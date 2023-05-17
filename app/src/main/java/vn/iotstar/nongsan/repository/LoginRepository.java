package vn.iotstar.nongsan.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.iotstar.nongsan.models.LoginModel;
import vn.iotstar.nongsan.models.SignupModel;
import vn.iotstar.nongsan.retrofit.NongSanAPI;
import vn.iotstar.nongsan.retrofit.RetrofitInstance;

public class LoginRepository {
    private NongSanAPI nongSanAPI;

    public LoginRepository() {
        nongSanAPI = RetrofitInstance.getRetrofit().create(NongSanAPI.class);
    }

    public MutableLiveData<LoginModel> getLoginModel(String email, String password) {

        MutableLiveData<LoginModel> data = new MutableLiveData<>();
        nongSanAPI.getLoginModel(email, password).enqueue(new Callback<LoginModel>() {
            @Override
            public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                if (response.isSuccessful()) {
                    data.postValue(response.body());
                    Log.d("logg", "co du lieu Login account");

                } else {
                    Log.d("logg", "dell co user login");
                }
            }

            @Override
            public void onFailure(Call<LoginModel> call, Throwable t) {
                Log.d("logg", "Lỗi đọc ở đây nè, retrofit bị lỗi login");
                Log.d("logg", t.getMessage());
                data.setValue(null);
            }
        });
        return data;
        }
}
