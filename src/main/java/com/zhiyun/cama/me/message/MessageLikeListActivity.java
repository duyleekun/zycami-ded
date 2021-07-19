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
package com.zhiyun.cama.me.message;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import androidx.navigation.fragment.NavHostFragment;
import com.zhiyun.common.util.StatusBarUtil;
import d.v.f.c.d;
import d.v.f.i.g;

public class MessageLikeListActivity
extends d {
    private void d() {
        Object object = this.getSupportFragmentManager();
        int n10 = 2131362934;
        if ((object = (NavHostFragment)((FragmentManager)object).findFragmentById(n10)) != null) {
            object = ((NavHostFragment)object).getNavController();
            NavGraph navGraph = ((NavController)object).getNavInflater().inflate(2131755021);
            int n11 = 2131362893;
            navGraph.setStartDestination(n11);
            ((NavController)object).setGraph(navGraph);
        }
    }

    public static void f(Activity activity) {
        Intent intent = new Intent((Context)activity, MessageLikeListActivity.class);
        activity.startActivity(intent);
    }

    public static void h(Context context) {
        Intent intent = new Intent(context, MessageLikeListActivity.class);
        intent.setFlags(0x10000000);
        context.startActivity(intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2131558749);
        bundle = this.getWindow();
        int n10 = g.c((Context)this, 2131099772);
        StatusBarUtil.z((Window)bundle, n10);
        StatusBarUtil.E(this.getWindow(), true);
        this.d();
    }
}

