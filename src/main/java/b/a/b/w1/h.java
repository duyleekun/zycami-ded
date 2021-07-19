/*
 * Decompiled with CFR 0.151.
 */
package b.a.b.w1;

import androidx.camera.core.impl.DeferrableSurfaces;
import com.google.common.util.concurrent.ListenableFuture;

public final class h
implements Runnable {
    public final /* synthetic */ ListenableFuture a;

    public /* synthetic */ h(ListenableFuture listenableFuture) {
        this.a = listenableFuture;
    }

    public final void run() {
        DeferrableSurfaces.c(this.a);
    }
}

