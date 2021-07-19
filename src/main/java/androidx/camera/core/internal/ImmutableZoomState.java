/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.internal;

import androidx.camera.core.ZoomState;
import androidx.camera.core.internal.AutoValue_ImmutableZoomState;

public abstract class ImmutableZoomState
implements ZoomState {
    public static ZoomState create(float f10, float f11, float f12, float f13) {
        AutoValue_ImmutableZoomState autoValue_ImmutableZoomState = new AutoValue_ImmutableZoomState(f10, f11, f12, f13);
        return autoValue_ImmutableZoomState;
    }

    public static ZoomState create(ZoomState zoomState) {
        float f10 = zoomState.getZoomRatio();
        float f11 = zoomState.getMaxZoomRatio();
        float f12 = zoomState.getMinZoomRatio();
        float f13 = zoomState.getLinearZoom();
        AutoValue_ImmutableZoomState autoValue_ImmutableZoomState = new AutoValue_ImmutableZoomState(f10, f11, f12, f13);
        return autoValue_ImmutableZoomState;
    }

    public abstract float getLinearZoom();

    public abstract float getMaxZoomRatio();

    public abstract float getMinZoomRatio();

    public abstract float getZoomRatio();
}

