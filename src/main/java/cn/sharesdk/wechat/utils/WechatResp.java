/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package cn.sharesdk.wechat.utils;

import android.os.Bundle;

public abstract class WechatResp {
    public int g;
    public String h;
    public String i;
    public String j;

    public WechatResp(Bundle bundle) {
        this.a(bundle);
    }

    public abstract int a();

    public void a(Bundle object) {
        String string2;
        int n10;
        this.g = n10 = object.getInt("_wxapi_baseresp_errcode");
        this.h = string2 = object.getString("_wxapi_baseresp_errstr");
        this.i = string2 = object.getString("_wxapi_baseresp_transaction");
        object = object.getString("_wxapi_baseresp_openId");
        this.j = object;
    }

    public void b(Bundle bundle) {
        int n10 = this.a();
        bundle.putInt("_wxapi_command_type", n10);
        n10 = this.g;
        bundle.putInt("_wxapi_baseresp_errcode", n10);
        String string2 = this.h;
        bundle.putString("_wxapi_baseresp_errstr", string2);
        string2 = this.i;
        bundle.putString("_wxapi_baseresp_transaction", string2);
        string2 = this.j;
        bundle.putString("_wxapi_baseresp_openId", string2);
    }
}

