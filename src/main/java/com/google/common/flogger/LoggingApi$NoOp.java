/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.flogger;

import com.google.common.flogger.LogSite;
import com.google.common.flogger.LoggingApi;
import com.google.common.flogger.StackSize;
import com.google.common.flogger.util.Checks;
import java.util.concurrent.TimeUnit;

public class LoggingApi$NoOp
implements LoggingApi {
    public final LoggingApi atMostEvery(int n10, TimeUnit timeUnit) {
        Checks.checkNotNull((Object)timeUnit, "time unit");
        return this.noOp();
    }

    public final LoggingApi every(int n10) {
        return this.noOp();
    }

    public final boolean isEnabled() {
        return false;
    }

    public final void log() {
    }

    public final void log(String string2) {
    }

    public final void log(String string2, byte by2) {
    }

    public final void log(String string2, byte by2, byte by3) {
    }

    public final void log(String string2, byte by2, char c10) {
    }

    public final void log(String string2, byte by2, double d10) {
    }

    public final void log(String string2, byte by2, float f10) {
    }

    public final void log(String string2, byte by2, int n10) {
    }

    public final void log(String string2, byte by2, long l10) {
    }

    public final void log(String string2, byte by2, Object object) {
    }

    public final void log(String string2, byte by2, short s10) {
    }

    public final void log(String string2, byte by2, boolean bl2) {
    }

    public final void log(String string2, char c10) {
    }

    public final void log(String string2, char c10, byte by2) {
    }

    public final void log(String string2, char c10, char c11) {
    }

    public final void log(String string2, char c10, double d10) {
    }

    public final void log(String string2, char c10, float f10) {
    }

    public final void log(String string2, char c10, int n10) {
    }

    public final void log(String string2, char c10, long l10) {
    }

    public final void log(String string2, char c10, Object object) {
    }

    public final void log(String string2, char c10, short s10) {
    }

    public final void log(String string2, char c10, boolean bl2) {
    }

    public final void log(String string2, double d10, byte by2) {
    }

    public final void log(String string2, double d10, char c10) {
    }

    public final void log(String string2, double d10, double d11) {
    }

    public final void log(String string2, double d10, float f10) {
    }

    public final void log(String string2, double d10, int n10) {
    }

    public final void log(String string2, double d10, long l10) {
    }

    public final void log(String string2, double d10, Object object) {
    }

    public final void log(String string2, double d10, short s10) {
    }

    public final void log(String string2, double d10, boolean bl2) {
    }

    public final void log(String string2, float f10, byte by2) {
    }

    public final void log(String string2, float f10, char c10) {
    }

    public final void log(String string2, float f10, double d10) {
    }

    public final void log(String string2, float f10, float f11) {
    }

    public final void log(String string2, float f10, int n10) {
    }

    public final void log(String string2, float f10, long l10) {
    }

    public final void log(String string2, float f10, Object object) {
    }

    public final void log(String string2, float f10, short s10) {
    }

    public final void log(String string2, float f10, boolean bl2) {
    }

    public final void log(String string2, int n10) {
    }

    public final void log(String string2, int n10, byte by2) {
    }

    public final void log(String string2, int n10, char c10) {
    }

    public final void log(String string2, int n10, double d10) {
    }

    public final void log(String string2, int n10, float f10) {
    }

    public final void log(String string2, int n10, int n11) {
    }

    public final void log(String string2, int n10, long l10) {
    }

    public final void log(String string2, int n10, Object object) {
    }

    public final void log(String string2, int n10, short s10) {
    }

    public final void log(String string2, int n10, boolean bl2) {
    }

    public final void log(String string2, long l10) {
    }

    public final void log(String string2, long l10, byte by2) {
    }

    public final void log(String string2, long l10, char c10) {
    }

    public final void log(String string2, long l10, double d10) {
    }

    public final void log(String string2, long l10, float f10) {
    }

    public final void log(String string2, long l10, int n10) {
    }

    public final void log(String string2, long l10, long l11) {
    }

    public final void log(String string2, long l10, Object object) {
    }

    public final void log(String string2, long l10, short s10) {
    }

    public final void log(String string2, long l10, boolean bl2) {
    }

    public final void log(String string2, Object object) {
    }

    public final void log(String string2, Object object, byte by2) {
    }

    public final void log(String string2, Object object, char c10) {
    }

    public final void log(String string2, Object object, double d10) {
    }

    public final void log(String string2, Object object, float f10) {
    }

    public final void log(String string2, Object object, int n10) {
    }

    public final void log(String string2, Object object, long l10) {
    }

    public final void log(String string2, Object object, Object object2) {
    }

    public final void log(String string2, Object object, Object object2, Object object3) {
    }

    public final void log(String string2, Object object, Object object2, Object object3, Object object4) {
    }

    public final void log(String string2, Object object, Object object2, Object object3, Object object4, Object object5) {
    }

    public final void log(String string2, Object object, Object object2, Object object3, Object object4, Object object5, Object object6) {
    }

    public final void log(String string2, Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7) {
    }

    public final void log(String string2, Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8) {
    }

    public final void log(String string2, Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9) {
    }

    public final void log(String string2, Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9, Object object10) {
    }

    public final void log(String string2, Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9, Object object10, Object ... objectArray) {
    }

    public final void log(String string2, Object object, short s10) {
    }

    public final void log(String string2, Object object, boolean bl2) {
    }

    public final void log(String string2, short s10) {
    }

    public final void log(String string2, short s10, byte by2) {
    }

    public final void log(String string2, short s10, char c10) {
    }

    public final void log(String string2, short s10, double d10) {
    }

    public final void log(String string2, short s10, float f10) {
    }

    public final void log(String string2, short s10, int n10) {
    }

    public final void log(String string2, short s10, long l10) {
    }

    public final void log(String string2, short s10, Object object) {
    }

    public final void log(String string2, short s10, short s11) {
    }

    public final void log(String string2, short s10, boolean bl2) {
    }

    public final void log(String string2, boolean bl2, byte by2) {
    }

    public final void log(String string2, boolean bl2, char c10) {
    }

    public final void log(String string2, boolean bl2, double d10) {
    }

    public final void log(String string2, boolean bl2, float f10) {
    }

    public final void log(String string2, boolean bl2, int n10) {
    }

    public final void log(String string2, boolean bl2, long l10) {
    }

    public final void log(String string2, boolean bl2, Object object) {
    }

    public final void log(String string2, boolean bl2, short s10) {
    }

    public final void log(String string2, boolean bl2, boolean bl3) {
    }

    public final void logVarargs(String string2, Object[] objectArray) {
    }

    public final LoggingApi noOp() {
        return this;
    }

    public final LoggingApi withCause(Throwable throwable) {
        return this.noOp();
    }

    public LoggingApi withInjectedLogSite(LogSite logSite) {
        Checks.checkNotNull(logSite, "log site");
        return this.noOp();
    }

    public LoggingApi withInjectedLogSite(String string2, String string3, int n10, String string4) {
        return this.noOp();
    }

    public LoggingApi withStackTrace(StackSize stackSize) {
        Checks.checkNotNull((Object)stackSize, "stack size");
        return this.noOp();
    }
}

