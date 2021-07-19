/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.media.Image$Plane
 *  android.os.SystemClock
 *  android.util.SparseArray
 */
package com.google.mlkit.vision.face.internal;

import android.content.Context;
import android.media.Image;
import android.os.SystemClock;
import android.util.SparseArray;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzab;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzac;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzad;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzad$zza;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzae;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaf;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaf$zza;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzap;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzap$zza;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzd;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzd$zza;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzd$zza$zza;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzd$zzb;
import com.google.android.gms.internal.mlkit_vision_face.zzbx;
import com.google.android.gms.internal.mlkit_vision_face.zzcb;
import com.google.android.gms.internal.mlkit_vision_face.zzel;
import com.google.android.gms.internal.mlkit_vision_face.zzel$zza;
import com.google.android.gms.internal.mlkit_vision_face.zzep;
import com.google.android.gms.internal.mlkit_vision_face.zzg;
import com.google.android.gms.internal.mlkit_vision_face.zzgd;
import com.google.android.gms.internal.mlkit_vision_face.zzgd$zza;
import com.google.android.gms.internal.mlkit_vision_face.zzhn;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.Frame$Builder;
import com.google.android.gms.vision.face.FaceDetector;
import com.google.android.gms.vision.face.FaceDetector$Builder;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.MLTask;
import com.google.mlkit.common.sdkinternal.MLTaskInput;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.common.internal.BitmapInStreamingChecker;
import com.google.mlkit.vision.common.internal.CommonConvertUtils;
import com.google.mlkit.vision.common.internal.ImageConvertUtils;
import com.google.mlkit.vision.common.internal.ImageUtils;
import com.google.mlkit.vision.face.Face;
import com.google.mlkit.vision.face.FaceDetectorOptions;
import com.google.mlkit.vision.face.internal.zzd;
import com.google.mlkit.vision.face.internal.zze;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public final class zzb
extends MLTask {
    private static final AtomicBoolean zzd;
    private static final ImageUtils zze;
    private final Context zza;
    private final FaceDetectorOptions zzb;
    private final zzel zzc;
    private FaceDetector zzf;
    private FaceDetector zzg;
    private zzg zzh;
    private final BitmapInStreamingChecker zzi;

    static {
        AtomicBoolean atomicBoolean;
        zzd = atomicBoolean = new AtomicBoolean(true);
        zze = ImageUtils.getInstance();
    }

    public zzb(Context context, zzel zzel2, FaceDetectorOptions faceDetectorOptions) {
        Object object = com.google.android.gms.internal.mlkit_vision_face.zzg.zzb();
        this.zzh = object;
        this.zzi = object = new BitmapInStreamingChecker();
        Preconditions.checkNotNull(context, "Application context can not be null");
        Preconditions.checkNotNull(zzel2, "MlStatsLogger can not be null");
        Preconditions.checkNotNull(faceDetectorOptions, "FaceDetectorOptions can not be null");
        this.zza = context;
        this.zzb = faceDetectorOptions;
        this.zzc = zzel2;
    }

    private static int zza(int n10) {
        int n11 = 1;
        if (n10 != n11) {
            int n12 = 2;
            if (n10 == n12) {
                return n11;
            }
            StringBuilder stringBuilder = new StringBuilder(34);
            stringBuilder.append("Invalid landmark type: ");
            stringBuilder.append(n10);
            String string2 = stringBuilder.toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
            throw illegalArgumentException;
        }
        return 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final List zza(FaceDetector object, InputImage arrayList, long l10) {
        synchronized (this) {
            int n10;
            int n11;
            int n12;
            Object object2;
            ArrayList<Face> arrayList2;
            long l11;
            int n13 = ((FaceDetector)object).isOperational();
            if (n13 == 0) {
                zzbx zzbx2 = zzbx.zzb;
                this.zza(zzbx2, l11, (InputImage)((Object)arrayList2), 0, 0);
                arrayList2 = "Waiting for the face detection model to be downloaded. Please wait.";
                int n14 = 14;
                object = new MlKitException((String)((Object)arrayList2), n14);
                throw object;
            }
            int n15 = ((InputImage)((Object)arrayList2)).getFormat();
            int n16 = 35;
            n13 = 0;
            if (n15 == n16) {
                object2 = new Frame$Builder();
                Image.Plane[] planeArray = ((InputImage)((Object)arrayList2)).getPlanes();
                int n17 = ((InputImage)((Object)arrayList2)).getWidth();
                n12 = ((InputImage)((Object)arrayList2)).getHeight();
                n11 = ((InputImage)((Object)arrayList2)).getFormat();
                n11 = CommonConvertUtils.convertToAndroidImageFormat(n11);
                object2 = ((Frame$Builder)object2).setPlanes(planeArray, n17, n12, n11);
                n10 = ((InputImage)((Object)arrayList2)).getRotationDegrees();
                n10 = CommonConvertUtils.convertToMVRotation(n10);
                arrayList2 = ((Frame$Builder)object2).setRotation(n10);
                l11 = SystemClock.elapsedRealtime();
                arrayList2 = ((Frame$Builder)((Object)arrayList2)).setTimestampMillis(l11);
                arrayList2 = ((Frame$Builder)((Object)arrayList2)).build();
            } else {
                n15 = ((InputImage)((Object)arrayList2)).getFormat();
                if (n15 == (n16 = 17)) {
                    object2 = ((InputImage)((Object)arrayList2)).getByteBuffer();
                } else {
                    object2 = ImageConvertUtils.getInstance();
                    object2 = ((ImageConvertUtils)object2).convertToNv21Buffer((InputImage)((Object)arrayList2), false);
                }
                Frame$Builder frame$Builder = new Frame$Builder();
                n12 = ((InputImage)((Object)arrayList2)).getWidth();
                n11 = ((InputImage)((Object)arrayList2)).getHeight();
                object2 = frame$Builder.setImageData((ByteBuffer)object2, n12, n11, n16);
                n10 = ((InputImage)((Object)arrayList2)).getRotationDegrees();
                n10 = CommonConvertUtils.convertToMVRotation(n10);
                arrayList2 = ((Frame$Builder)object2).setRotation(n10);
                arrayList2 = ((Frame$Builder)((Object)arrayList2)).build();
            }
            object = ((FaceDetector)object).detect((Frame)((Object)arrayList2));
            arrayList2 = new ArrayList<Face>();
            while (n13 < (n15 = object.size())) {
                n15 = object.keyAt(n13);
                object2 = object.get(n15);
                object2 = (com.google.android.gms.vision.face.Face)object2;
                Face face = new Face((com.google.android.gms.vision.face.Face)object2);
                arrayList2.add(face);
                ++n13;
            }
            return arrayList2;
        }
    }

    /*
     * Unable to fully structure code
     */
    private final List zza(InputImage var1_1) {
        var2_2 = this;
        var3_3 = var1_1;
        synchronized (this) {
            block76: {
                block75: {
                    block77: {
                        block73: {
                            block72: {
                                block71: {
                                    var4_5 = SystemClock.elapsedRealtime();
                                    var6_6 = this.zzf;
                                    var7_7 = 13;
                                    if (var6_6 != null) ** GOTO lbl27
                                    var6_6 = this.zzg;
                                    if (var6_6 != null) ** GOTO lbl27
                                    var8_8 = zzbx.zzc;
                                    var9_10 = false;
                                    var10_12 = null;
                                    var11_14 = false;
                                    var12_16 = null;
                                    var6_6 = this;
                                    var13_18 = var1_1;
                                    this.zza(var8_8, var4_5, var1_1, 0, 0);
                                    var6_6 = "Face detector wasn't initialized correctly. This is most likely caused by invalid face detector options.";
                                    var3_3 = new Iterator<E>((String)var6_6, var7_7);
                                    throw var3_3;
lbl27:
                                    // 2 sources

                                    var6_6 = var2_2.zzi;
                                    var6_6.check((InputImage)var3_3);
                                    var6_6 = var2_2.zzf;
                                    var14_20 = 0;
                                    var8_9 = null;
                                    if (var6_6 == null) break block71;
                                    var6_6 = var2_2.zza((FaceDetector)var6_6, (InputImage)var3_3, var4_5);
                                    var13_19 = var2_2.zzb;
                                    var15_21 = var13_19.zze();
                                    if (var15_21) break block72;
                                    com.google.mlkit.vision.face.internal.zzb.zza((List)var6_6);
                                    break block72;
                                }
                                var16_22 = 0;
                                var6_6 = null;
                            }
                            var13_19 = var2_2.zzg;
                            if (var13_19 == null) break block73;
                            var8_9 = var2_2.zza((FaceDetector)var13_19, (InputImage)var3_3, var4_5);
                            com.google.mlkit.vision.face.internal.zzb.zza((List)var8_9);
                        }
                        if (var6_6 == null && var8_9 == null) {
                            var6_6 = "No detector is enabled";
                            var3_3 = new Iterator<E>((String)var6_6, var7_7);
                            throw var3_3;
                        }
                        if (var6_6 != null) break block77;
                        var3_3 = var8_9;
lbl63:
                        // 2 sources

                        while (true) {
                            var17_23 = var4_5;
                            ** GOTO lbl198
                            break;
                        }
                    }
                    if (var8_9 == null) {
                        var3_3 = var6_6;
                        ** continue;
                    }
                    var13_19 = new HashSet();
                    var10_13 = var8_9.iterator();
                    while (true) {
                        var11_15 = var10_13.hasNext();
                        if (var11_15 == 0) break;
                        var12_17 = (Face)var10_13.next();
                        var12_17 = var12_17;
                        var19_24 = var6_6.iterator();
                        var20_25 = false;
                        while (true) {
                            block79: {
                                block78: {
                                    block74: {
                                        var21_26 = var19_24.hasNext();
                                        if (!var21_26) break;
                                        var22_27 = var19_24.next();
                                        var22_27 = (Face)var22_27;
                                        var23_28 = var12_17.getBoundingBox();
                                        if (var23_28 == null) break block74;
                                        var23_28 = var22_27.getBoundingBox();
                                        if (var23_28 == null) break block74;
                                        var23_28 = var12_17.getBoundingBox();
                                        var24_29 = var22_27.getBoundingBox();
                                        var25_30 = var23_28.intersect(var24_29);
                                        if (!var25_30) break block74;
                                        var26_31 = var23_28.right;
                                        var7_7 = var24_29.right;
                                        var7_7 = Math.min(var26_31, var7_7);
                                        var26_31 = var23_28.left;
                                        var27_32 = var24_29.left;
                                        var27_32 = Math.max(var26_31, var27_32);
                                        var7_7 -= var27_32;
                                        var27_32 = var23_28.bottom;
                                        var26_31 = var24_29.bottom;
                                        var27_32 = Math.min(var27_32, var26_31);
                                        var26_31 = var23_28.top;
                                        var28_33 = var10_13;
                                        var9_11 = var24_29.top;
                                        var9_11 = Math.max(var26_31, var9_11);
                                        var3_3 = var19_24;
                                        var29_34 = var7_7 *= (var27_32 -= var9_11);
                                        var9_11 = var23_28.right;
                                        var26_31 = var23_28.left;
                                        var9_11 -= var26_31;
                                        var26_31 = var23_28.bottom;
                                        var31_35 = var23_28.top;
                                        var32_36 = var9_11 *= (var26_31 -= var31_35);
                                        var9_11 = var24_29.right;
                                        var34_37 = var19_24;
                                        var27_32 = var24_29.left;
                                        var9_11 -= var27_32;
                                        var27_32 = var24_29.bottom;
                                        var35_38 = var24_29.top;
                                        var17_23 = var4_5;
                                        var36_39 = var9_11 *= (var27_32 -= var35_38);
                                        var32_36 = var32_36 + var36_39 - var29_34;
                                        var4_5 = 0x3FE3333333333333L;
                                        var36_39 = 0.6;
                                        cfr_temp_0 = (var29_34 /= var32_36) - var36_39;
                                        var27_32 = (int)(cfr_temp_0 == 0.0 ? 0 : (cfr_temp_0 > 0.0 ? 1 : -1));
                                        if (var27_32 <= 0) break block78;
                                        var27_32 = 1;
                                        break block79;
                                    }
                                    var17_23 = var4_5;
                                    var28_33 = var10_13;
                                    var34_37 = var19_24;
                                }
                                var27_32 = 0;
                                var3_3 = null;
                            }
                            if (var27_32 != 0) {
                                var3_3 = var12_17.zza();
                                var22_27.zza((SparseArray)var3_3);
                                var20_25 = true;
                            }
                            var13_19.add(var22_27);
                            var3_3 = var1_1;
                            var10_13 = var28_33;
                            var19_24 = var34_37;
                            var4_5 = var17_23;
                            continue;
                            break;
                        }
                        var17_23 = var4_5;
                        var28_33 = var10_13;
                        if (!var20_25) {
                            var13_19.add(var12_17);
                        }
                        var3_3 = var1_1;
                        var10_13 = var28_33;
                        var4_5 = var17_23;
                    }
                    var17_23 = var4_5;
                    var3_3 = new Iterator<E>(var13_19);
lbl198:
                    // 2 sources

                    var38_40 = zzbx.zza;
                    if (var8_9 != null) break block75;
                    var9_11 = 0;
                    var10_13 = null;
                    break block76;
                }
                var9_11 = var14_20 = var8_9.size();
            }
            if (var6_6 == null) {
                var11_15 = 0;
                var12_17 = null;
            } else {
                var11_15 = var16_22 = var6_6.size();
            }
            var6_6 = this;
            var8_9 = var38_40;
            var4_5 = var17_23;
            var13_19 = var1_1;
            this.zza(var38_40, var17_23, var1_1, var9_11, var11_15);
            var6_6 = com.google.mlkit.vision.face.internal.zzb.zzd;
            var14_20 = 0;
            var8_9 = null;
            var6_6.set(false);
            return var3_3;
        }
    }

    private final void zza(zzbx object, long l10, InputImage inputImage, int n10, int n11) {
        Object object2 = inputImage;
        synchronized (this) {
            zze zze2;
            long l11 = SystemClock.elapsedRealtime();
            long l12 = l11 - l10;
            Object object3 = zze2;
            Object object4 = this;
            zze2 = new zze(this, l12, (zzbx)object, n10, n11, inputImage);
            object3 = this.zzc;
            object4 = zzcb.zza;
            ((zzel)object3).zza(zze2, (zzcb)object4);
            object3 = zzbm$zzd$zza.zza();
            object4 = object;
            object3 = ((zzbm$zzd$zza$zza)object3).zza((zzbx)object);
            object4 = zzd;
            boolean bl2 = ((AtomicBoolean)object4).get();
            object3 = ((zzbm$zzd$zza$zza)object3).zza(bl2);
            object4 = zze;
            int n12 = ((ImageUtils)object4).getMobileVisionImageFormat(inputImage);
            int n13 = ((ImageUtils)object4).getMobileVisionImageSize(inputImage);
            object2 = zzep.zza(n12, n13);
            object2 = ((zzbm$zzd$zza$zza)object3).zza((zzbm$zzae)object2);
            object2 = ((zzbm$zzd$zza$zza)object2).zza(n10);
            object2 = ((zzbm$zzd$zza$zza)object2).zzb(n11);
            object3 = this.zzb;
            object3 = ((FaceDetectorOptions)object3).zzh();
            object2 = ((zzbm$zzd$zza$zza)object2).zza((zzbm$zzac)object3);
            object2 = ((zzgd$zza)object2).zzh();
            object2 = (zzgd)object2;
            object2 = (zzbm$zzd$zza)object2;
            object3 = new zzd(this);
            object4 = this.zzc;
            zzcb zzcb2 = zzcb.zzc;
            object = object4;
            ((zzel)object4).zza(object2, l12, zzcb2, (zzel$zza)object3);
            return;
        }
    }

    private static void zza(List object) {
        boolean bl2;
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Face face = (Face)object.next();
            int n10 = -1;
            face.zza(n10);
        }
    }

    private static int zzb(int n10) {
        int n11 = 1;
        if (n10 != n11) {
            int n12 = 2;
            if (n10 == n12) {
                return n11;
            }
            StringBuilder stringBuilder = new StringBuilder(30);
            stringBuilder.append("Invalid mode type: ");
            stringBuilder.append(n10);
            String string2 = stringBuilder.toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
            throw illegalArgumentException;
        }
        return 0;
    }

    private static int zzc(int n10) {
        int n11 = 1;
        if (n10 != n11) {
            int n12 = 2;
            if (n10 == n12) {
                return n11;
            }
            StringBuilder stringBuilder = new StringBuilder(40);
            stringBuilder.append("Invalid classification type: ");
            stringBuilder.append(n10);
            String string2 = stringBuilder.toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
            throw illegalArgumentException;
        }
        return 0;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void load() {
        synchronized (this) {
            int n10;
            int n11;
            Object object = this.zzh;
            boolean bl2 = ((zzg)object).zza();
            boolean bl3 = true;
            float f10 = Float.MIN_VALUE;
            if (!bl2) {
                void var2_6;
                object = this.zza;
                String string2 = "com.google.android.gms.vision.dynamite.face";
                int n12 = DynamiteModule.getLocalVersion((Context)object, string2);
                if (n12 > 0) {
                    boolean bl4 = bl3;
                } else {
                    boolean bl5 = false;
                    object = null;
                }
                object = (boolean)var2_6;
                this.zzh = object = com.google.android.gms.internal.mlkit_vision_face.zzg.zzb(object);
            }
            if ((n11 = ((FaceDetectorOptions)(object = this.zzb)).zzb()) == (n10 = 2)) {
                int n13;
                int n14;
                int n15;
                object = this.zzg;
                if (object == null) {
                    Context context = this.zza;
                    object = new FaceDetector$Builder(context);
                    object = ((FaceDetector$Builder)object).setLandmarkType(n10);
                    object = ((FaceDetector$Builder)object).setMode(n10);
                    object = ((FaceDetector$Builder)object).setTrackingEnabled(false);
                    object = ((FaceDetector$Builder)object).setProminentFaceOnly(bl3);
                    this.zzg = object = ((FaceDetector$Builder)object).build();
                }
                if (((n15 = ((FaceDetectorOptions)(object = this.zzb)).zza()) == n10 || (n14 = ((FaceDetectorOptions)(object = this.zzb)).zzc()) == n10 || (n13 = ((FaceDetectorOptions)(object = this.zzb)).zzd()) == n10) && (object = this.zzf) == null) {
                    Object object2 = this.zza;
                    object = new FaceDetector$Builder((Context)object2);
                    object2 = this.zzb;
                    int n17 = ((FaceDetectorOptions)object2).zza();
                    n17 = com.google.mlkit.vision.face.internal.zzb.zza(n17);
                    object = ((FaceDetector$Builder)object).setLandmarkType(n17);
                    object2 = this.zzb;
                    int n19 = ((FaceDetectorOptions)object2).zzc();
                    n19 = com.google.mlkit.vision.face.internal.zzb.zzc(n19);
                    object = ((FaceDetector$Builder)object).setClassificationType(n19);
                    object2 = this.zzb;
                    int n21 = ((FaceDetectorOptions)object2).zzd();
                    n21 = com.google.mlkit.vision.face.internal.zzb.zzb(n21);
                    object = ((FaceDetector$Builder)object).setMode(n21);
                    object2 = this.zzb;
                    f10 = ((FaceDetectorOptions)object2).zzf();
                    object = ((FaceDetector$Builder)object).setMinFaceSize(f10);
                    object2 = this.zzb;
                    boolean bl6 = ((FaceDetectorOptions)object2).zze();
                    object = ((FaceDetector$Builder)object).setTrackingEnabled(bl6);
                    this.zzf = object = ((FaceDetector$Builder)object).build();
                    return;
                }
            } else {
                object = this.zzf;
                if (object == null) {
                    Object object3 = this.zza;
                    object = new FaceDetector$Builder((Context)object3);
                    object3 = this.zzb;
                    int n23 = ((FaceDetectorOptions)object3).zza();
                    n23 = com.google.mlkit.vision.face.internal.zzb.zza(n23);
                    object = ((FaceDetector$Builder)object).setLandmarkType(n23);
                    object3 = this.zzb;
                    int n25 = ((FaceDetectorOptions)object3).zzc();
                    n25 = com.google.mlkit.vision.face.internal.zzb.zzc(n25);
                    object = ((FaceDetector$Builder)object).setClassificationType(n25);
                    object3 = this.zzb;
                    int n27 = ((FaceDetectorOptions)object3).zzd();
                    n27 = com.google.mlkit.vision.face.internal.zzb.zzb(n27);
                    object = ((FaceDetector$Builder)object).setMode(n27);
                    object3 = this.zzb;
                    f10 = ((FaceDetectorOptions)object3).zzf();
                    object = ((FaceDetector$Builder)object).setMinFaceSize(f10);
                    object3 = this.zzb;
                    boolean bl7 = ((FaceDetectorOptions)object3).zze();
                    object = ((FaceDetector$Builder)object).setTrackingEnabled(bl7);
                    this.zzf = object = ((FaceDetector$Builder)object).build();
                }
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void release() {
        synchronized (this) {
            Object object = this.zzf;
            boolean bl2 = false;
            if (object != null) {
                ((FaceDetector)object).release();
                this.zzf = null;
            }
            if ((object = this.zzg) != null) {
                ((FaceDetector)object).release();
                this.zzg = null;
            }
            object = zzd;
            bl2 = true;
            ((AtomicBoolean)object).set(bl2);
            return;
        }
    }

    public final /* synthetic */ Object run(MLTaskInput mLTaskInput) {
        mLTaskInput = (InputImage)mLTaskInput;
        return this.zza((InputImage)mLTaskInput);
    }

    public final /* synthetic */ zzbm$zzad$zza zza(long l10, zzbx object, int n10, int n11, InputImage inputImage) {
        zzbm$zzap$zza zzbm$zzap$zza = zzbm$zzap.zza();
        zzhn zzhn2 = zzbm$zzaf.zza().zza(l10).zza((zzbx)object);
        int n12 = zzd.get();
        zzhn2 = zzhn2.zza(n12 != 0);
        n12 = 1;
        zzhn2 = zzhn2.zzb(n12 != 0).zzc(n12 != 0);
        zzhn2 = zzbm$zzap$zza.zza((zzbm$zzaf$zza)zzhn2);
        Object object2 = this.zzb.zzh();
        zzhn2 = ((zzbm$zzap$zza)zzhn2).zza((zzbm$zzac)object2).zza(n10).zzb(n11);
        object2 = zze;
        int bl2 = ((ImageUtils)object2).getMobileVisionImageFormat(inputImage);
        n12 = ((ImageUtils)object2).getMobileVisionImageSize(inputImage);
        object2 = zzep.zza(bl2, n12);
        zzhn2 = (zzbm$zzap)((zzgd)((zzbm$zzap$zza)zzhn2).zza((zzbm$zzae)object2).zzh());
        object2 = zzbm$zzad.zzb();
        object = this.zzh;
        Boolean bl3 = Boolean.FALSE;
        boolean bl4 = (Boolean)((zzg)object).zza(bl3);
        return ((zzbm$zzad$zza)object2).zza(bl4).zza((zzbm$zzap)zzhn2);
    }

    public final /* synthetic */ zzbm$zzad$zza zza(zzbm$zzd$zza zzhn2, int n10, zzbm$zzab zzbm$zzab) {
        zzbm$zzad$zza zzbm$zzad$zza = zzbm$zzad.zzb();
        zzg zzg2 = this.zzh;
        Boolean bl2 = Boolean.FALSE;
        boolean bl3 = (Boolean)zzg2.zza(bl2);
        zzbm$zzad$zza = zzbm$zzad$zza.zza(bl3);
        zzhn2 = zzbm$zzd.zza().zza(n10).zza((zzbm$zzd$zza)zzhn2).zza(zzbm$zzab);
        return zzbm$zzad$zza.zza((zzbm$zzd$zzb)zzhn2);
    }
}

