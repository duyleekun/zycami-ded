/*
 * Decompiled with CFR 0.151.
 */
package b.a.d;

import androidx.camera.view.SurfaceViewImplementation;

public final class s
implements Runnable {
    public final /* synthetic */ SurfaceViewImplementation a;

    public /* synthetic */ s(SurfaceViewImplementation surfaceViewImplementation) {
        this.a = surfaceViewImplementation;
    }

    public final void run() {
        this.a.notifySurfaceNotInUse();
    }
}

