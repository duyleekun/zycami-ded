/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.ServiceConnection
 *  android.os.IBinder
 */
package com.xiaomi.push;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.xiaomi.push.k;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class j$b
implements ServiceConnection {
    private final LinkedBlockingQueue a;
    public boolean a = false;

    private j$b() {
        LinkedBlockingQueue linkedBlockingQueue;
        this.a = linkedBlockingQueue = new LinkedBlockingQueue(1);
    }

    public /* synthetic */ j$b(k k10) {
        this();
    }

    public IBinder a() {
        boolean bl2 = this.a;
        if (!bl2) {
            this.a = true;
            LinkedBlockingQueue linkedBlockingQueue = this.a;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            return (IBinder)linkedBlockingQueue.poll(30000L, timeUnit);
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
            object = this.a;
        }
        catch (InterruptedException interruptedException) {
            return;
        }
        ((LinkedBlockingQueue)object).put(iBinder);
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }
}

