/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.Runnables$1;

public final class Runnables {
    private static final Runnable EMPTY_RUNNABLE;

    static {
        Runnables$1 runnables$1 = new Runnables$1();
        EMPTY_RUNNABLE = runnables$1;
    }

    private Runnables() {
    }

    public static Runnable doNothing() {
        return EMPTY_RUNNABLE;
    }
}

