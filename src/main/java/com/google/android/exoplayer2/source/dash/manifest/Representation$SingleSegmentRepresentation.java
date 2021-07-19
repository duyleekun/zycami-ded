/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.dash.DashSegmentIndex;
import com.google.android.exoplayer2.source.dash.manifest.RangedUri;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.source.dash.manifest.SegmentBase$SingleSegmentBase;
import com.google.android.exoplayer2.source.dash.manifest.SingleSegmentIndex;
import java.util.List;

public class Representation$SingleSegmentRepresentation
extends Representation {
    private final String cacheKey;
    public final long contentLength;
    private final RangedUri indexUri;
    private final SingleSegmentIndex segmentIndex;
    public final Uri uri;

    public Representation$SingleSegmentRepresentation(long l10, Format format, String string2, SegmentBase$SingleSegmentBase segmentBase$SingleSegmentBase, List list, String string3, long l11) {
        Representation$SingleSegmentRepresentation representation$SingleSegmentRepresentation = this;
        Object object = this;
        Object object2 = format;
        super(l10, format, string2, segmentBase$SingleSegmentBase, list, null);
        object = Uri.parse((String)string2);
        this.uri = object;
        this.indexUri = object = segmentBase$SingleSegmentBase.getIndex();
        this.cacheKey = string3;
        this.contentLength = l11;
        if (object != null) {
            object = null;
        } else {
            long l12 = 0L;
            object2 = new RangedUri(null, l12, l11);
            object = new SingleSegmentIndex((RangedUri)object2);
        }
        representation$SingleSegmentRepresentation.segmentIndex = object;
    }

    public static Representation$SingleSegmentRepresentation newInstance(long l10, Format format, String string2, long l11, long l12, long l13, long l14, List list, String string3, long l15) {
        SegmentBase$SingleSegmentBase segmentBase$SingleSegmentBase;
        RangedUri rangedUri;
        long l16 = l12 - l11;
        long l17 = 1L;
        long l18 = l16 + l17;
        Object object = rangedUri;
        rangedUri = new RangedUri(null, l11, l18);
        long l19 = l14 - l13 + l17;
        object = segmentBase$SingleSegmentBase;
        segmentBase$SingleSegmentBase = new SegmentBase$SingleSegmentBase(rangedUri, 1L, 0L, l13, l19);
        object = new Representation$SingleSegmentRepresentation(l10, format, string2, segmentBase$SingleSegmentBase, list, string3, l15);
        return object;
    }

    public String getCacheKey() {
        return this.cacheKey;
    }

    public DashSegmentIndex getIndex() {
        return this.segmentIndex;
    }

    public RangedUri getIndexUri() {
        return this.indexUri;
    }
}

