package vn.iotstar.nongsan.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
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

    private void initData() {
        String searchName = getIntent().getStringExtra("searchName");
        String cateName = getIntent().getStringExtra("categoryName");
        boolean isValid = searchName != null ? true : false;
        Log.d("logg", String.valueOf(isValid));
        Log.d("logg", "searchName is +" + searchName);
        if (isValid) {
            initDataSearch(searchName);
        } else {
            initDataCate(cateName);
        }
    }

    private void initDataSearch(String searchName) {

        Log.d("logg", searchName);

        viewModel = new ViewModelProvider(this).get(CategoryViewModel.class);
        viewModel.searchModelMutableLiveData(searchName).observe(this, productModel -> {
            if (productModel.getStatus() == 200) {

                    ProductAdapter adapter = new ProductAdapter(productModel.getMetadata(), this);
                if (adapter.getItemCount() == 0) {
                    binding.tvCategoryName.setText("Không tìm thấy sản phẩm!");
                } else {
                    binding.tvCategoryName.setText("Số lượng sản phẩm có: *" + searchName + "* trong tên là: " + productModel.getMetadata().size() + " món");
                }
                binding.rcCategoryMain.setAdapter(adapter);
            } else {
                binding.tvCategoryName.setText("Không tìm thấy sản phẩm!");
            }
        });

    }

    private void initDataCate(String cateName) {

        Log.d("logg", cateName);

        int idCate = getIntent().getIntExtra("idCate", 2);
        String categoryName = getIntent().getStringExtra("cateName");
        viewModel = new ViewModelProvider(this).get(CategoryViewModel.class);
        viewModel.productModelMutableLiveData().observe(this, productModel -> {
            if (productModel.getStatus() == 200) {
                ProductAdapter adapter = new ProductAdapter(productModel.getMetadata(), this);
                binding.tvCategoryName.setText(cateName + ": " + productModel.getMetadata().size() + " món");
                binding.rcCategoryMain.setAdapter(adapter);
            }
        });

    }


    private void initView() {
        binding.rcCategoryMain.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        binding.rcCategoryMain.setLayoutManager(layoutManager);
    }

    @Override
    public void onProductClick(Product product) {
        Intent intent = new Intent(getApplicationContext(), ProductActivity.class);
        intent.putExtra("id", product.getId());
        startActivity(intent);
    }
}