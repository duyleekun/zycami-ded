/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.SurfaceTexture
 */
package androidx.camera.view;

import android.graphics.SurfaceTexture;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceRequest$Result;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.view.TextureViewImplementation;
import androidx.camera.view.TextureViewImplementation$1;
import androidx.core.util.Preconditions;

public class TextureViewImplementation$1$1
implements FutureCallback {
    public final /* synthetic */ TextureViewImplementation$1 this$1;
    public final /* synthetic */ SurfaceTexture val$surfaceTexture;

    public TextureViewImplementation$1$1(TextureViewImplementation$1 textureViewImplementation$1, SurfaceTexture surfaceTexture) {
        this.this$1 = textureViewImplementation$1;
        this.val$surfaceTexture = surfaceTexture;
    }

    public void onFailure(Throwable throwable) {
        IllegalStateException illegalStateException = new IllegalStateException("SurfaceReleaseFuture did not complete nicely.", throwable);
        throw illegalStateException;
    }

    public void onSuccess(SurfaceRequest$Result object) {
        int n10;
        int n11 = ((SurfaceRequest$Result)object).getResultCode();
        if (n11 != (n10 = 3)) {
            n11 = 1;
        } else {
            n11 = 0;
            object = null;
        }
        Preconditions.checkState(n11 != 0, "Unexpected result from SurfaceRequest. Surface was provided twice.");
        Logger.d("TextureViewImpl", "SurfaceTexture about to manually be destroyed");
        this.val$surfaceTexture.release();
        object = this.this$1.this$0;
        SurfaceTexture surfaceTexture = ((TextureViewImplementation)object).mDetachedSurfaceTexture;
        if (surfaceTexture != null) {
            n10 = 0;
            surfaceTexture = null;
            ((TextureViewImplementation)object).mDetachedSurfaceTexture = null;
        }
    }
}

