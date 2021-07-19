/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 */
package com.zhiyun.cama.me.help.list;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView$ItemDecoration;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import com.zhiyun.cama.data.database.model.Feedback;
import com.zhiyun.cama.me.help.list.FeedbackListFragment$a;
import d.v.c.h1.o;
import d.v.c.h1.p;
import d.v.c.j1.a.o0;
import d.v.c.j1.a.p0.a;
import d.v.c.x1.l;
import d.v.f.i.g;
import d.v.i0.b;

public class FeedbackListFragment
extends p {
    private o0 f;

    private /* synthetic */ void M(View view, int n10, Feedback object) {
        MutableLiveData mutableLiveData = this.f.f;
        object = ((Feedback)object).getId();
        mutableLiveData.setValue(object);
        l.a(view, 2131362441);
    }

    public void D() {
        this.f.I();
    }

    public void E() {
        this.f.L();
    }

    public /* synthetic */ void N(View view, int n10, Feedback feedback) {
        this.M(view, n10, feedback);
    }

    public o k() {
        FeedbackListFragment$a feedbackListFragment$a = new FeedbackListFragment$a();
        a a10 = new a(this);
        feedbackListFragment$a.m(a10);
        return feedbackListFragment$a;
    }

    public LiveData l() {
        return this.f.k();
    }

    public RecyclerView$ItemDecoration m() {
        return null;
    }

    public RecyclerView$LayoutManager n() {
        o o10 = this.c;
        Context context = this.getContext();
        return o10.d(context, 1);
    }

    public LiveData o() {
        return this.f.l();
    }

    public void s() {
        String string2 = g.m(this.requireContext(), 2131952301);
        this.I(string2);
        this.K(true);
    }

    public void t() {
        o0 o02;
        this.f = o02 = (o0)d.v.i0.b.c(this.requireActivity()).get(o0.class);
    }
}

