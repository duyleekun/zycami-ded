/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.zhiyun.cama.web;

import android.os.Bundle;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.zhiyun.cama.main.me.WebViewFragment;
import com.zhiyun.cama.splash.SplashActivity;
import d.v.c.a2.a;
import d.v.c.v0.k;
import d.v.c.w0.t;
import d.v.f.c.d;
import d.v.i0.b;

public class WebAwakeActivity
extends d {
    private t b;
    private a c;
    private int d;

    private void d() {
        a a10 = this.c;
        boolean bl2 = a10.d(this);
        if (bl2) {
            bl2 = true;
            this.d = (int)(bl2 ? 1 : 0);
        }
    }

    private void f() {
        long l10;
        Object object;
        long l11;
        long l12;
        long l13;
        int n10 = this.d;
        int n11 = 1;
        if (n10 == n11 && (l13 = (l12 = (l11 = ((a)(object = this.c)).c(this)) - (l10 = (long)-1)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != false) {
            object = k.a(l11);
            n11 = 0;
            object = WebViewFragment.S((String)object, false, false, false);
            FragmentTransaction fragmentTransaction = this.getSupportFragmentManager().beginTransaction();
            l13 = 2131362511;
            object = fragmentTransaction.add((int)l13, (Fragment)object);
            ((FragmentTransaction)object).commit();
        }
    }

    public void onBackPressed() {
        int n10 = this.d;
        int n11 = 1;
        if (n10 == n11) {
            d.v.e.b b10 = d.v.e.b.i();
            n10 = b10.f();
            if (n10 > n11) {
                super.onBackPressed();
            } else {
                SplashActivity.m(this);
                this.finish();
            }
        } else {
            super.onBackPressed();
        }
    }

    public void onCreate(Bundle object) {
        super.onCreate((Bundle)object);
        object = (t)DataBindingUtil.setContentView(this, 2131558446);
        this.b = object;
        object = (a)d.v.i0.b.c(this).get(a.class);
        this.c = object;
        this.d();
        this.f();
    }
}

