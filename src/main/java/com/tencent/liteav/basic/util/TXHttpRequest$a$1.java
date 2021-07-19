/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.basic.util;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXHttpRequest;
import com.tencent.liteav.basic.util.TXHttpRequest$a;
import com.tencent.liteav.basic.util.TXHttpRequest$b;

public class TXHttpRequest$a$1
implements Runnable {
    public final /* synthetic */ TXHttpRequest$b a;
    public final /* synthetic */ TXHttpRequest b;
    public final /* synthetic */ TXHttpRequest.a c;

    public TXHttpRequest$a$1(TXHttpRequest.a a10, TXHttpRequest$b b10, TXHttpRequest tXHttpRequest) {
        this.c = a10;
        this.a = b10;
        this.b = tXHttpRequest;
    }

    public void run() {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("TXPostRequest->recvMsg: ");
        int n10 = this.a.a;
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append("|");
        String string2 = this.a.b;
        ((StringBuilder)object).append(string2);
        object = ((StringBuilder)object).toString();
        TXCLog.i("TXHttpRequest", (String)object);
        object = this.b;
        long l10 = TXHttpRequest.access$000((TXHttpRequest)object);
        Object object2 = this.a;
        int n11 = ((TXHttpRequest$b)object2).a;
        object2 = ((TXHttpRequest$b)object2).c;
        TXHttpRequest.access$100((TXHttpRequest)object, l10, n11, (byte[])object2);
    }
}

