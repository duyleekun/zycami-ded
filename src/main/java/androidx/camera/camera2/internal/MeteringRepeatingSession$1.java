/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.SurfaceTexture
 *  android.view.Surface
 */
package androidx.camera.camera2.internal;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import androidx.camera.camera2.internal.MeteringRepeatingSession;
import androidx.camera.core.impl.utils.futures.FutureCallback;

public class MeteringRepeatingSession$1
implements FutureCallback {
    public final /* synthetic */ MeteringRepeatingSession this$0;
    public final /* synthetic */ Surface val$surface;
    public final /* synthetic */ SurfaceTexture val$surfaceTexture;

    public MeteringRepeatingSession$1(MeteringRepeatingSession meteringRepeatingSession, Surface surface, SurfaceTexture surfaceTexture) {
        this.this$0 = meteringRepeatingSession;
        this.val$surface = surface;
        this.val$surfaceTexture = surfaceTexture;
    }

    public void onFailure(Throwable throwable) {
        IllegalStateException illegalStateException = new IllegalStateException("Future should never fail. Did it get completed by GC?", throwable);
        throw illegalStateException;
    }

    public void onSuccess(Void void_) {
        this.val$surface.release();
        this.val$surfaceTexture.release();
    }
}

