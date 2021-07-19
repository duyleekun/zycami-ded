/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.huawei.hms.support.api.client;

import android.os.Bundle;

public class BundleResult {
    private int a;
    private Bundle b;

    public BundleResult(int n10, Bundle bundle) {
        this.a = n10;
        this.b = bundle;
    }

    public int getResultCode() {
        return this.a;
    }

    public Bundle getRspBody() {
        return this.b;
    }

    public void setResultCode(int n10) {
        this.a = n10;
    }

    public void setRspBody(Bundle bundle) {
        this.b = bundle;
    }
}

