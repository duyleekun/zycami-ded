/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.dash.manifest;

import com.google.android.exoplayer2.source.dash.manifest.RangedUri;
import com.google.android.exoplayer2.source.dash.manifest.SegmentBase;

public class SegmentBase$SingleSegmentBase
extends SegmentBase {
    public final long indexLength;
    public final long indexStart;

    public SegmentBase$SingleSegmentBase() {
        this(null, 1L, 0L, 0L, 0L);
    }

    public SegmentBase$SingleSegmentBase(RangedUri rangedUri, long l10, long l11, long l12, long l13) {
        super(rangedUri, l10, l11);
        this.indexStart = l12;
        this.indexLength = l13;
    }

    public RangedUri getIndex() {
        RangedUri rangedUri;
        long l10 = this.indexLength;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object <= 0) {
            object = 0;
            rangedUri = null;
        } else {
            RangedUri rangedUri2;
            long l13 = this.indexStart;
            rangedUri = rangedUri2;
            rangedUri2 = new RangedUri(null, l13, l10);
        }
        return rangedUri;
    }
}

