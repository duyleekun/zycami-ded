/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.ServiceConnection
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.Message
 *  android.os.Messenger
 *  android.os.RemoteException
 */
package com.huawei.hms.opendevice;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.huawei.hms.opendevice.h;
import com.huawei.hms.support.log.HMSLog;

public class g
implements ServiceConnection {
    public final /* synthetic */ Bundle a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ h c;

    public g(h h10, Bundle bundle, Context context) {
        this.c = h10;
        this.a = bundle;
        this.b = context;
    }

    public void onServiceConnected(ComponentName object, IBinder object2) {
        object = "RemoteService";
        HMSLog.i((String)object, "remote service onConnected");
        h h10 = this.c;
        Messenger messenger = new Messenger(object2);
        h.a(h10, messenger);
        object2 = Message.obtain();
        h10 = this.a;
        object2.setData((Bundle)h10);
        h10 = this.c;
        h10 = h.a(h10);
        try {
            h10.send((Message)object2);
        }
        catch (RemoteException remoteException) {
            object2 = "remote service message send failed";
            HMSLog.i((String)object, (String)object2);
        }
        HMSLog.i((String)object, "remote service unbindservice");
        object = this.b;
        object2 = h.b(this.c);
        object.unbindService((ServiceConnection)object2);
    }

    public void onServiceDisconnected(ComponentName componentName) {
        HMSLog.i("RemoteService", "remote service onDisconnected");
        h.a(this.c, null);
    }
}

