/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.Looper
 */
package com.tencent.liteav.basic.util;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.liteav.basic.util.h$1;

public class h {
    private Handler a;
    private Looper b;
    private boolean c;
    private Thread d;

    public h(String string2) {
        HandlerThread handlerThread = new HandlerThread(string2);
        this.c = true;
        handlerThread.start();
        string2 = handlerThread.getLooper();
        Looper looper = this.b = string2;
        super(looper);
        this.a = string2;
        this.d = handlerThread;
    }

    public static /* synthetic */ Handler a(h h10) {
        return h10.a;
    }

    public Handler a() {
        return this.a;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(Runnable runnable) {
        Thread thread;
        int n10 = 1;
        boolean[] blArray = new boolean[n10];
        Thread thread2 = Thread.currentThread();
        boolean bl2 = thread2.equals(thread = this.d);
        if (bl2) {
            runnable.run();
            return;
        }
        thread2 = this.a;
        synchronized (thread2) {
            boolean bl3;
            thread = null;
            blArray[0] = false;
            Handler handler = this.a;
            h$1 h$1 = new h$1(this, runnable, blArray);
            handler.post((Runnable)h$1);
            while (!(bl3 = blArray[0])) {
                try {
                    runnable = this.a;
                    runnable.wait();
                }
                catch (Exception exception) {}
            }
            return;
        }
    }

    public void a(Runnable runnable, long l10) {
        this.a.postDelayed(runnable, l10);
    }

    public void b(Runnable runnable) {
        this.a.post(runnable);
    }

    public void finalize() {
        boolean bl2 = this.c;
        if (bl2) {
            Looper looper = this.a.getLooper();
            looper.quit();
        }
        super.finalize();
    }
}

