/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseArray
 */
package com.zhiyun.cama.rotate;

import android.util.SparseArray;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.zhiyun.cama.rotate.EditorRotateFragment;
import d.v.c.i1.i2;
import d.v.c.q0.d$a;
import d.v.c.q0.e;
import d.v.e.i.h;
import d.v.h.e.d;

public class EditorRotateFragment$a
extends d$a {
    public final /* synthetic */ EditorRotateFragment c;

    public EditorRotateFragment$a(EditorRotateFragment editorRotateFragment) {
        this.c = editorRotateFragment;
        super(editorRotateFragment);
    }

    public void c() {
        Object object;
        int n10;
        Object object2 = EditorRotateFragment.y(this.c).n();
        MutableLiveData mutableLiveData = null;
        for (int i10 = 0; i10 < (n10 = (object = ((e)object2).b()).size()); ++i10) {
            object = EditorRotateFragment.N(this.c);
            SparseArray sparseArray = ((e)object2).b();
            int n11 = sparseArray.keyAt(i10);
            d.v.c.p1.d d10 = (d.v.c.p1.d)((e)object2).b().valueAt(i10);
            ((i2)object).Y(n11, d10);
        }
        EditorRotateFragment.O(this.c, false);
        mutableLiveData = EditorRotateFragment.P(this.c).t1();
        object2 = ((e)object2).c();
        h.g(mutableLiveData, object2);
    }

    public void d() {
        super.d();
        EditorRotateFragment.Q(this.c, 16);
    }

    public void f() {
        EditorRotateFragment.J((EditorRotateFragment)this.c).c.setPositionData(0);
        ViewModel viewModel = EditorRotateFragment.z(this.c);
        d.v.c.p1.d d10 = EditorRotateFragment.R(this.c);
        ((i2)viewModel).Z(d10);
        viewModel = EditorRotateFragment.y(this.c);
        int n10 = EditorRotateFragment.A(this.c).S0();
        ((d.v.c.p1.e)viewModel).r(n10, false);
    }

    public void h(int n10) {
        d.v.c.p1.e e10 = EditorRotateFragment.y(this.c);
        int n11 = EditorRotateFragment.L(this.c).Q0();
        n10 = e10.d(n11, n10);
        EditorRotateFragment.M(this.c).v2(n10);
    }

    public void i() {
        Object object = EditorRotateFragment.B(this.c);
        int n10 = ((i2)object).S0();
        Object object2 = EditorRotateFragment.y(this.c);
        int n11 = ((d.v.c.p1.e)object2).k(n10);
        Object object3 = EditorRotateFragment.y(this.c);
        int n12 = n11 ^ 1;
        ((d.v.c.p1.e)object3).r(n10, n12 != 0);
        if (n11 == 0) {
            object = EditorRotateFragment.D(this.c).C1();
            object2 = EditorRotateFragment.C(this.c);
            int n13 = ((i2)object2).S0();
            if ((object = (d)object.get(n13)) != null) {
                object2 = EditorRotateFragment.F(this.c);
                int n14 = EditorRotateFragment.E(this.c).S0();
                object3 = n14;
                if ((object2 = (d.v.c.p1.d)object2.get(object3)) == null) {
                    object2 = new d.v.c.p1.d();
                }
                float f10 = ((d)object).G();
                object3 = ((d.v.c.p1.d)object2).j(f10);
                float f11 = ((d)object).H();
                object3 = ((d.v.c.p1.d)object3).k(f11);
                n12 = ((d)object).F();
                object3 = ((d.v.c.p1.d)object3).i(n12);
                n12 = 0;
                f11 = 0.0f;
                object3 = ((d.v.c.p1.d)object3).l(0.0f).m(0.0f);
                n10 = ((d)object).B();
                ((d.v.c.p1.d)object3).h(n10);
                object = EditorRotateFragment.F(this.c);
                n14 = EditorRotateFragment.G(this.c).S0();
                object3 = n14;
                object.put(object3, object2);
            }
            object = EditorRotateFragment.H(this.c);
            ((i2)object).z0();
        } else {
            object = EditorRotateFragment.F(this.c);
            int n15 = EditorRotateFragment.I(this.c).S0();
            object2 = n15;
            if ((object = (d.v.c.p1.d)object.get(object2)) != null) {
                object2 = EditorRotateFragment.K(this.c);
                ((i2)object2).Z((d.v.c.p1.d)object);
            }
        }
    }

    public void j(int n10) {
        d.v.c.p1.e e10 = EditorRotateFragment.y(this.c);
        int n11 = -EditorRotateFragment.x(this.c).V0();
        n10 = e10.e(n11, n10);
        EditorRotateFragment.J((EditorRotateFragment)this.c).c.setPositionData(n10);
    }
}

