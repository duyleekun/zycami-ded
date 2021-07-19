/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 */
package com.sina.weibo.sdk.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sina.weibo.sdk.b.c;

public final class c$1
extends Handler {
    public final /* synthetic */ c V;

    public c$1(c c10, Looper looper) {
        this.V = c10;
        super(looper);
    }

    public final void handleMessage(Message message) {
        Object object = (Object[])message.obj;
        int n10 = message.what;
        int n11 = 1;
        if (n10 == n11) {
            c c10 = object.X;
            object = object.Y;
            n11 = 0;
            object = object[0];
            c.a(c10, object);
            object = null;
            message.obj = null;
        }
    }
}

