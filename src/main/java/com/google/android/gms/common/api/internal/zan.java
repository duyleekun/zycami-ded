/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Dialog
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.content.DialogInterface$OnCancelListener
 *  android.content.Intent
 */
package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.api.internal.zal;
import com.google.android.gms.common.api.internal.zam;
import com.google.android.gms.common.api.internal.zao;

public final class zan
implements Runnable {
    private final zam zadj;
    public final /* synthetic */ zal zadk;

    public zan(zal zal2, zam zam2) {
        this.zadk = zal2;
        this.zadj = zam2;
    }

    public final void run() {
        Object object = this.zadk;
        boolean bl2 = ((zal)object).mStarted;
        if (!bl2) {
            return;
        }
        object = this.zadj.getConnectionResult();
        boolean n10 = ((ConnectionResult)object).hasResolution();
        if (n10) {
            zal zal2 = this.zadk;
            LifecycleFragment googleApiAvailability = zal2.mLifecycleFragment;
            zal2 = zal2.getActivity();
            object = ((ConnectionResult)object).getResolution();
            int n11 = this.zadj.zar();
            object = GoogleApiActivity.zaa((Context)zal2, (PendingIntent)object, n11, false);
            googleApiAvailability.startActivityForResult((Intent)object, 1);
            return;
        }
        Object object2 = this.zadk.zacd;
        int n12 = ((ConnectionResult)object).getErrorCode();
        boolean bl3 = ((GoogleApiAvailability)object2).isUserResolvableError(n12);
        if (bl3) {
            object2 = this.zadk;
            GoogleApiAvailability googleApiAvailability = ((zal)object2).zacd;
            Activity activity = ((LifecycleCallback)object2).getActivity();
            LifecycleFragment lifecycleFragment = this.zadk.mLifecycleFragment;
            int n13 = ((ConnectionResult)object).getErrorCode();
            zal zal3 = this.zadk;
            googleApiAvailability.zaa(activity, lifecycleFragment, n13, 2, zal3);
            return;
        }
        int n14 = ((ConnectionResult)object).getErrorCode();
        if (n14 == (n12 = 18)) {
            object = this.zadk.getActivity();
            object2 = this.zadk;
            object = GoogleApiAvailability.zaa((Activity)object, (DialogInterface.OnCancelListener)object2);
            object2 = this.zadk;
            GoogleApiAvailability googleApiAvailability = ((zal)object2).zacd;
            object2 = ((LifecycleCallback)object2).getActivity().getApplicationContext();
            zao zao2 = new zao(this, (Dialog)object);
            googleApiAvailability.zaa((Context)object2, zao2);
            return;
        }
        object2 = this.zadk;
        n12 = this.zadj.zar();
        ((zal)object2).zaa((ConnectionResult)object, n12);
    }
}

