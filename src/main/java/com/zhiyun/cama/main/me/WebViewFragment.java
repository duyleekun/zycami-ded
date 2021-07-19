/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.view.View
 *  android.webkit.WebView
 */
package com.zhiyun.cama.main.me;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle$State;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.zhiyun.account.data.database.model.UserInfo;
import com.zhiyun.cama.main.me.WebViewFragment$a;
import com.zhiyun.cama.main.me.WebViewFragment$b;
import com.zhiyun.component.widget.JSWebView;
import com.zhiyun.component.widget.JSWebView$a;
import com.zhiyun.net.Punish;
import d.v.c.i1.r2;
import d.v.c.i1.s2.s;
import d.v.c.i1.t2.a0;
import d.v.c.i1.t2.b0;
import d.v.c.i1.t2.c0;
import d.v.c.i1.t2.d0;
import d.v.c.i1.t2.e0;
import d.v.c.i1.t2.f0;
import d.v.c.i1.t2.n0;
import d.v.c.l0$a;
import d.v.c.m1.d.p;
import d.v.c.v0.u.b0.c;
import d.v.f.f.a;
import d.v.f.i.g;
import d.v.g0.k$a;
import d.v.g0.k$b;
import d.v.i0.b;

public class WebViewFragment
extends f0 {
    private r2 i;
    private s j;
    private d.v.c.m1.c k;
    private boolean l;

    public static /* synthetic */ void H(WebViewFragment webViewFragment, String string2) {
        webViewFragment.g0(string2);
    }

    public static /* synthetic */ void I(WebViewFragment webViewFragment, String string2, String string3, String string4, String string5, String string6, String string7) {
        webViewFragment.U(string2, string3, string4, string5, string6, string7);
    }

    public static /* synthetic */ r2 J(WebViewFragment webViewFragment) {
        return webViewFragment.i;
    }

    public static /* synthetic */ boolean K(WebViewFragment webViewFragment) {
        return webViewFragment.W();
    }

    public static /* synthetic */ d.v.c.m1.c L(WebViewFragment webViewFragment) {
        return webViewFragment.k;
    }

    public static /* synthetic */ void M(WebViewFragment webViewFragment) {
        webViewFragment.d0();
    }

    public static /* synthetic */ void N(WebViewFragment webViewFragment, Punish punish) {
        webViewFragment.V(punish);
    }

    public static /* synthetic */ void O(WebViewFragment webViewFragment, String string2, String string3) {
        webViewFragment.f0(string2, string3);
    }

    public static /* synthetic */ boolean P(WebViewFragment webViewFragment) {
        return webViewFragment.l;
    }

    public static /* synthetic */ boolean Q(WebViewFragment webViewFragment, boolean bl2) {
        webViewFragment.l = bl2;
        return bl2;
    }

    public static /* synthetic */ s R(WebViewFragment webViewFragment) {
        return webViewFragment.j;
    }

    public static WebViewFragment S(String string2, boolean bl2, boolean bl3, boolean bl4) {
        WebViewFragment webViewFragment = new WebViewFragment();
        Bundle bundle = new Bundle();
        bundle.putString("url", string2);
        bundle.putBoolean("useBgColor", bl2);
        bundle.putBoolean("hideBack", bl3);
        bundle.putBoolean("darkMode", bl4);
        webViewFragment.setArguments(bundle);
        return webViewFragment;
    }

    private void U(String string2, String string3, String string4, String string5, String string6, String string7) {
        r2 r22 = this.i;
        WebViewFragment$a webViewFragment$a = new WebViewFragment$a(this);
        r22.d(string2, string3, string4, string5, string6, string7, webViewFragment$a);
    }

    private void V(Punish object) {
        int n10;
        if (object == null) {
            n10 = 0;
            object = null;
        } else {
            object = ((Punish)object).getPunish();
        }
        String string2 = "1";
        n10 = TextUtils.equals((CharSequence)string2, (CharSequence)object);
        if (n10 != 0) {
            n10 = 2131951675;
            object = g.s(this, n10);
            int n11 = 2131951676;
            string2 = g.s(this, n11);
            this.f0((String)object, string2);
        } else {
            this.d0();
        }
    }

    private boolean W() {
        Lifecycle$State lifecycle$State = this.getLifecycle().getCurrentState();
        Lifecycle$State lifecycle$State2 = Lifecycle$State.RESUMED;
        return lifecycle$State.isAtLeast(lifecycle$State2);
    }

    private /* synthetic */ void X(Boolean object) {
        boolean bl2 = (Boolean)object;
        if (bl2 && (bl2 = ((d.v.a.f.c.b)(object = d.v.a.f.c.b.N())).j())) {
            bl2 = true;
            this.e0(bl2);
        }
    }

    private /* synthetic */ void Z() {
        JSWebView jSWebView = this.c;
        String string2 = l0$a.f;
        Object[] objectArray = new Object[]{};
        jSWebView.c(string2, objectArray);
    }

    private /* synthetic */ void b0(String string2) {
        boolean bl2 = this.isVisible();
        if (bl2) {
            JSWebView jSWebView = this.c;
            String string3 = l0$a.c;
            int n10 = 1;
            Object[] objectArray = new Object[n10];
            objectArray[0] = string2;
            jSWebView.c(string3, objectArray);
        }
    }

    private void d0() {
        FragmentActivity fragmentActivity = this.requireActivity();
        b0 b02 = new b0(this);
        fragmentActivity.runOnUiThread(b02);
    }

    private void f0(String object, String object2) {
        Context context = this.requireContext();
        Object object3 = new k$b(context);
        object = (k$b)((k$b)((k$a)object3).B((String)object)).n((String)object2);
        object2 = g.s(this, 2131952621);
        object3 = d0.a;
        object = (k$b)((k$a)object).x((String)object2, (a)object3);
        object2 = this.getChildFragmentManager();
        ((k$a)object).D((FragmentManager)object2);
    }

    private void g0(String string2) {
        FragmentActivity fragmentActivity = this.requireActivity();
        c0 c02 = new c0(this, string2);
        fragmentActivity.runOnUiThread(c02);
    }

    private void q() {
        LiveData liveData = this.i.e;
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        Observer observer = new e0(this);
        liveData.observe(lifecycleOwner, observer);
        liveData = this.k.i();
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new a0(this);
        liveData.observe(lifecycleOwner, observer);
    }

    public void T() {
        JSWebView jSWebView = this.c;
        String string2 = l0$a.d;
        Object[] objectArray = new Object[]{};
        jSWebView.c(string2, objectArray);
    }

    public /* synthetic */ void Y(Boolean bl2) {
        this.X(bl2);
    }

    public /* synthetic */ void a0() {
        this.Z();
    }

    public /* synthetic */ void c0(String string2) {
        this.b0(string2);
    }

    public void e0(boolean bl2) {
        boolean bl3 = d.v.c.v0.u.b0.c.W();
        if (bl3) {
            JSWebView jSWebView = this.c;
            String string2 = l0$a.e;
            int n10 = 1;
            Object[] objectArray = new Object[n10];
            Boolean bl4 = bl2;
            objectArray[0] = bl4;
            jSWebView.c(string2, objectArray);
        }
    }

    public void h0() {
        String string2 = "1.2.6".split("-")[0];
        JSWebView jSWebView = this.c;
        String string3 = l0$a.g;
        Object[] objectArray = new Object[]{string2};
        jSWebView.c(string3, objectArray);
    }

    public void l() {
        boolean bl2 = this.l;
        if (bl2) {
            this.requireActivity().finish();
            return;
        }
        super.l();
    }

    public String m() {
        return n0.b(this.getArguments()).e();
    }

    public JSWebView$a n() {
        WebViewFragment$b webViewFragment$b = new WebViewFragment$b(this, null);
        return webViewFragment$b;
    }

    public UserInfo o() {
        return (UserInfo)this.i.e.getValue();
    }

    public void onActivityResult(int n10, int n11, Intent intent) {
        Object object;
        super.onActivityResult(n10, n11, intent);
        int n12 = 1;
        if (n10 == n12 && n11 == (n10 = 2) && (n10 = (int)(((d.v.a.f.c.b)(object = d.v.a.f.c.b.N())).s() ? 1 : 0)) != 0) {
            n10 = p.p;
            object = p.L(n10, n12 != 0);
            FragmentManager fragmentManager = this.getChildFragmentManager();
            ((d.v.f.g.b)object).q(fragmentManager);
            object = this.k;
            ((d.v.c.m1.c)object).y();
        }
        this.k.x(false);
    }

    public void onAttach(Context object) {
        Class<s> clazz = s.class;
        super.onAttach((Context)object);
        object = b.c(this.requireActivity());
        Class<r2> clazz2 = r2.class;
        this.i = object = (r2)((ViewModelProvider)object).get(clazz2);
        object = this.getParentFragment();
        this.j = object != null ? (object = (s)b.a(this.getParentFragment()).get(clazz)) : (object = (s)b.a(this).get(clazz));
        this.k = object = (d.v.c.m1.c)b.c(this.requireActivity()).get(d.v.c.m1.c.class);
    }

    public void onViewCreated(View object, Bundle bundle) {
        Bundle bundle2 = this.getArguments();
        if (bundle2 != null) {
            super.onViewCreated((View)object, bundle);
            this.q();
            return;
        }
        object = new IllegalArgumentException("getArguments can not be null");
        throw object;
    }

    public boolean r() {
        return n0.b(this.getArguments()).c();
    }

    public boolean s() {
        return n0.b(this.getArguments()).d();
    }

    public boolean t() {
        return n0.b(this.getArguments()).f();
    }

    public void y(WebView object, String string2) {
        super.y((WebView)object, string2);
        this.h0();
        object = this.k;
        boolean bl2 = ((d.v.c.m1.c)object).p();
        if (bl2 && (bl2 = ((d.v.a.f.c.b)(object = d.v.a.f.c.b.N())).j())) {
            bl2 = true;
            this.e0(bl2);
        }
    }
}

