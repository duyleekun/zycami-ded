/*
 * Decompiled with CFR 0.151.
 */
package com.weibo.ssosdk;

import com.weibo.ssosdk.WeiboSsoSdk;
import com.weibo.ssosdk.WeiboSsoSdk$h;
import d.s.a.a;

public class WeiboSsoSdk$g
implements Runnable {
    public final /* synthetic */ a a;
    public final /* synthetic */ WeiboSsoSdk b;

    public WeiboSsoSdk$g(WeiboSsoSdk weiboSsoSdk, a a10) {
        this.b = weiboSsoSdk;
        this.a = a10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        Object object;
        Object object2;
        try {
            object2 = this.b;
            object = "";
            int n10 = 1;
            WeiboSsoSdk.f((WeiboSsoSdk)object2, (String)object, n10);
        }
        catch (Exception exception) {}
        if ((object2 = WeiboSsoSdk.c(this.b)) == null) {
            object2 = this.b;
            object = new WeiboSsoSdk$h();
            WeiboSsoSdk.d((WeiboSsoSdk)object2, (WeiboSsoSdk$h)object);
        }
        object2 = this.a;
        object = WeiboSsoSdk.c(this.b).b();
        object2.a((String)object);
    }
}

