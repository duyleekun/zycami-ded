/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

import com.meicam.sdk.NvsPointD;

public class NvsControlPointPair {
    public NvsPointD backwardControlPoint;
    public NvsPointD forwardControlPoint;

    public NvsControlPointPair(NvsPointD nvsPointD, NvsPointD nvsPointD2) {
        this.backwardControlPoint = nvsPointD;
        this.forwardControlPoint = nvsPointD2;
    }
}

