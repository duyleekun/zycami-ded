/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.text.method.LinkMovementMethod
 *  android.text.method.MovementMethod
 *  android.view.View
 *  android.widget.CompoundButton
 *  android.widget.CompoundButton$OnCheckedChangeListener
 *  android.widget.FrameLayout
 */
package d.v.a.i.a.v0;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.zhiyun.account.R$layout;
import com.zhiyun.account.R$string;
import com.zhiyun.account.me.account.getcode.GetCodeStatus;
import com.zhiyun.account.me.account.widget.MeGetCodeView;
import com.zhiyun.account.me.account.widget.MeNameView;
import d.v.a.i.a.m0;
import d.v.a.i.a.v0.a;
import d.v.a.i.a.v0.b;
import d.v.a.i.a.v0.c;
import d.v.a.i.a.v0.d;
import d.v.a.i.a.v0.e;
import d.v.a.i.a.v0.f;
import d.v.a.i.a.v0.g;
import d.v.a.i.a.v0.h;
import d.v.a.i.a.v0.i;
import d.v.a.i.a.v0.j;
import d.v.a.i.a.v0.k;
import d.v.a.i.a.v0.l;
import d.v.a.i.a.v0.m$a;
import d.v.a.i.a.v0.m$b;
import d.v.a.i.a.v0.n;
import d.v.a.i.a.y0.d$b;
import d.v.e.l.w1;
import d.v.g0.k$a;
import d.v.g0.k$b;
import d.v.g0.s;

