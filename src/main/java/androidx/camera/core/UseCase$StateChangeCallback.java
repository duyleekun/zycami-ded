/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core;

import androidx.camera.core.UseCase;

public interface UseCase$StateChangeCallback {
    public void onUseCaseActive(UseCase var1);

    public void onUseCaseInactive(UseCase var1);

    public void onUseCaseReset(UseCase var1);

    public void onUseCaseUpdated(UseCase var1);
}

