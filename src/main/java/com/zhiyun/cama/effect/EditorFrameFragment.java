/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.effect;

import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.zhiyun.cama.effect.EditorFrameFragment$a;
import d.v.c.b1.t.g;
import d.v.c.c1.a;
import d.v.c.c1.b;
import d.v.c.c1.c;
import d.v.c.i1.i2;
import d.v.c.q0.e;
import d.v.c.w0.r6;
import d.v.e.i.h;
import d.v.e.i.j;
import d.v.h.e.d;

public class EditorFrameFragment
extends d.v.c.q0.d {
    private r6 j;
    private d.v.c.c1.d k;

    public static /* synthetic */ g A(EditorFrameFragment editorFrameFragment) {
        return editorFrameFragment.g;
    }

    public static /* synthetic */ boolean B(EditorFrameFragment editorFrameFragment, boolean bl2) {
        editorFrameFragment.c = bl2;
        return bl2;
    }

    public static /* synthetic */ g C(EditorFrameFragment editorFrameFragment) {
        return editorFrameFragment.g;
    }

    public static /* synthetic */ void D(EditorFrameFragment editorFrameFragment, long l10) {
        editorFrameFragment.w(l10);
    }

    public static /* synthetic */ g E(EditorFrameFragment editorFrameFragment) {
        return editorFrameFragment.g;
    }

    public static /* synthetic */ g F(EditorFrameFragment editorFrameFragment) {
        return editorFrameFragment.g;
    }

    public static /* synthetic */ g G(EditorFrameFragment editorFrameFragment) {
        return editorFrameFragment.g;
    }

    private void H() {
        Object object;
        int n10;
        e e10 = new e();
        int n11 = this.g.p1();
        e10 = e10.e(n11 != 0);
        d.v.h.f.a a10 = this.g.h1().a();
        e10 = e10.f(a10);
        a10 = null;
        for (n11 = 0; n11 < (n10 = (object = this.g.C1()).size()); ++n11) {
            object = ((d)this.g.C1().get(n11)).w().a();
            e10.d(n11, object);
        }
        this.k.i(e10);
    }

    private void I() {
        MutableLiveData mutableLiveData = this.g.o1();
        Observer observer = new b(this);
        mutableLiveData.observe(this, observer);
        mutableLiveData = this.g.R0();
        observer = new c(this);
        ((j)mutableLiveData).observe(this, observer);
        mutableLiveData = this.k.e();
        observer = new a(this);
        mutableLiveData.observe(this, observer);
    }

    private /* synthetic */ void J(Boolean bl2) {
        boolean bl3 = this.c;
        Object object = bl3 ? ((bl3 = bl2.booleanValue()) ? this.g.M0() : this.g.h1()) : this.g.e1();
        this.g.H3();
        this.g.d3((d.v.h.f.a)object);
        object = this.j.b.a;
        boolean bl4 = bl2;
        object.setChecked(bl4);
        this.g.A2();
        object = this.g;
        boolean bl5 = bl2;
        ((i2)object).f3(bl5);
    }

    private /* synthetic */ void L(Integer n10) {
        this.P();
    }

    private /* synthetic */ void N(Integer n10) {
        this.P();
    }

    public static /* synthetic */ d.v.c.c1.d x(EditorFrameFragment editorFrameFragment) {
        return editorFrameFragment.k;
    }

    public static /* synthetic */ g y(EditorFrameFragment editorFrameFragment) {
        return editorFrameFragment.g;
    }

    public static /* synthetic */ g z(EditorFrameFragment editorFrameFragment) {
        return editorFrameFragment.g;
    }

    public /* synthetic */ void K(Boolean bl2) {
        this.J(bl2);
    }

    public /* synthetic */ void M(Integer n10) {
        this.L(n10);
    }

    public /* synthetic */ void O(Integer n10) {
        this.N(n10);
    }

    public void P() {
        Object object = this.k;
        Object object2 = this.g.e1();
        int n10 = ((d.v.c.c1.d)object).c((d.v.h.f.a)object2);
        object2 = this.k.d();
        object = n10;
        h.g((MutableLiveData)object2, object);
    }

    public int h() {
        return 2131558570;
    }

    public void i(ViewDataBinding object) {
        super.i((ViewDataBinding)object);
        object = (r6)object;
        this.j = object;
        this.k = object = (d.v.c.c1.d)d.v.i0.b.a(this).get(d.v.c.c1.d.class);
        this.j.B((d.v.c.c1.d)object);
        object = this.j;
        EditorFrameFragment$a editorFrameFragment$a = new EditorFrameFragment$a(this);
        ((r6)object).A(editorFrameFragment$a);
        this.H();
        this.I();
    }

    public boolean s(int n10) {
        this.j.u().g(n10);
        return true;
    }
}

