/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core;

import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.DeferrableSurface;
import com.google.common.util.concurrent.ListenableFuture;

public class SurfaceRequest$2
extends DeferrableSurface {
    public final /* synthetic */ SurfaceRequest this$0;

    public SurfaceRequest$2(SurfaceRequest surfaceRequest) {
        this.this$0 = surfaceRequest;
    }

    public ListenableFuture provideSurface() {
        return this.this$0.mSurfaceFuture;
    }
}

