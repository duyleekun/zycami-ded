/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.dash.manifest;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.dash.DashSegmentIndex;
import com.google.android.exoplayer2.source.dash.manifest.RangedUri;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.source.dash.manifest.SegmentBase$MultiSegmentBase;
import java.util.List;

public class Representation$MultiSegmentRepresentation
extends Representation
implements DashSegmentIndex {
    public final SegmentBase$MultiSegmentBase segmentBase;

    public Representation$MultiSegmentRepresentation(long l10, Format format, String string2, SegmentBase$MultiSegmentBase segmentBase$MultiSegmentBase, List list) {
        super(l10, format, string2, segmentBase$MultiSegmentBase, list, null);
        this.segmentBase = segmentBase$MultiSegmentBase;
    }

    public int getAvailableSegmentCount(long l10, long l11) {
        return this.segmentBase.getAvailableSegmentCount(l10, l11);
    }

    public String getCacheKey() {
        return null;
    }

    public long getDurationUs(long l10, long l11) {
        return this.segmentBase.getSegmentDurationUs(l10, l11);
    }

    public long getFirstAvailableSegmentNum(long l10, long l11) {
        return this.segmentBase.getFirstAvailableSegmentNum(l10, l11);
    }

    public long getFirstSegmentNum() {
        return this.segmentBase.getFirstSegmentNum();
    }

    public DashSegmentIndex getIndex() {
        return this;
    }

    public RangedUri getIndexUri() {
        return null;
    }

    public long getNextSegmentAvailableTimeUs(long l10, long l11) {
        return this.segmentBase.getNextSegmentAvailableTimeUs(l10, l11);
    }

    public int getSegmentCount(long l10) {
        return this.segmentBase.getSegmentCount(l10);
    }

    public long getSegmentNum(long l10, long l11) {
        return this.segmentBase.getSegmentNum(l10, l11);
    }

    public RangedUri getSegmentUrl(long l10) {
        return this.segmentBase.getSegmentUrl(this, l10);
    }

    public long getTimeUs(long l10) {
        return this.segmentBase.getSegmentTimeUs(l10);
    }

    public boolean isExplicit() {
        return this.segmentBase.isExplicit();
    }
}

