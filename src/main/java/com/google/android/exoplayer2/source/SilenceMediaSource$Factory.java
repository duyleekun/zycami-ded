/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaItem$Builder;
import com.google.android.exoplayer2.source.SilenceMediaSource;
import com.google.android.exoplayer2.util.Assertions;

public final class SilenceMediaSource$Factory {
    private long durationUs;
    private Object tag;

    public SilenceMediaSource createMediaSource() {
        SilenceMediaSource silenceMediaSource;
        long l10 = this.durationUs;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object > 0) {
            object = 1;
        } else {
            object = 0;
            silenceMediaSource = null;
        }
        Assertions.checkState((boolean)object);
        long l13 = this.durationUs;
        Object object2 = SilenceMediaSource.access$000().buildUpon();
        Object object3 = this.tag;
        object2 = ((MediaItem$Builder)object2).setTag(object3).build();
        silenceMediaSource = new SilenceMediaSource(l13, (MediaItem)object2, null);
        return silenceMediaSource;
    }

    public SilenceMediaSource$Factory setDurationUs(long l10) {
        this.durationUs = l10;
        return this;
    }

    public SilenceMediaSource$Factory setTag(Object object) {
        this.tag = object;
        return this;
    }
}

