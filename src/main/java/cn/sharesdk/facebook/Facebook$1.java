/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.text.TextUtils
 */
package cn.sharesdk.facebook;

import android.os.Bundle;
import android.text.TextUtils;
import cn.sharesdk.facebook.Facebook;
import cn.sharesdk.facebook.h;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.ResHelper;

public class Facebook$1
implements AuthorizeListener {
    public final /* synthetic */ h a;
    public final /* synthetic */ Facebook b;

    public Facebook$1(Facebook facebook, h h10) {
        this.b = facebook;
        this.a = h10;
    }

    public void onCancel() {
        PlatformActionListener platformActionListener = Facebook.e(this.b);
        if (platformActionListener != null) {
            platformActionListener = Facebook.f(this.b);
            Facebook facebook = this.b;
            int n10 = 1;
            platformActionListener.onCancel(facebook, n10);
        }
        SSDKLog.b().w("Facebook doAuthorize by origianl onCancel ");
    }

    public void onComplete(Bundle object) {
        boolean bl2;
        SSDKLog.b().w("Facebook doAuthorize by origianl onComplete ");
        String string2 = object.getString("oauth_token");
        String string3 = "oauth_token_expires";
        int n10 = object.getInt(string3);
        if (n10 == 0) {
            string3 = String.valueOf(object.get("expires_in"));
            try {
                n10 = ResHelper.parseInt(string3);
            }
            catch (Throwable throwable) {
                NLog nLog = SSDKLog.b();
                nLog.d(throwable);
                n10 = 0;
                string3 = null;
            }
        }
        if (bl2 = TextUtils.isEmpty((CharSequence)string2)) {
            string2 = object.getString("access_token");
        }
        Facebook.c(this.b).putToken(string2);
        object = Facebook.d(this.b);
        long l10 = n10;
        ((PlatformDb)object).putExpiresIn(l10);
        object = this.a;
        string3 = String.valueOf(n10);
        ((h)object).a(string2, string3);
        Facebook.a(this.b, 1, null);
    }

    public void onError(Throwable object) {
        Object object2;
        Object object3 = Facebook.a(this.b);
        if (object3 != null) {
            object3 = Facebook.b(this.b);
            object2 = this.b;
            int n10 = 1;
            object3.onError((Platform)object2, n10, (Throwable)object);
        }
        object3 = SSDKLog.b();
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Facebook doAuthorize by origianl onError ");
        ((StringBuilder)object2).append(object);
        object = ((StringBuilder)object2).toString();
        ((NLog)object3).w((String)object);
    }
}

