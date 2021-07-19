/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Striped$PaddedSemaphore;
import java.util.concurrent.Semaphore;

public final class Striped$3
implements Supplier {
    public final /* synthetic */ int val$permits;

    public Striped$3(int n10) {
        this.val$permits = n10;
    }

    public Semaphore get() {
        int n10 = this.val$permits;
        Striped$PaddedSemaphore striped$PaddedSemaphore = new Striped$PaddedSemaphore(n10);
        return striped$PaddedSemaphore;
    }
}

