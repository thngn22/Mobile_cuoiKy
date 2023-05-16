package vn.iotstar.nongsan.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.adapters.SearchViewBindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import vn.iotstar.nongsan.R;
import vn.iotstar.nongsan.databinding.ItemCategoryBinding;
import vn.iotstar.nongsan.listener.HomeEventClickListener;
import vn.iotstar.nongsan.models.Category;
import vn.iotstar.nongsan.models.Product;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {
    private List<Category> list;
    private HomeEventClickListener listener;

    public CategoryAdapter(List<Category> list, HomeEventClickListener listener) {
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCategoryBinding itemCategoryBinding = ItemCategoryBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MyViewHolder(itemCategoryBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.setBinding(list.get(position));
        Glide.with(holder.itemView)
                .load(list.get(position).getCategoryThumb())
                .placeholder(R.drawable.rricardo)
                .error(android.R.drawable.stat_notify_error)
                .into(holder.binding.imgCate);
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ItemCategoryBinding binding;

        public MyViewHolder(ItemCategoryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void setBinding(Category category) {
            binding.setCategory(category);
            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onCategoryClick(category);
                }
            });

        }

    }
}
