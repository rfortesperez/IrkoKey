// Generated by Dagger (https://dagger.dev).
package com.example.irkokey.presentation.modules.login;

import com.example.irkokey.common.infraestructure.Preferences;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class LoginViewModel_Factory implements Factory<LoginViewModel> {
  private final Provider<Preferences> prefsProvider;

  public LoginViewModel_Factory(Provider<Preferences> prefsProvider) {
    this.prefsProvider = prefsProvider;
  }

  @Override
  public LoginViewModel get() {
    return newInstance(prefsProvider.get());
  }

  public static LoginViewModel_Factory create(Provider<Preferences> prefsProvider) {
    return new LoginViewModel_Factory(prefsProvider);
  }

  public static LoginViewModel newInstance(Preferences prefs) {
    return new LoginViewModel(prefs);
  }
}
