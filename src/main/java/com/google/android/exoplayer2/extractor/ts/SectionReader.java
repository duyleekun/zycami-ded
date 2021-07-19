/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ts.SectionPayloadReader;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader$TrackIdGenerator;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;

public final class SectionReader
implements TsPayloadReader {
    private static final int DEFAULT_SECTION_BUFFER_LENGTH = 32;
    private static final int MAX_SECTION_LENGTH = 4098;
    private static final int SECTION_HEADER_LENGTH = 3;
    private int bytesRead;
    private final SectionPayloadReader reader;
    private final ParsableByteArray sectionData;
    private boolean sectionSyntaxIndicator;
    private int totalSectionLength;
    private boolean waitingForPayloadStart;

    public SectionReader(SectionPayloadReader object) {
        this.reader = object;
        this.sectionData = object = new ParsableByteArray(32);
    }

    public void consume(ParsableByteArray parsableByteArray, int n10) {
        int n11;
        int n12;
        Object object;
        int n13 = 1;
        if ((n10 &= n13) != 0) {
            n10 = n13;
        } else {
            n10 = 0;
            object = null;
        }
        int n14 = -1;
        if (n10 != 0) {
            n12 = parsableByteArray.readUnsignedByte();
            n11 = parsableByteArray.getPosition() + n12;
        } else {
            n11 = n14;
        }
        n12 = (int)(this.waitingForPayloadStart ? 1 : 0);
        if (n12 != 0) {
            if (n10 == 0) {
                return;
            }
            this.waitingForPayloadStart = false;
            parsableByteArray.setPosition(n11);
            this.bytesRead = 0;
        }
        while ((n10 = parsableByteArray.bytesLeft()) > 0) {
            Object object2;
            n10 = this.bytesRead;
            n12 = 3;
            if (n10 < n12) {
                if (n10 == 0) {
                    n10 = parsableByteArray.readUnsignedByte();
                    n11 = parsableByteArray.getPosition() - n13;
                    parsableByteArray.setPosition(n11);
                    n11 = 255;
                    if (n10 == n11) {
                        this.waitingForPayloadStart = n13;
                        return;
                    }
                }
                n10 = parsableByteArray.bytesLeft();
                n11 = this.bytesRead;
                n11 = 3 - n11;
                n10 = Math.min(n10, n11);
                Object object3 = this.sectionData.getData();
                int n15 = this.bytesRead;
                parsableByteArray.readBytes((byte[])object3, n15, n10);
                this.bytesRead = n11 = this.bytesRead + n10;
                if (n11 != n12) continue;
                this.sectionData.setPosition(0);
                this.sectionData.setLimit(n12);
                this.sectionData.skipBytes(n13);
                object = this.sectionData;
                n10 = object.readUnsignedByte();
                object3 = this.sectionData;
                n11 = ((ParsableByteArray)object3).readUnsignedByte();
                n15 = n10 & 0x80;
                n15 = n15 != 0 ? n13 : 0;
                this.sectionSyntaxIndicator = n15;
                this.totalSectionLength = n10 = ((n10 & 0xF) << 8 | n11) + n12;
                object = this.sectionData;
                n10 = object.capacity();
                if (n10 >= (n12 = this.totalSectionLength)) continue;
                object3 = this.sectionData;
                n11 = ((ParsableByteArray)object3).capacity() * 2;
                n12 = Math.max(n12, n11);
                n10 = Math.min(4098, n12);
                object2 = this.sectionData;
                ((ParsableByteArray)object2).ensureCapacity(n10);
                continue;
            }
            n10 = parsableByteArray.bytesLeft();
            n12 = this.totalSectionLength;
            n11 = this.bytesRead;
            n10 = Math.min(n10, n12 -= n11);
            object2 = this.sectionData.getData();
            n11 = this.bytesRead;
            parsableByteArray.readBytes((byte[])object2, n11, n10);
            this.bytesRead = n12 = this.bytesRead + n10;
            n10 = this.totalSectionLength;
            if (n12 != n10) continue;
            n12 = (int)(this.sectionSyntaxIndicator ? 1 : 0);
            if (n12 != 0) {
                object = this.sectionData.getData();
                n10 = Util.crc32(object, 0, n12 = this.totalSectionLength, n14);
                if (n10 != 0) {
                    this.waitingForPayloadStart = n13;
                    return;
                }
                object = this.sectionData;
                n12 = this.totalSectionLength + -4;
                object.setLimit(n12);
            } else {
                object2 = this.sectionData;
                ((ParsableByteArray)object2).setLimit(n10);
            }
            this.sectionData.setPosition(0);
            object = this.reader;
            object2 = this.sectionData;
            object.consume((ParsableByteArray)object2);
            this.bytesRead = 0;
        }
    }

    public void init(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TsPayloadReader$TrackIdGenerator tsPayloadReader$TrackIdGenerator) {
        this.reader.init(timestampAdjuster, extractorOutput, tsPayloadReader$TrackIdGenerator);
        this.waitingForPayloadStart = true;
    }

    public void seek() {
        this.waitingForPayloadStart = true;
    }
}

