/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.ViewGroup$LayoutParams
 *  android.webkit.WebChromeClient
 *  android.webkit.WebView
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.TextView
 */
package cn.sharesdk.framework.authorize;

import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.sharesdk.framework.authorize.RegisterView;

public class RegisterView$2
extends WebChromeClient {
    public final /* synthetic */ int a;
    public final /* synthetic */ RegisterView b;

    public RegisterView$2(RegisterView registerView, int n10) {
        this.b = registerView;
        this.a = n10;
    }

    public void onProgressChanged(WebView webView, int n10) {
        super.onProgressChanged(webView, n10);
        webView = (LinearLayout.LayoutParams)RegisterView.a(this.b).getLayoutParams();
        int n11 = this.a * n10;
        int n12 = 100;
        webView.width = n11 /= n12;
        TextView textView = RegisterView.a(this.b);
        textView.setLayoutParams((ViewGroup.LayoutParams)webView);
        if (n10 > 0 && n10 < n12) {
            webView = RegisterView.a(this.b);
            n10 = 0;
            webView.setVisibility(0);
        } else {
            webView = RegisterView.a(this.b);
            n10 = 8;
            webView.setVisibility(n10);
        }
    }
}

