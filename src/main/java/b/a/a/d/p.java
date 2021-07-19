/*
 * Decompiled with CFR 0.151.
 */
package b.a.a.d;

import androidx.camera.camera2.internal.Camera2CameraImpl;
import java.util.Collection;

public final class p
implements Runnable {
    public final /* synthetic */ Camera2CameraImpl a;
    public final /* synthetic */ Collection b;

    public /* synthetic */ p(Camera2CameraImpl camera2CameraImpl, Collection collection) {
        this.a = camera2CameraImpl;
        this.b = collection;
    }

    public final void run() {
        Camera2CameraImpl camera2CameraImpl = this.a;
        Collection collection = this.b;
        camera2CameraImpl.i(collection);
    }
}

