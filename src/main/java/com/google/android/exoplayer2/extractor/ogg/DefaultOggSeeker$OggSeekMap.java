/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekMap$SeekPoints;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.extractor.ogg.DefaultOggSeeker;
import com.google.android.exoplayer2.extractor.ogg.DefaultOggSeeker$1;
import com.google.android.exoplayer2.extractor.ogg.StreamReader;
import com.google.android.exoplayer2.util.Util;

public final class DefaultOggSeeker$OggSeekMap
implements SeekMap {
    public final /* synthetic */ DefaultOggSeeker this$0;

    private DefaultOggSeeker$OggSeekMap(DefaultOggSeeker defaultOggSeeker) {
        this.this$0 = defaultOggSeeker;
    }

    public /* synthetic */ DefaultOggSeeker$OggSeekMap(DefaultOggSeeker defaultOggSeeker, DefaultOggSeeker$1 defaultOggSeeker$1) {
        this(defaultOggSeeker);
    }

    public long getDurationUs() {
        StreamReader streamReader = DefaultOggSeeker.access$100(this.this$0);
        long l10 = DefaultOggSeeker.access$400(this.this$0);
        return streamReader.convertGranuleToTime(l10);
    }

    public SeekMap$SeekPoints getSeekPoints(long l10) {
        long l11 = DefaultOggSeeker.access$100(this.this$0).convertTimeToGranule(l10);
        long l12 = DefaultOggSeeker.access$200(this.this$0);
        long l13 = DefaultOggSeeker.access$300(this.this$0);
        long l14 = DefaultOggSeeker.access$200(this.this$0);
        l11 *= (l13 -= l14);
        l13 = DefaultOggSeeker.access$400(this.this$0);
        l11 /= l13;
        l13 = l12 + l11 - 30000L;
        l14 = DefaultOggSeeker.access$200(this.this$0);
        long l15 = DefaultOggSeeker.access$300(this.this$0) - 1L;
        l11 = Util.constrainValue(l13, l14, l15);
        SeekPoint seekPoint = new SeekPoint(l10, l11);
        SeekMap$SeekPoints seekMap$SeekPoints = new SeekMap$SeekPoints(seekPoint);
        return seekMap$SeekPoints;
    }

    public boolean isSeekable() {
        return true;
    }
}

