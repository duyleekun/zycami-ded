/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.mlkit.vision.face.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_vision_face.zzel;
import com.google.mlkit.common.sdkinternal.ExecutorSelector;
import com.google.mlkit.vision.face.FaceDetectorOptions;
import com.google.mlkit.vision.face.internal.FaceDetectorImpl;

public class FaceDetectorImpl$zza {
    private final Context zza;
    private final zzel zzb;
    private final ExecutorSelector zzc;

    public FaceDetectorImpl$zza(Context context, zzel zzel2, ExecutorSelector executorSelector) {
        this.zza = context;
        this.zzb = zzel2;
        this.zzc = executorSelector;
    }

    public final FaceDetectorImpl zza() {
        FaceDetectorOptions faceDetectorOptions = FaceDetectorImpl.zza;
        return this.zza(faceDetectorOptions);
    }

    public final FaceDetectorImpl zza(FaceDetectorOptions faceDetectorOptions) {
        Preconditions.checkNotNull(faceDetectorOptions, "You must provide a valid FaceDetectorOptions.");
        Context context = this.zza;
        zzel zzel2 = this.zzb;
        ExecutorSelector executorSelector = this.zzc;
        FaceDetectorImpl faceDetectorImpl = new FaceDetectorImpl(context, zzel2, executorSelector, faceDetectorOptions, null);
        return faceDetectorImpl;
    }
}

