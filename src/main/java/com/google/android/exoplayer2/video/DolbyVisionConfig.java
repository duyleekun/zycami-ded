/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.util.ParsableByteArray;

public final class DolbyVisionConfig {
    public final String codecs;
    public final int level;
    public final int profile;

    private DolbyVisionConfig(int n10, int n11, String string2) {
        this.profile = n10;
        this.level = n11;
        this.codecs = string2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static DolbyVisionConfig parse(ParsableByteArray parsableByteArray) {
        String string2;
        parsableByteArray.skipBytes(2);
        int n10 = parsableByteArray.readUnsignedByte();
        int n11 = n10 >> 1;
        n10 &= 1;
        int n12 = 5;
        int n13 = parsableByteArray.readUnsignedByte() >> 3 & 0x1F | (n10 <<= n12);
        n10 = 4;
        if (n11 != n10 && n11 != n12 && n11 != (n10 = 7)) {
            n10 = 8;
            if (n11 == n10) {
                string2 = "hev1";
            } else {
                n10 = 9;
                if (n11 != n10) return null;
                string2 = "avc3";
            }
        } else {
            string2 = "dvhe";
        }
        n12 = 10;
        String string3 = ".0";
        String string4 = n13 < n12 ? string3 : ".";
        int n14 = string2.length() + 24;
        int n15 = string4.length();
        StringBuilder stringBuilder = new StringBuilder(n14 += n15);
        stringBuilder.append(string2);
        stringBuilder.append(string3);
        stringBuilder.append(n11);
        stringBuilder.append(string4);
        stringBuilder.append(n13);
        string2 = stringBuilder.toString();
        return new DolbyVisionConfig(n11, n13, string2);
    }
}

