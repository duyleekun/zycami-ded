/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.SurfaceTexture
 */
package d.h.b.a;

import android.graphics.SurfaceTexture;
import com.google.mediapipe.components.ExternalTextureConverter;

public final class e
implements Runnable {
    public final /* synthetic */ ExternalTextureConverter a;
    public final /* synthetic */ SurfaceTexture b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;

    public /* synthetic */ e(ExternalTextureConverter externalTextureConverter, SurfaceTexture surfaceTexture, int n10, int n11) {
        this.a = externalTextureConverter;
        this.b = surfaceTexture;
        this.c = n10;
        this.d = n11;
    }

    public final void run() {
        ExternalTextureConverter externalTextureConverter = this.a;
        SurfaceTexture surfaceTexture = this.b;
        int n10 = this.c;
        int n11 = this.d;
        externalTextureConverter.f(surfaceTexture, n10, n11);
    }
}

