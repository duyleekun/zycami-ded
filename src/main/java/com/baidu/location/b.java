/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.ServiceConnection
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.Message
 *  android.os.Messenger
 *  android.util.Log
 */
package com.baidu.location;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClient$a;
import com.baidu.location.LocationClientOption;

public class b
implements ServiceConnection {
    public final /* synthetic */ LocationClient a;

    public b(LocationClient locationClient) {
        this.a = locationClient;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onServiceConnected(ComponentName object, IBinder iBinder) {
        void var2_18;
        LocationClient locationClient = this.a;
        Messenger messenger = new Messenger((IBinder)var2_18);
        LocationClient.a(locationClient, messenger);
        Messenger messenger2 = LocationClient.a(this.a);
        if (messenger2 == null) {
            return;
        }
        LocationClient locationClient2 = this.a;
        int n10 = 1;
        LocationClient.a(locationClient2, n10 != 0);
        String string2 = "baidu location connected ...";
        Log.d((String)"baidu_location_client", (String)string2);
        LocationClient locationClient3 = this.a;
        boolean bl2 = LocationClient.b(locationClient3);
        if (bl2) {
            LocationClient$a locationClient$a = LocationClient.c(this.a);
            n10 = 2;
            Message message = locationClient$a.obtainMessage(n10);
            message.sendToTarget();
            return;
        }
        bl2 = false;
        Object var1_8 = null;
        int n11 = 11;
        try {
            Messenger messenger3;
            Message message = Message.obtain(null, (int)n11);
            LocationClient locationClient4 = this.a;
            message.replyTo = messenger3 = LocationClient.d(locationClient4);
            LocationClient locationClient5 = this.a;
            Bundle bundle = LocationClient.e(locationClient5);
            message.setData(bundle);
            LocationClient locationClient6 = this.a;
            Messenger messenger4 = LocationClient.a(locationClient6);
            messenger4.send(message);
            LocationClient locationClient7 = this.a;
            LocationClient.a(locationClient7, n10 != 0);
            LocationClient locationClient8 = this.a;
            LocationClientOption locationClientOption = LocationClient.f(locationClient8);
            if (locationClientOption == null) return;
            LocationClient locationClient9 = this.a;
            Boolean bl3 = LocationClient.g(locationClient9);
            bl3.booleanValue();
            LocationClient locationClient10 = this.a;
            LocationClient$a locationClient$a = LocationClient.c(locationClient10);
            n10 = 4;
            Message message2 = locationClient$a.obtainMessage(n10);
            message2.sendToTarget();
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        LocationClient.a(this.a, null);
        LocationClient.a(this.a, false);
    }
}

