/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  com.facebook.FacebookCallback
 *  com.facebook.FacebookException
 *  com.facebook.login.LoginResult
 */
package cn.sharesdk.facebook;

import cn.sharesdk.facebook.b;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.utils.SSDKLog;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;

public class b$1
implements FacebookCallback {
    public final /* synthetic */ b a;

    public b$1(b b10) {
        this.a = b10;
    }

    public void a(LoginResult object) {
        Object object2 = String.valueOf(object.getAccessToken().getToken());
        String string2 = String.valueOf(object.getAccessToken().getExpires());
        String string3 = String.valueOf(object.getAccessToken().getUserId());
        String string4 = String.valueOf(object.getAccessToken().getGraphDomain());
        String string5 = String.valueOf(object.getAccessToken().getPermissions());
        object = String.valueOf(object.getAccessToken().getApplicationId());
        Object object3 = b.a(this.a).getDb();
        if (object3 != null) {
            b.a(this.a).getDb().putToken((String)object2);
            object2 = b.a(this.a).getDb();
            object3 = "expires";
            ((PlatformDb)object2).put((String)object3, string2);
            b.a(this.a).getDb().putUserId(string3);
            b.a(this.a).getDb().put("GraphDomain", string4);
            b.a(this.a).getDb().put("Permissions", string5);
            object2 = b.a(this.a).getDb();
            string2 = "ApplicationId";
            ((PlatformDb)object2).put(string2, (String)object);
        }
        if ((object = b.b(this.a)) != null) {
            object = b.b(this.a);
            object2 = b.a(this.a);
            int n10 = 1;
            string3 = null;
            object.onComplete((Platform)object2, n10, null);
        }
        SSDKLog.b().w("FacebookOfficialAuth onSuccess finish");
        this.a.finish();
    }

    public void onCancel() {
        PlatformActionListener platformActionListener = b.b(this.a);
        if (platformActionListener != null) {
            platformActionListener = b.b(this.a);
            Platform platform = b.a(this.a);
            int n10 = 1;
            platformActionListener.onCancel(platform, n10);
        }
        SSDKLog.b().w("FacebookOfficialAuth onCancel finish");
        this.a.finish();
    }

    public void onError(FacebookException facebookException) {
        PlatformActionListener platformActionListener = b.b(this.a);
        if (platformActionListener != null) {
            platformActionListener = b.b(this.a);
            Platform platform = b.a(this.a);
            int n10 = 1;
            platformActionListener.onError(platform, n10, (Throwable)facebookException);
        }
        SSDKLog.b().w("FacebookOfficialAuth onError finish");
        this.a.finish();
    }

    public /* synthetic */ void onSuccess(Object object) {
        object = (LoginResult)object;
        this.a((LoginResult)object);
    }
}

