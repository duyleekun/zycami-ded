/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.view.View
 */
package com.zhiyun.cama.me.help;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import com.zhiyun.cama.me.help.FeedbackDetailAddFragment$a;
import com.zhiyun.cama.me.help.FeedbackDetailAddFragment$b;
import d.v.c.j1.a.o0;
import d.v.c.w0.me;
import d.v.f.h.a;
import d.v.i0.b;
import java.util.List;

public class FeedbackDetailAddFragment
extends a {
    private me b;
    private o0 c;
    private FeedbackDetailAddFragment$a d;

    private /* synthetic */ void j(List list) {
        this.d.d(list);
    }

    public int h() {
        return 2131558695;
    }

    public void i(ViewDataBinding viewDataBinding) {
        super.i(viewDataBinding);
        viewDataBinding = (me)viewDataBinding;
        this.b = viewDataBinding;
        FeedbackDetailAddFragment$b feedbackDetailAddFragment$b = new FeedbackDetailAddFragment$b(this);
        ((me)viewDataBinding).z(feedbackDetailAddFragment$b);
    }

    public /* synthetic */ void k(List list) {
        this.j(list);
    }

    public void onAttach(Context object) {
        super.onAttach((Context)object);
        object = (o0)d.v.i0.b.c(this.requireActivity()).get(o0.class);
        this.c = object;
        object = new FeedbackDetailAddFragment$a();
        this.d = object;
    }

    public void onViewCreated(View object, Bundle object2) {
        super.onViewCreated((View)object, (Bundle)object2);
        object = this.c.i;
        object2 = this.getViewLifecycleOwner();
        d.v.c.j1.a.a a10 = new d.v.c.j1.a.a(this);
        ((LiveData)object).observe((LifecycleOwner)object2, a10);
        object = this.b.d;
        a10 = this.getContext();
        object2 = new LinearLayoutManager((Context)a10, 1, false);
        ((RecyclerView)object).setLayoutManager((RecyclerView$LayoutManager)object2);
        object = this.b.d;
        object2 = this.d;
        ((RecyclerView)object).setAdapter((RecyclerView$Adapter)object2);
    }
}

