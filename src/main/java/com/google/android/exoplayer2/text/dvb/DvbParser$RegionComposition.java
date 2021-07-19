/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseArray
 */
package com.google.android.exoplayer2.text.dvb;

import android.util.SparseArray;
import com.google.android.exoplayer2.text.dvb.DvbParser$RegionObject;

public final class DvbParser$RegionComposition {
    public final int clutId;
    public final int depth;
    public final boolean fillFlag;
    public final int height;
    public final int id;
    public final int levelOfCompatibility;
    public final int pixelCode2Bit;
    public final int pixelCode4Bit;
    public final int pixelCode8Bit;
    public final SparseArray regionObjects;
    public final int width;

    public DvbParser$RegionComposition(int n10, boolean bl2, int n11, int n12, int n13, int n14, int n15, int n16, int n17, int n18, SparseArray sparseArray) {
        this.id = n10;
        this.fillFlag = bl2;
        this.width = n11;
        this.height = n12;
        this.levelOfCompatibility = n13;
        this.depth = n14;
        this.clutId = n15;
        this.pixelCode8Bit = n16;
        this.pixelCode4Bit = n17;
        this.pixelCode2Bit = n18;
        this.regionObjects = sparseArray;
    }

    public void mergeFrom(DvbParser$RegionComposition dvbParser$RegionComposition) {
        int n10;
        dvbParser$RegionComposition = dvbParser$RegionComposition.regionObjects;
        for (int i10 = 0; i10 < (n10 = dvbParser$RegionComposition.size()); ++i10) {
            SparseArray sparseArray = this.regionObjects;
            int n11 = dvbParser$RegionComposition.keyAt(i10);
            DvbParser$RegionObject dvbParser$RegionObject = (DvbParser$RegionObject)dvbParser$RegionComposition.valueAt(i10);
            sparseArray.put(n11, (Object)dvbParser$RegionObject);
        }
    }
}

