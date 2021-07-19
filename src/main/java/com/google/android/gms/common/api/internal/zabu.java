/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.PendingIntent
 *  android.content.Context
 */
package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.api.internal.zal;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.CancellationException;

public class zabu
extends zal {
    private TaskCompletionSource zajp;

    private zabu(LifecycleFragment object) {
        super((LifecycleFragment)object);
        this.zajp = object = new TaskCompletionSource();
        this.mLifecycleFragment.addCallback("GmsAvailabilityHelper", this);
    }

    public static zabu zac(Activity object) {
        String string2;
        zabu zabu2 = (zabu)(object = LifecycleCallback.getFragment((Activity)object)).getCallbackOrNull(string2 = "GmsAvailabilityHelper", zabu.class);
        if (zabu2 != null) {
            object = zabu2.zajp.getTask();
            boolean bl2 = ((Task)object).isComplete();
            if (bl2) {
                zabu2.zajp = object = new TaskCompletionSource();
            }
            return zabu2;
        }
        zabu2 = new zabu((LifecycleFragment)object);
        return zabu2;
    }

    public final Task getTask() {
        return this.zajp.getTask();
    }

    public void onDestroy() {
        super.onDestroy();
        TaskCompletionSource taskCompletionSource = this.zajp;
        CancellationException cancellationException = new CancellationException("Host activity was destroyed before Google Play services could be made available.");
        taskCompletionSource.trySetException(cancellationException);
    }

    public final void zaa(ConnectionResult object, int n10) {
        TaskCompletionSource taskCompletionSource = this.zajp;
        int n11 = ((ConnectionResult)object).getErrorCode();
        String string2 = ((ConnectionResult)object).getErrorMessage();
        object = ((ConnectionResult)object).getResolution();
        Status status = new Status(n11, string2, (PendingIntent)object);
        object = ApiExceptionUtil.fromStatus(status);
        taskCompletionSource.setException((Exception)object);
    }

    public final void zao() {
        GoogleApiAvailability googleApiAvailability = this.zacd;
        Activity activity = this.mLifecycleFragment.getLifecycleActivity();
        int n10 = googleApiAvailability.isGooglePlayServicesAvailable((Context)activity);
        activity = null;
        if (n10 == 0) {
            this.zajp.setResult(null);
            return;
        }
        Object object = this.zajp.getTask();
        boolean bl2 = ((Task)object).isComplete();
        if (!bl2) {
            object = new ConnectionResult(n10, null);
            n10 = 0;
            googleApiAvailability = null;
            this.zab((ConnectionResult)object, 0);
        }
    }
}

