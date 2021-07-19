/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.material.shape;

import com.google.android.material.shape.EdgeTreatment;
import com.google.android.material.shape.ShapePath;

public class TriangleEdgeTreatment
extends EdgeTreatment {
    private final boolean inside;
    private final float size;

    public TriangleEdgeTreatment(float f10, boolean bl2) {
        this.size = f10;
        this.inside = bl2;
    }

    public void getEdgePath(float f10, float f11, ShapePath shapePath) {
        float f12 = f10 / 2.0f;
        float f13 = this.size * f11;
        f13 = f12 - f13;
        shapePath.lineTo(f13, 0.0f);
        boolean bl2 = this.inside;
        f13 = bl2 ? this.size : -this.size;
        shapePath.lineTo(f12, f13 *= f11);
        f13 = this.size * f11;
        shapePath.lineTo(f12 += f13, 0.0f);
        shapePath.lineTo(f10, 0.0f);
    }
}

