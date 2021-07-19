/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format$Builder;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader$TrackIdGenerator;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;

public final class Id3Reader
implements ElementaryStreamReader {
    private static final String TAG = "Id3Reader";
    private final ParsableByteArray id3Header;
    private TrackOutput output;
    private int sampleBytesRead;
    private int sampleSize;
    private long sampleTimeUs;
    private boolean writingSample;

    public Id3Reader() {
        ParsableByteArray parsableByteArray;
        this.id3Header = parsableByteArray = new ParsableByteArray(10);
    }

    public void consume(ParsableByteArray parsableByteArray) {
        int n10;
        TrackOutput trackOutput = this.output;
        Assertions.checkStateNotNull(trackOutput);
        int n11 = this.writingSample;
        if (n11 == 0) {
            return;
        }
        n11 = parsableByteArray.bytesLeft();
        int n12 = this.sampleBytesRead;
        int n13 = 10;
        if (n12 < n13) {
            n12 = 10 - n12;
            n12 = Math.min(n11, n12);
            byte[] byArray = parsableByteArray.getData();
            int n14 = parsableByteArray.getPosition();
            byte[] byArray2 = this.id3Header.getData();
            int n15 = this.sampleBytesRead;
            System.arraycopy(byArray, n14, byArray2, n15, n12);
            int n16 = this.sampleBytesRead + n12;
            if (n16 == n13) {
                ParsableByteArray parsableByteArray2 = this.id3Header;
                n16 = 0;
                byArray = null;
                parsableByteArray2.setPosition(0);
                n12 = 73;
                ParsableByteArray parsableByteArray3 = this.id3Header;
                n14 = parsableByteArray3.readUnsignedByte();
                if (n12 == n14 && (n12 = 68) == (n14 = (parsableByteArray3 = this.id3Header).readUnsignedByte()) && (n12 = 51) == (n14 = (parsableByteArray3 = this.id3Header).readUnsignedByte())) {
                    parsableByteArray2 = this.id3Header;
                    n16 = 3;
                    parsableByteArray2.skipBytes(n16);
                    parsableByteArray2 = this.id3Header;
                    this.sampleSize = n12 = parsableByteArray2.readSynchSafeInt() + n13;
                } else {
                    Log.w(TAG, "Discarding invalid ID3 tag");
                    this.writingSample = false;
                    return;
                }
            }
        }
        n12 = this.sampleSize;
        n13 = this.sampleBytesRead;
        n11 = Math.min(n11, n12 -= n13);
        this.output.sampleData(parsableByteArray, n11);
        this.sampleBytesRead = n10 = this.sampleBytesRead + n11;
    }

    public void createTracks(ExtractorOutput object, TsPayloadReader$TrackIdGenerator object2) {
        ((TsPayloadReader$TrackIdGenerator)object2).generateNewId();
        int n10 = ((TsPayloadReader$TrackIdGenerator)object2).getTrackId();
        this.output = object = object.track(n10, 5);
        Format$Builder format$Builder = new Format$Builder();
        object2 = ((TsPayloadReader$TrackIdGenerator)object2).getFormatId();
        object2 = format$Builder.setId((String)object2).setSampleMimeType("application/id3").build();
        object.format((Format)object2);
    }

    public void packetFinished() {
        int n10;
        TrackOutput trackOutput = this.output;
        Assertions.checkStateNotNull(trackOutput);
        int n11 = this.writingSample;
        if (n11 != 0 && (n10 = this.sampleSize) != 0 && (n11 = this.sampleBytesRead) == n10) {
            TrackOutput trackOutput2 = this.output;
            long l10 = this.sampleTimeUs;
            int n12 = 1;
            trackOutput2.sampleMetadata(l10, n12, n10, 0, null);
            n11 = 0;
            trackOutput = null;
            this.writingSample = false;
        }
    }

    public void packetStarted(long l10, int n10) {
        if ((n10 &= 4) == 0) {
            return;
        }
        this.writingSample = true;
        this.sampleTimeUs = l10;
        this.sampleSize = 0;
        this.sampleBytesRead = 0;
    }

    public void seek() {
        this.writingSample = false;
    }
}

