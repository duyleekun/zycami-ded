/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.camera2.internal;

import androidx.camera.core.ZoomState;
import androidx.core.math.MathUtils;
import java.io.Serializable;

public class ZoomStateImpl
implements ZoomState {
    private float mLinearZoom;
    private final float mMaxZoomRatio;
    private final float mMinZoomRatio;
    private float mZoomRatio;

    public ZoomStateImpl(float f10, float f11) {
        this.mMaxZoomRatio = f10;
        this.mMinZoomRatio = f11;
    }

    private float getPercentageByRatio(float f10) {
        float f11 = this.mMaxZoomRatio;
        float f12 = this.mMinZoomRatio;
        float f13 = f11 - f12;
        Object object = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
        if (object == false) {
            return 0.0f;
        }
        object = f10 == f11 ? 0 : (f10 > f11 ? 1 : -1);
        float f14 = 1.0f;
        if (object == false) {
            return f14;
        }
        object = f10 == f12 ? 0 : (f10 > f12 ? 1 : -1);
        if (object == false) {
            return 0.0f;
        }
        f10 = f14 / f10;
        f11 = f14 / f11;
        return (f10 -= (f14 /= f12)) / (f11 -= f14);
    }

    private float getRatioByPercentage(float f10) {
        float f11 = 1.0f;
        float f12 = f10 - f11;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object == false) {
            return this.mMaxZoomRatio;
        }
        float f13 = 0.0f;
        float f14 = f10 - 0.0f;
        object = f14 == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1);
        if (object == false) {
            return this.mMinZoomRatio;
        }
        f13 = this.mMaxZoomRatio;
        double d10 = f11 / f13;
        float f15 = this.mMinZoomRatio;
        double d11 = f11 / f15;
        d10 -= d11;
        double d12 = f10;
        d11 += (d10 *= d12);
        d12 = 1.0 / d11;
        double d13 = f15;
        double d14 = f13;
        return (float)MathUtils.clamp(d12, d13, d14);
    }

    public float getLinearZoom() {
        return this.mLinearZoom;
    }

    public float getMaxZoomRatio() {
        return this.mMaxZoomRatio;
    }

    public float getMinZoomRatio() {
        return this.mMinZoomRatio;
    }

    public float getZoomRatio() {
        return this.mZoomRatio;
    }

    public void setLinearZoom(float f10) {
        Serializable serializable;
        float f11 = 1.0f;
        float f12 = f10 - f11;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object <= 0) {
            f11 = 0.0f;
            serializable = null;
            float f13 = f10 - 0.0f;
            object = f13 == 0.0f ? 0 : (f13 < 0.0f ? -1 : 1);
            if (object >= 0) {
                this.mLinearZoom = f10;
                this.mZoomRatio = f10 = this.getRatioByPercentage(f10);
                return;
            }
        }
        serializable = new StringBuilder();
        serializable.append("Requested linearZoom ");
        serializable.append(f10);
        serializable.append(" is not within valid range [0..1]");
        String string2 = serializable.toString();
        serializable = new IllegalArgumentException(string2);
        throw serializable;
    }

    public void setZoomRatio(float f10) {
        float f11;
        float f12 = this.mMaxZoomRatio;
        float f13 = f10 - f12;
        Object object = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
        if (object <= 0 && (object = (f11 = f10 - (f12 = this.mMinZoomRatio)) == 0.0f ? 0 : (f11 < 0.0f ? -1 : 1)) >= 0) {
            this.mZoomRatio = f10;
            this.mLinearZoom = f10 = this.getPercentageByRatio(f10);
            return;
        }
        Serializable serializable = new StringBuilder();
        serializable.append("Requested zoomRatio ");
        serializable.append(f10);
        serializable.append(" is not within valid range [");
        f10 = this.mMinZoomRatio;
        serializable.append(f10);
        serializable.append(" , ");
        f10 = this.mMaxZoomRatio;
        serializable.append(f10);
        serializable.append("]");
        String string2 = serializable.toString();
        serializable = new IllegalArgumentException(string2);
        throw serializable;
    }
}

