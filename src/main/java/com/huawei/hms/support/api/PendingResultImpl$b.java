/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.support.api;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.PendingResultImpl;
import com.huawei.hms.support.api.transport.DatagramTransport$a;
import java.util.concurrent.atomic.AtomicBoolean;

public class PendingResultImpl$b
implements DatagramTransport$a {
    public final /* synthetic */ AtomicBoolean a;
    public final /* synthetic */ PendingResultImpl b;

    public PendingResultImpl$b(PendingResultImpl pendingResultImpl, AtomicBoolean atomicBoolean) {
        this.b = pendingResultImpl;
        this.a = atomicBoolean;
    }

    public void a(int n10, IMessageEntity iMessageEntity) {
        Object object = this.a;
        boolean bl2 = ((AtomicBoolean)object).get();
        if (!bl2) {
            object = this.b;
            PendingResultImpl.access$000((PendingResultImpl)object, n10, iMessageEntity);
        }
        PendingResultImpl.access$100(this.b).countDown();
    }
}

