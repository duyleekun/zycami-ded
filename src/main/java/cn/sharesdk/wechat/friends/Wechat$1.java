/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package cn.sharesdk.wechat.friends;

import android.os.Bundle;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.wechat.friends.Wechat;

public class Wechat$1
implements AuthorizeListener {
    public final /* synthetic */ Wechat a;

    public Wechat$1(Wechat wechat) {
        this.a = wechat;
    }

    public void onCancel() {
        PlatformActionListener platformActionListener = Wechat.c(this.a);
        if (platformActionListener != null) {
            platformActionListener = Wechat.d(this.a);
            Wechat wechat = this.a;
            int n10 = 1;
            platformActionListener.onCancel(wechat, n10);
        }
    }

    public void onComplete(Bundle bundle) {
        Wechat.a(this.a, 1, null);
    }

    public void onError(Throwable throwable) {
        PlatformActionListener platformActionListener = Wechat.a(this.a);
        if (platformActionListener != null) {
            platformActionListener = Wechat.b(this.a);
            Wechat wechat = this.a;
            int n10 = 1;
            platformActionListener.onError(wechat, n10, throwable);
        }
    }
}

