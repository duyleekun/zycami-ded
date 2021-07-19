/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.support.api;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.PendingResultImpl;
import com.huawei.hms.support.api.transport.DatagramTransport$a;

public class PendingResultImpl$a
implements DatagramTransport$a {
    public final /* synthetic */ PendingResultImpl a;

    public PendingResultImpl$a(PendingResultImpl pendingResultImpl) {
        this.a = pendingResultImpl;
    }

    public void a(int n10, IMessageEntity iMessageEntity) {
        PendingResultImpl.access$000(this.a, n10, iMessageEntity);
        PendingResultImpl.access$100(this.a).countDown();
    }
}

