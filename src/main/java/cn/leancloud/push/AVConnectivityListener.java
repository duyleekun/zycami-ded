/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package cn.leancloud.push;

import android.content.Context;

public interface AVConnectivityListener {
    public void onMobile(Context var1);

    public void onNotConnected(Context var1);

    public void onOtherConnected(Context var1);

    public void onWifi(Context var1);
}

