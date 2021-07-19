/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.os.Bundle
 */
package com.huawei.hms.activity;

import android.app.Activity;
import android.os.Bundle;
import com.huawei.hms.base.ui.R$layout;

public class EnableServiceActivity
extends Activity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.requestWindowFeature(1);
        int n10 = R$layout.activity_endisable_service;
        this.setContentView(n10);
    }
}

