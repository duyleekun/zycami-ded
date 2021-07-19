/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.dash.manifest;

import com.google.android.exoplayer2.source.dash.manifest.AdaptationSet;
import com.google.android.exoplayer2.source.dash.manifest.Descriptor;
import java.util.Collections;
import java.util.List;

public class Period {
    public final List adaptationSets;
    public final Descriptor assetIdentifier;
    public final List eventStreams;
    public final String id;
    public final long startMs;

    public Period(String string2, long l10, List list) {
        List list2 = Collections.emptyList();
        this(string2, l10, list, list2, null);
    }

    public Period(String string2, long l10, List list, List list2) {
        this(string2, l10, list, list2, null);
    }

    public Period(String list, long l10, List list2, List list3, Descriptor descriptor) {
        this.id = list;
        this.startMs = l10;
        list = Collections.unmodifiableList(list2);
        this.adaptationSets = list;
        this.eventStreams = list = Collections.unmodifiableList(list3);
        this.assetIdentifier = descriptor;
    }

    public int getAdaptationSetIndex(int n10) {
        List list = this.adaptationSets;
        int n11 = list.size();
        for (int i10 = 0; i10 < n11; ++i10) {
            AdaptationSet adaptationSet = (AdaptationSet)this.adaptationSets.get(i10);
            int n12 = adaptationSet.type;
            if (n12 != n10) continue;
            return i10;
        }
        return -1;
    }
}

