/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Message
 */
package com.mob.tools;

import android.os.Handler;
import android.os.Message;
import com.mob.tools.MobHandlerThread;

public abstract class SSDKHandlerThread
implements Handler.Callback {
    private static final int MSG_START = 255;
    private static final int MSG_STOP = 254;
    public final Handler handler;

    public SSDKHandlerThread() {
        Handler handler;
        this.handler = handler = MobHandlerThread.newHandler("s", (Handler.Callback)this);
    }

    public final boolean handleMessage(Message message) {
        int n10 = message.what;
        int n11 = -2;
        if (n10 != n11) {
            n11 = -1;
            if (n10 != n11) {
                this.onMessage(message);
            } else {
                this.onStart(message);
            }
        } else {
            this.onStop(message);
        }
        return false;
    }

    public abstract void onMessage(Message var1);

    public void onStart(Message message) {
    }

    public void onStop(Message message) {
    }

    public void startThread() {
        this.startThread(0, 0, null);
    }

    public void startThread(int n10, int n11, Object object) {
        Message message = new Message();
        message.what = -1;
        message.arg1 = n10;
        message.arg2 = n11;
        message.obj = object;
        this.handler.sendMessage(message);
    }

    public void stopThread() {
        this.stopThread(0, 0, null);
    }

    public void stopThread(int n10, int n11, Object object) {
        Message message = new Message();
        message.what = -2;
        message.arg1 = n10;
        message.arg2 = n11;
        message.obj = object;
        this.handler.sendMessage(message);
    }
}

