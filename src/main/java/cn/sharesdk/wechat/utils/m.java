/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package cn.sharesdk.wechat.utils;

import android.os.Bundle;

public abstract class m {
    public String e;
    public String f;

    public abstract int a();

    public void a(Bundle bundle) {
        int n10 = this.a();
        bundle.putInt("_wxapi_command_type", n10);
        String string2 = this.e;
        bundle.putString("_wxapi_basereq_transaction", string2);
        string2 = this.f;
        bundle.putString("_wxapi_basereq_openid", string2);
    }

    public abstract boolean a(boolean var1);
}

