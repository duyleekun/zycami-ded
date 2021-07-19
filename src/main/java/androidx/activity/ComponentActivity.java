/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentSender
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 */
package androidx.activity;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.ComponentActivity$1;
import androidx.activity.ComponentActivity$2;
import androidx.activity.ComponentActivity$3;
import androidx.activity.ComponentActivity$NonConfigurationInstances;
import androidx.activity.ImmLeaksCleaner;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.contextaware.ContextAware;
import androidx.activity.contextaware.ContextAwareHelper;
import androidx.activity.contextaware.OnContextAvailableListener;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle$State;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ReportFragment;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider$Factory;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import androidx.tracing.Trace;
import java.util.concurrent.atomic.AtomicInteger;

public class ComponentActivity
extends androidx.core.app.ComponentActivity
implements ContextAware,
LifecycleOwner,
ViewModelStoreOwner,
HasDefaultViewModelProviderFactory,
SavedStateRegistryOwner,
OnBackPressedDispatcherOwner,
ActivityResultRegistryOwner,
ActivityResultCaller {
    private final ActivityResultRegistry mActivityResultRegistry;
    private int mContentLayoutId;
    public final ContextAwareHelper mContextAwareHelper;
    private ViewModelProvider$Factory mDefaultFactory;
    private final LifecycleRegistry mLifecycleRegistry;
    private final AtomicInteger mNextLocalRequestCode;
    private final OnBackPressedDispatcher mOnBackPressedDispatcher;
    public final SavedStateRegistryController mSavedStateRegistryController;
    private ViewModelStore mViewModelStore;

    public ComponentActivity() {
        Object object = new ContextAwareHelper();
        this.mContextAwareHelper = object;
        this.mLifecycleRegistry = object = new LifecycleRegistry(this);
        this.mSavedStateRegistryController = object = SavedStateRegistryController.create(this);
        Object object2 = new ComponentActivity$1(this);
        this.mOnBackPressedDispatcher = object = new OnBackPressedDispatcher((Runnable)object2);
        this.mNextLocalRequestCode = object = new AtomicInteger();
        this.mActivityResultRegistry = object = new ComponentActivity$2(this);
        object = this.getLifecycle();
        if (object != null) {
            LifecycleEventObserver lifecycleEventObserver;
            Lifecycle lifecycle;
            int n10 = Build.VERSION.SDK_INT;
            int n11 = 19;
            if (n10 >= n11) {
                lifecycle = this.getLifecycle();
                lifecycleEventObserver = new ComponentActivity$3(this);
                lifecycle.addObserver(lifecycleEventObserver);
            }
            lifecycle = this.getLifecycle();
            super(this);
            lifecycle.addObserver(lifecycleEventObserver);
            lifecycle = this.getLifecycle();
            super(this);
            lifecycle.addObserver(lifecycleEventObserver);
            if (n11 <= n10 && n10 <= (n11 = 23)) {
                object = this.getLifecycle();
                object2 = new ImmLeaksCleaner(this);
                ((Lifecycle)object).addObserver((LifecycleObserver)object2);
            }
            return;
        }
        object = new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
        throw object;
    }

    public ComponentActivity(int n10) {
        this();
        this.mContentLayoutId = n10;
    }

    public static /* synthetic */ void access$001(ComponentActivity componentActivity) {
        super.onBackPressed();
    }

    private void initViewTreeOwners() {
        ViewTreeLifecycleOwner.set(this.getWindow().getDecorView(), this);
        ViewTreeViewModelStoreOwner.set(this.getWindow().getDecorView(), this);
        ViewTreeSavedStateRegistryOwner.set(this.getWindow().getDecorView(), this);
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.initViewTreeOwners();
        super.addContentView(view, layoutParams);
    }

    public final void addOnContextAvailableListener(OnContextAvailableListener onContextAvailableListener) {
        this.mContextAwareHelper.addOnContextAvailableListener(onContextAvailableListener);
    }

    public void ensureViewModelStore() {
        Object object = this.mViewModelStore;
        if (object == null) {
            object = (ComponentActivity$NonConfigurationInstances)this.getLastNonConfigurationInstance();
            if (object != null) {
                this.mViewModelStore = object = ((ComponentActivity$NonConfigurationInstances)object).viewModelStore;
            }
            if ((object = this.mViewModelStore) == null) {
                this.mViewModelStore = object = new ViewModelStore();
            }
        }
    }

    public final ActivityResultRegistry getActivityResultRegistry() {
        return this.mActivityResultRegistry;
    }

    public ViewModelProvider$Factory getDefaultViewModelProviderFactory() {
        Object object = this.getApplication();
        if (object != null) {
            object = this.mDefaultFactory;
            if (object == null) {
                Application application = this.getApplication();
                Object object2 = this.getIntent();
                object2 = object2 != null ? this.getIntent().getExtras() : null;
                object = new SavedStateViewModelFactory(application, this, (Bundle)object2);
                this.mDefaultFactory = object;
            }
            return this.mDefaultFactory;
        }
        object = new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        throw object;
    }

    public Object getLastCustomNonConfigurationInstance() {
        Object object = (ComponentActivity$NonConfigurationInstances)this.getLastNonConfigurationInstance();
        object = object != null ? ((ComponentActivity$NonConfigurationInstances)object).custom : null;
        return object;
    }

    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.mOnBackPressedDispatcher;
    }

    public final SavedStateRegistry getSavedStateRegistry() {
        return this.mSavedStateRegistryController.getSavedStateRegistry();
    }

    public ViewModelStore getViewModelStore() {
        Object object = this.getApplication();
        if (object != null) {
            this.ensureViewModelStore();
            return this.mViewModelStore;
        }
        object = new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        throw object;
    }

    public void onActivityResult(int n10, int n11, Intent intent) {
        ActivityResultRegistry activityResultRegistry = this.mActivityResultRegistry;
        boolean bl2 = activityResultRegistry.dispatchResult(n10, n11, intent);
        if (!bl2) {
            super.onActivityResult(n10, n11, intent);
        }
    }

    public void onBackPressed() {
        this.mOnBackPressedDispatcher.onBackPressed();
    }

    public void onCreate(Bundle bundle) {
        this.mSavedStateRegistryController.performRestore(bundle);
        this.mContextAwareHelper.dispatchOnContextAvailable((Context)this);
        super.onCreate(bundle);
        ActivityResultRegistry activityResultRegistry = this.mActivityResultRegistry;
        activityResultRegistry.onRestoreInstanceState(bundle);
        ReportFragment.injectIfNeededIn(this);
        int n10 = this.mContentLayoutId;
        if (n10 != 0) {
            this.setContentView(n10);
        }
    }

    public void onRequestPermissionsResult(int n10, String[] stringArray, int[] nArray) {
        int n11;
        ActivityResultRegistry activityResultRegistry = this.mActivityResultRegistry;
        Intent intent = new Intent();
        intent = intent.putExtra("androidx.activity.result.contract.extra.PERMISSIONS", stringArray);
        int n12 = -1;
        String string2 = "androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS";
        int n13 = activityResultRegistry.dispatchResult(n10, n12, intent = intent.putExtra(string2, nArray));
        if (n13 == 0 && (n13 = Build.VERSION.SDK_INT) >= (n11 = 23)) {
            super.onRequestPermissionsResult(n10, stringArray, nArray);
        }
    }

    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    public final Object onRetainNonConfigurationInstance() {
        ComponentActivity$NonConfigurationInstances componentActivity$NonConfigurationInstances;
        Object object = this.onRetainCustomNonConfigurationInstance();
        ViewModelStore viewModelStore = this.mViewModelStore;
        if (viewModelStore == null && (componentActivity$NonConfigurationInstances = (ComponentActivity$NonConfigurationInstances)this.getLastNonConfigurationInstance()) != null) {
            viewModelStore = componentActivity$NonConfigurationInstances.viewModelStore;
        }
        if (viewModelStore == null && object == null) {
            return null;
        }
        componentActivity$NonConfigurationInstances = new ComponentActivity$NonConfigurationInstances();
        componentActivity$NonConfigurationInstances.custom = object;
        componentActivity$NonConfigurationInstances.viewModelStore = viewModelStore;
        return componentActivity$NonConfigurationInstances;
    }

    public void onSaveInstanceState(Bundle bundle) {
        Lifecycle lifecycle = this.getLifecycle();
        boolean bl2 = lifecycle instanceof LifecycleRegistry;
        if (bl2) {
            lifecycle = (LifecycleRegistry)lifecycle;
            Lifecycle$State lifecycle$State = Lifecycle$State.CREATED;
            ((LifecycleRegistry)lifecycle).setCurrentState(lifecycle$State);
        }
        super.onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.performSave(bundle);
        this.mActivityResultRegistry.onSaveInstanceState(bundle);
    }

    public Context peekAvailableContext() {
        return this.mContextAwareHelper.peekAvailableContext();
    }

    public final ActivityResultLauncher registerForActivityResult(ActivityResultContract activityResultContract, ActivityResultCallback activityResultCallback) {
        ActivityResultRegistry activityResultRegistry = this.mActivityResultRegistry;
        return this.registerForActivityResult(activityResultContract, activityResultRegistry, activityResultCallback);
    }

    public final ActivityResultLauncher registerForActivityResult(ActivityResultContract activityResultContract, ActivityResultRegistry activityResultRegistry, ActivityResultCallback activityResultCallback) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("activity_rq#");
        int n10 = this.mNextLocalRequestCode.getAndIncrement();
        charSequence.append(n10);
        charSequence = charSequence.toString();
        return activityResultRegistry.register((String)charSequence, this, activityResultContract, activityResultCallback);
    }

    public final void removeOnContextAvailableListener(OnContextAvailableListener onContextAvailableListener) {
        this.mContextAwareHelper.removeOnContextAvailableListener(onContextAvailableListener);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void reportFullyDrawn() {
        try {
            int n10;
            CharSequence charSequence;
            int n11 = Trace.isEnabled();
            if (n11 != 0) {
                charSequence = new StringBuilder();
                String string2 = "reportFullyDrawn() for ";
                ((StringBuilder)charSequence).append(string2);
                string2 = this.getComponentName();
                ((StringBuilder)charSequence).append((Object)string2);
                charSequence = ((StringBuilder)charSequence).toString();
                Trace.beginSection((String)charSequence);
            }
            if ((n11 = Build.VERSION.SDK_INT) > (n10 = 19)) {
                super.reportFullyDrawn();
                return;
            }
            if (n11 != n10) return;
            charSequence = "android.permission.UPDATE_DEVICE_STATS";
            n11 = ContextCompat.checkSelfPermission((Context)this, (String)charSequence);
            if (n11 != 0) return;
            super.reportFullyDrawn();
            return;
        }
        finally {
            Trace.endSection();
        }
    }

    public void setContentView(int n10) {
        this.initViewTreeOwners();
        super.setContentView(n10);
    }

    public void setContentView(View view) {
        this.initViewTreeOwners();
        super.setContentView(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.initViewTreeOwners();
        super.setContentView(view, layoutParams);
    }

    public void startActivityForResult(Intent intent, int n10) {
        super.startActivityForResult(intent, n10);
    }

    public void startActivityForResult(Intent intent, int n10, Bundle bundle) {
        super.startActivityForResult(intent, n10, bundle);
    }

    public void startIntentSenderForResult(IntentSender intentSender, int n10, Intent intent, int n11, int n12, int n13) {
        super.startIntentSenderForResult(intentSender, n10, intent, n11, n12, n13);
    }

    public void startIntentSenderForResult(IntentSender intentSender, int n10, Intent intent, int n11, int n12, int n13, Bundle bundle) {
        super.startIntentSenderForResult(intentSender, n10, intent, n11, n12, n13, bundle);
    }
}

