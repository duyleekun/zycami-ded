/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.text.TextUtils
 */
package cn.sharesdk.wechat.utils;

import android.os.Bundle;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.a.b;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.wechat.utils.h$1;
import cn.sharesdk.wechat.utils.h$2;
import com.mob.tools.log.NLog;
import com.mob.tools.network.KVPair;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.util.ArrayList;
import java.util.HashMap;

public class h {
    private String a;
    private String b;
    private b c;
    private Platform d;
    private int e;

    public h(Platform object, int n10) {
        this.d = object;
        this.e = n10;
        this.c = object = cn.sharesdk.framework.a.b.a();
    }

    public static /* synthetic */ Platform a(h h10) {
        return h10.d;
    }

    public static /* synthetic */ void a(h h10, String string2) {
        h10.a(string2);
    }

    private void a(String object) {
        Object object2 = SSDKLog.b();
        CharSequence charSequence = new StringBuilder();
        charSequence.append("wechat getAuthorizeToken ==>>");
        charSequence.append((String)object);
        charSequence = charSequence.toString();
        Object object3 = new Object[]{};
        ((NLog)object2).d(charSequence, object3);
        object2 = new Hashon();
        object = ((Hashon)object2).fromJson((String)object);
        object2 = String.valueOf(((HashMap)object).get("access_token"));
        charSequence = "refresh_token";
        object3 = String.valueOf(((HashMap)object).get(charSequence));
        String string2 = String.valueOf(((HashMap)object).get("expires_in"));
        String string3 = "openid";
        object = String.valueOf(((HashMap)object).get(string3));
        this.d.getDb().put(string3, (String)object);
        object = this.d.getDb();
        long l10 = Long.valueOf(string2);
        ((PlatformDb)object).putExpiresIn(l10);
        this.d.getDb().putToken((String)object2);
        this.d.getDb().put((String)charSequence, (String)object3);
    }

    private void a(String string2, AuthorizeListener authorizeListener) {
        Object object = SSDKLog.b();
        CharSequence charSequence = new StringBuilder();
        charSequence.append("getAuthorizeToken ==>> ");
        charSequence.append(string2);
        charSequence = charSequence.toString();
        Object[] objectArray = new Object[]{};
        ((NLog)object).d(charSequence, objectArray);
        object = new h$1(this, string2, authorizeListener);
        ((Thread)object).start();
    }

    public static /* synthetic */ int b(h h10) {
        return h10.e;
    }

    public static /* synthetic */ b c(h h10) {
        return h10.c;
    }

    public static /* synthetic */ String d(h h10) {
        return h10.a;
    }

    public static /* synthetic */ String e(h h10) {
        return h10.b;
    }

    public void a(Bundle object, AuthorizeListener authorizeListener) {
        Object object2 = "_wxapi_sendauth_resp_url";
        int n10 = TextUtils.isEmpty((CharSequence)(object = object.getString((String)object2)));
        if (n10 != 0) {
            if (authorizeListener != null) {
                object = null;
                authorizeListener.onError(null);
            }
            return;
        }
        object2 = "://oauth?";
        n10 = ((String)object).indexOf((String)object2);
        if (n10 >= 0) {
            object = ((String)object).substring(++n10);
        }
        object = ResHelper.urlToBundle((String)object);
        object2 = "code";
        object = object.getString((String)object2);
        try {
            this.a((String)object, authorizeListener);
            return;
        }
        catch (Throwable throwable) {
            object2 = SSDKLog.b();
            ((NLog)object2).d(throwable);
            if (authorizeListener != null) {
                authorizeListener.onError(throwable);
            }
            return;
        }
    }

    public void a(PlatformActionListener platformActionListener) {
        h$2 h$2 = new h$2(this, platformActionListener);
        h$2.start();
    }

    public void a(String string2, String string3) {
        this.a = string2;
        this.b = string3;
    }

    public boolean a() {
        Object object = this.d.getDb();
        Object object2 = "refresh_token";
        object = ((PlatformDb)object).get((String)object2);
        Object object3 = this.a;
        boolean bl2 = TextUtils.isEmpty((CharSequence)object3);
        if (!bl2 && !(bl2 = TextUtils.isEmpty((CharSequence)object))) {
            block9: {
                object3 = new Object();
                String string2 = this.a;
                String string3 = "appid";
                Object object4 = new KVPair(string3, string2);
                ((ArrayList)object3).add(object4);
                object4 = new KVPair((String)object2, object);
                ((ArrayList)object3).add(object4);
                object4 = "grant_type";
                object = new KVPair((String)object4, object2);
                ((ArrayList)object3).add(object);
                object = "https://api.weixin.qq.com/sns/oauth2/refresh_token";
                object2 = this.c;
                object4 = "/sns/oauth2/refresh_token";
                int n10 = this.e;
                object = ((b)object2).a((String)object, (ArrayList)object3, (String)object4, n10);
                boolean bl3 = TextUtils.isEmpty((CharSequence)object);
                if (bl3) {
                    return false;
                }
                object2 = "errcode";
                bl3 = ((String)object).contains((CharSequence)object2);
                if (!bl3) break block9;
                return false;
            }
            try {
                this.a((String)object);
                return true;
            }
            catch (Throwable throwable) {
                object2 = SSDKLog.b();
                ((NLog)object2).d(throwable);
            }
        }
        return false;
    }
}

