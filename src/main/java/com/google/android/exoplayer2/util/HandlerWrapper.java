/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 *  android.os.Message
 */
package com.google.android.exoplayer2.util;

import android.os.Looper;
import android.os.Message;

public interface HandlerWrapper {
    public Looper getLooper();

    public boolean hasMessages(int var1);

    public Message obtainMessage(int var1);

    public Message obtainMessage(int var1, int var2, int var3);

    public Message obtainMessage(int var1, int var2, int var3, Object var4);

    public Message obtainMessage(int var1, Object var2);

    public boolean post(Runnable var1);

    public boolean postDelayed(Runnable var1, long var2);

    public void removeCallbacksAndMessages(Object var1);

    public void removeMessages(int var1);

    public boolean sendEmptyMessage(int var1);

    public boolean sendEmptyMessageAtTime(int var1, long var2);

    public boolean sendEmptyMessageDelayed(int var1, int var2);
}

