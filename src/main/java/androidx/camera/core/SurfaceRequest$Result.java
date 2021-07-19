/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.Surface
 */
package androidx.camera.core;

import android.view.Surface;
import androidx.camera.core.AutoValue_SurfaceRequest_Result;

public abstract class SurfaceRequest$Result {
    public static final int RESULT_INVALID_SURFACE = 2;
    public static final int RESULT_REQUEST_CANCELLED = 1;
    public static final int RESULT_SURFACE_ALREADY_PROVIDED = 3;
    public static final int RESULT_SURFACE_USED_SUCCESSFULLY = 0;
    public static final int RESULT_WILL_NOT_PROVIDE_SURFACE = 4;

    public static SurfaceRequest$Result of(int n10, Surface surface) {
        AutoValue_SurfaceRequest_Result autoValue_SurfaceRequest_Result = new AutoValue_SurfaceRequest_Result(n10, surface);
        return autoValue_SurfaceRequest_Result;
    }

    public abstract int getResultCode();

    public abstract Surface getSurface();
}

