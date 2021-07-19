/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package com.zhiyun.cama.set.server;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import com.zhiyun.account.widget.StatusView;
import com.zhiyun.cama.set.server.ServersFragment$a;
import com.zhiyun.net.DataListEntity;
import d.v.c.n0.c;
import d.v.c.q1.i0.a;
import d.v.c.q1.i0.d;
import d.v.c.q1.i0.f;
import d.v.c.q1.i0.g;
import d.v.c.w0.b0;
import d.v.e.i.j;
import d.v.i0.b;
import java.util.ArrayList;
import java.util.List;

public class ServersFragment
extends d.v.f.h.a {
    private b0 b;
    private g c;
    private ServersFragment$a d;

    public static /* synthetic */ g j(ServersFragment serversFragment) {
        return serversFragment.c;
    }

    private void k() {
        this.c.d();
        j j10 = this.c.a;
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        Observer observer = new d.v.c.q1.i0.c(this);
        j10.observe(lifecycleOwner, observer);
        j10 = this.c.c;
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new f(this);
        j10.observe(lifecycleOwner, observer);
        j10 = this.c.b;
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new d.v.c.q1.i0.b(this);
        j10.observe(lifecycleOwner, observer);
    }

    private void l() {
        StatusView statusView = this.b.f;
        Object object = new d(this);
        statusView.setOnClickErrorListener((View.OnClickListener)object);
        statusView = this.b.b;
        object = a.a;
        statusView.setOnClickListener((View.OnClickListener)object);
    }

    private void m() {
        RecyclerView recyclerView = this.b.d;
        Context context = this.getContext();
        Object object = new LinearLayoutManager(context, 1, false);
        recyclerView.setLayoutManager((RecyclerView$LayoutManager)object);
        recyclerView = this.b.d;
        object = this.d;
        recyclerView.setAdapter((RecyclerView$Adapter)object);
        this.b.e.setEnabled(false);
    }

    private /* synthetic */ void n(DataListEntity object) {
        ServersFragment$a serversFragment$a = this.d;
        object = ((DataListEntity)object).list;
        serversFragment$a.d((List)object);
    }

    private /* synthetic */ void p(Boolean object) {
        boolean bl2 = (Boolean)object;
        if (bl2) {
            object = this.b.f;
            ((StatusView)((Object)object)).e();
        } else {
            object = this.b.f;
            ((StatusView)((Object)object)).a();
        }
    }

    private /* synthetic */ void r(Boolean object) {
        boolean bl2 = (Boolean)object;
        if (bl2) {
            object = this.b.f;
            ((StatusView)((Object)object)).d();
        }
    }

    private /* synthetic */ void t(View view) {
        this.c.d();
    }

    public int h() {
        return 2131558451;
    }

    public void i(ViewDataBinding viewDataBinding) {
        super.i(viewDataBinding);
        viewDataBinding = (b0)viewDataBinding;
        this.b = viewDataBinding;
    }

    public /* synthetic */ void o(DataListEntity dataListEntity) {
        this.n(dataListEntity);
    }

    public void onAttach(Context object) {
        super.onAttach((Context)object);
        object = (g)d.v.i0.b.c(this.requireActivity()).get(g.class);
        this.c = object;
        object = new ServersFragment$a(this);
        this.d = object;
        ArrayList arrayList = new ArrayList();
        ((c)object).d(arrayList);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        view = this.b.c;
        int n10 = -1;
        view.setBackgroundColor(n10);
        this.b.f.setBackgroundColor(n10);
        this.m();
        this.k();
        this.l();
    }

    public /* synthetic */ void q(Boolean bl2) {
        this.p(bl2);
    }

    public /* synthetic */ void s(Boolean bl2) {
        this.r(bl2);
    }

    public /* synthetic */ void u(View view) {
        this.t(view);
    }
}

