/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package cn.sharesdk.wechat.utils;

import android.os.Bundle;
import cn.sharesdk.wechat.utils.WechatResp;

public class b
extends WechatResp {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public boolean f = false;

    public b(Bundle bundle) {
        super(bundle);
    }

    public int a() {
        return 1;
    }

    public void a(Bundle bundle) {
        boolean bl2;
        String string2;
        super.a(bundle);
        this.a = string2 = bundle.getString("_wxapi_sendauth_resp_token");
        this.b = string2 = bundle.getString("_wxapi_sendauth_resp_state");
        this.c = string2 = bundle.getString("_wxapi_sendauth_resp_url");
        this.d = string2 = bundle.getString("_wxapi_sendauth_resp_lang");
        this.e = string2 = bundle.getString("_wxapi_sendauth_resp_country");
        this.f = bl2 = bundle.getBoolean("_wxapi_sendauth_resp_auth_result");
    }

    public void b(Bundle bundle) {
        super.b(bundle);
        String string2 = this.a;
        bundle.putString("_wxapi_sendauth_resp_token", string2);
        string2 = this.b;
        bundle.putString("_wxapi_sendauth_resp_state", string2);
        string2 = this.c;
        bundle.putString("_wxapi_sendauth_resp_url", string2);
        string2 = this.d;
        bundle.putString("_wxapi_sendauth_resp_lang", string2);
        string2 = this.e;
        bundle.putString("_wxapi_sendauth_resp_country", string2);
        boolean bl2 = this.f;
        bundle.putBoolean("_wxapi_sendauth_resp_auth_result", bl2);
    }
}

