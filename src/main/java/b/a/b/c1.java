/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.Surface
 */
package b.a.b;

import android.view.Surface;
import androidx.camera.core.SurfaceRequest;
import androidx.core.util.Consumer;

public final class c1
implements Runnable {
    public final /* synthetic */ Consumer a;
    public final /* synthetic */ Surface b;

    public /* synthetic */ c1(Consumer consumer, Surface surface) {
        this.a = consumer;
        this.b = surface;
    }

    public final void run() {
        Consumer consumer = this.a;
        Surface surface = this.b;
        SurfaceRequest.f(consumer, surface);
    }
}

