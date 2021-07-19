/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  android.os.Bundle
 *  android.os.IBinder
 */
package com.heytap.mcssdk;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import com.heytap.mcssdk.d;
import com.heytap.mcssdk.f.c;
import com.mcs.aidl.IMcsSdkService$Stub;

public class d$1
implements ServiceConnection {
    public final /* synthetic */ Intent a;
    public final /* synthetic */ d b;

    public d$1(d d10, Intent intent) {
        this.b = d10;
        this.a = intent;
    }

    public void onServiceConnected(ComponentName componentName, IBinder object) {
        componentName = new Bundle();
        Object object2 = this.a.getExtras();
        componentName.putAll(object2);
        object = IMcsSdkService$Stub.asInterface((IBinder)object);
        try {
            object.process((Bundle)componentName);
        }
        catch (Exception exception) {
            object = new StringBuilder();
            object2 = "bindMcsService exception:";
            ((StringBuilder)object).append((String)object2);
            ((StringBuilder)object).append(exception);
            String string2 = ((StringBuilder)object).toString();
            c.b(string2);
        }
        d.a(this.b).unbindService((ServiceConnection)this);
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }
}

