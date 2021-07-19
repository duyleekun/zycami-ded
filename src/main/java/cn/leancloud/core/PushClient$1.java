/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.core;

import cn.leancloud.core.PushClient;
import cn.leancloud.utils.ErrorUtils;
import e.a.e0;
import e.a.v0.o;
import e.a.z;

public class PushClient$1
implements o {
    public final /* synthetic */ PushClient this$0;

    public PushClient$1(PushClient pushClient) {
        this.this$0 = pushClient;
    }

    public e0 apply(Throwable throwable) {
        return z.m2(ErrorUtils.propagateException(throwable));
    }
}

