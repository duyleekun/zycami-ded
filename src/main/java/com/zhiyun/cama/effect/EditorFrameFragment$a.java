/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package com.zhiyun.cama.effect;

import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.effect.EditorFrameFragment;
import d.v.c.b1.t.g;
import d.v.c.c1.d;
import d.v.c.i1.i2;
import d.v.c.q0.d$a;
import d.v.c.q0.e;
import d.v.e.i.h;
import d.v.h.f.a;

public class EditorFrameFragment$a
extends d$a {
    public final /* synthetic */ EditorFrameFragment c;

    public EditorFrameFragment$a(EditorFrameFragment editorFrameFragment) {
        this.c = editorFrameFragment;
        super(editorFrameFragment);
    }

    /*
     * WARNING - void declaration
     */
    public void c() {
        Object object;
        super.c();
        Object object2 = EditorFrameFragment.x(this.c).g();
        boolean n10 = ((e)object2).c();
        if (n10) {
            object = EditorFrameFragment.z(this.c);
            a a10 = (a)((e)object2).a();
            ((i2)object).l3(a10);
        } else {
            Object object3;
            int n11;
            void var2_4;
            boolean bl2 = false;
            object = null;
            while (++var2_4 < (n11 = (object3 = ((e)object2).b()).size())) {
                object3 = EditorFrameFragment.A(this.c);
                a a11 = (a)((e)object2).b().valueAt((int)var2_4);
                ((i2)object3).c3((int)var2_4, a11);
            }
        }
        EditorFrameFragment.B(this.c, false);
        object = EditorFrameFragment.C(this.c).o1();
        object2 = ((e)object2).c();
        h.g((MutableLiveData)object, object2);
    }

    public void d() {
        super.d();
        EditorFrameFragment.D(this.c, 64);
    }

    public void e() {
        super.e();
        MutableLiveData mutableLiveData = EditorFrameFragment.F(this.c).o1();
        Boolean bl2 = EditorFrameFragment.G(this.c).p1() ^ true;
        h.g(mutableLiveData, bl2);
    }

    public void f() {
        super.f();
        g g10 = EditorFrameFragment.E(this.c);
        a a10 = new a();
        g10.d3(a10);
        this.c.P();
    }

    public void h(int n10) {
        g g10 = EditorFrameFragment.y(this.c);
        int n11 = EditorFrameFragment.x(this.c).f();
        g10.j3(n11, n10);
        this.c.P();
    }

    public void i(View object, int n10) {
        object = EditorFrameFragment.x(this.c);
        int n11 = ((d)object).f();
        if (n10 == n11) {
            return;
        }
        object = EditorFrameFragment.x(this.c).e();
        Integer n12 = n10;
        h.g((MutableLiveData)object, n12);
    }
}

