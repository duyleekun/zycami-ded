/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.main.me;

import com.zhiyun.account.data.database.model.UserInfo;
import com.zhiyun.cama.main.me.WebViewFragment;
import com.zhiyun.cama.main.me.WebViewFragment$b;
import com.zhiyun.net.BaseEntity;
import com.zhiyun.net.Punish;
import d.v.a.f.b.a;

public class WebViewFragment$b$a
extends a {
    public final /* synthetic */ UserInfo a;
    public final /* synthetic */ WebViewFragment$b b;

    public WebViewFragment$b$a(WebViewFragment$b webViewFragment$b, UserInfo userInfo) {
        this.b = webViewFragment$b;
        this.a = userInfo;
    }

    public void onError(Throwable object, int n10, String string2) {
        object = this.b.a;
        Punish punish = this.a.punish;
        WebViewFragment.N((WebViewFragment)object, punish);
    }

    public void onSuccess(UserInfo object) {
        object = ((BaseEntity)object).punish;
        WebViewFragment.N(this.b.a, (Punish)object);
    }
}

