/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.service;

import cn.leancloud.service.RealtimeClient;
import cn.leancloud.utils.ErrorUtils;
import e.a.e0;
import e.a.v0.o;
import e.a.z;

public class RealtimeClient$2
implements o {
    public final /* synthetic */ RealtimeClient this$0;

    public RealtimeClient$2(RealtimeClient realtimeClient) {
        this.this$0 = realtimeClient;
    }

    public e0 apply(Throwable throwable) {
        return z.m2(ErrorUtils.propagateException(throwable));
    }
}

