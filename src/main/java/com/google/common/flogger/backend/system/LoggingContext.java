/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.flogger.backend.system;

import com.google.common.flogger.backend.Tags;
import java.util.logging.Level;

public abstract class LoggingContext {
    public abstract Tags getTags();

    public abstract boolean shouldForceLogging(String var1, Level var2, boolean var3);
}

