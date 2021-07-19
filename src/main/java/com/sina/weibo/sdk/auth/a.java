/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.text.TextUtils
 */
package com.sina.weibo.sdk.auth;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.auth.AccessTokenHelper;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.auth.b;
import com.sina.weibo.sdk.c.a$a;
import com.sina.weibo.sdk.c.c;
import com.sina.weibo.sdk.c.e;
import com.sina.weibo.sdk.common.UiError;
import com.sina.weibo.sdk.net.h;
import com.sina.weibo.sdk.web.WebActivity;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public final class a {
    public WeakReference g;
    public WbAuthListener h;

    public a(Activity activity) {
        WeakReference<Activity> weakReference;
        this.g = weakReference = new WeakReference<Activity>(activity);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void d() {
        Object object = "WBSsoTag";
        Object object2 = "startClientAuth()";
        c.a((String)object, (String)object2);
        try {
            Object object3;
            object2 = this.g;
            object2 = ((Reference)object2).get();
            object2 = (Context)object2;
            Object object4 = com.sina.weibo.sdk.c.a.c((Context)object2);
            Intent intent = new Intent();
            if (object4 == null) {
                object4 = "com.sina.weibo";
                object3 = "com.sina.weibo.SSOActivity";
                intent.setClassName((String)object4, (String)object3);
            } else {
                object3 = ((a$a)object4).packageName;
                object4 = ((a$a)object4).al;
                intent.setClassName((String)object3, (String)object4);
            }
            object4 = com.sina.weibo.sdk.a.a();
            object3 = "appKey";
            CharSequence charSequence = ((AuthInfo)object4).getAppKey();
            intent.putExtra((String)object3, (String)charSequence);
            object3 = "redirectUri";
            charSequence = ((AuthInfo)object4).getRedirectUrl();
            intent.putExtra((String)object3, (String)charSequence);
            object3 = "scope";
            charSequence = ((AuthInfo)object4).getScope();
            intent.putExtra((String)object3, (String)charSequence);
            object3 = "packagename";
            charSequence = ((AuthInfo)object4).getPackageName();
            intent.putExtra((String)object3, (String)charSequence);
            object3 = "key_hash";
            charSequence = ((AuthInfo)object4).getHash();
            intent.putExtra((String)object3, (String)charSequence);
            object3 = "_weibo_command_type";
            int n10 = 3;
            intent.putExtra((String)object3, n10);
            object3 = "_weibo_transaction";
            charSequence = new StringBuilder();
            long l10 = System.currentTimeMillis();
            ((StringBuilder)charSequence).append(l10);
            charSequence = ((StringBuilder)charSequence).toString();
            intent.putExtra((String)object3, (String)charSequence);
            object3 = this.g;
            object3 = ((Reference)object3).get();
            object3 = (Activity)object3;
            charSequence = "";
            if (object3 == null) {
                object2 = this.h;
                int n11 = -1;
                object3 = "activity is null";
                object4 = new UiError(n11, (String)object3, (String)charSequence);
                object2.onError((UiError)object4);
                return;
            }
            int n12 = com.sina.weibo.sdk.c.a.a((Context)object2, intent);
            if (n12 != 0) {
                object2 = "aid";
                object4 = ((AuthInfo)object4).getAppKey();
                object4 = e.f((Context)object3, (String)object4);
                intent.putExtra((String)object2, (String)object4);
                n12 = 32973;
                object3.startActivityForResult(intent, n12);
                object2 = "start SsoActivity ";
                c.a((String)object, (String)object2);
                return;
            }
            object2 = this.h;
            int n13 = -2;
            object3 = "your app is illegal";
            object4 = new UiError(n13, (String)object3, (String)charSequence);
            object2.onError((UiError)object4);
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            Object object5 = exception.getMessage();
            c.b((String)object, (String)object5);
            object = this.h;
            String string2 = exception.getMessage();
            object5 = new UiError(-3, "occur exception", string2);
            object.onError((UiError)object5);
            return;
        }
    }

    public final void e() {
        Activity activity = (Activity)this.g.get();
        Object object = new h();
        AuthInfo authInfo = com.sina.weibo.sdk.a.a();
        if (authInfo == null) {
            return;
        }
        Object object2 = authInfo.getAppKey();
        ((h)object).put("client_id", (String)object2);
        object2 = authInfo.getRedirectUrl();
        ((h)object).put("redirect_uri", (String)object2);
        object2 = authInfo.getScope();
        ((h)object).put("scope", (String)object2);
        object2 = authInfo.getPackageName();
        ((h)object).put("packagename", (String)object2);
        object2 = authInfo.getHash();
        ((h)object).put("key_hash", (String)object2);
        ((h)object).put("response_type", "code");
        ((h)object).put("version", "0041005000");
        ((h)object).put("luicode", "10000360");
        object2 = new StringBuilder("OP_");
        CharSequence charSequence = authInfo.getAppKey();
        ((StringBuilder)object2).append((String)charSequence);
        object2 = ((StringBuilder)object2).toString();
        charSequence = "lfid";
        ((h)object).put((String)charSequence, (String)object2);
        object2 = AccessTokenHelper.readAccessToken((Context)activity);
        if (object2 != null) {
            charSequence = ((Oauth2AccessToken)object2).getAccessToken();
            boolean bl2 = TextUtils.isEmpty((CharSequence)(object2 = ((Oauth2AccessToken)object2).getAccessToken()));
            if (!bl2) {
                ((h)object).put("trans_token", (String)charSequence);
                object2 = "trans_access_token";
                ((h)object).put((String)object2, (String)charSequence);
            }
        }
        object2 = authInfo.getAppKey();
        boolean bl3 = TextUtils.isEmpty((CharSequence)(object2 = e.f((Context)activity, (String)object2)));
        if (!bl3) {
            charSequence = "aid";
            ((h)object).put((String)charSequence, (String)object2);
        }
        charSequence = "https://open.weibo.cn/oauth2/authorize?";
        object2 = new StringBuilder((String)charSequence);
        object = ((h)object).k();
        ((StringBuilder)object2).append((String)object);
        object = ((StringBuilder)object2).toString();
        object2 = this.h;
        if (object2 != null) {
            object2 = b.f();
            charSequence = new StringBuilder();
            long l10 = System.currentTimeMillis();
            ((StringBuilder)charSequence).append(l10);
            charSequence = ((StringBuilder)charSequence).toString();
            Object object3 = this.h;
            ((b)object2).a((String)charSequence, (WbAuthListener)object3);
            object2 = new Intent((Context)activity, WebActivity.class);
            object3 = new com.sina.weibo.sdk.web.b.a(authInfo, (String)object, (String)charSequence);
            object = new Bundle();
            ((com.sina.weibo.sdk.web.b.b)object3).writeToBundle((Bundle)object);
            object2.putExtras((Bundle)object);
            activity.startActivity((Intent)object2);
        }
    }
}

