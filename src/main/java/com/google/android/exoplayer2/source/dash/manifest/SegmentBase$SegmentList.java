/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.dash.manifest;

import com.google.android.exoplayer2.source.dash.manifest.RangedUri;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.source.dash.manifest.SegmentBase$MultiSegmentBase;
import java.util.List;

public final class SegmentBase$SegmentList
extends SegmentBase$MultiSegmentBase {
    public final List mediaSegments;

    public SegmentBase$SegmentList(RangedUri rangedUri, long l10, long l11, long l12, long l13, List list, long l14, List list2, long l15, long l16) {
        super(rangedUri, l10, l11, l12, l13, list, l14, l15, l16);
        this.mediaSegments = list2;
    }

    public int getSegmentCount(long l10) {
        return this.mediaSegments.size();
    }

    public RangedUri getSegmentUrl(Representation object, long l10) {
        object = this.mediaSegments;
        long l11 = this.startNumber;
        int n10 = (int)(l10 - l11);
        return (RangedUri)object.get(n10);
    }

    public boolean isExplicit() {
        return true;
    }
}

