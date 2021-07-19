/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.sina.weibo.sdk.web.b;

import android.text.TextUtils;
import com.sina.weibo.sdk.c.c;
import com.sina.weibo.sdk.web.b.b$a;
import com.sina.weibo.sdk.web.b.d;
import org.json.JSONException;
import org.json.JSONObject;

public final class d$1
implements com.sina.weibo.sdk.net.c {
    public final /* synthetic */ b$a aM;
    public final /* synthetic */ d aN;

    public d$1(d d10, b$a b$a) {
        this.aN = d10;
        this.aM = b$a;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final /* synthetic */ void a(Object object) {
        object = (String)object;
        StringBuilder stringBuilder = new StringBuilder("handle image result :");
        stringBuilder.append((String)object);
        String string2 = stringBuilder.toString();
        String string3 = "WbShareTag";
        c.a(string3, string2);
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            try {
                JSONObject jSONObject = new JSONObject((String)object);
                object = "code";
                int n10 = jSONObject.optInt((String)object);
                string3 = "data";
                String string4 = jSONObject.optString(string3);
                int n11 = 1;
                if (n10 == n11 && (n10 = (int)(TextUtils.isEmpty((CharSequence)string4) ? 1 : 0)) == 0) {
                    object = this.aN;
                    ((d)object).aL = string4;
                    object = this.aM;
                    if (object == null) return;
                    object.onComplete();
                    return;
                } else {
                    object = this.aM;
                    if (object == null) return;
                    String string5 = "\u56fe\u7247\u5185\u5bb9\u4e0d\u5408\u9002\uff0c\u7981\u6b62\u4e0a\u4f20\uff01";
                    object.onError(string5);
                }
                return;
            }
            catch (JSONException jSONException) {
                jSONException.printStackTrace();
                object = this.aM;
                if (object == null) return;
                String string6 = "\u89e3\u6790\u670d\u52a1\u7aef\u8fd4\u56de\u7684\u5b57\u7b26\u4e32\u65f6\u53d1\u751f\u5f02\u5e38\uff01";
                object.onError(string6);
                return;
            }
        }
        object = this.aM;
        if (object == null) return;
        String string7 = "\u5904\u7406\u56fe\u7247\uff0c\u670d\u52a1\u7aef\u8fd4\u56denull!";
        object.onError(string7);
    }

    public final void onError(Throwable object) {
        b$a b$a = this.aM;
        if (b$a != null) {
            object = ((Throwable)object).getMessage();
            b$a.onError((String)object);
        }
    }
}

