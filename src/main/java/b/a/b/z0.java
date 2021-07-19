/*
 * Decompiled with CFR 0.151.
 */
package b.a.b;

import androidx.camera.core.ProcessingSurface;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.ImageReaderProxy$OnImageAvailableListener;

public final class z0
implements ImageReaderProxy$OnImageAvailableListener {
    public final /* synthetic */ ProcessingSurface a;

    public /* synthetic */ z0(ProcessingSurface processingSurface) {
        this.a = processingSurface;
    }

    public final void onImageAvailable(ImageReaderProxy imageReaderProxy) {
        this.a.g(imageReaderProxy);
    }
}

