/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import java.util.concurrent.Executor;

public final class DirectExecutor
extends Enum
implements Executor {
    private static final /* synthetic */ DirectExecutor[] $VALUES;
    public static final /* enum */ DirectExecutor INSTANCE;

    static {
        DirectExecutor directExecutor;
        INSTANCE = directExecutor = new DirectExecutor("INSTANCE", 0);
        DirectExecutor[] directExecutorArray = new DirectExecutor[]{directExecutor};
        $VALUES = directExecutorArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private DirectExecutor() {
        void var2_-1;
        void var1_-1;
    }

    public static DirectExecutor valueOf(String string2) {
        return Enum.valueOf(DirectExecutor.class, string2);
    }

    public static DirectExecutor[] values() {
        return (DirectExecutor[])$VALUES.clone();
    }

    public void execute(Runnable runnable) {
        runnable.run();
    }

    public String toString() {
        return "MoreExecutors.directExecutor()";
    }
}

