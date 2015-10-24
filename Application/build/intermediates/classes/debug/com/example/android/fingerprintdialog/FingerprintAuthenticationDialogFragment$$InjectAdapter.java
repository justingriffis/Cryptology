// Code generated by dagger-compiler.  Do not edit.
package com.example.android.fingerprintdialog;

import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

/**
 * A {@code Binding<FingerprintAuthenticationDialogFragment>} implementation which satisfies
 * Dagger's infrastructure requirements including:
 *
 * Owning the dependency links between {@code FingerprintAuthenticationDialogFragment} and its
 * dependencies.
 *
 * Being a {@code Provider<FingerprintAuthenticationDialogFragment>} and handling creation and
 * preparation of object instances.
 *
 * Being a {@code MembersInjector<FingerprintAuthenticationDialogFragment>} and handling injection
 * of annotated fields.
 */
public final class FingerprintAuthenticationDialogFragment$$InjectAdapter extends Binding<FingerprintAuthenticationDialogFragment>
    implements Provider<FingerprintAuthenticationDialogFragment>, MembersInjector<FingerprintAuthenticationDialogFragment> {
  private Binding<FingerprintUiHelper.FingerprintUiHelperBuilder> mFingerprintUiHelperBuilder;
  private Binding<android.view.inputmethod.InputMethodManager> mInputMethodManager;
  private Binding<android.content.SharedPreferences> mSharedPreferences;

  public FingerprintAuthenticationDialogFragment$$InjectAdapter() {
    super("com.example.android.fingerprintdialog.FingerprintAuthenticationDialogFragment", "members/com.example.android.fingerprintdialog.FingerprintAuthenticationDialogFragment", NOT_SINGLETON, FingerprintAuthenticationDialogFragment.class);
  }

  /**
   * Used internally to link bindings/providers together at run time
   * according to their dependency graph.
   */
  @Override
  @SuppressWarnings("unchecked")
  public void attach(Linker linker) {
    mFingerprintUiHelperBuilder = (Binding<FingerprintUiHelper.FingerprintUiHelperBuilder>) linker.requestBinding("com.example.android.fingerprintdialog.FingerprintUiHelper$FingerprintUiHelperBuilder", FingerprintAuthenticationDialogFragment.class, getClass().getClassLoader());
    mInputMethodManager = (Binding<android.view.inputmethod.InputMethodManager>) linker.requestBinding("android.view.inputmethod.InputMethodManager", FingerprintAuthenticationDialogFragment.class, getClass().getClassLoader());
    mSharedPreferences = (Binding<android.content.SharedPreferences>) linker.requestBinding("android.content.SharedPreferences", FingerprintAuthenticationDialogFragment.class, getClass().getClassLoader());
  }

  /**
   * Used internally obtain dependency information, such as for cyclical
   * graph detection.
   */
  @Override
  public void getDependencies(Set<Binding<?>> getBindings, Set<Binding<?>> injectMembersBindings) {
    injectMembersBindings.add(mFingerprintUiHelperBuilder);
    injectMembersBindings.add(mInputMethodManager);
    injectMembersBindings.add(mSharedPreferences);
  }

  /**
   * Returns the fully provisioned instance satisfying the contract for
   * {@code Provider<FingerprintAuthenticationDialogFragment>}.
   */
  @Override
  public FingerprintAuthenticationDialogFragment get() {
    FingerprintAuthenticationDialogFragment result = new FingerprintAuthenticationDialogFragment();
    injectMembers(result);
    return result;
  }

  /**
   * Injects any {@code @Inject} annotated fields in the given instance,
   * satisfying the contract for {@code Provider<FingerprintAuthenticationDialogFragment>}.
   */
  @Override
  public void injectMembers(FingerprintAuthenticationDialogFragment object) {
    object.mFingerprintUiHelperBuilder = mFingerprintUiHelperBuilder.get();
    object.mInputMethodManager = mInputMethodManager.get();
    object.mSharedPreferences = mSharedPreferences.get();
  }

}
