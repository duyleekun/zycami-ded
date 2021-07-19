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
package com.zhiyun.account.set;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import androidx.navigation.NavInflater;
import androidx.navigation.fragment.NavHostFragment;
import com.zhiyun.account.R$color;
import com.zhiyun.account.R$id;
import com.zhiyun.account.R$layout;
import com.zhiyun.account.R$navigation;
import com.zhiyun.common.util.StatusBarUtil;
import d.v.a.j.a;
import d.v.a.j.c.y;
import d.v.f.c.d;
import d.v.f.i.g;
import d.v.i0.b;

public class ModifyPassActivity
extends d {
    private y b;

    private void d() {
        LiveData liveData = this.b.y;
        a a10 = new a(this);
        liveData.observe(this, a10);
    }

    private void f() {
        Window window = this.getWindow();
        int n10 = R$color.com_color_white;
        n10 = g.c((Context)this, n10);
        StatusBarUtil.z(window, n10);
        StatusBarUtil.E(this.getWindow(), true);
    }

    private /* synthetic */ void h(Integer object) {
        Object object2 = this.b.y;
        ((LiveData)object2).removeObservers(this);
        int n10 = (Integer)object;
        int n11 = 1;
        int n12 = -1;
        if (n10 != n11) {
            n11 = 2;
            if (n10 != n11) {
                n11 = 3;
                n10 = n10 != n11 ? n12 : R$id.chooseModifyPassFragment;
            } else {
                object = this.b.g;
                object2 = Boolean.FALSE;
                ((MutableLiveData)object).setValue(object2);
                n10 = R$id.modifyPassFragment;
            }
        } else {
            object = this.b.g;
            object2 = Boolean.TRUE;
            ((MutableLiveData)object).setValue(object2);
            n10 = R$id.modifyPassFragment;
        }
        object2 = this.getSupportFragmentManager();
        int n13 = R$id.nav_host_fragment;
        object2 = (NavHostFragment)((FragmentManager)object2).findFragmentById(n13);
        if (object2 != null && n12 != n10) {
            object2 = ((NavHostFragment)object2).getNavController();
            Object object3 = ((NavController)object2).getNavInflater();
            n13 = R$navigation.nav_set_private_modify;
            object3 = ((NavInflater)object3).inflate(n13);
            ((NavGraph)object3).setStartDestination(n10);
            ((NavController)object2).setGraph((NavGraph)object3);
        }
    }

    public static void j(Activity activity) {
        Intent intent = new Intent((Context)activity, ModifyPassActivity.class);
        activity.startActivity(intent);
    }

    public /* synthetic */ void i(Integer n10) {
        this.h(n10);
    }

    public void onCreate(Bundle object) {
        super.onCreate((Bundle)object);
        object = (y)d.v.i0.b.c(this).get(y.class);
        this.b = object;
        int n10 = R$layout.set_private_modify_pass_act;
        this.setContentView(n10);
        this.f();
        this.d();
    }
}

