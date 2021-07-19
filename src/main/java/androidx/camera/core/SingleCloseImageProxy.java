/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core;

import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.ImageProxy;

public final class SingleCloseImageProxy
extends ForwardingImageProxy {
    private boolean mClosed = false;

    public SingleCloseImageProxy(ImageProxy imageProxy) {
        super(imageProxy);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void close() {
        synchronized (this) {
            boolean bl2 = this.mClosed;
            if (!bl2) {
                this.mClosed = bl2 = true;
                super.close();
            }
            return;
        }
    }
}

