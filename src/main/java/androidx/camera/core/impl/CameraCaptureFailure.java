/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.CameraCaptureFailure$Reason;

public final class CameraCaptureFailure {
    private final CameraCaptureFailure$Reason mReason;

    public CameraCaptureFailure(CameraCaptureFailure$Reason cameraCaptureFailure$Reason) {
        this.mReason = cameraCaptureFailure$Reason;
    }

    public CameraCaptureFailure$Reason getReason() {
        return this.mReason;
    }
}

