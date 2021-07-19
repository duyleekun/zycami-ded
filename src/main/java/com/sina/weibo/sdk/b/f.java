/*
 * Decompiled with CFR 0.151.
 */
package com.sina.weibo.sdk.b;

import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.b.c;
import com.sina.weibo.sdk.net.b;
import com.sina.weibo.sdk.net.d;
import com.sina.weibo.sdk.net.e$a;

public final class f
extends c {
    private com.sina.weibo.sdk.net.c ag;
    private Throwable ah;
    private Oauth2AccessToken ak;
    private String appKey;

    public f(String string2, Oauth2AccessToken oauth2AccessToken, com.sina.weibo.sdk.net.c c10) {
        this.appKey = string2;
        this.ak = oauth2AccessToken;
        this.ag = c10;
    }

    private String q() {
        Object object = "refresh_token";
        Object object2 = new e$a();
        Object object3 = "https://api.weibo.com/oauth2/access_token";
        ((e$a)object2).url = object3;
        object3 = "client_id";
        String string2 = this.appKey;
        object2 = ((e$a)object2).b((String)object3, string2);
        object3 = "appKey";
        string2 = this.appKey;
        object2 = ((e$a)object2).b((String)object3, string2);
        object3 = "grant_type";
        object2 = ((e$a)object2).b((String)object3, object);
        object3 = this.ak;
        object3 = ((Oauth2AccessToken)object3).getRefreshToken();
        object = ((e$a)object2).b((String)object, object3);
        object = ((e$a)object).i();
        object2 = new b();
        object = object2.a((d)object);
        try {
            object = object.j();
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
            this.ah = throwable;
            object = null;
        }
        return object;
    }

    public final /* synthetic */ Object o() {
        return this.q();
    }

    public final /* synthetic */ void onPostExecute(Object object) {
        object = (String)object;
        Object object2 = this.ah;
        if (object2 != null) {
            object = this.ag;
            if (object != null) {
                object.onError((Throwable)object2);
            }
            return;
        }
        object2 = this.ag;
        if (object2 != null) {
            object2.a(object);
        }
    }
}

