package vn.iotstar.nongsan.models.viewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import vn.iotstar.nongsan.models.CartModel;
import vn.iotstar.nongsan.models.ProductDetailModel;
import vn.iotstar.nongsan.models.ProductModel;
import vn.iotstar.nongsan.repository.CartRepository;
import vn.iotstar.nongsan.repository.ProductDetailRepository;
import vn.iotstar.nongsan.repository.ProductRepository;

public class ProductViewModel extends ViewModel {
    private ProductDetailRepository productDetailRepository;
    private CartRepository cartRepository;

    public ProductViewModel() {
        productDetailRepository = new ProductDetailRepository();
        cartRepository = new CartRepository();
    }
    public MutableLiveData<ProductDetailModel> productDetailModelMutableLiveData(String productId){
        return productDetailRepository.getProductDetailModel(productId);
    }
    public MutableLiveData<CartModel> cartModelMutableLiveData(String id, String name, String thumb, String description, int quantity, int price, String accessToken, String clientId, String refreshToken){
        return cartRepository.getUpdateAddCart(id, name, thumb, description, quantity, price, accessToken, clientId, refreshToken);
    }

}
