/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.IBinder
 */
package com.baidu.location;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

public interface LLSInterface {
    public double getVersion();

    public IBinder onBind(Intent var1);

    public void onCreate(Context var1);

    public void onDestroy();

    public int onStartCommand(Intent var1, int var2, int var3);

    public void onTaskRemoved(Intent var1);

    public boolean onUnBind(Intent var1);
}

