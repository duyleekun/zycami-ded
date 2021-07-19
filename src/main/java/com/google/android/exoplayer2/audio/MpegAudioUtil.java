/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.audio;

public final class MpegAudioUtil {
    private static final int[] BITRATE_V1_L1;
    private static final int[] BITRATE_V1_L2;
    private static final int[] BITRATE_V1_L3;
    private static final int[] BITRATE_V2;
    private static final int[] BITRATE_V2_L1;
    public static final int MAX_FRAME_SIZE_BYTES = 4096;
    public static final int MAX_RATE_BYTES_PER_SECOND = 40000;
    private static final String[] MIME_TYPE_BY_LAYER;
    private static final int SAMPLES_PER_FRAME_L1 = 384;
    private static final int SAMPLES_PER_FRAME_L2 = 1152;
    private static final int SAMPLES_PER_FRAME_L3_V1 = 1152;
    private static final int SAMPLES_PER_FRAME_L3_V2 = 576;
    private static final int[] SAMPLING_RATE_V1;

    static {
        int[] nArray;
        int[] nArray2;
        MIME_TYPE_BY_LAYER = new String[]{"audio/mpeg-L1", "audio/mpeg-L2", "audio/mpeg"};
        int[] nArray3 = nArray2 = new int[3];
        nArray2[0] = 44100;
        nArray3[1] = 48000;
        nArray3[2] = 32000;
        SAMPLING_RATE_V1 = nArray2;
        int n10 = 14;
        int[] nArray4 = nArray = new int[n10];
        int[] nArray5 = nArray;
        nArray4[0] = 32000;
        nArray5[1] = 64000;
        nArray4[2] = 96000;
        nArray5[3] = 128000;
        nArray4[4] = 160000;
        nArray5[5] = 192000;
        nArray4[6] = 224000;
        nArray5[7] = 256000;
        nArray4[8] = 288000;
        nArray5[9] = 320000;
        nArray4[10] = 352000;
        nArray5[11] = 384000;
        nArray4[12] = 416000;
        nArray5[13] = 448000;
        BITRATE_V1_L1 = nArray;
        int[] nArray6 = nArray = new int[n10];
        int[] nArray7 = nArray;
        nArray6[0] = 32000;
        nArray7[1] = 48000;
        nArray6[2] = 56000;
        nArray7[3] = 64000;
        nArray6[4] = 80000;
        nArray7[5] = 96000;
        nArray6[6] = 112000;
        nArray7[7] = 128000;
        nArray6[8] = 144000;
        nArray7[9] = 160000;
        nArray6[10] = 176000;
        nArray7[11] = 192000;
        nArray6[12] = 224000;
        nArray7[13] = 256000;
        BITRATE_V2_L1 = nArray;
        int[] nArray8 = nArray = new int[n10];
        int[] nArray9 = nArray;
        nArray8[0] = 32000;
        nArray9[1] = 48000;
        nArray8[2] = 56000;
        nArray9[3] = 64000;
        nArray8[4] = 80000;
        nArray9[5] = 96000;
        nArray8[6] = 112000;
        nArray9[7] = 128000;
        nArray8[8] = 160000;
        nArray9[9] = 192000;
        nArray8[10] = 224000;
        nArray9[11] = 256000;
        nArray8[12] = 320000;
        nArray9[13] = 384000;
        BITRATE_V1_L2 = nArray;
        int[] nArray10 = nArray = new int[n10];
        int[] nArray11 = nArray;
        nArray10[0] = 32000;
        nArray11[1] = 40000;
        nArray10[2] = 48000;
        nArray11[3] = 56000;
        nArray10[4] = 64000;
        nArray11[5] = 80000;
        nArray10[6] = 96000;
        nArray11[7] = 112000;
        nArray10[8] = 128000;
        nArray11[9] = 160000;
        nArray10[10] = 192000;
        nArray11[11] = 224000;
        nArray10[12] = 256000;
        nArray11[13] = 320000;
        BITRATE_V1_L3 = nArray;
        int[] nArray12 = nArray2 = new int[n10];
        int[] nArray13 = nArray2;
        nArray12[0] = 8000;
        nArray13[1] = 16000;
        nArray12[2] = 24000;
        nArray13[3] = 32000;
        nArray12[4] = 40000;
        nArray13[5] = 48000;
        nArray12[6] = 56000;
        nArray13[7] = 64000;
        nArray12[8] = 80000;
        nArray13[9] = 96000;
        nArray12[10] = 112000;
        nArray13[11] = 128000;
        nArray12[12] = 144000;
        nArray13[13] = 160000;
        BITRATE_V2 = nArray2;
    }

