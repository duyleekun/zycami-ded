/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.CaptureConfig$Builder;
import androidx.camera.core.impl.CaptureStage;

public final class CaptureStage$DefaultCaptureStage
implements CaptureStage {
    private final CaptureConfig mCaptureConfig;

    public CaptureStage$DefaultCaptureStage() {
        Object object = new CaptureConfig$Builder();
        this.mCaptureConfig = object = ((CaptureConfig$Builder)object).build();
    }

    public CaptureConfig getCaptureConfig() {
        return this.mCaptureConfig;
    }

    public int getId() {
        return 0;
    }
}

