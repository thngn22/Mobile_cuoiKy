package vn.iotstar.nongsan.models.viewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import vn.iotstar.nongsan.models.CartModel;
import vn.iotstar.nongsan.models.LoginModel;
import vn.iotstar.nongsan.models.ProductDetail;
import vn.iotstar.nongsan.models.ProductModel;
import vn.iotstar.nongsan.repository.CartRepository;
import vn.iotstar.nongsan.repository.OrderRepository;
import vn.iotstar.nongsan.repository.ProductDetailRepository;
import vn.iotstar.nongsan.repository.ProductRepository;

public class CartViewModel extends ViewModel {
    private OrderRepository orderRepository;

    public CartViewModel() {
        orderRepository = new OrderRepository();
    }
//    public MutableLiveData<CartModel> cartModelMutableLiveData(String accessToken, String clientId, String refreshToken, String id, String name, String thumb, String description, int quantity, int price){
//        return orderRepository.getUpdateAddCart(accessToken, clientId, refreshToken, id, name, thumb, description, quantity, price);
//    }
}
