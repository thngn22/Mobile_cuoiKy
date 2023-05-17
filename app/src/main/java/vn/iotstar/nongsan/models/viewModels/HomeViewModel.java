package vn.iotstar.nongsan.models.viewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import vn.iotstar.nongsan.models.CategoryModel;
import vn.iotstar.nongsan.models.Product;
import vn.iotstar.nongsan.models.ProductModel;
import vn.iotstar.nongsan.repository.CategoryRepository;
import vn.iotstar.nongsan.repository.ProductRepository;

public class HomeViewModel extends ViewModel {
    private CategoryRepository categoryRepository;
    private ProductRepository productRepository;

    public HomeViewModel() {
        categoryRepository = new CategoryRepository();
        productRepository = new ProductRepository();
    }

    public MutableLiveData<CategoryModel> categoryModelMutableLiveData() {
        return categoryRepository.getCategoryModel();
    }
    public MutableLiveData<ProductModel> productModelMutableLiveData(String categoryid){
        return productRepository.getProductByCategoryModel(categoryid);
    }

}
