/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source;

import java.io.IOException;

public final class MergingMediaSource$IllegalMergeException
extends IOException {
    public static final int REASON_PERIOD_COUNT_MISMATCH;
    public final int reason;

    public MergingMediaSource$IllegalMergeException(int n10) {
        this.reason = n10;
    }
}

