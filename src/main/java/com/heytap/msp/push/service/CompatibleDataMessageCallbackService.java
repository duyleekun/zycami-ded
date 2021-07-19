/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Service
 *  android.content.Context
 *  android.content.Intent
 *  android.os.IBinder
 */
package com.heytap.msp.push.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.heytap.mcssdk.c;
import d.i.a.a.b.b;

public class CompatibleDataMessageCallbackService
extends Service
implements b {
    public void a(Context context, d.i.a.a.c.b b10) {
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public final int onStartCommand(Intent intent, int n10, int n11) {
        c.a(this.getApplicationContext(), intent, this);
        return 2;
    }
}

