/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Intent
 *  android.view.KeyEvent
 */
package com.huawei.hms.activity;

import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;

public interface IBridgeActivityDelegate {
    public int getRequestCode();

    public void onBridgeActivityCreate(Activity var1);

    public void onBridgeActivityDestroy();

    public boolean onBridgeActivityResult(int var1, int var2, Intent var3);

    public void onBridgeConfigurationChanged();

    public void onKeyUp(int var1, KeyEvent var2);
}

