/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.h0.c;

import com.google.android.exoplayer2.extractor.BinarySearchSeeker$SeekTimestampConverter;
import com.google.android.exoplayer2.extractor.FlacStreamMetadata;

public final class b
implements BinarySearchSeeker$SeekTimestampConverter {
    public final /* synthetic */ FlacStreamMetadata a;

    public /* synthetic */ b(FlacStreamMetadata flacStreamMetadata) {
        this.a = flacStreamMetadata;
    }

    public final long timeUsToTargetTime(long l10) {
        return this.a.getSampleNumber(l10);
    }
}

