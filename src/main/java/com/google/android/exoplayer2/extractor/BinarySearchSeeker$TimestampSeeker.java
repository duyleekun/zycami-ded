/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.extractor.BinarySearchSeeker$TimestampSearchResult;
import com.google.android.exoplayer2.extractor.ExtractorInput;

public interface BinarySearchSeeker$TimestampSeeker {
    default public void onSeekFinished() {
    }

    public BinarySearchSeeker$TimestampSearchResult searchForTimestamp(ExtractorInput var1, long var2);
}