    private MpegAudioUtil() {
    }

    public static /* synthetic */ boolean access$000(int n10) {
        return MpegAudioUtil.isMagicPresent(n10);
    }

    public static /* synthetic */ String[] access$100() {
        return MIME_TYPE_BY_LAYER;
    }

    public static /* synthetic */ int[] access$200() {
        return SAMPLING_RATE_V1;
    }

    public static /* synthetic */ int access$300(int n10, int n11) {
        return MpegAudioUtil.getFrameSizeInSamples(n10, n11);
    }

    public static /* synthetic */ int[] access$400() {
        return BITRATE_V1_L1;
    }

    public static /* synthetic */ int[] access$500() {
        return BITRATE_V2_L1;
    }

    public static /* synthetic */ int[] access$600() {
        return BITRATE_V1_L2;
    }

    public static /* synthetic */ int[] access$700() {
        return BITRATE_V1_L3;
    }

    public static /* synthetic */ int[] access$800() {
        return BITRATE_V2;
    }

    public static int getFrameSize(int n10) {
        int n11 = MpegAudioUtil.isMagicPresent(n10);
        int n12 = -1;
        if (n11 == 0) {
            return n12;
        }
        n11 = n10 >>> 19;
        int n13 = 3;
        int n14 = 1;
        if ((n11 &= n13) == n14) {
            return n12;
        }
        int n15 = n10 >>> 17 & n13;
        if (n15 == 0) {
            return n12;
        }
        int n16 = n10 >>> 12;
        int n17 = 15;
        if ((n16 &= n17) != 0 && n16 != n17) {
            n17 = n10 >>> 10 & n13;
            if (n17 == n13) {
                return n12;
            }
            int[] nArray = SAMPLING_RATE_V1;
            n12 = nArray[n17];
            n17 = 2;
            if (n11 == n17) {
                n12 /= 2;
            } else if (n11 == 0) {
                n12 /= 4;
            }
            n10 = n10 >>> 9 & n14;
            if (n15 == n13) {
                if (n11 == n13) {
                    int[] nArray2 = BITRATE_V1_L1;
                    n11 = nArray2[n16 -= n14];
                } else {
                    int[] nArray3 = BITRATE_V2_L1;
                    n11 = nArray3[n16 -= n14];
                }
                return (n11 * 12 / n12 + n10) * 4;
            }
            if (n11 == n13) {
                if (n15 == n17) {
                    int[] nArray4 = BITRATE_V1_L2;
                    n16 -= n14;
                    n16 = nArray4[n16];
                } else {
                    int[] nArray5 = BITRATE_V1_L3;
                    n16 -= n14;
                    n16 = nArray5[n16];
                }
            } else {
                int[] nArray6 = BITRATE_V2;
                n16 -= n14;
                n16 = nArray6[n16];
            }
            n17 = 144;
            if (n11 == n13) {
                return n16 * n17 / n12 + n10;
            }
            if (n15 == n14) {
                n17 = 72;
            }
            return n17 * n16 / n12 + n10;
        }
        return n12;
    }

    private static int getFrameSizeInSamples(int n10, int n11) {
        int n12 = 1;
        int n13 = 1152;
        int n14 = 3;
        if (n11 != n12) {
            n10 = 2;
            if (n11 != n10) {
                if (n11 == n14) {
                    return 384;
                }
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
                throw illegalArgumentException;
            }
            return n13;
        }
        if (n10 != n14) {
            n13 = 576;
        }
        return n13;
    }

    private static boolean isMagicPresent(int n10) {
        int n11 = -2097152;
        n10 = (n10 &= n11) == n11 ? 1 : 0;
        return n10 != 0;
    }

    public static int parseMpegAudioFrameSampleCount(int n10) {
        int n11 = MpegAudioUtil.isMagicPresent(n10);
        int n12 = -1;
        if (n11 == 0) {
            return n12;
        }
        n11 = n10 >>> 19;
        int n13 = 3;
        int n14 = 1;
        if ((n11 &= n13) == n14) {
            return n12;
        }
        n14 = n10 >>> 17 & n13;
        if (n14 == 0) {
            return n12;
        }
        int n15 = n10 >>> 12;
        int n16 = 15;
        n10 = n10 >>> 10 & n13;
        if ((n15 &= n16) != 0 && n15 != n16 && n10 != n13) {
            return MpegAudioUtil.getFrameSizeInSamples(n11, n14);
        }
        return n12;
    }
}

