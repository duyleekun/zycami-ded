/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Looper
 *  android.os.Process
 */
package com.mob.tools;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.mob.tools.MobHandlerThread$1;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;

public class MobHandlerThread
extends Thread {
    private Looper looper;
    private int priority;
    private int tid = -1;

    public MobHandlerThread() {
        this.priority = 0;
    }

    public MobHandlerThread(int n10) {
        this.priority = n10;
    }

    public static Handler newHandler(Handler.Callback callback) {
        return MobHandlerThread.newHandler(null, null, callback);
    }

    public static Handler newHandler(Runnable runnable, Handler.Callback callback) {
        return MobHandlerThread.newHandler(null, runnable, callback);
    }

    public static Handler newHandler(String string2, Handler.Callback callback) {
        return MobHandlerThread.newHandler(string2, null, callback);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Handler newHandler(String handlerArray, Runnable runnable, Handler.Callback object) {
        int n10 = 1;
        handlerArray = new Handler[n10];
        MobHandlerThread$1 mobHandlerThread$1 = new MobHandlerThread$1(runnable, handlerArray, (Handler.Callback)object);
        synchronized (handlerArray) {
            try {
                mobHandlerThread$1.start();
                handlerArray.wait();
            }
            catch (Throwable throwable) {
                object = MobLog.getInstance();
                ((NLog)object).w(throwable);
            }
            return handlerArray[0];
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public Looper getLooper() {
        boolean bl2 = this.isAlive();
        if (!bl2) {
            return null;
        }
        // MONITORENTER : this
        while (bl2 = this.isAlive()) {
            Looper looper = this.looper;
            if (looper != null) return this.looper;
            try {
                this.wait();
            }
            catch (Throwable throwable) {}
        }
        return this.looper;
    }

    public int getThreadId() {
        return this.tid;
    }

    public void onLooperPrepared() {
    }

    public void onLooperPrepared(Looper looper) {
    }

    public boolean quit() {
        Looper looper = this.getLooper();
        if (looper != null) {
            looper.quit();
            return true;
        }
        return false;
    }

    public void realRun() {
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        Looper looper;
        int n10;
        try {
            this.realRun();
            this.tid = n10 = Process.myTid();
            Looper.prepare();
            synchronized (this) {
            }
        }
        catch (Throwable throwable) {
            NLog nLog = MobLog.getInstance();
            nLog.d(throwable);
            return;
        }
        {
            this.looper = looper = Looper.myLooper();
            this.notifyAll();
        }
        {
            n10 = this.priority;
            Process.setThreadPriority((int)n10);
            looper = this.looper;
            this.onLooperPrepared(looper);
            this.onLooperPrepared();
            Looper.loop();
            this.tid = n10 = -1;
            return;
        }
    }
}

