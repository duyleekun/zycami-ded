/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.os.Bundle
 *  android.util.Size
 *  android.view.Window
 *  android.view.WindowManager$LayoutParams
 *  android.widget.TextView
 */
package d.v.c.y1.f.v;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Size;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
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
import com.zhiyun.common.util.Windows;
import d.v.c.w0.v5;
import d.v.c.y1.f.q;
import d.v.c.y1.f.s;
import d.v.c.y1.f.u;
import d.v.c.y1.f.v.a;
import d.v.c.y1.f.v.b;
import d.v.c.y1.f.v.c;
import d.v.c.y1.f.v.d;
import d.v.c.y1.f.v.i$a;
import d.v.f.i.g;
import d.v.g0.k$a;
import d.v.g0.k$b;
import d.v.j.g.z;
import java.util.List;

public class i
extends d.v.c.q0.b {
    private static final String n = "albumTitle";
    private static final String o = "albumId";
    private long g;
    private MusicListViewModel h;
    private v5 i;
    private s j;
    private u k;
    private d.v.c.v0.i l;
    private z m;

    public static i A(String string2, long l10) {
        i i10 = new i();
        Bundle bundle = new Bundle();
        bundle.putString(n, string2);
        bundle.putLong(o, l10);
        i10.setArguments(bundle);
        return i10;
    }

    private void B() {
        long l10;
        Object object = this.getArguments();
        if (object != null) {
            long l11;
            TextView textView = this.i.f;
            String string2 = object.getString(n);
            textView.setText((CharSequence)string2);
            l10 = 0L;
            String string3 = o;
            this.g = l11 = object.getLong(string3, l10);
        }
        this.i.e.e();
        object = this.h;
        l10 = this.g;
        ((MusicListViewModel)object).u(l10);
    }

    private void C() {
        MutableLiveData mutableLiveData = this.h.r();
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        Observer observer = new b(this);
        mutableLiveData.observe(lifecycleOwner, observer);
        mutableLiveData = this.h.v();
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new c(this);
        mutableLiveData.observe(lifecycleOwner, observer);
    }

    private void D() {
        Object object = this.h;
        Object object2 = new s((LifecycleOwner)this, (MusicListViewModel)object);
        this.j = object2;
        object = this.k;
        ((s)object2).r((u)object);
        object2 = this.i.c;
        Context context = this.requireContext();
        object = new LinearLayoutManager(context, 1, false);
        ((RecyclerView)object2).setLayoutManager((RecyclerView$LayoutManager)object);
        object2 = this.i.c;
        object = this.j;
        ((RecyclerView)object2).setAdapter((RecyclerView$Adapter)object);
    }

    private /* synthetic */ void E(q object) {
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
            object3 = new a(this, (q)object);
            object = ((k$b)((k$b)((k$a)object2).v(n10, (d.v.f.f.a)object3)).s()).b();
            object2 = this.getChildFragmentManager();
            object4 = this.getClass().getSimpleName();
            ((DialogFragment)object).show((FragmentManager)object2, (String)object4);
        } else {
            object2 = this.h;
            Context context = this.requireContext();
            ((MusicListViewModel)object2).p(context, (q)object);
        }
    }

    private /* synthetic */ void G(List list) {
        if (list == null) {
            return;
        }
        this.l.f(false);
        this.j.m(list);
        this.i.c.scrollBy(0, 1);
        boolean bl2 = list.isEmpty();
        this.N(bl2);
    }

    private /* synthetic */ void I(DialogFragment dialogFragment) {
        this.m.i(false);
    }

    private /* synthetic */ void K(q q10, DialogFragment object) {
        this.m.i(true);
        object = this.h;
        Context context = this.requireContext();
        ((MusicListViewModel)object).p(context, q10);
    }

    private void M() {
        Window window;
        Dialog dialog = this.getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            int n10;
            dialog = dialog.getWindow();
            int n11 = 2131099762;
            dialog.setBackgroundDrawableResource(n11);
            dialog.getDecorView().setPadding(0, 0, 0, 0);
            window = dialog.getAttributes();
            window.width = -1;
            Size size = Windows.o(this.requireContext());
            window.height = n10 = size.getHeight() * 2 / 3;
            window.flags = 32;
            window.gravity = n10 = 80;
            dialog.setAttributes((WindowManager.LayoutParams)window);
        }
    }

    private void N(boolean bl2) {
        Object object;
        if (bl2) {
            object = this.i.e;
            ((StatusView)((Object)object)).d();
        } else {
            object = this.i.e;
            ((StatusView)((Object)object)).a();
        }
        object = this.l;
        ((d.v.c.v0.i)object).g(bl2 ^= true);
    }

    public static /* synthetic */ MusicListViewModel w(i i10) {
        return i10.h;
    }

    public static /* synthetic */ v5 x(i i10) {
        return i10.i;
    }

    public static /* synthetic */ d.v.c.v0.i y(i i10) {
        return i10.l;
    }

    public static /* synthetic */ long z(i i10) {
        return i10.g;
    }

    public /* synthetic */ void F(q q10) {
        this.E(q10);
    }

    public /* synthetic */ void H(List list) {
        this.G(list);
    }

    public /* synthetic */ void J(DialogFragment dialogFragment) {
        this.I(dialogFragment);
    }

    public /* synthetic */ void L(q q10, DialogFragment dialogFragment) {
        this.K(q10, dialogFragment);
    }

    public void onDestroyView() {
        super.onDestroyView();
        Lifecycle lifecycle = this.getLifecycle();
        MusicListViewModel musicListViewModel = this.h;
        lifecycle.removeObserver(musicListViewModel);
    }

    public int s() {
        return 2131558559;
    }

    public void t(ViewDataBinding object) {
        super.t((ViewDataBinding)object);
        object = (v5)object;
        this.i = object;
        this.k = object = (u)d.v.i0.b.a(this.requireParentFragment().requireParentFragment()).get(u.class);
        object = d.v.i0.b.a(this);
        Object object2 = (MusicListViewModel)((ViewModelProvider)object).get(MusicListViewModel.class);
        this.h = object2;
        object2 = (d.v.c.v0.i)((ViewModelProvider)object).get(d.v.c.v0.i.class);
        this.l = object2;
        this.m = object = (z)((ViewModelProvider)object).get(z.class);
        object = this.i;
        object2 = new i$a(this);
        ((v5)object).B((i$a)object2);
        object = this.i;
        object2 = this.h;
        ((v5)object).D((MusicListViewModel)object2);
        object = this.i;
        object2 = this.l;
        ((v5)object).C((d.v.c.v0.i)object2);
        object = this.getLifecycle();
        object2 = this.h;
        ((Lifecycle)object).addObserver((LifecycleObserver)object2);
        this.m(true);
        this.M();
        this.D();
        this.B();
        this.C();
    }
}

