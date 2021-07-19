/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.dash;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.extractor.rawcc.RawCcExtractor;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.chunk.BundledChunkExtractor;
import com.google.android.exoplayer2.source.chunk.ChunkExtractor;
import com.google.android.exoplayer2.source.dash.DashSegmentIndex;
import com.google.android.exoplayer2.source.dash.manifest.RangedUri;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.List;

public final class DefaultDashChunkSource$RepresentationHolder {
    public final ChunkExtractor chunkExtractor;
    private final long periodDurationUs;
    public final Representation representation;
    public final DashSegmentIndex segmentIndex;
    private final long segmentNumShift;

    public DefaultDashChunkSource$RepresentationHolder(long l10, int n10, Representation representation, boolean bl2, List list, TrackOutput trackOutput) {
        ChunkExtractor chunkExtractor = DefaultDashChunkSource$RepresentationHolder.createChunkExtractor(n10, representation, bl2, list, trackOutput);
        DashSegmentIndex dashSegmentIndex = representation.getIndex();
        this(l10, representation, chunkExtractor, 0L, dashSegmentIndex);
    }

    private DefaultDashChunkSource$RepresentationHolder(long l10, Representation representation, ChunkExtractor chunkExtractor, long l11, DashSegmentIndex dashSegmentIndex) {
        this.periodDurationUs = l10;
        this.representation = representation;
        this.segmentNumShift = l11;
        this.chunkExtractor = chunkExtractor;
        this.segmentIndex = dashSegmentIndex;
    }

