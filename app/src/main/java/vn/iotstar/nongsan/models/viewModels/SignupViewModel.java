package vn.iotstar.nongsan.models.viewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import vn.iotstar.nongsan.models.SignupModel;
import vn.iotstar.nongsan.repository.SignupRepository;

public class SignupViewModel extends ViewModel {
    private SignupRepository signupRepository;

    public SignupViewModel() {
        signupRepository = new SignupRepository();
    }

    public MutableLiveData<SignupModel> signupModelMutableLiveData(String name, String email, String password, String phone) {
        return signupRepository.getSignupModel(name, email, password, phone);
    }
}
