/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Looper
 */
package com.mob.tools;

import android.os.Handler;
import android.os.Looper;
import com.mob.tools.MobHandlerThread;

public final class MobHandlerThread$1
extends MobHandlerThread {
    public final /* synthetic */ Runnable val$beforeRun;
    public final /* synthetic */ Handler.Callback val$callback;
    public final /* synthetic */ Handler[] val$handler;

    public MobHandlerThread$1(Runnable runnable, Handler[] handlerArray, Handler.Callback callback) {
        this.val$beforeRun = runnable;
        this.val$handler = handlerArray;
        this.val$callback = callback;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onLooperPrepared(Looper handlerArray) {
        Handler[] handlerArray2 = this.val$handler;
        synchronized (handlerArray2) {
            Handler handler;
            Handler[] handlerArray3 = this.val$handler;
            Handler.Callback callback = this.val$callback;
            handlerArray3[0] = handler = new Handler((Looper)handlerArray, callback);
            handlerArray = this.val$handler;
            handlerArray.notifyAll();
            return;
        }
    }

    public void run() {
        Runnable runnable = this.val$beforeRun;
        if (runnable != null) {
            runnable.run();
        }
        super.run();
    }
}

