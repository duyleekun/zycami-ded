/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.Looper
 */
package com.tencent.liteav.basic.opengl;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.liteav.basic.opengl.h$1$1;

public final class h$1
implements Runnable {
    public final /* synthetic */ Handler a;
    public final /* synthetic */ HandlerThread b;

    public h$1(Handler handler, HandlerThread handlerThread) {
        this.a = handler;
        this.b = handlerThread;
    }

    public void run() {
        Object object = Looper.getMainLooper();
        Handler handler = new Handler(object);
        object = new h$1$1(this);
        handler.post((Runnable)object);
    }
}

