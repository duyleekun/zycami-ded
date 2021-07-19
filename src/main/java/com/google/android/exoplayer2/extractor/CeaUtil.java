/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;

public final class CeaUtil {
    private static final int COUNTRY_CODE = 181;
    private static final int PAYLOAD_TYPE_CC = 4;
    private static final int PROVIDER_CODE_ATSC = 49;
    private static final int PROVIDER_CODE_DIRECTV = 47;
    private static final String TAG = "CeaUtil";
    public static final int USER_DATA_IDENTIFIER_GA94 = 1195456820;
    public static final int USER_DATA_TYPE_CODE_MPEG_CC = 3;

    private CeaUtil() {
    }

    public static void consume(long l10, ParsableByteArray parsableByteArray, TrackOutput[] trackOutputArray) {
        int n10;
        int n11;
        while ((n11 = parsableByteArray.bytesLeft()) > (n10 = 1)) {
            String string2;
            String string3;
            n11 = CeaUtil.readNon255TerminatedValue(parsableByteArray);
            int n12 = CeaUtil.readNon255TerminatedValue(parsableByteArray);
            int n13 = parsableByteArray.getPosition() + n12;
            int n14 = -1;
            if (n12 != n14 && n12 <= (n14 = parsableByteArray.bytesLeft())) {
                n14 = 4;
                if (n11 == n14 && n12 >= (n11 = 8)) {
                    int n15;
                    n11 = parsableByteArray.readUnsignedByte();
                    n12 = parsableByteArray.readUnsignedShort();
                    int n16 = n12 == (n14 = 49) ? parsableByteArray.readInt() : 0;
                    int n17 = parsableByteArray.readUnsignedByte();
                    int n18 = 47;
                    if (n12 == n18) {
                        parsableByteArray.skipBytes(n10);
                    }
                    if (n11 == (n15 = 181) && (n12 == n14 || n12 == n18) && n17 == (n11 = 3)) {
                        n11 = n10;
                    } else {
                        n11 = 0;
                        string3 = null;
                    }
                    if (n12 == n14) {
                        n12 = 1195456820;
                        if (n16 != n12) {
                            n10 = 0;
                            string2 = null;
                        }
                        n11 &= n10;
                    }
                    if (n11 != 0) {
                        CeaUtil.consumeCcData(l10, parsableByteArray, trackOutputArray);
                    }
                }
            } else {
                string3 = TAG;
                string2 = "Skipping remainder of malformed SEI NAL unit.";
                Log.w(string3, string2);
                n13 = parsableByteArray.limit();
            }
            parsableByteArray.setPosition(n13);
        }
    }

    public static void consumeCcData(long l10, ParsableByteArray parsableByteArray, TrackOutput[] trackOutputArray) {
        int n10 = parsableByteArray.readUnsignedByte();
        int n11 = n10 & 0x40;
        int n12 = 1;
        if ((n11 = n11 != 0 ? n12 : 0) == 0) {
            return;
        }
        n10 &= 0x1F;
        parsableByteArray.skipBytes(n12);
        n10 *= 3;
        n11 = parsableByteArray.getPosition();
        for (TrackOutput trackOutput : trackOutputArray) {
            parsableByteArray.setPosition(n11);
            trackOutput.sampleData(parsableByteArray, n10);
            int n13 = 1;
            trackOutput.sampleMetadata(l10, n13, n10, 0, null);
        }
    }

    private static int readNon255TerminatedValue(ParsableByteArray parsableByteArray) {
        int n10;
        int n11;
        int n12 = 0;
        do {
            if ((n11 = parsableByteArray.bytesLeft()) == 0) {
                return -1;
            }
            n11 = parsableByteArray.readUnsignedByte();
            n12 += n11;
        } while (n11 == (n10 = 255));
        return n12;
    }
}

