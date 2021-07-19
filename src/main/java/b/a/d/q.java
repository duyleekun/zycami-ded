/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.Surface
 */
package b.a.d;

import android.view.Surface;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.view.TextureViewImplementation;
import com.google.common.util.concurrent.ListenableFuture;

public final class q
implements Runnable {
    public final /* synthetic */ TextureViewImplementation a;
    public final /* synthetic */ Surface b;
    public final /* synthetic */ ListenableFuture c;
    public final /* synthetic */ SurfaceRequest d;

    public /* synthetic */ q(TextureViewImplementation textureViewImplementation, Surface surface, ListenableFuture listenableFuture, SurfaceRequest surfaceRequest) {
        this.a = textureViewImplementation;
        this.b = surface;
        this.c = listenableFuture;
        this.d = surfaceRequest;
    }

    public final void run() {
        TextureViewImplementation textureViewImplementation = this.a;
        Surface surface = this.b;
        ListenableFuture listenableFuture = this.c;
        SurfaceRequest surfaceRequest = this.d;
        textureViewImplementation.f(surface, listenableFuture, surfaceRequest);
    }
}

