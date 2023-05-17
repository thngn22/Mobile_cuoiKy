package vn.iotstar.nongsan.repository;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.iotstar.nongsan.activities.SignupActivity;
import vn.iotstar.nongsan.models.ProductModel;
import vn.iotstar.nongsan.models.SignupModel;
import vn.iotstar.nongsan.models.viewModels.SignupViewModel;
import vn.iotstar.nongsan.retrofit.NongSanAPI;
import vn.iotstar.nongsan.retrofit.RetrofitInstance;

public class SignupRepository{
    private NongSanAPI nongSanAPI;

    public SignupRepository() {
        nongSanAPI = RetrofitInstance.getRetrofit().create(NongSanAPI.class);
    }

    public MutableLiveData<SignupModel> getSignupModel(String name, String email, String password, String phone) {

        MutableLiveData<SignupModel> data = new MutableLiveData<>();
        nongSanAPI.getSignupModel(name, email, password, phone).enqueue(new Callback<SignupModel>() {
            @Override
            public void onResponse(Call<SignupModel> call, Response<SignupModel> response) {
                if (response.isSuccessful()) {
                    data.setValue(response.body());
                    Log.d("logg", "co du lieu Sign Up account");

                } else {

                    Log.d("logg", "dell co user");
                }
            }

            @Override
            public void onFailure(Call<SignupModel> call, Throwable t) {
                Log.d("logg", "Lỗi đọc ở đây nè, retrofit bị lỗi signup");
                Log.d("logg", t.getMessage());
                data.setValue(null);
            }
        });
        return data;
    }
}
