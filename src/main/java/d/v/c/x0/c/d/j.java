/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.v.c.x0.c.d;

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
import d.v.c.m0;
import d.v.c.w0.f8;
import d.v.c.x0.c.d.a;
import d.v.c.x0.c.d.b;
import d.v.c.x0.c.d.c;
import d.v.c.x0.c.d.d;
import d.v.c.x0.c.d.e;
import d.v.c.x0.c.d.f;
import d.v.c.x0.c.d.i;
import d.v.c.x0.c.d.j$a;
import d.v.c.x0.c.d.l;
import d.v.e.i.h;
import d.v.e.l.h2;
import d.v.f.i.g;
import d.v.g0.k$a;
import d.v.g0.k$b;
import d.v.j.g.z;
import java.util.List;

public class j
extends d.v.c.q0.d {
    private f8 j;
    private d.v.c.v0.i k;
    private z l;
    private l m;
    private d.v.c.x0.c.b n;

    private void A() {
        this.j.b.e();
        this.m.s();
    }

    private void B() {
        MutableLiveData mutableLiveData = this.m.f();
        Object object = this.getViewLifecycleOwner();
        Observer observer = new a(this);
        mutableLiveData.observe((LifecycleOwner)object, observer);
        mutableLiveData = this.m.r();
        object = this.getViewLifecycleOwner();
        observer = new f(this);
        mutableLiveData.observe((LifecycleOwner)object, observer);
        mutableLiveData = this.g.Y0();
        object = new b(this);
        mutableLiveData.observe(this, (Observer)object);
        mutableLiveData = this.m.d();
        object = new c(this);
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
        object = this.m;
        baseResourceListView.b(this, (d.v.c.b2.v.b)object);
        baseResourceListView = this.j.a;
        object = BaseResourceListView$ResourceType.RESOURCE_TYPE_FONT;
        baseResourceListView.setResourceType((BaseResourceListView$ResourceType)((Object)object));
    }

    private /* synthetic */ void D(d.v.c.b2.w.a object) {
        if (object == null) {
            return;
        }
        Object object2 = this.l;
        boolean bl2 = ((z)object2).f();
        if (bl2) {
            object2 = d.v.f.i.g.o(this.getResources(), 2131951893);
            Object object3 = this.getContext();
            Object object4 = new k$b((Context)object3);
            object2 = (k$b)((k$a)object4).n((String)object2);
            object4 = new d(this);
            object2 = (k$b)((k$a)object2).p((d.v.f.f.a)object4);
            int n10 = 2131951892;
            object3 = new e(this, (d.v.c.b2.w.a)object);
            object = ((k$b)((k$b)((k$a)object2).v(n10, (d.v.f.f.a)object3)).s()).b();
            object2 = this.getChildFragmentManager();
            object4 = this.getClass().getSimpleName();
            ((DialogFragment)object).show((FragmentManager)object2, (String)object4);
        } else {
            object2 = this.m;
            Context context = this.requireContext();
            ((l)object2).n(context, (d.v.c.b2.w.a)object);
        }
    }

    private /* synthetic */ void F(List object) {
        if (object == null) {
            return;
        }
        this.k.f(false);
        this.j.a.setData((List)object);
        boolean bl2 = object.isEmpty();
        this.Q(bl2);
        object = this.m;
        d.v.h.d.d d10 = this.g.X0();
        ((l)object).z(d10);
    }

    private /* synthetic */ void H(DecorationType object) {
        Object object2 = DecorationType.FONT;
        if (object != object2 && object != (object2 = DecorationType.CAPTION)) {
            return;
        }
        object = this.m.g();
        object2 = -1;
        h.g((MutableLiveData)object, object2);
    }

    private /* synthetic */ void J(Integer object) {
        int n10;
        int n11 = (Integer)object;
        if (n11 == (n10 = -1)) {
            return;
        }
        l l10 = this.m;
        int n12 = (Integer)object;
        object = l10.p(n12);
        this.P((i)object);
    }

    private /* synthetic */ void L(DialogFragment dialogFragment) {
        this.l.i(false);
    }

    private /* synthetic */ void N(d.v.c.b2.w.a a10, DialogFragment object) {
        this.l.i(true);
        object = this.m;
        Context context = this.requireContext();
        ((l)object).n(context, a10);
    }

    private void P(i object) {
        boolean bl2;
        Object object2;
        Object object3;
        Object object4 = this.g.X0();
        if (object4 == null) {
            object3 = this.g;
            object2 = this.requireContext();
            ((i2)object3).w((Context)object2);
        }
        if (bl2 = ((l)(object3 = this.m)).m((d.v.h.d.d)object4, (i)object)) {
            return;
        }
        object3 = this.g;
        object2 = ((i)object).R();
        int n10 = object4 == null ? m0.c : ((d.v.h.d.d)object4).w();
        ((i2)object3).g4((String)object2, n10);
        object4 = this.g.X0().v();
        object3 = ((i)object).R();
        n10 = (int)(((String)object4).equals(object3) ? 1 : 0);
        if (n10 != 0) {
            object4 = this.n;
            ((d.v.c.x0.c.b)object4).i((i)object);
        }
        object = this.m;
        object4 = this.g.X0();
        ((l)object).z((d.v.h.d.d)object4);
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
        object = this.k;
        ((d.v.c.v0.i)object).g(bl2 ^= true);
    }

    public static /* synthetic */ f8 x(j j10) {
        return j10.j;
    }

    public static /* synthetic */ d.v.c.v0.i y(j j10) {
        return j10.k;
    }

    public static /* synthetic */ l z(j j10) {
        return j10.m;
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
        return 2131558590;
    }

    public void i(ViewDataBinding object) {
        super.i((ViewDataBinding)object);
        object = (f8)object;
        this.j = object;
        object = d.v.i0.b.a(this);
        Object object2 = (l)((ViewModelProvider)object).get(l.class);
        this.m = object2;
        object2 = this.getParentFragment();
        object2 = object2 != null ? this.getParentFragment() : this;
        this.n = object2 = (d.v.c.x0.c.b)d.v.i0.b.a((Fragment)object2).get(d.v.c.x0.c.b.class);
        this.k = object2 = (d.v.c.v0.i)((ViewModelProvider)object).get(d.v.c.v0.i.class);
        this.l = object = (z)((ViewModelProvider)object).get(z.class);
        object = this.j;
        object2 = new j$a(this);
        ((f8)object).B((j$a)object2);
        object = this.j;
        object2 = this.m;
        ((f8)object).D((l)object2);
        object = this.j;
        object2 = this.k;
        ((f8)object).C((d.v.c.v0.i)object2);
        this.C();
        this.A();
        this.B();
    }

    public void onResume() {
        super.onResume();
    }
}

