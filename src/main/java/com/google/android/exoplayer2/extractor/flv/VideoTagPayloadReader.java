/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format$Builder;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.flv.TagPayloadReader;
import com.google.android.exoplayer2.extractor.flv.TagPayloadReader$UnsupportedFormatException;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.video.AvcConfig;
import java.util.List;

public final class VideoTagPayloadReader
extends TagPayloadReader {
    private static final int AVC_PACKET_TYPE_AVC_NALU = 1;
    private static final int AVC_PACKET_TYPE_SEQUENCE_HEADER = 0;
    private static final int VIDEO_CODEC_AVC = 7;
    private static final int VIDEO_FRAME_KEYFRAME = 1;
    private static final int VIDEO_FRAME_VIDEO_INFO = 5;
    private int frameType;
    private boolean hasOutputFormat;
    private boolean hasOutputKeyframe;
    private final ParsableByteArray nalLength;
    private final ParsableByteArray nalStartCode;
    private int nalUnitLengthFieldLength;

    public VideoTagPayloadReader(TrackOutput object) {
        super((TrackOutput)object);
        byte[] byArray = NalUnitUtil.NAL_START_CODE;
        this.nalStartCode = object = new ParsableByteArray(byArray);
        this.nalLength = object = new ParsableByteArray(4);
    }

    public boolean parseHeader(ParsableByteArray object) {
        int n10 = ((ParsableByteArray)object).readUnsignedByte();
        int n11 = n10 >> 4 & 0xF;
        int n12 = 7;
        if ((n10 &= 0xF) == n12) {
            this.frameType = n11;
            n10 = 5;
            if (n11 != n10) {
                n10 = 1;
            } else {
                n10 = 0;
                object = null;
            }
            return n10 != 0;
        }
        StringBuilder stringBuilder = new StringBuilder(39);
        stringBuilder.append("Video format not supported: ");
        stringBuilder.append(n10);
        object = stringBuilder.toString();
        TagPayloadReader$UnsupportedFormatException tagPayloadReader$UnsupportedFormatException = new TagPayloadReader$UnsupportedFormatException((String)object);
        throw tagPayloadReader$UnsupportedFormatException;
    }

    public boolean parsePayload(ParsableByteArray object, long l10) {
        boolean bl2;
        int bl22 = ((ParsableByteArray)object).readUnsignedByte();
        int n10 = ((ParsableByteArray)object).readInt24();
        long l11 = n10;
        long l12 = 1000L;
        long l13 = l10 + (l11 *= l12);
        int n11 = 1;
        if (bl22 == 0 && (n10 = (int)(this.hasOutputFormat ? 1 : 0)) == 0) {
            int n12;
            Object object2 = new byte[((ParsableByteArray)object).bytesLeft()];
            Object object3 = new ParsableByteArray((byte[])object2);
            object2 = ((ParsableByteArray)object3).getData();
            int n13 = ((ParsableByteArray)object).bytesLeft();
            ((ParsableByteArray)object).readBytes((byte[])object2, 0, n13);
            object = AvcConfig.parse((ParsableByteArray)object3);
            this.nalUnitLengthFieldLength = n12 = ((AvcConfig)object).nalUnitLengthFieldLength;
            object3 = new Format$Builder();
            object3 = ((Format$Builder)object3).setSampleMimeType("video/avc");
            object2 = ((AvcConfig)object).codecs;
            object3 = ((Format$Builder)object3).setCodecs((String)object2);
            n10 = ((AvcConfig)object).width;
            object3 = ((Format$Builder)object3).setWidth(n10);
            n10 = ((AvcConfig)object).height;
            object3 = ((Format$Builder)object3).setHeight(n10);
            float f10 = ((AvcConfig)object).pixelWidthAspectRatio;
            object3 = ((Format$Builder)object3).setPixelWidthHeightRatio(f10);
            object = ((AvcConfig)object).initializationData;
            object = ((Format$Builder)object3).setInitializationData((List)object).build();
            this.output.format((Format)object);
            this.hasOutputFormat = n11;
            return false;
        }
        if (bl22 == n11 && (bl2 = this.hasOutputFormat)) {
            int n14;
            int n15 = this.frameType;
            int n16 = n15 == n11 ? n11 : 0;
            boolean bl3 = this.hasOutputKeyframe;
            if (!bl3 && n16 == 0) {
                return false;
            }
            byte[] byArray = this.nalLength.getData();
            byArray[0] = 0;
            byArray[n11] = 0;
            byArray[2] = 0;
            int n17 = this.nalUnitLengthFieldLength;
            n10 = 4;
            float f11 = 5.6E-45f;
            int n18 = 4 - n17;
            int n19 = 0;
            while ((n14 = ((ParsableByteArray)object).bytesLeft()) > 0) {
                Object object4 = this.nalLength.getData();
                int n20 = this.nalUnitLengthFieldLength;
                ((ParsableByteArray)object).readBytes((byte[])object4, n18, n20);
                this.nalLength.setPosition(0);
                object4 = this.nalLength;
                n14 = ((ParsableByteArray)object4).readUnsignedIntToInt();
                this.nalStartCode.setPosition(0);
                TrackOutput trackOutput = this.output;
                ParsableByteArray parsableByteArray = this.nalStartCode;
                trackOutput.sampleData(parsableByteArray, n10);
                n19 += 4;
                trackOutput = this.output;
                trackOutput.sampleData((ParsableByteArray)object, n14);
                n19 += n14;
            }
            this.output.sampleMetadata(l13, n16, n19, 0, null);
            this.hasOutputKeyframe = n11;
            return n11 != 0;
        }
        return false;
    }

    public void seek() {
        this.hasOutputKeyframe = false;
    }
}

