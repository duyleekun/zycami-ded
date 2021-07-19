/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Pair
 */
package com.google.android.exoplayer2.util;

import android.util.Pair;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.ParsableNalUnitBitArray;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class CodecSpecificDataUtil {
    private static final String[] HEVC_GENERAL_PROFILE_SPACE_STRINGS;
    private static final byte[] NAL_START_CODE;

    static {
        byte[] byArray;
        byte[] byArray2 = byArray = new byte[4];
        byte[] byArray3 = byArray;
        byArray2[0] = 0;
        byArray3[1] = 0;
        byArray2[2] = 0;
        byArray3[3] = 1;
        NAL_START_CODE = byArray;
        HEVC_GENERAL_PROFILE_SPACE_STRINGS = new String[]{"", "A", "B", "C"};
    }

    private CodecSpecificDataUtil() {
    }

    public static String buildAvcCodecString(int n10, int n11, int n12) {
        Object[] objectArray = new Object[3];
        Integer n13 = n10;
        objectArray[0] = n13;
        n13 = n11;
        objectArray[1] = n13;
        n13 = n12;
        objectArray[2] = n13;
        return String.format("avc1.%02X%02X%02X", objectArray);
    }

    public static List buildCea708InitializationData(boolean bl2) {
        byte[] byArray;
        int n10 = 1;
        if (bl2) {
            byArray = new byte[n10];
            byArray[0] = n10;
        } else {
            byArray = new byte[n10];
            byArray[0] = 0;
        }
        return Collections.singletonList(byArray);
    }

    public static String buildHevcCodecStringFromSps(ParsableNalUnitBitArray object) {
        Object object2;
        int n10;
        int n11;
        ((ParsableNalUnitBitArray)object).skipBits(24);
        int n12 = 2;
        int n13 = ((ParsableNalUnitBitArray)object).readBits(n12);
        boolean bl2 = ((ParsableNalUnitBitArray)object).readBit();
        int n14 = 5;
        int n15 = ((ParsableNalUnitBitArray)object).readBits(n14);
        int n16 = 0;
        int n17 = 0;
        while (true) {
            int n18 = 32;
            n11 = 1;
            if (n16 >= n18) break;
            n18 = (int)(((ParsableNalUnitBitArray)object).readBit() ? 1 : 0);
            if (n18 != 0) {
                n18 = n11 << n16;
                n17 |= n18;
            }
            ++n16;
        }
        n16 = 6;
        int[] nArray = new int[n16];
        int n19 = 0;
        StringBuilder stringBuilder = null;
        while (true) {
            n10 = 8;
            if (n19 >= n16) break;
            nArray[n19] = n10 = ((ParsableNalUnitBitArray)object).readBits(n10);
            ++n19;
        }
        int n20 = ((ParsableNalUnitBitArray)object).readBits(n10);
        Object[] objectArray = new Object[n14];
        String[] stringArray = HEVC_GENERAL_PROFILE_SPACE_STRINGS;
        objectArray[0] = object2 = stringArray[n13];
        objectArray[n11] = object2 = Integer.valueOf(n15);
        objectArray[n12] = object2 = Integer.valueOf(n17);
        n12 = 3;
        n13 = bl2 ? 72 : 76;
        objectArray[n12] = object2 = Character.valueOf((char)n13);
        n12 = 4;
        objectArray[n12] = object = Integer.valueOf(n20);
        object = Util.formatInvariant("hvc1.%s%d.%X.%c%d", objectArray);
        stringBuilder = new StringBuilder((String)object);
        while (n16 > 0) {
            n20 = n16 + -1;
            if ((n20 = nArray[n20]) != 0) break;
            n16 += -1;
        }
        object = null;
        for (n20 = 0; n20 < n16; ++n20) {
            Object object3 = new Object[n11];
            n13 = nArray[n20];
            object3[0] = object2 = Integer.valueOf(n13);
            object2 = ".%02X";
            object3 = String.format((String)object2, object3);
            stringBuilder.append((String)object3);
        }
        return stringBuilder.toString();
    }

    public static byte[] buildNalUnit(byte[] byArray, int n10, int n11) {
        byte[] byArray2 = NAL_START_CODE;
        byte[] byArray3 = new byte[byArray2.length + n11];
        int n12 = byArray2.length;
        System.arraycopy(byArray2, 0, byArray3, 0, n12);
        int n13 = byArray2.length;
        System.arraycopy(byArray, n10, byArray3, n13, n11);
        return byArray3;
    }

    private static int findNalStartCode(byte[] byArray, int n10) {
        int n11 = byArray.length;
        byte[] byArray2 = NAL_START_CODE;
        int n12 = byArray2.length;
        n11 -= n12;
        while (n10 <= n11) {
            n12 = (int)(CodecSpecificDataUtil.isNalStartCode(byArray, n10) ? 1 : 0);
            if (n12 != 0) {
                return n10;
            }
            ++n10;
        }
        return -1;
    }

    private static boolean isNalStartCode(byte[] byArray, int n10) {
        int n11;
        int n12 = byArray.length - n10;
        byte[] byArray2 = NAL_START_CODE;
        int n13 = byArray2.length;
        if (n12 <= n13) {
            return false;
        }
        for (n12 = 0; n12 < (n11 = (byArray2 = NAL_START_CODE).length); ++n12) {
            n11 = n10 + n12;
            n13 = byArray2[n12];
            if ((n11 = byArray[n11]) == n13) continue;
            return false;
        }
        return true;
    }

    public static Pair parseAlacAudioSpecificConfig(byte[] object) {
        Object object2 = new ParsableByteArray((byte[])object);
        ((ParsableByteArray)object2).setPosition(9);
        int n10 = ((ParsableByteArray)object2).readUnsignedByte();
        ((ParsableByteArray)object2).setPosition(20);
        object2 = ((ParsableByteArray)object2).readUnsignedIntToInt();
        object = n10;
        return Pair.create((Object)object2, (Object)object);
    }

    public static boolean parseCea708InitializationData(List object) {
        Object object2;
        byte[] byArray;
        int n10 = object.size();
        int n11 = 0;
        int n12 = 1;
        if (n10 == n12 && (n10 = (byArray = (byte[])object.get(0)).length) == n12 && (object2 = (object = (Object)((byte[])object.get(0)))[0]) == n12) {
            n11 = n12;
        }
        return n11 != 0;
    }

    public static byte[][] splitNalUnits(byte[] byArray) {
        int n10;
        Object object;
        int n11;
        boolean bl2 = CodecSpecificDataUtil.isNalStartCode(byArray, 0);
        if (!bl2) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int n12 = 0;
        byte[][] byArrayArray = null;
        do {
            object = n12;
            arrayList.add((Integer)object);
            object = NAL_START_CODE;
            n11 = ((Object)object).length;
            n12 += n11;
        } while ((n12 = CodecSpecificDataUtil.findNalStartCode(byArray, n12)) != (n11 = -1));
        n12 = arrayList.size();
        byArrayArray = new byte[n12][];
        object = null;
        for (n11 = 0; n11 < (n10 = arrayList.size()); ++n11) {
            Integer n13 = (Integer)arrayList.get(n11);
            n10 = n13;
            int n14 = arrayList.size() + -1;
            if (n11 < n14) {
                n14 = n11 + 1;
                Integer n15 = (Integer)arrayList.get(n14);
                n14 = n15;
            } else {
                n14 = byArray.length;
            }
            byte[] byArray2 = new byte[n14 -= n10];
            System.arraycopy(byArray, n10, byArray2, 0, n14);
            byArrayArray[n11] = byArray2;
        }
        return byArrayArray;
    }
}

