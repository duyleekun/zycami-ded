/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseArray
 *  android.view.View
 */
package com.zhiyun.cama.zoom;

import android.util.SparseArray;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.zoom.EditorZoomFragment;
import d.v.c.i1.i2;
import d.v.c.q0.d$a;
import d.v.c.q0.e;
import d.v.e.i.h;

public class EditorZoomFragment$a
extends d$a {
    public final /* synthetic */ EditorZoomFragment c;

    public EditorZoomFragment$a(EditorZoomFragment editorZoomFragment) {
        this.c = editorZoomFragment;
        super(editorZoomFragment);
    }

    /*
     * WARNING - void declaration
     */
    public void c() {
        Object object;
        Object object2 = EditorZoomFragment.x(this.c).c();
        boolean n10 = ((e)object2).c();
        if (n10) {
            object = EditorZoomFragment.z(this.c);
            Integer n11 = (Integer)((e)object2).a();
            int n12 = n11;
            ((i2)object).S(n12);
        } else {
            Object object3;
            int n13;
            void var2_4;
            boolean bl2 = false;
            object = null;
            while (++var2_4 < (n13 = (object3 = ((e)object2).b()).size())) {
                object3 = EditorZoomFragment.A(this.c);
                SparseArray sparseArray = ((e)object2).b();
                int n14 = sparseArray.keyAt((int)var2_4);
                Integer n15 = (Integer)((e)object2).b().valueAt((int)var2_4);
                int n16 = n15;
                ((i2)object3).g0(n14, n16);
            }
        }
        EditorZoomFragment.B(this.c, false);
        object = EditorZoomFragment.C(this.c).v1();
        object2 = ((e)object2).c();
        h.g((MutableLiveData)object, object2);
    }

    public void d() {
        super.d();
        EditorZoomFragment.D(this.c, 32);
    }

    public void e() {
        MutableLiveData mutableLiveData = EditorZoomFragment.F(this.c).v1();
        Boolean bl2 = EditorZoomFragment.G(this.c).w1() ^ true;
        h.g(mutableLiveData, bl2);
    }

    public void f() {
        EditorZoomFragment.x(this.c).d(0);
        EditorZoomFragment.E(this.c).f0(0);
    }

    public void h(View view, int n10) {
        EditorZoomFragment.x(this.c).d(n10);
        EditorZoomFragment.y(this.c).f0(n10);
    }
}

