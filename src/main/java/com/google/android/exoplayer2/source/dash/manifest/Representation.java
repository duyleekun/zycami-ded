/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.dash.manifest;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.dash.DashSegmentIndex;
import com.google.android.exoplayer2.source.dash.manifest.RangedUri;
import com.google.android.exoplayer2.source.dash.manifest.Representation$1;
import com.google.android.exoplayer2.source.dash.manifest.Representation$MultiSegmentRepresentation;
import com.google.android.exoplayer2.source.dash.manifest.Representation$SingleSegmentRepresentation;
import com.google.android.exoplayer2.source.dash.manifest.SegmentBase;
import com.google.android.exoplayer2.source.dash.manifest.SegmentBase$MultiSegmentBase;
import com.google.android.exoplayer2.source.dash.manifest.SegmentBase$SingleSegmentBase;
import java.util.Collections;
import java.util.List;

public abstract class Representation {
    public static final long REVISION_ID_DEFAULT = 255L;
    public final String baseUrl;
    public final Format format;
    public final List inbandEventStreams;
    private final RangedUri initializationUri;
    public final long presentationTimeOffsetUs;
    public final long revisionId;

    private Representation(long l10, Format format, String string2, SegmentBase segmentBase, List list) {
        this.revisionId = l10;
        this.format = format;
        this.baseUrl = string2;
        List list2 = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        this.inbandEventStreams = list2;
        this.initializationUri = list2 = segmentBase.getInitialization(this);
        this.presentationTimeOffsetUs = l10 = segmentBase.getPresentationTimeOffsetUs();
    }

    public /* synthetic */ Representation(long l10, Format format, String string2, SegmentBase segmentBase, List list, Representation$1 representation$1) {
        this(l10, format, string2, segmentBase, list);
    }

    public static Representation newInstance(long l10, Format format, String string2, SegmentBase segmentBase) {
        return Representation.newInstance(l10, format, string2, segmentBase, null);
    }

    public static Representation newInstance(long l10, Format format, String string2, SegmentBase segmentBase, List list) {
        return Representation.newInstance(l10, format, string2, segmentBase, list, null);
    }

    public static Representation newInstance(long l10, Format format, String string2, SegmentBase segmentBase, List list, String string3) {
        Object object = segmentBase;
        boolean bl2 = segmentBase instanceof SegmentBase$SingleSegmentBase;
        if (bl2) {
            SegmentBase segmentBase2 = segmentBase;
            segmentBase2 = (SegmentBase$SingleSegmentBase)segmentBase;
            Representation$SingleSegmentRepresentation representation$SingleSegmentRepresentation = new Representation$SingleSegmentRepresentation(l10, format, string2, (SegmentBase$SingleSegmentBase)segmentBase2, list, string3, -1);
            return representation$SingleSegmentRepresentation;
        }
        bl2 = segmentBase instanceof SegmentBase$MultiSegmentBase;
        if (bl2) {
            SegmentBase segmentBase3 = segmentBase;
            segmentBase3 = (SegmentBase$MultiSegmentBase)segmentBase;
            Representation$MultiSegmentRepresentation representation$MultiSegmentRepresentation = new Representation$MultiSegmentRepresentation(l10, format, string2, (SegmentBase$MultiSegmentBase)segmentBase3, list);
            return representation$MultiSegmentRepresentation;
        }
        object = new IllegalArgumentException("segmentBase must be of type SingleSegmentBase or MultiSegmentBase");
        throw object;
    }

    public abstract String getCacheKey();

    public abstract DashSegmentIndex getIndex();

    public abstract RangedUri getIndexUri();

    public RangedUri getInitializationUri() {
        return this.initializationUri;
    }
}

