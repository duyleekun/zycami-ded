/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.support.api;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.PendingResultImpl;
import com.huawei.hms.support.api.PendingResultImpl$d;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.transport.DatagramTransport$a;

public class PendingResultImpl$c
implements DatagramTransport$a {
    public final /* synthetic */ PendingResultImpl$d a;
    public final /* synthetic */ ResultCallback b;
    public final /* synthetic */ PendingResultImpl c;

    public PendingResultImpl$c(PendingResultImpl pendingResultImpl, PendingResultImpl$d pendingResultImpl$d, ResultCallback resultCallback) {
        this.c = pendingResultImpl;
        this.a = pendingResultImpl$d;
        this.b = resultCallback;
    }

    public void a(int n10, IMessageEntity object) {
        PendingResultImpl.access$000(this.c, n10, (IMessageEntity)object);
        PendingResultImpl$d pendingResultImpl$d = this.a;
        object = this.b;
        Result result2 = PendingResultImpl.access$200(this.c);
        pendingResultImpl$d.a((ResultCallback)object, result2);
    }
}

