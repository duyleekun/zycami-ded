/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.view.Window
 */
package com.zhiyun.account.me.account.visitor;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import androidx.fragment.app.Fragment;
import com.zhiyun.account.R$color;
import com.zhiyun.account.R$layout;
import com.zhiyun.common.util.StatusBarUtil;
import d.v.f.c.d;
import d.v.f.i.g;

public class VisitorBindActivity
extends d {
    private void d() {
        Window window = this.getWindow();
        int n10 = R$color.com_color_white;
        n10 = g.c((Context)this, n10);
        StatusBarUtil.z(window, n10);
        StatusBarUtil.E(this.getWindow(), true);
    }

    public static void f(Context context) {
        Intent intent = new Intent(context, VisitorBindActivity.class);
        context.startActivity(intent);
    }

    public static void h(Fragment fragment, int n10) {
        Context context = fragment.requireContext();
        Intent intent = new Intent(context, VisitorBindActivity.class);
        fragment.startActivityForResult(intent, n10);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int n10 = R$layout.me_visitor_bind_act;
        this.setContentView(n10);
        this.d();
    }
}

