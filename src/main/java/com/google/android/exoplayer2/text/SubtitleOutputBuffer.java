/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.text;

import com.google.android.exoplayer2.decoder.OutputBuffer;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.Assertions;
import java.util.List;

public abstract class SubtitleOutputBuffer
extends OutputBuffer
implements Subtitle {
    private long subsampleOffsetUs;
    private Subtitle subtitle;

    public void clear() {
        super.clear();
        this.subtitle = null;
    }

    public List getCues(long l10) {
        Subtitle subtitle = (Subtitle)Assertions.checkNotNull(this.subtitle);
        long l11 = this.subsampleOffsetUs;
        return subtitle.getCues(l10 -= l11);
    }

    public long getEventTime(int n10) {
        long l10 = ((Subtitle)Assertions.checkNotNull(this.subtitle)).getEventTime(n10);
        long l11 = this.subsampleOffsetUs;
        return l10 + l11;
    }

    public int getEventTimeCount() {
        return ((Subtitle)Assertions.checkNotNull(this.subtitle)).getEventTimeCount();
    }

    public int getNextEventTimeIndex(long l10) {
        Subtitle subtitle = (Subtitle)Assertions.checkNotNull(this.subtitle);
        long l11 = this.subsampleOffsetUs;
        return subtitle.getNextEventTimeIndex(l10 -= l11);
    }

    public void setContent(long l10, Subtitle subtitle, long l11) {
        this.timeUs = l10;
        this.subtitle = subtitle;
        long l12 = Long.MAX_VALUE;
        long l13 = l11 - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object != false) {
            l10 = l11;
        }
        this.subsampleOffsetUs = l10;
    }
}

