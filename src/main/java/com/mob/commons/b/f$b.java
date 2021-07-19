/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.ServiceConnection
 *  android.os.IBinder
 */
package com.mob.commons.b;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.mob.commons.b.f;
import com.mob.commons.b.f$1;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class f$b
implements ServiceConnection {
    public boolean a = false;
    public final /* synthetic */ f b;
    private final BlockingQueue c;

    private f$b(f linkedBlockingQueue) {
        this.b = linkedBlockingQueue;
        this.c = linkedBlockingQueue = new LinkedBlockingQueue();
    }

    public /* synthetic */ f$b(f f10, f$1 f$1) {
        this(f10);
    }

    public IBinder a(long l10) {
        boolean bl2 = this.a;
        if (!bl2) {
            this.a = bl2 = true;
            BlockingQueue blockingQueue = this.c;
            long l11 = 0L;
            long l12 = l10 - l11;
            Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object <= 0) {
                l10 = 1500L;
            }
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            return (IBinder)blockingQueue.poll(l10, timeUnit);
        }
        IllegalStateException illegalStateException = new IllegalStateException();
        throw illegalStateException;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void onServiceConnected(ComponentName object, IBinder iBinder) {
        try {
            object = this.c;
        }
        catch (Throwable throwable) {
            return;
        }
        object.put(iBinder);
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }
}

