/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package cn.sharesdk.wechat.utils;

import android.os.Bundle;
import cn.sharesdk.wechat.utils.WXMediaMessage;
import cn.sharesdk.wechat.utils.WXMediaMessage$a;
import cn.sharesdk.wechat.utils.WechatResp;

public class f
extends WechatResp {
    public WXMediaMessage a;

    public f(Bundle bundle) {
        super(bundle);
    }

    public int a() {
        return 4;
    }

    public void a(Bundle object) {
        super.a((Bundle)object);
        object = WXMediaMessage$a.a(object);
        this.a = object;
    }

    public void b(Bundle bundle) {
        super.b(bundle);
        Bundle bundle2 = WXMediaMessage$a.a(this.a);
        bundle.putAll(bundle2);
    }
}

