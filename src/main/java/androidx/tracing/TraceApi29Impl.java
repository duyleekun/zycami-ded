/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Trace
 */
package androidx.tracing;

import android.os.Trace;

public final class TraceApi29Impl {
    private TraceApi29Impl() {
    }

    public static void beginAsyncSection(String string2, int n10) {
        Trace.beginAsyncSection((String)string2, (int)n10);
    }

    public static void endAsyncSection(String string2, int n10) {
        Trace.endAsyncSection((String)string2, (int)n10);
    }

    public static void setCounter(String string2, int n10) {
        long l10 = n10;
        Trace.setCounter((String)string2, (long)l10);
    }
}

