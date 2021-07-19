/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.text.ttml;

import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.exoplayer2.util.Util;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class TtmlSubtitle
implements Subtitle {
    private final long[] eventTimesUs;
    private final Map globalStyles;
    private final Map imageMap;
    private final Map regionMap;
    private final TtmlNode root;

    public TtmlSubtitle(TtmlNode object, Map map, Map map2, Map map3) {
        this.root = object;
        this.regionMap = map2;
        this.imageMap = map3;
        map = map != null ? Collections.unmodifiableMap(map) : Collections.emptyMap();
        this.globalStyles = map;
        object = ((TtmlNode)object).getEventTimesUs();
        this.eventTimesUs = (long[])object;
    }

    public List getCues(long l10) {
        TtmlNode ttmlNode = this.root;
        Map map = this.globalStyles;
        Map map2 = this.regionMap;
        Map map3 = this.imageMap;
        return ttmlNode.getCues(l10, map, map2, map3);
    }

    public long getEventTime(int n10) {
        return this.eventTimesUs[n10];
    }

    public int getEventTimeCount() {
        return this.eventTimesUs.length;
    }

    public Map getGlobalStyles() {
        return this.globalStyles;
    }

    public int getNextEventTimeIndex(long l10) {
        long[] lArray;
        int n10;
        long[] lArray2 = this.eventTimesUs;
        int n11 = Util.binarySearchCeil(lArray2, l10, false, false);
        if (n11 >= (n10 = (lArray = this.eventTimesUs).length)) {
            n11 = -1;
        }
        return n11;
    }

    public TtmlNode getRoot() {
        return this.root;
    }
}

