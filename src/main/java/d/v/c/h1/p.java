/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.graphics.Typeface
 *  android.os.Bundle
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.FrameLayout
 *  android.widget.TextView
 */
package d.v.c.h1;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.app.ActivityCompat;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$ItemDecoration;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import androidx.recyclerview.widget.RecyclerView$OnScrollListener;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout$OnRefreshListener;
import com.zhiyun.account.widget.StatusView;
import com.zhiyun.cama.data.PagingRequestHelper$Status;
import com.zhiyun.cama.data.PagingRequestHelper$b;
import d.v.c.h1.d;
import d.v.c.h1.e;
import d.v.c.h1.f;
import d.v.c.h1.g;
import d.v.c.h1.m;
import d.v.c.h1.o;
import d.v.c.h1.p$a;
import d.v.c.h1.p$b;
import d.v.c.w0.b0;
import d.v.c.x1.l;
import m.a.a;

public abstract class p
extends d.v.f.h.a {
    public b0 b;
    public o c;
    private boolean d = false;
    private boolean e = true;

    private /* synthetic */ void B(View object) {
        boolean bl2 = l.g(object);
        if (!bl2) {
            object = this.getActivity();
            ActivityCompat.finishAfterTransition((Activity)object);
        }
    }

    private void F(boolean bl2) {
        int n10 = -16777216;
        int n11 = -1;
        if (bl2) {
            StatusView statusView = this.b.f;
            int n12 = 2131231805;
            statusView.setErrorImage(n12);
            this.b.g.setTextColor(n11);
            statusView = this.b.b;
            n11 = 2131231369;
            statusView.setImageResource(n11);
        } else {
            StatusView statusView = this.b.f;
            int n13 = 2131231806;
            statusView.setErrorImage(n13);
            this.b.g.setTextColor(n10);
            statusView = this.b.b;
            statusView.setImageResource(2131231726);
            n10 = n11;
        }
        this.b.c.setBackgroundColor(n10);
        this.b.f.setBackgroundColor(n10);
    }

    private void L() {
        this.b.f.a();
    }

    public static /* synthetic */ boolean j(p p10, RecyclerView recyclerView) {
        return p10.v(recyclerView);
    }

    private void p(PagingRequestHelper$b object) {
        Object object2 = p$b.a;
        PagingRequestHelper$Status pagingRequestHelper$Status = ((PagingRequestHelper$b)object).a;
        int n10 = pagingRequestHelper$Status.ordinal();
        int n11 = object2[n10];
        if (n11 != (n10 = 1)) {
            n10 = 2;
            if (n11 != n10) {
                n10 = 3;
                if (n11 == n10) {
                    object2 = new StringBuilder;
                    ((StringBuilder)object2)();
                    n10 = ((PagingRequestHelper$b)object).b;
                    ((StringBuilder)object2).append(n10);
                    object = ((PagingRequestHelper$b)object).c;
                    ((StringBuilder)object2).append((String)object);
                    object = ((StringBuilder)object2).toString();
                    object2 = new Object[]{};
                    a.b((String)object, (Object[])object2);
                    this.b.e.setRefreshing(false);
                    object = this.c;
                    n11 = 102;
                    ((o)object).l(n11);
                    boolean bl2 = this.e;
                    if (bl2) {
                        object = this.b.f;
                        ((StatusView)((Object)object)).d();
                    } else {
                        this.L();
                    }
                }
            } else {
                this.b.e.setRefreshing(false);
                object = this.c;
                n11 = 100;
                ((o)object).l(n11);
                boolean bl3 = this.e;
                if (bl3) {
                    object = this.b.f;
                    ((StatusView)((Object)object)).c();
                } else {
                    this.L();
                }
            }
        } else {
            object = this.c;
            n11 = 101;
            ((o)object).l(n11);
            boolean bl4 = this.e;
            if (bl4) {
                object = this.b.f;
                ((StatusView)((Object)object)).e();
            }
        }
    }

    private void q() {
        Object object;
        boolean bl2 = this.d;
        if (bl2) {
            bl2 = false;
            this.d = false;
            object = this.b.f;
            ((StatusView)((Object)object)).e();
        }
        if ((object = this.c) == null) {
            object = this.k();
            this.c = object;
        }
        object = this.b.d;
        Object object2 = this.n();
        ((RecyclerView)object).setLayoutManager((RecyclerView$LayoutManager)object2);
        object = this.b.d;
        object2 = this.c;
        ((RecyclerView)object).setAdapter((RecyclerView$Adapter)object2);
        object = this.m();
        if (object != null) {
            object2 = this.b.d;
            ((RecyclerView)object2).addItemDecoration((RecyclerView$ItemDecoration)object);
        }
        this.b.d.setItemAnimator(null);
        object = this.l();
        object2 = this.getViewLifecycleOwner();
        Observer observer = new g(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.o();
        object2 = this.getViewLifecycleOwner();
        observer = new d(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
    }

    private void r() {
        Object object = this.b.e;
        Object object2 = new m(this);
        ((SwipeRefreshLayout)object).setOnRefreshListener((SwipeRefreshLayout$OnRefreshListener)object2);
        object = this.b.f;
        object2 = new f(this);
        ((StatusView)((Object)object)).setOnClickErrorListener((View.OnClickListener)object2);
        object = this.b.d;
        object2 = new p$a(this);
        ((RecyclerView)object).addOnScrollListener((RecyclerView$OnScrollListener)object2);
        object = this.b.b;
        object2 = new e(this);
        object.setOnClickListener((View.OnClickListener)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean v(RecyclerView object) {
        int n10 = ((RecyclerView)object).computeVerticalScrollOffset();
        int n11 = 1;
        if (n10 <= 0) return 0 != 0;
        RecyclerView$LayoutManager recyclerView$LayoutManager = ((RecyclerView)object).getLayoutManager();
        boolean bl2 = recyclerView$LayoutManager instanceof LinearLayoutManager;
        if (bl2) {
            recyclerView$LayoutManager = (LinearLayoutManager)recyclerView$LayoutManager;
            n10 = ((LinearLayoutManager)recyclerView$LayoutManager).findLastVisibleItemPosition();
        } else {
            bl2 = recyclerView$LayoutManager instanceof GridLayoutManager;
            if (bl2) {
                recyclerView$LayoutManager = (GridLayoutManager)recyclerView$LayoutManager;
                n10 = ((LinearLayoutManager)recyclerView$LayoutManager).findLastVisibleItemPosition();
            } else {
                recyclerView$LayoutManager = (StaggeredGridLayoutManager)recyclerView$LayoutManager;
                bl2 = false;
                int[] nArray = ((StaggeredGridLayoutManager)recyclerView$LayoutManager).findLastVisibleItemPositions(null);
                n10 = ((StaggeredGridLayoutManager)recyclerView$LayoutManager).getSpanCount() - n11;
                n10 = nArray[n10];
            }
        }
        object = ((RecyclerView)object).getAdapter();
        int n12 = ((RecyclerView$Adapter)object).getItemCount() - n11;
        if (n10 != n12) return 0 != 0;
        this.D();
        return n11 != 0;
    }

    public static /* synthetic */ void w(p p10, PagingRequestHelper$b pagingRequestHelper$b) {
        p10.p(pagingRequestHelper$b);
    }

    private /* synthetic */ void x(PagedList pagedList) {
        int n10;
        n10 = pagedList != null && (n10 = pagedList.size()) > 0 ? 0 : 1;
        this.e = n10;
        this.c.submitList(pagedList);
    }

    private /* synthetic */ void z(View view) {
        this.b.f.e();
        this.E();
    }

    public /* synthetic */ void A(View view) {
        this.z(view);
    }

    public /* synthetic */ void C(View view) {
        this.B(view);
    }

    public abstract void D();

    public abstract void E();

    public void G(int n10) {
        this.b.f.setEmptyImage(n10);
    }

    public void H(String string2) {
        this.b.f.setEmptyText(string2);
    }

    public void I(String string2) {
        this.b.g.setText((CharSequence)string2);
    }

    public void J() {
        TextView textView = this.b.g;
        Typeface typeface = textView.getTypeface();
        textView.setTypeface(typeface, 1);
    }

    public void K(boolean n10) {
        FrameLayout frameLayout = this.b.a;
        n10 = n10 != 0 ? 0 : 8;
        frameLayout.setVisibility(n10);
    }

    public int h() {
        return 2131558451;
    }

    public void i(ViewDataBinding viewDataBinding) {
        super.i(viewDataBinding);
        viewDataBinding = (b0)viewDataBinding;
        this.b = viewDataBinding;
        ((b0)viewDataBinding).a.setVisibility(8);
    }

    public abstract o k();

    public abstract LiveData l();

    public abstract RecyclerView$ItemDecoration m();

    public abstract RecyclerView$LayoutManager n();

    public abstract LiveData o();

    public void onAttach(Context context) {
        super.onAttach(context);
        this.t();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.d = true;
        this.E();
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.c = null;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        boolean bl2 = this.u();
        this.F(bl2);
        this.s();
        this.q();
        this.r();
    }

    public abstract void s();

    public abstract void t();

    public boolean u() {
        return false;
    }

    public /* synthetic */ void y(PagedList pagedList) {
        this.x(pagedList);
    }
}

