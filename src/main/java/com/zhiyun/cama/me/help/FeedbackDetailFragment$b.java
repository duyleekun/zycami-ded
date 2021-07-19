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
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.data.database.model.Feedback;
import com.zhiyun.cama.me.help.FeedbackDetailFragment;
import com.zhiyun.cama.me.help.FeedbackDetailFragment$a;
import com.zhiyun.cama.me.help.data.FeedbackSet$DealStatus;
import com.zhiyun.cama.me.help.data.FeedbackSet$Type;
import d.v.c.j1.a.c;
import d.v.c.j1.a.d;
import d.v.c.j1.a.e;
import d.v.c.j1.a.f;
import d.v.c.j1.a.h;
import d.v.c.j1.a.i;
import d.v.c.j1.a.m0$b;
import d.v.c.j1.a.o0;
import d.v.c.x1.l;
import d.v.e.l.o1;
import d.v.f.f.a;
import d.v.f.i.g;
import d.v.g0.i$c;
import d.v.g0.k$a;
import d.v.g0.k$b;
import d.v.g0.o;
import java.util.ArrayList;

public class FeedbackDetailFragment$b {
    public final /* synthetic */ FeedbackDetailFragment a;

    public FeedbackDetailFragment$b(FeedbackDetailFragment feedbackDetailFragment) {
        this.a = feedbackDetailFragment;
    }

    private /* synthetic */ void c(Feedback feedback, DialogFragment object) {
        object = FeedbackDetailFragment.j(this.a);
        Context context = this.a.requireContext();
        ((o0)object).e(context, feedback);
    }

    public static /* synthetic */ void e(DialogFragment dialogFragment) {
    }

    private /* synthetic */ void f(Feedback feedback, DialogFragment object) {
        object = FeedbackDetailFragment.j(this.a);
        Context context = this.a.requireContext();
        ((o0)object).d(context, feedback);
    }

    public static /* synthetic */ void h(DialogFragment dialogFragment) {
    }

    private /* synthetic */ void i(Feedback object, View object2, int n10) {
        if (n10 == 0) {
            Object object3 = this.a.getContext();
            object2 = new k$b((Context)object3);
            object2 = (k$b)((k$a)object2).A(2131952619);
            n10 = 2131952321;
            object2 = (k$b)((k$a)object2).m(n10);
            object3 = new c(this, (Feedback)object);
            object = (k$b)((k$a)object2).w((a)object3);
            object2 = h.a;
            object = (k$b)((k$a)object).p((a)object2);
            object2 = this.a.getChildFragmentManager();
            ((k$a)object).D((FragmentManager)object2);
        } else {
            int n11 = 1;
            if (n11 == n10) {
                MutableLiveData mutableLiveData = FeedbackDetailFragment.j((FeedbackDetailFragment)this.a).p;
                Object object4 = FeedbackSet$Type.from(((Feedback)object).getType());
                mutableLiveData.setValue(object4);
                n10 = 2131362443;
                object4 = new m0$b();
                object = ((m0$b)object4).c((Feedback)object).a().d();
                l.b((View)object2, n10, (Bundle)object);
            }
        }
    }

    public static /* synthetic */ void k(View view, int n10) {
        l.a(view, 2131362442);
    }

    private /* synthetic */ void l(Feedback object, int n10) {
        Object object2 = this.a.getContext();
        Object object3 = new k$b((Context)object2);
        object3 = (k$b)((k$b)((k$a)object3).A(2131952619)).m(2131952260);
        object2 = new d.v.c.j1.a.g(this, (Feedback)object);
        object = (k$b)((k$a)object3).w((a)object2);
        object3 = e.a;
        object = (k$b)((k$a)object).p((a)object3);
        object3 = this.a.getChildFragmentManager();
        ((k$a)object).D((FragmentManager)object3);
    }

    public void a(View view) {
        l.a(view, 2131362440);
    }

    public void b(View view) {
        l.g(view);
    }

    public /* synthetic */ void d(Feedback feedback, DialogFragment dialogFragment) {
        this.c(feedback, dialogFragment);
    }

    public /* synthetic */ void g(Feedback feedback, DialogFragment dialogFragment) {
        this.f(feedback, dialogFragment);
    }

    public /* synthetic */ void j(Feedback feedback, View view, int n10) {
        this.i(feedback, view, n10);
    }

    public /* synthetic */ void m(Feedback feedback, int n10) {
        this.l(feedback, n10);
    }

    public void n(View object, Feedback object2, FeedbackSet$DealStatus object3) {
        if (object2 != null && object3 != null) {
            int n10;
            ArrayList<Object> arrayList = new ArrayList<Object>();
            int n11 = 0;
            Object object4 = null;
            Context context = this.a.requireContext();
            int n12 = o1.a(context, 2131099739);
            int[] nArray = FeedbackDetailFragment$a.a;
            int n13 = object3.ordinal();
            int n14 = 1;
            if ((n13 = nArray[n13]) != n14) {
                n14 = 2;
                if (n13 != n14) {
                    n10 = 3;
                    if (n13 == n10) {
                        object3 = this.a.requireContext();
                        n11 = 2131951911;
                        object3 = g.m((Context)object3, n11);
                        object = new o((String)object3, n12);
                        arrayList.add(object);
                        object4 = new d(this, (Feedback)object2);
                    }
                } else {
                    object3 = this.a.requireContext();
                    n11 = 2131952289;
                    object3 = g.m((Context)object3, n11);
                    object2 = new o((String)object3, n12);
                    arrayList.add(object2);
                    object4 = new f((View)object);
                }
            } else {
                object4 = g.m(this.a.requireContext(), 2131952320);
                object3 = new o((String)object4, n12);
                arrayList.add(object3);
                object4 = this.a.requireContext();
                n14 = 2131952603;
                object4 = g.m((Context)object4, n14);
                object3 = new o((String)object4, n12);
                arrayList.add(object3);
                object4 = new i(this, (Feedback)object2, (View)object);
            }
            if (object4 == null) {
                return;
            }
            n10 = 0;
            object = d.v.g0.i.w(false).B(arrayList).D((i$c)object4);
            object2 = this.a.getChildFragmentManager();
            object3 = d.v.g0.i.class.getName();
            ((DialogFragment)object).show((FragmentManager)object2, (String)object3);
        }
    }
}

