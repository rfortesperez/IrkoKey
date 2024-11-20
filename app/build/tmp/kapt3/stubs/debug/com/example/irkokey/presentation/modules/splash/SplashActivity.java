package com.example.irkokey.presentation.modules.splash;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import com.example.irkokey.R;
import com.example.irkokey.presentation.modules.auth.AuthActivity;
import com.example.irkokey.presentation.modules.register.RegisterActivity;
import dagger.hilt.android.AndroidEntryPoint;

@dagger.hilt.android.AndroidEntryPoint
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\u0017\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002\u00a2\u0006\u0002\u0010\u000eJ\u0012\u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0012"}, d2 = {"Lcom/example/irkokey/presentation/modules/splash/SplashActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "splashViewModel", "Lcom/example/irkokey/presentation/modules/splash/SplashViewModel;", "getSplashViewModel", "()Lcom/example/irkokey/presentation/modules/splash/SplashViewModel;", "splashViewModel$delegate", "Lkotlin/Lazy;", "initObservers", "", "navigateToDestination", "isLogged", "", "(Ljava/lang/Boolean;)V", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
@android.annotation.SuppressLint(value = {"CustomSplashScreen"})
public final class SplashActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy splashViewModel$delegate = null;
    
    public SplashActivity() {
        super();
    }
    
    private final com.example.irkokey.presentation.modules.splash.SplashViewModel getSplashViewModel() {
        return null;
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    /**
     * Initializes the observers for LiveData.
     */
    private final void initObservers() {
    }
    
    /**
     * Navigates to the appropriate activity based on the login status.
     * @param isLogged Boolean indicating if the user is logged in.
     */
    private final void navigateToDestination(java.lang.Boolean isLogged) {
    }
}