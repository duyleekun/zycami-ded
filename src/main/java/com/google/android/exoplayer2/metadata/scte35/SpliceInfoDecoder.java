/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.metadata.scte35;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata$Entry;
import com.google.android.exoplayer2.metadata.MetadataInputBuffer;
import com.google.android.exoplayer2.metadata.SimpleMetadataDecoder;
import com.google.android.exoplayer2.metadata.scte35.PrivateCommand;
import com.google.android.exoplayer2.metadata.scte35.SpliceCommand;
import com.google.android.exoplayer2.metadata.scte35.SpliceInsertCommand;
import com.google.android.exoplayer2.metadata.scte35.SpliceNullCommand;
import com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand;
import com.google.android.exoplayer2.metadata.scte35.TimeSignalCommand;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import java.nio.ByteBuffer;

public final class SpliceInfoDecoder
extends SimpleMetadataDecoder {
    private static final int TYPE_PRIVATE_COMMAND = 255;
    private static final int TYPE_SPLICE_INSERT = 5;
    private static final int TYPE_SPLICE_NULL = 0;
    private static final int TYPE_SPLICE_SCHEDULE = 4;
    private static final int TYPE_TIME_SIGNAL = 6;
    private final ParsableByteArray sectionData;
    private final ParsableBitArray sectionHeader;
    private TimestampAdjuster timestampAdjuster;

    public SpliceInfoDecoder() {
        Object object = new ParsableByteArray();
        this.sectionData = object;
        this.sectionHeader = object = new ParsableBitArray();
    }

    public Metadata decode(MetadataInputBuffer object, ByteBuffer object2) {
        long l10;
        long l11;
        long l12;
        long l13;
        Object object3 = this.timestampAdjuster;
        if (object3 == null || (l13 = (l12 = (l11 = object.subsampleOffsetUs) - (l10 = ((TimestampAdjuster)object3).getTimestampOffsetUs())) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != false) {
            l11 = object.timeUs;
            object3 = new TimestampAdjuster(l11);
            this.timestampAdjuster = object3;
            l11 = object.timeUs;
            l10 = object.subsampleOffsetUs;
            ((TimestampAdjuster)object3).adjustSampleTimestamp(l11 -= l10);
        }
        object = object2.array();
        int n10 = object2.limit();
        this.sectionData.reset((byte[])object, n10);
        object3 = this.sectionHeader;
        ((ParsableBitArray)object3).reset((byte[])object, n10);
        this.sectionHeader.skipBits(39);
        object = this.sectionHeader;
        n10 = 1;
        long l14 = object.readBits(n10);
        int n11 = 32;
        l14 <<= n11;
        long l15 = this.sectionHeader.readBits(n11);
        l14 |= l15;
        this.sectionHeader.skipBits(20);
        object = this.sectionHeader;
        n11 = object.readBits(12);
        Object object4 = this.sectionHeader;
        int n12 = ((ParsableBitArray)object4).readBits(8);
        SpliceCommand spliceCommand = null;
        ParsableByteArray parsableByteArray = this.sectionData;
        int n13 = 14;
        parsableByteArray.skipBytes(n13);
        if (n12 != 0) {
            int n14 = 255;
            if (n12 != n14) {
                n11 = 4;
                if (n12 != n11) {
                    n11 = 5;
                    if (n12 != n11) {
                        n11 = 6;
                        if (n12 == n11) {
                            object = this.sectionData;
                            object4 = this.timestampAdjuster;
                            spliceCommand = TimeSignalCommand.parseFromSection((ParsableByteArray)object, l14, (TimestampAdjuster)object4);
                        }
                    } else {
                        object = this.sectionData;
                        object4 = this.timestampAdjuster;
                        spliceCommand = SpliceInsertCommand.parseFromSection((ParsableByteArray)object, l14, (TimestampAdjuster)object4);
                    }
                } else {
                    object = this.sectionData;
                    spliceCommand = SpliceScheduleCommand.parseFromSection((ParsableByteArray)object);
                }
            } else {
                object4 = this.sectionData;
                spliceCommand = PrivateCommand.parseFromSection((ParsableByteArray)object4, n11, l14);
            }
        } else {
            spliceCommand = new SpliceNullCommand();
        }
        n11 = 0;
        object = null;
        if (spliceCommand == null) {
            object = new Metadata$Entry[]{};
            object2 = new Metadata((Metadata$Entry)object);
        } else {
            object2 = new Metadata$Entry[n10];
            object2[0] = spliceCommand;
            object3 = new Metadata((Metadata$Entry)object2);
            object2 = object3;
        }
        return object2;
    }
}

