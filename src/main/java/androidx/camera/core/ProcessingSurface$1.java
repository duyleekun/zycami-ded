/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.Surface
 */
package androidx.camera.core;

import android.view.Surface;
import androidx.camera.core.Logger;
import androidx.camera.core.ProcessingSurface;
import androidx.camera.core.impl.utils.futures.FutureCallback;

public class ProcessingSurface$1
implements FutureCallback {
    public final /* synthetic */ ProcessingSurface this$0;

    public ProcessingSurface$1(ProcessingSurface processingSurface) {
        this.this$0 = processingSurface;
    }

    public void onFailure(Throwable throwable) {
        Logger.e("ProcessingSurfaceTextur", "Failed to extract Listenable<Surface>.", throwable);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onSuccess(Surface surface) {
        Object object = this.this$0.mLock;
        synchronized (object) {
            Object object2 = this.this$0;
            object2 = ((ProcessingSurface)object2).mCaptureProcessor;
            int n10 = 1;
            object2.onOutputSurface(surface, n10);
            return;
        }
    }
}

