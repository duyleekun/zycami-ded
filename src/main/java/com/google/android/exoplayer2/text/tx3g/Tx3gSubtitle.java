/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.text.tx3g;

import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Collections;
import java.util.List;

public final class Tx3gSubtitle
implements Subtitle {
    public static final Tx3gSubtitle EMPTY;
    private final List cues;

    static {
        Tx3gSubtitle tx3gSubtitle;
        EMPTY = tx3gSubtitle = new Tx3gSubtitle();
    }

    private Tx3gSubtitle() {
        List list;
        this.cues = list = Collections.emptyList();
    }

    public Tx3gSubtitle(Cue object) {
        this.cues = object = Collections.singletonList(object);
    }

    public List getCues(long l10) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        List list = object >= 0 ? this.cues : Collections.emptyList();
        return list;
    }

    public long getEventTime(int n10) {
        n10 = n10 == 0 ? 1 : 0;
        Assertions.checkArgument(n10 != 0);
        return 0L;
    }

    public int getEventTimeCount() {
        return 1;
    }

    public int getNextEventTimeIndex(long l10) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object < 0 ? (Object)0 : (Object)-1;
        return (int)object;
    }
}

