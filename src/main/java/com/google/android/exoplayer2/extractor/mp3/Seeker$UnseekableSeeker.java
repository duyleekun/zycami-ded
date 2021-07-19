/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.mp3;

import com.google.android.exoplayer2.extractor.SeekMap$Unseekable;
import com.google.android.exoplayer2.extractor.mp3.Seeker;

public class Seeker$UnseekableSeeker
extends SeekMap$Unseekable
implements Seeker {
    public Seeker$UnseekableSeeker() {
        super(-9223372036854775807L);
    }

    public long getDataEndPosition() {
        return -1;
    }

    public long getTimeUs(long l10) {
        return 0L;
    }
}

