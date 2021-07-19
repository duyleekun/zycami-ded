/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.os.Bundle
 *  android.view.View
 *  android.webkit.WebResourceError
 *  android.webkit.WebResourceRequest
 *  android.webkit.WebView
 *  android.widget.ImageView
 */
package d.v.c.i1.t2;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.widget.ImageView;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.account.data.database.model.UserInfo;
import com.zhiyun.account.widget.StatusView$Status;
import com.zhiyun.component.widget.JSWebView;
import com.zhiyun.component.widget.JSWebView$a;
import d.v.c.i1.t2.a;
import d.v.c.i1.t2.b;
import d.v.c.i1.t2.f0$a;
import d.v.c.i1.t2.f0$b;
import d.v.c.i1.t2.f0$c;
import d.v.c.i1.t2.o0;
import d.v.c.l0$a;
import d.v.c.l0$b;
import d.v.c.w0.z;
import d.v.e.l.b2;
import d.v.e.l.w1;

public abstract class f0
extends d.v.f.h.a {
    private z b;
    public JSWebView c;
    public ImageView d;
    private o0 e;
    private boolean f;
    private boolean g;
    private OnBackPressedCallback h;

    public f0() {
        f0$a f0$a = new f0$a(this, true);
        this.h = f0$a;
    }

    /*
     * WARNING - void declaration
     */
    private void E() {
        void var4_8;
        String string2;
        boolean bl2;
        Object object = this.e;
        StatusView$Status statusView$Status = StatusView$Status.STATUS_LOADING;
        object.k(statusView$Status);
        boolean bl3 = this.t();
        statusView$Status = null;
        if (!bl3) {
            object = this.b.d;
            object.setBackgroundColor(0);
        } else {
            object = this.b.d;
            int bl22 = -1;
            object.setBackgroundColor(bl22);
        }
        object = this.b.d;
        Object object2 = this.n();
        ((JSWebView)((Object)object)).a((JSWebView$a)object2);
        object = this.e;
        object2 = this.m();
        if (object2 != null && (bl2 = ((String)(object2 = this.m())).equals(string2 = l0$b.a))) {
            boolean bl4 = true;
        } else {
            boolean bl5 = false;
            object2 = null;
        }
        object.j((boolean)var4_8);
        object = this.b.d;
        object2 = this.m();
        object.loadUrl((String)object2);
        this.g = false;
    }

    private void F() {
        String string2 = w1.a();
        JSWebView jSWebView = this.b.d;
        b b10 = new b(this, string2);
        jSWebView.evaluateJavascript("window.localStorage.getItem('lang');", b10);
    }

    private void G(String string2) {
        Object object = new Object[]{string2};
        m.a.a.b("---set language %s", object);
        object = this.b.d;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("window.localStorage.setItem('");
        stringBuilder.append("lang");
        stringBuilder.append("','");
        stringBuilder.append(string2);
        stringBuilder.append("');");
        string2 = stringBuilder.toString();
        object.evaluateJavascript(string2, null);
    }

    public static /* synthetic */ void j(f0 f02) {
        f02.k();
    }

    private void k() {
        Object object = this.b;
        if (object != null) {
            JSWebView jSWebView = object.d;
            String string2 = "";
            String string3 = "text/html";
            String string4 = "utf-8";
            jSWebView.loadDataWithBaseURL(null, string2, string3, string4, null);
            this.b.d.clearHistory();
            object = this.b.d;
            object.destroy();
        }
    }

    private void p() {
        o0 o02 = this.e;
        boolean bl2 = this.s();
        o02.i(bl2);
        o02 = this.e;
        bl2 = this.r();
        o02.g(bl2);
        this.E();
    }

    private void q() {
        JSWebView jSWebView = this.b.d;
        f0$b f0$b = new f0$b(this);
        jSWebView.setWebViewClient(f0$b);
    }

    private /* synthetic */ void u(UserInfo object, String object2) {
        String string2;
        boolean bl2;
        boolean bl3;
        Object object3;
        if (object2 != null) {
            object3 = "null";
            bl3 = ((String)object2).equals(object3);
            if (bl3) {
                bl2 = false;
                object2 = null;
            } else {
                object3 = "\"";
                string2 = "";
                object2 = ((String)object2).replace((CharSequence)object3, string2);
            }
        }
        object3 = d.v.a.f.c.b.N();
        bl3 = object3.s();
        int n10 = 0;
        string2 = null;
        if (!bl3 && object2 != null) {
            object = this.b.d;
            object2 = l0$a.a;
            object3 = new Object[]{};
            ((JSWebView)((Object)object)).c((String)object2, object3);
        } else if (object2 == null && bl3 && object != null || object2 != null && bl3 && object != null && !(bl2 = ((String)object2).equals(object3 = ((UserInfo)object).getToken()))) {
            object2 = this.b.d;
            object3 = l0$a.b;
            int n11 = 3;
            Object[] objectArray = new Object[n11];
            String string3 = ((UserInfo)object).getToken();
            objectArray[0] = string3;
            string3 = w1.a();
            objectArray[1] = string3;
            n10 = 2;
            int n12 = ((UserInfo)object).getId();
            objectArray[n10] = object = Integer.valueOf(n12);
            ((JSWebView)((Object)object2)).c((String)object3, objectArray);
        }
    }

    private /* synthetic */ void w(String object, String object2) {
        boolean bl2;
        int n10 = 1;
        Object object3 = new Object[n10];
        object3[0] = object2;
        String string2 = "---value = %s";
        m.a.a.b(string2, object3);
        if (object2 != null) {
            object3 = "null";
            n10 = (int)(((String)object2).equals(object3) ? 1 : 0);
            if (n10 != 0) {
                bl2 = false;
                object2 = null;
            } else {
                object3 = "\"";
                string2 = "";
                object2 = ((String)object2).replace((CharSequence)object3, string2);
            }
        }
        if (!(bl2 = ((String)object).equals(object2))) {
            this.G((String)object);
            this.B();
        } else {
            object = this.e;
            object2 = StatusView$Status.STATUS_NONE;
            ((o0)object).k((StatusView$Status)((Object)object2));
        }
    }

    public void A(WebView object, WebResourceRequest object2, WebResourceError webResourceError) {
        int n10;
        int n11 = webResourceError.getErrorCode();
        if (n11 == (n10 = -2) || (n11 = webResourceError.getErrorCode()) == (n10 = -6) || (n11 = webResourceError.getErrorCode()) == (n10 = -8)) {
            n11 = 1;
            this.f = n11;
            this.b.d.onPause();
            object = this.e;
            object2 = StatusView$Status.STATUS_ERROR;
            ((o0)object).k((StatusView$Status)((Object)object2));
        }
    }

    public void B() {
        Object object;
        boolean bl2 = this.isAdded();
        if (bl2 && (bl2 = b2.m((Context)(object = this.requireContext()))) && (bl2 = this.g)) {
            this.b.d.reload();
            object = this.e;
            StatusView$Status statusView$Status = StatusView$Status.STATUS_LOADING;
            ((o0)object).k(statusView$Status);
        }
    }

    public void C(UserInfo userInfo) {
        boolean bl2 = this.g;
        if (!bl2) {
            return;
        }
        JSWebView jSWebView = this.b.d;
        a a10 = new a(this, userInfo);
        jSWebView.evaluateJavascript("window.localStorage.getItem('token');", a10);
    }

    public void D(boolean bl2) {
        this.e.j(bl2);
    }

    public int h() {
        return 2131558450;
    }

    public void i(ViewDataBinding viewDataBinding) {
        super.i(viewDataBinding);
        viewDataBinding = (z)viewDataBinding;
        this.b = viewDataBinding;
        Object object = new f0$c(this);
        ((z)viewDataBinding).A((f0$c)object);
        viewDataBinding = this.b;
        object = this.e;
        ((z)viewDataBinding).B((o0)object);
        viewDataBinding = this.b;
        object = ((z)viewDataBinding).d;
        this.c = object;
        viewDataBinding = ((z)viewDataBinding).a;
        this.d = viewDataBinding;
    }

    public void l() {
        Object object = this.b.d;
        int n10 = -1;
        boolean bl2 = object.canGoBackOrForward(n10);
        if (bl2) {
            object = this.b.d;
            object.goBackOrForward(n10);
        } else {
            object = this.h;
            n10 = 0;
            ((OnBackPressedCallback)object).setEnabled(false);
            object = this.requireActivity();
            ((ComponentActivity)object).onBackPressed();
        }
    }

    public abstract String m();

    public abstract JSWebView$a n();

    public abstract UserInfo o();

    public void onAttach(Context object) {
        super.onAttach((Context)object);
        object = (o0)d.v.i0.b.a(this).get(o0.class);
        this.e = object;
    }

    public void onCreate(Bundle object) {
        super.onCreate((Bundle)object);
        object = this.requireActivity().getOnBackPressedDispatcher();
        OnBackPressedCallback onBackPressedCallback = this.h;
        ((OnBackPressedDispatcher)object).addCallback(this, onBackPressedCallback);
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.k();
    }

    public void onPause() {
        super.onPause();
        this.b.d.onPause();
    }

    public void onResume() {
        super.onResume();
        this.b.d.onResume();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.p();
        this.q();
    }

    public abstract boolean r();

    public abstract boolean s();

    public abstract boolean t();

    public /* synthetic */ void v(UserInfo userInfo, String string2) {
        this.u(userInfo, string2);
    }

    public /* synthetic */ void x(String string2, String string3) {
        this.w(string2, string3);
    }

    public void y(WebView object, String object2) {
        this.g = true;
        boolean bl2 = this.f;
        if (!bl2) {
            this.b.d.onResume();
            object = "http";
            bl2 = object2.startsWith((String)object);
            if (bl2) {
                this.F();
                object = this.o();
                this.C((UserInfo)object);
            } else {
                object = this.e;
                object2 = StatusView$Status.STATUS_NONE;
                ((o0)object).k((StatusView$Status)((Object)object2));
            }
        }
    }

    public void z(WebView webView, String string2, Bitmap bitmap) {
        this.g = false;
        this.f = false;
    }
}

