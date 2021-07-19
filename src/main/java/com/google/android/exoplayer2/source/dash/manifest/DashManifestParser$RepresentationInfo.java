/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.dash.manifest;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.dash.manifest.SegmentBase;
import java.util.ArrayList;

public final class DashManifestParser$RepresentationInfo {
    public final String baseUrl;
    public final ArrayList drmSchemeDatas;
    public final String drmSchemeType;
    public final Format format;
    public final ArrayList inbandEventStreams;
    public final long revisionId;
    public final SegmentBase segmentBase;

    public DashManifestParser$RepresentationInfo(Format format, String string2, SegmentBase segmentBase, String string3, ArrayList arrayList, ArrayList arrayList2, long l10) {
        this.format = format;
        this.baseUrl = string2;
        this.segmentBase = segmentBase;
        this.drmSchemeType = string3;
        this.drmSchemeDatas = arrayList;
        this.inbandEventStreams = arrayList2;
        this.revisionId = l10;
    }
}

