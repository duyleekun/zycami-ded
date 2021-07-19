/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.DeferrableSurface;

public final class DeferrableSurface$SurfaceClosedException
extends Exception {
    public DeferrableSurface mDeferrableSurface;

    public DeferrableSurface$SurfaceClosedException(String string2, DeferrableSurface deferrableSurface) {
        super(string2);
        this.mDeferrableSurface = deferrableSurface;
    }

    public DeferrableSurface getDeferrableSurface() {
        return this.mDeferrableSurface;
    }
}

