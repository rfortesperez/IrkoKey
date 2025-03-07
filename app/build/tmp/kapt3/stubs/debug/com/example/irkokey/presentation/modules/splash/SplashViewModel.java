package com.example.irkokey.presentation.modules.splash;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.irkokey.common.infraestructure.Preferences;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

/**
 * ViewModel for the SplashActivity.
 * Handles the logic for determining if the user is logged in.
 *
 * @property prefs Preferences instance for accessing stored user data.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\u0007H\u0002J\u0006\u0010\u000b\u001a\u00020\fR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068F\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/example/irkokey/presentation/modules/splash/SplashViewModel;", "Landroidx/lifecycle/ViewModel;", "prefs", "Lcom/example/irkokey/common/infraestructure/Preferences;", "(Lcom/example/irkokey/common/infraestructure/Preferences;)V", "_isLogged", "Landroidx/lifecycle/MutableLiveData;", "", "isLogged", "()Landroidx/lifecycle/MutableLiveData;", "checkUserLoggedIn", "initFlow", "", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class SplashViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.irkokey.common.infraestructure.Preferences prefs = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _isLogged = null;
    
    @javax.inject.Inject
    public SplashViewModel(@org.jetbrains.annotations.NotNull
    com.example.irkokey.common.infraestructure.Preferences prefs) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> isLogged() {
        return null;
    }
    
    /**
     * Initializes the flow by checking the user's login status after a delay.
     */
    public final void initFlow() {
    }
    
    /**
     * Checks if the user is logged in by verifying the presence of an email in preferences.
     *
     * @return True if the user is logged in, false otherwise.
     */
    private final boolean checkUserLoggedIn() {
        return false;
    }
}