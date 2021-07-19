/*
 * Decompiled with CFR 0.151.
 */
package b.a.b;

import androidx.arch.core.util.Function;
import androidx.camera.core.CameraX;

public final class e
implements Function {
    public final /* synthetic */ CameraX a;

    public /* synthetic */ e(CameraX cameraX) {
        this.a = cameraX;
    }

    public final Object apply(Object object) {
        CameraX cameraX = this.a;
        object = (Void)object;
        CameraX.b(cameraX, (Void)object);
        return cameraX;
    }
}

