/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format$Builder;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.audio.AacUtil$Config;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.flv.TagPayloadReader;
import com.google.android.exoplayer2.extractor.flv.TagPayloadReader$UnsupportedFormatException;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Collections;
import java.util.List;

public final class AudioTagPayloadReader
extends TagPayloadReader {
    private static final int AAC_PACKET_TYPE_AAC_RAW = 1;
    private static final int AAC_PACKET_TYPE_SEQUENCE_HEADER = 0;
    private static final int AUDIO_FORMAT_AAC = 10;
    private static final int AUDIO_FORMAT_ALAW = 7;
    private static final int AUDIO_FORMAT_MP3 = 2;
    private static final int AUDIO_FORMAT_ULAW = 8;
    private static final int[] AUDIO_SAMPLING_RATE_TABLE;
    private int audioFormat;
    private boolean hasOutputFormat;
    private boolean hasParsedAudioDataHeader;

    static {
        int[] nArray;
        int[] nArray2 = nArray = new int[4];
        int[] nArray3 = nArray;
        nArray2[0] = 5512;
        nArray3[1] = 11025;
        nArray2[2] = 22050;
        nArray3[3] = 44100;
        AUDIO_SAMPLING_RATE_TABLE = nArray;
    }

    public AudioTagPayloadReader(TrackOutput trackOutput) {
        super(trackOutput);
    }

    public boolean parseHeader(ParsableByteArray object) {
        int n10 = this.hasParsedAudioDataHeader;
        int n11 = 1;
        if (n10 == 0) {
            int n12 = ((ParsableByteArray)object).readUnsignedByte();
            this.audioFormat = n10 = n12 >> 4 & 0xF;
            int n13 = 2;
            if (n10 == n13) {
                n12 = n12 >> n13 & 3;
                n12 = AUDIO_SAMPLING_RATE_TABLE[n12];
                Object object2 = new Format$Builder();
                String string2 = "audio/mpeg";
                object = ((Format$Builder)object2).setSampleMimeType(string2).setChannelCount(n11).setSampleRate(n12).build();
                object2 = this.output;
                object2.format((Format)object);
                this.hasOutputFormat = n11;
            } else {
                n12 = 7;
                if (n10 != n12 && n10 != (n13 = 8)) {
                    n12 = 10;
                    if (n10 != n12) {
                        n10 = this.audioFormat;
                        StringBuilder stringBuilder = new StringBuilder(39);
                        stringBuilder.append("Audio format not supported: ");
                        stringBuilder.append(n10);
                        String string3 = stringBuilder.toString();
                        object = new TagPayloadReader$UnsupportedFormatException(string3);
                        throw object;
                    }
                } else {
                    object = n10 == n12 ? "audio/g711-alaw" : "audio/g711-mlaw";
                    Object object3 = new Format$Builder();
                    object = ((Format$Builder)object3).setSampleMimeType((String)object).setChannelCount(n11);
                    n10 = 8000;
                    object = ((Format$Builder)object).setSampleRate(n10).build();
                    object3 = this.output;
                    object3.format((Format)object);
                    this.hasOutputFormat = n11;
                }
            }
            this.hasParsedAudioDataHeader = n11;
        } else {
            ((ParsableByteArray)object).skipBytes(n11);
        }
        return n11 != 0;
    }

    public boolean parsePayload(ParsableByteArray object, long l10) {
        int n10;
        int n11 = this.audioFormat;
        int n12 = 1;
        int n13 = 2;
        if (n11 == n13) {
            int n14 = ((ParsableByteArray)object).bytesLeft();
            this.output.sampleData((ParsableByteArray)object, n14);
            this.output.sampleMetadata(l10, 1, n14, 0, null);
            return n12 != 0;
        }
        n11 = ((ParsableByteArray)object).readUnsignedByte();
        n13 = 0;
        if (n11 == 0 && (n10 = this.hasOutputFormat) == 0) {
            int n15 = ((ParsableByteArray)object).bytesLeft();
            byte[] byArray = new byte[n15];
            ((ParsableByteArray)object).readBytes(byArray, 0, n15);
            object = AacUtil.parseAudioSpecificConfig(byArray);
            Object object2 = new Format$Builder();
            object2 = ((Format$Builder)object2).setSampleMimeType("audio/mp4a-latm");
            String string2 = ((AacUtil$Config)object).codecs;
            object2 = ((Format$Builder)object2).setCodecs(string2);
            n11 = ((AacUtil$Config)object).channelCount;
            object2 = ((Format$Builder)object2).setChannelCount(n11);
            int n16 = ((AacUtil$Config)object).sampleRateHz;
            object = ((Format$Builder)object2).setSampleRate(n16);
            object2 = Collections.singletonList(byArray);
            object = ((Format$Builder)object).setInitializationData((List)object2).build();
            this.output.format((Format)object);
            this.hasOutputFormat = n12;
            return false;
        }
        n10 = this.audioFormat;
        int n17 = 10;
        if (n10 == n17 && n11 != n12) {
            return false;
        }
        int n18 = ((ParsableByteArray)object).bytesLeft();
        this.output.sampleData((ParsableByteArray)object, n18);
        this.output.sampleMetadata(l10, 1, n18, 0, null);
        return n12 != 0;
    }

    public void seek() {
    }
}

