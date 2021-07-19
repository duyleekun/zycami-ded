/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.sina.weibo.sdk.auth;

import android.content.Context;
import com.sina.weibo.sdk.auth.AccessTokenHelper;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.net.c;

public final class AccessTokenHelper$1
implements c {
    public final /* synthetic */ Context f;

    public AccessTokenHelper$1(Context context) {
        this.f = context;
    }

    public final /* synthetic */ void a(Object object) {
        object = Oauth2AccessToken.parseAccessToken((String)object);
        AccessTokenHelper.writeAccessToken(this.f, (Oauth2AccessToken)object);
    }

    public final void onError(Throwable throwable) {
    }
}

