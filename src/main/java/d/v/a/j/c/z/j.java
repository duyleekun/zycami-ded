/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.view.View
 *  android.widget.FrameLayout
 */
package d.v.a.j.c.z;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.zhiyun.account.R$layout;
import com.zhiyun.account.me.account.widget.MeGetCodeView;
import com.zhiyun.account.me.account.widget.MeNameView;
import com.zhiyun.account.set.privacy.getcode.PrivateGetCodeStatus;
import d.v.a.g.i0;
import d.v.a.i.a.y0.d$b;
import d.v.a.j.c.y;
import d.v.a.j.c.z.a;
import d.v.a.j.c.z.b;
import d.v.a.j.c.z.c;
import d.v.a.j.c.z.d;
import d.v.a.j.c.z.e;
import d.v.a.j.c.z.f;
import d.v.a.j.c.z.g;
import d.v.a.j.c.z.h;
import d.v.a.j.c.z.i;
import d.v.a.j.c.z.j$a;
import d.v.a.j.c.z.j$b;
import d.v.a.j.c.z.k;
import d.v.g0.k$a;
import d.v.g0.k$b;
import d.v.g0.s;

public abstract class j
extends d.v.f.h.a
implements k {
    private i0 b;
    private y c;

    private /* synthetic */ void A(Boolean object) {
        boolean bl2 = (Boolean)object;
        if (bl2) {
            object = this.getActivity();
            s.t((FragmentActivity)object);
        } else {
            s.j();
        }
    }

    private /* synthetic */ void C(Boolean bl2) {
        bl2 = this.b.a;
        this.b((View)bl2);
    }

    private /* synthetic */ void E(String object) {
        Context context = this.getContext();
        Object object2 = new k$b(context);
        object = (k$b)((k$a)object2).B((String)object);
        object2 = this.getChildFragmentManager();
        ((k$a)object).D((FragmentManager)object2);
    }

    private /* synthetic */ void G(Boolean object) {
        boolean bl2 = (Boolean)object;
        if (bl2) {
            object = this.b.c;
            ((MeGetCodeView)((Object)object)).e();
        } else {
            object = this.b.c;
            ((MeGetCodeView)((Object)object)).f();
        }
    }

    private void I(String object, String string2) {
        MutableLiveData mutableLiveData = this.c.b;
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2 && !(bl2 = TextUtils.isEmpty((CharSequence)string2))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        object = bl2;
        mutableLiveData.setValue(object);
    }

    public static /* synthetic */ void j(j j10, String string2, String string3, String string4) {
        j10.n(string2, string3, string4);
    }

    public static /* synthetic */ y k(j j10) {
        return j10.c;
    }

    public static /* synthetic */ i0 l(j j10) {
        return j10.b;
    }

    private void m(boolean bl2) {
        this.b.b.setShowCode(bl2);
        this.c.j();
    }

    private void n(String string2, String string3, String string4) {
        y y10 = this.c;
        Context context = this.getContext();
        PrivateGetCodeStatus privateGetCodeStatus = this.a();
        String string5 = this.b.b.getCountryCode();
        String string6 = this.b.b.getName();
        y10.x(context, privateGetCodeStatus, string5, string6, string2, string3, string4);
    }

    private void o() {
        Object object = this.c;
        Object object2 = this.a();
        ((y)object).A((PrivateGetCodeStatus)((Object)object2));
        object = this.b;
        object2 = this.c;
        ((i0)object).B((y)object2);
    }

    private void p() {
        FrameLayout frameLayout = this.b.c;
        Object object = new j$a(this);
        frameLayout.setOnClickGetCodeListener((d$b)object);
        frameLayout = this.b.b;
        object = new h(this);
        frameLayout.setOnTextChangedListener((d.v.a.i.a.y0.e)object);
        frameLayout = this.b.c;
        object = new f(this);
        frameLayout.setOnTextChangedListener((d.v.a.i.a.y0.e)object);
    }

    private void q() {
        Observer observer;
        Object object = PrivateGetCodeStatus.BIND;
        Object object2 = this.a();
        if (object != object2 && (object = PrivateGetCodeStatus.CHANGE_BIND_SECOND) != (object2 = this.a())) {
            object = this.c.i;
            object2 = this.getViewLifecycleOwner();
            observer = new e(this);
            ((LiveData)object).observe((LifecycleOwner)object2, observer);
        } else {
            object = this.b.b;
            boolean bl2 = true;
            ((MeNameView)((Object)object)).setEditable(bl2);
        }
        object = this.c.h;
        object2 = this.getViewLifecycleOwner();
        observer = new d(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.c.o;
        object2 = this.getViewLifecycleOwner();
        observer = new c(this);
        ((d.v.e.i.j)object).observe((LifecycleOwner)object2, observer);
        object = this.c.r;
        object2 = this.getViewLifecycleOwner();
        observer = a.a;
        ((d.v.e.i.j)object).observe((LifecycleOwner)object2, observer);
        object = this.c.p;
        object2 = this.getViewLifecycleOwner();
        observer = new g(this);
        ((d.v.e.i.j)object).observe((LifecycleOwner)object2, observer);
        object = this.c.q;
        object2 = this.getViewLifecycleOwner();
        observer = new i(this);
        ((d.v.e.i.j)object).observe((LifecycleOwner)object2, observer);
        object = this.c.u;
        object2 = this.getViewLifecycleOwner();
        observer = new b(this);
        ((d.v.e.i.j)object).observe((LifecycleOwner)object2, observer);
    }

    private void r() {
        this.I(null, null);
        Object object = this.b;
        MeGetCodeView meGetCodeView = ((i0)object).c;
        boolean bl2 = TextUtils.isEmpty((CharSequence)((i0)object).b.getName()) ^ true;
        meGetCodeView.setGetCodeClickable(bl2);
        object = this.c.g.getValue();
        if (object != null) {
            object = (Boolean)this.c.g.getValue();
            bl2 = (Boolean)object;
            this.m(bl2);
        }
    }

    private /* synthetic */ void s(String string2) {
        Object object = this.b.c;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2) ^ true;
        object.setGetCodeClickable(bl2);
        string2 = this.b.b.getName();
        object = this.b.c.getCode();
        this.I(string2, (String)object);
    }

    private /* synthetic */ void u(String string2) {
        string2 = this.b.b.getName();
        String string3 = this.b.c.getCode();
        this.I(string2, string3);
    }

    private /* synthetic */ void w(String string2) {
        this.b.b.setName(string2);
        MeNameView meNameView = this.b.b;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        meNameView.setEditable(bl2);
    }

    private /* synthetic */ void y(String string2) {
        this.b.b.setCountryCode(string2);
    }

    public /* synthetic */ void B(Boolean bl2) {
        this.A(bl2);
    }

    public /* synthetic */ void D(Boolean bl2) {
        this.C(bl2);
    }

    public /* synthetic */ void F(String string2) {
        this.E(string2);
    }

    public /* synthetic */ void H(Boolean bl2) {
        this.G(bl2);
    }

    public int h() {
        return R$layout.set_private_get_code_frag;
    }

    public void i(ViewDataBinding viewDataBinding) {
        super.i(viewDataBinding);
        viewDataBinding = (i0)viewDataBinding;
        this.b = viewDataBinding;
        j$b j$b = new j$b(this);
        ((i0)viewDataBinding).A(j$b);
    }

    public void onAttach(Context object) {
        super.onAttach((Context)object);
        object = (y)d.v.i0.b.c(this.requireActivity()).get(y.class);
        this.c = object;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.o();
        this.r();
        this.p();
        this.q();
    }

    public /* synthetic */ void t(String string2) {
        this.s(string2);
    }

    public /* synthetic */ void v(String string2) {
        this.u(string2);
    }

    public /* synthetic */ void x(String string2) {
        this.w(string2);
    }

    public /* synthetic */ void z(String string2) {
        this.y(string2);
    }
}

