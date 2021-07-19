/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.net.http.SslError
 *  android.os.Message
 *  android.view.KeyEvent
 *  android.webkit.ClientCertRequest
 *  android.webkit.HttpAuthHandler
 *  android.webkit.RenderProcessGoneDetail
 *  android.webkit.SafeBrowsingResponse
 *  android.webkit.SslErrorHandler
 *  android.webkit.WebResourceError
 *  android.webkit.WebResourceRequest
 *  android.webkit.WebResourceResponse
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 */
package d.j.f.a.a.l;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SafeBrowsingResponse;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import d.j.f.a.a.l.c;
import d.j.f.a.a.l.c$a;

public final class c$d
extends WebViewClient {
    private WebViewClient a;
    private boolean b;
    public final /* synthetic */ c c;

    private c$d(c c10, WebViewClient webViewClient, boolean bl2) {
        this.c = c10;
        this.a = webViewClient;
        this.b = bl2;
    }

    public /* synthetic */ c$d(c c10, WebViewClient webViewClient, boolean bl2, c$a c$a) {
        this(c10, webViewClient, bl2);
    }

    public void doUpdateVisitedHistory(WebView webView, String string2, boolean bl2) {
        WebViewClient webViewClient = this.a;
        if (webViewClient != null) {
            webViewClient.doUpdateVisitedHistory(webView, string2, bl2);
        } else {
            super.doUpdateVisitedHistory(webView, string2, bl2);
        }
    }

    public void onFormResubmission(WebView webView, Message message, Message message2) {
        WebViewClient webViewClient = this.a;
        if (webViewClient != null) {
            webViewClient.onFormResubmission(webView, message, message2);
        } else {
            super.onFormResubmission(webView, message, message2);
        }
    }

    public void onLoadResource(WebView webView, String string2) {
        WebViewClient webViewClient = this.a;
        if (webViewClient != null) {
            webViewClient.onLoadResource(webView, string2);
        } else {
            super.onLoadResource(webView, string2);
        }
    }

    public void onPageCommitVisible(WebView webView, String string2) {
        WebViewClient webViewClient = this.a;
        if (webViewClient != null) {
            webViewClient.onPageCommitVisible(webView, string2);
        } else {
            super.onPageCommitVisible(webView, string2);
        }
    }

    public void onPageFinished(WebView webView, String string2) {
        WebViewClient webViewClient = this.a;
        if (webViewClient != null) {
            webViewClient.onPageFinished(webView, string2);
        } else {
            super.onPageFinished(webView, string2);
        }
    }

    public void onPageStarted(WebView webView, String string2, Bitmap bitmap) {
        boolean bl2;
        Object object = this.a;
        if (object != null && !(bl2 = this.b)) {
            object.onPageStarted(webView, string2, bitmap);
            return;
        }
        object = this.c;
        boolean bl3 = object.c(string2);
        if (!bl3) {
            this.c.d(webView, string2);
            return;
        }
        super.onPageStarted(webView, string2, bitmap);
    }

    public void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
        WebViewClient webViewClient = this.a;
        if (webViewClient != null) {
            webViewClient.onReceivedClientCertRequest(webView, clientCertRequest);
        } else {
            super.onReceivedClientCertRequest(webView, clientCertRequest);
        }
    }

    public void onReceivedError(WebView webView, int n10, String string2, String string3) {
        WebViewClient webViewClient = this.a;
        if (webViewClient != null) {
            webViewClient.onReceivedError(webView, n10, string2, string3);
        } else {
            super.onReceivedError(webView, n10, string2, string3);
        }
    }

    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        WebViewClient webViewClient = this.a;
        if (webViewClient != null) {
            webViewClient.onReceivedError(webView, webResourceRequest, webResourceError);
        } else {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
        }
    }

    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String string2, String string3) {
        WebViewClient webViewClient = this.a;
        if (webViewClient != null) {
            webViewClient.onReceivedHttpAuthRequest(webView, httpAuthHandler, string2, string3);
        } else {
            super.onReceivedHttpAuthRequest(webView, httpAuthHandler, string2, string3);
        }
    }

    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        WebViewClient webViewClient = this.a;
        if (webViewClient != null) {
            webViewClient.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        } else {
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        }
    }

    public void onReceivedLoginRequest(WebView webView, String string2, String string3, String string4) {
        WebViewClient webViewClient = this.a;
        if (webViewClient != null) {
            webViewClient.onReceivedLoginRequest(webView, string2, string3, string4);
        } else {
            super.onReceivedLoginRequest(webView, string2, string3, string4);
        }
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        WebViewClient webViewClient = this.a;
        if (webViewClient != null) {
            webViewClient.onReceivedSslError(webView, sslErrorHandler, sslError);
        } else {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    }

    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        WebViewClient webViewClient = this.a;
        if (webViewClient != null) {
            return webViewClient.onRenderProcessGone(webView, renderProcessGoneDetail);
        }
        return super.onRenderProcessGone(webView, renderProcessGoneDetail);
    }

    public void onSafeBrowsingHit(WebView webView, WebResourceRequest webResourceRequest, int n10, SafeBrowsingResponse safeBrowsingResponse) {
        WebViewClient webViewClient = this.a;
        if (webViewClient != null) {
            webViewClient.onSafeBrowsingHit(webView, webResourceRequest, n10, safeBrowsingResponse);
        } else {
            super.onSafeBrowsingHit(webView, webResourceRequest, n10, safeBrowsingResponse);
        }
    }

    public void onScaleChanged(WebView webView, float f10, float f11) {
        WebViewClient webViewClient = this.a;
        if (webViewClient != null) {
            webViewClient.onScaleChanged(webView, f10, f11);
        } else {
            super.onScaleChanged(webView, f10, f11);
        }
    }

    public void onTooManyRedirects(WebView webView, Message message, Message message2) {
        WebViewClient webViewClient = this.a;
        if (webViewClient != null) {
            webViewClient.onTooManyRedirects(webView, message, message2);
        } else {
            super.onTooManyRedirects(webView, message, message2);
        }
    }

    public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
        WebViewClient webViewClient = this.a;
        if (webViewClient != null) {
            webViewClient.onUnhandledKeyEvent(webView, keyEvent);
        } else {
            super.onUnhandledKeyEvent(webView, keyEvent);
        }
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        WebViewClient webViewClient = this.a;
        if (webViewClient != null) {
            return webViewClient.shouldInterceptRequest(webView, webResourceRequest);
        }
        return super.shouldInterceptRequest(webView, webResourceRequest);
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String string2) {
        WebViewClient webViewClient = this.a;
        if (webViewClient != null) {
            return webViewClient.shouldInterceptRequest(webView, string2);
        }
        return super.shouldInterceptRequest(webView, string2);
    }

    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        WebViewClient webViewClient = this.a;
        if (webViewClient != null) {
            return webViewClient.shouldOverrideKeyEvent(webView, keyEvent);
        }
        return super.shouldOverrideKeyEvent(webView, keyEvent);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        WebViewClient webViewClient = this.a;
        if (webViewClient != null) {
            return webViewClient.shouldOverrideUrlLoading(webView, webResourceRequest);
        }
        return super.shouldOverrideUrlLoading(webView, webResourceRequest);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String string2) {
        WebViewClient webViewClient = this.a;
        if (webViewClient != null) {
            return webViewClient.shouldOverrideUrlLoading(webView, string2);
        }
        return super.shouldOverrideUrlLoading(webView, string2);
    }
}

