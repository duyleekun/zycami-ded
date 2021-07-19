/*
 * Decompiled with CFR 0.151.
 */
package b.a.b;

import androidx.camera.core.SafeCloseImageReaderProxy;

public final class u1
implements Runnable {
    public final /* synthetic */ SafeCloseImageReaderProxy a;

    public /* synthetic */ u1(SafeCloseImageReaderProxy safeCloseImageReaderProxy) {
        this.a = safeCloseImageReaderProxy;
    }

    public final void run() {
        this.a.safeClose();
    }
}

