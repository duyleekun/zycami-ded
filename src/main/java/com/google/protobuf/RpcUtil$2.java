/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.RpcCallback;
import com.google.protobuf.RpcUtil$AlreadyCalledException;

public final class RpcUtil$2
implements RpcCallback {
    private boolean alreadyCalled = false;
    public final /* synthetic */ RpcCallback val$originalCallback;

    public RpcUtil$2(RpcCallback rpcCallback) {
        this.val$originalCallback = rpcCallback;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run(Object object) {
        synchronized (this) {
            boolean bl2 = this.alreadyCalled;
            if (!bl2) {
                this.alreadyCalled = bl2 = true;
                // MONITOREXIT @DISABLED, blocks:[2, 3] lbl5 : MonitorExitStatement: MONITOREXIT : this
                this.val$originalCallback.run(object);
                return;
            }
            object = new RpcUtil$AlreadyCalledException();
            throw object;
        }
    }
}

