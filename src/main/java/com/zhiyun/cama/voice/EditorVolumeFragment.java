/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.voice;

import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.zhiyun.cama.voice.EditorVolumeFragment$a;
import com.zhiyun.editorinterface.edit.MediaType;
import d.v.c.b1.t.g;
import d.v.c.i1.i2;
import d.v.c.w0.t8;
import d.v.c.y1.a;
import d.v.c.y1.b;
import d.v.c.y1.c;
import d.v.c.y1.e;
import d.v.e.i.h;
import d.v.e.i.j;
import d.v.h.e.d;
import java.util.List;

public class EditorVolumeFragment
extends d.v.c.q0.d {
    private t8 j;
    private e k;

    public static /* synthetic */ void A(EditorVolumeFragment editorVolumeFragment) {
        editorVolumeFragment.Q();
    }

    public static /* synthetic */ g B(EditorVolumeFragment editorVolumeFragment) {
        return editorVolumeFragment.g;
    }

    public static /* synthetic */ g C(EditorVolumeFragment editorVolumeFragment) {
        return editorVolumeFragment.g;
    }

    public static /* synthetic */ g D(EditorVolumeFragment editorVolumeFragment) {
        return editorVolumeFragment.g;
    }

    public static /* synthetic */ g E(EditorVolumeFragment editorVolumeFragment) {
        return editorVolumeFragment.g;
    }

    public static /* synthetic */ boolean F(EditorVolumeFragment editorVolumeFragment, boolean bl2) {
        editorVolumeFragment.c = bl2;
        return bl2;
    }

    public static /* synthetic */ g G(EditorVolumeFragment editorVolumeFragment) {
        return editorVolumeFragment.g;
    }

    public static /* synthetic */ void H(EditorVolumeFragment editorVolumeFragment, long l10) {
        editorVolumeFragment.w(l10);
    }

    private boolean I(float f10) {
        return this.g.U(f10);
    }

    private void J() {
        MutableLiveData mutableLiveData = this.g.R0();
        Observer observer = new c(this);
        ((j)mutableLiveData).observe(this, observer);
        mutableLiveData = this.g.r1();
        observer = new b(this);
        mutableLiveData.observe(this, observer);
        mutableLiveData = this.k.c();
        observer = new a(this);
        mutableLiveData.observe(this, observer);
    }

    private void K() {
        Object object;
        int n10;
        d.v.c.q0.e e10 = new d.v.c.q0.e();
        int n11 = this.g.s1();
        e10 = e10.e(n11 != 0);
        Float f10 = Float.valueOf(this.g.i1());
        e10 = e10.f(f10);
        f10 = null;
        for (n11 = 0; n11 < (n10 = (object = this.g.C1()).size()); ++n11) {
            float f11 = this.g.E1(n11);
            object = Float.valueOf(f11);
            e10.d(n11, object);
        }
        this.k.e(e10);
        this.Q();
    }

    public static /* synthetic */ boolean L(EditorVolumeFragment editorVolumeFragment, float f10) {
        return editorVolumeFragment.I(f10);
    }

    private /* synthetic */ void M(Integer object) {
        if (object == null) {
            return;
        }
        this.Q();
        e e10 = this.k;
        List list = this.g.C1();
        int n10 = (Integer)object;
        object = (d)list.get(n10);
        e10.f((d)object);
    }

    private /* synthetic */ void O(Boolean bl2) {
        Boolean bl3;
        boolean bl4;
        Object object;
        float f10;
        boolean bl5 = this.c;
        if (bl5) {
            bl5 = bl2;
            if (bl5) {
                g g10 = this.g;
                f10 = g10.O0();
            } else {
                g g11 = this.g;
                f10 = g11.i1();
            }
        } else {
            g g12 = this.g;
            f10 = g12.D1();
        }
        g g13 = this.g;
        g13.J3();
        bl5 = this.I(f10);
        boolean bl6 = true;
        if (!bl5) {
            object = this.g.r1();
            bl4 = bl2 ^ bl6;
            bl3 = bl4;
            h.g((MutableLiveData)object, bl3);
        }
        this.Q();
        object = this.j.b.a;
        bl4 = bl2;
        if (bl4 && bl5) {
            bl4 = bl6;
        } else {
            bl4 = false;
            bl3 = null;
        }
        object.setChecked(bl4);
        this.g.A2();
        object = this.g;
        boolean bl7 = bl2;
        if (!bl7 || !bl5) {
            bl6 = false;
            g13 = null;
        }
        ((i2)object).f3(bl6);
    }

    private void Q() {
        boolean bl2;
        MediaType mediaType;
        Object object = this.g.C1();
        int n10 = this.g.S0();
        Object object2 = ((d.v.h.e.a)(object = (d)object.get(n10))).f();
        if (object2 == (mediaType = MediaType.VIDEO) && !(bl2 = ((d.v.h.e.a)object).j())) {
            float f10 = this.g.D1();
            object2 = this.k.c();
            object = Float.valueOf(f10);
            h.g((MutableLiveData)object2, object);
        } else {
            object = this.k.c();
            n10 = 0;
            object2 = Float.valueOf(0.0f);
            h.g((MutableLiveData)object, object2);
        }
    }

    public static /* synthetic */ e x(EditorVolumeFragment editorVolumeFragment) {
        return editorVolumeFragment.k;
    }

    public static /* synthetic */ boolean y(EditorVolumeFragment editorVolumeFragment, float f10) {
        return editorVolumeFragment.I(f10);
    }

    public static /* synthetic */ t8 z(EditorVolumeFragment editorVolumeFragment) {
        return editorVolumeFragment.j;
    }

    public /* synthetic */ void N(Integer n10) {
        this.M(n10);
    }

    public /* synthetic */ void P(Boolean bl2) {
        this.O(bl2);
    }

    public int h() {
        return 2131558597;
    }

    public void i(ViewDataBinding object) {
        super.i((ViewDataBinding)object);
        object = (t8)object;
        this.j = object;
        this.k = object = (e)d.v.i0.b.a(this).get(e.class);
        object = this.j;
        Object object2 = new EditorVolumeFragment$a(this);
        ((t8)object).A((EditorVolumeFragment$a)object2);
        object = this.j;
        object2 = this.k;
        ((t8)object).B((e)object2);
        this.K();
        this.J();
    }

    public boolean s(int n10) {
        this.j.u().g(n10);
        return true;
    }
}

