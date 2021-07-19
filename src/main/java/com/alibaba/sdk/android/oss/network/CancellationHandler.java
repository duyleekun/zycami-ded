/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.network;

import g.e;

public class CancellationHandler {
    private volatile e call;
    private volatile boolean isCancelled;

    public void cancel() {
        e e10 = this.call;
        if (e10 != null) {
            e10 = this.call;
            e10.cancel();
        }
        this.isCancelled = true;
    }

    public boolean isCancelled() {
        return this.isCancelled;
    }

    public void setCall(e e10) {
        this.call = e10;
    }
}

