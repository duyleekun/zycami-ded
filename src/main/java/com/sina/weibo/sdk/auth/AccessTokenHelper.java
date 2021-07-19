/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.sina.weibo.sdk.auth;

import android.content.Context;
import android.text.TextUtils;
import com.sina.weibo.sdk.auth.AccessTokenHelper$1;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.b.b;
import com.sina.weibo.sdk.b.b$a;
import com.sina.weibo.sdk.b.f;

public class AccessTokenHelper {
    private static final String PREFERENCES_NAME = "com_weibo_sdk_android";

    public static void clearAccessToken(Context context) {
        if (context == null) {
            return;
        }
        context = context.getSharedPreferences(PREFERENCES_NAME, 0).edit();
        context.clear();
        context.apply();
    }

    public static Oauth2AccessToken readAccessToken(Context context) {
        if (context == null) {
            return null;
        }
        Oauth2AccessToken oauth2AccessToken = new Oauth2AccessToken();
        context = context.getSharedPreferences(PREFERENCES_NAME, 0);
        String string2 = "";
        String string3 = context.getString("uid", string2);
        oauth2AccessToken.setUid(string3);
        string3 = context.getString("userName", string2);
        oauth2AccessToken.setScreenName(string3);
        string3 = context.getString("access_token", string2);
        oauth2AccessToken.setAccessToken(string3);
        string3 = context.getString("refresh_token", string2);
        oauth2AccessToken.setRefreshToken(string3);
        long l10 = context.getLong("expires_in", 0L);
        oauth2AccessToken.setExpiresTime(l10);
        return oauth2AccessToken;
    }

    public static void refreshAccessToken(Context object, String string2) {
        Oauth2AccessToken oauth2AccessToken = AccessTokenHelper.readAccessToken((Context)object);
        if (oauth2AccessToken != null) {
            AccessTokenHelper$1 accessTokenHelper$1 = new AccessTokenHelper$1((Context)object);
            f f10 = new f(string2, oauth2AccessToken, accessTokenHelper$1);
            object = b$a.n();
            ((b)object).a(f10);
        }
    }

    public static void writeAccessToken(Context context, Oauth2AccessToken object) {
        String string2;
        boolean bl2;
        if (context != null && object != null && !(bl2 = TextUtils.isEmpty((CharSequence)(string2 = ((Oauth2AccessToken)object).getAccessToken())))) {
            bl2 = false;
            context = context.getSharedPreferences(PREFERENCES_NAME, 0).edit();
            string2 = ((Oauth2AccessToken)object).getUid();
            context.putString("uid", string2);
            string2 = ((Oauth2AccessToken)object).getScreenName();
            context.putString("userName", string2);
            string2 = ((Oauth2AccessToken)object).getAccessToken();
            context.putString("access_token", string2);
            string2 = ((Oauth2AccessToken)object).getRefreshToken();
            String string3 = "refresh_token";
            context.putString(string3, string2);
            long l10 = ((Oauth2AccessToken)object).getExpiresTime();
            object = "expires_in";
            context.putLong((String)object, l10);
            context.apply();
        }
    }
}

