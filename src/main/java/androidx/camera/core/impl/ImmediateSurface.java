/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.Surface
 */
package androidx.camera.core.impl;

import android.view.Surface;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.utils.futures.Futures;
import com.google.common.util.concurrent.ListenableFuture;

public final class ImmediateSurface
extends DeferrableSurface {
    private final Surface mSurface;

    public ImmediateSurface(Surface surface) {
        this.mSurface = surface;
    }

    public ListenableFuture provideSurface() {
        return Futures.immediateFuture(this.mSurface);
    }
}

