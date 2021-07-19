/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.photo;

import org.opencv.photo.Tonemap;

public class TonemapDrago
extends Tonemap {
    public TonemapDrago(long l10) {
        super(l10);
    }

    private static native void delete(long var0);

    private static native float getBias_0(long var0);

    private static native float getSaturation_0(long var0);

    public static TonemapDrago k(long l10) {
        TonemapDrago tonemapDrago = new TonemapDrago(l10);
        return tonemapDrago;
    }

    private static native void setBias_0(long var0, float var2);

    private static native void setSaturation_0(long var0, float var2);

    public void finalize() {
        TonemapDrago.delete(this.a);
    }

    public float l() {
        return TonemapDrago.getBias_0(this.a);
    }

    public float m() {
        return TonemapDrago.getSaturation_0(this.a);
    }

    public void n(float f10) {
        TonemapDrago.setBias_0(this.a, f10);
    }

    public void o(float f10) {
        TonemapDrago.setSaturation_0(this.a, f10);
    }
}

