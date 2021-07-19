/*
 * Decompiled with CFR 0.151.
 */
package com.sina.weibo.sdk.a;

import com.sina.weibo.sdk.a.a;
import com.weibo.ssosdk.WeiboSsoSdk$h;
import d.s.a.d;

public final class a$2
implements d {
    public final /* synthetic */ a d;

    public a$2(a a10) {
        this.d = a10;
    }

    public final void handler(WeiboSsoSdk$h object) {
        if (object != null) {
            a a10 = this.d;
            object = ((WeiboSsoSdk$h)object).b();
            try {
                a10.c = object;
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
}

