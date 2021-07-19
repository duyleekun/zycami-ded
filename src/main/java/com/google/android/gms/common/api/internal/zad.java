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
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleApiManager$zaa;
import com.google.android.gms.common.api.internal.zaab;
import com.google.android.gms.common.api.internal.zab;
import com.google.android.gms.common.api.internal.zac;
import com.google.android.gms.tasks.TaskCompletionSource;

public abstract class zad
extends zac {
    public final TaskCompletionSource zacn;

    public zad(int n10, TaskCompletionSource taskCompletionSource) {
        super(n10);
        this.zacn = taskCompletionSource;
    }

    public void zaa(Status status) {
        TaskCompletionSource taskCompletionSource = this.zacn;
        ApiException apiException = new ApiException(status);
        taskCompletionSource.trySetException(apiException);
    }

    public final void zaa(GoogleApiManager$zaa object) {
        try {
            this.zad((GoogleApiManager$zaa)object);
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
            Status status = zab.zab((RemoteException)((Object)deadObjectException));
            ((zab)this).zaa(status);
            throw deadObjectException;
        }
    }

    public void zaa(zaab zaab2, boolean bl2) {
    }

    public void zaa(RuntimeException runtimeException) {
        this.zacn.trySetException(runtimeException);
    }

    public abstract void zad(GoogleApiManager$zaa var1);
}

