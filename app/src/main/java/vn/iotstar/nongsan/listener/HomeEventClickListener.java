package vn.iotstar.nongsan.listener;

import vn.iotstar.nongsan.models.Category;
import vn.iotstar.nongsan.models.Product;

public interface HomeEventClickListener {
    void onCategoryClick(Category category);
    void onPopularClick(Product product);

}
