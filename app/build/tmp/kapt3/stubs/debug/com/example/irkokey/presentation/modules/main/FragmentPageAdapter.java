package com.example.irkokey.presentation.modules.main;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.example.irkokey.presentation.modules.createPassword.CreateFragment;
import com.example.irkokey.presentation.modules.passwords.PasswordsFragment;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\n"}, d2 = {"Lcom/example/irkokey/presentation/modules/main/FragmentPageAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "fragmentActivity", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;)V", "createFragment", "Landroidx/fragment/app/Fragment;", "position", "", "getItemCount", "app_debug"})
public final class FragmentPageAdapter extends androidx.viewpager2.adapter.FragmentStateAdapter {
    
    public FragmentPageAdapter(@org.jetbrains.annotations.NotNull
    androidx.fragment.app.FragmentActivity fragmentActivity) {
        super(null);
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public androidx.fragment.app.Fragment createFragment(int position) {
        return null;
    }
}