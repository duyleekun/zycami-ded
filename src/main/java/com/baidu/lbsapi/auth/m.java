/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 */
package com.baidu.lbsapi.auth;

import android.os.Handler;
import android.os.Looper;
import com.baidu.lbsapi.auth.a;

public class m
extends Thread {
    public Handler a = null;
    private Object b;
    private boolean c;

    public m() {
        Object object;
        this.b = object = new Object();
        this.c = false;
    }

    public m(String object) {
        super((String)object);
        this.b = object = new Object();
        this.c = false;
    }

    public void a() {
        boolean bl2 = com.baidu.lbsapi.auth.a.a;
        if (bl2) {
            String string2 = "Looper thread quit()";
            com.baidu.lbsapi.auth.a.a(string2);
        }
        this.a.getLooper().quit();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b() {
        Object object = this.b;
        synchronized (object) {
            Throwable throwable2;
            block7: {
                try {
                    try {
                        boolean bl2 = this.c;
                        if (!bl2) {
                            Object object2 = this.b;
                            object2.wait();
                        }
                    }
                    catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                }
                catch (Throwable throwable2) {
                    break block7;
                }
                return;
            }
            throw throwable2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void c() {
        Object object = this.b;
        synchronized (object) {
            boolean bl2;
            this.c = bl2 = true;
            Object object2 = this.b;
            object2.notifyAll();
            return;
        }
    }

    public void run() {
        Looper.prepare();
        Object object = new Handler();
        this.a = object;
        boolean bl2 = com.baidu.lbsapi.auth.a.a;
        if (bl2) {
            object = "new Handler() finish!!";
            com.baidu.lbsapi.auth.a.a((String)object);
        }
        Looper.loop();
        bl2 = com.baidu.lbsapi.auth.a.a;
        if (bl2) {
            object = new StringBuilder();
            ((StringBuilder)object).append("LooperThread run() thread id:");
            long l10 = Thread.currentThread().getId();
            String string2 = String.valueOf(l10);
            ((StringBuilder)object).append(string2);
            object = ((StringBuilder)object).toString();
            com.baidu.lbsapi.auth.a.a((String)object);
        }
    }
}

