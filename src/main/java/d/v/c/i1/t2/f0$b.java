/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.webkit.WebResourceError
 *  android.webkit.WebResourceRequest
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 */
package d.v.c.i1.t2;

import android.graphics.Bitmap;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import d.v.c.i1.t2.f0;

public class f0$b
extends WebViewClient {
    public final /* synthetic */ f0 a;

    public f0$b(f0 f02) {
        this.a = f02;
    }

    public void onPageFinished(WebView webView, String string2) {
        super.onPageFinished(webView, string2);
        f0 f02 = this.a;
        boolean bl2 = f02.isAdded();
        if (!bl2) {
            f0.j(this.a);
            return;
        }
        this.a.y(webView, string2);
    }

    public void onPageStarted(WebView webView, String string2, Bitmap bitmap) {
        super.onPageStarted(webView, string2, bitmap);
        this.a.z(webView, string2, bitmap);
    }

    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        this.a.A(webView, webResourceRequest, webResourceError);
    }
}

