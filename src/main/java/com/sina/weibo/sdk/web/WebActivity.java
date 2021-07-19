/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.view.KeyEvent
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup$LayoutParams
 *  android.webkit.WebChromeClient
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  android.widget.Button
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.ProgressBar
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  android.widget.TextView
 */
package com.sina.weibo.sdk.web;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sina.weibo.sdk.c.e;
import com.sina.weibo.sdk.web.WebActivity$1;
import com.sina.weibo.sdk.web.WebActivity$2;
import com.sina.weibo.sdk.web.WebActivity$3;
import com.sina.weibo.sdk.web.WebActivity$4;
import com.sina.weibo.sdk.web.a.b;
import com.sina.weibo.sdk.web.a.d;
import com.sina.weibo.sdk.web.b.a;
import com.sina.weibo.sdk.web.b.b$a;
import com.sina.weibo.sdk.web.b.c;
import java.lang.reflect.Method;

public class WebActivity
extends Activity
implements com.sina.weibo.sdk.web.a {
    private LinearLayout ar;
    private TextView as;
    private TextView at;
    private WebView au;
    private ProgressBar av;
    private com.sina.weibo.sdk.web.b.b aw;
    private b ax;
    private String ay;

    public static /* synthetic */ com.sina.weibo.sdk.web.b.b a(WebActivity webActivity) {
        return webActivity.aw;
    }

    private static void a(WebView webView, String string2) {
        Class<String> clazz;
        Class[] classArray;
        Object object = WebView.class;
        Object[] objectArray = "removeJavascriptInterface";
        int n10 = 1;
        try {
            classArray = new Class[n10];
            clazz = String.class;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
        classArray[0] = clazz;
        object = ((Class)object).getDeclaredMethod((String)objectArray, classArray);
        objectArray = new Object[n10];
        objectArray[0] = string2;
        ((Method)object).invoke(webView, objectArray);
    }

    public static /* synthetic */ WebView b(WebActivity webActivity) {
        return webActivity.au;
    }

    public static /* synthetic */ b c(WebActivity webActivity) {
        return webActivity.ax;
    }

    public static /* synthetic */ void d(WebActivity webActivity) {
        webActivity.ar.setVisibility(8);
        webActivity.au.setVisibility(0);
    }

    public static /* synthetic */ ProgressBar e(WebActivity webActivity) {
        return webActivity.av;
    }

    private static boolean j(String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2) {
            boolean bl3;
            String string3 = "https://service.weibo.com/share/mobilesdk.php";
            bl2 = string2.startsWith(string3);
            return bl2 || (bl3 = string2.startsWith(string3 = "https://open.weibo.cn/oauth2/authorize?"));
            {
            }
        }
        return false;
    }

    public static /* synthetic */ boolean k(String string2) {
        return WebActivity.j(string2);
    }

    public void onCreate(Bundle object) {
        int n10;
        Object object2;
        int n11;
        Object object3;
        super.onCreate((Bundle)object);
        int n12 = Build.VERSION.SDK_INT;
        int n13 = 23;
        if (n12 >= n13) {
            object3 = this.getWindow().getDecorView();
            n11 = 8192;
            object3.setSystemUiVisibility(n11);
        }
        object3 = new RelativeLayout((Context)this);
        n11 = -1;
        object3.setBackgroundColor(n11);
        Object object4 = new RelativeLayout((Context)this);
        this.as = object2 = new TextView((Context)this);
        object2.setText((CharSequence)"\u5173\u95ed");
        this.as.setTextSize(17.0f);
        this.as.setTextColor(-32256);
        object2 = this.as;
        Object object5 = new WebActivity$2(this);
        object2.setOnClickListener((View.OnClickListener)object5);
        this.at = object2 = new TextView((Context)this);
        object2.setTextSize(18.0f);
        this.at.setTextColor(-11382190);
        int n14 = -2;
        object2 = new RelativeLayout.LayoutParams(n14, n14);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(n14, n14);
        object2.addRule(15);
        TextView textView = this.as;
        int n15 = 10;
        int n16 = e.a(n15, (Context)this);
        n15 = e.a(n15, (Context)this);
        textView.setPadding(n16, 0, n15, 0);
        int n17 = 13;
        layoutParams.addRule(n17);
        Object object6 = this.as;
        object4.addView((View)object6, (ViewGroup.LayoutParams)object2);
        object2 = this.at;
        object4.addView((View)object2, (ViewGroup.LayoutParams)layoutParams);
        int n18 = 55;
        n15 = e.a(n18, (Context)this);
        object2 = new RelativeLayout.LayoutParams(n11, n15);
        object3.addView((View)object4, (ViewGroup.LayoutParams)object2);
        object2 = this.getApplicationContext();
        object4 = new WebView((Context)object2);
        this.au = object4;
        object4 = new RelativeLayout.LayoutParams(n11, n11);
        object4.topMargin = n10 = e.a(n18, (Context)this);
        object2 = this.au;
        object3.addView((View)object2, (ViewGroup.LayoutParams)object4);
        object4 = new ProgressBar((Context)this);
        this.av = object4;
        n10 = 3;
        n15 = e.a(n10, (Context)this);
        object4 = new RelativeLayout.LayoutParams(n11, n15);
        object4.topMargin = n15 = e.a(n18, (Context)this);
        object6 = this.av;
        object3.addView((View)object6, (ViewGroup.LayoutParams)object4);
        object4 = new View((Context)this);
        object6 = this.getResources();
        String string2 = this.getPackageName();
        String string3 = "drawable";
        n15 = object6.getIdentifier("weibosdk_common_shadow_top", string3, string2);
        object4.setBackgroundResource(n15);
        n16 = e.a(n10, (Context)this);
        object6 = new RelativeLayout.LayoutParams(n11, n16);
        n18 = e.a(n18, (Context)this);
        object6.topMargin = n18;
        object3.addView((View)object4, (ViewGroup.LayoutParams)object6);
        object4 = new LinearLayout((Context)this);
        this.ar = object4;
        n18 = 1;
        object4.setOrientation(n18);
        object4 = new ImageView((Context)this);
        object6 = this.getResources();
        string2 = this.getPackageName();
        n15 = object6.getIdentifier("weibosdk_empty_failed", string3, string2);
        object4.setImageResource(n15);
        this.ar.addView((View)object4);
        object4 = new TextView((Context)this);
        object4.setTextSize(14.0f);
        object4.setTextColor(-4342339);
        object6 = new LinearLayout.LayoutParams(n14, n14);
        object6.topMargin = n16 = e.a(18, (Context)this);
        object6.bottomMargin = n16 = e.a(20, (Context)this);
        this.ar.addView((View)object4, (ViewGroup.LayoutParams)object6);
        object4.setText((CharSequence)"\u7f51\u7edc\u51fa\u9519\u5566\uff0c\u8bf7\u70b9\u51fb\u6309\u94ae\u91cd\u65b0\u52a0\u8f7d");
        object4 = new Button((Context)this);
        object4.setTextSize(16.0f);
        object4.setTextColor(-8882056);
        n16 = e.a(142, (Context)this);
        int n19 = e.a(46, (Context)this);
        object6 = new LinearLayout.LayoutParams(n16, n19);
        object6.gravity = n16 = 17;
        this.ar.addView((View)object4, (ViewGroup.LayoutParams)object6);
        object6 = this.getResources();
        string2 = this.getPackageName();
        String string4 = "retry_btn_selector";
        n15 = object6.getIdentifier(string4, string3, string2);
        object4.setBackgroundResource(n15);
        object4.setText((CharSequence)"\u91cd\u65b0\u52a0\u8f7d");
        object6 = new WebActivity$3(this);
        object4.setOnClickListener((View.OnClickListener)object6);
        object4 = new RelativeLayout.LayoutParams(n14, n14);
        object4.addRule(n17);
        object5 = this.ar;
        object3.addView((View)object5, (ViewGroup.LayoutParams)object4);
        object4 = this.ar;
        n14 = 8;
        object4.setVisibility(n14);
        object4 = this.au;
        object5 = new WebActivity$4(this);
        object4.setWebChromeClient((WebChromeClient)object5);
        this.setContentView((View)object3);
        object3 = this.getIntent();
        if (object3 == null) {
            this.finish();
            return;
        }
        object4 = object3.getExtras();
        if (object4 == null) {
            this.finish();
            return;
        }
        object5 = "web_type";
        n13 = object3.getIntExtra((String)object5, n11);
        if (n13 == n11) {
            this.finish();
            return;
        }
        n11 = 2;
        if (n13 != n18) {
            if (n13 != n11) {
                if (n13 == n10) {
                    object3 = new c();
                    this.aw = object3;
                    object2 = this.aw;
                    object3 = new com.sina.weibo.sdk.web.a.c(this, (com.sina.weibo.sdk.web.b.b)object2);
                    this.ax = object3;
                }
            } else {
                this.ay = "\u5fae\u535a\u767b\u5f55";
                object3 = new a();
                this.aw = object3;
                object2 = this.aw;
                object3 = new com.sina.weibo.sdk.web.a.a(this, this, (com.sina.weibo.sdk.web.b.b)object2);
                this.ax = object3;
            }
        } else {
            this.ay = "\u5fae\u535a\u5206\u4eab";
            object3 = new com.sina.weibo.sdk.web.b.d((Context)this);
            this.aw = object3;
            object2 = this.aw;
            object3 = new d(this, this, (com.sina.weibo.sdk.web.b.b)object2);
            this.ax = object3;
        }
        object3 = this.au;
        object2 = this.ax;
        object3.setWebViewClient((WebViewClient)object2);
        this.aw.readFromBundle((Bundle)object4);
        object3 = this.au.getSettings();
        object3.setSavePassword(false);
        object3.setAllowContentAccess(false);
        object4 = e.r();
        object3.setUserAgentString((String)object4);
        object3.setAllowFileAccess(false);
        object3.setJavaScriptEnabled(n18 != 0);
        object3.setGeolocationEnabled(false);
        int n20 = 16;
        if (n12 >= n20) {
            object3.setAllowFileAccessFromFileURLs(false);
            object3.setAllowUniversalAccessFromFileURLs(false);
        }
        this.au.requestFocus();
        this.au.setScrollBarStyle(0);
        WebActivity.a(this.au, "searchBoxJavaBridge_");
        WebActivity.a(this.au, "accessibility");
        object4 = this.au;
        object2 = "accessibilityTraversal";
        WebActivity.a((WebView)object4, (String)object2);
        n20 = 21;
        if (n12 >= n20) {
            object3.setMixedContentMode(n11);
        }
        if ((n12 = (int)(((com.sina.weibo.sdk.web.b.b)(object = this.aw)).w() ? 1 : 0)) != 0) {
            object = this.aw;
            object3 = new WebActivity$1(this);
            ((com.sina.weibo.sdk.web.b.b)object).a((b$a)object3);
        } else {
            object = this.aw.getUrl();
            n13 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0);
            if (n13 == 0 && (n13 = (int)(WebActivity.j((String)object) ? 1 : 0)) != 0) {
                object3 = this.au;
                object3.loadUrl((String)object);
            }
        }
        object = this.at;
        if (object != null) {
            object3 = this.ay;
            object.setText((CharSequence)object3);
        }
    }

    public boolean onKeyDown(int n10, KeyEvent keyEvent) {
        int n11 = 4;
        if (n10 == n11) {
            b b10 = this.ax;
            n11 = (int)(b10.v() ? 1 : 0);
            boolean bl2 = true;
            if (n11 != 0) {
                return bl2;
            }
            b10 = this.au;
            n11 = (int)(b10.canGoBack() ? 1 : 0);
            if (n11 != 0) {
                this.au.goBack();
                return bl2;
            }
        }
        return super.onKeyDown(n10, keyEvent);
    }

    public final void s() {
        this.ar.setVisibility(0);
        this.au.setVisibility(8);
    }

    public final void t() {
        this.finish();
    }
}

