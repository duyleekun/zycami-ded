/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.jpeg;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ForwardingExtractorInput;
import com.google.android.exoplayer2.util.Assertions;

public final class StartOffsetExtractorInput
extends ForwardingExtractorInput {
    private final long startOffset;

    public StartOffsetExtractorInput(ExtractorInput extractorInput, long l10) {
        super(extractorInput);
        long l11 = extractorInput.getPosition();
        long l12 = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
        if (l12 >= 0) {
            l12 = 1;
        } else {
            l12 = 0;
            extractorInput = null;
        }
        Assertions.checkArgument((boolean)l12);
        this.startOffset = l10;
    }

    public long getLength() {
        long l10 = super.getLength();
        long l11 = this.startOffset;
        return l10 - l11;
    }

    public long getPeekPosition() {
        long l10 = super.getPeekPosition();
        long l11 = this.startOffset;
        return l10 - l11;
    }

    public long getPosition() {
        long l10 = super.getPosition();
        long l11 = this.startOffset;
        return l10 - l11;
    }

    public void setRetryPosition(long l10, Throwable throwable) {
        long l11 = this.startOffset;
        super.setRetryPosition(l10 += l11, throwable);
    }
}

