/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.mkv;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.ParsableByteArray;

public final class Sniffer {
    private static final int ID_EBML = 440786851;
    private static final int SEARCH_LENGTH = 1024;
    private int peekLength;
    private final ParsableByteArray scratch;

    public Sniffer() {
        ParsableByteArray parsableByteArray;
        this.scratch = parsableByteArray = new ParsableByteArray(8);
    }

    private long readUint(ExtractorInput extractorInput) {
        int n10;
        int n11;
        byte[] byArray = this.scratch.getData();
        int n12 = 0;
        int n13 = 1;
        extractorInput.peekFully(byArray, 0, n13);
        byArray = this.scratch.getData();
        int n14 = byArray[0] & 0xFF;
        if (n14 == 0) {
            return Long.MIN_VALUE;
        }
        int n15 = 128;
        int n16 = 0;
        while ((n11 = n14 & n15) == 0) {
            n15 >>= 1;
            ++n16;
        }
        n14 &= (n15 ^= 0xFFFFFFFF);
        byte[] byArray2 = this.scratch.getData();
        extractorInput.peekFully(byArray2, n13, n16);
        while (n12 < n16) {
            n10 = n14 << 8;
            byArray = this.scratch.getData();
            n14 = (byArray[++n12] & 0xFF) + n10;
        }
        n10 = this.peekLength;
        this.peekLength = n10 += (n16 += n13);
        return n14;
    }

    public boolean sniff(ExtractorInput extractorInput) {
        long l10;
        long l11;
        int n10;
        long l12;
        long l13;
        long l14 = extractorInput.getLength();
        long l15 = -1;
        Object object = l14 == l15 ? 0 : (l14 < l15 ? -1 : 1);
        long l16 = 1024L;
        if (object != false && (l13 = l14 == l16 ? 0 : (l14 < l16 ? -1 : 1)) <= 0) {
            l16 = l14;
        }
        int n11 = (int)l16;
        Object object2 = this.scratch.getData();
        l13 = 0;
        int n12 = 4;
        extractorInput.peekFully((byte[])object2, 0, n12);
        object2 = this.scratch;
        long l17 = object2.readUnsignedInt();
        this.peekLength = n12;
        while (true) {
            l12 = 440786851L;
            long l18 = l17 == l12 ? 0 : (l17 < l12 ? -1 : 1);
            n12 = 1;
            if (l18 == false) break;
            l18 = this.peekLength + n12;
            this.peekLength = (int)l18;
            if (l18 == n11) {
                return false;
            }
            object2 = this.scratch.getData();
            extractorInput.peekFully((byte[])object2, 0, n12);
            long l19 = l17 << 8 & 0xFFFFFFFFFFFFFF00L;
            object2 = this.scratch.getData();
            l18 = object2[0] & 0xFF;
            long l20 = l18;
            l17 = l19 | l20;
        }
        l16 = this.readUint(extractorInput);
        int n13 = this.peekLength;
        l17 = n13;
        l12 = Long.MIN_VALUE;
        long l21 = l16 - l12;
        Object object3 = l21 == 0L ? 0 : (l21 < 0L ? -1 : 1);
        if (object3 != false && (object == false || (n10 = (int)((l11 = (l10 = l17 + l16) - l14) == 0L ? 0 : (l11 < 0L ? -1 : 1))) < 0)) {
            long l22;
            long l23;
            long l24;
            while ((l24 = (l23 = (l22 = (long)(n10 = this.peekLength)) - (l10 = l17 + l16)) == 0L ? 0 : (l23 < 0L ? -1 : 1)) < 0) {
                long l25;
                l14 = this.readUint(extractorInput);
                long l26 = l14 - l12;
                n10 = (int)(l26 == 0L ? 0 : (l26 < 0L ? -1 : 1));
                if (n10 == 0) {
                    return false;
                }
                l14 = this.readUint(extractorInput);
                long l27 = l14 - (l10 = 0L);
                object = l27 == 0L ? 0 : (l27 < 0L ? -1 : 1);
                if (object >= 0 && (object3 = (l25 = l14 - (l10 = Integer.MAX_VALUE)) == 0L ? 0 : (l25 < 0L ? -1 : 1)) <= 0) {
                    if (object == false) continue;
                    n10 = (int)l14;
                    extractorInput.advancePeekPosition(n10);
                    l24 = this.peekLength + n10;
                    this.peekLength = (int)l24;
                    continue;
                }
                return false;
            }
            l14 = n10;
            long l28 = l14 - l10;
            Object object4 = l28 == 0L ? 0 : (l28 < 0L ? -1 : 1);
            if (object4 == false) {
                l13 = n12;
            }
        }
        return (boolean)l13;
    }
}

