/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.rotate;

import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider$Factory;
import com.zhiyun.cama.rotate.EditorRotateFragment$a;
import com.zhiyun.cama.widget.HorizontalScrollView;
import com.zhiyun.cama.widget.HorizontalScrollView$a;
import d.v.c.b1.t.g;
import d.v.c.i1.i2;
import d.v.c.p1.a;
import d.v.c.p1.b;
import d.v.c.p1.c;
import d.v.c.p1.d;
import d.v.c.p1.e;
import d.v.c.w0.p7;
import d.v.c.x1.m;
import d.v.e.i.j;
import java.util.HashMap;
import java.util.Map;

public class EditorRotateFragment
extends d.v.c.q0.d {
    private p7 j;
    private e k;
    private d l;
    private Map m;

    public static /* synthetic */ g A(EditorRotateFragment editorRotateFragment) {
        return editorRotateFragment.g;
    }

    public static /* synthetic */ g B(EditorRotateFragment editorRotateFragment) {
        return editorRotateFragment.g;
    }

    public static /* synthetic */ g C(EditorRotateFragment editorRotateFragment) {
        return editorRotateFragment.g;
    }

    public static /* synthetic */ g D(EditorRotateFragment editorRotateFragment) {
        return editorRotateFragment.g;
    }

    public static /* synthetic */ g E(EditorRotateFragment editorRotateFragment) {
        return editorRotateFragment.g;
    }

    public static /* synthetic */ Map F(EditorRotateFragment editorRotateFragment) {
        return editorRotateFragment.m;
    }

    public static /* synthetic */ g G(EditorRotateFragment editorRotateFragment) {
        return editorRotateFragment.g;
    }

    public static /* synthetic */ g H(EditorRotateFragment editorRotateFragment) {
        return editorRotateFragment.g;
    }

    public static /* synthetic */ g I(EditorRotateFragment editorRotateFragment) {
        return editorRotateFragment.g;
    }

    public static /* synthetic */ p7 J(EditorRotateFragment editorRotateFragment) {
        return editorRotateFragment.j;
    }

    public static /* synthetic */ g K(EditorRotateFragment editorRotateFragment) {
        return editorRotateFragment.g;
    }

    public static /* synthetic */ g L(EditorRotateFragment editorRotateFragment) {
        return editorRotateFragment.g;
    }

    public static /* synthetic */ g M(EditorRotateFragment editorRotateFragment) {
        return editorRotateFragment.g;
    }

    public static /* synthetic */ g N(EditorRotateFragment editorRotateFragment) {
        return editorRotateFragment.g;
    }

    public static /* synthetic */ boolean O(EditorRotateFragment editorRotateFragment, boolean bl2) {
        editorRotateFragment.c = bl2;
        return bl2;
    }

    public static /* synthetic */ g P(EditorRotateFragment editorRotateFragment) {
        return editorRotateFragment.g;
    }

    public static /* synthetic */ void Q(EditorRotateFragment editorRotateFragment, long l10) {
        editorRotateFragment.w(l10);
    }

    public static /* synthetic */ d R(EditorRotateFragment editorRotateFragment) {
        return editorRotateFragment.l;
    }

    private void S() {
        Object object;
        int n10;
        Object object2 = new HashMap();
        this.m = object2;
        object2 = new d.v.c.q0.e();
        int n11 = this.g.u1();
        object2 = ((d.v.c.q0.e)object2).e(n11 != 0);
        n11 = 0;
        object2 = ((d.v.c.q0.e)object2).f(null);
        HashMap hashMap = this.k.j();
        for (int i10 = 0; i10 < (n10 = (object = this.g.C1()).size()); ++i10) {
            d d10;
            object = (d.v.h.e.d)this.g.C1().get(i10);
            float f10 = ((d.v.h.e.d)object).G();
            float f11 = ((d.v.h.e.d)object).H();
            int n12 = ((d.v.h.e.d)object).F();
            float f12 = ((d.v.h.e.d)object).L();
            float f13 = ((d.v.h.e.d)object).M();
            int n13 = ((d.v.h.e.d)object).B();
            Object object3 = d10;
            d10 = new d(f10, f11, n12, f12, f13, n13);
            ((d.v.c.q0.e)object2).d(i10, d10);
            object = i10;
            object3 = Boolean.FALSE;
            hashMap.put(object, object3);
        }
        this.k.t((d.v.c.q0.e)object2);
        this.g.z2();
        object2 = this.k;
        n11 = this.g.V0();
        ((e)object2).s(n11);
        this.l = object2 = new d();
    }

    private void T() {
        Object object = this.j.c;
        Object object2 = new b(this);
        ((HorizontalScrollView)((Object)object)).setHorizontalScrollListener((HorizontalScrollView$a)object2);
        object = this.g.R0();
        object2 = this.getViewLifecycleOwner();
        Observer observer = new c(this);
        ((j)object).observe((LifecycleOwner)object2, observer);
        object = this.k.l();
        object2 = this.getViewLifecycleOwner();
        observer = new a(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
    }

    private /* synthetic */ void U(int n10) {
        ViewModel viewModel = this.k;
        int n11 = this.g.S0();
        ((e)viewModel).r(n11, false);
        viewModel = this.g;
        n10 = -n10;
        ((i2)viewModel).U2(n10);
    }

    private /* synthetic */ void W(Integer object) {
        if (object == null) {
            return;
        }
        e e10 = this.k;
        int n10 = (Integer)object;
        e10.o(n10);
        object = this.k;
        int n11 = this.g.V0();
        ((e)object).s(n11);
    }

    private /* synthetic */ void Y(Integer n10) {
        HorizontalScrollView horizontalScrollView = this.j.c;
        int n11 = -n10.intValue();
        horizontalScrollView.setPositionData(n11);
    }

    public static /* synthetic */ g x(EditorRotateFragment editorRotateFragment) {
        return editorRotateFragment.g;
    }

    public static /* synthetic */ e y(EditorRotateFragment editorRotateFragment) {
        return editorRotateFragment.k;
    }

    public static /* synthetic */ g z(EditorRotateFragment editorRotateFragment) {
        return editorRotateFragment.g;
    }

    public /* synthetic */ void V(int n10) {
        this.U(n10);
    }

    public /* synthetic */ void X(Integer n10) {
        this.W(n10);
    }

    public /* synthetic */ void Z(Integer n10) {
        this.Y(n10);
    }

    public int h() {
        return 2131558582;
    }

    public void i(ViewDataBinding object) {
        super.i((ViewDataBinding)object);
        object = (p7)object;
        this.j = object;
        Object object2 = new EditorRotateFragment$a(this);
        ((p7)object).A((EditorRotateFragment$a)object2);
        object2 = this.g.a1();
        object = new Object[]{object2};
        object = d.v.c.x1.m.b((Object[])object);
        object = (e)d.v.i0.b.b(this, (ViewModelProvider$Factory)object).get(e.class);
        this.k = object;
        this.j.b.a.setVisibility(8);
        object = this.j;
        object2 = this.k;
        ((p7)object).B((e)object2);
        this.S();
        this.T();
    }

    public void onDestroy() {
        super.onDestroy();
        this.g.o0();
    }

    public void onStart() {
        super.onStart();
    }

    public boolean s(int n10) {
        this.j.u().g(n10);
        return true;
    }
}

