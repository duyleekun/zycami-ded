/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;

public final class MediaLoadData {
    public final int dataType;
    public final long mediaEndTimeMs;
    public final long mediaStartTimeMs;
    public final Format trackFormat;
    public final Object trackSelectionData;
    public final int trackSelectionReason;
    public final int trackType;

    public MediaLoadData(int n10) {
        this(n10, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
    }

    public MediaLoadData(int n10, int n11, Format format, int n12, Object object, long l10, long l11) {
        this.dataType = n10;
        this.trackType = n11;
        this.trackFormat = format;
        this.trackSelectionReason = n12;
        this.trackSelectionData = object;
        this.mediaStartTimeMs = l10;
        this.mediaEndTimeMs = l11;
    }
}

