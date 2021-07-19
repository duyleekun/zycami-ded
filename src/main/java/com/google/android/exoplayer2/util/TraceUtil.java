/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Trace
 */
package com.google.android.exoplayer2.util;

import android.os.Trace;
import com.google.android.exoplayer2.util.Util;

public final class TraceUtil {
    private TraceUtil() {
    }

    public static void beginSection(String string2) {
        int n10 = Util.SDK_INT;
        int n11 = 18;
        if (n10 >= n11) {
            TraceUtil.beginSectionV18(string2);
        }
    }

    private static void beginSectionV18(String string2) {
        Trace.beginSection((String)string2);
    }

    public static void endSection() {
        int n10 = Util.SDK_INT;
        int n11 = 18;
        if (n10 >= n11) {
            TraceUtil.endSectionV18();
        }
    }

    private static void endSectionV18() {
        Trace.endSection();
    }
}

