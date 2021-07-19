/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.webkit.WebView
 */
package cn.sharesdk.sina.weibo;

import android.webkit.WebView;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.sina.weibo.h;
import com.mob.tools.RxMob$Subscriber;

public class h$3
extends RxMob$Subscriber {
    public final /* synthetic */ h a;

    public h$3(h h10) {
        this.a = h10;
    }

    public void a(String string2) {
        WebView webView = h.c(this.a);
        string2 = h.b(this.a, string2);
        webView.loadUrl(string2);
    }

    public void onCompleted() {
        super.onCompleted();
    }

    public void onError(Throwable throwable) {
        SSDKLog.b().w(throwable);
        throwable = h.c(this.a);
        String string2 = h.b(this.a, null);
        throwable.loadUrl(string2);
    }

    public /* synthetic */ void onNext(Object object) {
        object = (String)object;
        this.a((String)object);
    }

    public void onStart() {
        super.onStart();
    }
}

