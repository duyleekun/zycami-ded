/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

import com.meicam.sdk.NvsColor;
import com.meicam.sdk.NvsMakeupEffectInfo$MakeupEffectLayer;

public class NvsMakeupEffectInfo$MakeupEffectLayer3D
extends NvsMakeupEffectInfo$MakeupEffectLayer {
    public int blendingMode;
    public NvsColor texColor;
    public String texFilePath;

    public NvsMakeupEffectInfo$MakeupEffectLayer3D() {
        super(0);
    }

    public int getBlendingMode() {
        return this.blendingMode;
    }

    public NvsColor getTexColor() {
        return this.texColor;
    }

    public String getTexFilePath() {
        return this.texFilePath;
    }
}

