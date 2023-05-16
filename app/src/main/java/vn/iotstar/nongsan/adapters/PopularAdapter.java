package vn.iotstar.nongsan.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import vn.iotstar.nongsan.R;
import vn.iotstar.nongsan.databinding.ItemPopularProductBinding;
import vn.iotstar.nongsan.listener.HomeEventClickListener;
import vn.iotstar.nongsan.models.Product;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.MyViewHolder> {
    private List<Product> listProduct;
    private HomeEventClickListener listener;

    public PopularAdapter(List<Product> listProduct, HomeEventClickListener listener) {
        this.listProduct = listProduct;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPopularProductBinding itemPopularProductBinding = ItemPopularProductBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MyViewHolder(itemPopularProductBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.setBinding(listProduct.get(position));
        Glide.with(holder.itemView).load(listProduct.get(position).getThumb())
                .placeholder(R.drawable.rricardo)
                .error(android.R.drawable.stat_notify_error)
                .into(holder.binding.imgPopular);
    }

    @Override
    public int getItemCount() {
        return listProduct == null ? 0 : listProduct.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ItemPopularProductBinding binding;

        public MyViewHolder(ItemPopularProductBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        private void setBinding(Product product) {
            binding.setPopular(product);
            binding.executePendingBindings();
            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onPopularClick(product);
                }
            });
        }
    }
}
