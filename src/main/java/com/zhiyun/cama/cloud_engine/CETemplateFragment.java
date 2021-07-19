/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.View
 */
package com.zhiyun.cama.cloud_engine;

import android.os.Bundle;
import android.view.View;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.chad.library.adapter.base.loadmore.BaseLoadMoreView;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.quvideo.mobile.external.component.cloudengine.QVCloudEngine;
import com.quvideo.mobile.external.component.cloudengine.model.TemplateConfig;
import com.quvideo.mobile.external.component.cloudengine.model.TemplateResponse$Data;
import com.zhiyun.cama.cloud_engine.CEPullToRefreshLayout;
import com.zhiyun.cama.cloud_engine.CEPullToRefreshLayout$d;
import com.zhiyun.cama.cloud_engine.CETemplateFragment$a;
import com.zhiyun.cama.cloud_engine.CETemplateFragment$b;
import com.zhiyun.cama.cloud_engine.CETemplateModel;
import com.zhiyun.cama.cloud_engine.SingeBindingLoadMoreAdapter;
import d.v.c.t0.a0;
import d.v.c.t0.e0;
import d.v.c.t0.k;
import d.v.c.t0.l;
import d.v.c.t0.m;
import d.v.c.t0.n;
import d.v.c.w0.p2;
import d.v.f.h.a;

public class CETemplateFragment
extends a {
    private p2 b;
    private SingeBindingLoadMoreAdapter c;
    private ObservableField d;
    private int e;

    public CETemplateFragment() {
        ObservableField observableField;
        this.d = observableField = new ObservableField();
        this.e = 1;
    }

    public static /* synthetic */ SingeBindingLoadMoreAdapter j(CETemplateFragment cETemplateFragment) {
        return cETemplateFragment.c;
    }

    public static /* synthetic */ int k(CETemplateFragment cETemplateFragment) {
        return cETemplateFragment.e;
    }

    public static /* synthetic */ int l(CETemplateFragment cETemplateFragment) {
        int n10;
        int n11 = cETemplateFragment.e;
        cETemplateFragment.e = n10 = n11 + 1;
        return n11;
    }

    public static /* synthetic */ ObservableField m(CETemplateFragment cETemplateFragment) {
        return cETemplateFragment.d;
    }

    public static /* synthetic */ p2 n(CETemplateFragment cETemplateFragment) {
        return cETemplateFragment.b;
    }

    public static /* synthetic */ void o(CETemplateFragment cETemplateFragment) {
        cETemplateFragment.w();
    }

    private void p() {
        this.c.getLoadMoreModule().setEnableLoadMore(false);
        int n10 = this.e;
        TemplateConfig templateConfig = new TemplateConfig(n10, 10);
        CETemplateFragment$a cETemplateFragment$a = new CETemplateFragment$a(this);
        QVCloudEngine.getTemplates(templateConfig, cETemplateFragment$a);
    }

    public static /* synthetic */ void q(CETemplateFragment cETemplateFragment) {
        cETemplateFragment.w();
    }

    public static /* synthetic */ void r(CETemplateFragment cETemplateFragment) {
        cETemplateFragment.p();
    }

    public static /* synthetic */ void s(View view) {
        view.setEnabled(true);
    }

    private /* synthetic */ void t(BaseQuickAdapter object, View view, int n10) {
        object = (TemplateResponse$Data)this.c.getItem(n10);
        this.v(view, (TemplateResponse$Data)object);
    }

    private void v(View view, TemplateResponse$Data object) {
        view.setEnabled(false);
        NavController navController = NavHostFragment.findNavController(this);
        object = e0.a(CETemplateModel.from((TemplateResponse$Data)object));
        navController.navigate((NavDirections)object);
        object = new l(view);
        view.postDelayed((Runnable)object, 200L);
    }

    private void w() {
        this.d.set(null);
        CEPullToRefreshLayout cEPullToRefreshLayout = this.b.d;
        int n10 = 1;
        cEPullToRefreshLayout.setRefreshing(n10 != 0);
        this.e = n10;
        this.p();
    }

    public int h() {
        return 2131558488;
    }

    public void i(ViewDataBinding viewDataBinding) {
        super.i(viewDataBinding);
        viewDataBinding = (p2)viewDataBinding;
        this.b = viewDataBinding;
        Object object = new CETemplateFragment$b(this);
        ((p2)viewDataBinding).A((CETemplateFragment$b)object);
        viewDataBinding = this.b;
        object = this.d;
        ((p2)viewDataBinding).B((ObservableField)object);
    }

    public void onViewCreated(View object, Bundle object2) {
        super.onViewCreated((View)object, (Bundle)object2);
        object = new SingeBindingLoadMoreAdapter(2131558622);
        this.c = object;
        ((BaseQuickAdapter)object).getLoadMoreModule().setEnableLoadMore(false);
        object = this.c.getLoadMoreModule();
        boolean bl2 = true;
        ((BaseLoadMoreModule)object).setAutoLoadMore(bl2);
        this.c.getLoadMoreModule().setEnableLoadMoreIfNotFullPage(false);
        object = this.c.getLoadMoreModule();
        Object object3 = new n(this);
        ((BaseLoadMoreModule)object).setOnLoadMoreListener((OnLoadMoreListener)object3);
        object = this.c.getLoadMoreModule();
        object3 = new a0();
        ((BaseLoadMoreModule)object).setLoadMoreView((BaseLoadMoreView)object3);
        object = this.c;
        object3 = new int[bl2];
        object3[0] = 2131362880;
        ((BaseQuickAdapter)object).addChildClickViewIds((int[])object3);
        object = this.c;
        object2 = new k(this);
        ((BaseQuickAdapter)object).setOnItemChildClickListener((OnItemChildClickListener)object2);
        object = this.b.c;
        object2 = new StaggeredGridLayoutManager(2, (int)(bl2 ? 1 : 0));
        ((RecyclerView)object).setLayoutManager((RecyclerView$LayoutManager)object2);
        object2 = this.c;
        ((RecyclerView)object).setAdapter((RecyclerView$Adapter)object2);
        object = this.b.d;
        object2 = new m(this);
        ((CEPullToRefreshLayout)object).setOnRefreshListener((CEPullToRefreshLayout$d)object2);
        this.b.d.setRefreshing(bl2);
    }

    public /* synthetic */ void u(BaseQuickAdapter baseQuickAdapter, View view, int n10) {
        this.t(baseQuickAdapter, view, n10);
    }
}

