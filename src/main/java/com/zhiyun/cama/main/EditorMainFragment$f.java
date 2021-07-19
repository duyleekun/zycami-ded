/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 */
package com.zhiyun.cama.main;

import android.view.MotionEvent;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.zhiyun.cama.main.EditorMainFragment;
import com.zhiyun.cama.widget.EditorThumbnail$a;
import com.zhiyun.cama.widget.ScrollRecyclerViewImpl;
import com.zhiyun.common.util.Windows;
import d.v.c.b2.u;
import d.v.c.b2.w.e;
import d.v.c.i1.n2;
import d.v.c.i1.o;
import d.v.e.l.h2;
import d.v.e.l.m2;
import java.util.List;

public class EditorMainFragment$f
implements EditorThumbnail$a {
    public final /* synthetic */ ScrollRecyclerViewImpl a;
    public final /* synthetic */ n2 b;
    public final /* synthetic */ ItemTouchHelper c;
    public final /* synthetic */ EditorMainFragment d;

    public EditorMainFragment$f(EditorMainFragment editorMainFragment, ScrollRecyclerViewImpl scrollRecyclerViewImpl, n2 n22, ItemTouchHelper itemTouchHelper) {
        this.d = editorMainFragment;
        this.a = scrollRecyclerViewImpl;
        this.b = n22;
        this.c = itemTouchHelper;
    }

    private /* synthetic */ void b() {
        this.d.s1(false);
    }

    public void a(e e10, float f10, float f11) {
        ItemTouchHelper itemTouchHelper;
        EditorMainFragment$f editorMainFragment$f = this;
        EditorMainFragment.x0(this.d);
        Object object = this.a;
        int n10 = -((u)object).getCurScrollX();
        ((RecyclerView)object).scrollBy(n10, 0);
        object = EditorMainFragment.e0(this.d).y0();
        n10 = e10.b();
        int n11 = Windows.l(this.d.requireContext()).getWidth() / 2;
        float f12 = EditorMainFragment.x((EditorMainFragment)this.d).l.getScrollX();
        f12 = f10 - f12;
        float f13 = n11;
        float f14 = f12 + f13;
        f12 = h2.b(194.0f);
        float f15 = f11 + f12;
        int n12 = h2.b(60.0f);
        double d10 = f14;
        double d11 = n11;
        double d12 = n12;
        double d13 = n10;
        double d14 = 0.5;
        d13 = (d13 + d14) * d12;
        double d15 = d11 + d13;
        int n13 = n11;
        double d16 = d10 - d15;
        int n14 = (int)d16;
        n11 = object.size() - n10;
        d15 = d10;
        double d17 = (double)n11 - d14;
        d11 = d11 - (d12 *= d17) - d10;
        n11 = (int)d11;
        n2 n22 = this.b;
        f13 = 0.0f;
        n14 = Math.max(n14, 0);
        n14 = n13 + n14;
        n22.u(n14);
        n2 n23 = this.b;
        n11 = Math.max(n11, 0);
        n11 = n13 + n11;
        n23.v(n11);
        n23 = this.b;
        n23.l((List)object);
        this.b.notifyDataSetChanged();
        object = this.d;
        n14 = 1;
        ((EditorMainFragment)object).s1(n14 != 0);
        d10 = this.b.o();
        d13 = d13 + d10 - d15;
        int n15 = (int)d13;
        n11 = this.a.getCurScrollX();
        n15 -= n11;
        float f16 = 3.0f;
        n11 = h2.b(f16);
        ScrollRecyclerViewImpl scrollRecyclerViewImpl = this.a;
        n12 = 0;
        f12 = 0.0f;
        n22 = null;
        scrollRecyclerViewImpl.scrollBy(n15 += n11, 0);
        object = this.a;
        object = ((RecyclerView)object).findViewHolderForAdapterPosition(n10 += n14);
        if (object != null) {
            itemTouchHelper = this.c;
            itemTouchHelper.startDrag((RecyclerView$ViewHolder)object);
        }
        object = editorMainFragment$f.a;
        long l10 = System.currentTimeMillis();
        long l11 = System.currentTimeMillis();
        itemTouchHelper = MotionEvent.obtain((long)l10, (long)l11, (int)0, (float)f14, (float)f15, (int)0);
        object.dispatchTouchEvent((MotionEvent)itemTouchHelper);
        EditorMainFragment.z(editorMainFragment$f.d);
    }

    public /* synthetic */ void c() {
        this.b();
    }

    public void onStop() {
        o o10 = new o(this);
        m2.Y(10, o10);
        EditorMainFragment.A(this.d);
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        int n10;
        int n11 = motionEvent.getAction() & 0xFF;
        if (n11 == (n10 = 6)) {
            return;
        }
        ScrollRecyclerViewImpl scrollRecyclerViewImpl = this.a;
        long l10 = motionEvent.getDownTime();
        long l11 = motionEvent.getEventTime();
        int n12 = motionEvent.getAction();
        float f10 = motionEvent.getX();
        float f11 = EditorMainFragment.x((EditorMainFragment)this.d).l.getScrollX();
        f10 -= f11;
        f11 = motionEvent.getY();
        float f12 = h2.b(194.0f);
        int n13 = motionEvent.getMetaState();
        motionEvent = MotionEvent.obtain((long)l10, (long)l11, (int)n12, (float)f10, (float)(f11 += f12), (int)n13);
        scrollRecyclerViewImpl.dispatchTouchEvent(motionEvent);
    }
}

