/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.material.shape;

import com.google.android.material.shape.CornerTreatment;
import com.google.android.material.shape.ShapePath;

public class CutCornerTreatment
extends CornerTreatment {
    private final float size;

    public CutCornerTreatment(float f10) {
        this.size = f10;
    }

    public void getCornerPath(float f10, float f11, ShapePath shapePath) {
        float f12 = this.size * f11;
        shapePath.reset(0.0f, f12);
        double d10 = f10;
        double d11 = Math.sin(d10);
        double d12 = this.size;
        double d13 = f11;
        float f13 = (float)((d11 *= d12) * d13);
        d10 = Math.cos(d10);
        double d14 = this.size;
        f10 = (float)(d10 * d14 * d13);
        shapePath.lineTo(f13, f10);
    }
}

