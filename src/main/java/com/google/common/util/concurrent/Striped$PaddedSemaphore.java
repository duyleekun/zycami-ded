/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import java.util.concurrent.Semaphore;

public class Striped$PaddedSemaphore
extends Semaphore {
    public long unused1;
    public long unused2;
    public long unused3;

    public Striped$PaddedSemaphore(int n10) {
        super(n10, false);
    }
}

