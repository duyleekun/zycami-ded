/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.SurfaceTexture
 */
package d.v.d.g.e;

import android.graphics.SurfaceTexture;
import androidx.camera.core.Preview$SurfaceProvider;
import androidx.camera.core.SurfaceRequest;
import d.v.d.g.e.e;

public final class a
implements Preview$SurfaceProvider {
    public final /* synthetic */ e a;
    public final /* synthetic */ SurfaceTexture b;

    public /* synthetic */ a(e e10, SurfaceTexture surfaceTexture) {
        this.a = e10;
        this.b = surfaceTexture;
    }

    public final void onSurfaceRequested(SurfaceRequest surfaceRequest) {
        e e10 = this.a;
        SurfaceTexture surfaceTexture = this.b;
        e10.e(surfaceTexture, surfaceRequest);
    }
}

