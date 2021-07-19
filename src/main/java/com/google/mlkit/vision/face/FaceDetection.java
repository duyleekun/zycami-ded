/*
 * Decompiled with CFR 0.151.
 */
package com.google.mlkit.vision.face;

import com.google.android.gms.common.internal.Preconditions;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.vision.face.FaceDetector;
import com.google.mlkit.vision.face.FaceDetectorOptions;
import com.google.mlkit.vision.face.internal.FaceDetectorImpl$zza;

public class FaceDetection {
    private FaceDetection() {
    }

    public static FaceDetector getClient() {
        return ((FaceDetectorImpl$zza)MlKitContext.getInstance().get(FaceDetectorImpl$zza.class)).zza();
    }

    public static FaceDetector getClient(FaceDetectorOptions faceDetectorOptions) {
        Preconditions.checkNotNull(faceDetectorOptions, "You must provide a valid FaceDetectorOptions.");
        return ((FaceDetectorImpl$zza)MlKitContext.getInstance().get(FaceDetectorImpl$zza.class)).zza(faceDetectorOptions);
    }
}

