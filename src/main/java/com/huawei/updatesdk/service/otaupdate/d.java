/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 */
package com.huawei.updatesdk.service.otaupdate;

import android.content.Intent;
import com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack;

public class d {
    private static final Object b;
    private static d c;
    private CheckUpdateCallBack a;

    static {
        Object object;
        b = object = new Object();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static d a() {
        Object object = b;
        synchronized (object) {
            d d10 = c;
            if (d10 != null) return c;
            c = d10 = new d();
            return c;
        }
    }

    public void a(int n10) {
        CheckUpdateCallBack checkUpdateCallBack = this.a;
        if (checkUpdateCallBack != null) {
            checkUpdateCallBack.onMarketStoreError(n10);
        }
    }

    public void a(Intent intent) {
        CheckUpdateCallBack checkUpdateCallBack = this.a;
        if (checkUpdateCallBack != null) {
            checkUpdateCallBack.onMarketInstallInfo(intent);
        }
    }

    public void a(CheckUpdateCallBack checkUpdateCallBack) {
        this.a = checkUpdateCallBack;
    }

    public void b(Intent intent) {
        CheckUpdateCallBack checkUpdateCallBack = this.a;
        if (checkUpdateCallBack != null) {
            checkUpdateCallBack.onUpdateInfo(intent);
        }
    }
}

