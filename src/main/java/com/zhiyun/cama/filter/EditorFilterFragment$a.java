/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.SparseArray
 *  android.widget.SeekBar
 */
package com.zhiyun.cama.filter;

import android.content.Context;
import android.util.SparseArray;
import android.widget.SeekBar;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.filter.EditorFilterFragment;
import d.v.c.e1.u;
import d.v.c.i1.i2;
import d.v.c.q0.d$a;
import d.v.c.q0.e;
import d.v.e.i.h;
import d.v.h.f.a;

public class EditorFilterFragment$a
extends d$a {
    public final /* synthetic */ EditorFilterFragment c;

    public EditorFilterFragment$a(EditorFilterFragment editorFilterFragment) {
        this.c = editorFilterFragment;
        super(editorFilterFragment);
    }

    /*
     * WARNING - void declaration
     */
    public void c() {
        Object object;
        super.c();
        Object object2 = EditorFilterFragment.x(this.c).S();
        boolean n10 = ((e)object2).c();
        if (n10) {
            object = EditorFilterFragment.G(this.c);
            a a10 = (a)((e)object2).a();
            ((i2)object).m3(a10);
        } else {
            Object object3;
            int n11;
            void var2_4;
            boolean bl2 = false;
            object = null;
            while (++var2_4 < (n11 = (object3 = ((e)object2).b()).size())) {
                object3 = EditorFilterFragment.H(this.c);
                SparseArray sparseArray = ((e)object2).b();
                int n12 = sparseArray.keyAt((int)var2_4);
                a a11 = (a)((e)object2).b().valueAt((int)var2_4);
                ((i2)object3).h3(n12, a11);
            }
        }
        EditorFilterFragment.I(this.c, false);
        object = EditorFilterFragment.J(this.c).m1();
        object2 = ((e)object2).c();
        h.g((MutableLiveData)object, object2);
    }

    public void d() {
        super.d();
        EditorFilterFragment editorFilterFragment = this.c;
        boolean bl2 = EditorFilterFragment.K(editorFilterFragment);
        if (bl2) {
            editorFilterFragment = this.c;
            EditorFilterFragment.z(editorFilterFragment);
        } else {
            editorFilterFragment = this.c;
            boolean bl3 = true;
            EditorFilterFragment.A(editorFilterFragment, bl3);
            editorFilterFragment = this.c;
            long l10 = 2;
            EditorFilterFragment.B(editorFilterFragment, l10);
        }
    }

    public void e() {
        super.e();
        MutableLiveData mutableLiveData = EditorFilterFragment.E(this.c).m1();
        Boolean bl2 = EditorFilterFragment.F(this.c).n1() ^ true;
        h.g(mutableLiveData, bl2);
    }

    public void f() {
        super.f();
        EditorFilterFragment.y(this.c).E2();
        EditorFilterFragment.D(this.c);
    }

    public void h(SeekBar object, int n10, boolean bl2) {
        object = EditorFilterFragment.x(this.c).x();
        Integer n11 = n10;
        h.g((MutableLiveData)object, n11);
    }

    public void i() {
        EditorFilterFragment.C((EditorFilterFragment)this.c).e.e();
        u u10 = EditorFilterFragment.x(this.c);
        Context context = this.c.requireContext();
        u10.u(context);
    }
}

