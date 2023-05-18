package vn.iotstar.nongsan.models.viewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import vn.iotstar.nongsan.models.CartModel;
import vn.iotstar.nongsan.models.LoginModel;
import vn.iotstar.nongsan.models.ProductDetail;
import vn.iotstar.nongsan.models.ProductModel;
import vn.iotstar.nongsan.repository.CartRepository;
import vn.iotstar.nongsan.repository.ProductDetailRepository;
import vn.iotstar.nongsan.repository.ProductRepository;

public class CartViewModel extends ViewModel {
    private CartRepository cartRepository;

    public CartViewModel() {
        cartRepository = new CartRepository();
    }


}
