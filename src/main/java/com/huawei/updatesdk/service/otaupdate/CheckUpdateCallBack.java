/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 */
package com.huawei.updatesdk.service.otaupdate;

import android.content.Intent;

public interface CheckUpdateCallBack {
    public void onMarketInstallInfo(Intent var1);

    public void onMarketStoreError(int var1);

    public void onUpdateInfo(Intent var1);

    public void onUpdateStoreError(int var1);
}

