/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.graphics.Bitmap
 */
package com.zhiyun.cama.push;

import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import com.zhiyun.cama.push.CustomPushReceiver;
import d.v.l.f;

public class CustomPushReceiver$a
extends f {
    public final /* synthetic */ Context b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ int f;
    public final /* synthetic */ String g;
    public final /* synthetic */ PendingIntent h;
    public final /* synthetic */ CustomPushReceiver i;

    public CustomPushReceiver$a(CustomPushReceiver customPushReceiver, Context context, String string2, String string3, String string4, int n10, String string5, PendingIntent pendingIntent) {
        this.i = customPushReceiver;
        this.b = context;
        this.c = string2;
        this.d = string3;
        this.e = string4;
        this.f = n10;
        this.g = string5;
        this.h = pendingIntent;
    }

    public void b() {
    }

    public void e(Bitmap bitmap) {
        CustomPushReceiver customPushReceiver = this.i;
        Context context = this.b;
        String string2 = this.c;
        String string3 = this.d;
        String string4 = this.e;
        int n10 = this.f;
        String string5 = this.g;
        PendingIntent pendingIntent = this.h;
        CustomPushReceiver.a(customPushReceiver, context, string2, string3, string4, n10, string5, bitmap, pendingIntent);
    }
}

