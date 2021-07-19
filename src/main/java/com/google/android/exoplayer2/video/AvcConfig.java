/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.NalUnitUtil$SpsData;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.List;

public final class AvcConfig {
    public final String codecs;
    public final int height;
    public final List initializationData;
    public final int nalUnitLengthFieldLength;
    public final float pixelWidthAspectRatio;
    public final int width;

    private AvcConfig(List list, int n10, int n11, int n12, float f10, String string2) {
        this.initializationData = list;
        this.nalUnitLengthFieldLength = n10;
        this.width = n11;
        this.height = n12;
        this.pixelWidthAspectRatio = f10;
        this.codecs = string2;
    }

    private static byte[] buildNalUnitForChild(ParsableByteArray parsableByteArray) {
        int n10 = parsableByteArray.readUnsignedShort();
        int n11 = parsableByteArray.getPosition();
        parsableByteArray.skipBytes(n10);
        return CodecSpecificDataUtil.buildNalUnit(parsableByteArray.getData(), n11, n10);
    }

    public static AvcConfig parse(ParsableByteArray object) {
        block30: {
            float f10;
            Object object2;
            int n10;
            Object object3;
            int n11;
            byte[] byArray;
            int n12;
            int n13 = 4;
            ((ParsableByteArray)object).skipBytes(n13);
            n13 = ((ParsableByteArray)object).readUnsignedByte();
            int n14 = 3;
            int n15 = (n13 &= n14) + 1;
            if (n15 == n14) break block30;
            ArrayList<byte[]> arrayList = new ArrayList<byte[]>();
            n13 = ((ParsableByteArray)object).readUnsignedByte() & 0x1F;
            n14 = 0;
            float f11 = 0.0f;
            for (n12 = 0; n12 < n13; ++n12) {
                byArray = AvcConfig.buildNalUnitForChild((ParsableByteArray)object);
                arrayList.add(byArray);
                continue;
            }
            n12 = ((ParsableByteArray)object).readUnsignedByte();
            byArray = null;
            for (n11 = 0; n11 < n12; ++n11) {
                byte[] byArray2 = AvcConfig.buildNalUnitForChild((ParsableByteArray)object);
                arrayList.add(byArray2);
                continue;
            }
            int n16 = 1065353216;
            float f12 = 1.0f;
            n12 = 0;
            f11 = 0.0f;
            n11 = -1;
            if (n13 > 0) {
                object = arrayList.get(0);
                object = (byte[])object;
                object3 = arrayList.get(0);
                object3 = (byte[])object3;
                n16 = ((Object)object).length;
                object = NalUnitUtil.parseSpsNalUnit((byte[])object3, n15, n16);
                n13 = ((NalUnitUtil$SpsData)object).width;
                n14 = ((NalUnitUtil$SpsData)object).height;
                f11 = ((NalUnitUtil$SpsData)object).pixelWidthAspectRatio;
                n11 = ((NalUnitUtil$SpsData)object).profileIdc;
                n10 = ((NalUnitUtil$SpsData)object).constraintsFlagsAndReservedZero2Bits;
                n16 = ((NalUnitUtil$SpsData)object).levelIdc;
                object2 = object = CodecSpecificDataUtil.buildAvcCodecString(n11, n10, n16);
                n11 = n13;
                n10 = n14;
                f10 = f11;
            } else {
                f10 = f12;
                object2 = null;
                n10 = n11;
            }
            try {
                object = new AvcConfig(arrayList, n15, n11, n10, f10, (String)object2);
                return object;
            }
            catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                object3 = new ParserException("Error parsing AVC config", arrayIndexOutOfBoundsException);
                throw object3;
            }
        }
        object = new IllegalStateException();
        throw object;
    }
}

