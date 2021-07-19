/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format$Builder;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader;
import com.google.android.exoplayer2.extractor.ts.H263Reader$CsdBuffer;
import com.google.android.exoplayer2.extractor.ts.H263Reader$SampleReader;
import com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader$TrackIdGenerator;
import com.google.android.exoplayer2.extractor.ts.UserDataReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class H263Reader
implements ElementaryStreamReader {
    private static final float[] PIXEL_WIDTH_HEIGHT_RATIO_BY_ASPECT_RATIO_INFO;
    private static final int START_CODE_VALUE_GROUP_OF_VOP = 179;
    private static final int START_CODE_VALUE_MAX_VIDEO_OBJECT = 31;
    private static final int START_CODE_VALUE_UNSET = 255;
    private static final int START_CODE_VALUE_USER_DATA = 178;
    private static final int START_CODE_VALUE_VISUAL_OBJECT = 181;
    private static final int START_CODE_VALUE_VISUAL_OBJECT_SEQUENCE = 176;
    private static final int START_CODE_VALUE_VOP = 182;
    private static final String TAG = "H263Reader";
    private static final int VIDEO_OBJECT_LAYER_SHAPE_RECTANGULAR;
    private final H263Reader$CsdBuffer csdBuffer;
    private String formatId;
    private boolean hasOutputFormat;
    private TrackOutput output;
    private long pesTimeUs;
    private final boolean[] prefixFlags;
    private H263Reader$SampleReader sampleReader;
    private long totalBytesWritten;
    private final NalUnitTargetBuffer userData;
    private final ParsableByteArray userDataParsable;
    private final UserDataReader userDataReader;

    static {
        float[] fArray;
        float[] fArray2 = fArray = new float[7];
        float[] fArray3 = fArray;
        fArray2[0] = 1.0f;
        fArray3[1] = 1.0f;
        fArray2[2] = 1.0909091f;
        fArray3[3] = 0.90909094f;
        fArray2[4] = 1.4545455f;
        fArray3[5] = 1.2121212f;
        fArray3[6] = 1.0f;
        PIXEL_WIDTH_HEIGHT_RATIO_BY_ASPECT_RATIO_INFO = fArray;
    }

    public H263Reader() {
        this(null);
    }

    public H263Reader(UserDataReader object) {
        this.userDataReader = object;
        int n10 = 4;
        Object object2 = new boolean[n10];
        this.prefixFlags = object2;
        object2 = new H263Reader$CsdBuffer;
        int n11 = 128;
        super(n11);
        this.csdBuffer = object2;
        if (object != null) {
            n10 = 178;
            this.userData = object = new NalUnitTargetBuffer(n10, n11);
            this.userDataParsable = object = new ParsableByteArray();
        } else {
            object = null;
            this.userData = null;
            this.userDataParsable = null;
        }
    }

    private static Format parseCsdBuffer(H263Reader$CsdBuffer list, int n10, String string2) {
        Object object;
        float[] fArray;
        Object object2 = ((H263Reader$CsdBuffer)list).data;
        int n11 = ((H263Reader$CsdBuffer)list).length;
        list = (List<Object>)Arrays.copyOf((byte[])object2, n11);
        object2 = new ParsableBitArray;
        ((ParsableBitArray)object2)((byte[])list);
        ((ParsableBitArray)object2).skipBytes(n10);
        n10 = 4;
        float f10 = 5.6E-45f;
        ((ParsableBitArray)object2).skipBytes(n10);
        ((ParsableBitArray)object2).skipBit();
        int n12 = 8;
        float f11 = 1.1E-44f;
        ((ParsableBitArray)object2).skipBits(n12);
        boolean n13 = ((ParsableBitArray)object2).readBit();
        int n14 = 3;
        if (n13) {
            ((ParsableBitArray)object2).skipBits(n10);
            ((ParsableBitArray)object2).skipBits(n14);
        }
        n10 = ((ParsableBitArray)object2).readBits(n10);
        int n15 = 1065353216;
        float f12 = 1.0f;
        String string3 = "Invalid aspect ratio";
        String string4 = TAG;
        int n16 = 15;
        if (n10 == n16) {
            n10 = ((ParsableBitArray)object2).readBits(n12);
            if ((n12 = ((ParsableBitArray)object2).readBits(n12)) == 0) {
                Log.w(string4, string3);
            } else {
                f10 = n10;
                f11 = n12;
                f12 = f10 /= f11;
            }
        } else {
            fArray = PIXEL_WIDTH_HEIGHT_RATIO_BY_ASPECT_RATIO_INFO;
            int n17 = fArray.length;
            if (n10 < n17) {
                f12 = fArray[n10];
            } else {
                Log.w(string4, string3);
            }
        }
        n10 = (int)(((ParsableBitArray)object2).readBit() ? 1 : 0);
        n12 = 2;
        f11 = 2.8E-45f;
        if (n10 != 0) {
            ((ParsableBitArray)object2).skipBits(n12);
            f10 = Float.MIN_VALUE;
            ((ParsableBitArray)object2).skipBits(1);
            n10 = (int)(((ParsableBitArray)object2).readBit() ? 1 : 0);
            if (n10 != 0) {
                ((ParsableBitArray)object2).skipBits(n16);
                ((ParsableBitArray)object2).skipBit();
                ((ParsableBitArray)object2).skipBits(n16);
                ((ParsableBitArray)object2).skipBit();
                ((ParsableBitArray)object2).skipBits(n16);
                ((ParsableBitArray)object2).skipBit();
                ((ParsableBitArray)object2).skipBits(n14);
                n10 = 11;
                f10 = 1.5E-44f;
                ((ParsableBitArray)object2).skipBits(n10);
                ((ParsableBitArray)object2).skipBit();
                ((ParsableBitArray)object2).skipBits(n16);
                ((ParsableBitArray)object2).skipBit();
            }
        }
        if ((n10 = ((ParsableBitArray)object2).readBits(n12)) != 0) {
            object = "Unhandled video object layer shape";
            Log.w(string4, (String)object);
        }
        ((ParsableBitArray)object2).skipBit();
        f10 = 2.24E-44f;
        n10 = ((ParsableBitArray)object2).readBits(16);
        ((ParsableBitArray)object2).skipBit();
        n12 = (int)(((ParsableBitArray)object2).readBit() ? 1 : 0);
        if (n12 != 0) {
            if (n10 == 0) {
                object = "Invalid vop_increment_time_resolution";
                Log.w(string4, (String)object);
            } else {
                n10 += -1;
                n12 = 0;
                f11 = 0.0f;
                fArray = null;
                while (n10 > 0) {
                    ++n12;
                    n10 >>= 1;
                }
                ((ParsableBitArray)object2).skipBits(n12);
            }
        }
        ((ParsableBitArray)object2).skipBit();
        n10 = 13;
        n12 = ((ParsableBitArray)object2).readBits(n10);
        ((ParsableBitArray)object2).skipBit();
        n10 = ((ParsableBitArray)object2).readBits(n10);
        ((ParsableBitArray)object2).skipBit();
        ((ParsableBitArray)object2).skipBit();
        object2 = new Format$Builder();
        object = ((Format$Builder)object2).setId(string2).setSampleMimeType("video/mp4v-es").setWidth(n12).setHeight(n10).setPixelWidthHeightRatio(f12);
        list = Collections.singletonList(list);
        return ((Format$Builder)object).setInitializationData(list).build();
    }

    public void consume(ParsableByteArray object) {
        Assertions.checkStateNotNull(this.sampleReader);
        Object object2 = this.output;
        Assertions.checkStateNotNull(object2);
        Object object3 = ((ParsableByteArray)object).getPosition();
        int n10 = ((ParsableByteArray)object).limit();
        byte[] byArray = ((ParsableByteArray)object).getData();
        long l10 = this.totalBytesWritten;
        Object object4 = ((ParsableByteArray)object).bytesLeft();
        long l11 = object4;
        this.totalBytesWritten = l10 += l11;
        Object object5 = this.output;
        int n11 = ((ParsableByteArray)object).bytesLeft();
        object5.sampleData((ParsableByteArray)object, n11);
        while (true) {
            long l12;
            Object object6;
            int n12;
            if ((n12 = NalUnitUtil.findNalUnit(byArray, object3, n10, (boolean[])(object5 = (Object)this.prefixFlags))) == n10) {
                boolean bl2 = this.hasOutputFormat;
                if (!bl2) {
                    object = this.csdBuffer;
                    ((H263Reader$CsdBuffer)object).onData(byArray, (int)object3, n10);
                }
                this.sampleReader.onData(byArray, (int)object3, n10);
                object = this.userData;
                if (object != null) {
                    ((NalUnitTargetBuffer)object).appendToNalUnit(byArray, (int)object3, n10);
                }
                return;
            }
            byte[] byArray2 = ((ParsableByteArray)object).getData();
            object4 = n12 + 3;
            n11 = byArray2[object4] & 0xFF;
            int n13 = n12 - object3;
            int n14 = this.hasOutputFormat;
            Object object7 = 1;
            int n15 = 0;
            ParsableByteArray parsableByteArray = null;
            if (n14 == 0) {
                if (n13 > 0) {
                    object6 = this.csdBuffer;
                    ((H263Reader$CsdBuffer)object6).onData(byArray, (int)object3, n12);
                }
                if (n13 < 0) {
                    n14 = -n13;
                } else {
                    n14 = 0;
                    object6 = null;
                }
                Object object8 = this.csdBuffer;
                n14 = (int)(((H263Reader$CsdBuffer)object8).onStartCode(n11, n14) ? 1 : 0);
                if (n14 != 0) {
                    object6 = this.output;
                    object8 = this.csdBuffer;
                    int n16 = ((H263Reader$CsdBuffer)object8).volStartPosition;
                    String string2 = (String)Assertions.checkNotNull(this.formatId);
                    object8 = H263Reader.parseCsdBuffer((H263Reader$CsdBuffer)object8, n16, string2);
                    object6.format((Format)object8);
                    this.hasOutputFormat = object7;
                }
            }
            this.sampleReader.onData(byArray, (int)object3, n12);
            object6 = this.userData;
            if (object6 != null) {
                if (n13 > 0) {
                    ((NalUnitTargetBuffer)object6).appendToNalUnit(byArray, (int)object3, n12);
                } else {
                    n15 = -n13;
                }
                object2 = this.userData;
                object3 = ((NalUnitTargetBuffer)object2).endNalUnit(n15);
                if (object3 != 0) {
                    object2 = this.userData;
                    Object object9 = ((NalUnitTargetBuffer)object2).nalData;
                    object3 = ((NalUnitTargetBuffer)object2).nalLength;
                    object3 = NalUnitUtil.unescapeStream((byte[])object9, object3);
                    object9 = (ParsableByteArray)Util.castNonNull(this.userDataParsable);
                    object6 = this.userData.nalData;
                    ((ParsableByteArray)object9).reset((byte[])object6, (int)object3);
                    object2 = (UserDataReader)Util.castNonNull(this.userDataReader);
                    l12 = this.pesTimeUs;
                    parsableByteArray = this.userDataParsable;
                    ((UserDataReader)object2).consume(l12, parsableByteArray);
                }
                if (n11 == (object3 = 178) && (object3 = (Object)(object2 = (Object)((ParsableByteArray)object).getData())[n13 = n12 + 2]) == object7) {
                    object2 = this.userData;
                    ((NalUnitTargetBuffer)object2).startNalUnit(n11);
                }
            }
            object3 = n10 - n12;
            l12 = this.totalBytesWritten;
            long l13 = object3;
            object5 = this.sampleReader;
            object7 = this.hasOutputFormat;
            ((H263Reader$SampleReader)object5).onDataEnd(l12 -= l13, (int)object3, (boolean)object7);
            object2 = this.sampleReader;
            l12 = this.pesTimeUs;
            ((H263Reader$SampleReader)object2).onStartCode(n11, l12);
            object3 = object4;
        }
    }

    public void createTracks(ExtractorOutput extractorOutput, TsPayloadReader$TrackIdGenerator tsPayloadReader$TrackIdGenerator) {
        H263Reader$SampleReader h263Reader$SampleReader;
        tsPayloadReader$TrackIdGenerator.generateNewId();
        Object object = tsPayloadReader$TrackIdGenerator.getFormatId();
        this.formatId = object;
        int n10 = tsPayloadReader$TrackIdGenerator.getTrackId();
        int n11 = 2;
        this.output = object = extractorOutput.track(n10, n11);
        this.sampleReader = h263Reader$SampleReader = new H263Reader$SampleReader((TrackOutput)object);
        object = this.userDataReader;
        if (object != null) {
            ((UserDataReader)object).createTracks(extractorOutput, tsPayloadReader$TrackIdGenerator);
        }
    }

    public void packetFinished() {
    }

    public void packetStarted(long l10, int n10) {
        this.pesTimeUs = l10;
    }

    public void seek() {
        NalUnitUtil.clearPrefixFlags(this.prefixFlags);
        this.csdBuffer.reset();
        Object object = this.sampleReader;
        if (object != null) {
            ((H263Reader$SampleReader)object).reset();
        }
        if ((object = this.userData) != null) {
            ((NalUnitTargetBuffer)object).reset();
        }
        this.totalBytesWritten = 0L;
    }
}

