/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.Window
 */
package androidx.fragment.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentHostCallback;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentOnAttachListener;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class FragmentActivity$HostCallbacks
extends FragmentHostCallback
implements ViewModelStoreOwner,
OnBackPressedDispatcherOwner,
ActivityResultRegistryOwner,
FragmentOnAttachListener {
    public final /* synthetic */ FragmentActivity this$0;

    public FragmentActivity$HostCallbacks(FragmentActivity fragmentActivity) {
        this.this$0 = fragmentActivity;
        super(fragmentActivity);
    }

    public ActivityResultRegistry getActivityResultRegistry() {
        return this.this$0.getActivityResultRegistry();
    }

    public Lifecycle getLifecycle() {
        return this.this$0.mFragmentLifecycleRegistry;
    }

    public OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.this$0.getOnBackPressedDispatcher();
    }

    public ViewModelStore getViewModelStore() {
        return this.this$0.getViewModelStore();
    }

    public void onAttachFragment(FragmentManager fragmentManager, Fragment fragment) {
        this.this$0.onAttachFragment(fragment);
    }

    public void onDump(String string2, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] stringArray) {
        this.this$0.dump(string2, fileDescriptor, printWriter, stringArray);
    }

    public View onFindViewById(int n10) {
        return this.this$0.findViewById(n10);
    }

    public FragmentActivity onGetHost() {
        return this.this$0;
    }

    public LayoutInflater onGetLayoutInflater() {
        LayoutInflater layoutInflater = this.this$0.getLayoutInflater();
        FragmentActivity fragmentActivity = this.this$0;
        return layoutInflater.cloneInContext((Context)fragmentActivity);
    }

    public int onGetWindowAnimations() {
        int n10;
        Window window = this.this$0.getWindow();
        if (window == null) {
            n10 = 0;
            window = null;
        } else {
            window = window.getAttributes();
            n10 = window.windowAnimations;
        }
        return n10;
    }

    public boolean onHasView() {
        boolean bl2;
        Window window = this.this$0.getWindow();
        if (window != null && (window = window.peekDecorView()) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            window = null;
        }
        return bl2;
    }

    public boolean onHasWindowAnimations() {
        boolean bl2;
        Window window = this.this$0.getWindow();
        if (window != null) {
            bl2 = true;
        } else {
            bl2 = false;
            window = null;
        }
        return bl2;
    }

    public boolean onShouldSaveFragmentState(Fragment fragment) {
        return this.this$0.isFinishing() ^ true;
    }

    public boolean onShouldShowRequestPermissionRationale(String string2) {
        return ActivityCompat.shouldShowRequestPermissionRationale(this.this$0, string2);
    }

    public void onSupportInvalidateOptionsMenu() {
        this.this$0.supportInvalidateOptionsMenu();
    }
}

