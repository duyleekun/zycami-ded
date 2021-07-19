/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.ParsableNalUnitBitArray;
import java.util.Collections;
import java.util.List;

public final class HevcConfig {
    private static final int SPS_NAL_UNIT_TYPE = 33;
    public final String codecs;
    public final List initializationData;
    public final int nalUnitLengthFieldLength;

    private HevcConfig(List list, int n10, String string2) {
        this.initializationData = list;
        this.nalUnitLengthFieldLength = n10;
        this.codecs = string2;
    }

    public static HevcConfig parse(ParsableByteArray parsableByteArray) {
        int n10;
        int n11;
        int n12;
        int n13;
        Object object = parsableByteArray;
        int n14 = 21;
        parsableByteArray.skipBytes(n14);
        n14 = parsableByteArray.readUnsignedByte() & 3;
        int n15 = parsableByteArray.readUnsignedByte();
        int n16 = parsableByteArray.getPosition();
        int n17 = 0;
        Object object2 = null;
        int n18 = 0;
        while (true) {
            n13 = 1;
            if (n17 >= n15) break;
            ((ParsableByteArray)object).skipBytes(n13);
            n13 = parsableByteArray.readUnsignedShort();
            for (n12 = 0; n12 < n13; ++n12) {
                n11 = parsableByteArray.readUnsignedShort();
                n10 = n11 + 4;
                n18 += n10;
                ((ParsableByteArray)object).skipBytes(n11);
                continue;
            }
            ++n17;
        }
        ((ParsableByteArray)object).setPosition(n16);
        byte[] byArray = new byte[n18];
        n10 = 0;
        n11 = 0;
        Object object3 = null;
        for (n12 = 0; n12 < n15; ++n12) {
            int n19 = parsableByteArray.readUnsignedByte() & 0x7F;
            int n20 = parsableByteArray.readUnsignedShort();
            for (int i10 = 0; i10 < n20; ++i10) {
                int n21;
                block29: {
                    n21 = parsableByteArray.readUnsignedShort();
                    byte[] byArray2 = NalUnitUtil.NAL_START_CODE;
                    n17 = byArray2.length;
                    System.arraycopy(byArray2, 0, byArray, n10, n17);
                    n17 = byArray2.length;
                    n10 += n17;
                    object2 = parsableByteArray.getData();
                    int n22 = parsableByteArray.getPosition();
                    System.arraycopy(object2, n22, byArray, n10, n21);
                    n17 = 33;
                    if (n19 != n17 || i10 != 0) break block29;
                    n11 = n10 + n21;
                    object2 = new ParsableNalUnitBitArray(byArray, n10, n11);
                    object3 = object2 = CodecSpecificDataUtil.buildHevcCodecStringFromSps((ParsableNalUnitBitArray)object2);
                }
                n10 += n21;
                ((ParsableByteArray)object).skipBytes(n21);
                continue;
            }
        }
        if (n18 == 0) {
            n17 = 0;
            object2 = null;
        } else {
            object2 = Collections.singletonList(byArray);
        }
        n14 += n13;
        try {
            object = new HevcConfig((List)object2, n14, (String)object3);
            return object;
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            ParserException parserException = new ParserException("Error parsing HEVC config", arrayIndexOutOfBoundsException);
            throw parserException;
        }
    }
}

