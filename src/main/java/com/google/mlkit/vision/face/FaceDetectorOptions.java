/*
 * Decompiled with CFR 0.151.
 */
package com.google.mlkit.vision.face;

import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzac;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzac$zza;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzac$zzb;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzac$zzc;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzac$zzd;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzac$zze;
import com.google.android.gms.internal.mlkit_vision_face.zzd;
import com.google.android.gms.internal.mlkit_vision_face.zzf;
import com.google.android.gms.internal.mlkit_vision_face.zzgd;
import com.google.mlkit.vision.face.zza;
import java.lang.constant.Constable;
import java.util.concurrent.Executor;

public class FaceDetectorOptions {
    public static final int CLASSIFICATION_MODE_ALL = 2;
    public static final int CLASSIFICATION_MODE_NONE = 1;
    public static final int CONTOUR_MODE_ALL = 2;
    public static final int CONTOUR_MODE_NONE = 1;
    public static final int LANDMARK_MODE_ALL = 2;
    public static final int LANDMARK_MODE_NONE = 1;
    public static final int PERFORMANCE_MODE_ACCURATE = 2;
    public static final int PERFORMANCE_MODE_FAST = 1;
    private final int zza;
    private final int zzb;
    private final int zzc;
    private final int zzd;
    private final boolean zze;
    private final float zzf;
    private final Executor zzg;

    private FaceDetectorOptions(int n10, int n11, int n12, int n13, boolean bl2, float f10, Executor executor) {
        this.zza = n10;
        this.zzb = n11;
        this.zzc = n12;
        this.zzd = n13;
        this.zze = bl2;
        this.zzf = f10;
        this.zzg = executor;
    }

    public /* synthetic */ FaceDetectorOptions(int n10, int n11, int n12, int n13, boolean bl2, float f10, Executor executor, zza zza2) {
        this(n10, n11, n12, n13, bl2, f10, executor);
    }

    public boolean equals(Object object) {
        int n10;
        float f10;
        int n11;
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        int n12 = object instanceof FaceDetectorOptions;
        if (n12 == 0) {
            return false;
        }
        object = (FaceDetectorOptions)object;
        float f11 = this.zzf;
        n12 = Float.floatToIntBits(f11);
        if (n12 == (n11 = Float.floatToIntBits(f10 = ((FaceDetectorOptions)object).zzf)) && (n12 = this.zza) == (n11 = ((FaceDetectorOptions)object).zza) && (n12 = this.zzb) == (n11 = ((FaceDetectorOptions)object).zzb) && (n12 = this.zzd) == (n11 = ((FaceDetectorOptions)object).zzd) && (n12 = (int)(this.zze ? 1 : 0)) == (n11 = (int)(((FaceDetectorOptions)object).zze ? 1 : 0)) && (n12 = this.zzc) == (n10 = ((FaceDetectorOptions)object).zzc)) {
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        Object[] objectArray = new Object[6];
        Constable constable = Float.floatToIntBits(this.zzf);
        objectArray[0] = constable;
        constable = this.zza;
        objectArray[1] = constable;
        constable = this.zzb;
        objectArray[2] = constable;
        constable = this.zzd;
        objectArray[3] = constable;
        constable = Boolean.valueOf(this.zze);
        objectArray[4] = constable;
        constable = this.zzc;
        objectArray[5] = constable;
        return Objects.hashCode(objectArray);
    }

    public String toString() {
        zzf zzf2 = com.google.android.gms.internal.mlkit_vision_face.zzd.zza("FaceDetectorOptions");
        int bl2 = this.zza;
        zzf2 = zzf2.zza("landmarkMode", bl2);
        int n10 = this.zzb;
        zzf2 = zzf2.zza("contourMode", n10);
        int n11 = this.zzc;
        zzf2 = zzf2.zza("classificationMode", n11);
        int n12 = this.zzd;
        zzf2 = zzf2.zza("performanceMode", n12);
        boolean bl3 = this.zze;
        zzf2 = zzf2.zza("trackingEnabled", bl3);
        float f10 = this.zzf;
        return zzf2.zza("minFaceSize", f10).toString();
    }

    public final int zza() {
        return this.zza;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final int zzc() {
        return this.zzc;
    }

    public final int zzd() {
        return this.zzd;
    }

    public final boolean zze() {
        return this.zze;
    }

    public final float zzf() {
        return this.zzf;
    }

    public final Executor zzg() {
        return this.zzg;
    }

    public final zzbm$zzac zzh() {
        zzbm$zzac$zzb zzbm$zzac$zzb = zzbm$zzac.zza();
        int bl2 = this.zza;
        int n10 = 2;
        int n11 = 1;
        Enum enum_ = bl2 != n11 ? (bl2 != n10 ? zzbm$zzac$zzd.zza : zzbm$zzac$zzd.zzc) : zzbm$zzac$zzd.zzb;
        zzbm$zzac$zzb = zzbm$zzac$zzb.zza((zzbm$zzac$zzd)enum_);
        int n12 = this.zzc;
        enum_ = n12 != n11 ? (n12 != n10 ? zzbm$zzac$zza.zza : zzbm$zzac$zza.zzc) : zzbm$zzac$zza.zzb;
        zzbm$zzac$zzb = zzbm$zzac$zzb.zza((zzbm$zzac$zza)enum_);
        int n13 = this.zzd;
        enum_ = n13 != n11 ? (n13 != n10 ? zzbm$zzac$zze.zza : zzbm$zzac$zze.zzc) : zzbm$zzac$zze.zzb;
        zzbm$zzac$zzb = zzbm$zzac$zzb.zza((zzbm$zzac$zze)enum_);
        int n14 = this.zzb;
        enum_ = n14 != n11 ? (n14 != n10 ? zzbm$zzac$zzc.zza : zzbm$zzac$zzc.zzc) : zzbm$zzac$zzc.zzb;
        zzbm$zzac$zzb = zzbm$zzac$zzb.zza((zzbm$zzac$zzc)enum_);
        boolean bl3 = this.zze;
        zzbm$zzac$zzb = zzbm$zzac$zzb.zza(bl3);
        float f10 = this.zzf;
        return (zzbm$zzac)((zzgd)zzbm$zzac$zzb.zza(f10).zzh());
    }
}

