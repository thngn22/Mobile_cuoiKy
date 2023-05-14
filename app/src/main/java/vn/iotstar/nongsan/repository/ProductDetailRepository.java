package vn.iotstar.nongsan.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.iotstar.nongsan.models.ProductDetailModel;
import vn.iotstar.nongsan.retrofit.NongSanAPI;
import vn.iotstar.nongsan.retrofit.RetrofitInstance;

public class ProductDetailRepository {
    private NongSanAPI nongSanAPI;

    public ProductDetailRepository() {
        nongSanAPI = RetrofitInstance.getRetrofit().create(NongSanAPI.class);
    }
    public MutableLiveData<ProductDetailModel> getProductDetailModel(int id){
        MutableLiveData<ProductDetailModel> data = new MutableLiveData<>();
        nongSanAPI.getProductDetailModel(id).enqueue(new Callback<ProductDetailModel>() {
            @Override
            public void onResponse(Call<ProductDetailModel> call, Response<ProductDetailModel> response) {
                if (response.isSuccessful()) {
                    data.setValue(response.body());
                    Log.d("logg", "co du lieu category");
                } else {
                    Log.d("logg", "dell");
                }
            }

            @Override
            public void onFailure(Call<ProductDetailModel> call, Throwable t) {
                Log.d("logg", "Lỗi đọc ở đây nè, retrofit bị lỗi category");
                Log.d("logg", t.getMessage());
                data.setValue(null);
            }
        });
        return data;
    }
}
