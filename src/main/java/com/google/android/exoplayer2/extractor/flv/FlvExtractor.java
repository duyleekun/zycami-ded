/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.IndexSeekMap;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekMap$Unseekable;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.flv.AudioTagPayloadReader;
import com.google.android.exoplayer2.extractor.flv.ScriptTagPayloadReader;
import com.google.android.exoplayer2.extractor.flv.VideoTagPayloadReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import d.h.a.a.h0.d.a;

public final class FlvExtractor
implements Extractor {
    public static final ExtractorsFactory FACTORY = a.a;
    private static final int FLV_HEADER_SIZE = 9;
    private static final int FLV_TAG = 4607062;
    private static final int FLV_TAG_HEADER_SIZE = 11;
    private static final int STATE_READING_FLV_HEADER = 1;
    private static final int STATE_READING_TAG_DATA = 4;
    private static final int STATE_READING_TAG_HEADER = 3;
    private static final int STATE_SKIPPING_TO_TAG_HEADER = 2;
    private static final int TAG_TYPE_AUDIO = 8;
    private static final int TAG_TYPE_SCRIPT_DATA = 18;
    private static final int TAG_TYPE_VIDEO = 9;
    private AudioTagPayloadReader audioReader;
    private int bytesToNextTagHeader;
    private ExtractorOutput extractorOutput;
    private final ParsableByteArray headerBuffer;
    private long mediaTagTimestampOffsetUs;
    private final ScriptTagPayloadReader metadataReader;
    private boolean outputFirstSample;
    private boolean outputSeekMap;
    private final ParsableByteArray scratch;
    private int state;
    private final ParsableByteArray tagData;
    private int tagDataSize;
    private final ParsableByteArray tagHeaderBuffer;
    private long tagTimestampUs;
    private int tagType;
    private VideoTagPayloadReader videoReader;

    public FlvExtractor() {
        Object object = new ParsableByteArray(4);
        this.scratch = object;
        object = new ParsableByteArray(9);
        this.headerBuffer = object;
        object = new ParsableByteArray(11);
        this.tagHeaderBuffer = object;
        object = new ParsableByteArray();
        this.tagData = object;
        this.metadataReader = object = new ScriptTagPayloadReader();
        this.state = 1;
    }

    public static /* synthetic */ Extractor[] a() {
        Extractor[] extractorArray = new Extractor[1];
        FlvExtractor flvExtractor = new FlvExtractor();
        extractorArray[0] = flvExtractor;
        return extractorArray;
    }

    private void ensureReadyForMediaOutput() {
        boolean bl2 = this.outputSeekMap;
        if (!bl2) {
            ExtractorOutput extractorOutput = this.extractorOutput;
            long l10 = -9223372036854775807L;
            SeekMap$Unseekable seekMap$Unseekable = new SeekMap$Unseekable(l10);
            extractorOutput.seekMap(seekMap$Unseekable);
            this.outputSeekMap = bl2 = true;
        }
    }

    private long getCurrentTimestampUs() {
        long l10;
        Object object = this.outputFirstSample;
        if (object) {
            l10 = this.mediaTagTimestampOffsetUs;
            long l11 = this.tagTimestampUs;
            l10 += l11;
        } else {
            long l12;
            ScriptTagPayloadReader scriptTagPayloadReader = this.metadataReader;
            l10 = scriptTagPayloadReader.getDurationUs();
            long l13 = l10 - (l12 = -9223372036854775807L);
            object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            l10 = !object ? 0L : this.tagTimestampUs;
        }
        return l10;
    }

    private ParsableByteArray prepareTagData(ExtractorInput extractorInput) {
        Object object;
        int n10 = this.tagDataSize;
        Object object2 = this.tagData;
        int n11 = ((ParsableByteArray)object2).capacity();
        if (n10 > n11) {
            object = this.tagData;
            n11 = ((ParsableByteArray)object).capacity() * 2;
            int n12 = this.tagDataSize;
            n11 = Math.max(n11, n12);
            object2 = new byte[n11];
            ((ParsableByteArray)object).reset((byte[])object2, 0);
        } else {
            object = this.tagData;
            ((ParsableByteArray)object).setPosition(0);
        }
        object = this.tagData;
        n11 = this.tagDataSize;
        ((ParsableByteArray)object).setLimit(n11);
        object = this.tagData.getData();
        n11 = this.tagDataSize;
        extractorInput.readFully((byte[])object, 0, n11);
        return this.tagData;
    }

    private boolean readFlvHeader(ExtractorInput object) {
        Object object2;
        byte[] byArray = this.headerBuffer.getData();
        int n10 = 0;
        VideoTagPayloadReader videoTagPayloadReader = null;
        int n11 = 9;
        int n12 = 1;
        int n13 = object.readFully(byArray, 0, n11, n12 != 0);
        if (n13 == 0) {
            return false;
        }
        this.headerBuffer.setPosition(0);
        object = this.headerBuffer;
        int n14 = 4;
        ((ParsableByteArray)object).skipBytes(n14);
        object = this.headerBuffer;
        n13 = ((ParsableByteArray)object).readUnsignedByte();
        int n15 = n13 & 4;
        if (n15 != 0) {
            n15 = n12;
        } else {
            n15 = 0;
            object2 = null;
        }
        if ((n13 &= n12) != 0) {
            n10 = n12;
        }
        if (n15 != 0 && (object = this.audioReader) == null) {
            object2 = this.extractorOutput;
            int n16 = 8;
            object2 = object2.track(n16, n12);
            this.audioReader = object = new AudioTagPayloadReader((TrackOutput)object2);
        }
        n13 = 2;
        if (n10 != 0 && (videoTagPayloadReader = this.videoReader) == null) {
            object2 = this.extractorOutput.track(n11, n13);
            this.videoReader = videoTagPayloadReader = new VideoTagPayloadReader((TrackOutput)object2);
        }
        this.extractorOutput.endTracks();
        this.bytesToNextTagHeader = n10 = this.headerBuffer.readInt() - n11 + n14;
        this.state = n13;
        return n12 != 0;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private boolean readTagData(ExtractorInput var1_1) {
        block3: {
            block5: {
                block4: {
                    var2_2 = this.getCurrentTimestampUs();
                    var4_3 = this.tagType;
                    var5_4 = -9223372036854775807L;
                    var7_5 = false;
                    var8_6 = true;
                    var9_7 = 8;
                    if (var4_3 == var9_7 && (var10_8 = this.audioReader) != null) {
                        this.ensureReadyForMediaOutput();
                        var11_9 = this.audioReader;
                        var1_1 = this.prepareTagData((ExtractorInput)var1_1);
                        var7_5 = var11_9.consume((ParsableByteArray)var1_1, var2_2);
lbl12:
                        // 4 sources

                        while (true) {
                            var12_12 /* !! */  = var8_6;
                            break block3;
                            break;
                        }
                    }
                    var9_7 = 9;
                    if (var4_3 != var9_7 || (var10_8 = this.videoReader) == null) break block4;
                    this.ensureReadyForMediaOutput();
                    var11_10 = this.videoReader;
                    var1_1 = this.prepareTagData((ExtractorInput)var1_1);
                    var7_5 = var11_10.consume((ParsableByteArray)var1_1, var2_2);
                    ** GOTO lbl12
                }
                var9_7 = 18;
                if (var4_3 != var9_7 || (var4_3 = (int)this.outputSeekMap) != 0) break block5;
                var11_11 = this.metadataReader;
                var1_1 = this.prepareTagData((ExtractorInput)var1_1);
                var7_5 = var11_11.consume((ParsableByteArray)var1_1, var2_2);
                var1_1 = this.metadataReader;
                var2_2 = var1_1.getDurationUs();
                cfr_temp_0 = var2_2 - var5_4;
                var12_12 /* !! */  = cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1);
                if (!var12_12 /* !! */ ) ** GOTO lbl12
                var1_1 = this.extractorOutput;
                var10_8 = this.metadataReader.getKeyFrameTagPositions();
                var13_13 = this.metadataReader.getKeyFrameTimesUs();
                var11_11 = new IndexSeekMap((long[])var10_8, var13_13, var2_2);
                var1_1.seekMap((SeekMap)var11_11);
                this.outputSeekMap = var8_6;
                ** while (true)
            }
            var14_14 = this.tagDataSize;
            var1_1.skipFully(var14_14);
            var12_12 /* !! */  = false;
            var1_1 = null;
        }
        var14_14 = (int)this.outputFirstSample;
        if (var14_14 == 0 && var7_5) {
            this.outputFirstSample = var8_6;
            var15_15 = this.metadataReader;
            var2_2 = var15_15.getDurationUs();
            cfr_temp_1 = var2_2 - var5_4;
            var14_14 = (int)(cfr_temp_1 == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1));
            var2_2 = var14_14 == 0 ? -this.tagTimestampUs : 0L;
            this.mediaTagTimestampOffsetUs = var2_2;
        }
        this.bytesToNextTagHeader = 4;
        this.state = 2;
        return var12_12 /* !! */ ;
    }

    private boolean readTagHeader(ExtractorInput extractorInput) {
        long l10;
        boolean bl2;
        int n10;
        byte[] byArray = this.tagHeaderBuffer.getData();
        int n11 = extractorInput.readFully(byArray, 0, n10 = 11, bl2 = true);
        if (n11 == 0) {
            return false;
        }
        this.tagHeaderBuffer.setPosition(0);
        this.tagType = n11 = this.tagHeaderBuffer.readUnsignedByte();
        this.tagDataSize = n11 = this.tagHeaderBuffer.readUnsignedInt24();
        this.tagTimestampUs = l10 = (long)this.tagHeaderBuffer.readUnsignedInt24();
        l10 = this.tagHeaderBuffer.readUnsignedByte() << 24;
        long l11 = this.tagTimestampUs;
        this.tagTimestampUs = l10 = (l10 | l11) * 1000L;
        this.tagHeaderBuffer.skipBytes(3);
        this.state = 4;
        return bl2;
    }

    private void skipToTagHeader(ExtractorInput extractorInput) {
        int n10 = this.bytesToNextTagHeader;
        extractorInput.skipFully(n10);
        this.bytesToNextTagHeader = 0;
        this.state = 3;
    }

    public void init(ExtractorOutput extractorOutput) {
        this.extractorOutput = extractorOutput;
    }

    public int read(ExtractorInput object, PositionHolder object2) {
        int n10;
        object2 = this.extractorOutput;
        Assertions.checkStateNotNull(object2);
        while (true) {
            int n11 = this.state;
            int n12 = 1;
            n10 = -1;
            if (n11 != n12) {
                n12 = 2;
                if (n11 != n12) {
                    n12 = 3;
                    if (n11 != n12) {
                        n12 = 4;
                        if (n11 == n12) {
                            n11 = (int)(this.readTagData((ExtractorInput)object) ? 1 : 0);
                            if (n11 == 0) continue;
                            return 0;
                        }
                        object = new IllegalStateException();
                        throw object;
                    }
                    n11 = (int)(this.readTagHeader((ExtractorInput)object) ? 1 : 0);
                    if (n11 != 0) continue;
                    return n10;
                }
                this.skipToTagHeader((ExtractorInput)object);
                continue;
            }
            n11 = (int)(this.readFlvHeader((ExtractorInput)object) ? 1 : 0);
            if (n11 == 0) break;
        }
        return n10;
    }

    public void release() {
    }

    public void seek(long l10, long l11) {
        l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            object = 1;
            this.state = (int)object;
            this.outputFirstSample = false;
        } else {
            object = 3;
            this.state = (int)object;
        }
        this.bytesToNextTagHeader = 0;
    }

    public boolean sniff(ExtractorInput object) {
        Object object2 = this.scratch.getData();
        boolean bl2 = false;
        object.peekFully((byte[])object2, 0, 3);
        this.scratch.setPosition(0);
        object2 = this.scratch;
        int n10 = object2.readUnsignedInt24();
        int n11 = 4607062;
        if (n10 != n11) {
            return false;
        }
        object2 = this.scratch.getData();
        n11 = 2;
        object.peekFully((byte[])object2, 0, n11);
        this.scratch.setPosition(0);
        object2 = this.scratch;
        n10 = object2.readUnsignedShort() & 0xFA;
        if (n10 != 0) {
            return false;
        }
        object2 = this.scratch.getData();
        n11 = 4;
        object.peekFully((byte[])object2, 0, n11);
        this.scratch.setPosition(0);
        n10 = this.scratch.readInt();
        object.resetPeekPosition();
        object.advancePeekPosition(n10);
        object2 = this.scratch.getData();
        object.peekFully((byte[])object2, 0, n11);
        this.scratch.setPosition(0);
        object = this.scratch;
        int n12 = ((ParsableByteArray)object).readInt();
        if (n12 == 0) {
            bl2 = true;
        }
        return bl2;
    }
}

