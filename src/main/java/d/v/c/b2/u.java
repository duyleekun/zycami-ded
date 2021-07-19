/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.View
 */
package d.v.c.b2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.util.Pair;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import androidx.recyclerview.widget.SimpleItemAnimator;
import d.v.c.b2.u$a;
import d.v.c.b2.u$b;
import java.util.Iterator;
import java.util.List;
import m.a.a;

public abstract class u
extends RecyclerView {
    public static final String j = "ScrollRecyclerView";
    private boolean a = false;
    private boolean b = false;
    private int c;
    private int d;
    private List e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;

    public u(Context object) {
        super((Context)object);
        super();
        this.e = object;
        this.t();
    }

    public u(Context object, AttributeSet attributeSet) {
        super((Context)object, attributeSet);
        super();
        this.e = object;
        this.t();
    }

    public u(Context object, AttributeSet attributeSet, int n10) {
        super((Context)object, attributeSet, n10);
        super();
        this.e = object;
        this.t();
    }

    public static /* synthetic */ void a(u u10) {
        u10.p();
    }

    public static /* synthetic */ void b(u u10) {
        u10.o();
    }

    public static /* synthetic */ List c(u u10) {
        return u10.e;
    }

    public static /* synthetic */ void d(u u10) {
        u10.n();
    }

    public static /* synthetic */ int e(u u10) {
        return u10.c;
    }

    public static /* synthetic */ int f(u u10, int n10) {
        u10.c = n10;
        return n10;
    }

    public static /* synthetic */ int g(u u10) {
        return u10.d;
    }

    public static /* synthetic */ int h(u u10, int n10) {
        u10.d = n10;
        return n10;
    }

    public static /* synthetic */ boolean i(u u10, boolean bl2) {
        u10.f = bl2;
        return bl2;
    }

    public static /* synthetic */ boolean j(u u10, boolean bl2) {
        u10.g = bl2;
        return bl2;
    }

    public static /* synthetic */ boolean k(u u10, boolean bl2) {
        u10.h = bl2;
        return bl2;
    }

    public static /* synthetic */ boolean l(u u10, boolean bl2) {
        u10.i = bl2;
        return bl2;
    }

    public static /* synthetic */ boolean m(u u10) {
        return u10.a;
    }

    private void n() {
        boolean bl2;
        boolean bl3;
        this.b = bl3 = true;
        Iterator iterator2 = this.e.iterator();
        while (bl2 = iterator2.hasNext()) {
            u$b u$b = (u$b)iterator2.next();
            u$b.d();
        }
    }

    private void o() {
        boolean bl2;
        boolean bl3;
        this.a = bl3 = true;
        Iterator iterator2 = this.e.iterator();
        while (bl2 = iterator2.hasNext()) {
            u$b u$b = (u$b)iterator2.next();
            u$b.c();
        }
    }

    private void p() {
        boolean bl2;
        this.b = false;
        this.a = false;
        Iterator iterator2 = this.e.iterator();
        while (bl2 = iterator2.hasNext()) {
            u$b u$b = (u$b)iterator2.next();
            u$b.a();
        }
    }

    private void t() {
        u$a u$a = new u$a(this);
        this.addOnScrollListener(u$a);
        this.getItemAnimator().setChangeDuration(0L);
        ((SimpleItemAnimator)this.getItemAnimator()).setSupportsChangeAnimations(false);
        this.setItemAnimator(null);
    }

    public boolean A(int n10) {
        RecyclerView$LayoutManager recyclerView$LayoutManager = this.getLayoutManager();
        int n11 = recyclerView$LayoutManager instanceof LinearLayoutManager;
        boolean bl2 = false;
        if (n11 != 0) {
            recyclerView$LayoutManager = (LinearLayoutManager)recyclerView$LayoutManager;
            n11 = ((LinearLayoutManager)recyclerView$LayoutManager).findLastVisibleItemPosition();
            int n12 = ((LinearLayoutManager)recyclerView$LayoutManager).findFirstVisibleItemPosition();
            if (n10 >= n12 && n10 <= n11) {
                bl2 = true;
            }
        }
        return bl2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean B() {
        int n10;
        View view;
        RecyclerView$LayoutManager recyclerView$LayoutManager = this.getLayoutManager();
        int n11 = recyclerView$LayoutManager instanceof LinearLayoutManager;
        int n12 = 1;
        if (n11 == 0) return 0 != 0;
        n11 = ((LinearLayoutManager)(recyclerView$LayoutManager = (LinearLayoutManager)recyclerView$LayoutManager)).findFirstVisibleItemPosition();
        if (n11 == 0 && (n11 = (view = this.getChildAt(0)).getRight()) > (n10 = this.getWidth() / 2)) {
            recyclerView$LayoutManager = this.getChildAt(0);
            int n13 = recyclerView$LayoutManager.getRight();
            n11 = this.getWidth() / 2;
            this.scrollBy(n13 -= n11, 0);
            return n12 != 0;
        } else {
            int n14 = ((LinearLayoutManager)recyclerView$LayoutManager).findLastVisibleItemPosition();
            if (n14 != (n11 = this.getItemCount() - n12)) return 0 != 0;
            n14 = this.getChildCount() - n12;
            recyclerView$LayoutManager = this.getChildAt(n14);
            if ((n14 = recyclerView$LayoutManager.getLeft()) >= (n11 = this.getWidth() / 2)) return 0 != 0;
            n14 = this.getChildCount() - n12;
            recyclerView$LayoutManager = this.getChildAt(n14);
            n14 = recyclerView$LayoutManager.getLeft();
            n11 = this.getWidth() / 2;
            this.scrollBy(n14 -= n11, 0);
        }
        return n12 != 0;
    }

    public void C(int n10, boolean bl2) {
        View view;
        if (n10 >= 0 && (view = this.q(n10)) != null) {
            if (bl2) {
                n10 = view.getLeft();
                int n11 = this.getWidth() / 2;
                this.scrollBy(n10 -= n11, 0);
            } else {
                n10 = view.getRight();
                int n12 = this.getWidth() / 2;
                this.scrollBy(n10 -= n12, 0);
            }
        }
    }

    public void D(boolean n10, int n11, int n12, int n13) {
        View view = this.q(n11);
        if (view != null) {
            int n14 = view.getLeft() + n12;
            n11 = view.getRight() - n12;
            n12 = 0;
            if (n10 != 0) {
                if (n14 < n13) {
                    this.scrollBy(n14 -= n13, 0);
                } else {
                    n10 = this.getWidth() - n13;
                    if (n14 > n10) {
                        n10 = this.getWidth() - n13;
                        this.scrollBy(n14 -= n10, 0);
                    }
                }
            } else {
                n10 = this.getWidth() - n13;
                if (n11 > n10) {
                    n10 = this.getWidth() - n13;
                    this.scrollBy(n11 -= n10, 0);
                } else if (n11 < n13) {
                    this.scrollBy(n11 -= n13, 0);
                }
            }
        }
    }

    public void E(int n10) {
        Object[] objectArray = new Object[2];
        Integer n11 = n10;
        objectArray[0] = n11;
        n11 = this.c;
        objectArray[1] = n11;
        m.a.a.b("scrollToX, x: %s  mScrollX: %s", objectArray);
        int n12 = this.c;
        this.scrollBy(n10 -= n12, 0);
    }

    public void F(int n10) {
        int n11 = this.getWidth() / 2;
        this.G(n10, n11);
    }

    public void G(int n10, int n11) {
        this.E(n10 += n11);
    }

    public int getCurScrollX() {
        return this.c;
    }

    public int getCurScrollY() {
        return this.d;
    }

    public abstract int getFooterLayoutCount();

    public abstract int getHeaderLayoutCount();

    public int getItemCount() {
        RecyclerView$Adapter recyclerView$Adapter = this.getAdapter();
        if (recyclerView$Adapter != null) {
            return recyclerView$Adapter.getItemCount();
        }
        return 0;
    }

    public int getItemLayoutCount() {
        int n10 = this.getItemCount();
        int n11 = this.getFooterLayoutCount();
        n10 -= n11;
        n11 = this.getHeaderLayoutCount();
        return n10 - n11;
    }

    public List getOnHandScrollListenerList() {
        return this.e;
    }

    public View q(int n10) {
        RecyclerView$LayoutManager recyclerView$LayoutManager = this.getLayoutManager();
        int n11 = recyclerView$LayoutManager instanceof LinearLayoutManager;
        if (n11 != 0) {
            n11 = this.getHeaderLayoutCount();
            return recyclerView$LayoutManager.findViewByPosition(n10 += n11);
        }
        return null;
    }

    public Pair r(int n10) {
        int n11;
        Object object = null;
        Object object2 = null;
        for (int i10 = 0; i10 < (n11 = this.getChildCount()); ++i10) {
            View view = this.getChildAt(i10);
            int n12 = view.getWidth();
            if (n12 <= 0) continue;
            n12 = view.getLeft();
            int n13 = view.getRight();
            n11 = this.getChildLayoutPosition(view);
            if (n12 > n10 || n13 <= n10) continue;
            object2 = new Object[2];
            Integer n14 = n11;
            object2[0] = n14;
            object2[1] = object = Integer.valueOf(n10 -= n12);
            m.a.a.b("getCurScreenChildPosition, position: %s  offset = %s", object2);
            object2 = n11;
            Integer n15 = n10;
            object = new Pair(object2, n15);
            return object;
        }
        return null;
    }

    public Pair s(int n10) {
        Object object = this.r(n10);
        if (object != null) {
            Integer n11 = (Integer)((Pair)object).first;
            int n12 = n11;
            int n13 = this.getHeaderLayoutCount();
            if ((n12 -= n13) >= 0 && n12 < (n13 = this.getItemLayoutCount())) {
                n11 = n12;
                object = ((Pair)object).second;
                Pair pair = new Pair(n11, object);
                return pair;
            }
            n13 = this.getItemLayoutCount();
            if (n12 == n13 && (n10 = ((Integer)(object = (Integer)((Pair)object).second)).intValue()) == 0) {
                Integer n14 = n12 += -1;
                n11 = this.q(n12).getWidth();
                object = new Pair(n14, n11);
                return object;
            }
        }
        return null;
    }

    public void scrollTo(int n10, int n11) {
        int n12 = this.c;
        n10 -= n12;
        n12 = this.d;
        this.scrollBy(n10, n11 -= n12);
    }

    public void setOnHandScrollListener(u$b u$b) {
        this.e.add(u$b);
    }

    public boolean u() {
        return this.i;
    }

    public boolean v() {
        return this.f;
    }

    public boolean w() {
        return this.g;
    }

    public boolean x() {
        return this.h;
    }

    public boolean y() {
        return this.a;
    }

    public boolean z() {
        return this.b;
    }
}

