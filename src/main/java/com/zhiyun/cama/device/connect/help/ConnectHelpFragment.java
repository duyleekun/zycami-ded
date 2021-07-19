/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.view.View
 */
package com.zhiyun.cama.device.connect.help;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.core.app.ActivityCompat;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.zhiyun.cama.device.connect.help.ConnectHelpFragment$a;
import com.zhiyun.cama.device.connect.help.SingleBindingAdapter;
import com.zhiyun.protocol.constants.Model;
import d.v.c.w0.b6;
import d.v.c.y0.b.u.c;
import d.v.f.g.b;
import d.v.f.h.a;
import d.v.f.i.g;
import java.util.ArrayList;

public class ConnectHelpFragment
extends a {
    private b6 b;
    private SingleBindingAdapter c;

    private void j() {
        ArrayList<d.v.c.y0.b.u.b> arrayList = new ArrayList<d.v.c.y0.b.u.b>();
        d.v.c.y0.b.u.b b10 = new d.v.c.y0.b.u.b();
        b10.d("SMOOTH-X");
        b10.e(2131231825);
        int n10 = 2131951974;
        String string2 = g.s(this, n10);
        b10.f(string2);
        arrayList.add(b10);
        b10 = new d.v.c.y0.b.u.b();
        b10.d("SMOOTH-XS");
        b10.e(2131231822);
        string2 = g.s(this, n10);
        b10.f(string2);
        arrayList.add(b10);
        b10 = new d.v.c.y0.b.u.b();
        string2 = Model.SMOOTHQ3.getName();
        b10.d(string2);
        b10.e(2131231824);
        String string3 = g.s(this, n10);
        b10.f(string3);
        arrayList.add(b10);
        this.c.addData(arrayList);
    }

    private void k() {
        this.requireActivity().setResult(5);
        ActivityCompat.finishAfterTransition(this.requireActivity());
    }

    private void l() {
        SingleBindingAdapter singleBindingAdapter;
        RecyclerView recyclerView = this.b.c;
        recyclerView.setHasFixedSize(true);
        this.c = singleBindingAdapter = new SingleBindingAdapter(2131558624);
        Object object = new int[]{2131362363, 2131363558};
        singleBindingAdapter.addChildClickViewIds((int)object);
        singleBindingAdapter = this.c;
        object = new d.v.c.y0.b.u.a;
        object(this);
        singleBindingAdapter.setOnItemChildClickListener((OnItemChildClickListener)object);
        singleBindingAdapter = this.c;
        recyclerView.setAdapter(singleBindingAdapter);
        this.j();
    }

    private /* synthetic */ void m(BaseQuickAdapter object, View object2, int n10) {
        int n11 = object2.getId();
        if (n11 == (n10 = 2131362363)) {
            this.k();
        } else {
            int n12;
            n11 = object2.getId();
            if (n11 == (n12 = 2131363558)) {
                object = new c();
                object2 = this.getChildFragmentManager();
                ((b)object).q((FragmentManager)object2);
            }
        }
    }

    public int h() {
        return 2131558562;
    }

    public void i(ViewDataBinding viewDataBinding) {
        super.i(viewDataBinding);
        viewDataBinding = (b6)viewDataBinding;
        this.b = viewDataBinding;
    }

    public /* synthetic */ void n(BaseQuickAdapter baseQuickAdapter, View view, int n10) {
        this.m(baseQuickAdapter, view, n10);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public void onViewCreated(View object, Bundle object2) {
        super.onViewCreated((View)object, (Bundle)object2);
        object = this.b;
        object2 = new ConnectHelpFragment$a(this);
        ((b6)object).z((ConnectHelpFragment$a)object2);
        this.l();
    }
}

