/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.Surface
 */
package androidx.camera.core;

import android.view.Surface;
import androidx.camera.core.SurfaceRequest$Result;
import java.util.Objects;

public final class AutoValue_SurfaceRequest_Result
extends SurfaceRequest$Result {
    private final int resultCode;
    private final Surface surface;

    public AutoValue_SurfaceRequest_Result(int n10, Surface surface) {
        this.resultCode = n10;
        Objects.requireNonNull(surface, "Null surface");
        this.surface = surface;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        int n10 = object instanceof SurfaceRequest$Result;
        if (n10 != 0) {
            Surface surface;
            boolean bl3;
            n10 = this.resultCode;
            int n11 = ((SurfaceRequest$Result)(object = (SurfaceRequest$Result)object)).getResultCode();
            if (n10 != n11 || !(bl3 = (surface = this.surface).equals(object = ((SurfaceRequest$Result)object).getSurface()))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int getResultCode() {
        return this.resultCode;
    }

    public Surface getSurface() {
        return this.surface;
    }

    public int hashCode() {
        int n10 = this.resultCode;
        int n11 = 1000003;
        n10 = (n10 ^ n11) * n11;
        n11 = this.surface.hashCode();
        return n10 ^ n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Result{resultCode=");
        int n10 = this.resultCode;
        stringBuilder.append(n10);
        stringBuilder.append(", surface=");
        Surface surface = this.surface;
        stringBuilder.append(surface);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

