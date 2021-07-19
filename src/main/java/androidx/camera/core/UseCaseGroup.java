/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core;

import androidx.camera.core.ViewPort;
import java.util.List;

public final class UseCaseGroup {
    private final List mUseCases;
    private final ViewPort mViewPort;

    public UseCaseGroup(ViewPort viewPort, List list) {
        this.mViewPort = viewPort;
        this.mUseCases = list;
    }

    public List getUseCases() {
        return this.mUseCases;
    }

    public ViewPort getViewPort() {
        return this.mViewPort;
    }
}

