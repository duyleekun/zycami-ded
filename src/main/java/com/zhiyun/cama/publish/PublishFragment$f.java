/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.InputFilter
 *  android.text.TextUtils
 *  android.view.View
 *  android.webkit.URLUtil
 *  android.widget.ImageView
 */
package com.zhiyun.cama.publish;

import android.content.Context;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.ImageView;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.data.database.model.PublishWorks;
import com.zhiyun.cama.publish.PublishFragment;
import com.zhiyun.cama.splash.SplashActivity;
import com.zhiyun.common.util.Times;
import com.zhiyun.image.Images;
import d.v.c.n1.a;
import d.v.c.n1.h0;
import d.v.c.n1.i0;
import d.v.c.n1.j0;
import d.v.c.n1.j2;
import d.v.c.n1.k0;
import d.v.c.n1.l0;
import d.v.c.n1.m0;
import d.v.c.n1.n0;
import d.v.c.n1.o0;
import d.v.c.n1.p0;
import d.v.c.n1.q0;
import d.v.c.n1.r0;
import d.v.c.u0.l;
import d.v.c.u0.m;
import d.v.c.u0.n;
import d.v.e.g.e;
import d.v.e.i.h;
import d.v.e.i.j;
import d.v.e.l.b2;
import d.v.e.l.n2;
import d.v.e.l.s1;
import d.v.f.i.f;
import d.v.f.i.g;
import d.v.g0.k;
import d.v.g0.k$a;
import d.v.g0.k$b;
import d.v.i0.b;

public class PublishFragment$f {
    public final /* synthetic */ PublishFragment a;

    public PublishFragment$f(PublishFragment publishFragment) {
        this.a = publishFragment;
    }

    private /* synthetic */ void f(String string2) {
        boolean bl2 = s1.q(string2);
        if (bl2) {
            PublishFragment.v(this.a).m0(string2);
            ImageView imageView = PublishFragment.m((PublishFragment)this.a).k;
            Images.e(imageView, string2);
        }
    }

    private /* synthetic */ void h() {
        SplashActivity.m(this.a.requireActivity());
    }

    private /* synthetic */ void j() {
        FragmentActivity fragmentActivity = this.a.requireActivity();
        n0 n02 = new n0(this);
        fragmentActivity.runOnUiThread(n02);
    }

    private /* synthetic */ void l(View view) {
        this.A(view);
    }

    private /* synthetic */ void n(DialogFragment object) {
        ((DialogFragment)object).dismissAllowingStateLoss();
        object = PublishFragment.v(this.a);
        l0 l02 = new l0(this);
        ((j2)object).j0(l02);
    }

    private /* synthetic */ void p(View view) {
        FragmentActivity fragmentActivity = this.a.requireActivity();
        i0 i02 = new i0(this, view);
        fragmentActivity.runOnUiThread(i02);
    }

    public static /* synthetic */ void r(DialogFragment dialogFragment) {
    }

    private /* synthetic */ void s(DialogFragment dialogFragment) {
        PublishFragment.m((PublishFragment)this.a).b.setChecked(false);
    }

    private /* synthetic */ void u(DialogFragment dialogFragment) {
        this.H();
    }

