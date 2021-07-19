/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import java.util.concurrent.Callable;

public final class Callables$1
implements Callable {
    public final /* synthetic */ Object val$value;

    public Callables$1(Object object) {
        this.val$value = object;
    }

    public Object call() {
        return this.val$value;
    }
}

