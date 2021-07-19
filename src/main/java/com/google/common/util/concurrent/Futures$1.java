/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import java.util.concurrent.Future;

public final class Futures$1
implements Runnable {
    public final /* synthetic */ Future val$scheduled;

    public Futures$1(Future future) {
        this.val$scheduled = future;
    }

    public void run() {
        this.val$scheduled.cancel(false);
    }
}

