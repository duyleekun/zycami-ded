/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.zoom;

import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.zhiyun.cama.zoom.EditorZoomFragment$a;
import d.v.c.b1.t.g;
import d.v.c.c2.a;
import d.v.c.c2.b;
import d.v.c.c2.c;
import d.v.c.i1.i2;
import d.v.c.q0.d;
import d.v.c.q0.e;
import d.v.c.w0.v8;
import d.v.e.i.h;
import d.v.e.i.j;

public class EditorZoomFragment
extends d {
    private v8 j;
    private c k;

    public static /* synthetic */ g A(EditorZoomFragment editorZoomFragment) {
        return editorZoomFragment.g;
    }

    public static /* synthetic */ boolean B(EditorZoomFragment editorZoomFragment, boolean bl2) {
        editorZoomFragment.c = bl2;
        return bl2;
    }

    public static /* synthetic */ g C(EditorZoomFragment editorZoomFragment) {
        return editorZoomFragment.g;
    }

    public static /* synthetic */ void D(EditorZoomFragment editorZoomFragment, long l10) {
        editorZoomFragment.w(l10);
    }

    public static /* synthetic */ g E(EditorZoomFragment editorZoomFragment) {
        return editorZoomFragment.g;
    }

    public static /* synthetic */ g F(EditorZoomFragment editorZoomFragment) {
        return editorZoomFragment.g;
    }

    public static /* synthetic */ g G(EditorZoomFragment editorZoomFragment) {
        return editorZoomFragment.g;
    }

    private void H() {
        this.O();
        this.N();
    }

    private void I() {
        MutableLiveData mutableLiveData = this.g.v1();
        Object object = new a(this);
        mutableLiveData.observe(this, (Observer)object);
        mutableLiveData = this.g.R0();
        object = this.getViewLifecycleOwner();
        b b10 = new b(this);
        ((j)mutableLiveData).observe((LifecycleOwner)object, b10);
    }

    private /* synthetic */ void J(Boolean bl2) {
        Boolean bl3;
        boolean bl4;
        Object object;
        int n10 = this.c;
        if (n10 != 0) {
            n10 = bl2.booleanValue();
            if (n10 != 0) {
                g g10 = this.g;
                n10 = g10.P0();
            } else {
                g g11 = this.g;
                n10 = g11.k1();
            }
        } else {
            g g12 = this.g;
            n10 = g12.h2();
        }
        this.g.U3();
        g g13 = this.g;
        n10 = (int)(g13.f0(n10) ? 1 : 0);
        boolean bl5 = true;
        if (n10 == 0) {
            object = this.g.v1();
            bl4 = bl2 ^ bl5;
            bl3 = bl4;
            h.g((MutableLiveData)object, bl3);
        }
        object = this.j.b.a;
        bl4 = bl2;
        if (bl4 && n10 != 0) {
            bl4 = bl5;
        } else {
            bl4 = false;
            bl3 = null;
        }
        object.setChecked(bl4);
        this.g.A2();
        object = this.g;
        boolean bl6 = bl2;
        if (!bl6 || n10 == 0) {
            bl5 = false;
            g13 = null;
        }
        ((i2)object).f3(bl5);
    }

    private /* synthetic */ void L(Integer n10) {
        this.O();
    }

    private void N() {
        Object object;
        int n10;
        e e10 = new e();
        int n11 = this.g.w1();
        e10 = e10.e(n11 != 0);
        Integer n12 = this.g.k1();
        e10 = e10.f(n12);
        n12 = null;
        for (n11 = 0; n11 < (n10 = (object = this.g.C1()).size()); ++n11) {
            n10 = this.g.i2(n11);
            object = n10;
            e10.d(n11, object);
        }
        this.k.e(e10);
    }

    private void O() {
        int n10 = this.g.h2();
        this.k.d(n10);
    }

    public static /* synthetic */ c x(EditorZoomFragment editorZoomFragment) {
        return editorZoomFragment.k;
    }

    public static /* synthetic */ g y(EditorZoomFragment editorZoomFragment) {
        return editorZoomFragment.g;
    }

    public static /* synthetic */ g z(EditorZoomFragment editorZoomFragment) {
        return editorZoomFragment.g;
    }

    public /* synthetic */ void K(Boolean bl2) {
        this.J(bl2);
    }

    public /* synthetic */ void M(Integer n10) {
        this.L(n10);
    }

    public int h() {
        return 2131558598;
    }

    public void i(ViewDataBinding object) {
        super.i((ViewDataBinding)object);
        object = (v8)object;
        this.j = object;
        this.k = object = (c)d.v.i0.b.a(this).get(c.class);
        object = this.j;
        Object object2 = new EditorZoomFragment$a(this);
        ((v8)object).A((EditorZoomFragment$a)object2);
        object = this.j;
        object2 = this.k;
        ((v8)object).B((c)object2);
        this.H();
        this.I();
    }

    public boolean s(int n10) {
        this.j.u().g(n10);
        return true;
    }
}

