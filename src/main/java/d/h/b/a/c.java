/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.SurfaceTexture
 */
package d.h.b.a;

import android.graphics.SurfaceTexture;
import com.google.mediapipe.components.ExternalTextureConverter$RenderThread;

public final class c
implements Runnable {
    public final /* synthetic */ ExternalTextureConverter$RenderThread a;
    public final /* synthetic */ SurfaceTexture b;

    public /* synthetic */ c(ExternalTextureConverter$RenderThread renderThread, SurfaceTexture surfaceTexture) {
        this.a = renderThread;
        this.b = surfaceTexture;
    }

    public final void run() {
        ExternalTextureConverter$RenderThread externalTextureConverter$RenderThread = this.a;
        SurfaceTexture surfaceTexture = this.b;
        externalTextureConverter$RenderThread.b(surfaceTexture);
    }
}

