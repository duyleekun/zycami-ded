/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.main;

import com.zhiyun.cama.main.EditorMainFragment;
import com.zhiyun.cama.main.EditorMainFragment$g;
import d.v.c.b1.t.g;
import d.v.c.b2.p$b;
import d.v.c.b2.w.k;
import d.v.c.i1.s;
import d.v.c.i1.t;
import java.util.Optional;

public class EditorMainFragment$g$b
implements p$b {
    public final /* synthetic */ EditorMainFragment$g a;

    public EditorMainFragment$g$b(EditorMainFragment$g editorMainFragment$g) {
        this.a = editorMainFragment$g;
    }

    private /* synthetic */ void g(int n10, k k10, k k11) {
        g g10 = EditorMainFragment.i0(this.a.a);
        long l10 = k10.i();
        long l11 = k10.t();
        long l12 = k10.s();
        boolean bl2 = k10.w();
        g10.t0(n10, l10, l11, l12, bl2, false);
    }

    private /* synthetic */ void i(int n10, k k10, k k11) {
        EditorMainFragment editorMainFragment = this.a.a;
        long l10 = k11.i();
        boolean bl2 = k10.w();
        EditorMainFragment.h0(editorMainFragment, n10, l10, bl2);
    }

    public /* synthetic */ void h(int n10, k k10, k k11) {
        this.g(n10, k10, k11);
    }

    public /* synthetic */ void j(int n10, k k10, k k11) {
        this.i(n10, k10, k11);
    }

    public void k(int n10, k k10, float f10, boolean bl2) {
    }

    public void l(int n10, k k10, float f10) {
    }

    public void m(int n10, k k10, boolean bl2) {
        EditorMainFragment.z(this.a.a);
    }

    public void n(int n10, k k10) {
        EditorMainFragment.x0(this.a.a);
        EditorMainFragment.z(this.a.a);
    }

    public void o(int n10, k k10, boolean bl2) {
        Optional<k> optional = Optional.ofNullable(k10);
        t t10 = new t(this, n10, k10);
        optional.ifPresent(t10);
        EditorMainFragment.A(this.a.a);
        EditorMainFragment.g0(this.a.a, bl2);
    }

    public void p(int n10, k k10) {
        Optional<k> optional = Optional.ofNullable(k10);
        s s10 = new s(this, n10, k10);
        optional.ifPresent(s10);
        EditorMainFragment.A(this.a.a);
        EditorMainFragment.X(this.a.a);
    }
}

