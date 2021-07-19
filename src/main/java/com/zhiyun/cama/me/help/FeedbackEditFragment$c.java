/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.view.View
 *  android.widget.ScrollView
 */
package com.zhiyun.cama.me.help;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.widget.ScrollView;
import com.zhiyun.cama.data.database.model.Feedback;
import com.zhiyun.cama.me.help.FeedbackEditFragment;
import d.v.c.j1.a.o0;
import d.v.c.j1.a.t;
import d.v.c.j1.a.u;
import d.v.c.j1.a.v;
import d.v.c.j1.a.w;
import d.v.c.x1.l;
import d.v.e.l.h2;
import java.util.List;

public class FeedbackEditFragment$c {
    public final /* synthetic */ FeedbackEditFragment a;

    public FeedbackEditFragment$c(FeedbackEditFragment feedbackEditFragment) {
        this.a = feedbackEditFragment;
    }

    private /* synthetic */ void c(int n10) {
        FeedbackEditFragment.j(this.a).M(n10);
    }

    private /* synthetic */ void e(int n10) {
        o0 o02 = FeedbackEditFragment.j(this.a);
        Context context = this.a.requireContext();
        o02.N(context, n10);
    }

    private /* synthetic */ void g(int n10) {
        FeedbackEditFragment.j(this.a).P(n10);
    }

    private /* synthetic */ void i(int n10) {
        FeedbackEditFragment.j(this.a).Q(n10);
    }

    public void a(View view, Feedback feedback) {
        o0 o02 = FeedbackEditFragment.j(this.a);
        Context context = this.a.requireContext();
        String string2 = FeedbackEditFragment.l((FeedbackEditFragment)this.a).d.getText().toString();
        String string3 = FeedbackEditFragment.l((FeedbackEditFragment)this.a).b.getText().toString();
        String string4 = FeedbackEditFragment.l((FeedbackEditFragment)this.a).e.getText().toString();
        String string5 = FeedbackEditFragment.l((FeedbackEditFragment)this.a).c.getText().toString();
        String string6 = FeedbackEditFragment.l((FeedbackEditFragment)this.a).a.getText().toString();
        List list = FeedbackEditFragment.l((FeedbackEditFragment)this.a).h.getImages();
        o02.g(context, feedback, string2, string3, string4, string5, string6, list);
    }

    public void b(View view) {
        l.g(view);
    }

    public /* synthetic */ void d(int n10) {
        this.c(n10);
    }

    public /* synthetic */ void f(int n10) {
        this.e(n10);
    }

    public /* synthetic */ void h(int n10) {
        this.g(n10);
    }

    public /* synthetic */ void j(int n10) {
        this.i(n10);
    }

    public void k(View view) {
        Context context = this.a.getContext();
        String string2 = FeedbackEditFragment.l((FeedbackEditFragment)this.a).j.getText().toString();
        ColorStateList colorStateList = FeedbackEditFragment.l((FeedbackEditFragment)this.a).j.getTextColors();
        List list = FeedbackEditFragment.j((FeedbackEditFragment)this.a).C;
        t t10 = new t(this);
        d.v.c.j1.a.q0.l.h(context, view, string2, colorStateList, list, t10);
    }

    public void l(View view) {
        o0 o02 = FeedbackEditFragment.j(this.a);
        Context context = this.a.requireContext();
        o02.G(context, false);
        context = this.a.getContext();
        String string2 = FeedbackEditFragment.l((FeedbackEditFragment)this.a).m.getText().toString();
        ColorStateList colorStateList = FeedbackEditFragment.l((FeedbackEditFragment)this.a).m.getTextColors();
        List list = FeedbackEditFragment.j((FeedbackEditFragment)this.a).w;
        v v10 = new v(this);
        d.v.c.j1.a.q0.l.g(context, view, string2, colorStateList, list, v10);
    }

    public void m(View view) {
        o0 o02 = FeedbackEditFragment.j(this.a);
        Context context = this.a.requireContext();
        o02.H(context, false);
        context = this.a.getContext();
        String string2 = FeedbackEditFragment.l((FeedbackEditFragment)this.a).n.getText().toString();
        ColorStateList colorStateList = FeedbackEditFragment.l((FeedbackEditFragment)this.a).n.getTextColors();
        List list = FeedbackEditFragment.j((FeedbackEditFragment)this.a).y;
        w w10 = new w(this);
        d.v.c.j1.a.q0.l.g(context, view, string2, colorStateList, list, w10);
    }

    public void n(View view) {
        int n10 = view.getTop();
        float f10 = 210.0f;
        int n11 = h2.b(f10);
        n10 += n11;
        n11 = FeedbackEditFragment.l((FeedbackEditFragment)this.a).i.getHeight();
        n10 -= n11;
        n11 = FeedbackEditFragment.l((FeedbackEditFragment)this.a).l.getHeight();
        ScrollView scrollView = FeedbackEditFragment.l((FeedbackEditFragment)this.a).i;
        if ((n10 -= n11) > (n11 = scrollView.getScrollY())) {
            scrollView = FeedbackEditFragment.l((FeedbackEditFragment)this.a).i;
            scrollView.scrollTo(0, n10);
        }
        scrollView = this.a.getContext();
        String string2 = FeedbackEditFragment.l((FeedbackEditFragment)this.a).k.getText().toString();
        ColorStateList colorStateList = FeedbackEditFragment.l((FeedbackEditFragment)this.a).k.getTextColors();
        List list = FeedbackEditFragment.j((FeedbackEditFragment)this.a).A;
        u u10 = new u(this);
        d.v.c.j1.a.q0.l.h((Context)scrollView, view, string2, colorStateList, list, u10);
    }
}

