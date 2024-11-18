package com.example.irkokey.presentation.modules.register;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.irkokey.R;
import com.example.irkokey.databinding.ActivityRegisterBinding;
import com.example.irkokey.presentation.modules.main.MainActivity;
import dagger.hilt.android.AndroidEntryPoint;

@dagger.hilt.android.AndroidEntryPoint
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\u0012\u0010\u000e\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\b\u0010\u0011\u001a\u00020\fH\u0002J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0015"}, d2 = {"Lcom/example/irkokey/presentation/modules/register/RegisterActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/example/irkokey/databinding/ActivityRegisterBinding;", "registerViewModel", "Lcom/example/irkokey/presentation/modules/register/RegisterViewModel;", "getRegisterViewModel", "()Lcom/example/irkokey/presentation/modules/register/RegisterViewModel;", "registerViewModel$delegate", "Lkotlin/Lazy;", "navigateToMainActivity", "", "observeViewModel", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setupRegisterButton", "showToast", "message", "", "app_debug"})
public final class RegisterActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy registerViewModel$delegate = null;
    private com.example.irkokey.databinding.ActivityRegisterBinding binding;
    
    public RegisterActivity() {
        super();
    }
    
    private final com.example.irkokey.presentation.modules.register.RegisterViewModel getRegisterViewModel() {
        return null;
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    /**
     * Sets up the register button click listener.
     */
    private final void setupRegisterButton() {
    }
    
    /**
     * Observes the ViewModel LiveData and updates the UI accordingly.
     */
    private final void observeViewModel() {
    }
    
    /**
     * Shows a toast message.
     * @param message The message to be displayed.
     */
    private final void showToast(java.lang.String message) {
    }
    
    /**
     * Navigates to the MainActivity.
     */
    private final void navigateToMainActivity() {
    }
}