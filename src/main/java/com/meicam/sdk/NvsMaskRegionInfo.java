/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

import com.meicam.sdk.NvsArbitraryData;
import com.meicam.sdk.NvsMaskRegionInfo$RegionInfo;
import java.util.ArrayList;
import java.util.List;

public class NvsMaskRegionInfo
extends NvsArbitraryData {
    public static final int MASK_REGION_TYPE_CUBIC_CURVE = 1;
    public static final int MASK_REGION_TYPE_ELLIPSE2D = 2;
    public static final int MASK_REGION_TYPE_POLYGON;
    private List regionInfoArray;

    public NvsMaskRegionInfo() {
        ArrayList arrayList;
        this.regionInfoArray = arrayList = new ArrayList();
    }

    public void addRegionInfo(NvsMaskRegionInfo$RegionInfo nvsMaskRegionInfo$RegionInfo) {
        this.regionInfoArray.add(nvsMaskRegionInfo$RegionInfo);
    }

    public List getRegionInfoArray() {
        return this.regionInfoArray;
    }

    public void removeRegionInfoByIndex(int n10) {
        List list;
        int n11;
        if (n10 >= 0 && n10 < (n11 = (list = this.regionInfoArray).size())) {
            list = this.regionInfoArray;
            list.remove(n10);
        }
    }
}

