/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 */
package d.j.f.a.a.l;

import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class b {
    public static void a(WebSettings webSettings) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 11;
        if (n10 >= n11) {
            n10 = 0;
            webSettings.setAllowContentAccess(false);
        }
    }

    public static void b(WebSettings webSettings) {
        webSettings.setAllowFileAccess(false);
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 16;
        if (n10 >= n11) {
            webSettings.setAllowFileAccessFromFileURLs(false);
            webSettings.setAllowUniversalAccessFromFileURLs(false);
        }
    }

    public static void c(WebSettings webSettings) {
        webSettings.setGeolocationEnabled(false);
    }

    public static void d(WebSettings webSettings) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            n10 = 1;
            webSettings.setMixedContentMode(n10);
        }
    }

    public static void e(WebSettings webSettings) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 18;
        if (n10 <= n11) {
            n10 = 0;
            webSettings.setSavePassword(false);
        }
    }

    public static void f(WebView webView) {
        WebSettings webSettings = webView.getSettings();
        b.b(webSettings);
        b.g(webView);
        b.e(webSettings);
        b.c(webSettings);
        b.d(webSettings);
        b.a(webSettings);
    }

    public static void g(WebView webView) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 11;
        if (n10 >= n11) {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            String string2 = "accessibilityTraversal";
            webView.removeJavascriptInterface(string2);
        }
    }
}

