/*
 * Decompiled with CFR 0.151.
 */
package com.google.mlkit.vision.common.internal;

import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.common.internal.MobileVisionBase;
import java.util.concurrent.Callable;

public final class zzc
implements Callable {
    private final MobileVisionBase zza;
    private final InputImage zzb;

    public zzc(MobileVisionBase mobileVisionBase, InputImage inputImage) {
        this.zza = mobileVisionBase;
        this.zzb = inputImage;
    }

    public final Object call() {
        MobileVisionBase mobileVisionBase = this.zza;
        InputImage inputImage = this.zzb;
        return mobileVisionBase.zza(inputImage);
    }
}

