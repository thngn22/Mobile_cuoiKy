package vn.iotstar.nongsan.activities;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;

import java.util.List;

import io.paperdb.Paper;
import vn.iotstar.nongsan.R;
import vn.iotstar.nongsan.databinding.ActivityProductBinding;
import vn.iotstar.nongsan.models.Cart;
import vn.iotstar.nongsan.models.Product;
import vn.iotstar.nongsan.models.ProductDetail;
import vn.iotstar.nongsan.models.viewModels.ProductViewModel;
import vn.iotstar.nongsan.utils.UtilsCart;

public class ProductActivity extends AppCompatActivity {
    ProductViewModel viewModel;
    ActivityProductBinding binding;
    Product product;
    int amount = 1;
    double price = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_product);
        Paper.init(this);
        int id = getIntent().getIntExtra("id", 0);
        getData();
        onClickListener();
        showData(id);
    }

    private void showData(int id) {
        if (Paper.book().read("cartList") != null){
            List<Cart> cartList = Paper.book().read("cartList");
            UtilsCart.listCart = cartList;
        }


        if (UtilsCart.listCart.size() > 0) {
            for (int i = 0; i < UtilsCart.listCart.size(); i++) {
                if (UtilsCart.listCart.get(i).getProductDetail().getId() == id) {
                    binding.txtProductAmount.setText(UtilsCart.listCart.get(i).getAmount() + "");
                }
            }
        } else {
            binding.txtProductAmount.setText(amount + "");
        }
    }

    private void getData() {
//        String id =  getIntent().getStringExtra("id");
//        viewModel = new ViewModelProvider(this).get(ProductViewModel.class);
//        product
//        product.getCategory()
//                binding.txtNameFood.setText(productDetail.getMeal());
//                binding.txtDesc.setText(productDetail.getInstructions());
//                binding.txtPrice.setText(productDetail.getPrice() + "đ");
//                price = productDetail.getPrice();
//                Glide.with(this)
//                        .load(productDetail.getStrMealThumb())
//                        .placeholder(R.drawable.rricardo)
//                        .error(android.R.drawable.stat_notify_error)
//                        .into(binding.imageProduct);

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
                addToCart(amount);
            }
        });
    }

    private void addToCart(int amount) {
        boolean checkExist = false;
        int index = 0;
        if (UtilsCart.listCart.size() > 0) {
            for (int i = 0; i < UtilsCart.listCart.size(); i++) {
//                if (UtilsCart.listCart.get(i).getProductDetail().getId() == productDetail.getId()) {
//                    checkExist = true;
//                    index = i;
//                    break;
//                }
            }
        }
        if (checkExist) {
            UtilsCart.listCart.get(index).setAmount(amount);
        } else {
            Cart cart = new Cart();
         //   cart.setProductDetail(productDetail);
            cart.setAmount(amount);
            UtilsCart.listCart.add(cart);
        }
        Toast.makeText(getApplicationContext(), "Added to your Cart", Toast.LENGTH_SHORT).show();
        Paper.book().write("cartList", UtilsCart.listCart);
    }
}
