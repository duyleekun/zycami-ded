/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package cn.sharesdk.sina.weibo;

import android.os.Bundle;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.sina.weibo.i;
import com.mob.tools.utils.ResHelper;

public class SinaWeibo$1
implements AuthorizeListener {
    public final /* synthetic */ i a;
    public final /* synthetic */ SinaWeibo b;

    public SinaWeibo$1(SinaWeibo sinaWeibo, i i10) {
        this.b = sinaWeibo;
        this.a = i10;
    }

    public void onCancel() {
        PlatformActionListener platformActionListener = SinaWeibo.h(this.b);
        if (platformActionListener != null) {
            platformActionListener = SinaWeibo.i(this.b);
            SinaWeibo sinaWeibo = this.b;
            int n10 = 1;
            platformActionListener.onCancel(sinaWeibo, n10);
        }
    }

    public void onComplete(Bundle object) {
        long l10;
        String string2 = object.getString("uid");
        String string3 = object.getString("access_token");
        String string4 = object.getString("expires_in");
        String string5 = "refresh_token";
        String string6 = object.getString(string5);
        Object object2 = "username";
        boolean bl2 = object.containsKey((String)object2);
        if (bl2) {
            object2 = SinaWeibo.a(this.b);
            object = object.getString("userName");
            String string7 = "nickname";
            ((PlatformDb)object2).put(string7, (String)object);
        }
        object = SinaWeibo.b(this.b);
        ((PlatformDb)object).putToken(string3);
        try {
            l10 = ResHelper.parseLong(string4);
        }
        catch (Throwable throwable) {
            l10 = 0L;
        }
        SinaWeibo.c(this.b).putExpiresIn(l10);
        SinaWeibo.d(this.b).put(string5, string6);
        SinaWeibo.e(this.b).putUserId(string2);
        this.a.c(string3);
        SinaWeibo.a(this.b, 1, null);
    }

    public void onError(Throwable throwable) {
        PlatformActionListener platformActionListener = SinaWeibo.f(this.b);
        if (platformActionListener != null) {
            platformActionListener = SinaWeibo.g(this.b);
            SinaWeibo sinaWeibo = this.b;
            int n10 = 1;
            platformActionListener.onError(sinaWeibo, n10, throwable);
        }
    }
}

