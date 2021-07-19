/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source;

import java.io.IOException;

public final class ClippingMediaSource$IllegalClippingException
extends IOException {
    public static final int REASON_INVALID_PERIOD_COUNT = 0;
    public static final int REASON_NOT_SEEKABLE_TO_START = 1;
    public static final int REASON_START_EXCEEDS_END = 2;
    public final int reason;

    public ClippingMediaSource$IllegalClippingException(int n10) {
        String string2 = String.valueOf(ClippingMediaSource$IllegalClippingException.getReasonDescription(n10));
        int n11 = string2.length();
        String string3 = "Illegal clipping: ";
        string2 = n11 != 0 ? string3.concat(string2) : new String(string3);
        super(string2);
        this.reason = n10;
    }

    private static String getReasonDescription(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    return "unknown";
                }
                return "start exceeds end";
            }
            return "not seekable to start";
        }
        return "invalid period count";
    }
}

