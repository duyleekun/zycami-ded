/*
 * Decompiled with CFR 0.151.
 */
package b.a.c;

import androidx.arch.core.util.Function;
import androidx.camera.core.CameraX;
import androidx.camera.lifecycle.ProcessCameraProvider;

public final class a
implements Function {
    public static final /* synthetic */ a a;

    static {
        a a10;
        a = a10 = new a();
    }

    public final Object apply(Object object) {
        return ProcessCameraProvider.a((CameraX)object);
    }
}

