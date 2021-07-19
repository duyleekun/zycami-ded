/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.graphics.Bitmap
 *  android.net.Uri
 *  android.net.http.SslError
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 *  android.webkit.SslErrorHandler
 *  android.webkit.WebResourceError
 *  android.webkit.WebResourceRequest
 *  android.webkit.WebResourceResponse
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 */
package com.geetest.sdk.dialog.views;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.geetest.sdk.au;
import com.geetest.sdk.dialog.views.GtWebView;
import com.geetest.sdk.model.beans.b;
import com.geetest.sdk.model.beans.g;
import com.geetest.sdk.utils.l;

public class GtWebView$c
extends WebViewClient {
    private GtWebView a;
    public final /* synthetic */ GtWebView b;

    public GtWebView$c(GtWebView gtWebView, GtWebView gtWebView2) {
        this.b = gtWebView;
        this.a = gtWebView2;
    }

    public void onLoadResource(WebView webView, String string2) {
        String string3 = GtWebView.c();
        CharSequence charSequence = new StringBuilder();
        charSequence.append("onLoadResource-->url: ");
        charSequence.append(string2);
        charSequence = charSequence.toString();
        l.b(string3, (String)charSequence);
        super.onLoadResource(webView, string2);
    }

    public void onPageFinished(WebView webView, String string2) {
        String string3 = GtWebView.c();
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Webview-->onPageFinished-->url: ");
        charSequence.append(string2);
        charSequence = charSequence.toString();
        l.b(string3, (String)charSequence);
        super.onPageFinished(webView, string2);
    }

    public void onPageStarted(WebView webView, String string2, Bitmap bitmap) {
        String string3 = GtWebView.c();
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Webview-->onPageStarted-->url: ");
        charSequence.append(string2);
        charSequence = charSequence.toString();
        l.b(string3, (String)charSequence);
        super.onPageStarted(webView, string2, bitmap);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        int n10;
        Object object;
        Object object2;
        block15: {
            int n11;
            Object object3;
            int n12;
            block16: {
                Exception exception2;
                block12: {
                    CharSequence charSequence;
                    object2 = "onReceivedError-->Description: ";
                    object = "onReceivedError-->url: ";
                    n12 = Build.VERSION.SDK_INT;
                    object3 = GtWebView.b(this.b);
                    if (object3 == null) break block15;
                    object3 = null;
                    n11 = 23;
                    int n13 = 21;
                    if (n12 >= n13) {
                        try {
                            charSequence = new StringBuilder();
                            ((StringBuilder)charSequence).append((String)object);
                            Object object4 = webResourceRequest.getUrl();
                            ((StringBuilder)charSequence).append(object4);
                            object3 = ((StringBuilder)charSequence).toString();
                            charSequence = GtWebView.c();
                            object4 = new StringBuilder();
                            ((StringBuilder)object4).append((String)object);
                            object = webResourceRequest.getUrl();
                            ((StringBuilder)object4).append(object);
                            object = ((StringBuilder)object4).toString();
                            l.b((String)charSequence, (String)object);
                        }
                        catch (Exception exception2) {
                            break block12;
                        }
                    }
                    if (n12 >= n11) {
                        object = new StringBuilder();
                        ((StringBuilder)object).append((String)object2);
                        charSequence = webResourceError.getDescription();
                        ((StringBuilder)object).append((Object)charSequence);
                        charSequence = "-->onReceivedError-->ErrorCode: ";
                        ((StringBuilder)object).append((String)charSequence);
                        n13 = webResourceError.getErrorCode();
                        ((StringBuilder)object).append(n13);
                        object3 = ((StringBuilder)object).toString();
                        object = GtWebView.c();
                        charSequence = new StringBuilder();
                        ((StringBuilder)charSequence).append((String)object2);
                        object2 = webResourceError.getDescription();
                        ((StringBuilder)charSequence).append(object2);
                        object2 = ((StringBuilder)charSequence).toString();
                        l.b((String)object, (String)object2);
                        object2 = GtWebView.c();
                        object = new StringBuilder();
                        charSequence = "onReceivedError-->ErrorCode: ";
                        ((StringBuilder)object).append((String)charSequence);
                        n13 = webResourceError.getErrorCode();
                        ((StringBuilder)object).append(n13);
                        object = ((StringBuilder)object).toString();
                        l.b((String)object2, (String)object);
                    }
                    break block16;
                }
                exception2.printStackTrace();
            }
            if (n12 >= n11) {
                try {
                    object2 = webResourceRequest.getUrl();
                    object2 = object2.toString();
                    object = ".mp3";
                    int n14 = ((String)object2).endsWith((String)object);
                    if (n14 != 0 && (n14 = webResourceError.getErrorCode()) == (n10 = -1)) {
                        super.onReceivedError(webView, webResourceRequest, webResourceError);
                        return;
                    }
                }
                catch (Exception exception) {}
            }
            object2 = GtWebView.c();
            object = "webview\u52a0\u8f7d\u51fa\u9519 \u9519\u8bef\u7801\uff1a204_1 \u4e2d\u95f4\u9875\u5730\u5740\u6709\u8bef\u6216\u52a0\u8f7d\u5931\u8d25";
            l.b((String)object2, (String)object);
            object2 = GtWebView.b(this.b);
            n10 = TextUtils.isEmpty((CharSequence)object3);
            if (n10 != 0) {
                object3 = "Webview-->onReceivedError: webview load error !";
            }
            object = "204_1";
            ((au)object2).a((String)object, (String)object3);
        }
        if ((object2 = GtWebView.c(this.b)) != null) {
            try {
                object2 = this.b;
                object2 = GtWebView.c((GtWebView)((Object)object2));
                object = this.b;
                object = GtWebView.d((GtWebView)((Object)object));
                object2.removeCallbacks((Runnable)object);
                object2 = this.b;
                object2 = GtWebView.c((GtWebView)((Object)object2));
                n10 = 1;
                object2.removeMessages(n10);
            }
            catch (Exception exception) {}
        }
        super.onReceivedError(webView, webResourceRequest, webResourceError);
    }

    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        block43: {
            String string2 = "?";
            int n10 = Build.VERSION.SDK_INT;
            int n11 = 21;
            if (n10 >= n11) {
                Object object = webResourceRequest.getUrl();
                object = object.toString();
                n11 = ((String)object).indexOf(string2);
                Object object2 = ((String)object).substring(0, n11);
                Object object3 = GtWebView.c();
                Object object4 = new StringBuilder();
                CharSequence charSequence = "onReceivedHttpError-->getStatusCode: ";
                ((StringBuilder)object4).append((String)charSequence);
                int n12 = webResourceResponse.getStatusCode();
                ((StringBuilder)object4).append(n12);
                object4 = ((StringBuilder)object4).toString();
                l.b(object3, (String)object4);
                object3 = GtWebView.c();
                object4 = new StringBuilder();
                charSequence = "onReceivedHttpError-->url: ";
                ((StringBuilder)object4).append((String)charSequence);
                ((StringBuilder)object4).append((String)object);
                object4 = ((StringBuilder)object4).toString();
                l.b(object3, (String)object4);
                object3 = this.b;
                object3 = GtWebView.e((GtWebView)((Object)object3));
                int n13 = TextUtils.isEmpty((CharSequence)object3);
                if (n13 != 0) break block43;
                object3 = this.b;
                object3 = GtWebView.e((GtWebView)((Object)object3));
                object4 = this.b;
                object4 = GtWebView.e((GtWebView)((Object)object4));
                int n14 = ((String)object4).indexOf(string2);
                object3 = object3.substring(0, n14);
                n11 = (int)(TextUtils.equals((CharSequence)object2, (CharSequence)object3) ? 1 : 0);
                if (n11 == 0) break block43;
                object2 = this.b;
                object2 = GtWebView.f((GtWebView)((Object)object2));
                object2 = ((b)object2).i();
                object2 = ((g)object2).b();
                if (object2 == null) break block43;
                n13 = object2.size();
                n14 = 1;
                if (n13 <= n14) break block43;
                object3 = this.a;
                charSequence = new StringBuilder();
                String string3 = "https://%s/static/appweb/app3-index.html";
                Object[] objectArray = new Object[n14];
                object2 = object2.get(n14);
                objectArray[0] = object2;
                object2 = String.format(string3, objectArray);
                ((StringBuilder)charSequence).append((String)object2);
                int n15 = ((String)object).indexOf(string2);
                string2 = ((String)object).substring(n15);
                ((StringBuilder)charSequence).append(string2);
                string2 = ((StringBuilder)charSequence).toString();
                try {
                    object3.loadUrl(string2);
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onReceivedSslError(WebView object, SslErrorHandler object2, SslError object3) {
        super.onReceivedSslError((WebView)object, (SslErrorHandler)object2, object3);
        object = GtWebView.b(this.b);
        if (object != null) {
            object = GtWebView.c();
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("onReceivedSslError-->webview\u52a0\u8f7d\u51fa\u9519 \u9519\u8bef\u7801\uff1a204_2 \u7f51\u7edc\u8bc1\u4e66\u6709\u8bef, ");
            String string2 = object3.toString();
            ((StringBuilder)object2).append(string2);
            object2 = ((StringBuilder)object2).toString();
            l.b((String)object, (String)object2);
            object = GtWebView.b(this.b);
            object2 = new StringBuilder();
            string2 = "Webview-->onReceivedSslError: ";
            ((StringBuilder)object2).append(string2);
            String string3 = object3.toString();
            ((StringBuilder)object2).append(string3);
            object2 = ((StringBuilder)object2).toString();
            String string4 = "204_2";
            ((au)object).a(string4, (String)object2);
        }
        if ((object = GtWebView.c(this.b)) == null) return;
        try {
            object = this.b;
            object = GtWebView.c((GtWebView)((Object)object));
            object2 = this.b;
            object2 = GtWebView.d((GtWebView)((Object)object2));
            object.removeCallbacks((Runnable)object2);
            object = this.b;
            object = GtWebView.c((GtWebView)((Object)object));
            int n10 = 1;
            object.removeMessages(n10);
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean shouldOverrideUrlLoading(WebView object, String string2) {
        Context context;
        String string3;
        if (object != null && string3 != null && (context = GtWebView.a(this.b)) != null) {
            try {
                String string4 = "android.intent.action.VIEW";
                Intent intent = new Intent(string4);
                int n10 = 0x10000000;
                intent.addFlags(n10);
                Uri uri = Uri.parse((String)string3);
                intent.setData(uri);
                GtWebView gtWebView = this.b;
                Context context2 = GtWebView.a(gtWebView);
                context2.startActivity(intent);
            }
            catch (Exception exception) {}
        }
        String string5 = GtWebView.c();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("shouldOverrideUrlLoading-->url: ");
        stringBuilder.append(string3);
        string3 = stringBuilder.toString();
        l.d(string5, string3);
        return true;
    }
}

