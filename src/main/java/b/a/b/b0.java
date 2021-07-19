/*
 * Decompiled with CFR 0.151.
 */
package b.a.b;

import androidx.camera.core.ImageCapture;
import com.google.common.util.concurrent.ListenableFuture;

public final class b0
implements Runnable {
    public final /* synthetic */ ListenableFuture a;

    public /* synthetic */ b0(ListenableFuture listenableFuture) {
        this.a = listenableFuture;
    }

    public final void run() {
        ImageCapture.z(this.a);
    }
}

