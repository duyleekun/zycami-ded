/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package cn.sharesdk.wechat.moments;

import android.os.Bundle;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.wechat.moments.WechatMoments;

public class WechatMoments$1
implements AuthorizeListener {
    public final /* synthetic */ WechatMoments a;

    public WechatMoments$1(WechatMoments wechatMoments) {
        this.a = wechatMoments;
    }

    public void onCancel() {
        PlatformActionListener platformActionListener = WechatMoments.c(this.a);
        if (platformActionListener != null) {
            platformActionListener = WechatMoments.d(this.a);
            WechatMoments wechatMoments = this.a;
            int n10 = 1;
            platformActionListener.onCancel(wechatMoments, n10);
        }
    }

    public void onComplete(Bundle bundle) {
        WechatMoments.a(this.a, 1, null);
    }

    public void onError(Throwable throwable) {
        PlatformActionListener platformActionListener = WechatMoments.a(this.a);
        if (platformActionListener != null) {
            platformActionListener = WechatMoments.b(this.a);
            WechatMoments wechatMoments = this.a;
            int n10 = 1;
            platformActionListener.onError(wechatMoments, n10, throwable);
        }
    }
}

