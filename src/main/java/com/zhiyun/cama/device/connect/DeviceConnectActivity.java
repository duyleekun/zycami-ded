/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 */
package com.zhiyun.cama.device.connect;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import d.v.f.c.d;

public class DeviceConnectActivity
extends d {
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;
    public static final int f = 5;

    public static void d(Context context) {
        Intent intent = new Intent(context, DeviceConnectActivity.class);
        context.startActivity(intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2131558432);
    }
}

