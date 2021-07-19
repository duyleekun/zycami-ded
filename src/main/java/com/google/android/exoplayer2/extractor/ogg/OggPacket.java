/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ogg.OggPageHeader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Arrays;

public final class OggPacket {
    private int currentSegmentIndex;
    private final ParsableByteArray packetArray;
    private final OggPageHeader pageHeader;
    private boolean populated;
    private int segmentCount;

    public OggPacket() {
        Object object = new OggPageHeader();
        this.pageHeader = object;
        byte[] byArray = new byte[65025];
        this.packetArray = object = new ParsableByteArray(byArray, 0);
        this.currentSegmentIndex = -1;
    }

    private int calculatePacketSize(int n10) {
        int n11;
        int n12;
        int n13 = 0;
        this.segmentCount = 0;
        do {
            int n14;
            n12 = this.segmentCount;
            n11 = n10 + n12;
            OggPageHeader oggPageHeader = this.pageHeader;
            int n15 = oggPageHeader.pageSegmentCount;
            if (n11 >= n15) break;
            int[] nArray = oggPageHeader.laces;
            this.segmentCount = n14 = n12 + 1;
            n12 += n10;
            n12 = nArray[n12];
            n13 += n12;
        } while (n12 == (n11 = 255));
        return n13;
    }

    public OggPageHeader getPageHeader() {
        return this.pageHeader;
    }

    public ParsableByteArray getPayload() {
        return this.packetArray;
    }

    public boolean populate(ExtractorInput extractorInput) {
        Object object;
        Object object2;
        int n10 = 1;
        if (extractorInput != null) {
            object2 = n10;
        } else {
            object2 = 0;
            object = null;
        }
        Assertions.checkState((boolean)object2);
        object2 = this.populated;
        if (object2 != 0) {
            this.populated = false;
            object = this.packetArray;
            ((ParsableByteArray)object).reset(0);
        }
        while ((object2 = this.populated) == 0) {
            int n11;
            object2 = this.currentSegmentIndex;
            if (object2 < 0) {
                object = this.pageHeader;
                object2 = ((OggPageHeader)object).skipToNextPage(extractorInput);
                if (object2 != 0 && (object2 = ((OggPageHeader)(object = this.pageHeader)).populate(extractorInput, n10 != 0)) != 0) {
                    object = this.pageHeader;
                    n11 = ((OggPageHeader)object).headerSize;
                    object2 = ((OggPageHeader)object).type & n10;
                    if (object2 == n10 && (object2 = ((ParsableByteArray)(object = this.packetArray)).limit()) == 0) {
                        object2 = this.calculatePacketSize(0);
                        n11 += object2;
                        object2 = this.segmentCount + 0;
                    } else {
                        object2 = 0;
                        object = null;
                    }
                    extractorInput.skipFully(n11);
                    this.currentSegmentIndex = object2;
                } else {
                    return false;
                }
            }
            object2 = this.currentSegmentIndex;
            object2 = this.calculatePacketSize((int)object2);
            n11 = this.currentSegmentIndex;
            int n12 = this.segmentCount;
            n11 += n12;
            if (object2 > 0) {
                Object object3 = this.packetArray;
                int n13 = ((ParsableByteArray)object3).limit() + object2;
                ((ParsableByteArray)object3).ensureCapacity(n13);
                object3 = this.packetArray.getData();
                ParsableByteArray parsableByteArray = this.packetArray;
                n13 = parsableByteArray.limit();
                extractorInput.readFully((byte[])object3, n13, (int)object2);
                object3 = this.packetArray;
                n13 = ((ParsableByteArray)object3).limit() + object2;
                ((ParsableByteArray)object3).setLimit(n13);
                object = this.pageHeader.laces;
                n12 = n11 + -1;
                object2 = object[n12];
                n12 = 255;
                if (object2 != n12) {
                    object2 = n10;
                } else {
                    object2 = 0;
                    object = null;
                }
                this.populated = object2;
            }
            object = this.pageHeader;
            object2 = ((OggPageHeader)object).pageSegmentCount;
            if (n11 == object2) {
                n11 = -1;
            }
            this.currentSegmentIndex = n11;
        }
        return n10 != 0;
    }

    public void reset() {
        this.pageHeader.reset();
        this.packetArray.reset(0);
        this.currentSegmentIndex = -1;
        this.populated = false;
    }

    public void trimPayload() {
        int n10;
        Object object = this.packetArray.getData();
        int n11 = ((byte[])object).length;
        if (n11 == (n10 = 65025)) {
            return;
        }
        object = this.packetArray;
        byte[] byArray = object.getData();
        int n12 = this.packetArray.limit();
        n10 = Math.max(n10, n12);
        byte[] byArray2 = Arrays.copyOf(byArray, n10);
        int n13 = this.packetArray.limit();
        object.reset(byArray2, n13);
    }
}

