/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format$Builder;
import com.google.android.exoplayer2.audio.OpusUtil;
import com.google.android.exoplayer2.extractor.ogg.StreamReader;
import com.google.android.exoplayer2.extractor.ogg.StreamReader$SetupData;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Arrays;
import java.util.List;

public final class OpusReader
extends StreamReader {
    private static final int OPUS_CODE = 1332770163;
    private static final byte[] OPUS_SIGNATURE;
    private boolean headerRead;

    static {
        byte[] byArray;
        byte[] byArray2 = byArray = new byte[8];
        byte[] byArray3 = byArray;
        byArray2[0] = 79;
        byArray3[1] = 112;
        byArray2[2] = 117;
        byArray3[3] = 115;
        byArray2[4] = 72;
        byArray3[5] = 101;
        byArray2[6] = 97;
        byArray3[7] = 100;
        OPUS_SIGNATURE = byArray;
    }

    private long getPacketDurationUs(byte[] byArray) {
        int n10;
        int n11 = byArray[0] & 0xFF;
        int n12 = n11 & 3;
        int n13 = 2;
        int n14 = 1;
        if (n12 != 0) {
            if (n12 != n14 && n12 != n13) {
                n10 = byArray[n14];
                n13 = n10 & 0x3F;
            }
        } else {
            n13 = n14;
        }
        n10 = 3;
        n12 = (n11 >>= n10) & 3;
        int n15 = 16;
        if (n11 >= n15) {
            n10 = 2500 << n12;
        } else {
            n15 = 12;
            int n16 = 10000;
            if (n11 >= n15) {
                n10 = n12 & 1;
                n10 = n16 << n10;
            } else {
                n10 = n12 == n10 ? 60000 : n16 << n12;
            }
        }
        long l10 = n13;
        long l11 = n10;
        return l10 * l11;
    }

    public static boolean verifyBitstreamType(ParsableByteArray parsableByteArray) {
        byte[] byArray;
        int n10;
        int n11 = parsableByteArray.bytesLeft();
        if (n11 < (n10 = (byArray = OPUS_SIGNATURE).length)) {
            return false;
        }
        byte[] byArray2 = new byte[byArray.length];
        n10 = byArray.length;
        parsableByteArray.readBytes(byArray2, 0, n10);
        return Arrays.equals(byArray2, byArray);
    }

    public long preparePayload(ParsableByteArray object) {
        object = ((ParsableByteArray)object).getData();
        long l10 = this.getPacketDurationUs((byte[])object);
        return this.convertTimeToGranule(l10);
    }

    public boolean readHeaders(ParsableByteArray object, long l10, StreamReader$SetupData streamReader$SetupData) {
        int n10 = this.headerRead;
        boolean bl2 = true;
        if (n10 == 0) {
            byte[] byArray = ((ParsableByteArray)object).getData();
            int n11 = ((ParsableByteArray)object).limit();
            object = Arrays.copyOf(byArray, n11);
            n10 = OpusUtil.getChannelCount((byte[])object);
            object = OpusUtil.buildInitializationData((byte[])object);
            Format$Builder format$Builder = new Format$Builder();
            streamReader$SetupData.format = object = format$Builder.setSampleMimeType("audio/opus").setChannelCount(n10).setSampleRate(48000).setInitializationData((List)object).build();
            this.headerRead = bl2;
            return bl2;
        }
        Format format = streamReader$SetupData.format;
        Assertions.checkNotNull(format);
        n10 = ((ParsableByteArray)object).readInt();
        int n12 = 1332770163;
        Object var9_10 = null;
        if (n10 != n12) {
            bl2 = false;
        }
        ((ParsableByteArray)object).setPosition(0);
        return bl2;
    }

    public void reset(boolean bl2) {
        super.reset(bl2);
        if (bl2) {
            bl2 = false;
            this.headerRead = false;
        }
    }
}

