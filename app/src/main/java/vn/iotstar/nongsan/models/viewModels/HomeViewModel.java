package vn.iotstar.nongsan.models.viewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import vn.iotstar.nongsan.models.CartModel;
import vn.iotstar.nongsan.models.CategoryModel;
import vn.iotstar.nongsan.models.Product;
import vn.iotstar.nongsan.models.ProductModel;
import vn.iotstar.nongsan.repository.CartRepository;
import vn.iotstar.nongsan.repository.CategoryRepository;
import vn.iotstar.nongsan.repository.ProductRepository;

public class HomeViewModel extends ViewModel {
    private CategoryRepository categoryRepository;
    private ProductRepository productRepository;
    private CartRepository cartRepository;

    public HomeViewModel() {
        categoryRepository = new CategoryRepository();
        productRepository = new ProductRepository();
        cartRepository = new CartRepository();
    }

    public MutableLiveData<CategoryModel> categoryModelMutableLiveData() {
        return categoryRepository.getCategoryModel();
    }
    public MutableLiveData<ProductModel> productModelMutableLiveData(){
        return productRepository.getProductModel();
    }
    public MutableLiveData<CartModel> getListCart(String accessToken, String clientId, String refreshToken){
        return cartRepository.getListCart(accessToken, clientId, refreshToken);
    }

}