public abstract class m
extends d.v.f.h.a
implements n {
    private d.v.a.g.c b;
    private m0 c;

    private /* synthetic */ void B(String string2) {
        this.b.f.setCountryCode(string2);
    }

    private /* synthetic */ void D(Boolean object) {
        boolean bl2 = (Boolean)object;
        if (bl2) {
            object = this.getActivity();
            s.t((FragmentActivity)object);
        } else {
            s.j();
        }
    }

    private /* synthetic */ void F(Boolean bl2) {
        bl2 = this.b.j;
        this.b((View)bl2);
    }

    private /* synthetic */ void H(String object) {
        Object object2 = this.getContext();
        Object object3 = new k$b((Context)object2);
        object = (k$b)((k$a)object3).B((String)object);
        object3 = h.a;
        object = (k$b)((k$a)object).p((d.v.f.f.a)object3);
        int n10 = R$string.me_login_now;
        object2 = new k(this);
        object = (k$b)((k$a)object).v(n10, (d.v.f.f.a)object2);
        object3 = this.getChildFragmentManager();
        ((k$a)object).D((FragmentManager)object3);
    }

    private /* synthetic */ void J(String object) {
        Context context = this.getContext();
        Object object2 = new k$b(context);
        object = (k$b)((k$a)object2).B((String)object);
        object2 = this.getChildFragmentManager();
        ((k$a)object).D((FragmentManager)object2);
    }

    public static /* synthetic */ void L(DialogFragment dialogFragment) {
    }

    private /* synthetic */ void M(DialogFragment dialogFragment) {
        dialogFragment = this.b.j;
        this.o((View)dialogFragment);
    }

    private void O(String object, String string2) {
        MutableLiveData mutableLiveData = this.c.i;
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

    public static /* synthetic */ void j(m m10, String string2, String string3, String string4) {
        m10.n(string2, string3, string4);
    }

    public static /* synthetic */ m0 k(m m10) {
        return m10.c;
    }

    public static /* synthetic */ d.v.a.g.c l(m m10) {
        return m10.b;
    }

    private void m(boolean bl2) {
        this.b.b.setChecked(bl2);
        this.b.f.setShowCode(bl2);
        this.c.j();
    }

    private void n(String string2, String string3, String string4) {
        String string5 = this.b.f.getCountryCode();
        m0 m02 = this.c;
        Context context = this.getContext();
        GetCodeStatus getCodeStatus = this.a();
        String string6 = this.b.f.getName();
        m02.u(context, getCodeStatus, string5, string6, string2, string3, string4);
    }

    private void p() {
        Object object = this.c;
        Object object2 = "zh_CN".toLowerCase();
        String string2 = w1.a();
        boolean bl2 = object2.equals(string2);
        ((m0)object).x(bl2);
        object = this.c;
        object2 = this.a();
        ((m0)object).y((GetCodeStatus)((Object)object2));
        object = this.b;
        object2 = this.c;
        ((d.v.a.g.c)object).B((m0)object2);
    }

    private void q() {
        FrameLayout frameLayout = this.b.g;
        Object object = new m$a(this);
        frameLayout.setOnClickGetCodeListener((d$b)object);
        frameLayout = this.b.b;
        object = new e(this);
        frameLayout.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)object);
        frameLayout = this.b.f;
        object = new g(this);
        frameLayout.setOnTextChangedListener((d.v.a.i.a.y0.e)object);
        frameLayout = this.b.g;
        object = new j(this);
        frameLayout.setOnTextChangedListener((d.v.a.i.a.y0.e)object);
    }

    private void r() {
        MutableLiveData mutableLiveData = this.c.k;
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        Observer observer = new c(this);
        mutableLiveData.observe(lifecycleOwner, observer);
        mutableLiveData = this.c.v;
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new i(this);
        ((d.v.e.i.j)mutableLiveData).observe(lifecycleOwner, observer);
        mutableLiveData = this.c.A;
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = l.a;
        ((d.v.e.i.j)mutableLiveData).observe(lifecycleOwner, observer);
        mutableLiveData = this.c.w;
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new d(this);
        ((d.v.e.i.j)mutableLiveData).observe(lifecycleOwner, observer);
        mutableLiveData = this.c.y;
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new a(this);
        ((d.v.e.i.j)mutableLiveData).observe(lifecycleOwner, observer);
        mutableLiveData = this.c.x;
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new b(this);
        ((d.v.e.i.j)mutableLiveData).observe(lifecycleOwner, observer);
        mutableLiveData = this.c.D;
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new f(this);
        ((d.v.e.i.j)mutableLiveData).observe(lifecycleOwner, observer);
    }

    private void s() {
        Object object = this.b.a;
        Object object2 = LinkMovementMethod.getInstance();
        object.setMovementMethod((MovementMethod)object2);
        this.O(null, null);
        object = this.b;
        object2 = ((d.v.a.g.c)object).g;
        boolean bl2 = TextUtils.isEmpty((CharSequence)((d.v.a.g.c)object).f.getName()) ^ true;
        ((MeGetCodeView)((Object)object2)).setGetCodeClickable(bl2);
        object = this.c.m.getValue();
        if (object != null) {
            object = (Boolean)this.c.m.getValue();
            bl2 = (Boolean)object;
            this.m(bl2);
        }
    }

    private /* synthetic */ void t(CompoundButton object, boolean bl2) {
        this.c.x(bl2);
        this.b.f.setShowCode(bl2);
        object = this.b.f;
        String string2 = "";
        ((MeNameView)((Object)object)).setName(string2);
        this.b.g.setCode(string2);
    }

    private /* synthetic */ void v(String string2) {
        Object object = this.b.g;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2) ^ true;
        object.setGetCodeClickable(bl2);
        string2 = this.b.f.getName();
        object = this.b.g.getCode();
        this.O(string2, (String)object);
    }

    private /* synthetic */ void x(String string2) {
        string2 = this.b.f.getName();
        String string3 = this.b.g.getCode();
        this.O(string2, string3);
    }

    private /* synthetic */ void z(Boolean object) {
        boolean bl2 = (Boolean)object;
        if (bl2) {
            object = this.b.g;
            ((MeGetCodeView)((Object)object)).e();
        } else {
            object = this.b.g;
            ((MeGetCodeView)((Object)object)).f();
        }
    }

    public /* synthetic */ void A(Boolean bl2) {
        this.z(bl2);
    }

    public /* synthetic */ void C(String string2) {
        this.B(string2);
    }

    public /* synthetic */ void E(Boolean bl2) {
        this.D(bl2);
    }

    public /* synthetic */ void G(Boolean bl2) {
        this.F(bl2);
    }

    public /* synthetic */ void I(String string2) {
        this.H(string2);
    }

    public /* synthetic */ void K(String string2) {
        this.J(string2);
    }

    public /* synthetic */ void N(DialogFragment dialogFragment) {
        this.M(dialogFragment);
    }

    public int h() {
        return R$layout.me_account_get_code_frag;
    }

    public void i(ViewDataBinding viewDataBinding) {
        super.i(viewDataBinding);
        viewDataBinding = (d.v.a.g.c)viewDataBinding;
        this.b = viewDataBinding;
        m$b m$b = new m$b(this);
        ((d.v.a.g.c)viewDataBinding).A(m$b);
    }

    public void o(View view) {
    }

    public void onAttach(Context object) {
        super.onAttach((Context)object);
        object = (m0)d.v.i0.b.c(this.requireActivity()).get(m0.class);
        this.c = object;
    }

    public void onDestroy() {
        this.b.g.f();
        super.onDestroy();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.p();
        this.s();
        this.q();
        this.r();
    }

    public /* synthetic */ void u(CompoundButton compoundButton, boolean bl2) {
        this.t(compoundButton, bl2);
    }

    public /* synthetic */ void w(String string2) {
        this.v(string2);
    }

    public /* synthetic */ void y(String string2) {
        this.x(string2);
    }
}

