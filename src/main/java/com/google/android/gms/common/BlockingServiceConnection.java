/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.ServiceConnection
 *  android.os.IBinder
 */
package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class BlockingServiceConnection
implements ServiceConnection {
    private boolean zza = false;
    private final BlockingQueue zzb;

    public BlockingServiceConnection() {
        LinkedBlockingQueue linkedBlockingQueue;
        this.zzb = linkedBlockingQueue = new LinkedBlockingQueue();
    }

    public IBinder getService() {
        Object object = "BlockingServiceConnection.getService() called on main thread";
        Preconditions.checkNotMainThread((String)object);
        boolean bl2 = this.zza;
        if (!bl2) {
            this.zza = true;
            return (IBinder)this.zzb.take();
        }
        object = new IllegalStateException("Cannot call get on this connection more than once");
        throw object;
    }

    public IBinder getServiceWithTimeout(long l10, TimeUnit timeUnit) {
        Object object = "BlockingServiceConnection.getServiceWithTimeout() called on main thread";
        Preconditions.checkNotMainThread((String)object);
        boolean bl2 = this.zza;
        if (!bl2) {
            this.zza = bl2 = true;
            object = this.zzb;
            Object object2 = (IBinder)object.poll(l10, timeUnit);
            if (object2 != null) {
                return object2;
            }
            object2 = new TimeoutException("Timed out waiting for the service connection");
            throw object2;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Cannot call get on this connection more than once");
        throw illegalStateException;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.zzb.add(iBinder);
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }
}

