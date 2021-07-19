/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  android.os.Bundle
 *  android.os.Messenger
 */
package com.huawei.hms.push;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Messenger;
import com.huawei.hms.push.g;
import com.huawei.hms.support.log.HMSLog;

public class h {
    public ServiceConnection a;
    public Messenger b = null;

    public static /* synthetic */ Messenger a(h h10) {
        return h10.b;
    }

    public static /* synthetic */ Messenger a(h h10, Messenger messenger) {
        h10.b = messenger;
        return messenger;
    }

    public static /* synthetic */ ServiceConnection b(h h10) {
        return h10.a;
    }

    public boolean a(Context context, Bundle bundle, Intent intent) {
        context = context.getApplicationContext();
        g g10 = new g(this, bundle, context);
        this.a = g10;
        HMSLog.i("RemoteService", "remote service bind service start");
        bundle = this.a;
        return context.bindService(intent, (ServiceConnection)bundle, 1);
    }
}

