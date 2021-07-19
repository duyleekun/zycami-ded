/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 */
package com.xiaomi.mipush.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.mipush.sdk.PushMessageHandler;

public class PushServiceReceiver
extends BroadcastReceiver {
    public void onReceive(Context context, Intent object) {
        Intent intent = new Intent(context, PushMessageHandler.class);
        intent.putExtras(object);
        object = object.getAction();
        intent.setAction((String)object);
        PushMessageHandler.a(context, intent);
    }
}

