/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

import androidx.camera.core.CameraSelector;
import androidx.camera.core.ExtendableBuilder;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.CaptureConfig$OptionUnpacker;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.SessionConfig$OptionUnpacker;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.internal.TargetConfig$Builder;
import androidx.camera.core.internal.UseCaseEventConfig$Builder;
import androidx.core.util.Consumer;

public interface UseCaseConfig$Builder
extends TargetConfig$Builder,
ExtendableBuilder,
UseCaseEventConfig$Builder {
    public UseCaseConfig getUseCaseConfig();

    public Object setAttachedUseCasesUpdateListener(Consumer var1);

    public Object setCameraSelector(CameraSelector var1);

    public Object setCaptureOptionUnpacker(CaptureConfig$OptionUnpacker var1);

    public Object setDefaultCaptureConfig(CaptureConfig var1);

    public Object setDefaultSessionConfig(SessionConfig var1);

    public Object setSessionOptionUnpacker(SessionConfig$OptionUnpacker var1);

    public Object setSurfaceOccupancyPriority(int var1);
}

