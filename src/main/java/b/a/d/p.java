/*
 * Decompiled with CFR 0.151.
 */
package b.a.d;

import androidx.camera.core.SurfaceRequest;
import androidx.camera.view.TextureViewImplementation;

public final class p
implements Runnable {
    public final /* synthetic */ TextureViewImplementation a;
    public final /* synthetic */ SurfaceRequest b;

    public /* synthetic */ p(TextureViewImplementation textureViewImplementation, SurfaceRequest surfaceRequest) {
        this.a = textureViewImplementation;
        this.b = surfaceRequest;
    }

    public final void run() {
        TextureViewImplementation textureViewImplementation = this.a;
        SurfaceRequest surfaceRequest = this.b;
        textureViewImplementation.b(surfaceRequest);
    }
}

