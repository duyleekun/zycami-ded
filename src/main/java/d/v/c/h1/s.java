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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.GridLayoutManager$SpanSizeLookup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.zhiyun.cama.main.view.LoadMoreView;
import d.v.c.h1.k;
import d.v.c.h1.l;
import d.v.c.h1.r;
import d.v.c.h1.s$a;
import d.v.c.h1.t;
import d.v.c.n0.e;
import d.v.f.f.b;
import d.v.f.i.g;

public abstract class s
extends r {
    public static final int h = 0;
    public static final int i = 1;
    private boolean c = true;
    private String d;
    private int e = 100;
    private b f;
    private t g;

    private /* synthetic */ void j(int n10, Object object, View view) {
        this.f.a(view, n10, object);
    }

    private /* synthetic */ boolean l(int n10, Object object, View view) {
        this.g.a(view, n10, object);
        return true;
    }

    public abstract int g(int var1);

    public int getDefItemViewType(int n10) {
        return 0;
    }

    public int getItemCount() {
        boolean bl2 = this.c;
        if (bl2) {
            return super.getItemCount() + 1;
        }
        return super.getItemCount();
    }

    public final int getItemViewType(int n10) {
        int n11 = this.c;
        if (n11 != 0) {
            n11 = this.getItemCount();
            int n12 = 1;
            if (n10 == (n11 -= n12)) {
                return n12;
            }
        }
        return this.getDefItemViewType(n10);
    }

    public GridLayoutManager h(Context object, int n10, int n11) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager((Context)object, n11);
        gridLayoutManager.setOrientation(n10);
        object = new s$a(this, n11);
        gridLayoutManager.setSpanSizeLookup((GridLayoutManager$SpanSizeLookup)object);
        return gridLayoutManager;
    }

    public LinearLayoutManager i(Context context, int n10) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(n10);
        return linearLayoutManager;
    }

    public /* synthetic */ void k(int n10, Object object, View view) {
        this.j(n10, object, view);
    }

    public /* synthetic */ boolean m(int n10, Object object, View view) {
        return this.l(n10, object, view);
    }

    public abstract void n(e var1, int var2);

    public final void o(e object, int n10) {
        int n11;
        int n12 = this.getItemViewType(n10);
        if (n12 == (n11 = 1)) {
            object = (LoadMoreView)((RecyclerView$ViewHolder)object).itemView;
            String string2 = d.v.f.i.g.q((View)object, 2131953124);
            ((LoadMoreView)((Object)object)).setTipNoMoreText(string2);
            n10 = this.e;
            ((LoadMoreView)((Object)object)).setState(n10);
        } else {
            this.n((e)object, n10);
            n12 = this.getDefItemViewType(n10);
            if (n12 == 0) {
                Object object2;
                Object object3 = this.getItem(n10);
                if (object3 != null && (object2 = this.f) != null) {
                    object2 = ((RecyclerView$ViewHolder)object).itemView;
                    l l10 = new l(this, n10, object3);
                    object2.setOnClickListener((View.OnClickListener)l10);
                }
                if (object3 != null && (object2 = this.g) != null) {
                    object = ((RecyclerView$ViewHolder)object).itemView;
                    object2 = new k(this, n10, object3);
                    object.setOnLongClickListener((View.OnLongClickListener)object2);
                }
            }
        }
    }

    public e p(ViewGroup object, int n10) {
        int n11 = 1;
        if (n11 == n10) {
            object = DataBindingUtil.inflate(LayoutInflater.from((Context)object.getContext()), 2131558453, object, false);
            e e10 = new e((ViewDataBinding)object);
            return e10;
        }
        LayoutInflater layoutInflater = LayoutInflater.from((Context)object.getContext());
        n10 = this.g(n10);
        object = DataBindingUtil.inflate(layoutInflater, n10, object, false);
        e e11 = new e((ViewDataBinding)object);
        return e11;
    }

    public void q(int n10) {
        this.e = n10;
        n10 = this.getItemCount() + -1;
        this.notifyItemChanged(n10);
    }

    public void r(b b10) {
        this.f = b10;
    }

    public void s(t t10) {
        this.g = t10;
    }

    public void t(boolean bl2) {
        this.c = bl2;
    }

    public void u(String string2) {
        this.d = string2;
    }
}

