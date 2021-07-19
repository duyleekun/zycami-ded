/*
 * Decompiled with CFR 0.151.
 */
package b.a.b;

import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.SurfaceRequest$TransformationInfo;
import androidx.camera.core.SurfaceRequest$TransformationInfoListener;

public final class f1
implements Runnable {
    public final /* synthetic */ SurfaceRequest$TransformationInfoListener a;
    public final /* synthetic */ SurfaceRequest$TransformationInfo b;

    public /* synthetic */ f1(SurfaceRequest$TransformationInfoListener surfaceRequest$TransformationInfoListener, SurfaceRequest$TransformationInfo surfaceRequest$TransformationInfo) {
        this.a = surfaceRequest$TransformationInfoListener;
        this.b = surfaceRequest$TransformationInfo;
    }

    public final void run() {
        SurfaceRequest$TransformationInfoListener surfaceRequest$TransformationInfoListener = this.a;
        SurfaceRequest$TransformationInfo surfaceRequest$TransformationInfo = this.b;
        SurfaceRequest.i(surfaceRequest$TransformationInfoListener, surfaceRequest$TransformationInfo);
    }
}

