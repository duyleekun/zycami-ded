/*
 * Decompiled with CFR 0.151.
 */
package com.weibo.ssosdk;

import com.weibo.ssosdk.WeiboSsoSdk;

public class WeiboSsoSdk$d
implements Runnable {
    public final /* synthetic */ WeiboSsoSdk a;

    public WeiboSsoSdk$d(WeiboSsoSdk weiboSsoSdk) {
        this.a = weiboSsoSdk;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void run() {
        int n10;
        String string2;
        WeiboSsoSdk weiboSsoSdk;
        try {
            weiboSsoSdk = this.a;
            string2 = "";
            n10 = 1;
        }
        catch (Exception exception) {
            return;
        }
        WeiboSsoSdk.f(weiboSsoSdk, string2, n10);
    }
}

