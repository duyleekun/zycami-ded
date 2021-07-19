/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.xfeatures2d;

import org.opencv.features2d.Feature2D;

public class BoostDesc
extends Feature2D {
    public BoostDesc(long l10) {
        super(l10);
    }

    private static native long create_0(int var0, boolean var1, float var2);

    private static native long create_1(int var0, boolean var1);

    private static native long create_2(int var0);

    private static native long create_3();

    private static native void delete(long var0);

    private static native float getScaleFactor_0(long var0);

    private static native boolean getUseScaleOrientation_0(long var0);

    private static native void setScaleFactor_0(long var0, float var2);

    private static native void setUseScaleOrientation_0(long var0, boolean var2);

    public static BoostDesc u(long l10) {
        BoostDesc boostDesc = new BoostDesc(l10);
        return boostDesc;
    }

    public static BoostDesc v() {
        return BoostDesc.u(BoostDesc.create_3());
    }

    public static BoostDesc w(int n10) {
        return BoostDesc.u(BoostDesc.create_2(n10));
    }

    public static BoostDesc x(int n10, boolean bl2) {
        return BoostDesc.u(BoostDesc.create_1(n10, bl2));
    }

    public static BoostDesc y(int n10, boolean bl2, float f10) {
        return BoostDesc.u(BoostDesc.create_0(n10, bl2, f10));
    }

    public boolean A() {
        return BoostDesc.getUseScaleOrientation_0(this.a);
    }

    public void B(float f10) {
        BoostDesc.setScaleFactor_0(this.a, f10);
    }

    public void C(boolean bl2) {
        BoostDesc.setUseScaleOrientation_0(this.a, bl2);
    }

    public void finalize() {
        BoostDesc.delete(this.a);
    }

    public float z() {
        return BoostDesc.getScaleFactor_0(this.a);
    }
}

