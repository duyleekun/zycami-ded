/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.Util;

public final class WavUtil {
    public static final int DATA_FOURCC = 1684108385;
    public static final int FMT_FOURCC = 1718449184;
    public static final int RIFF_FOURCC = 1380533830;
    public static final int TYPE_ALAW = 6;
    public static final int TYPE_FLOAT = 3;
    public static final int TYPE_IMA_ADPCM = 17;
    public static final int TYPE_MLAW = 7;
    public static final int TYPE_PCM = 1;
    public static final int TYPE_WAVE_FORMAT_EXTENSIBLE = 65534;
    public static final int WAVE_FOURCC = 1463899717;

    private WavUtil() {
    }

    public static int getPcmEncodingForType(int n10, int n11) {
        int n12 = 1;
        if (n10 != n12) {
            n12 = 3;
            int n13 = 0;
            if (n10 != n12) {
                n12 = (char)-2;
                if (n10 != n12) {
                    return 0;
                }
            } else {
                n10 = 32;
                if (n11 == n10) {
                    n13 = 4;
                }
                return n13;
            }
        }
        return Util.getPcmEncoding(n11);
    }

    public static int getTypeForPcmEncoding(int n10) {
        int n11 = 2;
        if (n10 != n11 && n10 != (n11 = 3)) {
            int n12 = 4;
            if (n10 != n12) {
                n11 = 0x20000000;
                if (n10 != n11 && n10 != (n11 = 0x30000000)) {
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
                    throw illegalArgumentException;
                }
            } else {
                return n11;
            }
        }
        return 1;
    }
}

