package vn.iotstar.nongsan.activities;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;

import java.lang.reflect.Type;

import vn.iotstar.nongsan.R;
import vn.iotstar.nongsan.databinding.ActivityProductBinding;
import vn.iotstar.nongsan.models.ProductDetail;
import vn.iotstar.nongsan.models.viewModels.ProductDetailViewModel;

public class ProductActivity extends AppCompatActivity {
    ProductDetailViewModel viewModel;
    ActivityProductBinding binding;
    int amount = 1;
    double price = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_product);
        getData();
        onClickListener();
    }

    private void getData() {
        int id = getIntent().getIntExtra("id", 0);
        viewModel = new ViewModelProvider(this).get(ProductDetailViewModel.class);
        viewModel.productDetailModelMutableLiveData(id).observe(this, productDetailModel -> {
            if (productDetailModel.isSuccess()) {
                ProductDetail productDetail = productDetailModel.getResult().get(0);
                binding.txtNameFood.setText(productDetail.getMeal());
                binding.txtDesc.setText(productDetail.getInstructions());
                binding.txtPrice.setText(productDetail.getPrice() + " VND");
                price = productDetail.getPrice();
                Glide.with(this)
                        .load(productDetail.getStrMealThumb())
                        .placeholder(R.drawable.rricardo)
                        .error(android.R.drawable.stat_notify_error)
                        .into(binding.imageProduct);
            }
        });
    }

    private void onClickListener() {
        binding.addBtnProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amount = Integer.parseInt(binding.txtProductAmount.getText().toString()) + 1;
                binding.txtProductAmount.setText(String.valueOf(amount));
                binding.txtPrice.setText((price * amount) + " VND");
            }
        });
        binding.subBtnProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amount = Integer.parseInt(binding.txtProductAmount.getText().toString());
                if (amount > 1) {
                    amount = amount - 1;
                    binding.txtProductAmount.setText(String.valueOf(amount));
                    binding.txtPrice.setText((price * amount) + " VND");
                }
            }
        });

        binding.txtProductAmount.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                    try {
                        amount = Integer.parseInt(binding.txtProductAmount.getText().toString());
                        if (amount <= 0) {
                            amount = 1;
                        }
                    } catch (Exception exception) {
                        amount = 1;
                    }
                    binding.txtProductAmount.setText(String.valueOf(amount));
                    binding.txtPrice.setText((price * amount) + " VND");
                    return true;
                }

                return false;
            }
        });
    }
}
