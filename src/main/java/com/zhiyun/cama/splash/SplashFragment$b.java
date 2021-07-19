/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.zhiyun.cama.splash;

import android.content.Context;
import androidx.viewpager.widget.ViewPager$OnPageChangeListener;
import com.zhiyun.cama.splash.SplashFragment;
import d.v.c.t1.s;
import d.v.f.i.g;

public class SplashFragment$b
implements ViewPager$OnPageChangeListener {
    public final /* synthetic */ int[] a;
    public final /* synthetic */ SplashFragment b;

    public SplashFragment$b(SplashFragment splashFragment, int[] nArray) {
        this.b = splashFragment;
        this.a = nArray;
    }

    public void onPageScrollStateChanged(int n10) {
    }

    public void onPageScrolled(int n10, float f10, int n11) {
    }

    public void onPageSelected(int n10) {
        s s10 = SplashFragment.j(this.b);
        Object object = this.b.requireContext();
        int[] nArray = this.a;
        int n11 = nArray[n10];
        object = g.m(object, n11);
        s10.r((String)object);
        s10 = SplashFragment.j(this.b);
        object = this.a;
        int n12 = ((Context)object).length;
        n11 = 1;
        if (n10 != (n12 -= n11)) {
            n11 = 0;
            nArray = null;
        }
        s10.n(n11 != 0);
        SplashFragment.l(this.b, n10);
    }
}

