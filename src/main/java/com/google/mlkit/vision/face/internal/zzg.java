/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.mlkit.vision.face.internal;

import android.content.Context;
import com.google.android.gms.internal.mlkit_vision_face.zzel;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.mlkit.common.sdkinternal.ExecutorSelector;
import com.google.mlkit.vision.face.internal.FaceDetectorImpl$zza;

public final class zzg
implements ComponentFactory {
    public static final ComponentFactory zza;

    static {
        zzg zzg2 = new zzg();
        zza = zzg2;
    }

    private zzg() {
    }

    public final Object create(ComponentContainer object) {
        Context context = (Context)object.get(Context.class);
        zzel zzel2 = (zzel)object.get(zzel.class);
        object = (ExecutorSelector)object.get(ExecutorSelector.class);
        FaceDetectorImpl$zza faceDetectorImpl$zza = new FaceDetectorImpl$zza(context, zzel2, (ExecutorSelector)object);
        return faceDetectorImpl$zza;
    }
}

