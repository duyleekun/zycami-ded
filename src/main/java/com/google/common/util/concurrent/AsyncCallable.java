/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.ListenableFuture;

public interface AsyncCallable {
    public ListenableFuture call();
}

