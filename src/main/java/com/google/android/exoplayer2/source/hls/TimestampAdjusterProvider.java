/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseArray
 */
package com.google.android.exoplayer2.source.hls;

import android.util.SparseArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;

public final class TimestampAdjusterProvider {
    private final SparseArray timestampAdjusters;

    public TimestampAdjusterProvider() {
        SparseArray sparseArray;
        this.timestampAdjusters = sparseArray = new SparseArray();
    }

    public TimestampAdjuster getAdjuster(int n10) {
        TimestampAdjuster timestampAdjuster = (TimestampAdjuster)this.timestampAdjusters.get(n10);
        if (timestampAdjuster == null) {
            long l10 = Long.MAX_VALUE;
            timestampAdjuster = new TimestampAdjuster(l10);
            SparseArray sparseArray = this.timestampAdjusters;
            sparseArray.put(n10, (Object)timestampAdjuster);
        }
        return timestampAdjuster;
    }

    public void reset() {
        this.timestampAdjusters.clear();
    }
}

