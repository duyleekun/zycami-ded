/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnLongClickListener
 *  android.view.ViewGroup
 */
package d.v.c.h1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil$ItemCallback;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.GridLayoutManager$SpanSizeLookup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView$AdapterDataObserver;
import com.zhiyun.cama.main.view.LoadMoreView;
import d.v.c.h1.b;
import d.v.c.h1.c;
import d.v.c.h1.n;
import d.v.c.h1.o$a;
import d.v.c.n0.e;
import d.v.c.w0.f0;

public abstract class o
extends PagedListAdapter {
    private static final int d = 0;
    private static final int e = 1;
    private static final int f = 2;
    private int a = 100;
    private d.v.f.f.b b;
    private d.v.f.f.b c;

    public o(DiffUtil$ItemCallback diffUtil$ItemCallback) {
        super(diffUtil$ItemCallback);
    }

    private /* synthetic */ void e(int n10, int n11, View view) {
        int n12;
        if (n10 >= 0 && n10 < (n12 = this.b())) {
            d.v.f.f.b b10 = this.b;
            Object object = this.getItem(n10);
            b10.a(view, n11, object);
        } else {
            this.notifyDataSetChanged();
        }
    }

    private /* synthetic */ boolean g(int n10, int n11, View view) {
        int n12;
        if (n10 >= 0 && n10 < (n12 = this.b())) {
            d.v.f.f.b b10 = this.c;
            Object object = this.getItem(n10);
            b10.a(view, n11, object);
        } else {
            this.notifyDataSetChanged();
        }
        return true;
    }

    public abstract int a(int var1);

    public int b() {
        return this.getItemCount() + -2;
    }

    public GridLayoutManager c(Context object, int n10, int n11) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager((Context)object, n11);
        gridLayoutManager.setOrientation(n10);
        object = new o$a(this, n11);
        gridLayoutManager.setSpanSizeLookup((GridLayoutManager$SpanSizeLookup)object);
        return gridLayoutManager;
    }

    public LinearLayoutManager d(Context context, int n10) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(n10);
        return linearLayoutManager;
    }

    public /* synthetic */ void f(int n10, int n11, View view) {
        this.e(n10, n11, view);
    }

    public int getDefItemViewType(int n10) {
        return 0;
    }

    public int getItemCount() {
        return super.getItemCount() + 2;
    }

    public final int getItemViewType(int n10) {
        if (n10 == 0) {
            return 2;
        }
        int n11 = this.getItemCount();
        int n12 = 1;
        if (n10 == (n11 -= n12)) {
            return n12;
        }
        return this.getDefItemViewType(n10);
    }

    public /* synthetic */ boolean h(int n10, int n11, View view) {
        return this.g(n10, n11, view);
    }

    public abstract void i(e var1, int var2);

    public void j(e object, int n10) {
        int n11 = 2;
        int n12 = this.getItemViewType(n10);
        if (n11 != n12) {
            n11 = 1;
            n12 = this.getItemViewType(n10);
            if (n11 == n12) {
                object = ((f0)object.a).a;
                n10 = this.a;
                ((LoadMoreView)((Object)object)).setState(n10);
            } else {
                n12 = n10 + -1;
                this.i((e)object, n12);
                n11 = this.getItemViewType(n10);
                if (n11 == 0) {
                    Object object2 = this.getItem(n12);
                    if (object2 == null) {
                        return;
                    }
                    object2 = this.b;
                    if (object2 != null) {
                        object2 = ((e)object).a.getRoot();
                        b b10 = new b(this, n12, n10);
                        object2.setOnClickListener((View.OnClickListener)b10);
                    }
                    if ((object2 = this.c) != null) {
                        object = ((e)object).a.getRoot();
                        object2 = new c(this, n12, n10);
                        object.setOnLongClickListener((View.OnLongClickListener)object2);
                    }
                }
            }
        }
    }

    public e k(ViewGroup object, int n10) {
        int n11 = 2;
        if (n11 == n10) {
            object = DataBindingUtil.inflate(LayoutInflater.from((Context)object.getContext()), 2131558452, object, false);
            e e10 = new e((ViewDataBinding)object);
            return e10;
        }
        n11 = 1;
        if (n11 == n10) {
            object = DataBindingUtil.inflate(LayoutInflater.from((Context)object.getContext()), 2131558453, object, false);
            e e11 = new e((ViewDataBinding)object);
            return e11;
        }
        LayoutInflater layoutInflater = LayoutInflater.from((Context)object.getContext());
        n10 = this.a(n10);
        object = DataBindingUtil.inflate(layoutInflater, n10, object, false);
        e e12 = new e((ViewDataBinding)object);
        return e12;
    }

    public void l(int n10) {
        this.a = n10;
        n10 = this.getItemCount() + -2;
        this.notifyItemChanged(n10);
    }

    public void m(d.v.f.f.b b10) {
        this.b = b10;
    }

    public void n(d.v.f.f.b b10) {
        this.c = b10;
    }

    public void registerAdapterDataObserver(RecyclerView$AdapterDataObserver recyclerView$AdapterDataObserver) {
        n n10 = new n(recyclerView$AdapterDataObserver, 1);
        super.registerAdapterDataObserver(n10);
    }
}

