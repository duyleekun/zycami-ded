/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaParser$SeekMap
 *  android.media.MediaParser$SeekPoint
 */
package com.google.android.exoplayer2.source.mediaparser;

import android.media.MediaParser;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekMap$SeekPoints;
import com.google.android.exoplayer2.extractor.SeekPoint;

public final class OutputConsumerAdapterV30$SeekMapAdapter
implements SeekMap {
    private final MediaParser.SeekMap adaptedSeekMap;

    public OutputConsumerAdapterV30$SeekMapAdapter(MediaParser.SeekMap seekMap) {
        this.adaptedSeekMap = seekMap;
    }

    private static SeekPoint asExoPlayerSeekPoint(MediaParser.SeekPoint seekPoint) {
        long l10 = seekPoint.timeMicros;
        long l11 = seekPoint.position;
        SeekPoint seekPoint2 = new SeekPoint(l10, l11);
        return seekPoint2;
    }

    public long getDurationUs() {
        long l10;
        MediaParser.SeekMap seekMap = this.adaptedSeekMap;
        long l11 = seekMap.getDurationMicros();
        long l12 = l11 - (l10 = 0x80000000L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            l11 = -9223372036854775807L;
        }
        return l11;
    }

    public SeekMap$SeekPoints getSeekPoints(long l10) {
        Object object = this.adaptedSeekMap.getSeekPoints(l10);
        Object object2 = object.first;
        Object object3 = object.second;
        if (object2 == object3) {
            object2 = OutputConsumerAdapterV30$SeekMapAdapter.asExoPlayerSeekPoint((MediaParser.SeekPoint)object2);
            object = new SeekMap$SeekPoints((SeekPoint)object2);
        } else {
            object2 = OutputConsumerAdapterV30$SeekMapAdapter.asExoPlayerSeekPoint((MediaParser.SeekPoint)object2);
            object = OutputConsumerAdapterV30$SeekMapAdapter.asExoPlayerSeekPoint((MediaParser.SeekPoint)object.second);
            object3 = new SeekMap$SeekPoints((SeekPoint)object2, (SeekPoint)object);
            object = object3;
        }
        return object;
    }

    public boolean isSeekable() {
        return this.adaptedSeekMap.isSeekable();
    }
}

