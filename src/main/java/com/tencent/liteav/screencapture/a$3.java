/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.HandlerThread
 */
package com.tencent.liteav.screencapture;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.liteav.screencapture.a;
import com.tencent.liteav.screencapture.a$3$1;

public class a$3
implements Runnable {
    public final /* synthetic */ Handler a;
    public final /* synthetic */ HandlerThread b;
    public final /* synthetic */ a c;

    public a$3(a a10, Handler handler, HandlerThread handlerThread) {
        this.c = a10;
        this.a = handler;
        this.b = handlerThread;
    }

    public void run() {
        Handler handler = this.c.a;
        a$3$1 a$3$1 = new a$3$1(this);
        handler.post((Runnable)a$3$1);
    }
}

