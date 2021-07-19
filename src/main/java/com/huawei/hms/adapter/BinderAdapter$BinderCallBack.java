/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Intent
 *  android.os.IBinder
 */
package com.huawei.hms.adapter;

import android.content.ComponentName;
import android.content.Intent;
import android.os.IBinder;

public interface BinderAdapter$BinderCallBack {
    public void onBinderFailed(int var1);

    public void onBinderFailed(int var1, Intent var2);

    public void onNullBinding(ComponentName var1);

    public void onServiceConnected(ComponentName var1, IBinder var2);

    public void onServiceDisconnected(ComponentName var1);
}

