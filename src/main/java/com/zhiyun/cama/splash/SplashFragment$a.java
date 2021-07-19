/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.splash;

import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.splash.SplashFragment;
import d.v.c.t1.s;
import d.v.e.l.m2$a;
import d.v.f.i.g;

public class SplashFragment$a
implements m2$a {
    public final /* synthetic */ SplashFragment a;

    public SplashFragment$a(SplashFragment splashFragment) {
        this.a = splashFragment;
    }

    public void a(Long object) {
        int n10;
        Object object2 = SplashFragment.j(this.a);
        ((s)object2).h = n10 = Math.toIntExact((Long)object);
        object2 = SplashFragment.j((SplashFragment)this.a).g;
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = g.m(this.a.requireContext(), 2131952253);
        stringBuilder.append(string2);
        stringBuilder.append(" ");
        stringBuilder.append(object);
        object = stringBuilder.toString();
        ((MutableLiveData)object2).setValue(object);
    }

    public void onComplete() {
        SplashFragment.j((SplashFragment)this.a).h = 0;
        MutableLiveData mutableLiveData = SplashFragment.j((SplashFragment)this.a).g;
        CharSequence charSequence = new StringBuilder();
        String string2 = g.m(this.a.requireContext(), 2131952253);
        charSequence.append(string2);
        charSequence.append(" 0");
        charSequence = charSequence.toString();
        mutableLiveData.setValue(charSequence);
        SplashFragment.k(this.a);
    }
}

