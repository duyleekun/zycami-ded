/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.webkit.WebChromeClient
 *  android.webkit.WebView
 */
package com.geetest.sdk.dialog.views;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.geetest.sdk.dialog.views.GtWebView;
import com.geetest.sdk.dialog.views.GtWebView$a;
import com.geetest.sdk.utils.l;

public class GtWebView$b
extends WebChromeClient {
    private GtWebView$b(GtWebView gtWebView) {
    }

    public /* synthetic */ GtWebView$b(GtWebView gtWebView, GtWebView$a gtWebView$a) {
        this(gtWebView);
    }

    public final void onProgressChanged(WebView webView, int n10) {
        String string2 = GtWebView.c();
        CharSequence charSequence = new StringBuilder();
        charSequence.append("onProgressChanged-->newProgress: ");
        charSequence.append(n10);
        charSequence = charSequence.toString();
        l.d(string2, (String)charSequence);
        super.onProgressChanged(webView, n10);
    }
}

