/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.mkv;

import com.google.android.exoplayer2.audio.Ac3Util;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.TrackOutput$CryptoData;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor$Track;

public final class MatroskaExtractor$TrueHdSampleRechunker {
    private int chunkFlags;
    private int chunkOffset;
    private int chunkSampleCount;
    private int chunkSize;
    private long chunkTimeUs;
    private boolean foundSyncframe;
    private final byte[] syncframePrefix;

    public MatroskaExtractor$TrueHdSampleRechunker() {
        byte[] byArray = new byte[10];
        this.syncframePrefix = byArray;
    }

    public void outputPendingSampleMetadata(MatroskaExtractor$Track matroskaExtractor$Track) {
        int n10 = this.chunkSampleCount;
        if (n10 > 0) {
            TrackOutput trackOutput = matroskaExtractor$Track.output;
            long l10 = this.chunkTimeUs;
            int n11 = this.chunkFlags;
            int n12 = this.chunkSize;
            int n13 = this.chunkOffset;
            TrackOutput$CryptoData trackOutput$CryptoData = matroskaExtractor$Track.cryptoData;
            trackOutput.sampleMetadata(l10, n11, n12, n13, trackOutput$CryptoData);
            matroskaExtractor$Track = null;
            this.chunkSampleCount = 0;
        }
    }

    public void reset() {
        this.foundSyncframe = false;
        this.chunkSampleCount = 0;
    }

    public void sampleMetadata(MatroskaExtractor$Track matroskaExtractor$Track, long l10, int n10, int n11, int n12) {
        int n13;
        int n14;
        int n15 = this.foundSyncframe;
        if (n15 == 0) {
            return;
        }
        n15 = this.chunkSampleCount;
        this.chunkSampleCount = n14 = n15 + 1;
        if (n15 == 0) {
            this.chunkTimeUs = l10;
            this.chunkFlags = n10;
            n13 = 0;
            this.chunkSize = 0;
        }
        this.chunkSize = n13 = this.chunkSize + n11;
        this.chunkOffset = n12;
        n13 = 16;
        if (n14 >= n13) {
            this.outputPendingSampleMetadata(matroskaExtractor$Track);
        }
    }

    public void startSample(ExtractorInput object) {
        boolean bl2 = this.foundSyncframe;
        if (bl2) {
            return;
        }
        byte[] byArray = this.syncframePrefix;
        int n10 = 10;
        object.peekFully(byArray, 0, n10);
        object.resetPeekPosition();
        object = this.syncframePrefix;
        int n11 = Ac3Util.parseTrueHdSyncframeAudioSampleCount((byte[])object);
        if (n11 == 0) {
            return;
        }
        this.foundSyncframe = true;
    }
}

