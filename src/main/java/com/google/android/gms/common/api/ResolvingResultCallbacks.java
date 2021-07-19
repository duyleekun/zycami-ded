/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.IntentSender$SendIntentException
 *  android.util.Log
 */
package com.google.android.gms.common.api;

import android.app.Activity;
import android.content.IntentSender;
import android.util.Log;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallbacks;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;

public abstract class ResolvingResultCallbacks
extends ResultCallbacks {
    private final Activity zza;
    private final int zzb;

    public ResolvingResultCallbacks(Activity activity, int n10) {
        this.zza = activity = (Activity)Preconditions.checkNotNull(activity, "Activity must not be null");
        this.zzb = n10;
    }

    public final void onFailure(Status status) {
        boolean bl2 = status.hasResolution();
        if (bl2) {
            Activity activity;
            try {
                activity = this.zza;
            }
            catch (IntentSender.SendIntentException sendIntentException) {
                Log.e((String)"ResolvingResultCallback", (String)"Failed to start resolution", (Throwable)sendIntentException);
                Status status2 = new Status(8);
                this.onUnresolvableFailure(status2);
                return;
            }
            int n10 = this.zzb;
            status.startResolutionForResult(activity, n10);
            return;
        }
        this.onUnresolvableFailure(status);
    }

    public abstract void onSuccess(Result var1);

    public abstract void onUnresolvableFailure(Status var1);
}

