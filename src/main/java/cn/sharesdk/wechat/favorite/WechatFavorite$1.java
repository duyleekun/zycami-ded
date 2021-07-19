/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package cn.sharesdk.wechat.favorite;

import android.os.Bundle;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.wechat.favorite.WechatFavorite;

public class WechatFavorite$1
implements AuthorizeListener {
    public final /* synthetic */ WechatFavorite a;

    public WechatFavorite$1(WechatFavorite wechatFavorite) {
        this.a = wechatFavorite;
    }

    public void onCancel() {
        PlatformActionListener platformActionListener = WechatFavorite.c(this.a);
        if (platformActionListener != null) {
            platformActionListener = WechatFavorite.d(this.a);
            WechatFavorite wechatFavorite = this.a;
            int n10 = 1;
            platformActionListener.onCancel(wechatFavorite, n10);
        }
    }

    public void onComplete(Bundle bundle) {
        WechatFavorite.a(this.a, 1, null);
    }

    public void onError(Throwable throwable) {
        PlatformActionListener platformActionListener = WechatFavorite.a(this.a);
        if (platformActionListener != null) {
            platformActionListener = WechatFavorite.b(this.a);
            WechatFavorite wechatFavorite = this.a;
            int n10 = 1;
            platformActionListener.onError(wechatFavorite, n10, throwable);
        }
    }
}

