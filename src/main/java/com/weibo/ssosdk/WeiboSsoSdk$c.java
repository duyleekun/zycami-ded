/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.weibo.ssosdk;

import android.text.TextUtils;
import com.weibo.ssosdk.WeiboSsoSdk;

public class WeiboSsoSdk$c
implements Runnable {
    public final /* synthetic */ WeiboSsoSdk a;

    public WeiboSsoSdk$c(WeiboSsoSdk weiboSsoSdk) {
        this.a = weiboSsoSdk;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void run() {
        int n10;
        WeiboSsoSdk weiboSsoSdk;
        boolean bl2;
        Object object = WeiboSsoSdk.c(this.a);
        object = object != null && !(bl2 = TextUtils.isEmpty((CharSequence)(object = WeiboSsoSdk.c(this.a).b()))) ? WeiboSsoSdk.c(this.a).b() : WeiboSsoSdk.e(this.a);
        try {
            weiboSsoSdk = this.a;
            n10 = 2;
        }
        catch (Exception exception) {
            return;
        }
        WeiboSsoSdk.f(weiboSsoSdk, (String)object, n10);
    }
}

