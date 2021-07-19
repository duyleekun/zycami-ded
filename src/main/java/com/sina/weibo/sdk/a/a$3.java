/*
 * Decompiled with CFR 0.151.
 */
package com.sina.weibo.sdk.a;

import com.sina.weibo.sdk.a.a;
import com.weibo.ssosdk.WeiboSsoSdk;
import com.weibo.ssosdk.WeiboSsoSdk$h;

public final class a$3
implements Runnable {
    public final /* synthetic */ a d;

    public a$3(a a10) {
        this.d = a10;
    }

    public final void run() {
        try {
            a a10 = this.d;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
        Object object = WeiboSsoSdk.n();
        object = ((WeiboSsoSdk)object).u();
        object = ((WeiboSsoSdk$h)object).b();
        a10.c = object;
    }
}

