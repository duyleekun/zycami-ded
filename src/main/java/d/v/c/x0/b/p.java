/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 */
package d.v.c.x0.b;

import android.content.Context;
import android.os.Bundle;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import com.zhiyun.account.widget.StatusView;
import com.zhiyun.cama.widget.base.BaseResourceListView;
import com.zhiyun.cama.widget.base.BaseResourceListView$ResourceType;
import com.zhiyun.editorinterface.decoration.DecorationType;
import d.v.c.k1.a.r;
import d.v.c.w0.j9;
import d.v.c.x0.a;
import d.v.c.x0.b.d;
import d.v.c.x0.b.e;
import d.v.c.x0.b.f;
import d.v.c.x0.b.g;
import d.v.c.x0.b.h;
import d.v.c.x0.b.i;
import d.v.c.x0.b.j;
import d.v.c.x0.b.o;
import d.v.c.x0.b.p$a;
import d.v.c.x0.b.p$b;
import d.v.c.x0.b.q;
import d.v.c.x0.b.s;
import d.v.e.l.h2;
import d.v.g0.k$a;
import d.v.g0.k$b;
import d.v.h.d.c;
import d.v.i0.b;
import d.v.j.g.z;
import java.util.List;

public class p
extends d.v.c.q0.d {
    private static final String r = "type_id";
    private static final String s = "replace";
    private j9 j;
    private q k;
    private s l;
    private d.v.c.v0.i m;
    private z n;
    private long o;
    private a p;
    private boolean q;

    public static /* synthetic */ d.v.c.b1.t.g A(p p10) {
        return p10.g;
    }

    public static /* synthetic */ s B(p p10) {
        return p10.l;
    }

    public static /* synthetic */ j9 C(p p10) {
        return p10.j;
    }

    public static /* synthetic */ d.v.c.v0.i D(p p10) {
        return p10.m;
    }

    public static /* synthetic */ long E(p p10) {
        return p10.o;
    }

    public static p F(long l10, boolean bl2) {
        p p10 = new p();
        Bundle bundle = new Bundle();
        bundle.putLong(r, l10);
        bundle.putBoolean(s, bl2);
        p10.setArguments(bundle);
        return p10;
    }

    private void G() {
        Object object;
        Object object2 = this.getArguments();
        if (object2 != null) {
            boolean bl2;
            long l10;
            this.o = l10 = object2.getLong(r);
            object = s;
            this.q = bl2 = object2.getBoolean((String)object);
            this.j.b.e();
            object2 = this.k;
            l10 = this.o;
            int n10 = (int)l10;
            ((q)object2).u(n10);
        }
        object2 = this.j.a;
        object = this.k;
        ((BaseResourceListView)object2).b(this, (d.v.c.b2.v.b)object);
        object2 = this.j.a;
        object = BaseResourceListView$ResourceType.RESOURCE_TYPE_STICKER;
        ((BaseResourceListView)object2).setResourceType((BaseResourceListView$ResourceType)((Object)object));
        this.p = object2 = new a();
    }

    private void H() {
        MutableLiveData mutableLiveData = this.k.f();
        Object object = this.getViewLifecycleOwner();
        Observer observer = new h(this);
        mutableLiveData.observe((LifecycleOwner)object, observer);
        mutableLiveData = this.g.Y0();
        object = this.getViewLifecycleOwner();
        observer = new g(this);
        mutableLiveData.observe((LifecycleOwner)object, observer);
        mutableLiveData = this.k.v();
        object = this.getViewLifecycleOwner();
        observer = new j(this);
        mutableLiveData.observe((LifecycleOwner)object, observer);
        mutableLiveData = this.k.g();
        object = this.getViewLifecycleOwner();
        observer = new d(this);
        mutableLiveData.observe((LifecycleOwner)object, observer);
        mutableLiveData = this.k.d();
        object = new f(this);
        mutableLiveData.observe(this, (Observer)object);
    }

    private void I() {
        r r10;
        int n10 = h2.b(8.0f);
        BaseResourceListView baseResourceListView = this.j.a;
        int n11 = h2.b(6.0f);
        int n12 = h2.b(20.0f);
        Object object = r10;
        r10 = new r(4, n10, false, n11, n12);
        baseResourceListView.addItemDecoration(r10);
        baseResourceListView = this.j.a;
        Context context = this.requireContext();
        object = new GridLayoutManager(context, 4);
        baseResourceListView.setLayoutManager((RecyclerView$LayoutManager)object);
    }

    private /* synthetic */ void J(d.v.c.b2.w.a object) {
        if (object == null) {
            return;
        }
        Object object2 = this.n;
        boolean bl2 = ((z)object2).f();
        if (bl2) {
            object2 = d.v.f.i.g.o(this.getResources(), 2131951893);
            Object object3 = this.getContext();
            Object object4 = new k$b((Context)object3);
            object2 = (k$b)((k$a)object4).n((String)object2);
            object4 = new i(this);
            object2 = (k$b)((k$a)object2).p((d.v.f.f.a)object4);
            int n10 = 2131951892;
            object3 = new e(this, (d.v.c.b2.w.a)object);
            object = ((k$b)((k$b)((k$a)object2).v(n10, (d.v.f.f.a)object3)).s()).b();
            object2 = this.getChildFragmentManager();
            object4 = this.getClass().getSimpleName();
            ((DialogFragment)object).show((FragmentManager)object2, (String)object4);
        } else {
            object2 = this.k;
            Context context = this.requireContext();
            ((q)object2).o(context, (d.v.c.b2.w.a)object);
        }
    }

    private /* synthetic */ void L(DecorationType decorationType) {
        DecorationType decorationType2 = DecorationType.IMAGE_PASTER;
        if (decorationType != decorationType2 && decorationType != (decorationType2 = DecorationType.GIF_PASTER)) {
            return;
        }
        this.k.H(-1);
    }

    private /* synthetic */ void N(List list) {
        boolean bl2 = d.v.j.b.f(list);
        if (bl2) {
            return;
        }
        this.m.f(false);
        this.j.a.setData(list);
        boolean bl3 = list.isEmpty();
        this.Y(bl3);
    }

    private /* synthetic */ void P(Integer n10) {
        int n11;
        int n12;
        if (n10 != null && (n12 = n10.intValue()) != (n11 = -1)) {
            BaseResourceListView baseResourceListView = this.j.a;
            int n13 = n10;
            baseResourceListView.smoothScrollToPosition(n13);
        }
    }

    private /* synthetic */ void R(Integer object) {
        int n10;
        int n11 = (Integer)object;
        if (n11 == (n10 = -1)) {
            return;
        }
        Object object2 = this.k;
        int n12 = (Integer)object;
        if ((object = ((q)object2).t(n12)) == null) {
            return;
        }
        q q10 = this.k;
        object2 = this.g.W0();
        n11 = (int)(q10.m((c)object2, (o)object) ? 1 : 0);
        if (n11 != 0) {
            return;
        }
        this.X((o)object);
    }

    private /* synthetic */ void T(DialogFragment dialogFragment) {
        this.n.i(false);
    }

    private /* synthetic */ void V(d.v.c.b2.w.a a10, DialogFragment object) {
        this.n.i(true);
        object = this.k;
        Context context = this.requireContext();
        ((q)object).o(context, a10);
    }

    private void X(o o10) {
        Object object = this.p;
        Object object2 = this.getChildFragmentManager();
        object.q((FragmentManager)object2);
        d.v.c.b1.t.g g10 = this.g;
        DecorationType decorationType = o10.R();
        long l10 = o10.V();
        String string2 = o10.U();
        object = o10.R();
        object2 = DecorationType.GIF_PASTER;
        object = object == object2 ? o10.S() : o10.I();
        float f10 = o10.T();
        boolean bl2 = this.q;
        p$a p$a = new p$a(this);
        g10.Q2(decorationType, l10, string2, (String)object, f10, bl2, p$a);
    }

    private void Y(boolean bl2) {
        Object object;
        if (bl2) {
            object = this.j.b;
            ((StatusView)((Object)object)).d();
        } else {
            object = this.j.b;
            ((StatusView)((Object)object)).a();
        }
        object = this.m;
        ((d.v.c.v0.i)object).g(bl2 ^= true);
    }

    public static /* synthetic */ d.v.c.b1.t.g x(p p10) {
        return p10.g;
    }

    public static /* synthetic */ q y(p p10) {
        return p10.k;
    }

    public static /* synthetic */ a z(p p10) {
        return p10.p;
    }

    public /* synthetic */ void K(d.v.c.b2.w.a a10) {
        this.J(a10);
    }

    public /* synthetic */ void M(DecorationType decorationType) {
        this.L(decorationType);
    }

    public /* synthetic */ void O(List list) {
        this.N(list);
    }

    public /* synthetic */ void Q(Integer n10) {
        this.P(n10);
    }

    public /* synthetic */ void S(Integer n10) {
        this.R(n10);
    }

    public /* synthetic */ void U(DialogFragment dialogFragment) {
        this.T(dialogFragment);
    }

    public /* synthetic */ void W(d.v.c.b2.w.a a10, DialogFragment dialogFragment) {
        this.V(a10, dialogFragment);
    }

    public int h() {
        return 2131558605;
    }

    public void i(ViewDataBinding object) {
        super.i((ViewDataBinding)object);
        object = (j9)object;
        this.j = object;
        object = this.getParentFragment();
        object = object != null ? this.getParentFragment() : this;
        this.l = object = (s)d.v.i0.b.a((Fragment)object).get(s.class);
        object = d.v.i0.b.a(this);
        Object object2 = (q)((ViewModelProvider)object).get(q.class);
        this.k = object2;
        object2 = (d.v.c.v0.i)((ViewModelProvider)object).get(d.v.c.v0.i.class);
        this.m = object2;
        this.n = object = (z)((ViewModelProvider)object).get(z.class);
        object = this.j;
        object2 = new p$b(this);
        ((j9)object).A((p$b)object2);
        object = this.j;
        object2 = this.m;
        ((j9)object).B((d.v.c.v0.i)object2);
        this.I();
        this.G();
        this.H();
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        q q10 = this.k;
        c c10 = this.g.W0();
        q10.r(c10);
    }
}

