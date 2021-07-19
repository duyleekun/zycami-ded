/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.AssetManager
 */
package com.google.android.gms.vision.face;

import android.content.res.AssetManager;
import com.google.android.gms.internal.vision.zzcb;
import com.google.android.gms.internal.vision.zzci;
import com.google.android.gms.internal.vision.zzci$zzc;
import com.google.android.gms.internal.vision.zzci$zzd;
import com.google.android.gms.internal.vision.zzge;
import com.google.android.gms.internal.vision.zzho;
import com.google.android.gms.internal.vision.zzid$zzg;
import com.google.android.gms.internal.vision.zzin;
import com.google.android.gms.vision.L;
import java.nio.ByteBuffer;

public class FaceDetectorV2Jni {
    private final zzho zzcu;

    public FaceDetectorV2Jni() {
        zzho zzho2;
        this.zzcu = zzho2 = zzho.zzge();
        zzid$zzg zzid$zzg = zzci.zzjg;
        zzho2.zza(zzid$zzg);
    }

    private native void closeDetectorJni(long var1);

    private native byte[] detectFacesImageByteArrayJni(long var1, byte[] var3, byte[] var4);

    private native byte[] detectFacesImageByteArrayMultiPlanesJni(long var1, byte[] var3, byte[] var4, byte[] var5, int var6, int var7, int var8, int var9, int var10, int var11, byte[] var12);

    private native byte[] detectFacesImageByteBufferJni(long var1, ByteBuffer var3, byte[] var4);

    private native byte[] detectFacesImageByteBufferMultiPlanesJni(long var1, ByteBuffer var3, ByteBuffer var4, ByteBuffer var5, int var6, int var7, int var8, int var9, int var10, int var11, byte[] var12);

    private native long initDetectorJni(byte[] var1, AssetManager var2);

    public final long zza(zzci$zzd object, AssetManager assetManager) {
        int n10 = 1;
        Object[] objectArray = new Object[n10];
        String string2 = "FaceDetectorV2Jni";
        objectArray[0] = string2;
        L.v("%s initialize.start()", objectArray);
        object = ((zzge)object).toByteArray();
        long l10 = this.initDetectorJni((byte[])object, assetManager);
        Object[] objectArray2 = new Object[n10];
        objectArray2[0] = string2;
        L.v("%s initialize.end()", objectArray2);
        return l10;
    }

