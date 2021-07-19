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
import com.zhiyun.cama.data.api.entity.ProductEntity;
import com.zhiyun.cama.data.database.model.Feedback;
import com.zhiyun.cama.me.help.FeedbackEditFragment$a;
import com.zhiyun.cama.me.help.FeedbackEditFragment$c;
import com.zhiyun.cama.me.help.data.FeedbackSet$Type;
import com.zhiyun.cama.me.help.view.AddImageRecyclerView;
import d.v.c.j1.a.a0;
import d.v.c.j1.a.k0;
import d.v.c.j1.a.m0;
import d.v.c.j1.a.o0;
import d.v.c.j1.a.s;
import d.v.c.j1.a.x;
import d.v.c.j1.a.y;
import d.v.c.j1.a.z;
import d.v.c.w0.ue;
import d.v.c.x1.l;
import d.v.e.i.j;
import d.v.f.h.a;
import d.v.g0.k$a;
import d.v.g0.k$b;
import d.v.i0.b;
import java.util.Arrays;
import java.util.List;

public class FeedbackEditFragment
extends a {
    private ue b;
    private o0 c;
    private TextWatcher d;

    public FeedbackEditFragment() {
        FeedbackEditFragment$a feedbackEditFragment$a = new FeedbackEditFragment$a(this);
        this.d = feedbackEditFragment$a;
    }

    public static /* synthetic */ o0 j(FeedbackEditFragment feedbackEditFragment) {
        return feedbackEditFragment.c;
    }

    public static /* synthetic */ void k(FeedbackEditFragment feedbackEditFragment) {
        feedbackEditFragment.m();
    }

    public static /* synthetic */ ue l(FeedbackEditFragment feedbackEditFragment) {
        return feedbackEditFragment.b;
    }

    private void m() {
        Object object = this.c.r.getValue();
        object = object == null ? "" : ((ProductEntity)this.c.r.getValue()).title;
        TextView textView = this.b.l;
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2 && !(bl2 = TextUtils.isEmpty((CharSequence)(object = this.b.e.getText().toString().trim())))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        textView.setEnabled(bl2);
    }

    private void n() {
        Object object = this.b.d;
        Object object2 = this.d;
        object.addTextChangedListener(object2);
        object = this.b.e;
        object2 = this.d;
        object.addTextChangedListener(object2);
        object = this.c.r;
        object2 = this.getViewLifecycleOwner();
        z z10 = new z(this);
        ((LiveData)object).observe((LifecycleOwner)object2, z10);
    }

    private /* synthetic */ void o(ProductEntity object) {
        FeedbackSet$Type feedbackSet$Type;
        object = (FeedbackSet$Type)((Object)this.c.p.getValue());
        if (object != null && (feedbackSet$Type = FeedbackSet$Type.FIRMWARE) == object) {
            this.m();
        }
    }

    private /* synthetic */ void q(Feedback object) {
        if (object != null) {
            Object object2 = object.getContent().trim();
            boolean bl2 = TextUtils.isEmpty((CharSequence)object2);
            String string2 = "";
            object2 = bl2 ? string2 : object.getContent();
            Object object3 = object.getContact().trim();
            boolean bl3 = TextUtils.isEmpty((CharSequence)object3);
            if (!bl3) {
                string2 = object.getContact();
            }
            object3 = this.b.d;
            String string3 = object.getTitle();
            object3.setText((CharSequence)string3);
            this.b.b.setText((CharSequence)object2);
            object3 = this.b.e;
            string3 = object.getTitle();
            object3.setText((CharSequence)string3);
            object3 = this.b.c;
            object3.setText((CharSequence)object2);
            this.b.a.setText((CharSequence)string2);
            object2 = object.getImages();
            bl2 = TextUtils.isEmpty((CharSequence)object2);
            if (!bl2) {
                object = object.getImages().trim().split(",");
                object2 = this.b.h;
                object = Arrays.asList(object);
                ((AddImageRecyclerView)object2).setImages((List)object);
            }
        }
    }

    private /* synthetic */ void s(Boolean object) {
        boolean bl2 = (Boolean)object;
        if (bl2) {
            object = this.getActivity();
            d.v.g0.s.t((FragmentActivity)object);
        } else {
            d.v.g0.s.j();
        }
    }

    private /* synthetic */ void u(String object) {
        Context context = this.getContext();
        Object object2 = new k$b(context);
        object = (k$b)((k$a)object2).B((String)object);
        object2 = this.getChildFragmentManager();
        ((k$a)object).D((FragmentManager)object2);
    }

    private /* synthetic */ void w(Boolean bl2) {
        boolean bl3 = bl2;
        if (bl3) {
            l.h(this);
        }
    }

    public int h() {
        return 2131558699;
    }

    public void i(ViewDataBinding viewDataBinding) {
        super.i(viewDataBinding);
        viewDataBinding = (ue)viewDataBinding;
        this.b = viewDataBinding;
        FeedbackEditFragment$c feedbackEditFragment$c = new FeedbackEditFragment$c(this);
        ((ue)viewDataBinding).A(feedbackEditFragment$c);
    }

    public void onActivityResult(int n10, int n11, Intent intent) {
        super.onActivityResult(n10, n11, intent);
        AddImageRecyclerView addImageRecyclerView = this.b.h;
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

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.c.J();
    }

    public void onViewCreated(View object, Bundle object2) {
        super.onViewCreated((View)object, (Bundle)object2);
        object = this.b;
        object2 = this.c;
        ((ue)object).B((o0)object2);
        object = this.c;
        object2 = this.requireContext();
        boolean bl2 = true;
        ((o0)object).G((Context)object2, bl2);
        object = this.getArguments();
        if (object != null && (object = m0.b(this.getArguments()).c()) != null) {
            object2 = this.c;
            ((o0)object2).m((Feedback)object);
        }
        object = this.c.q;
        object2 = this.getViewLifecycleOwner();
        Observer observer = new a0(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.c.j;
        object2 = this.getViewLifecycleOwner();
        observer = new x(this);
        ((j)object).observe((LifecycleOwner)object2, observer);
        object = this.c.k;
        object2 = this.getViewLifecycleOwner();
        observer = new y(this);
        ((j)object).observe((LifecycleOwner)object2, observer);
        object = this.c.l;
        object2 = this.getViewLifecycleOwner();
        observer = k0.a;
        ((j)object).observe((LifecycleOwner)object2, observer);
        object = this.c.m;
        object2 = this.getViewLifecycleOwner();
        observer = new s(this);
        ((j)object).observe((LifecycleOwner)object2, observer);
        this.b.h.setFragment(this);
        this.n();
    }

    public /* synthetic */ void p(ProductEntity productEntity) {
        this.o(productEntity);
    }

    public /* synthetic */ void r(Feedback feedback) {
        this.q(feedback);
    }

    public /* synthetic */ void t(Boolean bl2) {
        this.s(bl2);
    }

    public /* synthetic */ void v(String string2) {
        this.u(string2);
    }

    public /* synthetic */ void x(Boolean bl2) {
        this.w(bl2);
    }
}

