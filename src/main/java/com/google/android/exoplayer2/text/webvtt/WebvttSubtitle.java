/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.text.webvtt;

import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Cue$Builder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.webvtt.WebvttCueInfo;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import d.h.a.a.n0.c.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class WebvttSubtitle
implements Subtitle {
    private final List cueInfos;
    private final long[] cueTimesUs;
    private final long[] sortedCueTimesUs;

    public WebvttSubtitle(List object) {
        int n10;
        int n11;
        Object object2 = new ArrayList(object);
        object2 = Collections.unmodifiableList(object2);
        this.cueInfos = object2;
        object2 = new long[object.size() * 2];
        this.cueTimesUs = (long[])object2;
        object2 = null;
        for (n11 = 0; n11 < (n10 = object.size()); ++n11) {
            long l10;
            WebvttCueInfo webvttCueInfo = (WebvttCueInfo)object.get(n11);
            int n12 = n11 * 2;
            long[] lArray = this.cueTimesUs;
            lArray[n12] = l10 = webvttCueInfo.startTimeUs;
            lArray[++n12] = l10 = webvttCueInfo.endTimeUs;
        }
        object = this.cueTimesUs;
        n11 = ((Object)object).length;
        object = Arrays.copyOf((long[])object, n11);
        this.sortedCueTimesUs = (long[])object;
        Arrays.sort((long[])object);
    }

    public static /* synthetic */ int a(WebvttCueInfo webvttCueInfo, WebvttCueInfo webvttCueInfo2) {
        long l10 = webvttCueInfo.startTimeUs;
        long l11 = webvttCueInfo2.startTimeUs;
        return Long.compare(l10, l11);
    }

    public List getCues(long l10) {
        int n10;
        Object object;
        int n11;
        int n12;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        ArrayList<Object> arrayList2 = new ArrayList<Object>();
        int n13 = 0;
        for (n12 = 0; n12 < (n11 = (object = this.cueInfos).size()); ++n12) {
            Object object2;
            long l11;
            object = this.cueTimesUs;
            int n14 = n12 * 2;
            reference var10_9 = object[n14];
            reference cfr_temp_0 = var10_9 - l10;
            Object object3 = cfr_temp_0 == 0 ? 0 : (cfr_temp_0 < 0 ? -1 : 1);
            if (object3 > 0 || (n11 = (int)((l11 = l10 - (object2 = object[++n14])) == 0L ? 0 : (l11 < 0L ? -1 : 1))) >= 0) continue;
            object = (WebvttCueInfo)this.cueInfos.get(n12);
            Cue cue = ((WebvttCueInfo)object).cue;
            float f10 = cue.line;
            float f11 = -3.4028235E38f;
            float f12 = f10 - f11;
            object3 = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
            if (object3 == false) {
                arrayList2.add(object);
                continue;
            }
            arrayList.add(cue);
        }
        Object object4 = b.a;
        Collections.sort(arrayList2, object4);
        while (n13 < (n10 = arrayList2.size())) {
            object4 = ((WebvttCueInfo)arrayList2.get((int)n13)).cue.buildUpon();
            int n15 = -1 - n13;
            float f13 = n15;
            n12 = 1;
            object4 = ((Cue$Builder)object4).setLine(f13, n12).build();
            arrayList.add(object4);
            ++n13;
        }
        return arrayList;
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
        lArray = this.sortedCueTimesUs;
        n11 = lArray.length;
        if (n10 >= n11) {
            n12 = 0;
        }
        Assertions.checkArgument(n12 != 0);
        return this.sortedCueTimesUs[n10];
    }

    public int getEventTimeCount() {
        return this.sortedCueTimesUs.length;
    }

    public int getNextEventTimeIndex(long l10) {
        long[] lArray;
        int n10;
        long[] lArray2 = this.sortedCueTimesUs;
        int n11 = Util.binarySearchCeil(lArray2, l10, false, false);
        if (n11 >= (n10 = (lArray = this.sortedCueTimesUs).length)) {
            n11 = -1;
        }
        return n11;
    }
}

