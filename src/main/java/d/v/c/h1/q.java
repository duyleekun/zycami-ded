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
import com.zhiyun.editortemplate.data.resource.Status;
import d.v.c.h1.a;
import d.v.c.h1.h;
import d.v.c.h1.i;
import d.v.c.h1.j;
import d.v.c.h1.q$a;
import d.v.c.h1.q$b;
import d.v.c.h1.r;
import d.v.c.h1.s;
import d.v.c.w0.b0;
import d.v.c.x1.l;
import d.v.j.e.h.k;
import java.util.List;

public abstract class q
extends d.v.f.h.a {
    public b0 b;
    public View.OnClickListener c = null;
    public s d;
    private boolean e = false;
    private boolean f = true;

    private void D(boolean bl2) {
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

    private void K() {
        this.b.f.a();
    }

    public static /* synthetic */ boolean j(q q10, RecyclerView recyclerView) {
        return q10.v(recyclerView);
    }

    private void o(Status object) {
        int[] nArray = q$b.a;
        int n10 = ((Enum)object).ordinal();
        n10 = nArray[n10];
        int n11 = 1;
        int n12 = 100;
        if (n10 != n11) {
            n11 = 2;
            if (n10 != n11 && n10 != (n11 = 3)) {
                n11 = 4;
                if (n10 == n11) {
                    object = this.b.e;
                    ((SwipeRefreshLayout)object).setRefreshing(false);
                    n10 = (int)(this.f ? 1 : 0);
                    if (n10 != 0) {
                        this.d.q(n12);
                        object = this.b.f;
                        ((StatusView)((Object)object)).d();
                    } else {
                        object = this.d;
                        n11 = 102;
                        ((s)object).q(n11);
                        this.K();
                    }
                }
            } else {
                object = this.b.e;
                ((SwipeRefreshLayout)object).setRefreshing(false);
                n10 = (int)(this.f ? 1 : 0);
                if (n10 != 0) {
                    this.d.q(n12);
                    object = this.b.f;
                    ((StatusView)((Object)object)).c();
                } else {
                    object = this.d;
                    n11 = 103;
                    ((s)object).q(n11);
                    this.K();
                }
            }
        } else {
            n10 = (int)(this.f ? 1 : 0);
            if (n10 != 0) {
                this.d.q(n12);
                object = this.b.f;
                ((StatusView)((Object)object)).e();
            } else {
                object = this.d;
                n11 = 101;
                ((s)object).q(n11);
            }
        }
    }

    private void p(k object) {
        int n10;
        if (object == null) {
            return;
        }
        Object object2 = object.c;
        if (object2 != null && (n10 = (object2 = (List)object2).size()) > 0) {
            n10 = 0;
            object2 = null;
        } else {
            n10 = 1;
        }
        this.f = n10;
        object2 = this.d;
        List list = (List)object.c;
        ((r)object2).f(list);
        object = object.a;
        this.o((Status)((Object)object));
    }

    private void q() {
        Object object;
        boolean bl2 = this.e;
        if (bl2) {
            bl2 = false;
            this.e = false;
            object = this.b.f;
            ((StatusView)((Object)object)).e();
        }
        if ((object = this.d) == null) {
            object = this.k();
            this.d = object;
            object = this.b.d;
            Object object2 = this.n();
            ((RecyclerView)object).setLayoutManager((RecyclerView$LayoutManager)object2);
            object = this.b.d;
            object2 = this.d;
            ((RecyclerView)object).setAdapter((RecyclerView$Adapter)object2);
            object = this.m();
            if (object != null) {
                object2 = this.b.d;
                ((RecyclerView)object2).addItemDecoration((RecyclerView$ItemDecoration)object);
            }
            this.b.d.setItemAnimator(null);
            object = this.l();
            object2 = this.getViewLifecycleOwner();
            h h10 = new h(this);
            ((LiveData)object).observe((LifecycleOwner)object2, h10);
        }
    }

    private void r() {
        Object object = this.b.e;
        Object object2 = new a(this);
        ((SwipeRefreshLayout)object).setOnRefreshListener((SwipeRefreshLayout$OnRefreshListener)object2);
        object = this.b.f;
        object2 = new j(this);
        ((StatusView)((Object)object)).setOnClickErrorListener((View.OnClickListener)object2);
        object = this.b.d;
        object2 = new q$a(this);
        ((RecyclerView)object).addOnScrollListener((RecyclerView$OnScrollListener)object2);
        object = this.b.b;
        object2 = new i(this);
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
        this.B();
        return n11 != 0;
    }

    public static /* synthetic */ void w(q q10, k k10) {
        q10.p(k10);
    }

    private /* synthetic */ void x(View view) {
        this.b.f.e();
        this.C();
    }

    private /* synthetic */ void z(View object) {
        View.OnClickListener onClickListener = this.c;
        if (onClickListener != null) {
            onClickListener.onClick(object);
        } else {
            boolean bl2 = l.g(object);
            if (!bl2) {
                object = this.getActivity();
                ActivityCompat.finishAfterTransition((Activity)object);
            }
        }
    }

    public /* synthetic */ void A(View view) {
        this.z(view);
    }

    public abstract void B();

    public abstract void C();

    public void E(int n10) {
        this.b.f.setEmptyImage(n10);
    }

    public void F(String string2) {
        this.b.f.setEmptyText(string2);
    }

    public void G(View.OnClickListener onClickListener) {
        this.c = onClickListener;
    }

    public void H(String string2) {
        this.b.g.setText((CharSequence)string2);
    }

    public void I() {
        TextView textView = this.b.g;
        Typeface typeface = textView.getTypeface();
        textView.setTypeface(typeface, 1);
    }

    public void J(boolean n10) {
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

    public abstract s k();

    public abstract LiveData l();

    public abstract RecyclerView$ItemDecoration m();

    public abstract RecyclerView$LayoutManager n();

    public void onAttach(Context context) {
        super.onAttach(context);
        this.t();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.e = true;
        this.C();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        boolean bl2 = this.u();
        this.D(bl2);
        this.s();
        this.q();
        this.r();
    }

    public abstract void s();

    public abstract void t();

    public boolean u() {
        return false;
    }

    public /* synthetic */ void y(View view) {
        this.x(view);
    }
}

