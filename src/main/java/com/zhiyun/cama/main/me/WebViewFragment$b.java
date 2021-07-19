/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 */
package com.zhiyun.cama.main.me;

import android.app.Activity;
import android.content.Context;
import androidx.activity.result.ActivityResultCaller;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.account.data.database.model.UserInfo;
import com.zhiyun.account.me.account.AccountActivity;
import com.zhiyun.account.me.account.visitor.VisitorBindActivity;
import com.zhiyun.cama.appeal.AppealActivity;
import com.zhiyun.cama.appeal.detail.AppealDetailActivity;
import com.zhiyun.cama.data.database.model.Approval;
import com.zhiyun.cama.main.me.WebViewFragment;
import com.zhiyun.cama.main.me.WebViewFragment$a;
import com.zhiyun.cama.main.me.WebViewFragment$b$a;
import com.zhiyun.cama.main.me.user.UserPageActivity;
import com.zhiyun.component.widget.JSWebView$a;
import d.v.a.f.c.b;
import d.v.c.i1.r2;
import d.v.c.i1.t2.f0;
import d.v.c.i1.t2.y;
import d.v.c.i1.t2.z;
import d.v.c.v0.f;
import d.v.c.v0.u.b0.c;
import d.v.c.v0.u.v;
import d.v.e.l.b2;
import d.v.f.i.g;
import m.a.a;

