/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.view.View
 */
package com.zhiyun.cama.album;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.BaseObservableField;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DiffUtil$ItemCallback;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$ItemDecoration;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.zhiyun.cama.album.AlbumListAdapter;
import com.zhiyun.cama.album.AlbumListFragment$a;
import com.zhiyun.cama.album.AlbumSection;
import com.zhiyun.common.util.Windows;
import d.v.c.o0.p0;
import d.v.c.o0.t;
import d.v.c.o0.t0;
import d.v.c.o0.u;
import d.v.c.o0.u0;
import d.v.c.o0.v;
import d.v.c.o0.w;
import d.v.c.w0.x;
import d.v.c.x1.l;
import d.v.e.i.j;
import d.v.e.l.h2;
import d.v.f.h.a;
import d.v.i0.b;
import java.util.ArrayList;
import java.util.List;

public class AlbumListFragment
extends a {
    private final ObservableInt b;
    private final ObservableBoolean c;
    private u0 d;
    private AlbumListAdapter e;
    private GridLayoutManager f;
    private x g;
    private p0 h;

    public AlbumListFragment() {
        BaseObservableField baseObservableField;
        this.b = baseObservableField = new ObservableInt();
        super(false);
        this.c = baseObservableField;
    }

    private void A() {
        x x10 = this.g;
        Object object = this.d;
        x10.F((u0)object);
        x10 = this.g;
        object = this.b;
        x10.E((ObservableInt)object);
        x10 = this.g;
        object = new AlbumListFragment$a(this);
        x10.C((AlbumListFragment$a)object);
        x10 = this.g;
        object = this.c;
        x10.D((ObservableBoolean)object);
    }

    private void B(AlbumSection arrayList) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("album_info", (Parcelable)arrayList);
        List list = this.e.getData();
        arrayList = new ArrayList(list);
        bundle.putParcelableArrayList("album_list", arrayList);
        l.e(this, 2131362007, bundle);
    }

    public static /* synthetic */ ObservableInt j(AlbumListFragment albumListFragment) {
        return albumListFragment.b;
    }

    public static /* synthetic */ u0 k(AlbumListFragment albumListFragment) {
        return albumListFragment.d;
    }

    public static /* synthetic */ AlbumListAdapter l(AlbumListFragment albumListFragment) {
        return albumListFragment.e;
    }

    public static /* synthetic */ p0 m(AlbumListFragment albumListFragment) {
        return albumListFragment.h;
    }

    public static /* synthetic */ x n(AlbumListFragment albumListFragment) {
        return albumListFragment.g;
    }

    public static /* synthetic */ ObservableBoolean o(AlbumListFragment albumListFragment) {
        return albumListFragment.c;
    }

    private void p(List object) {
        int n10;
        ObservableInt observableInt;
        this.e.setDiffNewData((List)object);
        Object object2 = this.e;
        ((RecyclerView$Adapter)object2).notifyDataSetChanged();
        boolean bl2 = object.isEmpty();
        if (bl2) {
            object2 = this.h;
            observableInt = this.b;
            n10 = observableInt.get();
            ((p0)object2).c(n10);
        }
        object2 = this.g.k;
        n10 = object.isEmpty();
        int n11 = 8;
        if (n10 != 0) {
            n10 = n11;
        } else {
            n10 = 0;
            observableInt = null;
        }
        object2.setVisibility(n10);
        object2 = this.g.f;
        boolean bl3 = object.isEmpty();
        if (!bl3 && (bl3 = ((ObservableBoolean)(object = this.c)).get())) {
            n11 = 0;
        }
        ((Group)((Object)object2)).setVisibility(n11);
    }

    private void q() {
        Object object = this.requireContext();
        Object object2 = new p0((Context)object);
        this.h = object2;
        object2 = this.g.j;
        object = this.requireContext();
        int n10 = h2.c(object);
        n10 = n10 != 0 ? 3 : 6;
        Context context = this.requireContext();
        ArrayList arrayList = new ArrayList(context, n10);
        this.f = arrayList;
        ((RecyclerView)object2).setLayoutManager((RecyclerView$LayoutManager)((Object)arrayList));
        n10 = h2.b(2.0f);
        arrayList = new ArrayList(n10);
        ((RecyclerView)object2).addItemDecoration((RecyclerView$ItemDecoration)((Object)arrayList));
        arrayList = new ArrayList();
        object = new AlbumListAdapter(arrayList);
        this.e = object;
        ((RecyclerView)object2).setAdapter((RecyclerView$Adapter)object);
        object2 = this.e;
        object = this.h;
        ((BaseQuickAdapter)object2).setEmptyView((View)object);
        object2 = this.e;
        object = new t0();
        ((BaseQuickAdapter)object2).setDiffCallback((DiffUtil$ItemCallback)object);
        object2 = this.d;
        n10 = this.b.get();
        ((u0)object2).f(n10);
        object2 = this.e;
        object = new w(this);
        ((BaseQuickAdapter)object2).setOnItemClickListener((OnItemClickListener)object);
        object2 = this.e;
        object = new t(this);
        ((BaseQuickAdapter)object2).setOnItemChildClickListener((OnItemChildClickListener)object);
    }

    private void r() {
        MutableLiveData mutableLiveData = this.d.c;
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        Observer observer = new v(this);
        ((j)mutableLiveData).observe(lifecycleOwner, observer);
        mutableLiveData = this.d.e;
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new u(this);
        mutableLiveData.observe(lifecycleOwner, observer);
    }

    public static /* synthetic */ void s(AlbumListFragment albumListFragment, List list) {
        albumListFragment.p(list);
    }

    private /* synthetic */ void t(BaseQuickAdapter object, View object2, int n10) {
        object = this.e.getData();
        int n11 = object.size();
        if (n10 >= n11) {
            return;
        }
        object = (AlbumSection)this.e.getData().get(n10);
        boolean bl2 = ((AlbumSection)object).isHeader();
        if (bl2) {
            return;
        }
        this.d.w();
        object2 = this.c;
        bl2 = ((ObservableBoolean)object2).get();
        if (bl2) {
            object2 = object.getAlbum().isChecked;
            ObservableBoolean observableBoolean = object.getAlbum().isChecked;
            n10 = observableBoolean.get() ^ 1;
            ((ObservableBoolean)object2).set(n10 != 0);
            this.e.g((AlbumSection)object);
            object = this.d.f;
            bl2 = this.e.a();
            object2 = bl2;
            ((MutableLiveData)object).setValue(object2);
        } else {
            this.B((AlbumSection)object);
        }
    }

    private /* synthetic */ void v(BaseQuickAdapter object, View object2, int n10) {
        int n11 = (object = ((BaseQuickAdapter)object).getData()).size();
        if (n10 >= n11) {
            return;
        }
        this.d.w();
        object = (AlbumSection)this.e.getData().get(n10);
        this.e.s((AlbumSection)object);
        object = this.d.f;
        object2 = this.e.a();
        ((MutableLiveData)object).setValue(object2);
    }

    private /* synthetic */ void x(Boolean object) {
        boolean bl2 = (Boolean)object;
        if (!bl2) {
            object = this.e;
            ((AlbumListAdapter)object).b();
        }
    }

    private void z() {
        Context context = this.requireContext();
        int n10 = Windows.r(context);
        if (n10 == 0) {
            return;
        }
        context = this.getResources().getConfiguration();
        n10 = context.orientation;
        int n11 = 1;
        if (n10 != n11) {
            n11 = 0;
        }
        float f10 = 10.0f;
        n10 = h2.b(f10);
        RecyclerView recyclerView = this.g.j;
        int n12 = n11 != 0 ? 0 : n10;
        if (n11 != 0) {
            n10 = 0;
            context = null;
            f10 = 0.0f;
        }
        recyclerView.setPadding(n12, 0, n10, 0);
    }

    public int h() {
        return 2131558449;
    }

    public void i(ViewDataBinding viewDataBinding) {
        super.i(viewDataBinding);
        viewDataBinding = (x)viewDataBinding;
        this.g = viewDataBinding;
    }

    public void onAttach(Context object) {
        super.onAttach((Context)object);
        object = (u0)d.v.i0.b.c(this.requireActivity()).get(u0.class);
        this.d = object;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int n10 = configuration.orientation;
        int n11 = 1;
        n10 = n10 == n11 ? 3 : 6;
        this.f.setSpanCount(n10);
        this.z();
    }

    public void onStop() {
        super.onStop();
        this.d.w();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.r();
        this.A();
        this.q();
        this.z();
    }

    public /* synthetic */ void u(BaseQuickAdapter baseQuickAdapter, View view, int n10) {
        this.t(baseQuickAdapter, view, n10);
    }

    public /* synthetic */ void w(BaseQuickAdapter baseQuickAdapter, View view, int n10) {
        this.v(baseQuickAdapter, view, n10);
    }

    public /* synthetic */ void y(Boolean bl2) {
        this.x(bl2);
    }
}

