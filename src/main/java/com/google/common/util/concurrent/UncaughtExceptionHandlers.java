/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.UncaughtExceptionHandlers$Exiter;

public final class UncaughtExceptionHandlers {
    private UncaughtExceptionHandlers() {
    }

    public static Thread.UncaughtExceptionHandler systemExit() {
        Runtime runtime = Runtime.getRuntime();
        UncaughtExceptionHandlers$Exiter uncaughtExceptionHandlers$Exiter = new UncaughtExceptionHandlers$Exiter(runtime);
        return uncaughtExceptionHandlers$Exiter;
    }
}

