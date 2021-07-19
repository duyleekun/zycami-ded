/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.material.bottomappbar;

import com.google.android.material.shape.EdgeTreatment;
import com.google.android.material.shape.ShapePath;

public class BottomAppBarTopEdgeTreatment
extends EdgeTreatment {
    private static final int ANGLE_LEFT = 180;
    private static final int ANGLE_UP = 270;
    private static final int ARC_HALF = 180;
    private static final int ARC_QUARTER = 90;
    private float cradleVerticalOffset;
    private float fabDiameter;
    private float fabMargin;
    private float horizontalOffset;
    private float roundedCornerRadius;

    public BottomAppBarTopEdgeTreatment(float f10, float f11, float f12) {
        this.fabMargin = f10;
        this.roundedCornerRadius = f11;
        this.cradleVerticalOffset = f12;
        f10 = 0.0f;
        IllegalArgumentException illegalArgumentException = null;
        float f13 = f12 - 0.0f;
        float f14 = f13 == 0.0f ? 0 : (f13 < 0.0f ? -1 : 1);
        if (f14 >= 0) {
            this.horizontalOffset = 0.0f;
            return;
        }
        illegalArgumentException = new IllegalArgumentException("cradleVerticalOffset must be positive.");
        throw illegalArgumentException;
    }

    public float getCradleVerticalOffset() {
        return this.cradleVerticalOffset;
    }

    public void getEdgePath(float f10, float f11, ShapePath shapePath) {
        float f12 = this.fabDiameter;
        float f13 = f12 - 0.0f;
        Object object = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
        if (object == false) {
            shapePath.lineTo(f10, 0.0f);
            return;
        }
        float f14 = this.fabMargin;
        float f15 = 2.0f;
        float f16 = (f14 * f15 + f12) / f15;
        f12 = this.roundedCornerRadius;
        float f17 = f11 * f12;
        f12 = f10 / f15;
        f14 = this.horizontalOffset;
        float f18 = f12 + f14;
        f12 = this.cradleVerticalOffset * f11;
        object = 1065353216;
        f14 = 1.0f;
        float f19 = (f14 - f11) * f16;
        float f20 = f12 + f19;
        float f21 = (f12 = f20 / f16) - f14;
        Object object2 = f21 == 0.0f ? 0 : (f21 > 0.0f ? 1 : -1);
        if (object2 >= 0) {
            shapePath.lineTo(f10, 0.0f);
            return;
        }
        f12 = f16 + f17;
        f12 *= f12;
        f14 = f20 + f17;
        f19 = f14 * f14;
        f12 = (float)Math.sqrt(f12 - f19);
        f19 = f18 - f12;
        float f22 = f18 + f12;
        float f23 = (float)Math.toDegrees(Math.atan(f12 / f14));
        float f24 = 90.0f - f23;
        f14 = f19 - f17;
        shapePath.lineTo(f14, 0.0f);
        float f25 = f19 + f17;
        float f26 = f17 * f15;
        float f27 = f25;
        f25 = f26;
        float f28 = f23;
        shapePath.addArc(f14, 0.0f, f27, f26, 270.0f, f23);
        f14 = f18 - f16;
        f19 = -f16 - f20;
        f27 = f18 + f16;
        f25 = f16 - f20;
        f12 = 180.0f;
        float f29 = f12 - f24;
        f23 = f24 * f15 - f12;
        shapePath.addArc(f14, f19, f27, f25, f29, f23);
        f14 = f22 - f17;
        f27 = f22 + f17;
        f29 = 270.0f - f28;
        f25 = f26;
        f23 = f28;
        shapePath.addArc(f14, 0.0f, f27, f26, f29, f28);
        shapePath.lineTo(f10, 0.0f);
    }

    public float getFabCradleMargin() {
        return this.fabMargin;
    }

    public float getFabCradleRoundedCornerRadius() {
        return this.roundedCornerRadius;
    }

    public float getFabDiameter() {
        return this.fabDiameter;
    }

    public float getHorizontalOffset() {
        return this.horizontalOffset;
    }

    public void setCradleVerticalOffset(float f10) {
        this.cradleVerticalOffset = f10;
    }

    public void setFabCradleMargin(float f10) {
        this.fabMargin = f10;
    }

    public void setFabCradleRoundedCornerRadius(float f10) {
        this.roundedCornerRadius = f10;
    }

    public void setFabDiameter(float f10) {
        this.fabDiameter = f10;
    }

    public void setHorizontalOffset(float f10) {
        this.horizontalOffset = f10;
    }
}

