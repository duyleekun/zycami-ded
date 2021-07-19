/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.TrackOutput$CryptoData;
import com.google.android.exoplayer2.source.chunk.ChunkExtractor$TrackOutputProvider;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;

public final class BundledChunkExtractor$BindingTrackOutput
implements TrackOutput {
    private long endTimeUs;
    private final DummyTrackOutput fakeTrackOutput;
    private final int id;
    private final Format manifestFormat;
    public Format sampleFormat;
    private TrackOutput trackOutput;
    private final int type;

    public BundledChunkExtractor$BindingTrackOutput(int n10, int n11, Format format) {
        DummyTrackOutput dummyTrackOutput;
        this.id = n10;
        this.type = n11;
        this.manifestFormat = format;
        this.fakeTrackOutput = dummyTrackOutput = new DummyTrackOutput();
    }

    public void bind(ChunkExtractor$TrackOutputProvider object, long l10) {
        if (object == null) {
            this.trackOutput = object = this.fakeTrackOutput;
            return;
        }
        this.endTimeUs = l10;
        int n10 = this.id;
        int n11 = this.type;
        this.trackOutput = object = object.track(n10, n11);
        Format format = this.sampleFormat;
        if (format != null) {
            object.format(format);
        }
    }

    public void format(Format object) {
        Format format = this.manifestFormat;
        if (format != null) {
            object = ((Format)object).withManifestFormatInfo(format);
        }
        this.sampleFormat = object;
        object = (TrackOutput)Util.castNonNull(this.trackOutput);
        format = this.sampleFormat;
        object.format(format);
    }

    public int sampleData(DataReader dataReader, int n10, boolean bl2, int n11) {
        return ((TrackOutput)Util.castNonNull(this.trackOutput)).sampleData(dataReader, n10, bl2);
    }

    public void sampleData(ParsableByteArray parsableByteArray, int n10, int n11) {
        ((TrackOutput)Util.castNonNull(this.trackOutput)).sampleData(parsableByteArray, n10);
    }

    public void sampleMetadata(long l10, int n10, int n11, int n12, TrackOutput$CryptoData trackOutput$CryptoData) {
        Object object;
        long l11;
        long l12 = this.endTimeUs;
        long l13 = -9223372036854775807L;
        long l14 = l12 - l13;
        Object object2 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object2 != false && (l11 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1)) >= 0) {
            this.trackOutput = object = this.fakeTrackOutput;
        }
        Object object3 = object = Util.castNonNull(this.trackOutput);
        object3 = (TrackOutput)object;
        l13 = l10;
        object3.sampleMetadata(l10, n10, n11, n12, trackOutput$CryptoData);
    }
}

