/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.DeadObjectException
 *  android.os.RemoteException
 */
package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api$AnyClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleApiManager$zaa;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.zaab;
import com.google.android.gms.common.api.internal.zab;
import com.google.android.gms.common.api.internal.zac;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zag
extends zac {
    private final TaskCompletionSource zacn;
    private final TaskApiCall zacr;
    private final StatusExceptionMapper zacs;

    public zag(int n10, TaskApiCall taskApiCall, TaskCompletionSource taskCompletionSource, StatusExceptionMapper statusExceptionMapper) {
        super(n10);
        this.zacn = taskCompletionSource;
        this.zacr = taskApiCall;
        this.zacs = statusExceptionMapper;
    }

    public final void zaa(Status object) {
        TaskCompletionSource taskCompletionSource = this.zacn;
        object = this.zacs.getException((Status)object);
        taskCompletionSource.trySetException((Exception)object);
    }

    public final void zaa(GoogleApiManager$zaa object) {
        TaskApiCall taskApiCall = this.zacr;
        object = ((GoogleApiManager$zaa)object).zaab();
        TaskCompletionSource taskCompletionSource = this.zacn;
        try {
            taskApiCall.doExecute((Api$AnyClient)object, taskCompletionSource);
            return;
        }
        catch (RuntimeException runtimeException) {
            ((zab)this).zaa(runtimeException);
            return;
        }
        catch (RemoteException remoteException) {
            object = zab.zab(remoteException);
            ((zab)this).zaa((Status)object);
            return;
        }
        catch (DeadObjectException deadObjectException) {
            throw deadObjectException;
        }
    }

    public final void zaa(zaab zaab2, boolean bl2) {
        TaskCompletionSource taskCompletionSource = this.zacn;
        zaab2.zaa(taskCompletionSource, bl2);
    }

    public final void zaa(RuntimeException runtimeException) {
        this.zacn.trySetException(runtimeException);
    }

    public final Feature[] zab(GoogleApiManager$zaa googleApiManager$zaa) {
        return this.zacr.zabt();
    }

    public final boolean zac(GoogleApiManager$zaa googleApiManager$zaa) {
        return this.zacr.shouldAutoResolveMissingFeatures();
    }
}

