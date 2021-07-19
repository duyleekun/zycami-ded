/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 */
package androidx.camera.core;

import android.graphics.Rect;
import androidx.camera.core.AutoValue_SurfaceRequest_TransformationInfo;

public abstract class SurfaceRequest$TransformationInfo {
    public static SurfaceRequest$TransformationInfo of(Rect rect, int n10, int n11) {
        AutoValue_SurfaceRequest_TransformationInfo autoValue_SurfaceRequest_TransformationInfo = new AutoValue_SurfaceRequest_TransformationInfo(rect, n10, n11);
        return autoValue_SurfaceRequest_TransformationInfo;
    }

    public abstract Rect getCropRect();

    public abstract int getRotationDegrees();

    public abstract int getTargetRotation();
}

