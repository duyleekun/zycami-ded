/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseArray
 */
package com.google.android.exoplayer2.source.chunk;

import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.chunk.BundledChunkExtractor$BindingTrackOutput;
import com.google.android.exoplayer2.source.chunk.ChunkExtractor;
import com.google.android.exoplayer2.source.chunk.ChunkExtractor$TrackOutputProvider;
import com.google.android.exoplayer2.util.Assertions;

public final class BundledChunkExtractor
implements ExtractorOutput,
ChunkExtractor {
    private static final PositionHolder POSITION_HOLDER;
    private final SparseArray bindingTrackOutputs;
    private long endTimeUs;
    private final Extractor extractor;
    private boolean extractorInitialized;
    private final Format primaryTrackManifestFormat;
    private final int primaryTrackType;
    private Format[] sampleFormats;
    private SeekMap seekMap;
    private ChunkExtractor$TrackOutputProvider trackOutputProvider;

    static {
        PositionHolder positionHolder;
        POSITION_HOLDER = positionHolder = new PositionHolder();
    }

    public BundledChunkExtractor(Extractor extractor, int n10, Format format) {
        this.extractor = extractor;
        this.primaryTrackType = n10;
        this.primaryTrackManifestFormat = format;
        this.bindingTrackOutputs = extractor;
    }

    public void endTracks() {
        Object object;
        int n10;
        int n11 = this.bindingTrackOutputs.size();
        Format[] formatArray = new Format[n11];
        for (int i10 = 0; i10 < (n10 = (object = this.bindingTrackOutputs).size()); ++i10) {
            object = (Format)Assertions.checkStateNotNull(((BundledChunkExtractor$BindingTrackOutput)this.bindingTrackOutputs.valueAt((int)i10)).sampleFormat);
            formatArray[i10] = object;
        }
        this.sampleFormats = formatArray;
    }

    public ChunkIndex getChunkIndex() {
        SeekMap seekMap = this.seekMap;
        boolean bl2 = seekMap instanceof ChunkIndex;
        seekMap = bl2 ? (ChunkIndex)seekMap : null;
        return seekMap;
    }

    public Format[] getSampleFormats() {
        return this.sampleFormats;
    }

    public void init(ChunkExtractor$TrackOutputProvider object, long l10, long l11) {
        this.trackOutputProvider = object;
        this.endTimeUs = l11;
        boolean bl2 = this.extractorInitialized;
        long l12 = -9223372036854775807L;
        long l13 = 0L;
        if (!bl2) {
            object = this.extractor;
            object.init(this);
            long l14 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1);
            if (l14 != false) {
                object = this.extractor;
                object.seek(l13, l10);
            }
            l14 = 1;
            this.extractorInitialized = l14;
        } else {
            Object object2;
            int n10;
            Extractor extractor = this.extractor;
            Object object3 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1);
            if (object3 == false) {
                l10 = l13;
            }
            extractor.seek(l13, l10);
            for (int i10 = 0; i10 < (n10 = (object2 = this.bindingTrackOutputs).size()); ++i10) {
                object2 = (BundledChunkExtractor$BindingTrackOutput)this.bindingTrackOutputs.valueAt(i10);
                ((BundledChunkExtractor$BindingTrackOutput)object2).bind((ChunkExtractor$TrackOutputProvider)object, l11);
            }
        }
    }

    public boolean read(ExtractorInput extractorInput) {
        Extractor extractor = this.extractor;
        PositionHolder positionHolder = POSITION_HOLDER;
        boolean bl2 = extractor.read(extractorInput, positionHolder);
        boolean bl3 = false;
        extractor = null;
        boolean bl4 = true;
        boolean bl5 = bl2 != bl4 ? bl4 : false;
        Assertions.checkState(bl5);
        if (!bl2) {
            bl3 = bl4;
        }
        return bl3;
    }

    public void release() {
        this.extractor.release();
    }

    public void seekMap(SeekMap seekMap) {
        this.seekMap = seekMap;
    }

    public TrackOutput track(int n10, int n11) {
        Object object = (Format[])this.bindingTrackOutputs.get(n10);
        if (object == null) {
            Format format;
            boolean bl2;
            object = this.sampleFormats;
            if (object == null) {
                bl2 = true;
            } else {
                bl2 = false;
                object = null;
            }
            Assertions.checkState(bl2);
            int n12 = this.primaryTrackType;
            if (n11 == n12) {
                format = this.primaryTrackManifestFormat;
            } else {
                n12 = 0;
                format = null;
            }
            object = new BundledChunkExtractor$BindingTrackOutput(n10, n11, format);
            ChunkExtractor$TrackOutputProvider chunkExtractor$TrackOutputProvider = this.trackOutputProvider;
            long l10 = this.endTimeUs;
            ((BundledChunkExtractor$BindingTrackOutput)object).bind(chunkExtractor$TrackOutputProvider, l10);
            chunkExtractor$TrackOutputProvider = this.bindingTrackOutputs;
            chunkExtractor$TrackOutputProvider.put(n10, object);
        }
        return object;
    }
}