    /*
     * WARNING - void declaration
     */
    public final zzci$zzc zza(long l10, ByteBuffer byteBuffer, zzcb object) {
        void var6_8;
        String string2;
        int n10;
        block6: {
            n10 = 1;
            Object[] objectArray = new Object[n10];
            string2 = "FaceDetectorV2Jni";
            objectArray[0] = string2;
            String string3 = "%s detectFacesImageByteBuffer.start()";
            L.v(string3, objectArray);
            Object var6_6 = null;
            object = ((zzge)object).toByteArray();
            byte[] byArray = this.detectFacesImageByteBufferJni(l10, byteBuffer, (byte[])object);
            if (byArray == null) break block6;
            int n11 = byArray.length;
            if (n11 <= 0) break block6;
            Object[] objectArray2 = this.zzcu;
            try {
                zzci$zzc zzci$zzc;
                zzci$zzc zzci$zzc2 = zzci$zzc = zzci$zzc.zza(byArray, (zzho)objectArray2);
            }
            catch (zzin zzin2) {
                n11 = 2;
                objectArray2 = new Object[n11];
                objectArray2[0] = string2;
                String string4 = zzin2.getMessage();
                objectArray2[n10] = string4;
                String string5 = "%s detectFacesImageByteBuffer failed to parse result: %s";
                L.e(string5, objectArray2);
            }
        }
        Object[] objectArray = new Object[n10];
        objectArray[0] = string2;
        L.v("%s detectFacesImageByteBuffer.end()", objectArray);
        return var6_8;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final zzci$zzc zza(long l10, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int n10, int n11, int n12, int n13, int n14, int n15, zzcb zzcb2) {
        Object object;
        String string2;
        Object object2;
        int n16;
        block4: {
            block5: {
                n16 = 1;
                object2 = new Object[n16];
                string2 = "FaceDetectorV2Jni";
                object2[0] = string2;
                L.v("%s detectFacesImageByteBufferMultiPlanes.start()", object2);
                object = null;
                try {
                    int n17;
                    byte[] byArray = zzcb2.toByteArray();
                    object2 = this.detectFacesImageByteBufferMultiPlanesJni(l10, byteBuffer, byteBuffer2, byteBuffer3, n10, n11, n12, n13, n14, n15, byArray);
                    if (object2 == null || (n17 = ((Object[])object2).length) <= 0) break block4;
                }
                catch (zzin zzin3) {
                    // empty catch block
                    break block5;
                }
                try {
                    zzho object3 = this.zzcu;
                    object = object2 = zzci$zzc.zza((byte[])object2, object3);
                    break block4;
                }
                catch (zzin zzin2) {}
            }
            int n17 = 2;
            Object[] objectArray = new Object[n17];
            objectArray[0] = string2;
            objectArray[n16] = object2 = object2.getMessage();
            object2 = "%s detectFacesImageByteBufferMultiPlanes failed to parse result: %s";
            L.e((String)object2, objectArray);
        }
        object2 = new Object[n16];
        object2[0] = string2;
        L.v("%s detectFacesImageByteBuffer.end()", object2);
        return object;
    }

    /*
     * WARNING - void declaration
     */
    public final zzci$zzc zza(long l10, byte[] byArray, zzcb object) {
        void var6_8;
        String string2;
        int n10;
        block6: {
            n10 = 1;
            Object[] objectArray = new Object[n10];
            string2 = "FaceDetectorV2Jni";
            objectArray[0] = string2;
            String string3 = "%s detectFacesImageByteArray.start()";
            L.v(string3, objectArray);
            Object var6_6 = null;
            object = ((zzge)object).toByteArray();
            byte[] byArray2 = this.detectFacesImageByteArrayJni(l10, byArray, (byte[])object);
            if (byArray2 == null) break block6;
            int n11 = byArray2.length;
            if (n11 <= 0) break block6;
            Object[] objectArray2 = this.zzcu;
            try {
                zzci$zzc zzci$zzc;
                zzci$zzc zzci$zzc2 = zzci$zzc = zzci$zzc.zza(byArray2, (zzho)objectArray2);
            }
            catch (zzin zzin2) {
                n11 = 2;
                objectArray2 = new Object[n11];
                objectArray2[0] = string2;
                String string4 = zzin2.getMessage();
                objectArray2[n10] = string4;
                String string5 = "%s detectFacesImageByteArray failed to parse result: %s";
                L.e(string5, objectArray2);
            }
        }
        Object[] objectArray = new Object[n10];
        objectArray[0] = string2;
        L.v("%s detectFacesImageByteArray.end()", objectArray);
        return var6_8;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final zzci$zzc zza(long l10, byte[] byArray, byte[] byArray2, byte[] byArray3, int n10, int n11, int n12, int n13, int n14, int n15, zzcb zzcb2) {
        Object object;
        String string2;
        Object object2;
        int n16;
        block4: {
            block5: {
                n16 = 1;
                object2 = new Object[n16];
                string2 = "FaceDetectorV2Jni";
                object2[0] = string2;
                L.v("%s detectFacesImageByteArrayMultiPlanes.start()", object2);
                object = null;
                try {
                    int n17;
                    byte[] byArray4 = zzcb2.toByteArray();
                    object2 = this.detectFacesImageByteArrayMultiPlanesJni(l10, byArray, byArray2, byArray3, n10, n11, n12, n13, n14, n15, byArray4);
                    if (object2 == null || (n17 = ((Object[])object2).length) <= 0) break block4;
                }
                catch (zzin zzin3) {
                    // empty catch block
                    break block5;
                }
                try {
                    zzho object3 = this.zzcu;
                    object = object2 = zzci$zzc.zza((byte[])object2, object3);
                    break block4;
                }
                catch (zzin zzin2) {}
            }
            int n17 = 2;
            Object[] objectArray = new Object[n17];
            objectArray[0] = string2;
            objectArray[n16] = object2 = object2.getMessage();
            object2 = "%s detectFacesImageByteArrayMultiPlanes failed to parse result: %s";
            L.e((String)object2, objectArray);
        }
        object2 = new Object[n16];
        object2[0] = string2;
        L.v("%s detectFacesImageByteArrayMultiPlanes.end()", object2);
        return object;
    }

    public final void zza(long l10) {
        int n10 = 1;
        Object[] objectArray = new Object[n10];
        String string2 = "FaceDetectorV2Jni";
        objectArray[0] = string2;
        L.v("%s closeDetector.start()", objectArray);
        this.closeDetectorJni(l10);
        Object[] objectArray2 = new Object[n10];
        objectArray2[0] = string2;
        L.v("%s closeDetector.end()", objectArray2);
    }
}

