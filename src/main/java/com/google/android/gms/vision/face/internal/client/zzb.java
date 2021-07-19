/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.PointF
 *  android.media.Image$Plane
 *  android.os.RemoteException
 *  android.util.Log
 */
package com.google.android.gms.vision.face.internal.client;

import android.content.Context;
import android.graphics.PointF;
import android.media.Image;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.vision.zzs;
import com.google.android.gms.internal.vision.zzu;
import com.google.android.gms.internal.vision.zzw;
import com.google.android.gms.vision.face.Contour;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.Landmark;
import com.google.android.gms.vision.face.internal.client.FaceParcel;
import com.google.android.gms.vision.face.internal.client.LandmarkParcel;
import com.google.android.gms.vision.face.internal.client.zza;
import com.google.android.gms.vision.face.internal.client.zzf;
import com.google.android.gms.vision.face.internal.client.zzh;
import com.google.android.gms.vision.face.internal.client.zzl;
import java.nio.ByteBuffer;

public final class zzb
extends zzs {
    private final zzf zzdg;

    public zzb(Context context, zzf zzf2) {
        super(context, "FaceNativeHandle", "face");
        this.zzdg = zzf2;
        this.zzr();
    }

    private static Face zza(FaceParcel faceParcel) {
        Face face;
        float f10;
        Object object;
        PointF pointF;
        Object object2;
        int n10;
        int n11;
        float f11;
        Contour[] contourArray;
        Landmark[] landmarkArray;
        int n12;
        Object object3 = faceParcel;
        int n13 = faceParcel.id;
        float f12 = faceParcel.centerX;
        float f13 = faceParcel.centerY;
        PointF pointF2 = new PointF(f12, f13);
        f12 = faceParcel.width;
        f13 = faceParcel.height;
        float f14 = faceParcel.zzdh;
        float f15 = faceParcel.zzdi;
        float f16 = faceParcel.zzdj;
        Object[] objectArray = faceParcel.zzdk;
        float f17 = 0.0f;
        Object[] objectArray2 = null;
        if (objectArray == null) {
            objectArray = new Landmark[]{};
        } else {
            n12 = objectArray.length;
            landmarkArray = new Landmark[n12];
            contourArray = null;
            f11 = 0.0f;
            for (n11 = 0; n11 < (n10 = objectArray.length); ++n11) {
                object2 = objectArray[n11];
                f17 = ((LandmarkParcel)object2).x;
                float f18 = ((LandmarkParcel)object2).y;
                pointF = new PointF(f17, f18);
                int n14 = ((LandmarkParcel)object2).type;
                landmarkArray[n11] = object = new Landmark(pointF, n14);
                f17 = 0.0f;
                objectArray2 = null;
            }
            objectArray = landmarkArray;
        }
        objectArray2 = ((FaceParcel)object3).zzdl;
        if (objectArray2 == null) {
            n12 = 0;
            f10 = 0.0f;
            landmarkArray = null;
            objectArray2 = new Contour[]{};
        } else {
            f10 = 0.0f;
            landmarkArray = null;
            n11 = objectArray2.length;
            contourArray = new Contour[n11];
            for (n12 = 0; n12 < (n10 = objectArray2.length); ++n12) {
                object2 = objectArray2[n12];
                pointF = ((zza)object2).zzdf;
                n10 = ((zza)object2).type;
                contourArray[n12] = object = new Contour((PointF[])pointF, n10);
            }
            objectArray2 = contourArray;
        }
        f10 = ((FaceParcel)object3).zzcm;
        f11 = ((FaceParcel)object3).zzcn;
        float f19 = ((FaceParcel)object3).zzco;
        float f20 = ((FaceParcel)object3).zzcp;
        object3 = face;
        face = new Face(n13, pointF2, f12, f13, f14, f15, f16, (Landmark[])objectArray, (Contour[])objectArray2, f10, f11, f19, f20);
        return face;
    }

    public final /* synthetic */ Object zza(DynamiteModule object, Context object2) {
        Object object3 = "com.google.android.gms.vision.dynamite.face";
        boolean bl2 = zzw.zza(object2, (String)object3);
        if (bl2) {
            object3 = "com.google.android.gms.vision.face.NativeFaceDetectorV2Creator";
            object = zzl.asInterface(((DynamiteModule)object).instantiate((String)object3));
        } else {
            object3 = "com.google.android.gms.vision.face.ChimeraNativeFaceDetectorCreator";
            object = zzl.asInterface(((DynamiteModule)object).instantiate((String)object3));
        }
        if (object == null) {
            return null;
        }
        object2 = ObjectWrapper.wrap(object2);
        object3 = this.zzdg;
        return object.newFaceDetector((IObjectWrapper)object2, (zzf)object3);
    }

    public final Face[] zza(Image.Plane[] planeArray, zzu zzu2) {
        int n10;
        Face[] faceArray;
        int n11;
        FaceParcel[] faceParcelArray = planeArray;
        int n12 = this.isOperational();
        Object object = "FaceNativeHandle";
        if (n12 == 0) {
            Log.e((String)object, (String)"Native handle is not ready to be used.");
            return new Face[0];
        }
        if (planeArray != null && (n12 = planeArray.length) != (n11 = 3)) {
            faceParcelArray = new IllegalArgumentException("Only android.graphics.ImageFormat#YUV_420_888 is supported which should have 3 planes.");
            throw faceParcelArray;
        }
        Face[] faceArray2 = faceArray = this.zzr();
        faceArray2 = (zzh)faceArray;
        faceArray = faceParcelArray[0];
        faceArray = faceArray.getBuffer();
        IObjectWrapper iObjectWrapper = ObjectWrapper.wrap(faceArray);
        n12 = 1;
        Object object2 = faceParcelArray[n12];
        object2 = object2.getBuffer();
        object2 = ObjectWrapper.wrap(object2);
        int n13 = 2;
        Object object3 = faceParcelArray[n13];
        object3 = object3.getBuffer();
        object3 = ObjectWrapper.wrap(object3);
        Image.Plane plane = faceParcelArray[0];
        int n14 = plane.getPixelStride();
        Image.Plane plane2 = faceParcelArray[n12];
        int n15 = plane2.getPixelStride();
        Image.Plane plane3 = faceParcelArray[n13];
        int n16 = plane3.getPixelStride();
        Image.Plane plane4 = faceParcelArray[0];
        int n17 = plane4.getRowStride();
        faceArray = faceParcelArray[n12];
        n12 = faceArray.getRowStride();
        faceParcelArray = faceParcelArray[n13];
        int n18 = faceParcelArray.getRowStride();
        int n19 = n14;
        n14 = n15;
        n15 = n16;
        n16 = n17;
        n17 = n12;
        try {
            faceParcelArray = faceArray2.zza(iObjectWrapper, (IObjectWrapper)object2, (IObjectWrapper)object3, n19, n14, n15, n16, n12, n18, zzu2);
        }
        catch (RemoteException remoteException) {
            Log.e((String)object, (String)"Could not call native face detector", (Throwable)remoteException);
            return new Face[0];
        }
        n12 = faceParcelArray.length;
        faceArray = new Face[n12];
        for (int i10 = 0; i10 < (n10 = faceParcelArray.length); ++i10) {
            faceArray[i10] = object = zzb.zza(faceParcelArray[i10]);
        }
        return faceArray;
    }

    public final Face[] zzb(ByteBuffer faceParcelArray, zzu faceArray) {
        int n10 = this.isOperational();
        if (n10 == 0) {
            return new Face[0];
        }
        faceParcelArray = ObjectWrapper.wrap(faceParcelArray);
        Object object = this.zzr();
        object = (zzh)object;
        try {
            faceParcelArray = object.zzc((IObjectWrapper)faceParcelArray, (zzu)faceArray);
        }
        catch (RemoteException remoteException) {
            Log.e((String)"FaceNativeHandle", (String)"Could not call native face detector", (Throwable)remoteException);
            return new Face[0];
        }
        int n11 = faceParcelArray.length;
        faceArray = new Face[n11];
        for (int i10 = 0; i10 < (n10 = faceParcelArray.length); ++i10) {
            faceArray[i10] = object = zzb.zza(faceParcelArray[i10]);
        }
        return faceArray;
    }

    public final boolean zzd(int n10) {
        Object object;
        boolean bl2 = this.isOperational();
        if (!bl2) {
            return false;
        }
        try {
            object = this.zzr();
        }
        catch (RemoteException remoteException) {
            Log.e((String)"FaceNativeHandle", (String)"Could not call native face detector", (Throwable)remoteException);
            return false;
        }
        object = (zzh)object;
        return object.zzd(n10);
    }

    public final void zzp() {
        ((zzh)this.zzr()).zzo();
    }
}