    private /* synthetic */ void w(DialogFragment dialogFragment) {
        Object object = dialogFragment;
        object = ((k)dialogFragment).G();
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2) {
            return;
        }
        PublishFragment.m((PublishFragment)this.a).C.setTag(object);
        dialogFragment.dismiss();
    }

    private /* synthetic */ void y(DialogFragment dialogFragment) {
        PublishFragment.m((PublishFragment)this.a).b.setChecked(false);
    }

    public void A(View object) {
        Object object2 = this.a.requireContext();
        boolean bl2 = b2.m((Context)object2);
        if (!bl2) {
            n2.e(g.m(this.a.requireContext(), 2131952518));
            return;
        }
        object2 = PublishFragment.v(this.a);
        bl2 = ((j2)object2).a0();
        if (bl2) {
            bl2 = false;
            object.setEnabled(false);
            object2 = PublishFragment.v(this.a).R();
            PublishFragment publishFragment = this.a;
            String string2 = PublishFragment.v(publishFragment).u();
            int n10 = PublishFragment.p(publishFragment, string2);
            if (n10 == 0 && (n10 = URLUtil.isHttpsUrl((String)object2)) == 0 && !(bl2 = URLUtil.isHttpUrl((String)object2))) {
                object = PublishFragment.v(this.a);
                object2 = this.a.requireContext();
                n10 = 2131952070;
                object2 = g.m((Context)object2, n10);
                ((j2)object).t0((String)object2);
            } else {
                object2 = this.a.getContext();
                bl2 = b2.l((Context)object2);
                if (bl2 && !(bl2 = ((j2)(object2 = PublishFragment.v(this.a))).S())) {
                    object.setEnabled(true);
                    PublishFragment.q(this.a);
                    return;
                }
                object = this.a;
                PublishFragment.r((PublishFragment)object);
            }
        } else {
            object = this.a;
            PublishFragment.s((PublishFragment)object);
        }
    }

    public void B(View object) {
        PublishWorks publishWorks = PublishFragment.t(this.a);
        if (publishWorks == null) {
            this.a((View)object);
        }
        object = this.a;
        publishWorks = PublishFragment.t((PublishFragment)object);
        PublishFragment.n((PublishFragment)object, publishWorks);
    }

    public void C(View object) {
        Object object2 = this.a.requireContext();
        object = new k$b((Context)object2);
        object2 = g.o(this.a.getResources(), 2131951886);
        object = (k$b)((k$a)object).B((String)object2);
        object2 = g.o(this.a.getResources(), 2131951833);
        d.v.f.f.a a10 = d.v.c.n1.a.a;
        object = (k$b)((k$a)object).q((String)object2, a10);
        object2 = g.o(this.a.getResources(), 2131951887);
        a10 = new p0(this);
        object = (k$b)((k$a)object).x((String)object2, a10);
        object2 = this.a.getChildFragmentManager();
        ((k$a)object).D((FragmentManager)object2);
    }

    public void D(View view) {
        Object object;
        boolean bl2;
        Object object2 = PublishFragment.v(this.a).R();
        if (object2 != null && (bl2 = ((String)(object2 = PublishFragment.v(this.a).R())).startsWith((String)(object = "content://")))) {
            this.A(view);
            return;
        }
        object2 = PublishFragment.v(this.a);
        object = new h0(this, view);
        ((j2)object2).j0((e)object);
    }

    public void E(View object) {
        Object object2 = this.a.requireContext();
        object = new k$b((Context)object2);
        object = (k$b)((k$b)((k$b)((k$a)object).A(2131952805)).m(2131952803)).s();
        object2 = m0.a;
        object = (k$b)((k$a)object).v(2131952804, (d.v.f.f.a)object2);
        object2 = this.a.getChildFragmentManager();
        ((k$a)object).D((FragmentManager)object2);
    }

    public void F() {
        Object object = PublishFragment.w(this.a);
        boolean bl2 = ((l)object).l();
        if (bl2) {
            this.H();
            return;
        }
        Object object2 = this.a.requireContext();
        object = new k$b((Context)object2);
        object = (k$b)((k$a)object).A(2131952806);
        object2 = new r0(this);
        object = (k$b)((k$b)((k$a)object).p((d.v.f.f.a)object2)).s();
        object2 = new k0(this);
        object = (k$b)((k$a)object).w((d.v.f.f.a)object2);
        object2 = this.a.getChildFragmentManager();
        ((k$a)object).D((FragmentManager)object2);
    }

    public void G() {
        Object object = PublishFragment.u(this.a);
        Object object2 = PublishFragment.m(this.a).getRoot();
        object.showAtLocation(object2, 80, 0, 0);
        object = PublishFragment.v(this.a).M();
        object2 = Boolean.TRUE;
        h.g((MutableLiveData)object, object2);
    }

    public void H() {
        Object object = this.a.requireContext();
        k$b k$b = new k$b((Context)object);
        k$b = (k$b)k$b.A(2131952807);
        object = g.o(this.a.getResources(), 2131952808);
        k$b = (k$b)k$b.i((String)object);
        object = Times.TIME_DOT.getDate();
        k$b = (k$b)((k$b)k$b.k((String)object)).E(true);
        object = f.c();
        k$b = (k$b)((k$b)k$b.a((InputFilter)object)).s();
        object = new j0(this);
        k$b = (k$b)k$b.p((d.v.f.f.a)object);
        object = new q0(this);
        k$b = (k$b)k$b.w((d.v.f.f.a)object);
        object = this.a.getChildFragmentManager();
        k$b.D((FragmentManager)object);
    }

    public void I(View view) {
        ActivityCompat.finishAfterTransition(this.a.requireActivity());
    }

    public void a(View view) {
        PublishFragment.v(this.a).k();
        PublishFragment.k(this.a, true);
    }

    public void b(View view) {
        view = PublishFragment.m((PublishFragment)this.a).b;
        boolean bl2 = view.isChecked();
        if (bl2) {
            PublishFragment.m((PublishFragment)this.a).b.setChecked(false);
            PublishFragment.m((PublishFragment)this.a).C.setTag((Object)"");
            return;
        }
        PublishFragment.m((PublishFragment)this.a).b.setChecked(true);
        this.F();
    }

    public void c(View view) {
        PublishFragment.o(this.a);
    }

    public void d(View view) {
        PublishFragment publishFragment = this.a;
        boolean bl2 = PublishFragment.j(publishFragment);
        if (!bl2) {
            this.a(view);
        }
    }

    public void e(View object) {
        object = this.a.getChildFragmentManager().beginTransaction();
        LifecycleOwner lifecycleOwner = n.J(n.B(PublishFragment.v(this.a).u(), 0));
        ((FragmentTransaction)object).replace(2131362470, (Fragment)lifecycleOwner).commit();
        object = ((m)b.c(this.a.requireActivity()).get(m.class)).d();
        lifecycleOwner = this.a.getViewLifecycleOwner();
        o0 o02 = new o0(this);
        ((j)object).observe(lifecycleOwner, o02);
    }

    public /* synthetic */ void g(String string2) {
        this.f(string2);
    }

    public /* synthetic */ void i() {
        this.h();
    }

    public /* synthetic */ void k() {
        this.j();
    }

    public /* synthetic */ void m(View view) {
        this.l(view);
    }

    public /* synthetic */ void o(DialogFragment dialogFragment) {
        this.n(dialogFragment);
    }

    public /* synthetic */ void q(View view) {
        this.p(view);
    }

    public /* synthetic */ void t(DialogFragment dialogFragment) {
        this.s(dialogFragment);
    }

    public /* synthetic */ void v(DialogFragment dialogFragment) {
        this.u(dialogFragment);
    }

    public /* synthetic */ void x(DialogFragment dialogFragment) {
        this.w(dialogFragment);
    }

    public /* synthetic */ void z(DialogFragment dialogFragment) {
        this.y(dialogFragment);
    }
}

