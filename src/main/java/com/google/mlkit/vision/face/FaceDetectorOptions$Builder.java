/*
 * Decompiled with CFR 0.151.
 */
package com.google.mlkit.vision.face;

import com.google.mlkit.vision.face.FaceDetectorOptions;
import java.util.concurrent.Executor;

public class FaceDetectorOptions$Builder {
    private int zza;
    private int zzb;
    private int zzc;
    private int zzd;
    private boolean zze;
    private float zzf;
    private Executor zzg;

    public FaceDetectorOptions$Builder() {
        int n10;
        this.zza = n10 = 1;
        this.zzb = n10;
        this.zzc = n10;
        this.zzd = n10;
        this.zze = false;
        this.zzf = 0.1f;
    }

    public FaceDetectorOptions build() {
        int n10 = this.zza;
        int n11 = this.zzb;
        int n12 = this.zzc;
        int n13 = this.zzd;
        boolean bl2 = this.zze;
        float f10 = this.zzf;
        Executor executor = this.zzg;
        FaceDetectorOptions faceDetectorOptions = new FaceDetectorOptions(n10, n11, n12, n13, bl2, f10, executor, null);
        return faceDetectorOptions;
    }

    public FaceDetectorOptions$Builder enableTracking() {
        this.zze = true;
        return this;
    }

    public FaceDetectorOptions$Builder setClassificationMode(int n10) {
        this.zzc = n10;
        return this;
    }

    public FaceDetectorOptions$Builder setContourMode(int n10) {
        this.zzb = n10;
        return this;
    }

    public FaceDetectorOptions$Builder setExecutor(Executor executor) {
        this.zzg = executor;
        return this;
    }

    public FaceDetectorOptions$Builder setLandmarkMode(int n10) {
        this.zza = n10;
        return this;
    }

    public FaceDetectorOptions$Builder setMinFaceSize(float f10) {
        this.zzf = f10;
        return this;
    }

    public FaceDetectorOptions$Builder setPerformanceMode(int n10) {
        this.zzd = n10;
        return this;
    }
}

