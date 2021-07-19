/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 *  android.graphics.Rect
 *  android.util.SparseArray
 */
package com.google.mlkit.vision.face;

import android.graphics.PointF;
import android.graphics.Rect;
import android.util.SparseArray;
import com.google.android.gms.internal.mlkit_vision_face.zzd;
import com.google.android.gms.internal.mlkit_vision_face.zzf;
import com.google.android.gms.vision.face.Contour;
import com.google.android.gms.vision.face.Landmark;
import com.google.mlkit.vision.face.FaceContour;
import com.google.mlkit.vision.face.FaceLandmark;
import java.util.ArrayList;
import java.util.List;

public class Face {
    private final Rect zza;
    private int zzb;
    private float zzc;
    private float zzd;
    private float zze;
    private final float zzf;
    private final float zzg;
    private final float zzh;
    private final SparseArray zzi;
    private final SparseArray zzj;

    public Face(com.google.android.gms.vision.face.Face face) {
        float f10;
        Object object;
        Object object2;
        PointF pointF;
        int n10;
        boolean bl2;
        Object object3 = new SparseArray();
        this.zzi = object3;
        object3 = new SparseArray();
        this.zzj = object3;
        object3 = face.getPosition();
        float f11 = ((PointF)object3).x;
        int n11 = (int)f11;
        float f12 = ((PointF)object3).y;
        int n12 = (int)f12;
        float f13 = face.getWidth();
        int n13 = (int)(f11 += f13);
        float f14 = ((PointF)object3).y;
        f13 = face.getHeight();
        int n14 = (int)(f14 += f13);
        Object object4 = new Rect(n11, n12, n13, n14);
        this.zza = object4;
        this.zzb = n14 = face.getId();
        object3 = face.getLandmarks().iterator();
        while (bl2 = object3.hasNext()) {
            PointF pointF2;
            object4 = (Landmark)object3.next();
            n13 = (int)(Face.zzb(((Landmark)object4).getType()) ? 1 : 0);
            if (n13 == 0 || (pointF2 = ((Landmark)object4).getPosition()) == null) continue;
            pointF2 = this.zzi;
            n11 = ((Landmark)object4).getType();
            n10 = ((Landmark)object4).getType();
            pointF = ((Landmark)object4).getPosition();
            float f15 = pointF.x;
            object4 = ((Landmark)object4).getPosition();
            float f16 = ((PointF)object4).y;
            object2 = new PointF(f15, f16);
            object = new FaceLandmark(n10, (PointF)object2);
            pointF2.put(n11, object);
        }
        object3 = face.getContours().iterator();
        while (bl2 = object3.hasNext()) {
            object4 = (Contour)object3.next();
            n13 = ((Contour)object4).getType();
            n11 = 15;
            float f17 = 2.1E-44f;
            n12 = 1;
            f12 = Float.MIN_VALUE;
            switch (n13) {
                default: {
                    n13 = -1;
                    f11 = 0.0f / 0.0f;
                    break;
                }
                case 15: {
                    n13 = n11;
                    f11 = f17;
                    break;
                }
                case 14: {
                    n13 = 14;
                    f11 = 2.0E-44f;
                    break;
                }
                case 13: {
                    n13 = 13;
                    f11 = 1.8E-44f;
                    break;
                }
                case 12: {
                    n13 = 12;
                    f11 = 1.7E-44f;
                    break;
                }
                case 11: {
                    n13 = 11;
                    f11 = 1.5E-44f;
                    break;
                }
                case 10: {
                    n13 = 10;
                    f11 = 1.4E-44f;
                    break;
                }
                case 9: {
                    n13 = 9;
                    f11 = 1.3E-44f;
                    break;
                }
                case 8: {
                    n13 = 8;
                    f11 = 1.1E-44f;
                    break;
                }
                case 7: {
                    n13 = 7;
                    f11 = 9.8E-45f;
                    break;
                }
                case 6: {
                    n13 = 6;
                    f11 = 8.4E-45f;
                    break;
                }
                case 5: {
                    n13 = 5;
                    f11 = 7.0E-45f;
                    break;
                }
                case 4: {
                    n13 = 4;
                    f11 = 5.6E-45f;
                    break;
                }
                case 3: {
                    n13 = 3;
                    f11 = 4.2E-45f;
                    break;
                }
                case 2: {
                    n13 = 2;
                    f11 = 2.8E-45f;
                    break;
                }
                case 1: {
                    n13 = n12;
                    f11 = f12;
                }
            }
            n10 = 0;
            f13 = 0.0f;
            if (n13 > n11 || n13 <= 0) {
                n12 = 0;
                object = null;
                f12 = 0.0f;
            }
            if (n12 == 0) continue;
            object4 = ((Contour)object4).getPositions();
            ArrayList<PointF> arrayList = new ArrayList<PointF>();
            if (object4 == null) continue;
            n12 = ((Object)object4).length;
            while (n10 < n12) {
                object2 = object4[n10];
                float f18 = object2.x;
                float f19 = object2.y;
                pointF = new PointF(f18, f19);
                arrayList.add(pointF);
                ++n10;
            }
            object4 = this.zzj;
            object = new FaceContour(n13, arrayList);
            object4.put(n13, object);
        }
        this.zzf = f14 = face.getEulerX();
        this.zzg = f14 = face.getEulerY();
        this.zzh = f14 = face.getEulerZ();
        this.zze = f14 = face.getIsSmilingProbability();
        this.zzd = f14 = face.getIsLeftEyeOpenProbability();
        this.zzc = f10 = face.getIsRightEyeOpenProbability();
    }

