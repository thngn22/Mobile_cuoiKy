package vn.iotstar.nongsan.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import vn.iotstar.nongsan.R;
import vn.iotstar.nongsan.databinding.ItemProductBinding;
import vn.iotstar.nongsan.listener.CategoryEventClickListener;
import vn.iotstar.nongsan.models.Product;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {
    private List<Product> productList;
    private CategoryEventClickListener listener;
    public ProductAdapter(List<Product> productList, CategoryEventClickListener listener){
        this.productList = productList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemProductBinding itemProductBinding = ItemProductBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MyViewHolder(itemProductBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.setBinding(productList.get(position));
        Glide.with(holder.itemView)
                .load(productList.get(position).getStrMealThumb())
                .placeholder(R.drawable.rricardo)
                .error(android.R.drawable.stat_notify_error)
                .into(holder.binding.imgCategoryMain);
    }



    @Override
    public int getItemCount() {
        return productList == null ? 0 : productList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private ItemProductBinding binding;
        public MyViewHolder(ItemProductBinding binding){
            super(binding.getRoot());
            this.binding = binding;

        }
        private void setBinding(Product product){
            binding.setProduct(product);
            binding.executePendingBindings();
            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onProductClick(product);
                }
            });
        }
    }
}
