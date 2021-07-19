/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.weibo.ssosdk;

import android.text.TextUtils;
import com.weibo.ssosdk.WeiboSsoSdk;
import com.weibo.ssosdk.WeiboSsoSdk$h;

public class WeiboSsoSdk$a
implements Runnable {
    public final /* synthetic */ WeiboSsoSdk a;

    public WeiboSsoSdk$a(WeiboSsoSdk weiboSsoSdk) {
        this.a = weiboSsoSdk;
    }

    public void run() {
        while (true) {
            Object object;
            block16: {
                block15: {
                    long l10 = 86400000L;
                    try {
                        Thread.sleep(l10);
                        object = this.a;
                    }
                    catch (Exception exception) {
                        continue;
                    }
                    object = WeiboSsoSdk.c((WeiboSsoSdk)object);
                    if (object == null) break block15;
                    object = this.a;
                    object = WeiboSsoSdk.c((WeiboSsoSdk)object);
                    object = ((WeiboSsoSdk$h)object).b();
                    boolean bl2 = TextUtils.isEmpty((CharSequence)object);
                    if (bl2) break block15;
                    object = this.a;
                    object = WeiboSsoSdk.c((WeiboSsoSdk)object);
                    object = ((WeiboSsoSdk$h)object).b();
                    break block16;
                }
                object = this.a;
                object = WeiboSsoSdk.e((WeiboSsoSdk)object);
            }
            WeiboSsoSdk weiboSsoSdk = WeiboSsoSdk.n();
            int n10 = 2;
            WeiboSsoSdk.f(weiboSsoSdk, (String)object, n10);
            continue;
            break;
        }
    }
}

