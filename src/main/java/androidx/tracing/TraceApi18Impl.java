/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Trace
 */
package androidx.tracing;

import android.os.Trace;

public final class TraceApi18Impl {
    private TraceApi18Impl() {
    }

    public static void beginSection(String string2) {
        Trace.beginSection((String)string2);
    }

    public static void endSection() {
        Trace.endSection();
    }
}

