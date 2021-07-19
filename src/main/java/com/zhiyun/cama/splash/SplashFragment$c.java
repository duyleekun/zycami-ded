/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package com.zhiyun.cama.splash;

import android.view.View;
import com.zhiyun.cama.splash.SplashFragment;
import d.v.c.t1.f;

public class SplashFragment$c {
    public final /* synthetic */ SplashFragment a;

    public SplashFragment$c(SplashFragment splashFragment) {
        this.a = splashFragment;
    }

    private /* synthetic */ void b() {
        SplashFragment.j(this.a).o(true);
    }

    public void a(View view) {
        SplashFragment.m(this.a);
    }

    public /* synthetic */ void c() {
        this.b();
    }

    public void d(View view) {
        SplashFragment.k(this.a);
    }

    public void e(View view) {
        SplashFragment.k(this.a);
        f f10 = new f(this);
        view.postDelayed((Runnable)f10, 200L);
    }
}

