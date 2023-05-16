package vn.iotstar.nongsan.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import io.paperdb.Paper;
import vn.iotstar.nongsan.R;
import vn.iotstar.nongsan.databinding.ItemCartBinding;
import vn.iotstar.nongsan.listener.ChangeNumberListener;
import vn.iotstar.nongsan.models.Cart;
import vn.iotstar.nongsan.utils.UtilsCart;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.MyViewHolder> {
    private Context context;
    List<Cart> cartList;
    ChangeNumberListener listener;

    public CartAdapter(Context context, List<Cart> cartList, ChangeNumberListener listener) {
        this.context = context;
        this.cartList = cartList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCartBinding itemCartBinding = ItemCartBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MyViewHolder(itemCartBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Cart cart = cartList.get(position);
        holder.binding.txtNameProduct.setText(cart.getProductDetail().getMeal() + "");
        holder.binding.txtPrice.setText(cart.getProductDetail().getPrice() + "đ");
        Glide.with(context)
                .load(cart.getProductDetail().getStrMealThumb())
                .placeholder(R.drawable.rricardo)
                .error(android.R.drawable.stat_notify_error)
                .into(holder.binding.imageCart);
        holder.binding.imagePlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCart(holder.getAdapterPosition());
                notifyDataSetChanged();
                listener.change();
            }
        });
        holder.binding.imageSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subCart(holder.getAdapterPosition());
                notifyDataSetChanged();
                listener.change();
            }
        });
        holder.binding.txtAmount.setText(String.valueOf(cart.getAmount()));
        holder.binding.txtPriceSum.setText(cart.getAmount() * cart.getProductDetail().getPrice() + "đ");
    }

    private void subCart(int adapterPosition) {
        if (UtilsCart.listCart.get(adapterPosition).getAmount() == 1) {
            UtilsCart.listCart.remove(adapterPosition);
        } else {
            UtilsCart.listCart.get(adapterPosition).setAmount(UtilsCart.listCart.get(adapterPosition).getAmount() - 1);
        }
        Paper.book().write("cartList", UtilsCart.listCart);
    }

    private void addCart(int position) {
        UtilsCart.listCart.get(position).setAmount(UtilsCart.listCart.get(position).getAmount() + 1);
        Paper.book().write("cartList", UtilsCart.listCart);
    }

    @Override
    public int getItemCount() {
        return cartList == null ? 0 : cartList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ItemCartBinding binding;

        public MyViewHolder(ItemCartBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
