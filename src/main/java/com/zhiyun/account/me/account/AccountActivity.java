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
package com.zhiyun.account.me.account;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import androidx.navigation.NavInflater;
import androidx.navigation.fragment.NavHostFragment;
import com.zhiyun.account.R$color;
import com.zhiyun.account.R$id;
import com.zhiyun.account.R$layout;
import com.zhiyun.account.R$navigation;
import com.zhiyun.account.me.country.CountryChooseActivity;
import com.zhiyun.common.util.StatusBarUtil;
import d.v.a.i.a.m0;
import d.v.a.i.b.e;
import d.v.f.c.d;
import d.v.f.i.g;
import d.v.i0.b;

public class AccountActivity
extends d {
    public static final int d = 50001;
    private static final String e = "ACTION_TOASTS_ROTATION";
    private static final String f = "id";
    public static final int g = 1;
    public static final int h = 2;
    public static final int i = 3;
    public static final int j = 4;
    private m0 b;
    private NavGraph c;

    private void d() {
        this.getWindow().getDecorView().setSystemUiVisibility(1024);
        Window window = this.getWindow();
        int n10 = R$color.com_color_transparent;
        n10 = d.v.f.i.g.c((Context)this, n10);
        StatusBarUtil.z(window, n10);
        StatusBarUtil.E(this.getWindow(), true);
    }

    private void f() {
        Object object = this.getIntent();
        Object object2 = this.getSupportFragmentManager();
        int n10 = R$id.nav_host_fragment;
        if ((object2 = (NavHostFragment)((FragmentManager)object2).findFragmentById(n10)) != null) {
            object2 = ((NavHostFragment)object2).getNavController();
            Object object3 = ((NavController)object2).getNavInflater();
            int n11 = R$navigation.nav_account;
            this.c = object3 = ((NavInflater)object3).inflate(n11);
            String string2 = f;
            int n12 = object.getIntExtra(string2, -1);
            if (n12 != (n10 = 1)) {
                n10 = 2;
                if (n12 != n10) {
                    n10 = 3;
                    if (n12 != n10) {
                        n10 = 4;
                        if (n12 == n10) {
                            object = this.c;
                            n10 = R$id.loginQuickFragment;
                            ((NavGraph)object).setStartDestination(n10);
                        }
                    } else {
                        object = this.c;
                        n10 = R$id.thirdBindFragment;
                        ((NavGraph)object).setStartDestination(n10);
                    }
                } else {
                    object = this.c;
                    n10 = R$id.registerFragment;
                    ((NavGraph)object).setStartDestination(n10);
                }
            } else {
                object = this.c;
                n10 = R$id.loginFragment;
                ((NavGraph)object).setStartDestination(n10);
            }
            object = this.c;
            n10 = 0;
            object3 = null;
            ((NavController)object2).setGraph((NavGraph)object, null);
        }
    }

    public static void h(Activity activity) {
        Intent intent = new Intent((Context)activity, AccountActivity.class);
        activity.startActivity(intent);
    }

    public static void i(Activity activity, int n10) {
        Intent intent = new Intent((Context)activity, AccountActivity.class);
        intent.putExtra(f, n10);
        activity.startActivity(intent);
    }

    public static void j(Context context) {
        Intent intent = new Intent(context, AccountActivity.class);
        intent.setFlags(0x10000000);
        context.startActivity(intent);
    }

    public static void k(Activity activity) {
        Intent intent = new Intent((Context)activity, AccountActivity.class);
        intent.putExtra(e, true);
        activity.startActivity(intent);
    }

    public static void l(Activity activity) {
        Intent intent = new Intent((Context)activity, AccountActivity.class);
        activity.startActivityForResult(intent, 50001);
    }

    public void onActivityResult(int n10, int n11, Intent intent) {
        super.onActivityResult(n10, n11, intent);
        Object object = CountryChooseActivity.p(n10, n11, intent);
        if (object != null) {
            MutableLiveData mutableLiveData = this.b.k;
            object = ((e)object).b();
            mutableLiveData.setValue(object);
        }
    }

    public void onCreate(Bundle object) {
        super.onCreate((Bundle)object);
        this.d();
        int bl2 = R$layout.me_account_act;
        this.setContentView(bl2);
        this.b = object = (m0)d.v.i0.b.c(this).get(m0.class);
        boolean bl3 = this.getIntent().getBooleanExtra(e, false);
        this.b.v(bl3);
        this.f();
    }
}

