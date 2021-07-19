/*
 * Decompiled with CFR 0.151.
 */
package b.a.d;

import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.SurfaceRequest$TransformationInfo;
import androidx.camera.core.SurfaceRequest$TransformationInfoListener;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.view.PreviewView$1;

public final class i
implements SurfaceRequest$TransformationInfoListener {
    public final /* synthetic */ PreviewView$1 a;
    public final /* synthetic */ CameraInternal b;
    public final /* synthetic */ SurfaceRequest c;

    public /* synthetic */ i(PreviewView$1 previewView$1, CameraInternal cameraInternal, SurfaceRequest surfaceRequest) {
        this.a = previewView$1;
        this.b = cameraInternal;
        this.c = surfaceRequest;
    }

    public final void onTransformationInfoUpdate(SurfaceRequest$TransformationInfo surfaceRequest$TransformationInfo) {
        PreviewView$1 previewView$1 = this.a;
        CameraInternal cameraInternal = this.b;
        SurfaceRequest surfaceRequest = this.c;
        previewView$1.d(cameraInternal, surfaceRequest, surfaceRequest$TransformationInfo);
    }
}

