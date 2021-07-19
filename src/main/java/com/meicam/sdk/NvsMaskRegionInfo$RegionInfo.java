/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

import com.meicam.sdk.NvsMaskRegionInfo$Ellipse2D;
import com.meicam.sdk.NvsMaskRegionInfo$Transform2D;
import java.util.ArrayList;
import java.util.List;

public class NvsMaskRegionInfo$RegionInfo {
    private NvsMaskRegionInfo$Ellipse2D ellipse2d;
    private List points;
    private NvsMaskRegionInfo$Transform2D transform2d;
    private int type;

    public NvsMaskRegionInfo$RegionInfo(int n10) {
        Object object = new ArrayList();
        this.points = object;
        this.ellipse2d = object = new NvsMaskRegionInfo$Ellipse2D();
        this.transform2d = object = new NvsMaskRegionInfo$Transform2D();
        this.type = n10;
    }

    public NvsMaskRegionInfo$Ellipse2D getEllipse2D() {
        return this.ellipse2d;
    }

    public List getPoints() {
        return this.points;
    }

    public NvsMaskRegionInfo$Transform2D getTransform2D() {
        return this.transform2d;
    }

    public int getType() {
        return this.type;
    }

    public void setEllipse2D(NvsMaskRegionInfo$Ellipse2D nvsMaskRegionInfo$Ellipse2D) {
        this.ellipse2d = nvsMaskRegionInfo$Ellipse2D;
    }

    public void setPoints(List list) {
        this.points = list;
    }

    public void setTransform2D(NvsMaskRegionInfo$Transform2D nvsMaskRegionInfo$Transform2D) {
        this.transform2d = nvsMaskRegionInfo$Transform2D;
    }
}

