/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 */
package com.baidu.location.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.location.LocationClient;
import com.baidu.location.d.a;
import java.util.ArrayList;

public class a$a
extends BroadcastReceiver {
    public final /* synthetic */ a a;

    public a$a(a a10) {
        this.a = a10;
    }

    public void onReceive(Context object, Intent intent) {
        boolean bl2;
        object = com.baidu.location.d.a.a(this.a);
        if (object != null && !(bl2 = ((ArrayList)(object = com.baidu.location.d.a.a(this.a))).isEmpty())) {
            object = com.baidu.location.d.a.b(this.a);
            ((LocationClient)object).requestNotifyLocation();
        }
    }
}

