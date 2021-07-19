/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.json.JSONObject
 */
package com.weibo.ssosdk;

import org.json.JSONObject;

public final class WeiboSsoSdk$h {
    private String a;
    private String b;

    public WeiboSsoSdk$h() {
        String string2;
        this.a = string2 = "";
        this.b = string2;
    }

    public static WeiboSsoSdk$h d(String string2) {
        String string3;
        CharSequence charSequence;
        JSONObject jSONObject;
        Object object;
        String string4;
        block18: {
            string4 = "";
            object = new WeiboSsoSdk$h();
            jSONObject = new JSONObject(string2);
            string2 = "retcode";
            string2 = jSONObject.optString(string2, string4);
            charSequence = "data";
            charSequence = jSONObject.getJSONObject((String)charSequence);
            string3 = "20000000";
            boolean bl2 = string2.equals(string3);
            if (!bl2 || charSequence == null) break block18;
            string2 = "aid";
            string2 = charSequence.optString(string2, string4);
            ((WeiboSsoSdk$h)object).a = string2;
            string2 = "sub";
            string2 = charSequence.optString(string2, string4);
            ((WeiboSsoSdk$h)object).b = string2;
            return object;
        }
        string3 = "error\uff1a ";
        charSequence = new StringBuilder(string3);
        ((StringBuilder)charSequence).append(string2);
        string2 = " msg:";
        ((StringBuilder)charSequence).append(string2);
        string2 = "msg";
        string2 = jSONObject.optString(string2, string4);
        ((StringBuilder)charSequence).append(string2);
        string2 = ((StringBuilder)charSequence).toString();
        object = new Exception(string2);
        throw object;
    }

    public final WeiboSsoSdk$h a() {
        String string2;
        WeiboSsoSdk$h weiboSsoSdk$h = new WeiboSsoSdk$h();
        weiboSsoSdk$h.a = string2 = this.a;
        weiboSsoSdk$h.b = string2 = this.b;
        return weiboSsoSdk$h;
    }

    public final String b() {
        return this.a;
    }

    public final String c() {
        return this.b;
    }
}

