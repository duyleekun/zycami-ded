/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.text.TextUtils
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.sina.weibo.sdk.auth;

import android.os.Bundle;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class Oauth2AccessToken {
    public static final String KEY_ACCESS_TOKEN = "access_token";
    public static final String KEY_EXPIRES_IN = "expires_in";
    public static final String KEY_REFRESH_TOKEN = "refresh_token";
    public static final String KEY_SCREEN_NAME = "userName";
    public static final String KEY_UID = "uid";
    private String mAccessToken;
    private long mExpiresTime;
    private String mRefreshToken;
    private String mScreenName;
    private String mUid;

    public static Oauth2AccessToken parseAccessToken(Bundle bundle) {
        if (bundle != null) {
            Oauth2AccessToken oauth2AccessToken = new Oauth2AccessToken();
            String string2 = bundle.getString(KEY_UID);
            oauth2AccessToken.setUid(string2);
            string2 = bundle.getString(KEY_SCREEN_NAME);
            oauth2AccessToken.setScreenName(string2);
            string2 = bundle.getString(KEY_ACCESS_TOKEN);
            oauth2AccessToken.setAccessToken(string2);
            string2 = bundle.getString(KEY_REFRESH_TOKEN);
            oauth2AccessToken.setRefreshToken(string2);
            long l10 = Long.parseLong(bundle.getString(KEY_EXPIRES_IN)) * 1000L;
            oauth2AccessToken.setExpiresTime(l10);
            return oauth2AccessToken;
        }
        return null;
    }

    public static Oauth2AccessToken parseAccessToken(String object) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            Object object2 = new JSONObject((String)object);
            object = new Oauth2AccessToken();
            String string2 = KEY_UID;
            string2 = object2.optString(string2);
            ((Oauth2AccessToken)object).setUid(string2);
            string2 = KEY_SCREEN_NAME;
            string2 = object2.optString(string2);
            ((Oauth2AccessToken)object).setScreenName(string2);
            string2 = KEY_ACCESS_TOKEN;
            string2 = object2.optString(string2);
            ((Oauth2AccessToken)object).setAccessToken(string2);
            string2 = KEY_EXPIRES_IN;
            string2 = object2.getString(string2);
            long l10 = Long.parseLong(string2);
            long l11 = 1000L;
            l10 *= l11;
            ((Oauth2AccessToken)object).setExpiresTime(l10);
            string2 = KEY_REFRESH_TOKEN;
            object2 = object2.optString(string2);
            try {
                ((Oauth2AccessToken)object).setRefreshToken((String)object2);
                return object;
            }
            catch (JSONException jSONException) {
                jSONException.printStackTrace();
            }
        }
        return null;
    }

    public String getAccessToken() {
        return this.mAccessToken;
    }

    public long getExpiresTime() {
        return this.mExpiresTime;
    }

    public String getRefreshToken() {
        return this.mRefreshToken;
    }

    public String getScreenName() {
        return this.mScreenName;
    }

    public String getUid() {
        return this.mUid;
    }

    public boolean isSessionValid() {
        long l10;
        long l11;
        long l12;
        String string2 = this.mAccessToken;
        int n10 = TextUtils.isEmpty((CharSequence)string2);
        return n10 == 0 && (n10 = (l12 = (l11 = this.mExpiresTime) - (l10 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0;
    }

    public void setAccessToken(String string2) {
        this.mAccessToken = string2;
    }

    public void setExpiresTime(long l10) {
        this.mExpiresTime = l10;
    }

    public void setRefreshToken(String string2) {
        this.mRefreshToken = string2;
    }

    public void setScreenName(String string2) {
        this.mScreenName = string2;
    }

    public void setUid(String string2) {
        this.mUid = string2;
    }
}

