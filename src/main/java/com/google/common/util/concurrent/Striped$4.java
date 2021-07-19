/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import java.util.concurrent.Semaphore;

public final class Striped$4
implements Supplier {
    public final /* synthetic */ int val$permits;

    public Striped$4(int n10) {
        this.val$permits = n10;
    }

    public Semaphore get() {
        int n10 = this.val$permits;
        Semaphore semaphore = new Semaphore(n10, false);
        return semaphore;
    }
}

