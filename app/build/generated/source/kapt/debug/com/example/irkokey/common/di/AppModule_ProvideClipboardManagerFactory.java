// Generated by Dagger (https://dagger.dev).
package com.example.irkokey.common.di;

import android.content.ClipboardManager;
import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class AppModule_ProvideClipboardManagerFactory implements Factory<ClipboardManager> {
  private final Provider<Context> contextProvider;

  public AppModule_ProvideClipboardManagerFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public ClipboardManager get() {
    return provideClipboardManager(contextProvider.get());
  }

  public static AppModule_ProvideClipboardManagerFactory create(Provider<Context> contextProvider) {
    return new AppModule_ProvideClipboardManagerFactory(contextProvider);
  }

  public static ClipboardManager provideClipboardManager(Context context) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideClipboardManager(context));
  }
}
