/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.flogger.backend;

import com.google.common.flogger.LogSite;

public abstract class Platform$LogCallerFinder {
    public abstract LogSite findLogSite(Class var1, int var2);

    public abstract String findLoggingClass(Class var1);
}

