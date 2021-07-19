/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.zhiyun.cama.sort;

import android.content.Context;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.ItemTouchHelper$Callback;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$ItemDecoration;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import com.zhiyun.cama.sort.EditorSortFragment$a;
import com.zhiyun.cama.sort.EditorSortFragment$b;
import d.v.c.b1.t.g;
import d.v.c.k1.a.r;
import d.v.c.q0.d;
import d.v.c.r1.c;
import d.v.c.r1.c$a;
import d.v.c.r1.e;
import d.v.c.w0.r7;
import d.v.e.l.h2;
import d.v.i0.b;
import java.util.List;

public class EditorSortFragment
extends d {
    private r7 j;
    private e k;
    private EditorSortFragment$b l;

    public static /* synthetic */ g A(EditorSortFragment editorSortFragment) {
        return editorSortFragment.g;
    }

    public static /* synthetic */ g B(EditorSortFragment editorSortFragment) {
        return editorSortFragment.g;
    }

    private c C(List object) {
        c c10 = new c((List)object);
        object = new EditorSortFragment$a(this);
        c10.a((c$a)object);
        return c10;
    }

    private void D() {
        Object object = this.k;
        Object object2 = this.g.C1();
        object = ((e)object).c((List)object2);
        e e10 = this.k;
        object2 = new d.v.c.r1.b((LifecycleOwner)this, e10);
        int n10 = h2.b(6.0f);
        Object object3 = this.j.b;
        int n11 = 4;
        Object object4 = new r(n11, n10, false);
        ((RecyclerView)object3).addItemDecoration((RecyclerView$ItemDecoration)object4);
        object3 = this.j.b;
        Context context = this.requireContext();
        object4 = new GridLayoutManager(context, n11);
        ((RecyclerView)object3).setLayoutManager((RecyclerView$LayoutManager)object4);
        object3 = this.k;
        object4 = this.requireContext();
        int n12 = h2.b(20.0f) * 2;
        n10 = ((e)object3).b((Context)object4, n11, n10, n12);
        ((d.v.c.r1.b)object2).o(n10);
        ((d.v.f.d.b)object2).l((List)object);
        this.j.b.setAdapter((RecyclerView$Adapter)object2);
        object = ((d.v.f.d.b)object2).d();
        object = this.C((List)object);
        object2 = new ItemTouchHelper((ItemTouchHelper$Callback)object);
        object = this.j.b;
        ((ItemTouchHelper)object2).attachToRecyclerView((RecyclerView)object);
    }

    public static /* synthetic */ EditorSortFragment$b x(EditorSortFragment editorSortFragment) {
        return editorSortFragment.l;
    }

    public static /* synthetic */ g y(EditorSortFragment editorSortFragment) {
        return editorSortFragment.g;
    }

    public static /* synthetic */ void z(EditorSortFragment editorSortFragment, long l10) {
        editorSortFragment.w(l10);
    }

    public int h() {
        return 2131558583;
    }

    public void i(ViewDataBinding object) {
        super.i((ViewDataBinding)object);
        object = (r7)object;
        this.j = object;
        this.k = object = (e)d.v.i0.b.a(this).get(e.class);
        this.l = object = new EditorSortFragment$b(this);
        this.j.z((EditorSortFragment$b)object);
        this.D();
    }

    public boolean s(int n10) {
        this.j.u().g(n10);
        return true;
    }
}

