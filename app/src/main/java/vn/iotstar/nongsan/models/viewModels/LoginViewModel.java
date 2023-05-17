package vn.iotstar.nongsan.models.viewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import vn.iotstar.nongsan.models.LoginModel;
import vn.iotstar.nongsan.models.SignupModel;
import vn.iotstar.nongsan.repository.LoginRepository;
import vn.iotstar.nongsan.repository.SignupRepository;

public class LoginViewModel extends ViewModel {
    private LoginRepository loginRepository;

    public LoginViewModel() {
        loginRepository = new LoginRepository();
    }

    public MutableLiveData<LoginModel> loginModelMutableLiveData(String email, String password) {
        return loginRepository.getLoginModel(email, password);
    }
}
