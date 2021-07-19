/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

import androidx.camera.core.ImageInfo;
import androidx.camera.core.impl.CaptureStage;

public interface ImageInfoProcessor {
    public CaptureStage getCaptureStage();

    public boolean process(ImageInfo var1);
}