public class WebViewFragment$b
implements JSWebView$a {
    public final /* synthetic */ WebViewFragment a;

    private WebViewFragment$b(WebViewFragment webViewFragment) {
        this.a = webViewFragment;
    }

    public /* synthetic */ WebViewFragment$b(WebViewFragment webViewFragment, WebViewFragment$a webViewFragment$a) {
        this(webViewFragment);
    }

    private /* synthetic */ void b() {
        this.a.requireActivity().onBackPressed();
    }

    private /* synthetic */ void d() {
        this.a.requireActivity().onBackPressed();
    }

    private void f(String object, boolean bl2) {
        boolean bl3 = "index".equals(object);
        WebViewFragment webViewFragment = this.a;
        if (bl2 && bl3) {
            bl3 = true;
        } else {
            bl3 = false;
            object = null;
        }
        WebViewFragment.Q(webViewFragment, bl3);
        object = this.a;
        bl2 = WebViewFragment.P((WebViewFragment)object);
        ((f0)object).D(bl2);
        object = WebViewFragment.R((WebViewFragment)this.a).c;
        Boolean bl4 = WebViewFragment.P(this.a);
        ((MutableLiveData)object).postValue(bl4);
        object = WebViewFragment.J((WebViewFragment)this.a).g;
        bl4 = WebViewFragment.P(this.a);
        ((MutableLiveData)object).postValue(bl4);
    }

    public String a() {
        return "appAndroid";
    }

    public /* synthetic */ void c() {
        this.b();
    }

    public /* synthetic */ void e() {
        this.d();
    }

    public void nativaUserPunish() {
        Object object;
        int n10;
        UserInfo userInfo = b.N().i();
        int n11 = userInfo.getId();
        if (n11 != (n10 = -1) && (object = userInfo.getToken()) != null) {
            object = WebViewFragment.J(this.a);
            n10 = userInfo.getId();
            WebViewFragment$b$a webViewFragment$b$a = new WebViewFragment$b$a(this, userInfo);
            ((r2)object).i(n10, webViewFragment$b$a);
            return;
        }
        WebViewFragment.M(this.a);
    }

    public void nativeAlert(String string2, String string3) {
        WebViewFragment.O(this.a, string2, string3);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void nativeComplaint(String object, String string2, String string3) {
        int n10;
        try {
            n10 = Integer.parseInt((String)object);
        }
        catch (NumberFormatException numberFormatException) {
            return;
        }
        object = this.a.requireActivity();
        Approval approval = new Approval(n10, null, string2, string3, null, null, null, null);
        string2 = "person_production_approval_notice";
        AppealActivity.E((Activity)object, string2, approval);
    }

    public void nativeComplaintDetail(String string2, String string3, String string4) {
        AppealDetailActivity.v(this.a.requireActivity(), "person_production_approval_notice", string2);
    }

    public void nativeGetPrime() {
        Object object = new Object[]{};
        m.a.a.b("-----nativeGetPrime-----", (Object[])object);
        object = WebViewFragment.L(this.a);
        int n10 = 1;
        ((d.v.c.m1.c)object).x(n10 != 0);
        VisitorBindActivity.h(this.a, n10);
    }

    public void nativeGoPage(String string2) {
        this.f(string2, true);
    }

    public void nativeLeavePage(String object) {
        boolean bl2;
        this.f((String)object, false);
        Object object2 = this.a;
        boolean bl3 = ((Fragment)object2).isAdded();
        if (bl3 && object != null && ((bl3 = ((String)object).equals(object2 = "detail")) || (bl2 = ((String)object).equals(object2 = "worksVideoDetail")))) {
            object = this.a.requireActivity();
            object2 = new z(this);
            object.runOnUiThread((Runnable)object2);
        }
    }

    public void nativeLike(boolean bl2, String string2) {
        Object[] objectArray = new Object[2];
        Boolean bl3 = bl2;
        objectArray[0] = bl3;
        objectArray[1] = string2;
        m.a.a.b("nativeLike status = %1$s, worksId = %2$s", objectArray);
        WebViewFragment.J(this.a).g(bl2, string2);
    }

    public void nativeLogin() {
        ActivityResultCaller activityResultCaller = this.a;
        boolean bl2 = WebViewFragment.K(activityResultCaller);
        if (bl2 && (activityResultCaller = this.a.getActivity()) != null) {
            activityResultCaller = this.a.getActivity();
            AccountActivity.h((Activity)activityResultCaller);
        }
    }

    public void nativeNetwork(boolean bl2) {
        Object object = this.a.requireContext();
        bl2 = b2.l((Context)object);
        if (bl2 && !(bl2 = c.V())) {
            object = this.a;
            Object object2 = ((Fragment)object).requireContext();
            int n10 = 2131952647;
            object2 = g.m(object2, n10);
            WebViewFragment.H((WebViewFragment)object, (String)object2);
            bl2 = true;
            c.w0(bl2);
        }
    }

    public void nativeRemoveWorks(String object) {
        int n10 = 1;
        Object object2 = new Object[n10];
        object2[0] = object;
        String string2 = "nativeRemoveWorks worksId = %s";
        m.a.a.b(string2, (Object[])object2);
        object2 = f.a();
        int n11 = Integer.parseInt((String)object);
        ((v)object2).H(n11);
        object = this.a;
        n11 = (int)(((Fragment)object).isAdded() ? 1 : 0);
        if (n11 != 0) {
            object = this.a.requireActivity();
            object2 = new y(this);
            object.runOnUiThread((Runnable)object2);
        }
    }

    public void nativeSetAuthority(String string2) {
        Object[] objectArray = new Object[]{string2};
        m.a.a.b("nativeSetAuthority,range = %s", objectArray);
    }

    public void nativeShare(String string2, String string3, String string4, String string5, String string6, String string7) {
        WebViewFragment.I(this.a, string2, string3, string4, string5, string6, string7);
    }

    public void nativeUserCenter(String string2) {
        ActivityResultCaller activityResultCaller = this.a;
        boolean bl2 = WebViewFragment.K(activityResultCaller);
        if (bl2) {
            activityResultCaller = this.a.requireActivity();
            int n10 = Integer.parseInt(string2);
            UserPageActivity.d((Activity)activityResultCaller, n10);
        }
    }

    public void nativetoPrimeStatus() {
        Object[] objectArray = new Object[]{};
        m.a.a.b("-----nativetoPrimeStatus-----", objectArray);
        c.x0(false);
    }
}

