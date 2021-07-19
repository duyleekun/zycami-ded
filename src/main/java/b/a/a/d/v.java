/*
 * Decompiled with CFR 0.151.
 */
package b.a.a.d;

import androidx.camera.camera2.internal.Camera2CameraImpl$StateCallback$ScheduledReopen;

public final class v
implements Runnable {
    public final /* synthetic */ Camera2CameraImpl$StateCallback$ScheduledReopen a;

    public /* synthetic */ v(Camera2CameraImpl$StateCallback$ScheduledReopen camera2CameraImpl$StateCallback$ScheduledReopen) {
        this.a = camera2CameraImpl$StateCallback$ScheduledReopen;
    }

    public final void run() {
        this.a.b();
    }
}

