/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.text.pgs;

import com.google.android.exoplayer2.text.Subtitle;
import java.util.List;

public final class PgsSubtitle
implements Subtitle {
    private final List cues;

    public PgsSubtitle(List list) {
        this.cues = list;
    }

    public List getCues(long l10) {
        return this.cues;
    }

    public long getEventTime(int n10) {
        return 0L;
    }

    public int getEventTimeCount() {
        return 1;
    }

    public int getNextEventTimeIndex(long l10) {
        return -1;
    }
}

