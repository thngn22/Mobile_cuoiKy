package vn.iotstar.nongsan.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.iotstar.nongsan.models.CartModel;
import vn.iotstar.nongsan.models.Product;
import vn.iotstar.nongsan.models.ProductModel;
import vn.iotstar.nongsan.retrofit.NongSanAPI;
import vn.iotstar.nongsan.retrofit.RetrofitInstance;

public class CartRepository {
    private final NongSanAPI nongSanAPI;

    public CartRepository() {
        nongSanAPI = RetrofitInstance.getRetrofit().create(NongSanAPI.class);
    }

    public MutableLiveData<CartModel> getUpdateAddCart(String accessToken, String clientId, String refreshToken, String id, String name, String thumb, String description, int quantity, int price) {
        MutableLiveData<CartModel> data = new MutableLiveData<>();
        nongSanAPI.getUpdateAddCart(accessToken, clientId, refreshToken, id, name, thumb, description, quantity, price).enqueue(new Callback<CartModel>() {
            @Override
            public void onResponse(Call<CartModel> call, Response<CartModel> response) {
                if (response.isSuccessful()) {
                    data.setValue(response.body());
                    Log.d("logg", "co du lieu cart");
                } else {
                    Log.d("logg", "dell co du lieu tu cart");
                }

            }

            @Override
            public void onFailure(Call<CartModel> call, Throwable t) {
                Log.d("logg", "Lỗi đọc ở đây nè, retrofit bị lỗi cart");
                Log.d("logg", t.getMessage());
                data.setValue(null);
            }
        });
        return data;
    }
}
