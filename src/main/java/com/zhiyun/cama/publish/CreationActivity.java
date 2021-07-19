/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 */
package com.zhiyun.cama.publish;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.zhiyun.cama.splash.SplashActivity;
import d.v.f.c.d;

public class CreationActivity
extends d {
    public static void d(Context context) {
        Intent intent = new Intent(context, CreationActivity.class);
        context.startActivity(intent);
    }

    public void onActivityResult(int n10, int n11, Intent intent) {
        super.onActivityResult(n10, n11, intent);
        n10 = -1;
        if (n11 == n10) {
            SplashActivity.n(this);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.getWindow().getDecorView().setSystemUiVisibility(1792);
        this.getWindow().setStatusBarColor(0);
        this.setContentView(2131558492);
    }
}

