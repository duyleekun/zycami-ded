/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 */
package com.huawei.hms.activity.internal;

import android.content.Intent;

public class BusResponseResult {
    private int code;
    private Intent intent;

    public int getCode() {
        return this.code;
    }

    public Intent getIntent() {
        return this.intent;
    }

    public void setCode(int n10) {
        this.code = n10;
    }

    public void setIntent(Intent intent) {
        this.intent = intent;
    }
}

