/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.text.ssa;

import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.Collections;
import java.util.List;

public final class SsaSubtitle
implements Subtitle {
    private final List cueTimesUs;
    private final List cues;

    public SsaSubtitle(List list, List list2) {
        this.cues = list;
        this.cueTimesUs = list2;
    }

    public List getCues(long l10) {
        int n10;
        List list = this.cueTimesUs;
        Long l11 = l10;
        int n11 = Util.binarySearchFloor(list, l11, true, false);
        if (n11 == (n10 = -1)) {
            return Collections.emptyList();
        }
        return (List)this.cues.get(n11);
    }

    public long getEventTime(int n10) {
        List list;
        int n11;
        int n12 = 1;
        if (n10 >= 0) {
            n11 = n12;
        } else {
            n11 = 0;
            list = null;
        }
        Assertions.checkArgument(n11 != 0);
        list = this.cueTimesUs;
        n11 = list.size();
        if (n10 >= n11) {
            n12 = 0;
        }
        Assertions.checkArgument(n12 != 0);
        return (Long)this.cueTimesUs.get(n10);
    }

    public int getEventTimeCount() {
        return this.cueTimesUs.size();
    }

    public int getNextEventTimeIndex(long l10) {
        List list;
        int n10;
        List list2 = this.cueTimesUs;
        Long l11 = l10;
        int n11 = Util.binarySearchCeil(list2, l11, false, false);
        if (n11 >= (n10 = (list = this.cueTimesUs).size())) {
            n11 = -1;
        }
        return n11;
    }
}

