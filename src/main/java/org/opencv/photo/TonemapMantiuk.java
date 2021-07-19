/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.photo;

import org.opencv.photo.Tonemap;

public class TonemapMantiuk
extends Tonemap {
    public TonemapMantiuk(long l10) {
        super(l10);
    }

    private static native void delete(long var0);

    private static native float getSaturation_0(long var0);

    private static native float getScale_0(long var0);

    public static TonemapMantiuk k(long l10) {
        TonemapMantiuk tonemapMantiuk = new TonemapMantiuk(l10);
        return tonemapMantiuk;
    }

    private static native void setSaturation_0(long var0, float var2);

    private static native void setScale_0(long var0, float var2);

    public void finalize() {
        TonemapMantiuk.delete(this.a);
    }

    public float l() {
        return TonemapMantiuk.getSaturation_0(this.a);
    }

    public float m() {
        return TonemapMantiuk.getScale_0(this.a);
    }

    public void n(float f10) {
        TonemapMantiuk.setSaturation_0(this.a, f10);
    }

    public void o(float f10) {
        TonemapMantiuk.setScale_0(this.a, f10);
    }
}

