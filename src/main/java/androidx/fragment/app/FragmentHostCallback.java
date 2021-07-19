/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentSender
 *  android.os.Bundle
 *  android.os.Handler
 *  android.view.LayoutInflater
 *  android.view.View
 */
package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.util.Preconditions;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentContainer;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentManagerImpl;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class FragmentHostCallback
extends FragmentContainer {
    private final Activity mActivity;
    private final Context mContext;
    public final FragmentManager mFragmentManager;
    private final Handler mHandler;
    private final int mWindowAnimations;

    public FragmentHostCallback(Activity activity, Context context, Handler handler, int n10) {
        FragmentManagerImpl fragmentManagerImpl = new FragmentManagerImpl();
        this.mFragmentManager = fragmentManagerImpl;
        this.mActivity = activity;
        activity = (Context)Preconditions.checkNotNull(context, "context == null");
        this.mContext = activity;
        activity = (Handler)Preconditions.checkNotNull(handler, "handler == null");
        this.mHandler = activity;
        this.mWindowAnimations = n10;
    }

    public FragmentHostCallback(Context context, Handler handler, int n10) {
        Context context2;
        boolean bl2 = context instanceof Activity;
        if (bl2) {
            context2 = context;
            context2 = (Activity)context;
        } else {
            bl2 = false;
            context2 = null;
        }
        this((Activity)context2, context, handler, n10);
    }

    public FragmentHostCallback(FragmentActivity fragmentActivity) {
        Handler handler = new Handler();
        this(fragmentActivity, (Context)fragmentActivity, handler, 0);
    }

    public Activity getActivity() {
        return this.mActivity;
    }

    public Context getContext() {
        return this.mContext;
    }

    public Handler getHandler() {
        return this.mHandler;
    }

    public void onDump(String string2, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] stringArray) {
    }

    public View onFindViewById(int n10) {
        return null;
    }

    public abstract Object onGetHost();

    public LayoutInflater onGetLayoutInflater() {
        return LayoutInflater.from((Context)this.mContext);
    }

    public int onGetWindowAnimations() {
        return this.mWindowAnimations;
    }

    public boolean onHasView() {
        return true;
    }

    public boolean onHasWindowAnimations() {
        return true;
    }

    public void onRequestPermissionsFromFragment(Fragment fragment, String[] stringArray, int n10) {
    }

    public boolean onShouldSaveFragmentState(Fragment fragment) {
        return true;
    }

    public boolean onShouldShowRequestPermissionRationale(String string2) {
        return false;
    }

    public void onStartActivityFromFragment(Fragment fragment, Intent intent, int n10) {
        this.onStartActivityFromFragment(fragment, intent, n10, null);
    }

    public void onStartActivityFromFragment(Fragment object, Intent intent, int n10, Bundle bundle) {
        int n11 = -1;
        if (n10 == n11) {
            ContextCompat.startActivity(this.mContext, intent, bundle);
            return;
        }
        object = new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        throw object;
    }

    public void onStartIntentSenderFromFragment(Fragment fragment, IntentSender intentSender, int n10, Intent intent, int n11, int n12, int n13, Bundle bundle) {
        int n14 = -1;
        if (n10 == n14) {
            ActivityCompat.startIntentSenderForResult(this.mActivity, intentSender, n10, intent, n11, n12, n13, bundle);
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
        throw illegalStateException;
    }

    public void onSupportInvalidateOptionsMenu() {
    }
}

