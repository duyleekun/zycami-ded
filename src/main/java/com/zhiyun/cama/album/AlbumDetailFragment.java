/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.Configuration
 *  android.os.Bundle
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package com.zhiyun.cama.album;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.viewpager2.widget.ViewPager2;
import androidx.viewpager2.widget.ViewPager2$OnPageChangeCallback;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.zhiyun.cama.album.AlbumDetailFragment$a;
import com.zhiyun.cama.album.AlbumDetailFragment$b;
import com.zhiyun.cama.album.AlbumDetailFragment$c;
import com.zhiyun.cama.album.AlbumPagerAdapter;
import com.zhiyun.cama.album.AlbumSection;
import d.v.c.o0.c;
import d.v.c.o0.d;
import d.v.c.o0.e;
import d.v.c.o0.f;
import d.v.c.o0.g;
import d.v.c.o0.h;
import d.v.c.o0.u0;
import d.v.c.w0.t5;
import d.v.e.i.j;
import d.v.f.h.a;
import d.v.i0.b;
import java.util.List;
import java.util.stream.Collectors;

public class AlbumDetailFragment
extends a {
    private ViewPager2 b;
    private AlbumPagerAdapter c;
    private u0 d;
    private final ObservableField e;
    private final ObservableBoolean f;
    private t5 g;
    private boolean h;
    private final ViewPager2$OnPageChangeCallback i;
    private final OnItemChildClickListener j;
    private final View.OnClickListener k;

    public AlbumDetailFragment() {
        Object object = new ObservableField();
        this.e = object;
        this.f = object;
        this.h = true;
        this.i = object = new AlbumDetailFragment$a(this);
        this.j = object = new AlbumDetailFragment$b(this);
        object = new c(this);
        this.k = object;
    }

    private /* synthetic */ void A(List list) {
        int n10 = list.isEmpty();
        if (n10 != 0) {
            list = this.g.getRoot();
            f f10 = new f(this);
            list.post(f10);
            return;
        }
        n10 = this.h;
        if (n10 != 0) {
            this.c.getData().clear();
            Object object = this.c.getData();
            list = this.t(list);
            object.addAll(list);
            this.c.notifyDataSetChanged();
            list = this.c.getData();
            object = this.e.get();
            int n11 = list.indexOf(object);
            n10 = -1;
            if (n11 == n10) {
                object = this.e;
                Object object2 = this.c.getItem(0);
                ((ObservableField)object).set(object2);
            }
            object = this.b;
            ((ViewPager2)((Object)object)).setCurrentItem(n11, false);
        }
    }

    private /* synthetic */ void C(Integer object) {
        int n10 = (Integer)object;
        if (n10 == 0) {
            object = this.c;
            Object object2 = this.e.get();
            ((BaseQuickAdapter)object).remove(object2);
        }
    }

    private /* synthetic */ void E(View view) {
        this.H();
    }

    private void G() {
        this.requireActivity().onBackPressed();
    }

    private void H() {
        Object object = this.f;
        boolean bl2 = ((ObservableBoolean)object).get() ^ true;
        ((ObservableBoolean)object).set(bl2);
        object = this.c;
        bl2 = this.f.get();
        ((AlbumPagerAdapter)object).n(bl2);
    }

    private void I() {
        t5 t52 = this.g;
        Object object = this.e;
        t52.D((ObservableField)object);
        t52 = this.g;
        object = new AlbumDetailFragment$c(this);
        t52.B((AlbumDetailFragment$c)object);
        t52 = this.g;
        object = this.f;
        t52.C((ObservableBoolean)object);
    }

    public static /* synthetic */ AlbumPagerAdapter j(AlbumDetailFragment albumDetailFragment) {
        return albumDetailFragment.c;
    }

    public static /* synthetic */ ObservableField k(AlbumDetailFragment albumDetailFragment) {
        return albumDetailFragment.e;
    }

    public static /* synthetic */ void l(AlbumDetailFragment albumDetailFragment, int n10) {
        albumDetailFragment.r(n10);
    }

    public static /* synthetic */ void m(AlbumDetailFragment albumDetailFragment) {
        albumDetailFragment.H();
    }

    public static /* synthetic */ void n(AlbumDetailFragment albumDetailFragment) {
        albumDetailFragment.s();
    }

    public static /* synthetic */ void o(AlbumDetailFragment albumDetailFragment) {
        albumDetailFragment.G();
    }

    public static /* synthetic */ ViewPager2 p(AlbumDetailFragment albumDetailFragment) {
        return albumDetailFragment.b;
    }

    public static /* synthetic */ u0 q(AlbumDetailFragment albumDetailFragment) {
        return albumDetailFragment.d;
    }

    private void r(int n10) {
        AlbumPagerAdapter albumPagerAdapter = this.c;
        int n11 = 2131362584;
        View view = albumPagerAdapter.getViewByPosition(n10, n11);
        if (view != null) {
            albumPagerAdapter = this.k;
            view.setOnClickListener((View.OnClickListener)albumPagerAdapter);
        }
    }

    private void s() {
        Configuration configuration = this.getResources().getConfiguration();
        int n10 = configuration.orientation;
        int n11 = 1;
        if (n10 == n11) {
            n10 = n11;
        } else {
            n10 = 0;
            configuration = null;
        }
        Object object = this.requireActivity();
        int n12 = n10 ^ 1;
        object.setRequestedOrientation(n12);
        object = this.c;
        ((AlbumPagerAdapter)object).m((n10 ^= n11) != 0);
    }

    private List t(List stream) {
        stream = stream.stream();
        Object object = d.v.c.o0.d.a;
        stream = stream.filter(object);
        object = Collectors.toList();
        return (List)stream.collect(object);
    }

    private void u() {
        int n10;
        Object object;
        Object object2 = this.g.h;
        this.b = object2;
        object2 = new AlbumPagerAdapter();
        this.c = object2;
        this.b.setAdapter((RecyclerView$Adapter)object2);
        object2 = this.b;
        Object object3 = this.i;
        ((ViewPager2)((Object)object2)).registerOnPageChangeCallback((ViewPager2$OnPageChangeCallback)object3);
        object2 = this.c;
        object3 = new e(this);
        ((BaseQuickAdapter)object2).setOnItemClickListener((OnItemClickListener)object3);
        object2 = this.c;
        object3 = this.j;
        ((BaseQuickAdapter)object2).setOnItemChildClickListener((OnItemChildClickListener)object3);
        object2 = this.getArguments();
        int n11 = 0;
        object3 = null;
        if (object2 != null) {
            object = (AlbumSection)object2.getParcelable("album_info");
            this.e.set(object);
            Object object4 = "album_list";
            object2 = object2.getParcelableArrayList((String)object4);
            if (object2 != null) {
                this.c.getData().clear();
                object4 = this.c.getData();
                object2 = this.t((List)object2);
                object4.addAll(object2);
                object2 = this.b;
                object4 = this.c.getData();
                n10 = object4.indexOf(object);
                ((ViewPager2)((Object)object2)).setCurrentItem(n10, false);
                this.h = false;
            }
        } else {
            object = null;
        }
        if (object == null) {
            object2 = this.d;
            ((u0)object2).i();
        }
        object2 = this.getResources().getConfiguration();
        int n12 = ((Configuration)object2).orientation;
        object = this.c;
        n10 = 1;
        if (n12 == n10) {
            n11 = n10;
        }
        ((AlbumPagerAdapter)object).m(n11 != 0);
    }

    private void v() {
        Object object = (u0)d.v.i0.b.c(this.requireActivity()).get(u0.class);
        this.d = object;
        object = ((u0)object).c;
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        Observer observer = new h(this);
        ((j)object).observe(lifecycleOwner, observer);
        object = this.d.d;
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new g(this);
        ((LiveData)object).observe(lifecycleOwner, observer);
    }

    public static /* synthetic */ void w(AlbumDetailFragment albumDetailFragment) {
        albumDetailFragment.G();
    }

    public static /* synthetic */ boolean x(AlbumSection albumSection) {
        return albumSection.isHeader() ^ true;
    }

    private /* synthetic */ void y(BaseQuickAdapter baseQuickAdapter, View view, int n10) {
        this.H();
    }

    public /* synthetic */ void B(List list) {
        this.A(list);
    }

    public /* synthetic */ void D(Integer n10) {
        this.C(n10);
    }

    public /* synthetic */ void F(View view) {
        this.E(view);
    }

    public int h() {
        return 2131558558;
    }

    public void i(ViewDataBinding viewDataBinding) {
        super.i(viewDataBinding);
        viewDataBinding = (t5)viewDataBinding;
        this.g = viewDataBinding;
    }

    public void onConfigurationChanged(Configuration object) {
        super.onConfigurationChanged((Configuration)object);
        int n10 = ((Configuration)object).orientation;
        int n11 = 1;
        if (n10 != n11) {
            n11 = 0;
        }
        this.c.m(n11 != 0);
        object = this.c;
        n11 = this.b.getCurrentItem();
        ((AlbumPagerAdapter)object).t(n11);
    }

    public void onDestroyView() {
        super.onDestroyView();
        ViewPager2 viewPager2 = this.b;
        ViewPager2$OnPageChangeCallback viewPager2$OnPageChangeCallback = this.i;
        viewPager2.unregisterOnPageChangeCallback(viewPager2$OnPageChangeCallback);
    }

    public void onStop() {
        super.onStop();
        AlbumPagerAdapter albumPagerAdapter = this.c;
        List list = albumPagerAdapter.getData();
        Object object = this.e.get();
        int n10 = list.indexOf(object);
        albumPagerAdapter.p(n10);
        this.c.o();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.I();
        this.v();
        this.u();
    }

    public /* synthetic */ void z(BaseQuickAdapter baseQuickAdapter, View view, int n10) {
        this.y(baseQuickAdapter, view, n10);
    }
}

