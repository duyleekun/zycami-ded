/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.ImageView
 */
package com.zhiyun.cama.me.help;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.zhiyun.account.widget.StatusView;
import com.zhiyun.cama.data.PagingRequestHelper$Status;
import com.zhiyun.cama.data.PagingRequestHelper$b;
import com.zhiyun.cama.data.database.model.Feedback;
import com.zhiyun.cama.me.help.FeedbackDetailFragment$a;
import com.zhiyun.cama.me.help.FeedbackDetailFragment$b;
import com.zhiyun.cama.me.help.data.FeedbackSet$DealStatus;
import com.zhiyun.image.Images;
import d.v.c.j1.a.j;
import d.v.c.j1.a.k;
import d.v.c.j1.a.k0;
import d.v.c.j1.a.l;
import d.v.c.j1.a.m;
import d.v.c.j1.a.o0;
import d.v.c.w0.qe;
import d.v.e.l.h2;
import d.v.f.h.a;
import d.v.g0.s;
import d.v.i0.b;

public class FeedbackDetailFragment
extends a {
    private qe b;
    private o0 c;

    public static /* synthetic */ o0 j(FeedbackDetailFragment feedbackDetailFragment) {
        return feedbackDetailFragment.c;
    }

    private /* synthetic */ void k(View view) {
        this.c.K();
    }

    private /* synthetic */ void m(Integer n10) {
        o0 o02 = this.c;
        int n11 = n10;
        o02.F(n11);
    }

    private /* synthetic */ void o(PagingRequestHelper$b object) {
        if (object == null) {
            return;
        }
        Object object2 = this.b;
        PagingRequestHelper$Status pagingRequestHelper$Status = ((PagingRequestHelper$b)object).a;
        ((qe)object2).F(pagingRequestHelper$Status);
        object2 = FeedbackDetailFragment$a.b;
        object = ((PagingRequestHelper$b)object).a;
        Object object3 = ((Enum)object).ordinal();
        object3 = object2[object3];
        Object object4 = 1;
        if (object3 != object4) {
            object4 = 2;
            if (object3 != object4) {
                object4 = 3;
                if (object3 == object4) {
                    object = this.b.h;
                    ((StatusView)((Object)object)).d();
                }
            } else {
                object = this.b.h;
                ((StatusView)((Object)object)).a();
            }
        } else {
            object = this.b.h;
            ((StatusView)((Object)object)).e();
        }
    }

    private /* synthetic */ void q(Feedback object) {
        if (object != null) {
            this.b.E((Feedback)object);
            Object object2 = this.b;
            Object object3 = new StringBuilder();
            int n10 = object.getDealStatus();
            object3.append(n10);
            String string2 = "";
            object3.append(string2);
            object3 = FeedbackSet$DealStatus.from(object3.toString());
            ((qe)object2).D((FeedbackSet$DealStatus)((Object)object3));
            object2 = object.getImages();
            int n11 = TextUtils.isEmpty((CharSequence)object2);
            if (n11 == 0) {
                object = object.getImages().trim().split(",");
                this.b.g.setVisibility(0);
                object2 = this.b.b;
                object3 = object[0];
                n10 = 0x41000000;
                float f10 = 8.0f;
                int n12 = h2.b(f10);
                Images.G((ImageView)object2, object3, n12);
                n11 = ((String[])object).length;
                int n13 = 1;
                if (n11 > n13) {
                    object2 = this.b.d;
                    object3 = object[n13];
                    n12 = h2.b(f10);
                    Images.G((ImageView)object2, object3, n12);
                }
                if ((n11 = ((String[])object).length) > (n13 = 2)) {
                    object2 = this.b.c;
                    object = object[n13];
                    n13 = h2.b(f10);
                    Images.G((ImageView)object2, object, n13);
                }
            } else {
                object = this.b.g;
                n11 = 8;
                object.setVisibility(n11);
            }
        }
    }

    private /* synthetic */ void s(Boolean object) {
        boolean bl2 = (Boolean)object;
        if (bl2) {
            object = this.getActivity();
            s.t((FragmentActivity)object);
        } else {
            s.j();
        }
    }

    public int h() {
        return 2131558697;
    }

    public void i(ViewDataBinding viewDataBinding) {
        super.i(viewDataBinding);
        viewDataBinding = (qe)viewDataBinding;
        this.b = viewDataBinding;
        FeedbackDetailFragment$b feedbackDetailFragment$b = new FeedbackDetailFragment$b(this);
        ((qe)viewDataBinding).C(feedbackDetailFragment$b);
    }

    public /* synthetic */ void l(View view) {
        this.k(view);
    }

    public /* synthetic */ void n(Integer n10) {
        this.m(n10);
    }

    public void onAttach(Context object) {
        super.onAttach((Context)object);
        object = (o0)d.v.i0.b.c(this.requireActivity()).get(o0.class);
        this.c = object;
    }

    public void onViewCreated(View object, Bundle object2) {
        super.onViewCreated((View)object, (Bundle)object2);
        object = this.b.h;
        object2 = new d.v.c.j1.a.b(this);
        ((StatusView)((Object)object)).setOnClickErrorListener((View.OnClickListener)object2);
        object = this.c.f;
        object2 = this.getViewLifecycleOwner();
        Observer observer = new j(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.c.g;
        object2 = this.getViewLifecycleOwner();
        observer = new m(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.c.h;
        object2 = this.getViewLifecycleOwner();
        observer = new l(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.c.j;
        object2 = this.getViewLifecycleOwner();
        observer = new k(this);
        ((d.v.e.i.j)object).observe((LifecycleOwner)object2, observer);
        object = this.c.l;
        object2 = this.getViewLifecycleOwner();
        observer = k0.a;
        ((d.v.e.i.j)object).observe((LifecycleOwner)object2, observer);
    }

    public /* synthetic */ void p(PagingRequestHelper$b pagingRequestHelper$b) {
        this.o(pagingRequestHelper$b);
    }

    public /* synthetic */ void r(Feedback feedback) {
        this.q(feedback);
    }

    public /* synthetic */ void t(Boolean bl2) {
        this.s(bl2);
    }
}

