/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.internal;

import androidx.camera.core.internal.ImmutableZoomState;

public final class AutoValue_ImmutableZoomState
extends ImmutableZoomState {
    private final float linearZoom;
    private final float maxZoomRatio;
    private final float minZoomRatio;
    private final float zoomRatio;

    public AutoValue_ImmutableZoomState(float f10, float f11, float f12, float f13) {
        this.zoomRatio = f10;
        this.maxZoomRatio = f11;
        this.minZoomRatio = f12;
        this.linearZoom = f13;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        int n10 = object instanceof ImmutableZoomState;
        if (n10 != 0) {
            float f10;
            int n11;
            float f11;
            int n12;
            object = (ImmutableZoomState)object;
            float f12 = this.zoomRatio;
            n10 = Float.floatToIntBits(f12);
            if (n10 != (n12 = Float.floatToIntBits(f11 = ((ImmutableZoomState)object).getZoomRatio())) || (n10 = Float.floatToIntBits(f12 = this.maxZoomRatio)) != (n12 = Float.floatToIntBits(f11 = ((ImmutableZoomState)object).getMaxZoomRatio())) || (n10 = Float.floatToIntBits(f12 = this.minZoomRatio)) != (n12 = Float.floatToIntBits(f11 = ((ImmutableZoomState)object).getMinZoomRatio())) || (n10 = Float.floatToIntBits(f12 = this.linearZoom)) != (n11 = Float.floatToIntBits(f10 = ((ImmutableZoomState)object).getLinearZoom()))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public float getLinearZoom() {
        return this.linearZoom;
    }

    public float getMaxZoomRatio() {
        return this.maxZoomRatio;
    }

    public float getMinZoomRatio() {
        return this.minZoomRatio;
    }

    public float getZoomRatio() {
        return this.zoomRatio;
    }

    public int hashCode() {
        int n10 = Float.floatToIntBits(this.zoomRatio);
        int n11 = 1000003;
        n10 = (n10 ^ n11) * n11;
        int n12 = Float.floatToIntBits(this.maxZoomRatio);
        n10 = (n10 ^ n12) * n11;
        n12 = Float.floatToIntBits(this.minZoomRatio);
        n10 = (n10 ^ n12) * n11;
        n11 = Float.floatToIntBits(this.linearZoom);
        return n10 ^ n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ImmutableZoomState{zoomRatio=");
        float f10 = this.zoomRatio;
        stringBuilder.append(f10);
        stringBuilder.append(", maxZoomRatio=");
        f10 = this.maxZoomRatio;
        stringBuilder.append(f10);
        stringBuilder.append(", minZoomRatio=");
        f10 = this.minZoomRatio;
        stringBuilder.append(f10);
        stringBuilder.append(", linearZoom=");
        f10 = this.linearZoom;
        stringBuilder.append(f10);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

