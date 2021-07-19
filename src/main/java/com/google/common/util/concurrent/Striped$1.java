/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Striped$PaddedLock;
import java.util.concurrent.locks.Lock;

public final class Striped$1
implements Supplier {
    public Lock get() {
        Striped$PaddedLock striped$PaddedLock = new Striped$PaddedLock();
        return striped$PaddedLock;
    }
}

