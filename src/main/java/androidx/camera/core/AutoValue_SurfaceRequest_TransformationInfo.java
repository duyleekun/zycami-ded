/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 */
package androidx.camera.core;

import android.graphics.Rect;
import androidx.camera.core.SurfaceRequest$TransformationInfo;
import java.util.Objects;

public final class AutoValue_SurfaceRequest_TransformationInfo
extends SurfaceRequest$TransformationInfo {
    private final Rect cropRect;
    private final int rotationDegrees;
    private final int targetRotation;

    public AutoValue_SurfaceRequest_TransformationInfo(Rect rect, int n10, int n11) {
        Objects.requireNonNull(rect, "Null cropRect");
        this.cropRect = rect;
        this.rotationDegrees = n10;
        this.targetRotation = n11;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        int n10 = object instanceof SurfaceRequest$TransformationInfo;
        if (n10 != 0) {
            int n11;
            int n12;
            Rect rect = this.cropRect;
            Rect rect2 = ((SurfaceRequest$TransformationInfo)(object = (SurfaceRequest$TransformationInfo)object)).getCropRect();
            n10 = rect.equals((Object)rect2);
            if (n10 == 0 || (n10 = this.rotationDegrees) != (n12 = ((SurfaceRequest$TransformationInfo)object).getRotationDegrees()) || (n10 = this.targetRotation) != (n11 = ((SurfaceRequest$TransformationInfo)object).getTargetRotation())) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public Rect getCropRect() {
        return this.cropRect;
    }

    public int getRotationDegrees() {
        return this.rotationDegrees;
    }

    public int getTargetRotation() {
        return this.targetRotation;
    }

    public int hashCode() {
        int n10 = this.cropRect.hashCode();
        int n11 = 1000003;
        n10 = (n10 ^ n11) * n11;
        int n12 = this.rotationDegrees;
        n10 = (n10 ^ n12) * n11;
        n11 = this.targetRotation;
        return n10 ^ n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TransformationInfo{cropRect=");
        Rect rect = this.cropRect;
        stringBuilder.append(rect);
        stringBuilder.append(", rotationDegrees=");
        int n10 = this.rotationDegrees;
        stringBuilder.append(n10);
        stringBuilder.append(", targetRotation=");
        n10 = this.targetRotation;
        stringBuilder.append(n10);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

