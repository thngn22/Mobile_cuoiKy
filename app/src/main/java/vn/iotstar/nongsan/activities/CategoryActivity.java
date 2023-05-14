package vn.iotstar.nongsan.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.Objects;

import vn.iotstar.nongsan.R;
import vn.iotstar.nongsan.adapters.ProductAdapter;
import vn.iotstar.nongsan.databinding.ActivityCategoryBinding;
import vn.iotstar.nongsan.databinding.ActivityProductBinding;
import vn.iotstar.nongsan.listener.CategoryEventClickListener;
import vn.iotstar.nongsan.models.Product;
import vn.iotstar.nongsan.models.viewModels.CategoryViewModel;

public class CategoryActivity extends AppCompatActivity implements CategoryEventClickListener {
    ActivityCategoryBinding binding;
    CategoryViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_category);
        initView();
        initData();
    }

    private void initData(){
        String cateName = getIntent().getStringExtra("categoryName");
        int idCate = getIntent().getIntExtra("idCate", 1);
        viewModel = new ViewModelProvider(this).get(CategoryViewModel.class);
        viewModel.productModelMutableLiveData(idCate).observe(this, productModel -> {
            if (productModel.isSuccess()){
                ProductAdapter adapter = new ProductAdapter(productModel.getResult(), this);
                binding.tvCategoryName.setText(cateName + ": " + productModel.getResult().size() + " món");
                binding.rcCategoryMain.setAdapter(adapter);
            }
        });
    }
    private void initView(){
        binding.rcCategoryMain.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        binding.rcCategoryMain.setLayoutManager(layoutManager);
    }

    @Override
    public void onProductClick(Product product) {
        Intent intent = new Intent(getApplicationContext(), ProductActivity.class);
        intent.putExtra("id", product.getIdMeal());
        startActivity(intent);
    }
}