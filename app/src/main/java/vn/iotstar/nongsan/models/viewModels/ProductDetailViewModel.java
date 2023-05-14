package vn.iotstar.nongsan.models.viewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import vn.iotstar.nongsan.models.ProductDetailModel;
import vn.iotstar.nongsan.repository.ProductDetailRepository;

public class ProductDetailViewModel extends ViewModel {
    private ProductDetailRepository productDetailRepository;

    public ProductDetailViewModel() {
        productDetailRepository = new ProductDetailRepository();
    }
    public MutableLiveData<ProductDetailModel> productDetailModelMutableLiveData(int id){
        return productDetailRepository.getProductDetailModel(id);
    }
}
