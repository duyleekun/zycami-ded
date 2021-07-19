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

public class WeiboSsoSdk$b
implements Runnable {
    public final /* synthetic */ WeiboSsoSdk a;

    public WeiboSsoSdk$b(WeiboSsoSdk weiboSsoSdk) {
        this.a = weiboSsoSdk;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void run() {
        Object object;
        block19: {
            block18: {
                boolean bl2;
                block17: {
                    long l10 = 60000L;
                    try {
                        Thread.sleep(l10);
                        object = this.a;
                    }
                    catch (Exception exception) {
                        return;
                    }
                    bl2 = WeiboSsoSdk.g((WeiboSsoSdk)object);
                    if (bl2) break block17;
                    return;
                }
                object = this.a;
                object = WeiboSsoSdk.c((WeiboSsoSdk)object);
                if (object == null) break block18;
                object = this.a;
                object = WeiboSsoSdk.c((WeiboSsoSdk)object);
                object = ((WeiboSsoSdk$h)object).b();
                bl2 = TextUtils.isEmpty((CharSequence)object);
                if (bl2) break block18;
                object = this.a;
                object = WeiboSsoSdk.c((WeiboSsoSdk)object);
                object = ((WeiboSsoSdk$h)object).b();
                break block19;
            }
            object = this.a;
            object = WeiboSsoSdk.e((WeiboSsoSdk)object);
        }
        WeiboSsoSdk weiboSsoSdk = this.a;
        int n10 = 2;
        WeiboSsoSdk.f(weiboSsoSdk, (String)object, n10);
    }
}

