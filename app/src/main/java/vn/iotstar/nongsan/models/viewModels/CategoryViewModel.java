package vn.iotstar.nongsan.models.viewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import vn.iotstar.nongsan.models.ProductModel;
import vn.iotstar.nongsan.repository.ProductRepository;

public class CategoryViewModel extends ViewModel {
    private ProductRepository productRepository;

    public CategoryViewModel() {
        productRepository = new ProductRepository();
    }
    public MutableLiveData<ProductModel> productModelMutableLiveData(String categoryId, String accessToken, String clientId, String refreshToken){
        return productRepository.getProductByCategoryModel(categoryId, accessToken, clientId, refreshToken);
    }
    public MutableLiveData<ProductModel> searchModelMutableLiveData(String searchName){
        return productRepository.getSearchModel(searchName);
    }

}
