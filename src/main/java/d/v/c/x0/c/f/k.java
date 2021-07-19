/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.v.c.x0.c.f;

import android.content.Context;
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
import d.v.c.i1.i2;
import d.v.c.k1.a.r;
import d.v.c.v0.i;
import d.v.c.w0.l8;
import d.v.c.x0.c.b;
import d.v.c.x0.c.f.a;
import d.v.c.x0.c.f.c;
import d.v.c.x0.c.f.d;
import d.v.c.x0.c.f.e;
import d.v.c.x0.c.f.f;
import d.v.c.x0.c.f.j;
import d.v.c.x0.c.f.k$a;
import d.v.c.x0.c.f.l;
import d.v.e.i.h;
import d.v.e.l.h2;
import d.v.f.i.g;
import d.v.g0.k$b;
import d.v.j.g.z;
import java.util.List;

public class k
extends d.v.c.q0.d {
    private l8 j;
    private l k;
    private b l;
    private z m;
    private i n;

    private void A() {
        this.j.b.e();
        this.k.p();
    }

    private void B() {
        MutableLiveData mutableLiveData = this.k.f();
        Object object = this.getViewLifecycleOwner();
        Observer observer = new e(this);
        mutableLiveData.observe((LifecycleOwner)object, observer);
        mutableLiveData = this.k.s();
        object = this.getViewLifecycleOwner();
        observer = new d(this);
        mutableLiveData.observe((LifecycleOwner)object, observer);
        mutableLiveData = this.g.Y0();
        object = new d.v.c.x0.c.f.b(this);
        mutableLiveData.observe(this, (Observer)object);
        mutableLiveData = this.k.d();
        object = new a(this);
        mutableLiveData.observe(this, (Observer)object);
    }

    private void C() {
        r r10;
        int n10 = h2.b(10.0f);
        BaseResourceListView baseResourceListView = this.j.a;
        int n11 = h2.b(6.0f);
        int n12 = h2.b(20.0f);
        Object object = r10;
        r10 = new r(3, n10, false, n11, n12);
        baseResourceListView.addItemDecoration(r10);
        baseResourceListView = this.j.a;
        Context context = this.requireContext();
        object = new GridLayoutManager(context, 3);
        baseResourceListView.setLayoutManager((RecyclerView$LayoutManager)object);
        baseResourceListView = this.j.a;
        object = this.k;
        baseResourceListView.b(this, (d.v.c.b2.v.b)object);
        baseResourceListView = this.j.a;
        object = BaseResourceListView$ResourceType.RESOURCE_TYPE_CAPTION;
        baseResourceListView.setResourceType((BaseResourceListView$ResourceType)((Object)object));
    }

    private /* synthetic */ void D(d.v.c.b2.w.a object) {
        if (object == null) {
            return;
        }
        Object object2 = this.m;
        boolean bl2 = ((z)object2).f();
        if (bl2) {
            object2 = d.v.f.i.g.o(this.getResources(), 2131951893);
            Object object3 = this.getContext();
            Object object4 = new k$b((Context)object3);
            object2 = (k$b)((d.v.g0.k$a)object4).n((String)object2);
            object4 = new c(this);
            object2 = (k$b)((d.v.g0.k$a)object2).p((d.v.f.f.a)object4);
            int n10 = 2131951892;
            object3 = new f(this, (d.v.c.b2.w.a)object);
            object = ((k$b)((k$b)((d.v.g0.k$a)object2).v(n10, (d.v.f.f.a)object3)).s()).b();
            object2 = this.getChildFragmentManager();
            object4 = this.getClass().getSimpleName();
            ((DialogFragment)object).show((FragmentManager)object2, (String)object4);
        } else {
            object2 = this.k;
            Context context = this.requireContext();
            ((l)object2).n(context, (d.v.c.b2.w.a)object);
        }
    }

    private /* synthetic */ void F(List object) {
        if (object == null) {
            return;
        }
        this.n.f(false);
        this.j.a.setData((List)object);
        boolean bl2 = object.isEmpty();
        this.Q(bl2);
        object = this.k;
        d.v.h.d.d d10 = this.g.X0();
        ((l)object).z(d10);
    }

    private /* synthetic */ void H(DecorationType object) {
        Object object2 = DecorationType.FONT;
        if (object != object2 && object != (object2 = DecorationType.CAPTION)) {
            return;
        }
        object = this.k.g();
        object2 = -1;
        h.g((MutableLiveData)object, object2);
    }

    private /* synthetic */ void J(Integer object) {
        int n10;
        int n11 = (Integer)object;
        if (n11 == (n10 = -1)) {
            return;
        }
        n11 = (Integer)object;
        if (n11 == 0) {
            this.g.L2();
            object = this.k;
            d.v.h.d.d d10 = this.g.X0();
            ((l)object).z(d10);
            return;
        }
        l l10 = this.k;
        int n12 = (Integer)object;
        if ((object = l10.r(n12)) != null) {
            this.P((j)object);
        }
    }

    private /* synthetic */ void L(DialogFragment dialogFragment) {
        this.m.i(false);
    }

    private /* synthetic */ void N(d.v.c.b2.w.a a10, DialogFragment object) {
        this.m.i(true);
        object = this.k;
        Context context = this.requireContext();
        ((l)object).n(context, a10);
    }

    private void P(j object) {
        boolean bl2;
        Object object2;
        Object object3 = this.g.X0();
        if (object3 == null) {
            object2 = this.g;
            Context context = this.requireContext();
            ((i2)object2).w(context);
        }
        if (bl2 = ((l)(object2 = this.k)).m((d.v.h.d.d)object3, (j)object)) {
            return;
        }
        object3 = this.g;
        object2 = ((j)object).R();
        ((i2)object3).h4((String)object2);
        object3 = this.g.X0();
        if (object3 != null && (bl2 = ((String)(object3 = ((d.v.h.d.d)object3).t().b())).equals(object2 = ((j)object).R()))) {
            object3 = this.l;
            ((b)object3).g((j)object);
        }
        object = this.k;
        object3 = this.g.X0();
        ((l)object).z((d.v.h.d.d)object3);
    }

    private void Q(boolean bl2) {
        Object object;
        if (bl2) {
            object = this.j.b;
            ((StatusView)((Object)object)).d();
        } else {
            object = this.j.b;
            ((StatusView)((Object)object)).a();
        }
        object = this.n;
        ((i)object).g(bl2 ^= true);
    }

    public static /* synthetic */ l8 x(k k10) {
        return k10.j;
    }

    public static /* synthetic */ i y(k k10) {
        return k10.n;
    }

    public static /* synthetic */ l z(k k10) {
        return k10.k;
    }

    public /* synthetic */ void E(d.v.c.b2.w.a a10) {
        this.D(a10);
    }

    public /* synthetic */ void G(List list) {
        this.F(list);
    }

    public /* synthetic */ void I(DecorationType decorationType) {
        this.H(decorationType);
    }

    public /* synthetic */ void K(Integer n10) {
        this.J(n10);
    }

    public /* synthetic */ void M(DialogFragment dialogFragment) {
        this.L(dialogFragment);
    }

    public /* synthetic */ void O(d.v.c.b2.w.a a10, DialogFragment dialogFragment) {
        this.N(a10, dialogFragment);
    }

    public int h() {
        return 2131558593;
    }

    public void i(ViewDataBinding object) {
        super.i((ViewDataBinding)object);
        object = (l8)object;
        this.j = object;
        object = d.v.i0.b.a(this);
        Object object2 = (l)((ViewModelProvider)object).get(l.class);
        this.k = object2;
        object2 = this.getParentFragment();
        object2 = object2 != null ? this.getParentFragment() : this;
        this.l = object2 = (b)d.v.i0.b.a((Fragment)object2).get(b.class);
        this.n = object2 = (i)((ViewModelProvider)object).get(i.class);
        this.m = object = (z)((ViewModelProvider)object).get(z.class);
        object = this.j;
        object2 = new k$a(this);
        ((l8)object).A((k$a)object2);
        object = this.j;
        object2 = this.n;
        ((l8)object).B((i)object2);
        this.C();
        this.A();
        this.B();
    }
}

