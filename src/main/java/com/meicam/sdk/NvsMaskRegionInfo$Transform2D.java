/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

import com.meicam.sdk.NvsPosition2D;

public class NvsMaskRegionInfo$Transform2D {
    private NvsPosition2D anchor;
    private float rotation;
    private NvsPosition2D scale;
    private NvsPosition2D translation;

    public NvsMaskRegionInfo$Transform2D() {
        NvsPosition2D nvsPosition2D;
        this.anchor = nvsPosition2D = new NvsPosition2D(0.0f, 0.0f);
        float f10 = 1.0f;
        this.scale = nvsPosition2D = new NvsPosition2D(f10, f10);
        this.rotation = 0.0f;
        this.translation = nvsPosition2D = new NvsPosition2D(0.0f, 0.0f);
    }

    public NvsMaskRegionInfo$Transform2D(NvsPosition2D nvsPosition2D, NvsPosition2D nvsPosition2D2, float f10, NvsPosition2D nvsPosition2D3) {
        this.anchor = nvsPosition2D;
        this.scale = nvsPosition2D2;
        this.rotation = f10;
        this.translation = nvsPosition2D3;
    }

    public NvsPosition2D getAnchor() {
        return this.anchor;
    }

    public float getRotation() {
        return this.rotation;
    }

    public NvsPosition2D getScale() {
        return this.scale;
    }

    public NvsPosition2D getTranslation() {
        return this.translation;
    }

    public void setAnchor(NvsPosition2D nvsPosition2D) {
        this.anchor = nvsPosition2D;
    }

    public void setRotation(float f10) {
        this.rotation = f10;
    }

    public void setScale(NvsPosition2D nvsPosition2D) {
        this.scale = nvsPosition2D;
    }

    public void setTranslation(NvsPosition2D nvsPosition2D) {
        this.translation = nvsPosition2D;
    }
}

