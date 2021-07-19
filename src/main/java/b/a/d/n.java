/*
 * Decompiled with CFR 0.151.
 */
package b.a.d;

import androidx.camera.core.SurfaceRequest$Result;
import androidx.camera.view.SurfaceViewImplementation$SurfaceRequestCallback;
import androidx.core.util.Consumer;

public final class n
implements Consumer {
    public final /* synthetic */ SurfaceViewImplementation$SurfaceRequestCallback a;

    public /* synthetic */ n(SurfaceViewImplementation$SurfaceRequestCallback surfaceViewImplementation$SurfaceRequestCallback) {
        this.a = surfaceViewImplementation$SurfaceRequestCallback;
    }

    public final void accept(Object object) {
        SurfaceViewImplementation$SurfaceRequestCallback surfaceViewImplementation$SurfaceRequestCallback = this.a;
        object = (SurfaceRequest$Result)object;
        surfaceViewImplementation$SurfaceRequestCallback.b((SurfaceRequest$Result)object);
    }
}

