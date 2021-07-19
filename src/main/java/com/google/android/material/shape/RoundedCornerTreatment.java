/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.material.shape;

import com.google.android.material.shape.CornerTreatment;
import com.google.android.material.shape.ShapePath;

public class RoundedCornerTreatment
extends CornerTreatment {
    private final float radius;

    public RoundedCornerTreatment(float f10) {
        this.radius = f10;
    }

    public void getCornerPath(float f10, float f11, ShapePath shapePath) {
        float f12 = this.radius * f11;
        shapePath.reset(0.0f, f12);
        f12 = this.radius;
        float f13 = 2.0f;
        float f14 = f12 * f13 * f11;
        float f15 = f12 * f13 * f11;
        float f16 = f10 + 180.0f;
        shapePath.addArc(0.0f, 0.0f, f14, f15, f16, 90.0f);
    }
}

