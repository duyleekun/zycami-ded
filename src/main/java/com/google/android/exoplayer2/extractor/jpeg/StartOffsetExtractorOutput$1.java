/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.jpeg;

import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekMap$SeekPoints;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.extractor.jpeg.StartOffsetExtractorOutput;

public class StartOffsetExtractorOutput$1
implements SeekMap {
    public final /* synthetic */ StartOffsetExtractorOutput this$0;
    public final /* synthetic */ SeekMap val$seekMap;

    public StartOffsetExtractorOutput$1(StartOffsetExtractorOutput startOffsetExtractorOutput, SeekMap seekMap) {
        this.this$0 = startOffsetExtractorOutput;
        this.val$seekMap = seekMap;
    }

    public long getDurationUs() {
        return this.val$seekMap.getDurationUs();
    }

    public SeekMap$SeekPoints getSeekPoints(long l10) {
        Object object = this.val$seekMap.getSeekPoints(l10);
        SeekPoint seekPoint = ((SeekMap$SeekPoints)object).first;
        long l11 = seekPoint.timeUs;
        long l12 = seekPoint.position;
        long l13 = StartOffsetExtractorOutput.access$000(this.this$0);
        SeekPoint seekPoint2 = new SeekPoint(l11, l12 += l13);
        object = ((SeekMap$SeekPoints)object).second;
        l11 = ((SeekPoint)object).timeUs;
        l12 = ((SeekPoint)object).position;
        l13 = StartOffsetExtractorOutput.access$000(this.this$0);
        seekPoint = new SeekPoint(l11, l12 += l13);
        SeekMap$SeekPoints seekMap$SeekPoints = new SeekMap$SeekPoints(seekPoint2, seekPoint);
        return seekMap$SeekPoints;
    }

    public boolean isSeekable() {
        return this.val$seekMap.isSeekable();
    }
}

