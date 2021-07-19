/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.mlkit.vision.face.internal;

import android.content.Context;
import com.google.android.gms.internal.mlkit_vision_face.zzel;
import com.google.mlkit.common.sdkinternal.LazyInstanceMap;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.vision.face.FaceDetectorOptions;
import com.google.mlkit.vision.face.internal.zzb;

public class zzc
extends LazyInstanceMap {
    private final MlKitContext zza;

    public zzc(MlKitContext mlKitContext) {
        this.zza = mlKitContext;
    }

    public /* synthetic */ Object create(Object object) {
        object = (FaceDetectorOptions)object;
        Context context = this.zza.getApplicationContext();
        zzel zzel2 = (zzel)this.zza.get(zzel.class);
        zzb zzb2 = new zzb(context, zzel2, (FaceDetectorOptions)object);
        return zzb2;
    }
}

