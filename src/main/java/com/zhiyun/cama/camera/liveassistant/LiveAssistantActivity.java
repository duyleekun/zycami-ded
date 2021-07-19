/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 */
package com.zhiyun.cama.camera.liveassistant;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import d.v.c.s0.e7.s;
import d.v.f.c.d;
import d.v.i0.b;

public class LiveAssistantActivity
extends d {
    private s b;

    public static void d(Activity activity) {
        Intent intent = new Intent((Context)activity, LiveAssistantActivity.class);
        activity.startActivity(intent);
    }

    public void onCreate(Bundle object) {
        super.onCreate((Bundle)object);
        this.setContentView(2131558441);
        this.getWindow().getDecorView().setSystemUiVisibility(1280);
        this.getWindow().setStatusBarColor(0);
        object = (s)d.v.i0.b.c(this).get(s.class);
        this.b = object;
    }

    public void onDestroy() {
        super.onDestroy();
        this.b.j();
        this.b.g();
    }

    public void onPause() {
        super.onPause();
        boolean bl2 = this.isFinishing();
        if (!bl2) {
            s s10 = this.b;
            boolean bl3 = s10.e;
            if (bl3) {
                s10.t();
            }
        }
    }

    public void onResume() {
        super.onResume();
        this.b.o();
    }
}

