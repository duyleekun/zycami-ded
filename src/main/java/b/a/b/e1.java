/*
 * Decompiled with CFR 0.151.
 */
package b.a.b;

import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.SurfaceRequest$TransformationInfo;
import androidx.camera.core.SurfaceRequest$TransformationInfoListener;

public final class e1
implements Runnable {
    public final /* synthetic */ SurfaceRequest$TransformationInfoListener a;
    public final /* synthetic */ SurfaceRequest$TransformationInfo b;

    public /* synthetic */ e1(SurfaceRequest$TransformationInfoListener surfaceRequest$TransformationInfoListener, SurfaceRequest$TransformationInfo surfaceRequest$TransformationInfo) {
        this.a = surfaceRequest$TransformationInfoListener;
        this.b = surfaceRequest$TransformationInfo;
    }

    public final void run() {
        SurfaceRequest$TransformationInfoListener surfaceRequest$TransformationInfoListener = this.a;
        SurfaceRequest$TransformationInfo surfaceRequest$TransformationInfo = this.b;
        SurfaceRequest.h(surfaceRequest$TransformationInfoListener, surfaceRequest$TransformationInfo);
    }
}

