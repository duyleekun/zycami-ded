/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.mlkit.vision.face.internal;

import android.content.Context;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzac;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzad;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzad$zza;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzap;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzap$zza;
import com.google.android.gms.internal.mlkit_vision_face.zzcb;
import com.google.android.gms.internal.mlkit_vision_face.zzel;
import com.google.android.gms.internal.mlkit_vision_face.zzgd;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.common.sdkinternal.ExecutorSelector;
import com.google.mlkit.common.sdkinternal.MLTask;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.common.internal.MobileVisionBase;
import com.google.mlkit.vision.face.FaceDetector;
import com.google.mlkit.vision.face.FaceDetectorOptions;
import com.google.mlkit.vision.face.FaceDetectorOptions$Builder;
import com.google.mlkit.vision.face.internal.zza;
import com.google.mlkit.vision.face.internal.zzb;
import java.util.concurrent.Executor;

public class FaceDetectorImpl
extends MobileVisionBase
implements FaceDetector {
    public static final FaceDetectorOptions zza;

    static {
        FaceDetectorOptions$Builder faceDetectorOptions$Builder = new FaceDetectorOptions$Builder();
        zza = faceDetectorOptions$Builder.build();
    }

    private FaceDetectorImpl(Context object, zzel zzel2, ExecutorSelector executorSelector, FaceDetectorOptions faceDetectorOptions) {
        zzb zzb2 = new zzb((Context)object, zzel2, faceDetectorOptions);
        object = faceDetectorOptions.zzg();
        object = executorSelector.getExecutorToUse((Executor)object);
        this(zzb2, (Executor)object, faceDetectorOptions, zzel2);
    }

    public /* synthetic */ FaceDetectorImpl(Context context, zzel zzel2, ExecutorSelector executorSelector, FaceDetectorOptions faceDetectorOptions, zza zza2) {
        this(context, zzel2, executorSelector, faceDetectorOptions);
    }

    private FaceDetectorImpl(zzb object, Executor object2, FaceDetectorOptions faceDetectorOptions, zzel zzel2) {
        super((MLTask)object, (Executor)object2);
        object = zzbm$zzap.zza();
        object2 = faceDetectorOptions.zzh();
        object = (zzbm$zzap)((zzgd)((zzbm$zzap$zza)object).zza((zzbm$zzac)object2).zzh());
        object = zzbm$zzad.zzb().zza((zzbm$zzap)object);
        object2 = zzcb.zzb;
        zzel2.zza((zzbm$zzad$zza)object, (zzcb)object2);
    }

    public Task process(InputImage inputImage) {
        return super.processBase(inputImage);
    }
}

