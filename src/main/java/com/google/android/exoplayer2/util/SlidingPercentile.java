/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.util;

import com.google.android.exoplayer2.util.SlidingPercentile$Sample;
import d.h.a.a.r0.c;
import d.h.a.a.r0.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SlidingPercentile {
    private static final Comparator INDEX_COMPARATOR = c.a;
    private static final int MAX_RECYCLED_SAMPLES = 5;
    private static final int SORT_ORDER_BY_INDEX = 1;
    private static final int SORT_ORDER_BY_VALUE = 0;
    private static final int SORT_ORDER_NONE = 255;
    private static final Comparator VALUE_COMPARATOR = d.a;
    private int currentSortOrder;
    private final int maxWeight;
    private int nextSampleIndex;
    private int recycledSampleCount;
    private final SlidingPercentile$Sample[] recycledSamples;
    private final ArrayList samples;
    private int totalWeight;

    public SlidingPercentile(int n10) {
        this.maxWeight = n10;
        Object object = new SlidingPercentile$Sample[5];
        this.recycledSamples = object;
        this.samples = object;
        this.currentSortOrder = -1;
    }

    public static /* synthetic */ int a(SlidingPercentile$Sample slidingPercentile$Sample, SlidingPercentile$Sample slidingPercentile$Sample2) {
        int n10 = slidingPercentile$Sample.index;
        int n11 = slidingPercentile$Sample2.index;
        return n10 - n11;
    }

    public static /* synthetic */ int b(SlidingPercentile$Sample slidingPercentile$Sample, SlidingPercentile$Sample slidingPercentile$Sample2) {
        float f10 = slidingPercentile$Sample.value;
        float f11 = slidingPercentile$Sample2.value;
        return Float.compare(f10, f11);
    }

    private void ensureSortedByIndex() {
        int n10 = this.currentSortOrder;
        int n11 = 1;
        if (n10 != n11) {
            ArrayList arrayList = this.samples;
            Comparator comparator = INDEX_COMPARATOR;
            Collections.sort(arrayList, comparator);
            this.currentSortOrder = n11;
        }
    }

    private void ensureSortedByValue() {
        int n10 = this.currentSortOrder;
        if (n10 != 0) {
            ArrayList arrayList = this.samples;
            Comparator comparator = VALUE_COMPARATOR;
            Collections.sort(arrayList, comparator);
            n10 = 0;
            arrayList = null;
            this.currentSortOrder = 0;
        }
    }

    public void addSample(int n10, float f10) {
        int n11;
        int n12;
        int n13;
        SlidingPercentile$Sample[] slidingPercentile$SampleArray;
        SlidingPercentile$Sample[] slidingPercentile$SampleArray2;
        this.ensureSortedByIndex();
        int n14 = this.recycledSampleCount;
        if (n14 > 0) {
            slidingPercentile$SampleArray2 = this.recycledSamples;
            this.recycledSampleCount = n14 += -1;
            slidingPercentile$SampleArray = slidingPercentile$SampleArray2[n14];
        } else {
            n13 = 0;
            slidingPercentile$SampleArray2 = null;
            slidingPercentile$SampleArray = new SlidingPercentile$Sample(null);
        }
        n13 = this.nextSampleIndex;
        this.nextSampleIndex = n12 = n13 + 1;
        slidingPercentile$SampleArray.index = n13;
        slidingPercentile$SampleArray.weight = n10;
        slidingPercentile$SampleArray.value = f10;
        Object object = this.samples;
        ((ArrayList)object).add(slidingPercentile$SampleArray);
        this.totalWeight = n11 = this.totalWeight + n10;
        while ((n10 = this.totalWeight) > (n11 = this.maxWeight)) {
            object = this.samples;
            n14 = 0;
            slidingPercentile$SampleArray = null;
            object = (SlidingPercentile$Sample)((ArrayList)object).get(0);
            n13 = ((SlidingPercentile$Sample)object).weight;
            if (n13 <= (n10 -= n11)) {
                this.totalWeight = n10 = this.totalWeight - n13;
                ArrayList arrayList = this.samples;
                arrayList.remove(0);
                n10 = this.recycledSampleCount;
                n14 = 5;
                if (n10 >= n14) continue;
                slidingPercentile$SampleArray = this.recycledSamples;
                this.recycledSampleCount = n13 = n10 + 1;
                slidingPercentile$SampleArray[n10] = object;
                continue;
            }
            ((SlidingPercentile$Sample)object).weight = n13 -= n10;
            this.totalWeight = n11 = this.totalWeight - n10;
        }
    }

    public float getPercentile(float f10) {
        Object object;
        int n10;
        int n11;
        this.ensureSortedByValue();
        float f11 = this.totalWeight;
        f10 *= f11;
        f11 = 0.0f;
        int n12 = 0;
        for (n11 = 0; n11 < (n10 = ((ArrayList)(object = this.samples)).size()); ++n11) {
            object = (SlidingPercentile$Sample)this.samples.get(n11);
            int n13 = ((SlidingPercentile$Sample)object).weight;
            float f12 = n12 += n13;
            float f13 = f12 - f10;
            if ((n13 = (int)(f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1))) < 0) continue;
            return ((SlidingPercentile$Sample)object).value;
        }
        Object object2 = this.samples;
        boolean n14 = ((ArrayList)object2).isEmpty();
        if (n14) {
            int n13 = 2143289344;
            f10 = 0.0f / 0.0f;
        } else {
            object2 = this.samples;
            n11 = ((ArrayList)object2).size() + -1;
            object2 = (SlidingPercentile$Sample)((ArrayList)object2).get(n11);
            f10 = ((SlidingPercentile$Sample)object2).value;
        }
        return f10;
    }

    public void reset() {
        this.samples.clear();
        this.currentSortOrder = -1;
        this.nextSampleIndex = 0;
        this.totalWeight = 0;
    }
}

