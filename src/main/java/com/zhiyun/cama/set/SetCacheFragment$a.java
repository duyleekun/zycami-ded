/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package com.zhiyun.cama.set;

import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.set.SetCacheFragment;
import d.v.c.q1.f;
import d.v.c.q1.g;
import d.v.c.q1.h;
import d.v.c.q1.i;
import d.v.c.q1.j;
import d.v.c.x1.l;

public class SetCacheFragment$a {
    public final /* synthetic */ SetCacheFragment a;

    public SetCacheFragment$a(SetCacheFragment setCacheFragment) {
        this.a = setCacheFragment;
    }

    private /* synthetic */ void g(DialogFragment dialogFragment) {
        SetCacheFragment.j(this.a).e();
    }

    private /* synthetic */ void i(DialogFragment dialogFragment) {
        SetCacheFragment.j(this.a).f();
    }

    private /* synthetic */ void k(DialogFragment dialogFragment) {
        SetCacheFragment.j(this.a).g();
    }

    private /* synthetic */ void m(DialogFragment dialogFragment) {
        SetCacheFragment.j(this.a).i();
    }

    private /* synthetic */ void o(DialogFragment dialogFragment) {
        SetCacheFragment.j(this.a).j();
    }

    public void a(View object) {
        object = this.a;
        MutableLiveData mutableLiveData = SetCacheFragment.j((SetCacheFragment)object).m;
        g g10 = new g(this);
        SetCacheFragment.k((SetCacheFragment)object, mutableLiveData, g10);
    }

    public void b(View object) {
        object = this.a;
        MutableLiveData mutableLiveData = SetCacheFragment.j((SetCacheFragment)object).k;
        h h10 = new h(this);
        SetCacheFragment.k((SetCacheFragment)object, mutableLiveData, h10);
    }

    public void c(View object) {
        object = this.a;
        MutableLiveData mutableLiveData = SetCacheFragment.j((SetCacheFragment)object).o;
        j j10 = new j(this);
        SetCacheFragment.k((SetCacheFragment)object, mutableLiveData, j10);
    }

    public void d(View object) {
        object = this.a;
        LiveData liveData = SetCacheFragment.j((SetCacheFragment)object).n;
        i i10 = new i(this);
        SetCacheFragment.k((SetCacheFragment)object, liveData, i10);
    }

    public void e(View object) {
        object = this.a;
        MutableLiveData mutableLiveData = SetCacheFragment.j((SetCacheFragment)object).l;
        f f10 = new f(this);
        SetCacheFragment.k((SetCacheFragment)object, mutableLiveData, f10);
    }

    public void f(View view) {
        l.g(view);
    }

    public /* synthetic */ void h(DialogFragment dialogFragment) {
        this.g(dialogFragment);
    }

    public /* synthetic */ void j(DialogFragment dialogFragment) {
        this.i(dialogFragment);
    }

    public /* synthetic */ void l(DialogFragment dialogFragment) {
        this.k(dialogFragment);
    }

    public /* synthetic */ void n(DialogFragment dialogFragment) {
        this.m(dialogFragment);
    }

    public /* synthetic */ void p(DialogFragment dialogFragment) {
        this.o(dialogFragment);
    }
}

