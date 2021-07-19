/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.text.subrip;

import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.Collections;
import java.util.List;

public final class SubripSubtitle
implements Subtitle {
    private final long[] cueTimesUs;
    private final Cue[] cues;

    public SubripSubtitle(Cue[] cueArray, long[] lArray) {
        this.cues = cueArray;
        this.cueTimesUs = lArray;
    }

    public List getCues(long l10) {
        Cue cue;
        Cue[] cueArray;
        int n10;
        Object object = this.cueTimesUs;
        boolean bl2 = true;
        int n11 = Util.binarySearchFloor(object, l10, bl2, false);
        if (n11 != (n10 = -1) && (object = (Object)(cueArray = this.cues)[n11]) != (cue = Cue.EMPTY)) {
            return Collections.singletonList(cueArray[n11]);
        }
        return Collections.emptyList();
    }

    public long getEventTime(int n10) {
        long[] lArray;
        int n11;
        int n12 = 1;
        if (n10 >= 0) {
            n11 = n12;
        } else {
            n11 = 0;
            lArray = null;
        }
        Assertions.checkArgument(n11 != 0);
        lArray = this.cueTimesUs;
        n11 = lArray.length;
        if (n10 >= n11) {
            n12 = 0;
        }
        Assertions.checkArgument(n12 != 0);
        return this.cueTimesUs[n10];
    }

    public int getEventTimeCount() {
        return this.cueTimesUs.length;
    }

    public int getNextEventTimeIndex(long l10) {
        long[] lArray;
        int n10;
        long[] lArray2 = this.cueTimesUs;
        int n11 = Util.binarySearchCeil(lArray2, l10, false, false);
        if (n11 >= (n10 = (lArray = this.cueTimesUs).length)) {
            n11 = -1;
        }
        return n11;
    }
}

