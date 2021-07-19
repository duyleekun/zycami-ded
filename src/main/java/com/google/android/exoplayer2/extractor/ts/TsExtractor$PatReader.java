/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ts.SectionPayloadReader;
import com.google.android.exoplayer2.extractor.ts.SectionReader;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.android.exoplayer2.extractor.ts.TsExtractor$PmtReader;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader$TrackIdGenerator;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;

public class TsExtractor$PatReader
implements SectionPayloadReader {
    private final ParsableBitArray patScratch;
    public final /* synthetic */ TsExtractor this$0;

    public TsExtractor$PatReader(TsExtractor object) {
        this.this$0 = object;
        byte[] byArray = new byte[4];
        this.patScratch = object = new ParsableBitArray(byArray);
    }

    public void consume(ParsableByteArray object) {
        int n10 = ((ParsableByteArray)object).readUnsignedByte();
        if (n10 != 0) {
            return;
        }
        n10 = ((ParsableByteArray)object).readUnsignedByte() & 0x80;
        if (n10 == 0) {
            return;
        }
        ((ParsableByteArray)object).skipBytes(6);
        n10 = ((ParsableByteArray)object).bytesLeft();
        int n11 = 4;
        for (int i10 = 0; i10 < (n10 /= n11); ++i10) {
            Object object2 = this.patScratch;
            ((ParsableByteArray)object).readBytes((ParsableBitArray)object2, n11);
            object2 = this.patScratch;
            int n12 = ((ParsableBitArray)object2).readBits(16);
            Object object3 = this.patScratch;
            int n13 = 3;
            ((ParsableBitArray)object3).skipBits(n13);
            int n14 = 13;
            if (n12 == 0) {
                object2 = this.patScratch;
                ((ParsableBitArray)object2).skipBits(n14);
                continue;
            }
            object2 = this.patScratch;
            n12 = ((ParsableBitArray)object2).readBits(n14);
            object3 = TsExtractor.access$000(this.this$0).get(n12);
            if (object3 != null) continue;
            object3 = TsExtractor.access$000(this.this$0);
            TsExtractor tsExtractor = this.this$0;
            TsExtractor$PmtReader tsExtractor$PmtReader = new TsExtractor$PmtReader(tsExtractor, n12);
            SectionReader sectionReader = new SectionReader(tsExtractor$PmtReader);
            object3.put(n12, (Object)sectionReader);
            object2 = this.this$0;
            TsExtractor.access$108((TsExtractor)object2);
        }
        object = this.this$0;
        int n15 = TsExtractor.access$200((TsExtractor)object);
        if (n15 != (n10 = 2)) {
            object = TsExtractor.access$000(this.this$0);
            object.remove(0);
        }
    }

    public void init(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TsPayloadReader$TrackIdGenerator tsPayloadReader$TrackIdGenerator) {
    }
}

