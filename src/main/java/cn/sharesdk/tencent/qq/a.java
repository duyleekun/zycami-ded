/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.view.KeyEvent
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.view.Window
 *  android.webkit.WebSettings$LayoutAlgorithm
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 */
package cn.sharesdk.tencent.qq;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import cn.sharesdk.framework.authorize.SSOListener;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.tencent.qq.a$1;
import com.mob.tools.FakeActivity;
import com.mob.tools.log.NLog;
import java.lang.reflect.Method;

public class a
extends FakeActivity {
    private LinearLayout a;
    private WebView b;
    private String c = "http://qzs.qq.com/open/mobile/login/qzsjump.html?sdkv=3.3.0.lite&display=mobile";
    private String d = "http://app.qq.com/detail/com.tencent.mobileqq?autodownload=1&norecommend=1&rootvia=opensdk";
    private SSOListener e;

    public static /* synthetic */ SSOListener a(a a10, SSOListener sSOListener) {
        a10.e = sSOListener;
        return sSOListener;
    }

    public static /* synthetic */ String a(a a10) {
        return a10.d;
    }

    private void a(Activity activity) {
        this.b();
        activity = this.b;
        Object object = new a$1(this);
        activity.setWebViewClient((WebViewClient)object);
        activity = this.b;
        object = this.c;
        activity.loadUrl((String)object);
    }

    public static /* synthetic */ SSOListener b(a a10) {
        return a10.e;
    }

    private void b() {
        LinearLayout linearLayout;
        Context context = this.getContext();
        this.a = linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        int n10 = -1;
        linearLayout = new LinearLayout.LayoutParams(n10, n10);
        Context context2 = this.getContext();
        linearLayout = new WebView(context2);
        this.b = linearLayout;
        linearLayout = new LinearLayout.LayoutParams(n10, 0, 11.0f);
        context = this.a;
        context2 = this.b;
        context.addView((View)context2, (ViewGroup.LayoutParams)linearLayout);
        this.c();
    }

    private void c() {
        Object object;
        int n10 = Build.VERSION.SDK_INT;
        WebSettings.LayoutAlgorithm layoutAlgorithm = null;
        int n11 = 1;
        int n12 = 10;
        if (n10 > n12 && n10 < (n12 = 17)) {
            object = this.b;
            object = object.getClass();
            Object object2 = "removeJavascriptInterface";
            Object[] objectArray = new Class[n11];
            Object object3 = String.class;
            objectArray[0] = object3;
            object = ((Class)object).getMethod((String)object2, (Class<?>[])objectArray);
            ((Method)object).setAccessible(n11 != 0);
            object2 = this.b;
            objectArray = new Object[n11];
            object3 = "searchBoxJavaBridge_";
            objectArray[0] = object3;
            ((Method)object).invoke(object2, objectArray);
            object2 = this.b;
            objectArray = new Object[n11];
            object3 = "accessibility";
            objectArray[0] = object3;
            ((Method)object).invoke(object2, objectArray);
            object2 = this.b;
            objectArray = new Object[n11];
            object3 = "accessibilityTraversal";
            objectArray[0] = object3;
            try {
                ((Method)object).invoke(object2, objectArray);
            }
            catch (Throwable throwable) {
                object2 = SSDKLog.b();
                ((NLog)object2).d(throwable);
            }
        }
        object = this.b.getSettings();
        object.setCacheMode(2);
        object.setUseWideViewPort(n11 != 0);
        object.setJavaScriptEnabled(n11 != 0);
        this.b.setVerticalScrollBarEnabled(false);
        this.b.setHorizontalScrollBarEnabled(false);
        layoutAlgorithm = WebSettings.LayoutAlgorithm.SINGLE_COLUMN;
        object.setLayoutAlgorithm(layoutAlgorithm);
    }

    public void a() {
        this.finish();
    }

    public void a(SSOListener sSOListener) {
        this.e = sSOListener;
    }

    public void onCreate() {
        Window window = this.activity.getWindow();
        ColorDrawable colorDrawable = new ColorDrawable(-1);
        window.setBackgroundDrawable((Drawable)colorDrawable);
        window = this.activity;
        this.a((Activity)window);
        window = this.activity;
        colorDrawable = this.a;
        window.setContentView((View)colorDrawable);
    }

    public boolean onKeyEvent(int n10, KeyEvent keyEvent) {
        int n11;
        int n12 = 4;
        if (n10 == n12 && (n12 = keyEvent.getAction()) == (n11 = 1)) {
            WebView webView = this.b;
            if (webView != null && (n10 = (int)(webView.canGoBack() ? 1 : 0)) != 0) {
                webView = this.b;
                webView.goBack();
            } else {
                this.e.onCancel();
                n10 = 0;
                webView = null;
                this.e = null;
                this.a();
            }
            return n11;
        }
        return super.onKeyEvent(n10, keyEvent);
    }
}

