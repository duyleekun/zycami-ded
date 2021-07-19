/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;

public class Utf8$DecodeUtil {
    private Utf8$DecodeUtil() {
    }

    public static /* synthetic */ void access$1000(byte by2, byte by3, byte by4, byte by5, char[] cArray, int n10) {
        Utf8$DecodeUtil.handleFourBytes(by2, by3, by4, by5, cArray, n10);
    }

    public static /* synthetic */ boolean access$400(byte by2) {
        return Utf8$DecodeUtil.isOneByte(by2);
    }

    public static /* synthetic */ void access$500(byte by2, char[] cArray, int n10) {
        Utf8$DecodeUtil.handleOneByte(by2, cArray, n10);
    }

    public static /* synthetic */ boolean access$600(byte by2) {
        return Utf8$DecodeUtil.isTwoBytes(by2);
    }

    public static /* synthetic */ void access$700(byte by2, byte by3, char[] cArray, int n10) {
        Utf8$DecodeUtil.handleTwoBytes(by2, by3, cArray, n10);
    }

    public static /* synthetic */ boolean access$800(byte by2) {
        return Utf8$DecodeUtil.isThreeBytes(by2);
    }

    public static /* synthetic */ void access$900(byte by2, byte by3, byte by4, char[] cArray, int n10) {
        Utf8$DecodeUtil.handleThreeBytes(by2, by3, by4, cArray, n10);
    }

    private static void handleFourBytes(byte by2, byte by3, byte by4, byte by5, char[] cArray, int n10) {
        int n11 = Utf8$DecodeUtil.isNotTrailingByte(by3);
        if (n11 == 0) {
            n11 = by2 << 28;
            int n12 = by3 + 112;
            if ((n11 = n11 + n12 >> 30) == 0 && (n11 = (int)(Utf8$DecodeUtil.isNotTrailingByte(by4) ? 1 : 0)) == 0 && (n11 = (int)(Utf8$DecodeUtil.isNotTrailingByte(by5) ? 1 : 0)) == 0) {
                by2 = (byte)((by2 & 7) << 18);
                by3 = (byte)(Utf8$DecodeUtil.trailingByteValue(by3) << 12);
                by2 = (byte)(by2 | by3);
                by3 = (byte)(Utf8$DecodeUtil.trailingByteValue(by4) << 6);
                by2 = (byte)(by2 | by3);
                by3 = (byte)Utf8$DecodeUtil.trailingByteValue(by5);
                by2 = (byte)(by2 | by3);
                by3 = (byte)Utf8$DecodeUtil.highSurrogate(by2);
                cArray[n10] = (char)by3;
                by2 = (byte)Utf8$DecodeUtil.lowSurrogate(by2);
                cArray[++n10] = (char)by2;
                return;
            }
        }
        throw InvalidProtocolBufferException.invalidUtf8();
    }

    private static void handleOneByte(byte by2, char[] cArray, int n10) {
        by2 = by2;
        cArray[n10] = (char)by2;
    }

    private static void handleThreeBytes(byte n10, byte by2, byte by3, char[] cArray, int n11) {
        int n12 = Utf8$DecodeUtil.isNotTrailingByte(by2);
        if (n12 == 0) {
            n12 = -32;
            byte by4 = -96;
            if (!(n10 == n12 && by2 < by4 || n10 == (n12 = -19) && by2 >= by4 || (n12 = (int)(Utf8$DecodeUtil.isNotTrailingByte(by3) ? 1 : 0)) != 0)) {
                n10 = (n10 & 0xF) << 12;
                by2 = (byte)(Utf8$DecodeUtil.trailingByteValue(by2) << 6);
                n10 |= by2;
                by2 = (byte)Utf8$DecodeUtil.trailingByteValue(by3);
                cArray[n11] = n10 = (int)((char)(n10 | by2));
                return;
            }
        }
        throw InvalidProtocolBufferException.invalidUtf8();
    }

    private static void handleTwoBytes(byte by2, byte by3, char[] cArray, int n10) {
        byte by4 = -62;
        if (by2 >= by4 && (by4 = (byte)(Utf8$DecodeUtil.isNotTrailingByte(by3) ? 1 : 0)) == 0) {
            by2 = (byte)((by2 & 0x1F) << 6);
            by3 = (byte)Utf8$DecodeUtil.trailingByteValue(by3);
            by2 = (byte)(by2 | by3);
            cArray[n10] = (char)by2;
            return;
        }
        throw InvalidProtocolBufferException.invalidUtf8();
    }

    private static char highSurrogate(int n10) {
        return (char)((n10 >>> 10) + 55232);
    }

    private static boolean isNotTrailingByte(byte by2) {
        byte by3 = -65;
        by2 = by2 > by3 ? (byte)1 : 0;
        return by2 != 0;
    }

    private static boolean isOneByte(byte by2) {
        by2 = by2 >= 0 ? (byte)1 : 0;
        return by2 != 0;
    }

    private static boolean isThreeBytes(byte by2) {
        byte by3 = -16;
        by2 = by2 < by3 ? (byte)1 : 0;
        return by2 != 0;
    }

    private static boolean isTwoBytes(byte by2) {
        byte by3 = -32;
        by2 = by2 < by3 ? (byte)1 : 0;
        return by2 != 0;
    }

    private static char lowSurrogate(int n10) {
        return (char)((n10 & 0x3FF) + 56320);
    }

    private static int trailingByteValue(byte by2) {
        return by2 & 0x3F;
    }
}

