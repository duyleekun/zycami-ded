/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.mkv;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.mkv.EbmlProcessor;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor$1;

public final class MatroskaExtractor$InnerEbmlProcessor
implements EbmlProcessor {
    public final /* synthetic */ MatroskaExtractor this$0;

    private MatroskaExtractor$InnerEbmlProcessor(MatroskaExtractor matroskaExtractor) {
        this.this$0 = matroskaExtractor;
    }

    public /* synthetic */ MatroskaExtractor$InnerEbmlProcessor(MatroskaExtractor matroskaExtractor, MatroskaExtractor$1 matroskaExtractor$1) {
        this(matroskaExtractor);
    }

    public void binaryElement(int n10, int n11, ExtractorInput extractorInput) {
        this.this$0.binaryElement(n10, n11, extractorInput);
    }

    public void endMasterElement(int n10) {
        this.this$0.endMasterElement(n10);
    }

    public void floatElement(int n10, double d10) {
        this.this$0.floatElement(n10, d10);
    }

    public int getElementType(int n10) {
        return this.this$0.getElementType(n10);
    }

    public void integerElement(int n10, long l10) {
        this.this$0.integerElement(n10, l10);
    }

    public boolean isLevel1Element(int n10) {
        return this.this$0.isLevel1Element(n10);
    }

    public void startMasterElement(int n10, long l10, long l11) {
        this.this$0.startMasterElement(n10, l10, l11);
    }

    public void stringElement(int n10, String string2) {
        this.this$0.stringElement(n10, string2);
    }
}

