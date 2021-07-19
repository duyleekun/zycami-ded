/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.view.View
 */
package com.zhiyun.cama.set;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.core.util.Pair;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.zhiyun.account.SimpleWebViewActivity;
import com.zhiyun.cama.camera.data.CameraSet$Mode;
import com.zhiyun.cama.set.SetFragment;
import d.v.a.f.c.b;
import d.v.c.q1.g0;
import d.v.c.q1.m;
import d.v.c.q1.n;
import d.v.c.q1.o;
import d.v.c.s0.u6;
import d.v.c.x1.l;
import d.v.f.f.a;
import d.v.f.i.g;
import d.v.g0.k$a;
import d.v.g0.k$b;

public class SetFragment$a {
    public final /* synthetic */ SetFragment a;

    public SetFragment$a(SetFragment setFragment) {
        this.a = setFragment;
    }

    public static /* synthetic */ void i(View view, DialogFragment dialogFragment) {
        b.N().C();
        l.g(view);
    }

    public static /* synthetic */ void j(DialogFragment dialogFragment) {
    }

    public static /* synthetic */ void k(DialogFragment dialogFragment) {
    }

    private /* synthetic */ void l(DialogFragment object) {
        SetFragment.j(this.a).M();
        object = SetFragment.k(this.a);
        CameraSet$Mode cameraSet$Mode = CameraSet$Mode.video;
        ((u6)object).N1(cameraSet$Mode);
        SetFragment.l(this.a).P();
    }

    public void a(View view) {
        l.a(view, 2131363189);
    }

    public void b(View view) {
        l.g(view);
    }

    public void c(View object) {
        long l10;
        long l11;
        long l12;
        long l13;
        Object object2 = SetFragment.j((SetFragment)this.a).j.getValue();
        if (object2 != null && (l13 = (l12 = (l11 = ((Long)(object2 = (Long)((Pair)SetFragment.j((SetFragment)this.a).j.getValue()).first)).longValue()) - (l10 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0) {
            l13 = 2131363190;
            l.a(object, (int)l13);
        } else {
            object2 = SetFragment.j(this.a);
            int n10 = 2131952880;
            object = g.q(object, n10);
            ((g0)object2).S((String)object);
        }
    }

    public void d(View object) {
        object = this.a.requireActivity();
        String string2 = g.o(this.a.getResources(), 2131951876);
        String string3 = g.o(this.a.getResources(), 2131951874);
        SimpleWebViewActivity.h((Activity)object, string2, string3);
    }

    public void e(View view) {
        l.a(view, 2131362920);
    }

    public void f(View view) {
        l.a(view, 2131362444);
    }

    public void g(View view) {
        l.a(view, 2131363196);
    }

    public void h(View view) {
        l.a(view, 2131363198);
    }

    public /* synthetic */ void m(DialogFragment dialogFragment) {
        this.l(dialogFragment);
    }

    public void n(View object) {
        Object object2 = this.a.getContext();
        Object object3 = new k$b((Context)object2);
        object3 = (k$b)((k$a)object3).A(2131952541);
        object2 = new o((View)object);
        object = (k$b)((k$a)object3).w((a)object2);
        object3 = d.v.c.q1.l.a;
        object = (k$b)((k$a)object).p((a)object3);
        object3 = this.a.getChildFragmentManager();
        ((k$a)object).D((FragmentManager)object3);
    }

    public void o(View object) {
        Object object2 = this.a.getContext();
        object = new k$b((Context)object2);
        object = (k$b)((k$a)object).A(2131952918);
        object2 = m.a;
        object = (k$b)((k$a)object).p((a)object2);
        object2 = new n(this);
        object = (k$b)((k$a)object).w((a)object2);
        object2 = this.a.getChildFragmentManager();
        ((k$a)object).D((FragmentManager)object2);
    }
}

