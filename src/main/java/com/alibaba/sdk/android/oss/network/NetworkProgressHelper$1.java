/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.network;

import com.alibaba.sdk.android.oss.network.ExecutionContext;
import com.alibaba.sdk.android.oss.network.ProgressTouchableResponseBody;
import g.a0;
import g.c0;
import g.c0$a;
import g.d0;
import g.u;
import g.u$a;

public final class NetworkProgressHelper$1
implements u {
    public final /* synthetic */ ExecutionContext val$context;

    public NetworkProgressHelper$1(ExecutionContext executionContext) {
        this.val$context = executionContext;
    }

    public c0 intercept(u$a object) {
        Object object2 = object.C();
        object = object.c((a0)object2);
        object2 = ((c0)object).G0();
        object = ((c0)object).r0();
        ExecutionContext executionContext = this.val$context;
        ProgressTouchableResponseBody progressTouchableResponseBody = new ProgressTouchableResponseBody((d0)object, executionContext);
        return ((c0$a)object2).b(progressTouchableResponseBody).c();
    }
}

