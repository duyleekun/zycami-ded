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
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.account.R$color;
import com.zhiyun.account.R$layout;
import com.zhiyun.account.me.country.CountryChooseActivity;
import com.zhiyun.common.util.StatusBarUtil;
import d.v.a.i.b.e;
import d.v.a.j.b;
import d.v.a.j.c.y;
import d.v.f.c.d;
import d.v.f.i.g;

public class PrivateBindActivity
extends d {
    private void d() {
        Window window = this.getWindow();
        int n10 = R$color.com_color_white;
        n10 = g.c((Context)this, n10);
        StatusBarUtil.z(window, n10);
        StatusBarUtil.E(this.getWindow(), true);
    }

    public static /* synthetic */ void f(Integer n10) {
    }

    public static void h(Activity activity) {
        Intent intent = new Intent((Context)activity, PrivateBindActivity.class);
        activity.startActivity(intent);
    }

    public void onActivityResult(int n10, int n11, Intent object) {
        super.onActivityResult(n10, n11, (Intent)object);
        Object object2 = CountryChooseActivity.p(n10, n11, object);
        if (object2 != null) {
            Object object3 = d.v.i0.b.c(this);
            object = y.class;
            object3 = ((y)object3.get((Class)object)).h;
            object2 = ((e)object2).b();
            ((MutableLiveData)object3).setValue(object2);
        }
    }

    public void onCreate(Bundle object) {
        super.onCreate((Bundle)object);
        int n10 = R$layout.set_private_bind_act;
        this.setContentView(n10);
        object = ((y)d.v.i0.b.c((FragmentActivity)this).get(y.class)).y;
        b b10 = b.a;
        ((LiveData)object).observe(this, b10);
        this.d();
    }
}

