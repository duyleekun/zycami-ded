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
package com.xiaomi.push.service;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.bb;

public class bd
implements ServiceConnection {
    public final /* synthetic */ bb a;

    public bd(bb bb2) {
        this.a = bb2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onServiceConnected(ComponentName object, IBinder object2) {
        object = this.a;
        synchronized (object) {
            bb bb2 = this.a;
            Object object3 = new Messenger((IBinder)object2);
            bb.a(bb2, object3);
            object2 = this.a;
            boolean bl2 = false;
            bb2 = null;
            bb.a((bb)object2, false);
            object2 = this.a;
            object2 = bb.a((bb)object2);
            object2 = object2.iterator();
            while (true) {
                if (!(bl2 = object2.hasNext())) {
                    object2 = this.a;
                    object2 = bb.a((bb)object2);
                    object2.clear();
                    return;
                }
                bb2 = object2.next();
                bb2 = (Message)bb2;
                try {
                    object3 = this.a;
                    object3 = bb.a((bb)object3);
                    object3.send((Message)bb2);
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
        bb.a(this.a, null);
        bb.a(this.a, false);
    }
}

