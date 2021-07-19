/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Intent
 *  android.net.Uri
 */
package com.zhiyun.cama.prime.web;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import androidx.activity.result.ActivityResultCaller;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentManager;
import com.google.gson.reflect.TypeToken;
import com.zhiyun.cama.prime.web.PrimeWebFragment;
import com.zhiyun.cama.prime.web.PrimeWebFragment$a;
import com.zhiyun.cama.prime.web.PrimeWebFragment$d$a;
import com.zhiyun.component.widget.JSWebView$a;
import d.v.c.m1.c;
import d.v.c.m1.d.k;
import d.v.c.m1.d.p;
import d.v.c.m1.e.d;
import d.v.c.m1.e.e;
import d.v.c.m1.e.f;
import d.v.c.m1.e.g;
import d.v.c.m1.e.h;
import d.v.c.m1.e.i;
import d.v.c.x1.l;
import d.v.e.l.c1;
import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.Executor;

public class PrimeWebFragment$d
implements JSWebView$a {
    public final /* synthetic */ PrimeWebFragment a;

    private PrimeWebFragment$d(PrimeWebFragment primeWebFragment) {
        this.a = primeWebFragment;
    }

    public /* synthetic */ PrimeWebFragment$d(PrimeWebFragment primeWebFragment, PrimeWebFragment$a primeWebFragment$a) {
        this(primeWebFragment);
    }

    private /* synthetic */ void b() {
        p p10 = p.L(p.q, true);
        FragmentManager fragmentManager = this.a.getChildFragmentManager();
        p10.q(fragmentManager);
    }

    private /* synthetic */ void d() {
        PrimeWebFragment primeWebFragment = this.a;
        boolean bl2 = primeWebFragment.isVisible();
        if (!bl2) {
            return;
        }
        PrimeWebFragment.K(this.a);
    }

    private /* synthetic */ void f() {
        PrimeWebFragment.N((PrimeWebFragment)this.a).d = true;
        k k10 = k.F();
        FragmentManager fragmentManager = this.a.getChildFragmentManager();
        k10.q(fragmentManager);
    }

    private /* synthetic */ void h(List list) {
        PrimeWebFragment primeWebFragment = this.a;
        boolean bl2 = primeWebFragment.isVisible();
        if (!bl2) {
            return;
        }
        PrimeWebFragment.M(this.a, list);
    }

    private /* synthetic */ void j(String string2) {
        PrimeWebFragment primeWebFragment = this.a;
        boolean bl2 = primeWebFragment.isVisible();
        if (!bl2) {
            return;
        }
        PrimeWebFragment.L(this.a, string2);
    }

    private /* synthetic */ void l() {
        ActivityResultCaller activityResultCaller = this.a;
        try {
            l.h(activityResultCaller);
        }
        catch (Exception exception) {
            activityResultCaller = this.a.requireActivity();
            ActivityCompat.finishAfterTransition((Activity)activityResultCaller);
        }
    }

    public String a() {
        return "appAndroid";
    }

    public /* synthetic */ void c() {
        this.b();
    }

    public /* synthetic */ void e() {
        this.d();
    }

    public /* synthetic */ void g() {
        this.f();
    }

    public /* synthetic */ void i(List list) {
        this.h(list);
    }

    public /* synthetic */ void k(String string2) {
        this.j(string2);
    }

    public /* synthetic */ void m() {
        this.l();
    }

    public void nativeActivatPrime(String object) {
        object = PrimeWebFragment.I(this.a);
        boolean bl2 = ((c)object).p();
        if (bl2) {
            object = c1.b().c();
            g g10 = new g(this);
            object.execute(g10);
        }
    }

    public void nativeBrowser(String string2) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        string2 = Uri.parse((String)string2);
        intent.setData((Uri)string2);
        this.a.requireActivity().startActivity(intent);
    }

    public void nativeFailPrime() {
        Executor executor = c1.b().c();
        e e10 = new e(this);
        executor.execute(e10);
    }

    public void nativeLoginToast() {
        Executor executor = c1.b().c();
        f f10 = new f(this);
        executor.execute(f10);
    }

    public void nativeOpenPrime(int n10) {
        PrimeWebFragment.J(this.a).M(n10);
    }

    public void nativePushArray(String object) {
        boolean bl2;
        Object object2 = new PrimeWebFragment$d$a(this);
        object = d.v.e.l.q2.c.b((Type)(object2 = ((TypeToken)object2).getType()), (String)object);
        if (object != null && !(bl2 = object.isEmpty())) {
            object2 = c1.b().c();
            h h10 = new h(this, (List)object);
            object2.execute(h10);
        }
    }

    public void nativeShowPrime(String string2) {
        Executor executor = c1.b().c();
        i i10 = new i(this, string2);
        executor.execute(i10);
    }

    public void nativeUserCenter(String object) {
        object = this.a;
        boolean bl2 = PrimeWebFragment.H((PrimeWebFragment)object);
        if (bl2) {
            ActivityCompat.finishAfterTransition(this.a.requireActivity());
            return;
        }
        object = this.a.requireActivity();
        d d10 = new d(this);
        object.runOnUiThread((Runnable)d10);
    }
}

