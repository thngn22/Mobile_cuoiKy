package vn.iotstar.nongsan.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import io.paperdb.Paper;
import vn.iotstar.nongsan.R;
import vn.iotstar.nongsan.adapters.CartAdapter;
import vn.iotstar.nongsan.adapters.CategoryAdapter;
import vn.iotstar.nongsan.databinding.ActivityCartBinding;
import vn.iotstar.nongsan.listener.ChangeNumberListener;
import vn.iotstar.nongsan.models.Cart;
import vn.iotstar.nongsan.models.CartModel;
import vn.iotstar.nongsan.models.ProductDetail;
import vn.iotstar.nongsan.models.viewModels.CartViewModel;
import vn.iotstar.nongsan.models.viewModels.ProductViewModel;
import vn.iotstar.nongsan.utils.UtilsCart;
import vn.iotstar.nongsan.utils.UtilsTokens;
import vn.iotstar.nongsan.utils.UtilsUser;

public class CartActivity extends AppCompatActivity {
    CartViewModel viewModel;
    ActivityCartBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_cart);
        initView();
        initData();
        totalPrice();

        binding.checkOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCheckout();
                Intent intent = new Intent(getApplicationContext(), OrderActivity.class);
                startActivity(intent);
            }
        });
    }

    private void onClickCheckout() {

    }

    private void initData() {
        List<Cart> cartList = Paper.book().read("cartList");
        UtilsCart.listCart = cartList;
        Log.d("logg", "[Cart Activity] co gio hang voi so luong: " + UtilsCart.listCart.size());

        CartAdapter adapter = new CartAdapter(this, UtilsCart.listCart, new ChangeNumberListener() {
            @Override
            public void change() {
                totalPrice();
            }
        });
        binding.rcCart.setAdapter(adapter);


    }

    private void totalPrice() {
        int item_count = 0;
        double price = 0.0;
        List<Cart> list = UtilsCart.listCart;
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                item_count = item_count + list.get(i).getQuantity();
                price = price + list.get(i).getQuantity() * list.get(i).getPrice();
            }
        }

        binding.txtItems.setText(item_count + " món");
        binding.txtTotal.setText(price + "đ");
    }

    private void initView() {
        binding.rcCart.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        binding.rcCart.setLayoutManager(layoutManager);
    }

}
