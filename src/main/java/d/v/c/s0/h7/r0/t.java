/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.view.View
 */
package d.v.c.s0.h7.r0;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import androidx.recyclerview.widget.RecyclerView$OnScrollListener;
import androidx.recyclerview.widget.SnapHelper;
import com.zhiyun.cama.list.CenterLayoutManager;
import d.v.c.s0.h7.m0;
import d.v.c.s0.h7.r0.g;
import d.v.c.s0.h7.r0.h;
import d.v.c.s0.h7.r0.i;
import d.v.c.s0.h7.r0.k;
import d.v.c.s0.h7.r0.s;
import d.v.c.s0.h7.r0.t$a;
import d.v.c.s0.h7.r0.t$b;
import d.v.c.s0.h7.r0.u;
import d.v.c.w0.wh;
import d.v.f.h.a;
import d.v.i0.b;
import d.v.j.e.i.f1;
import java.util.List;

public class t
extends a {
    private static final String o = "typeStr";
    private static final String p = "typeId";
    private m0 b;
    public s c;
    private u d;
    private f1 e;
    public wh f;
    private t$b g;
    private LinearSnapHelper h;
    private boolean i;
    private int j = -1;
    private CenterLayoutManager k;
    private int l;
    private String m;
    private long n;

    private /* synthetic */ void A(Integer object) {
        Object object2 = this.f.b;
        i i10 = new i(this, (Integer)object);
        object2.post((Runnable)i10);
        object = this.d.d;
        object2 = this.getViewLifecycleOwner();
        ((LiveData)object).removeObservers((LifecycleOwner)object2);
    }

    private void C() {
        Object object;
        Object object2 = this.d;
        int n10 = ((u)object2).b();
        int n11 = this.i;
        if (n11 != 0 && (object = this.g) != null && (n11 = ((t$b)object).getItemCount()) > n10 && (object = this.g.f(n10)) != null && (object = this.g.f(n10).getTemplateData()) != null) {
            long l10 = this.g.f(n10).getTemplateData().getId();
            f1 f12 = this.e;
            object2 = f12.j(l10);
            object = this.b;
            ((m0)object).e0((LiveData)object2);
        }
    }

    private void D(int n10) {
        RecyclerView recyclerView = this.f.b;
        int n11 = 1;
        recyclerView.scrollToPosition(n10 += n11);
        this.f.b.smoothScrollBy(n11, 0);
    }

    private void E(List object) {
        int n10;
        Object object2;
        object = this.d.k((List)object);
        Object object3 = this.f.b.getAdapter();
        if (object3 == null) {
            object3 = new t$b(this);
            this.g = object3;
            object2 = this.f.b;
            ((RecyclerView)object2).setAdapter((RecyclerView$Adapter)object3);
        }
        this.j = n10 = object.size();
        this.g.d((List)object);
        object3 = this.g;
        ((RecyclerView$Adapter)object3).notifyDataSetChanged();
        n10 = (int)(this.i ? 1 : 0);
        if (n10 != 0) {
            object3 = this.c.b;
            int n11 = this.j;
            if (n11 > 0) {
                n11 = 1;
            } else {
                n11 = 0;
                object2 = null;
            }
            object2 = n11 != 0;
            ((MutableLiveData)object3).setValue(object2);
        }
        object3 = this.c;
        object2 = this.m;
        long l10 = this.n;
        int n12 = ((s)object3).b((String)object2, l10, (List)object);
        object3 = this.d.d;
        object = n12;
        ((MutableLiveData)object3).setValue(object);
        this.C();
    }

    public static /* synthetic */ CenterLayoutManager j(t t10) {
        return t10.k;
    }

    public static /* synthetic */ LinearSnapHelper k(t t10) {
        return t10.h;
    }

    public static /* synthetic */ u l(t t10) {
        return t10.d;
    }

    public static /* synthetic */ t$b m(t t10) {
        return t10.g;
    }

    public static /* synthetic */ void n(t t10) {
        t10.C();
    }

    public static /* synthetic */ int o(t t10) {
        return t10.l;
    }

    public static /* synthetic */ boolean p(t t10) {
        return t10.i;
    }

    public static /* synthetic */ void q(t t10, int n10) {
        t10.D(n10);
    }

    public static Bundle r(String string2, long l10) {
        Bundle bundle = new Bundle();
        bundle.putString(o, string2);
        bundle.putLong(p, l10);
        return bundle;
    }

    private void s() {
        Object object = this.getArguments();
        if (object != null) {
            long l10;
            Object object2 = object.getString(o);
            this.m = object2;
            this.n = l10 = object.getLong(p);
            object = this.d.a;
            object2 = this.m;
            ((MutableLiveData)object).setValue(object2);
            object = this.d.b;
            long l11 = this.n;
            object2 = l11;
            ((MutableLiveData)object).setValue(object2);
        }
    }

    private void t() {
        MediatorLiveData mediatorLiveData = this.d.c;
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        g g10 = new g(this);
        mediatorLiveData.observe(lifecycleOwner, g10);
    }

    private void u() {
        this.f.b.setOnFlingListener(null);
        Context context = this.getContext();
        Object object = new CenterLayoutManager(context, 0, false);
        this.k = object;
        this.f.b.setLayoutManager((RecyclerView$LayoutManager)object);
        this.f.b.setItemAnimator(null);
        this.h = object = new LinearSnapHelper();
        Object object2 = this.f.b;
        ((SnapHelper)object).attachToRecyclerView((RecyclerView)object2);
        object = this.f.b;
        object2 = new t$a(this);
        ((RecyclerView)object).addOnScrollListener((RecyclerView$OnScrollListener)object2);
        object = this.f.b;
        object2 = new k(this);
        object.post((Runnable)object2);
    }

    public static /* synthetic */ void v(t t10, List list) {
        t10.E(list);
    }

    private /* synthetic */ void w() {
        int n10;
        this.l = n10 = this.f.b.getWidth();
        t$b t$b = this.g;
        if (t$b != null) {
            t$b.notifyDataSetChanged();
        }
    }

    private /* synthetic */ void y(Integer n10) {
        int n11 = n10;
        this.D(n11);
    }

    public /* synthetic */ void B(Integer n10) {
        this.A(n10);
    }

    public int h() {
        return 2131558789;
    }

    public void i(ViewDataBinding viewDataBinding) {
        super.i(viewDataBinding);
        viewDataBinding = (wh)viewDataBinding;
        this.f = viewDataBinding;
    }

    public void onAttach(Context object) {
        m0 m02;
        super.onAttach((Context)object);
        object = d.v.i0.b.c(this.requireActivity());
        ViewModelProvider viewModelProvider = d.v.i0.b.a(this);
        this.b = m02 = (m0)((ViewModelProvider)object).get(m0.class);
        this.c = object = (s)((ViewModelProvider)object).get(s.class);
        this.d = object = (u)viewModelProvider.get(u.class);
        this.e = object = (f1)viewModelProvider.get(f1.class);
    }

    public void onPause() {
        this.i = false;
        t$b t$b = this.g;
        if (t$b != null) {
            t$b.e(t$b);
        }
        super.onPause();
    }

    /*
     * WARNING - void declaration
     */
    public void onResume() {
        Object object;
        super.onResume();
        Object object2 = this.c.a;
        Object object3 = Boolean.FALSE;
        ((MutableLiveData)object2).setValue(object3);
        int bl2 = this.j;
        boolean bl3 = true;
        int n10 = -1;
        if (n10 != bl2) {
            void var3_6;
            object = this.c.b;
            if (bl2 > 0) {
                boolean bl4 = bl3;
            } else {
                boolean bl5 = false;
                object2 = null;
            }
            object2 = (boolean)var3_6;
            ((MutableLiveData)object).setValue(object2);
        }
        this.i = bl3;
        object2 = this.g;
        if (object2 != null) {
            ((RecyclerView$Adapter)object2).notifyDataSetChanged();
        }
        this.C();
        object2 = this.d.d;
        object3 = this.getViewLifecycleOwner();
        object = new h(this);
        ((LiveData)object2).observe((LifecycleOwner)object3, (Observer)object);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.s();
        this.u();
        this.t();
    }

    public /* synthetic */ void x() {
        this.w();
    }

    public /* synthetic */ void z(Integer n10) {
        this.y(n10);
    }
}

