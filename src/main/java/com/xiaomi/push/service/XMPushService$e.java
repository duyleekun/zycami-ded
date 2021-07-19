/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 */
package com.xiaomi.push.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.push.service.XMPushService;

public class XMPushService$e
extends BroadcastReceiver {
    public final /* synthetic */ XMPushService a;

    public XMPushService$e(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    public void onReceive(Context object, Intent intent) {
        object = this.a;
        int n10 = XMPushService.a;
        ((XMPushService)object).onStart(intent, n10);
    }
}

