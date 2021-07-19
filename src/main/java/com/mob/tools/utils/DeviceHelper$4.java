/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.ServiceConnection
 *  android.os.IBinder
 */
package com.mob.tools.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.DeviceHelper;

public class DeviceHelper$4
implements ServiceConnection {
    public final /* synthetic */ DeviceHelper this$0;
    public final /* synthetic */ Context val$context;
    public final /* synthetic */ boolean[] val$result;

    public DeviceHelper$4(DeviceHelper deviceHelper, boolean[] blArray, Context context) {
        this.this$0 = deviceHelper;
        this.val$result = blArray;
        this.val$context = context;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onServiceConnected(ComponentName object, IBinder object2) {
        try {
            object = this.val$result;
            synchronized (object) {
            }
        }
        catch (Throwable throwable) {
            object2 = MobLog.getInstance();
            ((NLog)object2).d(throwable);
            return;
        }
        {
            object2 = this.val$result;
            boolean bl2 = true;
            object2[0] = (IBinder)bl2;
            object2.notifyAll();
            object2 = this.val$context;
            object2.unbindService((ServiceConnection)this);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onServiceDisconnected(ComponentName object) {
        try {
            object = this.val$result;
            synchronized (object) {
                boolean[] blArray = this.val$result;
                blArray.notifyAll();
            }
        }
        catch (Throwable throwable) {
            NLog nLog = MobLog.getInstance();
            nLog.d(throwable);
            return;
        }
    }
}

