/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseArray
 */
package com.google.android.exoplayer2.text.dvb;

import android.util.SparseArray;
import com.google.android.exoplayer2.text.dvb.DvbParser$DisplayDefinition;
import com.google.android.exoplayer2.text.dvb.DvbParser$PageComposition;

public final class DvbParser$SubtitleService {
    public final SparseArray ancillaryCluts;
    public final SparseArray ancillaryObjects;
    public final int ancillaryPageId;
    public final SparseArray cluts;
    public DvbParser$DisplayDefinition displayDefinition;
    public final SparseArray objects;
    public DvbParser$PageComposition pageComposition;
    public final SparseArray regions;
    public final int subtitlePageId;

    public DvbParser$SubtitleService(int n10, int n11) {
        SparseArray sparseArray;
        this.subtitlePageId = n10;
        this.ancillaryPageId = n11;
        this.regions = sparseArray = new SparseArray();
        this.cluts = sparseArray = new SparseArray();
        this.objects = sparseArray = new SparseArray();
        this.ancillaryCluts = sparseArray = new SparseArray();
        this.ancillaryObjects = sparseArray = new SparseArray();
    }

    public void reset() {
        this.regions.clear();
        this.cluts.clear();
        this.objects.clear();
        this.ancillaryCluts.clear();
        this.ancillaryObjects.clear();
        this.displayDefinition = null;
        this.pageComposition = null;
    }
}

