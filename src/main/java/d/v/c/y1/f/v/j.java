/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 */
package d.v.c.y1.f.v;

import android.content.Context;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$ItemDecoration;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import com.zhiyun.account.widget.StatusView;
import com.zhiyun.cama.data.database.model.music.AlbumData;
import com.zhiyun.editortemplate.data.resource.Status;
import d.v.c.k1.a.r;
import d.v.c.q0.d;
import d.v.c.w0.x6;
import d.v.c.y1.f.v.e;
import d.v.c.y1.f.v.f;
import d.v.c.y1.f.v.i;
import d.v.c.y1.f.v.j$a;
import d.v.c.y1.f.v.k;
import d.v.c.y1.f.v.l;
import d.v.e.l.h2;
import d.v.i0.b;
import java.util.List;

public class j
extends d {
    private x6 j;
    private l k;
    private k l;
    private d.v.c.v0.i m;

    private void A() {
        this.j.b.e();
        this.k.f();
    }

    private void B() {
        MutableLiveData mutableLiveData = this.k.b();
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        f f10 = new f(this);
        mutableLiveData.observe(lifecycleOwner, f10);
    }

    private void C() {
        Object object = this.k;
        Object object2 = new k((LifecycleOwner)this, (l)object);
        this.l = object2;
        object2 = this.j.a;
        int n10 = h2.b(16.0f);
        int n11 = 2;
        object = new r(n11, n10, false);
        ((RecyclerView)object2).addItemDecoration((RecyclerView$ItemDecoration)object);
        object2 = this.j.a;
        Context context = this.requireContext();
        object = new GridLayoutManager(context, n11);
        ((RecyclerView)object2).setLayoutManager((RecyclerView$LayoutManager)object);
        object2 = this.j.a;
        object = this.l;
        ((RecyclerView)object2).setAdapter((RecyclerView$Adapter)object);
        object2 = this.l;
        object = new e(this);
        ((d.v.f.d.b)object2).n((d.v.f.f.b)object);
    }

    private /* synthetic */ void D(d.v.j.e.h.k object) {
        boolean bl2;
        Object object2 = ((d.v.j.e.h.k)object).a;
        Object object3 = Status.LOADING;
        if (object2 == object3) {
            return;
        }
        object2 = this.l;
        object3 = (List)((d.v.j.e.h.k)object).c;
        ((d.v.f.d.b)object2).m((List)object3);
        object2 = this.m;
        boolean bl3 = false;
        object3 = null;
        ((d.v.c.v0.i)object2).f(false);
        object = ((d.v.j.e.h.k)object).c;
        if (object == null || (bl2 = (object = (List)object).isEmpty())) {
            bl3 = true;
        }
        this.H(bl3);
    }

    private /* synthetic */ void F(View object, int n10, AlbumData albumData) {
        object = albumData.showLabel();
        long l10 = albumData.getResId();
        object = i.A((String)object, l10);
        FragmentManager fragmentManager = this.getChildFragmentManager();
        ((d.v.f.g.b)object).q(fragmentManager);
    }

    private void H(boolean bl2) {
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

    public static /* synthetic */ x6 x(j j10) {
        return j10.j;
    }

    public static /* synthetic */ d.v.c.v0.i y(j j10) {
        return j10.m;
    }

    public static /* synthetic */ l z(j j10) {
        return j10.k;
    }

    public /* synthetic */ void E(d.v.j.e.h.k k10) {
        this.D(k10);
    }

    public /* synthetic */ void G(View view, int n10, AlbumData albumData) {
        this.F(view, n10, albumData);
    }

    public int h() {
        return 2131558574;
    }

    public void i(ViewDataBinding object) {
        super.i((ViewDataBinding)object);
        object = (x6)object;
        this.j = object;
        object = this.getParentFragment();
        object = object == null ? this : this.getParentFragment();
        this.k = object = (l)d.v.i0.b.a((Fragment)object).get(l.class);
        this.m = object = (d.v.c.v0.i)d.v.i0.b.a(this).get(d.v.c.v0.i.class);
        object = this.j;
        Object object2 = this.k;
        ((x6)object).D((l)object2);
        object = this.j;
        object2 = this.m;
        ((x6)object).C((d.v.c.v0.i)object2);
        object = this.j;
        object2 = new j$a(this);
        ((x6)object).B((j$a)object2);
        this.C();
        this.A();
        this.B();
    }
}

