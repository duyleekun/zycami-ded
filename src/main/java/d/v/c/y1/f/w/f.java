/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.v.c.y1.f.w;

import android.content.Context;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import com.zhiyun.account.widget.StatusView;
import com.zhiyun.cama.voice.music.MusicListViewModel;
import com.zhiyun.cama.voice.music.MusicPlayVieModel;
import d.v.c.v0.i;
import d.v.c.w0.b7;
import d.v.c.y1.f.q;
import d.v.c.y1.f.s;
import d.v.c.y1.f.u;
import d.v.c.y1.f.w.a;
import d.v.c.y1.f.w.b;
import d.v.c.y1.f.w.c;
import d.v.c.y1.f.w.d;
import d.v.c.y1.f.w.e;
import d.v.c.y1.f.w.f$a;
import d.v.f.i.g;
import d.v.g0.k$a;
import d.v.g0.k$b;
import d.v.j.g.z;
import java.util.List;

public class f
extends d.v.c.q0.d {
    private b7 j;
    private MusicListViewModel k;
    private i l;
    private z m;
    private u n;
    private s o;

    private void A() {
        this.j.c.e();
        this.k.s();
    }

    private void B() {
        MutableLiveData mutableLiveData = this.k.r();
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        Observer observer = new e(this);
        mutableLiveData.observe(lifecycleOwner, observer);
        mutableLiveData = this.k.v();
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new a(this);
        mutableLiveData.observe(lifecycleOwner, observer);
        mutableLiveData = this.l.c();
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new b(this);
        mutableLiveData.observe(lifecycleOwner, observer);
    }

    private void C() {
        Object object = this.k;
        Object object2 = new s((LifecycleOwner)this, (MusicListViewModel)object);
        this.o = object2;
        object = this.n;
        ((s)object2).r((u)object);
        object2 = this.j.a;
        Context context = this.requireContext();
        object = new LinearLayoutManager(context, 1, false);
        ((RecyclerView)object2).setLayoutManager((RecyclerView$LayoutManager)object);
        object2 = this.j.a;
        object = this.o;
        ((RecyclerView)object2).setAdapter((RecyclerView$Adapter)object);
    }

    private /* synthetic */ void D(q object) {
        if (object == null) {
            return;
        }
        Object object2 = this.m;
        boolean bl2 = ((z)object2).f();
        if (bl2) {
            object2 = d.v.f.i.g.o(this.getResources(), 2131951893);
            Object object3 = this.getContext();
            Object object4 = new k$b((Context)object3);
            object2 = (k$b)((k$a)object4).n((String)object2);
            object4 = new d(this);
            object2 = (k$b)((k$a)object2).p((d.v.f.f.a)object4);
            int n10 = 2131951892;
            object3 = new c(this, (q)object);
            object = ((k$b)((k$b)((k$a)object2).v(n10, (d.v.f.f.a)object3)).s()).b();
            object2 = this.getChildFragmentManager();
            object4 = this.getClass().getSimpleName();
            ((DialogFragment)object).show((FragmentManager)object2, (String)object4);
        } else {
            object2 = this.k;
            Context context = this.requireContext();
            ((MusicListViewModel)object2).p(context, (q)object);
        }
    }

    private /* synthetic */ void F(List list) {
        if (list == null) {
            return;
        }
        this.l.f(false);
        this.o.m(list);
        boolean bl2 = this.o.d().isEmpty();
        this.N(bl2);
    }

    private /* synthetic */ void H(Boolean object) {
        boolean bl2 = (Boolean)object;
        if (bl2) {
            object = this.k;
            ((MusicPlayVieModel)object).m();
        }
    }

    private /* synthetic */ void J(DialogFragment dialogFragment) {
        this.m.i(false);
    }

    private /* synthetic */ void L(q q10, DialogFragment object) {
        this.m.i(true);
        object = this.k;
        Context context = this.requireContext();
        ((MusicListViewModel)object).p(context, q10);
    }

    private void N(boolean bl2) {
        Object object;
        if (bl2) {
            object = this.j.c;
            ((StatusView)((Object)object)).d();
        } else {
            object = this.j.c;
            ((StatusView)((Object)object)).a();
        }
        object = this.l;
        ((i)object).g(bl2 ^= true);
    }

    public static /* synthetic */ b7 x(f f10) {
        return f10.j;
    }

    public static /* synthetic */ i y(f f10) {
        return f10.l;
    }

    public static /* synthetic */ MusicListViewModel z(f f10) {
        return f10.k;
    }

    public /* synthetic */ void E(q q10) {
        this.D(q10);
    }

    public /* synthetic */ void G(List list) {
        this.F(list);
    }

    public /* synthetic */ void I(Boolean bl2) {
        this.H(bl2);
    }

    public /* synthetic */ void K(DialogFragment dialogFragment) {
        this.J(dialogFragment);
    }

    public /* synthetic */ void M(q q10, DialogFragment dialogFragment) {
        this.L(q10, dialogFragment);
    }

    public int h() {
        return 2131558575;
    }

    public void i(ViewDataBinding object) {
        super.i((ViewDataBinding)object);
        object = (b7)object;
        this.j = object;
        Object object2 = new f$a(this);
        ((b7)object).B((f$a)object2);
        object = d.v.i0.b.a(this);
        this.k = object2 = (MusicListViewModel)((ViewModelProvider)object).get(MusicListViewModel.class);
        this.n = object2 = (u)d.v.i0.b.a(this.requireParentFragment()).get(u.class);
        this.l = object2 = (i)((ViewModelProvider)object).get(i.class);
        this.m = object = (z)((ViewModelProvider)object).get(z.class);
        object = this.j;
        object2 = this.k;
        ((b7)object).D((MusicListViewModel)object2);
        object = this.j;
        object2 = this.l;
        ((b7)object).C((i)object2);
        object = this.getLifecycle();
        object2 = this.k;
        ((Lifecycle)object).addObserver((LifecycleObserver)object2);
        this.C();
        this.A();
        this.B();
    }

    public void onDestroyView() {
        super.onDestroyView();
        Lifecycle lifecycle = this.getLifecycle();
        MusicListViewModel musicListViewModel = this.k;
        lifecycle.removeObserver(musicListViewModel);
    }

    public void onResume() {
        super.onResume();
        this.k.s();
    }
}

