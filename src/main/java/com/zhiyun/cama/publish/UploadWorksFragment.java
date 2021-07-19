/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.util.Size
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.ImageView
 */
package com.zhiyun.cama.publish;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout$LayoutParams;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$ItemDecoration;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.zhiyun.cama.device.connect.help.SingleBindingAdapter;
import com.zhiyun.cama.publish.PublishActivity;
import com.zhiyun.cama.publish.UploadCEMediaInfo;
import com.zhiyun.cama.publish.UploadWorksFragment$a;
import com.zhiyun.editorinterface.compose.ComposeParams$Resolution;
import d.v.c.n1.d2;
import d.v.c.n1.l2;
import d.v.c.n1.p1;
import d.v.c.n1.q1;
import d.v.c.n1.r1;
import d.v.c.n1.s1;
import d.v.c.n1.t1;
import d.v.c.o0.p0;
import d.v.c.o0.x0;
import d.v.c.w0.mi;
import d.v.c.z0.j;
import d.v.c.z0.j$b;
import d.v.e.l.h2;
import d.v.f.h.a;
import d.v.i0.b;
import d.v.v.q.h;
import java.util.Objects;

public class UploadWorksFragment
extends a {
    private final int b;
    private final int c;
    private mi d;
    private p0 e;
    private SingleBindingAdapter f;
    private l2 g;
    private ObservableBoolean h;
    private int i;

    public UploadWorksFragment() {
        ObservableBoolean observableBoolean;
        this.b = 300050;
        this.c = 1800000;
        this.h = observableBoolean = new ObservableBoolean();
        this.i = -1;
    }

    private void A() {
        j j10 = new j();
        Object object = new p1(this);
        j10 = j10.y((j$b)object);
        object = this.getChildFragmentManager();
        j10.q((FragmentManager)object);
    }

    private void B(int n10) {
        Object object = this.g;
        ((l2)object).l();
        int n11 = this.i;
        if (n11 >= 0) {
            object = (UploadCEMediaInfo)this.f.getItem(n11);
            ((UploadCEMediaInfo)object).e(false);
            object = this.f;
            int bl2 = this.i;
            ((RecyclerView$Adapter)object).notifyItemChanged(bl2);
        }
        object = (UploadCEMediaInfo)this.f.getItem(n10);
        boolean bl2 = true;
        ((UploadCEMediaInfo)object).e(bl2);
        this.f.notifyItemChanged(n10);
        this.i = n10;
        this.h.set(bl2);
    }

    public static /* synthetic */ int j(UploadWorksFragment uploadWorksFragment) {
        return uploadWorksFragment.i;
    }

    public static /* synthetic */ SingleBindingAdapter k(UploadWorksFragment uploadWorksFragment) {
        return uploadWorksFragment.f;
    }

    public static /* synthetic */ void l(UploadWorksFragment uploadWorksFragment) {
        uploadWorksFragment.A();
    }

    private void m(ComposeParams$Resolution composeParams$Resolution) {
        Object object = this.f;
        int n10 = this.i;
        object = (UploadCEMediaInfo)((BaseQuickAdapter)object).getItem(n10);
        Size size = d.v.v.q.h.e0(((UploadCEMediaInfo)object).a().e());
        int n11 = composeParams$Resolution.getHeight();
        if (n11 >= (n10 = size.getHeight())) {
            composeParams$Resolution = ComposeParams$Resolution.RESOLUTION_ORIGINAL;
        }
        object = ((UploadCEMediaInfo)object).a().e();
        PublishActivity.m(this, (String)object, composeParams$Resolution);
    }

    private void n() {
        Object object = new SingleBindingAdapter(2131558620);
        this.f = object;
        object = this.d.c;
        Context context = this.getContext();
        Object object2 = new GridLayoutManager(context, 3);
        ((RecyclerView)object).setLayoutManager((RecyclerView$LayoutManager)object2);
        object = this.d.c;
        int n10 = h2.b(2.0f);
        object2 = new x0(n10);
        ((RecyclerView)object).addItemDecoration((RecyclerView$ItemDecoration)object2);
        this.d.c.setHasFixedSize(true);
        object = this.d.c;
        object2 = this.f;
        ((RecyclerView)object).setAdapter((RecyclerView$Adapter)object2);
        object = this.f;
        object2 = new r1(this);
        ((BaseQuickAdapter)object).setOnItemClickListener((OnItemClickListener)object2);
    }

    private void o() {
        ImageView imageView = this.d.a;
        s1 s12 = new s1(this);
        imageView.post((Runnable)s12);
    }

    private void p() {
        Object object = (l2)d.v.i0.b.a(this).get(l2.class);
        this.g = object;
        this.d.D((l2)object);
        object = this.d;
        Object object2 = this.h;
        ((mi)object).B((ObservableBoolean)object2);
        object = this.d;
        object2 = new UploadWorksFragment$a(this);
        ((mi)object).C((UploadWorksFragment$a)object2);
        object = this.g.j();
        object2 = this.getViewLifecycleOwner();
        Object object3 = this.f;
        object3.getClass();
        d2 d22 = new d2((SingleBindingAdapter)object3);
        ((d.v.e.i.j)object).observe((LifecycleOwner)object2, d22);
        object = this.g.g();
        object2 = this.getViewLifecycleOwner();
        object3 = new q1(this);
        ((LiveData)object).observe((LifecycleOwner)object2, (Observer)object3);
        object = this.g.i();
        object2 = this.getViewLifecycleOwner();
        object3 = new t1(this);
        ((LiveData)object).observe((LifecycleOwner)object2, (Observer)object3);
        this.g.k(2);
    }

    public static /* synthetic */ void q(UploadWorksFragment uploadWorksFragment, ComposeParams$Resolution composeParams$Resolution) {
        uploadWorksFragment.m(composeParams$Resolution);
    }

    private /* synthetic */ void r(BaseQuickAdapter baseQuickAdapter, View view, int n10) {
        this.B(n10);
    }

    private /* synthetic */ void t() {
        int n10 = this.d.a.getMeasuredWidth();
        int n11 = this.d.d.getMeasuredWidth();
        n10 = Math.max(n10, n11);
        n11 = h2.b(32.0f);
        ConstraintLayout$LayoutParams constraintLayout$LayoutParams = (ConstraintLayout$LayoutParams)this.d.e.getLayoutParams();
        constraintLayout$LayoutParams.setMarginEnd(n10 += n11);
        constraintLayout$LayoutParams.setMarginStart(n10);
        this.d.e.setLayoutParams((ViewGroup.LayoutParams)constraintLayout$LayoutParams);
    }

    private /* synthetic */ void v(Boolean object) {
        object = this.f.getData();
        boolean bl2 = object.isEmpty();
        if (bl2) {
            this.z();
        }
    }

    private /* synthetic */ void x(Boolean object) {
        object = this.f.getData();
        boolean bl2 = object.isEmpty();
        if (bl2) {
            this.z();
        }
    }

    private void z() {
        p0 p02 = this.e;
        boolean bl2 = Objects.isNull(p02);
        if (bl2) {
            Object object = this.getContext();
            this.e = p02 = new p0((Context)object);
            object = this.f;
            ((BaseQuickAdapter)object).setEmptyView((View)p02);
        }
        this.e.c(1);
    }

    public int h() {
        return 2131558805;
    }

    public void i(ViewDataBinding viewDataBinding) {
        super.i(viewDataBinding);
        viewDataBinding = (mi)viewDataBinding;
        this.d = viewDataBinding;
    }

    public void onActivityResult(int n10, int n11, Intent intent) {
        super.onActivityResult(n10, n11, intent);
        n11 = 4097;
        if (n10 == n11 && (n10 = (int)(d.v.c.m1.b.a() ? 1 : 0)) != 0) {
            this.A();
        }
    }

    public void onStop() {
        super.onStop();
        this.g.l();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.o();
        this.n();
        this.p();
        this.h.set(false);
    }

    public /* synthetic */ void s(BaseQuickAdapter baseQuickAdapter, View view, int n10) {
        this.r(baseQuickAdapter, view, n10);
    }

    public /* synthetic */ void u() {
        this.t();
    }

    public /* synthetic */ void w(Boolean bl2) {
        this.v(bl2);
    }

    public /* synthetic */ void y(Boolean bl2) {
        this.x(bl2);
    }
}

