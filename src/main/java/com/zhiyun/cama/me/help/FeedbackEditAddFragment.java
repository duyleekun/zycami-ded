/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.text.TextWatcher
 *  android.view.View
 *  android.widget.TextView
 */
package com.zhiyun.cama.me.help;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.zhiyun.cama.me.help.FeedbackEditAddFragment$a;
import com.zhiyun.cama.me.help.FeedbackEditAddFragment$b;
import com.zhiyun.cama.me.help.view.AddImageRecyclerView;
import com.zhiyun.cama.me.help.view.AddImageRecyclerView$b;
import d.v.c.j1.a.k0;
import d.v.c.j1.a.n;
import d.v.c.j1.a.o;
import d.v.c.j1.a.o0;
import d.v.c.j1.a.p;
import d.v.c.j1.a.q;
import d.v.c.j1.a.r;
import d.v.c.w0.se;
import d.v.c.x1.l;
import d.v.e.i.j;
import d.v.f.h.a;
import d.v.g0.k$a;
import d.v.g0.k$b;
import d.v.g0.s;
import d.v.i0.b;

public class FeedbackEditAddFragment
extends a {
    private se b;
    private o0 c;

    public static /* synthetic */ void j(FeedbackEditAddFragment feedbackEditAddFragment) {
        feedbackEditAddFragment.m();
    }

    public static /* synthetic */ se k(FeedbackEditAddFragment feedbackEditAddFragment) {
        return feedbackEditAddFragment.b;
    }

    public static /* synthetic */ o0 l(FeedbackEditAddFragment feedbackEditAddFragment) {
        return feedbackEditAddFragment.c;
    }

    private void m() {
        Object object = this.b;
        TextView textView = ((se)object).e;
        object = ((se)object).d.getImages();
        int n10 = object.size();
        if (n10 <= 0 && (n10 = TextUtils.isEmpty((CharSequence)(object = this.b.a.getText().toString().trim())))) {
            n10 = 0;
            object = null;
        } else {
            n10 = 1;
        }
        textView.setEnabled(n10 != 0);
    }

    public static /* synthetic */ void n(FeedbackEditAddFragment feedbackEditAddFragment) {
        feedbackEditAddFragment.m();
    }

    private /* synthetic */ void o(Boolean object) {
        boolean bl2 = (Boolean)object;
        if (bl2) {
            object = this.getActivity();
            s.t((FragmentActivity)object);
        } else {
            s.j();
        }
    }

    private /* synthetic */ void q(String object) {
        Context context = this.getContext();
        Object object2 = new k$b(context);
        object = (k$b)((k$a)object2).B((String)object);
        object2 = this.getChildFragmentManager();
        ((k$a)object).D((FragmentManager)object2);
    }

    private /* synthetic */ void s(Boolean bl2) {
        boolean bl3 = bl2;
        if (bl3) {
            l.h(this);
        }
    }

    public static /* synthetic */ void u(Boolean bl2) {
    }

    public int h() {
        return 2131558698;
    }

    public void i(ViewDataBinding viewDataBinding) {
        super.i(viewDataBinding);
        viewDataBinding = (se)viewDataBinding;
        this.b = viewDataBinding;
        FeedbackEditAddFragment$b feedbackEditAddFragment$b = new FeedbackEditAddFragment$b(this);
        ((se)viewDataBinding).z(feedbackEditAddFragment$b);
    }

    public void onActivityResult(int n10, int n11, Intent intent) {
        super.onActivityResult(n10, n11, intent);
        AddImageRecyclerView addImageRecyclerView = this.b.d;
        String string2 = addImageRecyclerView.i(n10, n11, intent);
        n11 = (int)(TextUtils.isEmpty((CharSequence)string2) ? 1 : 0);
        if (n11 == 0) {
            j j10 = this.c.l;
            j10.setValue(string2);
        }
    }

    public void onAttach(Context object) {
        super.onAttach((Context)object);
        object = (o0)d.v.i0.b.c(this.requireActivity()).get(o0.class);
        this.c = object;
    }

    public void onViewCreated(View object, Bundle object2) {
        super.onViewCreated((View)object, (Bundle)object2);
        object = this.c.j;
        object2 = this.getViewLifecycleOwner();
        Observer observer = new n(this);
        ((j)object).observe((LifecycleOwner)object2, observer);
        object = this.c.k;
        object2 = this.getViewLifecycleOwner();
        observer = new o(this);
        ((j)object).observe((LifecycleOwner)object2, observer);
        object = this.c.l;
        object2 = this.getViewLifecycleOwner();
        observer = k0.a;
        ((j)object).observe((LifecycleOwner)object2, observer);
        object = this.c.m;
        object2 = this.getViewLifecycleOwner();
        observer = new q(this);
        ((j)object).observe((LifecycleOwner)object2, observer);
        object = this.c.n;
        object2 = this.getViewLifecycleOwner();
        observer = p.a;
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.b.a;
        object2 = new FeedbackEditAddFragment$a(this);
        object.addTextChangedListener((TextWatcher)object2);
        this.b.d.setFragment(this);
        object = this.b.d;
        object2 = new r(this);
        ((AddImageRecyclerView)object).setOnImageChangedListener((AddImageRecyclerView$b)object2);
    }

    public /* synthetic */ void p(Boolean bl2) {
        this.o(bl2);
    }

    public /* synthetic */ void r(String string2) {
        this.q(string2);
    }

    public /* synthetic */ void t(Boolean bl2) {
        this.s(bl2);
    }
}

