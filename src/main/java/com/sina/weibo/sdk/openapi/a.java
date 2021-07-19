/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.text.TextUtils
 */
package com.sina.weibo.sdk.openapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.sina.weibo.sdk.api.StoryMessage;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.auth.AccessTokenHelper;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.c.a$a;
import com.sina.weibo.sdk.c.b;
import com.sina.weibo.sdk.c.c;
import com.sina.weibo.sdk.common.UiError;
import com.sina.weibo.sdk.openapi.IWBAPI;
import com.sina.weibo.sdk.share.ShareStoryActivity;
import com.sina.weibo.sdk.share.ShareTransActivity;
import com.sina.weibo.sdk.share.WbShareCallback;
import com.sina.weibo.sdk.share.f;
import com.sina.weibo.sdk.web.b.d;

public final class a
implements IWBAPI {
    private Context mContext;
    private com.sina.weibo.sdk.auth.a s;
    private f t;

    public a(Context object) {
        com.sina.weibo.sdk.auth.a a10;
        this.mContext = object;
        object = (Activity)object;
        this.s = a10 = new com.sina.weibo.sdk.auth.a((Activity)object);
        a10 = (Activity)this.mContext;
        super((Activity)a10);
        this.t = object;
    }

    public final void authorize(WbAuthListener object) {
        com.sina.weibo.sdk.auth.a a10 = this.s;
        String string2 = "WBSsoTag";
        String string3 = "authorize()";
        c.a(string2, string3);
        if (object != null) {
            a10.h = object;
            object = (Context)a10.g.get();
            boolean bl2 = com.sina.weibo.sdk.a.a((Context)object);
            if (bl2) {
                boolean bl3;
                if ((object = com.sina.weibo.sdk.c.a.c((Context)object)) != null) {
                    bl3 = true;
                } else {
                    bl3 = false;
                    object = null;
                }
                if (bl3) {
                    a10.d();
                    return;
                }
            }
            a10.e();
            return;
        }
        object = new RuntimeException("listener can not be null.");
        throw object;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final void authorizeCallback(int n10, int n11, Intent object) {
        Object object2 = this.s;
        String string2 = "authorizeCallback()";
        c.a("WBSsoTag", string2);
        Object object3 = ((com.sina.weibo.sdk.auth.a)object2).h;
        if (object3 == null) return;
        int n12 = 32973;
        if (n12 == n10) {
            n10 = -1;
            if (n11 == n10) {
                if (object == null) return;
                Object object4 = object.getStringExtra("error");
                Object object5 = object.getStringExtra("error_type");
                object3 = object.getStringExtra("error_description");
                n12 = (int)(TextUtils.isEmpty((CharSequence)object4) ? 1 : 0);
                if (n12 != 0 && (n12 = (int)(TextUtils.isEmpty((CharSequence)object5) ? 1 : 0)) != 0 && (n12 = (int)(TextUtils.isEmpty((CharSequence)object3) ? 1 : 0)) != 0) {
                    object4 = Oauth2AccessToken.parseAccessToken(object.getExtras());
                    if (object4 != null) {
                        AccessTokenHelper.writeAccessToken((Context)((Activity)((com.sina.weibo.sdk.auth.a)object2).g.get()), (Oauth2AccessToken)object4);
                        ((com.sina.weibo.sdk.auth.a)object2).h.onComplete((Oauth2AccessToken)object4);
                        return;
                    }
                    object4 = ((com.sina.weibo.sdk.auth.a)object2).h;
                    object2 = "oauth2AccessToken is null";
                    object5 = new UiError(-4, (String)object2, (String)object2);
                    object4.onError((UiError)object5);
                    return;
                }
                object = "access_denied";
                boolean bl2 = ((String)object).equals(object4);
                if (!bl2 && (n10 = (int)(((String)(object = "OAuthAccessDeniedException")).equals(object4) ? 1 : 0)) == 0) {
                    object4 = ((com.sina.weibo.sdk.auth.a)object2).h;
                    object = new UiError(-5, (String)object5, (String)object3);
                    object4.onError((UiError)object);
                    return;
                }
                ((com.sina.weibo.sdk.auth.a)object2).h.onCancel();
                return;
            }
            if (n11 == 0) {
                object3.onCancel();
                return;
            }
            object = "result code is error";
            UiError uiError = new UiError(-6, (String)object, (String)object);
            object3.onError(uiError);
            return;
        }
        n11 = -7;
        object = "request code is error";
        object2 = "requestCode is error";
        UiError uiError = new UiError(n11, (String)object, (String)object2);
        object3.onError(uiError);
    }

    public final void authorizeClient(WbAuthListener object) {
        com.sina.weibo.sdk.auth.a a10 = this.s;
        String string2 = "WBSsoTag";
        String string3 = "authorizeClient()";
        c.a(string2, string3);
        if (object != null) {
            a10.h = object;
            a10.d();
            return;
        }
        object = new RuntimeException("listener can not be null.");
        throw object;
    }

    public final void authorizeWeb(WbAuthListener object) {
        com.sina.weibo.sdk.auth.a a10 = this.s;
        String string2 = "WBSsoTag";
        String string3 = "authorizeWeb()";
        c.a(string2, string3);
        if (object != null) {
            a10.h = object;
            a10.e();
            return;
        }
        object = new RuntimeException("listener can not be null.");
        throw object;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void doResultIntent(Intent object, WbShareCallback wbShareCallback) {
        void var2_6;
        if (object == null) return;
        if (var2_6 == null) return;
        Bundle bundle = object.getExtras();
        if (bundle == null) return;
        int n10 = -1;
        Object object2 = "_weibo_resp_errcode";
        try {
            int n11 = bundle.getInt((String)object2, n10);
            if (n11 == 0) {
                var2_6.onComplete();
                return;
            }
            int n12 = 1;
            if (n11 == n12) {
                var2_6.onCancel();
                return;
            }
            n12 = 2;
            if (n11 != n12) {
                return;
            }
            String string2 = "_weibo_resp_errstr";
            String string3 = bundle.getString(string2);
            string2 = "error from weibo client!";
            UiError uiError = new UiError(n11, string3, string2);
            var2_6.onError(uiError);
            return;
        }
        catch (Exception exception) {
            String string4 = exception.getMessage();
            String string5 = exception.getMessage();
            object2 = new UiError(n10, string4, string5);
            var2_6.onError((UiError)object2);
        }
    }

    public final boolean isWBAppInstalled() {
        return com.sina.weibo.sdk.a.a(this.mContext);
    }

    public final boolean isWBAppSupportMultipleImage() {
        return com.sina.weibo.sdk.a.b(this.mContext);
    }

    public final void registerApp(Context context, AuthInfo authInfo) {
        com.sina.weibo.sdk.a.a(context, authInfo);
    }

    public final void setLoggerEnable(boolean bl2) {
        c.setLoggerEnable(bl2);
    }

    public final void shareMessage(WeiboMultiMessage object, boolean n10) {
        boolean bl2;
        Object object2 = this.t;
        Object object3 = (Context)((f)object2).g.get();
        if (object3 != null && ((bl2 = com.sina.weibo.sdk.a.a((Context)object3)) || n10 == 0)) {
            if (n10 != 0) {
                ((f)object2).b((WeiboMultiMessage)object);
                return;
            }
            a$a a$a = com.sina.weibo.sdk.c.a.c((Context)object3);
            bl2 = com.sina.weibo.sdk.a.a((Context)object3);
            if (bl2 && a$a != null) {
                int n11;
                a$a = com.sina.weibo.sdk.c.a.c((Context)object3);
                if (a$a != null && (n10 = a$a.am) > (n11 = 10000)) {
                    n10 = 1;
                } else {
                    n10 = 0;
                    a$a = null;
                }
                if (n10 != 0) {
                    ((f)object2).b((WeiboMultiMessage)object);
                    return;
                }
            }
            if ((a$a = (Activity)((f)object2).g.get()) != null && (object2 = com.sina.weibo.sdk.a.a()) != null) {
                int n12;
                object3 = new d((AuthInfo)object2);
                ((com.sina.weibo.sdk.web.b.b)object3).setContext((Context)a$a);
                ((d)object3).aJ = object;
                ((d)object3).packageName = object = a$a.getPackageName();
                object = AccessTokenHelper.readAccessToken((Context)a$a);
                if (object != null) {
                    object2 = ((Oauth2AccessToken)object).getAccessToken();
                    n12 = TextUtils.isEmpty((CharSequence)(object = ((Oauth2AccessToken)object).getAccessToken()));
                    if (n12 == 0) {
                        ((d)object3).aj = object2;
                    }
                }
                object = new Bundle();
                ((com.sina.weibo.sdk.web.b.b)object3).writeToBundle((Bundle)object);
                object2 = new Intent((Context)a$a, ShareTransActivity.class);
                object2.putExtra("start_flag", 0);
                object3 = "start_web_activity";
                String string2 = "com.sina.weibo.sdk.web.WebActivity";
                object2.putExtra((String)object3, string2);
                object2.putExtras((Bundle)object);
                n12 = 10001;
                a$a.startActivityForResult((Intent)object2, n12);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void shareStory(StoryMessage clazz) {
        block8: {
            Exception exception2;
            block7: {
                Object object;
                block9: {
                    Object object2;
                    Uri uri;
                    block6: {
                        boolean bl2;
                        object = (Activity)this.t.g.get();
                        if (object == null) break block8;
                        uri = ((StoryMessage)((Object)clazz)).getImageUri();
                        object2 = ((StoryMessage)((Object)clazz)).getVideoUri();
                        if (uri != null) {
                            try {
                                bl2 = b.a((Context)object, uri);
                                if (bl2) break block6;
                            }
                            catch (Exception exception2) {
                                break block7;
                            }
                        }
                        if (object2 == null || !(bl2 = b.b((Context)object, object2))) break block9;
                    }
                    uri = new Intent();
                    object2 = "_weibo_message_stroy";
                    uri.putExtra((String)object2, (Parcelable)clazz);
                    clazz = "start_flag";
                    object2 = null;
                    uri.putExtra((String)((Object)clazz), 0);
                    clazz = ShareStoryActivity.class;
                    uri.setClass((Context)object, clazz);
                    int n10 = 10001;
                    object.startActivityForResult((Intent)uri, n10);
                    return;
                }
                object = "File only can be Image or Video. ";
                clazz = new Class<ShareStoryActivity>((String)object);
                throw clazz;
            }
            exception2.printStackTrace();
        }
    }
}

