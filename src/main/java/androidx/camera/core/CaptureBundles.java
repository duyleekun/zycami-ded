/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core;

import androidx.camera.core.CaptureBundles$CaptureBundleImpl;
import androidx.camera.core.impl.CaptureBundle;
import androidx.camera.core.impl.CaptureStage;
import androidx.camera.core.impl.CaptureStage$DefaultCaptureStage;
import java.util.Arrays;
import java.util.List;

public final class CaptureBundles {
    private CaptureBundles() {
    }

    public static CaptureBundle createCaptureBundle(List list) {
        CaptureBundles$CaptureBundleImpl captureBundles$CaptureBundleImpl = new CaptureBundles$CaptureBundleImpl(list);
        return captureBundles$CaptureBundleImpl;
    }

    public static CaptureBundle createCaptureBundle(CaptureStage ... object) {
        object = Arrays.asList(object);
        CaptureBundles$CaptureBundleImpl captureBundles$CaptureBundleImpl = new CaptureBundles$CaptureBundleImpl((List)object);
        return captureBundles$CaptureBundleImpl;
    }

    public static CaptureBundle singleDefaultCaptureBundle() {
        CaptureStage[] captureStageArray = new CaptureStage[1];
        CaptureStage$DefaultCaptureStage captureStage$DefaultCaptureStage = new CaptureStage$DefaultCaptureStage();
        captureStageArray[0] = captureStage$DefaultCaptureStage;
        return CaptureBundles.createCaptureBundle(captureStageArray);
    }
}

