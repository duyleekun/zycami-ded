/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.ServiceConnection
 *  android.os.IBinder
 *  android.os.Message
 *  android.os.Messenger
 *  android.os.RemoteException
 */
package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.mipush.sdk.aq;

public class at
implements ServiceConnection {
    public final /* synthetic */ aq a;

    public at(aq aq2) {
        this.a = aq2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onServiceConnected(ComponentName object, IBinder object2) {
        object = this.a;
        synchronized (object) {
            aq aq2 = this.a;
            Object object3 = new Messenger((IBinder)object2);
            aq.a(aq2, object3);
            object2 = this.a;
            boolean bl2 = false;
            aq2 = null;
            aq.a((aq)object2, false);
            object2 = this.a;
            object2 = aq.a((aq)object2);
            object2 = object2.iterator();
            while (true) {
                if (!(bl2 = object2.hasNext())) {
                    object2 = this.a;
                    object2 = aq.a((aq)object2);
                    object2.clear();
                    return;
                }
                aq2 = object2.next();
                aq2 = (Message)aq2;
                try {
                    object3 = this.a;
                    object3 = aq.a((aq)object3);
                    object3.send((Message)aq2);
                }
                catch (RemoteException remoteException) {
                    b.a(remoteException);
                    continue;
                }
                break;
            }
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        aq.a(this.a, null);
        aq.a(this.a, false);
    }
}

