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
import android.view.View;
import android.widget.GridLayout;

import vn.iotstar.nongsan.R;
import vn.iotstar.nongsan.adapters.CategoryAdapter;
import vn.iotstar.nongsan.adapters.PopularAdapter;
import vn.iotstar.nongsan.databinding.ActivityHomeBinding;
import vn.iotstar.nongsan.listener.HomeEventClickListener;
import vn.iotstar.nongsan.models.Category;
import vn.iotstar.nongsan.models.Product;
import vn.iotstar.nongsan.models.viewModels.HomeViewModel;

public class HomeActivity extends AppCompatActivity implements HomeEventClickListener {
    HomeViewModel homeViewModel;
    ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        initView();
        initData();

    }

    private void initData() {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        homeViewModel.categoryModelMutableLiveData().observe(this, categoryModel -> {
            if (categoryModel.isSuccess()) {
                CategoryAdapter adapter = new CategoryAdapter(categoryModel.getResult(), this);
                binding.rcCategory.setAdapter(adapter);
//            Toast.makeText(HomeActivity.this, "Đã lấy dc", Toast.LENGTH_SHORT).show();
                Log.d("logg", (String.valueOf(adapter.getItemCount())));
            }
        });
        homeViewModel.productModelMutableLiveData(1).observe(this, productModel -> {
            if (productModel.isSuccess()) {
                PopularAdapter adapter = new PopularAdapter(productModel.getResult(), this);
                binding.rcPopular.setAdapter(adapter);
                Log.d("logg", (String.valueOf(adapter.getItemCount())));
            }
        });
    }

    private void initView() {
        binding.rcCategory.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManagerCategory = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        binding.rcCategory.setLayoutManager(layoutManagerCategory);

        binding.rcPopular.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManagerPopular = new GridLayoutManager(this, 3);
        binding.rcPopular.setLayoutManager(layoutManagerPopular);

        binding.orderMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CartActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onCategoryClick(Category category) {
        Intent intent = new Intent(getApplicationContext(), CategoryActivity.class);
        intent.putExtra("idCate", category.getId());
        intent.putExtra("categoryName", category.getCategory());
        startActivity(intent);
    }

    @Override
    public void onPopularClick(Product product) {
        Intent intent = new Intent(getApplicationContext(), ProductActivity.class);
        intent.putExtra("id", product.getIdMeal());
        startActivity(intent);
    }
}