    private static boolean zzb(int n10) {
        int n11;
        int n12 = 1;
        if (n10 != 0 && n10 != n12 && n10 != (n11 = 7) && n10 != (n11 = 3) && n10 != (n11 = 9) && n10 != (n11 = 4) && n10 != (n11 = 10) && n10 != (n11 = 5) && n10 != (n11 = 11) && n10 != (n11 = 6)) {
            return false;
        }
        return n12 != 0;
    }

    public List getAllContours() {
        ArrayList<FaceContour> arrayList = new ArrayList<FaceContour>();
        SparseArray sparseArray = this.zzj;
        int n10 = sparseArray.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            FaceContour faceContour = (FaceContour)this.zzj.valueAt(i10);
            arrayList.add(faceContour);
        }
        return arrayList;
    }

    public List getAllLandmarks() {
        ArrayList<FaceLandmark> arrayList = new ArrayList<FaceLandmark>();
        SparseArray sparseArray = this.zzi;
        int n10 = sparseArray.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            FaceLandmark faceLandmark = (FaceLandmark)this.zzi.valueAt(i10);
            arrayList.add(faceLandmark);
        }
        return arrayList;
    }

    public Rect getBoundingBox() {
        return this.zza;
    }

    public FaceContour getContour(int n10) {
        return (FaceContour)this.zzj.get(n10);
    }

    public float getHeadEulerAngleX() {
        return this.zzf;
    }

    public float getHeadEulerAngleY() {
        return this.zzg;
    }

    public float getHeadEulerAngleZ() {
        return this.zzh;
    }

    public FaceLandmark getLandmark(int n10) {
        return (FaceLandmark)this.zzi.get(n10);
    }

    public Float getLeftEyeOpenProbability() {
        float f10 = this.zzd;
        float f11 = -1.0f;
        float f12 = f10 - f11;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object == false) {
            return null;
        }
        return Float.valueOf(f10);
    }

    public Float getRightEyeOpenProbability() {
        float f10 = this.zzc;
        float f11 = -1.0f;
        float f12 = f10 - f11;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object == false) {
            return null;
        }
        return Float.valueOf(f10);
    }

    public Float getSmilingProbability() {
        float f10 = this.zze;
        float f11 = -1.0f;
        float f12 = f10 - f11;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object == false) {
            return null;
        }
        return Float.valueOf(f10);
    }

    public Integer getTrackingId() {
        int n10 = this.zzb;
        int n11 = -1;
        if (n10 == n11) {
            return null;
        }
        return n10;
    }

    public String toString() {
        String string2;
        Object object;
        int n10;
        int n11;
        zzf zzf2 = com.google.android.gms.internal.mlkit_vision_face.zzd.zza("Face");
        Object object2 = this.zza;
        zzf2 = zzf2.zza("boundingBox", object2);
        int n12 = this.zzb;
        zzf2 = zzf2.zza("trackingId", n12);
        float f10 = this.zzc;
        zzf2 = zzf2.zza("rightEyeOpenProbability", f10);
        f10 = this.zzd;
        zzf2 = zzf2.zza("leftEyeOpenProbability", f10);
        f10 = this.zze;
        zzf2 = zzf2.zza("smileProbability", f10);
        f10 = this.zzf;
        zzf2 = zzf2.zza("eulerX", f10);
        f10 = this.zzg;
        zzf2 = zzf2.zza("eulerY", f10);
        f10 = this.zzh;
        zzf2 = zzf2.zza("eulerZ", f10);
        object2 = com.google.android.gms.internal.mlkit_vision_face.zzd.zza("Landmarks");
        String string3 = null;
        for (n11 = 0; n11 <= (n10 = 11); ++n11) {
            n10 = (int)(Face.zzb(n11) ? 1 : 0);
            if (n10 == 0) continue;
            n10 = 20;
            object = new StringBuilder(n10);
            ((StringBuilder)object).append("landmark_");
            ((StringBuilder)object).append(n11);
            string2 = ((StringBuilder)object).toString();
            object = this.getLandmark(n11);
            ((zzf)object2).zza(string2, object);
        }
        object2 = ((zzf)object2).toString();
        string3 = "landmarks";
        zzf2.zza(string3, object2);
        object2 = com.google.android.gms.internal.mlkit_vision_face.zzd.zza("Contours");
        for (n11 = 1; n11 <= (n10 = 15); ++n11) {
            n10 = 19;
            object = new StringBuilder(n10);
            ((StringBuilder)object).append("Contour_");
            ((StringBuilder)object).append(n11);
            string2 = ((StringBuilder)object).toString();
            object = this.getContour(n11);
            ((zzf)object2).zza(string2, object);
        }
        object2 = ((zzf)object2).toString();
        zzf2.zza("contours", object2);
        return zzf2.toString();
    }

    public final SparseArray zza() {
        return this.zzj;
    }

    public final void zza(int n10) {
        this.zzb = -1;
    }

    public final void zza(SparseArray sparseArray) {
        int n10;
        this.zzj.clear();
        for (int i10 = 0; i10 < (n10 = sparseArray.size()); ++i10) {
            SparseArray sparseArray2 = this.zzj;
            int n11 = sparseArray.keyAt(i10);
            FaceContour faceContour = (FaceContour)sparseArray.valueAt(i10);
            sparseArray2.put(n11, (Object)faceContour);
        }
    }
}

