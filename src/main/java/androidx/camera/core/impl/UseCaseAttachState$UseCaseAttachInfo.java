/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.SessionConfig;

public final class UseCaseAttachState$UseCaseAttachInfo {
    private boolean mActive = false;
    private boolean mAttached = false;
    private final SessionConfig mSessionConfig;

    public UseCaseAttachState$UseCaseAttachInfo(SessionConfig sessionConfig) {
        this.mSessionConfig = sessionConfig;
    }

    public boolean getActive() {
        return this.mActive;
    }

    public boolean getAttached() {
        return this.mAttached;
    }

    public SessionConfig getSessionConfig() {
        return this.mSessionConfig;
    }

    public void setActive(boolean bl2) {
        this.mActive = bl2;
    }

    public void setAttached(boolean bl2) {
        this.mAttached = bl2;
    }
}

