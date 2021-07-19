/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core;

import androidx.camera.core.UseCase;
import androidx.camera.core.UseCaseGroup;
import androidx.camera.core.ViewPort;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.List;

public final class UseCaseGroup$Builder {
    private final List mUseCases;
    private ViewPort mViewPort;

    public UseCaseGroup$Builder() {
        ArrayList arrayList;
        this.mUseCases = arrayList = new ArrayList();
    }

    public UseCaseGroup$Builder addUseCase(UseCase useCase) {
        this.mUseCases.add(useCase);
        return this;
    }

    public UseCaseGroup build() {
        Preconditions.checkArgument(this.mUseCases.isEmpty() ^ true, "UseCase must not be empty.");
        ViewPort viewPort = this.mViewPort;
        List list = this.mUseCases;
        UseCaseGroup useCaseGroup = new UseCaseGroup(viewPort, list);
        return useCaseGroup;
    }

    public UseCaseGroup$Builder setViewPort(ViewPort viewPort) {
        this.mViewPort = viewPort;
        return this;
    }
}

