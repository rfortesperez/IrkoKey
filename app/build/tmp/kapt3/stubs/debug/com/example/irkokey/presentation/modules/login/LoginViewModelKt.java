package com.example.irkokey.presentation.modules.login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.irkokey.common.utils.EncryptionUtil;
import com.example.irkokey.data.repository.UserRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0002"}, d2 = {"PIN_LENGTH", "", "app_debug"})
public final class LoginViewModelKt {
    private static final int PIN_LENGTH = 6;
}