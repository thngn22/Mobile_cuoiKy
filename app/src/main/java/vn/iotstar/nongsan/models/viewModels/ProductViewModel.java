package vn.iotstar.nongsan.models.viewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import vn.iotstar.nongsan.models.ProductDetailModel;
import vn.iotstar.nongsan.repository.ProductDetailRepository;

public class ProductViewModel extends ViewModel {
    private ProductDetailRepository productDetailRepository;

    public ProductViewModel() {
        productDetailRepository = new ProductDetailRepository();
    }
    public MutableLiveData<ProductDetailModel> productDetailModelMutableLiveData(){
        return productDetailRepository.getProductDetailModel();
    }
}
