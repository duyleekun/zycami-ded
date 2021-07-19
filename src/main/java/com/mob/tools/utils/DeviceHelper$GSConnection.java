/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.ServiceConnection
 *  android.os.IBinder
 */
package com.mob.tools.utils;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.DeviceHelper$1;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class DeviceHelper$GSConnection
implements ServiceConnection {
    public boolean got = false;
    private final BlockingQueue iBinders;
    public final /* synthetic */ DeviceHelper this$0;

    private DeviceHelper$GSConnection(DeviceHelper linkedBlockingQueue) {
        this.this$0 = linkedBlockingQueue;
        this.iBinders = linkedBlockingQueue = new LinkedBlockingQueue();
    }

    public /* synthetic */ DeviceHelper$GSConnection(DeviceHelper deviceHelper, DeviceHelper$1 deviceHelper$1) {
        this(deviceHelper);
    }

    public void onServiceConnected(ComponentName object, IBinder object2) {
        object = this.iBinders;
        try {
            object.put(object2);
        }
        catch (Throwable throwable) {
            object2 = MobLog.getInstance();
            ((NLog)object2).w(throwable);
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }

    public IBinder takeBinder() {
        boolean bl2 = this.got;
        if (!bl2) {
            this.got = true;
            BlockingQueue blockingQueue = this.iBinders;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            return (IBinder)blockingQueue.poll(1500L, timeUnit);
        }
        IllegalStateException illegalStateException = new IllegalStateException();
        throw illegalStateException;
    }
}

