/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.dash.manifest;

import com.google.android.exoplayer2.source.dash.manifest.RangedUri;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.util.Util;

public abstract class SegmentBase {
    public final RangedUri initialization;
    public final long presentationTimeOffset;
    public final long timescale;

    public SegmentBase(RangedUri rangedUri, long l10, long l11) {
        this.initialization = rangedUri;
        this.timescale = l10;
        this.presentationTimeOffset = l11;
    }

    public RangedUri getInitialization(Representation representation) {
        return this.initialization;
    }

    public long getPresentationTimeOffsetUs() {
        long l10 = this.presentationTimeOffset;
        long l11 = this.timescale;
        return Util.scaleLargeTimestamp(l10, 1000000L, l11);
    }
}

