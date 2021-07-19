/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.ContextWrapper
 *  android.content.Intent
 *  android.os.Bundle
 */
package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.api.internal.LifecycleActivity;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.api.internal.zzb;
import com.google.android.gms.common.api.internal.zzc;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class LifecycleCallback {
    public final LifecycleFragment mLifecycleFragment;

    public LifecycleCallback(LifecycleFragment lifecycleFragment) {
        this.mLifecycleFragment = lifecycleFragment;
    }

    private static LifecycleFragment getChimeraLifecycleFragmentImpl(LifecycleActivity object) {
        object = new IllegalStateException("Method not available in SDK.");
        throw object;
    }

    public static LifecycleFragment getFragment(Activity activity) {
        LifecycleActivity lifecycleActivity = new LifecycleActivity(activity);
        return LifecycleCallback.getFragment(lifecycleActivity);
    }

    public static LifecycleFragment getFragment(ContextWrapper object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public static LifecycleFragment getFragment(LifecycleActivity object) {
        boolean bl2 = ((LifecycleActivity)object).isSupport();
        if (bl2) {
            return zzc.zza(((LifecycleActivity)object).asFragmentActivity());
        }
        bl2 = ((LifecycleActivity)object).zza();
        if (bl2) {
            return zzb.zza(((LifecycleActivity)object).asActivity());
        }
        object = new IllegalArgumentException("Can't get fragment for unexpected activity.");
        throw object;
    }

    public void dump(String string2, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] stringArray) {
    }

    public Activity getActivity() {
        return this.mLifecycleFragment.getLifecycleActivity();
    }

    public void onActivityResult(int n10, int n11, Intent intent) {
    }

    public void onCreate(Bundle bundle) {
    }

    public void onDestroy() {
    }

    public void onResume() {
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onStart() {
    }

    public void onStop() {
    }
}

