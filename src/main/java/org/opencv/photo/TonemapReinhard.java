/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.photo;

import org.opencv.photo.Tonemap;

public class TonemapReinhard
extends Tonemap {
    public TonemapReinhard(long l10) {
        super(l10);
    }

    private static native void delete(long var0);

    private static native float getColorAdaptation_0(long var0);

    private static native float getIntensity_0(long var0);

    private static native float getLightAdaptation_0(long var0);

    public static TonemapReinhard k(long l10) {
        TonemapReinhard tonemapReinhard = new TonemapReinhard(l10);
        return tonemapReinhard;
    }

    private static native void setColorAdaptation_0(long var0, float var2);

    private static native void setIntensity_0(long var0, float var2);

    private static native void setLightAdaptation_0(long var0, float var2);

    public void finalize() {
        TonemapReinhard.delete(this.a);
    }

    public float l() {
        return TonemapReinhard.getColorAdaptation_0(this.a);
    }

    public float m() {
        return TonemapReinhard.getIntensity_0(this.a);
    }

    public float n() {
        return TonemapReinhard.getLightAdaptation_0(this.a);
    }

    public void o(float f10) {
        TonemapReinhard.setColorAdaptation_0(this.a, f10);
    }

    public void p(float f10) {
        TonemapReinhard.setIntensity_0(this.a, f10);
    }

    public void q(float f10) {
        TonemapReinhard.setLightAdaptation_0(this.a, f10);
    }
}

