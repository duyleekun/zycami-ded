/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.webkit.WebChromeClient
 *  android.webkit.WebView
 *  android.widget.ProgressBar
 */
package com.kwai.auth.login.kwailogin.h5login;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;
import com.kwai.auth.login.kwailogin.h5login.KwaiH5LoginActivity;

public class KwaiH5LoginActivity$c
extends WebChromeClient {
    public final /* synthetic */ KwaiH5LoginActivity a;

    public KwaiH5LoginActivity$c(KwaiH5LoginActivity kwaiH5LoginActivity) {
        this.a = kwaiH5LoginActivity;
    }

    public void onCloseWindow(WebView webView) {
        super.onCloseWindow(webView);
        this.a.finish();
    }

    public void onProgressChanged(WebView webView, int n10) {
        ProgressBar progressBar = KwaiH5LoginActivity.d(this.a);
        if (progressBar == null) {
            return;
        }
        int n11 = 100;
        if (n10 == n11) {
            progressBar = KwaiH5LoginActivity.d(this.a);
            int n12 = 8;
            progressBar.setVisibility(n12);
        } else {
            KwaiH5LoginActivity.d(this.a).setProgress(n10);
            progressBar = KwaiH5LoginActivity.d(this.a);
            boolean bl2 = false;
            progressBar.setVisibility(0);
        }
        super.onProgressChanged(webView, n10);
    }
}

