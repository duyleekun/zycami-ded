/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekMap$Unseekable;
import com.google.android.exoplayer2.extractor.ogg.OggSeeker;
import com.google.android.exoplayer2.extractor.ogg.StreamReader$1;

public final class StreamReader$UnseekableOggSeeker
implements OggSeeker {
    private StreamReader$UnseekableOggSeeker() {
    }

    public /* synthetic */ StreamReader$UnseekableOggSeeker(StreamReader$1 streamReader$1) {
        this();
    }

    public SeekMap createSeekMap() {
        SeekMap$Unseekable seekMap$Unseekable = new SeekMap$Unseekable(-9223372036854775807L);
        return seekMap$Unseekable;
    }

    public long read(ExtractorInput extractorInput) {
        return -1;
    }

    public void startSeek(long l10) {
    }
}

