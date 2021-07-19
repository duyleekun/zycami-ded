/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.view.Window
 */
package com.zhiyun.cama.main.me.user;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import com.zhiyun.common.util.StatusBarUtil;
import d.v.c.i1.t2.i0;
import d.v.f.c.d;
import d.v.f.i.g;
import d.v.i0.b;

public class UserPageActivity
extends d {
    public static void d(Activity activity, int n10) {
        Intent intent = new Intent((Context)activity, UserPageActivity.class);
        intent.putExtra("user_id", n10);
        activity.startActivity(intent);
    }

    public void onCreate(Bundle object) {
        super.onCreate((Bundle)object);
        this.setContentView(2131558808);
        object = this.getWindow();
        int n10 = g.c((Context)this, 2131099772);
        StatusBarUtil.z((Window)object, n10);
        StatusBarUtil.E(this.getWindow(), true);
        object = (i0)b.c(this).get(i0.class);
        ((i0)object).J(false);
        n10 = this.getIntent().getIntExtra("user_id", -1);
        ((i0)object).L(n10);
    }
}

