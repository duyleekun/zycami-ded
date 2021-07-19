/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 */
package com.zhiyun.cama.main;

import android.view.ViewTreeObserver;
import com.zhiyun.cama.main.EditorMainFragment;
import com.zhiyun.cama.main.EditorMainFragment$g;
import com.zhiyun.cama.main.EditorMainFragment$g$e$a;
import d.v.c.b1.t.g;
import d.v.c.b2.p$b;
import d.v.c.b2.w.j;
import d.v.c.i1.u;
import java.util.Optional;

public class EditorMainFragment$g$e
implements p$b {
    public final /* synthetic */ EditorMainFragment$g a;

    public EditorMainFragment$g$e(EditorMainFragment$g editorMainFragment$g) {
        this.a = editorMainFragment$g;
    }

    private /* synthetic */ void g(int n10, j j10, j j11) {
        g g10 = EditorMainFragment.q0(this.a.a);
        long l10 = j10.i();
        long l11 = j10.g();
        g10.s0(n10, l10, l11);
    }

    public /* synthetic */ void h(int n10, j j10, j j11) {
        this.g(n10, j10, j11);
    }

    public void i(int n10, j j10, float f10, boolean bl2) {
    }

    public void j(int n10, j j10, float f10) {
    }

    public void k(int n10, j j10, boolean bl2) {
        EditorMainFragment.z(this.a.a);
    }

    public void l(int n10, j j10) {
    }

    public void m(int n10, j object, boolean bl2) {
        Optional<j> optional = Optional.ofNullable(object);
        u u10 = new u(this, n10, (j)object);
        optional.ifPresent(u10);
        EditorMainFragment.A(this.a.a);
        EditorMainFragment.n0(this.a.a, bl2);
        ViewTreeObserver viewTreeObserver = EditorMainFragment.x((EditorMainFragment)this.a.a).m.getViewTreeObserver();
        object = new EditorMainFragment$g$e$a(this);
        viewTreeObserver.addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)object);
    }

    public void n(int n10, j j10) {
    }
}