    public static /* synthetic */ long access$000(DefaultDashChunkSource$RepresentationHolder defaultDashChunkSource$RepresentationHolder) {
        return defaultDashChunkSource$RepresentationHolder.periodDurationUs;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static ChunkExtractor createChunkExtractor(int n10, Representation object, boolean bl2, List object2, TrackOutput trackOutput) {
        Object object3;
        String string2 = object.format.containerMimeType;
        boolean bl3 = MimeTypes.isText(string2);
        if (bl3) {
            object3 = "application/x-rawcc";
            bl2 = ((String)object3).equals(string2);
            if (!bl2) return null;
            object2 = ((Representation)object).format;
            object3 = new RawCcExtractor((Format)object2);
        } else {
            int n11 = MimeTypes.isMatroska(string2);
            if (n11 != 0) {
                int n12 = 1;
                object3 = new MatroskaExtractor(n12);
            } else {
                n11 = 0;
                string2 = null;
                if (bl2) {
                    n11 = 4;
                }
                object3 = new FragmentedMp4Extractor(n11, null, null, (List)object2, trackOutput);
            }
        }
        object = ((Representation)object).format;
        return new BundledChunkExtractor((Extractor)object3, n10, (Format)object);
    }

    public DefaultDashChunkSource$RepresentationHolder copyWithNewRepresentation(long l10, Representation representation) {
        Object object;
        block10: {
            DefaultDashChunkSource$RepresentationHolder defaultDashChunkSource$RepresentationHolder;
            long l11;
            Object object2;
            Object object3;
            DefaultDashChunkSource$RepresentationHolder defaultDashChunkSource$RepresentationHolder2;
            block9: {
                Object object4;
                long l12;
                long l13;
                long l14;
                long l15;
                long l16;
                block8: {
                    defaultDashChunkSource$RepresentationHolder2 = this;
                    object = this.representation;
                    object3 = ((Representation)object).getIndex();
                    object2 = representation.getIndex();
                    if (object3 == null) {
                        ChunkExtractor chunkExtractor = this.chunkExtractor;
                        long l17 = this.segmentNumShift;
                        object = object2;
                        object2 = new DefaultDashChunkSource$RepresentationHolder(l10, representation, chunkExtractor, l17, (DashSegmentIndex)object3);
                        return object2;
                    }
                    int n10 = object3.isExplicit();
                    if (n10 == 0) {
                        DefaultDashChunkSource$RepresentationHolder defaultDashChunkSource$RepresentationHolder3;
                        ChunkExtractor chunkExtractor = this.chunkExtractor;
                        long l18 = this.segmentNumShift;
                        object = defaultDashChunkSource$RepresentationHolder3;
                        object3 = object2;
                        defaultDashChunkSource$RepresentationHolder3 = new DefaultDashChunkSource$RepresentationHolder(l10, representation, chunkExtractor, l18, (DashSegmentIndex)object2);
                        return defaultDashChunkSource$RepresentationHolder3;
                    }
                    n10 = object3.getSegmentCount(l10);
                    if (n10 == 0) {
                        DefaultDashChunkSource$RepresentationHolder defaultDashChunkSource$RepresentationHolder4;
                        ChunkExtractor chunkExtractor = this.chunkExtractor;
                        long l19 = this.segmentNumShift;
                        object = defaultDashChunkSource$RepresentationHolder4;
                        object3 = object2;
                        defaultDashChunkSource$RepresentationHolder4 = new DefaultDashChunkSource$RepresentationHolder(l10, representation, chunkExtractor, l19, (DashSegmentIndex)object2);
                        return defaultDashChunkSource$RepresentationHolder4;
                    }
                    l16 = object3.getFirstSegmentNum();
                    l11 = object3.getTimeUs(l16);
                    l15 = (long)n10 + l16 - 1L;
                    long l20 = object3.getTimeUs(l15);
                    long l21 = object3.getDurationUs(l15, l10);
                    l14 = object2.getFirstSegmentNum();
                    l13 = l16;
                    l16 = object2.getTimeUs(l14);
                    l12 = this.segmentNumShift;
                    long l22 = (l20 += l21) - l16;
                    object4 = l22 == 0L ? 0 : (l22 < 0L ? -1 : 1);
                    if (object4 != false) break block8;
                    l20 = 1L;
                    l15 = l15 + l20 - l14;
                    l11 = l12 += l15;
                    break block9;
                }
                if (object4 < 0) break block10;
                object4 = l16 == l11 ? 0 : (l16 < l11 ? -1 : 1);
                if (object4 < 0) {
                    l15 = l12;
                    l16 = object2.getSegmentNum(l11, l10) - l13;
                    l16 = l12 - l16;
                } else {
                    l15 = l12;
                    l16 = object3.getSegmentNum(l16, l10) - l14 + l12;
                }
                l11 = l16;
            }
            ChunkExtractor chunkExtractor = defaultDashChunkSource$RepresentationHolder2.chunkExtractor;
            object = defaultDashChunkSource$RepresentationHolder;
            object3 = object2;
            defaultDashChunkSource$RepresentationHolder = new DefaultDashChunkSource$RepresentationHolder(l10, representation, chunkExtractor, l11, (DashSegmentIndex)object2);
            return defaultDashChunkSource$RepresentationHolder;
        }
        object = new BehindLiveWindowException();
        throw object;
    }

    public DefaultDashChunkSource$RepresentationHolder copyWithNewSegmentIndex(DashSegmentIndex dashSegmentIndex) {
        long l10 = this.periodDurationUs;
        Representation representation = this.representation;
        ChunkExtractor chunkExtractor = this.chunkExtractor;
        long l11 = this.segmentNumShift;
        DefaultDashChunkSource$RepresentationHolder defaultDashChunkSource$RepresentationHolder = new DefaultDashChunkSource$RepresentationHolder(l10, representation, chunkExtractor, l11, dashSegmentIndex);
        return defaultDashChunkSource$RepresentationHolder;
    }

    public long getFirstAvailableSegmentNum(long l10) {
        DashSegmentIndex dashSegmentIndex = this.segmentIndex;
        long l11 = this.periodDurationUs;
        l10 = dashSegmentIndex.getFirstAvailableSegmentNum(l11, l10);
        long l12 = this.segmentNumShift;
        return l10 + l12;
    }

    public long getFirstSegmentNum() {
        long l10 = this.segmentIndex.getFirstSegmentNum();
        long l11 = this.segmentNumShift;
        return l10 + l11;
    }

    public long getLastAvailableSegmentNum(long l10) {
        long l11 = this.getFirstAvailableSegmentNum(l10);
        DashSegmentIndex dashSegmentIndex = this.segmentIndex;
        long l12 = this.periodDurationUs;
        l10 = dashSegmentIndex.getAvailableSegmentCount(l12, l10);
        return l11 + l10 - 1L;
    }

    public int getSegmentCount() {
        DashSegmentIndex dashSegmentIndex = this.segmentIndex;
        long l10 = this.periodDurationUs;
        return dashSegmentIndex.getSegmentCount(l10);
    }

    public long getSegmentEndTimeUs(long l10) {
        long l11 = this.getSegmentStartTimeUs(l10);
        DashSegmentIndex dashSegmentIndex = this.segmentIndex;
        long l12 = this.segmentNumShift;
        l10 -= l12;
        l12 = this.periodDurationUs;
        l10 = dashSegmentIndex.getDurationUs(l10, l12);
        return l11 + l10;
    }

    public long getSegmentNum(long l10) {
        DashSegmentIndex dashSegmentIndex = this.segmentIndex;
        long l11 = this.periodDurationUs;
        l10 = dashSegmentIndex.getSegmentNum(l10, l11);
        long l12 = this.segmentNumShift;
        return l10 + l12;
    }

    public long getSegmentStartTimeUs(long l10) {
        DashSegmentIndex dashSegmentIndex = this.segmentIndex;
        long l11 = this.segmentNumShift;
        return dashSegmentIndex.getTimeUs(l10 -= l11);
    }

    public RangedUri getSegmentUrl(long l10) {
        DashSegmentIndex dashSegmentIndex = this.segmentIndex;
        long l11 = this.segmentNumShift;
        return dashSegmentIndex.getSegmentUrl(l10 -= l11);
    }

    public boolean isSegmentAvailableAtFullNetworkSpeed(long l10, long l11) {
        long l12;
        int n10;
        long l13 = -9223372036854775807L;
        long l14 = l11 - l13;
        Object object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        n10 = object != false && (n10 = (l12 = (l10 = this.getSegmentEndTimeUs(l10)) - l11) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0 ? 0 : 1;
        return n10 != 0;
    }
}

