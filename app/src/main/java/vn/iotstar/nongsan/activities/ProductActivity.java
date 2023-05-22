package vn.iotstar.nongsan.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import io.paperdb.Paper;
import vn.iotstar.nongsan.R;
import vn.iotstar.nongsan.databinding.ActivityProductBinding;
import vn.iotstar.nongsan.models.Cart;
import vn.iotstar.nongsan.models.Product;
import vn.iotstar.nongsan.models.ProductDetail;
import vn.iotstar.nongsan.models.ProductDetailModel;
import vn.iotstar.nongsan.models.viewModels.ProductViewModel;
import vn.iotstar.nongsan.utils.UtilsCart;
import vn.iotstar.nongsan.utils.UtilsTokens;
import vn.iotstar.nongsan.utils.UtilsUser;

public class ProductActivity extends AppCompatActivity {
    ProductViewModel viewModel;
    ActivityProductBinding binding;
    ProductDetail product;
    int amount = 1;
    int price = 1;
    String id, name, thumb, description;
    int quantity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_product);
        Paper.init(this);
        String id = getIntent().getStringExtra("id");
        Log.d("logg", id);
        getData(id);
        showData(id);
        onClickListener();

    }

    private void showData(String id) {
        if (Paper.book().read("cartList") != null) {
            List<Cart> cartList = Paper.book().read("cartList");
            UtilsCart.listCart = cartList;
        }


        if (UtilsCart.listCart.size() > 0) {
            for (int i = 0; i < UtilsCart.listCart.size(); i++) {
                if (UtilsCart.listCart.get(i).getId() == id) {
                    binding.txtProductAmount.setText(UtilsCart.listCart.get(i).getQuantity() + "");
                }
            }
        } else {
            binding.txtProductAmount.setText(amount + "");
        }
    }

    private void getData(String id) {

        viewModel = new ViewModelProvider(this).get(ProductViewModel.class);
        viewModel.productDetailModelMutableLiveData(id).observe(this, productDetailModel -> {
            Log.d("logg", productDetailModel.getMetadata().toString());
            ProductDetail productDetail = productDetailModel.getMetadata();
            Log.d("logg", productDetail.getId());
            binding.txtNameFood.setText(productDetail.getName());
            binding.txtDesc.setText(productDetail.getDescription());
            binding.txtPrice.setText(productDetail.getPrice() + "đ");
            price = Integer.parseInt(binding.txtPrice.getText().toString().split("đ")[0]);

            this.id = productDetail.getId();
            name = productDetail.getName();
            thumb = productDetail.getThumb();
            description = productDetail.getDescription();
            quantity = productDetail.getQuantity();
            price = productDetail.getPrice();

            //price = binding.txtPrice.getText();
            Glide.with(this)
                    .load(productDetail.getThumb())
                    .placeholder(R.drawable.rricardo)
                    .error(android.R.drawable.stat_notify_error)
                    .into(binding.imageProduct);

        });

    }

    private void onClickListener() {
        binding.addBtnProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amount = Integer.parseInt(binding.txtProductAmount.getText().toString()) + 1;
                binding.txtProductAmount.setText(String.valueOf(amount));
                binding.txtPrice.setText((price * amount) + "đ");
            }
        });
        binding.subBtnProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amount = Integer.parseInt(binding.txtProductAmount.getText().toString());
                if (amount > 1) {
                    amount = amount - 1;
                    binding.txtProductAmount.setText(String.valueOf(amount));
                    binding.txtPrice.setText((price * amount) + "đ");
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
                    binding.txtPrice.setText((price * amount) + "đ");
                    return true;
                }

                return false;
            }
        });

        //Add to cart
        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToCart();

            }
        });
    }

    private void addToCart() {
        Paper.book().write("cartList", UtilsCart.listCart);
        List<Cart> cartList = UtilsCart.listCart;
        for (int i = 0; i < cartList.size(); i++) {
            if (cartList.get(i).getProductId() == id) {
                cartList.add(cartList.get(i));
                UtilsCart.listCart = cartList;
                Log.d("logg", "đã lấy dc product có id = " + cartList.get(i).getProductId());
                Toast.makeText(getApplicationContext(), "Added to your Cart", Toast.LENGTH_SHORT).show();
                break;
            }
            Log.d("logg", "du lieu trong cart gom: " + cartList.get(i).getProductId());

        }
        viewModel = new ViewModelProvider(this).get(ProductViewModel.class);

        String accessToken =  UtilsTokens.tokens.getAccessToken();
        String clientId = UtilsUser.user.getId();
        String refreshToken = UtilsTokens.tokens.getRefreshToken();

        Log.d("logg", "accessToken:" + accessToken);
        Log.d("logg", "clientId: " + clientId);
        Log.d("logg", "refreshToken" + refreshToken);

        viewModel.cartModelMutableLiveData(accessToken, clientId, refreshToken, id, name, thumb, description, quantity, price).observe(this, cartModel -> {
            if (cartModel.getStatus() == 200) {
                Log.d("logg", "có giỏ hàng" + cartModel.getMetadata().size());

                UtilsCart.listCart = cartModel.getMetadata();

                Toast.makeText(getApplicationContext(), "Added to your Cart", Toast.LENGTH_SHORT).show();
            } else {
                Log.d("logg", "không có giỏ hàng");
                Toast.makeText(getApplicationContext(), "Chưa add dc cart", Toast.LENGTH_SHORT).show();
            }
        });
        Paper.book().write("cartList", UtilsCart.listCart);

    }
}
