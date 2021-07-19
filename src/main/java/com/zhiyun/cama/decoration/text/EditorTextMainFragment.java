/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.View
 */
package com.zhiyun.cama.decoration.text;

import android.os.Bundle;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout$Tab;
import com.zhiyun.cama.decoration.text.EditorTextMainFragment$a;
import com.zhiyun.cama.decoration.text.EditorTextMainFragment$b;
import com.zhiyun.editorinterface.decoration.DecorationType;
import d.v.c.b1.t.g;
import d.v.c.i1.i2;
import d.v.c.w0.j8;
import d.v.c.x0.c.a;
import d.v.c.x0.c.d.i;
import d.v.c.x0.c.f.k;
import d.v.e.i.j;
import d.v.h.d.d;
import d.v.i0.b;

public class EditorTextMainFragment
extends d.v.c.q0.d {
    private static final String m = "page";
    private static final int[] n;
    private j8 j;
    private final Fragment[] k;
    private d.v.c.x0.c.b l;

    static {
        int[] nArray;
        int[] nArray2 = nArray = new int[4];
        int[] nArray3 = nArray;
        nArray2[0] = 2131231966;
        nArray3[1] = 2131231965;
        nArray2[2] = 2131231967;
        nArray3[3] = 2131231964;
        n = nArray;
    }

    public EditorTextMainFragment() {
        Fragment[] fragmentArray = new Fragment[4];
        this.k = fragmentArray;
    }

    public static /* synthetic */ boolean A(EditorTextMainFragment editorTextMainFragment) {
        return editorTextMainFragment.K();
    }

    public static /* synthetic */ void B(EditorTextMainFragment editorTextMainFragment) {
        editorTextMainFragment.t();
    }

    public static /* synthetic */ void C(EditorTextMainFragment editorTextMainFragment) {
        editorTextMainFragment.N();
    }

    public static /* synthetic */ Fragment[] D(EditorTextMainFragment editorTextMainFragment) {
        return editorTextMainFragment.k;
    }

    public static /* synthetic */ int[] E() {
        return n;
    }

    public static Bundle F(int n10) {
        Bundle bundle = new Bundle();
        bundle.putInt(m, n10);
        return bundle;
    }

    private void G() {
        Object object = this.k;
        Object object2 = new d.v.c.x0.c.e.b();
        object[0] = object2;
        object = this.k;
        object2 = new d.v.c.x0.c.d.j();
        object[1] = object2;
        object = this.k;
        object2 = new k();
        object[2] = object2;
        object = this.k;
        object2 = new d.v.c.x0.c.c.d();
        int n10 = 3;
        object[n10] = object2;
        object = this.l;
        object2 = this.g.X0();
        object2 = object2 == null ? null : this.g.X0().s();
        ((d.v.c.x0.c.b)object).j((d)object2);
    }

    private void H() {
        j j10 = this.l.b();
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        a a10 = new a(this);
        j10.observe(lifecycleOwner, a10);
    }

    private void I() {
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            int n10 = bundle.getInt(m, 0);
            d.v.c.x0.c.b b10 = this.l;
            b10.f(n10);
        }
    }

    private void J() {
        Object object;
        int n10;
        this.G();
        Object object2 = this.j;
        Object object3 = ((j8)object2).b;
        object2 = ((j8)object2).c;
        object3.setupWithViewPager((ViewPager)((Object)object2));
        object3 = this.getChildFragmentManager();
        boolean bl2 = true;
        object2 = new EditorTextMainFragment$b(this, (FragmentManager)object3, (int)(bl2 ? 1 : 0));
        this.j.c.setAdapter((PagerAdapter)object2);
        object3 = null;
        DecorationType decorationType = null;
        for (int i10 = 0; i10 < (n10 = ((Fragment[])(object = this.k)).length); ++i10) {
            object = this.j.b.getTabAt(i10);
            View view = ((EditorTextMainFragment$b)object2).a(i10);
            ((TabLayout$Tab)object).setCustomView(view);
        }
        object2 = this.g;
        decorationType = DecorationType.FONT;
        ((i2)object2).F3(decorationType, false, bl2);
    }

    private boolean K() {
        boolean bl2;
        boolean bl3;
        i i10 = this.l.d();
        d.v.c.x0.c.f.j j10 = this.l.c();
        boolean bl4 = true;
        if (i10 != null && (bl3 = i10.J())) {
            bl3 = bl4;
        } else {
            bl3 = false;
            i10 = null;
        }
        if (j10 != null && (bl2 = j10.J())) {
            bl2 = bl4;
        } else {
            bl2 = false;
            j10 = null;
        }
        if (!bl3 && !bl2 || (bl3 = d.v.c.m1.b.a())) {
            bl4 = false;
        }
        return bl4;
    }

    private /* synthetic */ void L(Integer n10) {
        ViewPager viewPager = this.j.c;
        int n11 = n10;
        viewPager.setCurrentItem(n11);
    }

    private void N() {
        boolean bl2 = true;
        this.v(bl2);
        Object object = this.l.e();
        Object object2 = this.g.X0();
        if (object == null && object2 == null) {
            return;
        }
        if (object == null) {
            long l10 = 262144L;
            this.w(l10);
        } else if (object2 == null) {
            long l11 = 524288L;
            this.w(l11);
        } else {
            long l12 = 0x200000L;
            this.w(l12);
        }
        object = this.g;
        object2 = DecorationType.FONT;
        ((i2)object).F3((DecorationType)((Object)object2), bl2, bl2);
    }

    public static /* synthetic */ d.v.c.x0.c.b x(EditorTextMainFragment editorTextMainFragment) {
        return editorTextMainFragment.l;
    }

    public static /* synthetic */ g y(EditorTextMainFragment editorTextMainFragment) {
        return editorTextMainFragment.g;
    }

    public static /* synthetic */ g z(EditorTextMainFragment editorTextMainFragment) {
        return editorTextMainFragment.g;
    }

    public /* synthetic */ void M(Integer n10) {
        this.L(n10);
    }

    public int h() {
        return 2131558592;
    }

    public void i(ViewDataBinding object) {
        super.i((ViewDataBinding)object);
        object = (j8)object;
        this.j = object;
        this.l = object = (d.v.c.x0.c.b)d.v.i0.b.a(this).get(d.v.c.x0.c.b.class);
        this.j.B((d.v.c.x0.c.b)object);
        object = this.j;
        EditorTextMainFragment$a editorTextMainFragment$a = new EditorTextMainFragment$a(this);
        ((j8)object).A(editorTextMainFragment$a);
        this.J();
        this.I();
        this.H();
    }

    public void j() {
        this.N();
        this.u();
    }

    public void k() {
        super.k();
        this.j.u().c();
    }

    public boolean s(int n10) {
        this.j.u().g(n10);
        return this.K() ^ true;
    }
}

