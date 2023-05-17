package vn.iotstar.nongsan.models.viewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import vn.iotstar.nongsan.activities.ProductActivity;
import vn.iotstar.nongsan.models.ProductDetailModel;
import vn.iotstar.nongsan.models.ProductModel;
import vn.iotstar.nongsan.repository.ProductRepository;

public class ProductViewModel extends ViewModel {
    private ProductRepository productRepository;

    public ProductViewModel() {
        productRepository = new ProductRepository();
    }
    public MutableLiveData<ProductModel> productModelMutableLiveData(){
        return productRepository.getProductByCategoryModel();
    }
}
