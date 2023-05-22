package vn.iotstar.nongsan.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

//import io.paperdb.Paper;
import java.util.ArrayList;
import java.util.List;

import io.paperdb.Paper;
import vn.iotstar.nongsan.R;
import vn.iotstar.nongsan.adapters.CategoryAdapter;
import vn.iotstar.nongsan.adapters.PopularAdapter;
import vn.iotstar.nongsan.databinding.ActivityHomeBinding;
import vn.iotstar.nongsan.listener.HomeEventClickListener;
import vn.iotstar.nongsan.models.Cart;
import vn.iotstar.nongsan.models.Category;
import vn.iotstar.nongsan.models.Product;
import vn.iotstar.nongsan.models.viewModels.CartViewModel;
import vn.iotstar.nongsan.models.viewModels.HomeViewModel;
import vn.iotstar.nongsan.models.viewModels.ProductViewModel;
import vn.iotstar.nongsan.utils.UtilsCart;
import vn.iotstar.nongsan.utils.UtilsTokens;
import vn.iotstar.nongsan.utils.UtilsUser;

public class HomeActivity extends AppCompatActivity implements HomeEventClickListener {
    HomeViewModel homeViewModel;
    ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        Paper.init(this);
        initView();
        initData();

        binding.avt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                startActivity(intent);
                finish();
            }
        });
        binding.orderMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onCartClick();

            }
        });
        binding.search.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    // Perform action on key press
                    onSearchClick(binding.search.getText().toString());
                    return true;
                }

                return false;
            }
        });

        binding.tvhi.setText("Welcome back " + UtilsUser.user.getName());
    }

    private void initData() {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        homeViewModel.categoryModelMutableLiveData().observe(this, categoryModel -> {
            if (categoryModel.getStatus() == 200) {
                CategoryAdapter adapter = new CategoryAdapter(categoryModel.getMetadata(), this);
                binding.rcCategory.setAdapter(adapter);
//            Toast.makeText(HomeActivity.this, "Đã lấy dc", Toast.LENGTH_SHORT).show();
                Log.d("logg", (String.valueOf(adapter.getItemCount())));
            }
        });
        homeViewModel.productModelMutableLiveData().observe(this, productModel -> {
            if (productModel.getStatus() == 200) {
                PopularAdapter adapter = new PopularAdapter(productModel.getMetadata(), this);
                binding.rcPopular.setAdapter(adapter);
                Log.d("logg", (String.valueOf(adapter.getItemCount())));
            }
        });
        //Paper.book().write("token", UtilsTokens.tokens);
    }

    private void initView() {
        binding.rcCategory.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManagerCategory = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        binding.rcCategory.setLayoutManager(layoutManagerCategory);

        binding.rcPopular.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManagerPopular = new GridLayoutManager(this, 3);
        binding.rcPopular.setLayoutManager(layoutManagerPopular);


    }

    private void onCartClick() {

        Intent intent = new Intent(getApplicationContext(), CartActivity.class);

        String accessToken = UtilsTokens.tokens.getAccessToken();
        String clientId = UtilsUser.user.getId();
        String refreshToken = UtilsTokens.tokens.getRefreshToken();
        homeViewModel.getListCart(accessToken, clientId, refreshToken).observe(this, cartModel -> {
            if (cartModel.getStatus() == 200) {
                Log.d("logg", "[Home Activity] có giỏ hàng metadata voi so luong: " + cartModel.getMetadata().size());
                UtilsCart.listCart = cartModel.getMetadata();
                for (int i = 0; i < cartModel.getMetadata().size(); i++) {
                    Log.d("logg", "so luong" + cartModel.getMetadata().get(i).getName() + " : " + cartModel.getMetadata().get(i).getQuantity());
                }



                Log.d("logg", "[Home Activity] có giỏ hàng Utils.Cart voi so luong: " + UtilsCart.listCart.size());
                for (int i = 0; i < UtilsCart.listCart.size(); i++) {
                    Log.d("logg", "so luong" + UtilsCart.listCart.get(i).getName() + " : " + UtilsCart.listCart.get(i).getQuantity());
                }


            } else {
                Log.d("logg", "[Home Activity] không có giỏ hàng");
                Toast.makeText(getApplicationContext(), "Chưa add dc cart", Toast.LENGTH_SHORT).show();
            }
        });
        Paper.book().write("cartList", UtilsCart.listCart);
        startActivity(intent);
    }

    @Override
    public void onCategoryClick(Category category) {
        Intent intent = new Intent(getApplicationContext(), CategoryActivity.class);
        intent.putExtra("categoryId", category.getId());
        intent.putExtra("categoryName", category.getName());
        startActivity(intent);
    }

    @Override
    public void onPopularClick(Product product) {
        Intent intent = new Intent(HomeActivity.this, ProductActivity.class);
        intent.putExtra("id", product.getId());
        startActivity(intent);
    }

    @Override
    public void onSearchClick(String searchName) {
        Intent intent = new Intent(getApplicationContext(), CategoryActivity.class);
        intent.putExtra("searchName", searchName);
        startActivity(intent);
    }

}