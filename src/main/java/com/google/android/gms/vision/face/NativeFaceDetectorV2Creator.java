/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.android.gms.vision.face;

import android.content.Context;
import com.google.android.gms.internal.vision.zzq;
import com.google.android.gms.vision.clearcut.DynamiteClearcutLogger;
import com.google.android.gms.vision.face.ChimeraNativeBaseFaceDetectorCreator;
import com.google.android.gms.vision.face.FaceDetectorV2Jni;
import com.google.android.gms.vision.face.NativeFaceDetectorV2Impl;
import com.google.android.gms.vision.face.internal.client.zzf;
import com.google.android.gms.vision.face.internal.client.zzh;

public class NativeFaceDetectorV2Creator
extends ChimeraNativeBaseFaceDetectorCreator {
    public final zzh zza(Context context, Context context2, DynamiteClearcutLogger dynamiteClearcutLogger, zzf zzf2) {
        NativeFaceDetectorV2Impl nativeFaceDetectorV2Impl;
        Object object = "face";
        String string2 = "libface_detector_v2_jni.so";
        boolean bl2 = zzq.zza(context2, (String)object, string2);
        if (!bl2) {
            return null;
        }
        FaceDetectorV2Jni faceDetectorV2Jni = new FaceDetectorV2Jni();
        object = nativeFaceDetectorV2Impl;
        string2 = context;
        nativeFaceDetectorV2Impl = new NativeFaceDetectorV2Impl(context, context2, dynamiteClearcutLogger, zzf2, faceDetectorV2Jni);
        return nativeFaceDetectorV2Impl;
    }
}

