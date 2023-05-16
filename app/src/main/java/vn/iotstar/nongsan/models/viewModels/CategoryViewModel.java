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
    public MutableLiveData<ProductModel> productModelMutableLiveData(){
        return productRepository.getProductModel();
    }
    public MutableLiveData<ProductModel> searchModelMutableLiveData(String searchName){
        return productRepository.getSearchModel(searchName);
    }

}
