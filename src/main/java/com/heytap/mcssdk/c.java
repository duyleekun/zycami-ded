/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 */
package com.heytap.mcssdk;

import android.content.Context;
import android.content.Intent;
import com.heytap.mcssdk.c$1;
import com.heytap.mcssdk.f.f;
import d.i.a.a.b.b;

public class c {
    public static void a(Context context, Intent intent, b b10) {
        if (context == null) {
            com.heytap.mcssdk.f.c.e("context is null , please check param of parseIntent()");
            return;
        }
        if (intent == null) {
            com.heytap.mcssdk.f.c.e("intent is null , please check param of parseIntent()");
            return;
        }
        if (b10 == null) {
            com.heytap.mcssdk.f.c.e("callback is null , please check param of parseIntent()");
            return;
        }
        c$1 c$1 = new c$1(context, intent, b10);
        f.a(c$1);
    }
}

