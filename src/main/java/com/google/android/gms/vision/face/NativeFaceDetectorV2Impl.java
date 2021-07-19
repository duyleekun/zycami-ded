/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.AssetManager
 *  android.graphics.PointF
 *  android.os.SystemClock
 */
package com.google.android.gms.vision.face;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.PointF;
import android.os.SystemClock;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.vision.zzbw;
import com.google.android.gms.internal.vision.zzcb;
import com.google.android.gms.internal.vision.zzcb$zza;
import com.google.android.gms.internal.vision.zzcc;
import com.google.android.gms.internal.vision.zzci;
import com.google.android.gms.internal.vision.zzci$zza;
import com.google.android.gms.internal.vision.zzci$zza$zza;
import com.google.android.gms.internal.vision.zzci$zzb;
import com.google.android.gms.internal.vision.zzci$zzb$zzb;
import com.google.android.gms.internal.vision.zzci$zzb$zzc;
import com.google.android.gms.internal.vision.zzci$zzc;
import com.google.android.gms.internal.vision.zzci$zzd;
import com.google.android.gms.internal.vision.zzci$zzd$zza;
import com.google.android.gms.internal.vision.zzci$zze;
import com.google.android.gms.internal.vision.zzci$zze$zza;
import com.google.android.gms.internal.vision.zzci$zzf;
import com.google.android.gms.internal.vision.zzci$zzf$zza;
import com.google.android.gms.internal.vision.zzci$zzg;
import com.google.android.gms.internal.vision.zzck;
import com.google.android.gms.internal.vision.zzcp;
import com.google.android.gms.internal.vision.zzct;
import com.google.android.gms.internal.vision.zzfl$zzd;
import com.google.android.gms.internal.vision.zzfl$zzd$zza;
import com.google.android.gms.internal.vision.zzfl$zzf;
import com.google.android.gms.internal.vision.zzfl$zzf$zza;
import com.google.android.gms.internal.vision.zzfl$zzh;
import com.google.android.gms.internal.vision.zzfl$zzh$zza;
import com.google.android.gms.internal.vision.zzfl$zzi;
import com.google.android.gms.internal.vision.zzfl$zzi$zza;
import com.google.android.gms.internal.vision.zzfl$zzj;
import com.google.android.gms.internal.vision.zzfl$zzj$zza;
import com.google.android.gms.internal.vision.zzfl$zzm;
import com.google.android.gms.internal.vision.zzfl$zzm$zza;
import com.google.android.gms.internal.vision.zzfl$zzn;
import com.google.android.gms.internal.vision.zzfl$zzn$zza;
import com.google.android.gms.internal.vision.zzfl$zzo;
import com.google.android.gms.internal.vision.zzhp;
import com.google.android.gms.internal.vision.zzid;
import com.google.android.gms.internal.vision.zzid$zza;
import com.google.android.gms.internal.vision.zzjp;
import com.google.android.gms.internal.vision.zzls;
import com.google.android.gms.internal.vision.zzls$zza;
import com.google.android.gms.internal.vision.zzls$zzb;
import com.google.android.gms.internal.vision.zzls$zze;
import com.google.android.gms.internal.vision.zzma;
import com.google.android.gms.internal.vision.zzu;
import com.google.android.gms.vision.clearcut.DynamiteClearcutLogger;
import com.google.android.gms.vision.face.FaceDetectorV2Jni;
import com.google.android.gms.vision.face.NativeFaceDetectorV2Impl$1;
import com.google.android.gms.vision.face.internal.client.FaceParcel;
import com.google.android.gms.vision.face.internal.client.LandmarkParcel;
import com.google.android.gms.vision.face.internal.client.zza;
import com.google.android.gms.vision.face.internal.client.zzf;
import com.google.android.gms.vision.face.internal.client.zzg;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public final class NativeFaceDetectorV2Impl
extends zzg {
    private static final GmsLogger zzcy;
    private final long zzcz;
    private final DynamiteClearcutLogger zzda;
    private final zzci$zzd zzdb;
    private final FaceDetectorV2Jni zzdc;

    static {
        GmsLogger gmsLogger;
        zzcy = gmsLogger = new GmsLogger("NativeFaceDetectorV2Imp", "");
    }

    public NativeFaceDetectorV2Impl(Context object, Context context, DynamiteClearcutLogger dynamiteClearcutLogger, zzf object2, FaceDetectorV2Jni faceDetectorV2Jni) {
        long l10;
        object = (zzci$zzg)((zzid)zzci$zzg.zzbz().zzk("models").zzgw());
        zzci$zzd$zza zzci$zzd$zza = zzci$zzd.zzbt();
        Object object3 = zzci$zze.zzbv().zzh((zzci$zzg)object).zzi((zzci$zzg)object).zzj((zzci$zzg)object);
        zzci$zzd$zza = zzci$zzd$zza.zza((zzci$zze$zza)object3);
        object3 = zzci$zza.zzbh().zzc((zzci$zzg)object).zzd((zzci$zzg)object);
        zzci$zzd$zza = zzci$zzd$zza.zza((zzci$zza$zza)object3);
        object3 = zzci$zzf.zzbx().zzk((zzci$zzg)object).zzl((zzci$zzg)object).zzm((zzci$zzg)object);
        object = ((zzci$zzf$zza)object3).zzn((zzci$zzg)object);
        object = zzci$zzd$zza.zza((zzci$zzf$zza)object);
        int n10 = ((zzf)object2).zzcv;
        object = ((zzci$zzd$zza)object).zzd(n10 != 0);
        n10 = ((zzf)object2).trackingEnabled;
        object = ((zzci$zzd$zza)object).zze(n10 != 0);
        float f10 = ((zzf)object2).proportionalMinFaceSize;
        object = ((zzci$zzd$zza)object).zze(f10);
        n10 = 1;
        f10 = Float.MIN_VALUE;
        object = ((zzci$zzd$zza)object).zzf(n10 != 0);
        int n11 = ((zzf)object2).mode;
        int n12 = 2;
        if (n11 != 0) {
            if (n11 != n10) {
                if (n11 == n12) {
                    object3 = zzct.zzlt;
                    ((zzci$zzd$zza)object).zzb((zzct)object3);
                }
            } else {
                object3 = zzct.zzls;
                ((zzci$zzd$zza)object).zzb((zzct)object3);
            }
        } else {
            object3 = zzct.zzlr;
            ((zzci$zzd$zza)object).zzb((zzct)object3);
        }
        n11 = ((zzf)object2).landmarkType;
        if (n11 != 0) {
            if (n11 != n10) {
                if (n11 == n12) {
                    object3 = zzcp.zzlj;
                    ((zzci$zzd$zza)object).zzb((zzcp)object3);
                }
            } else {
                object3 = zzcp.zzli;
                ((zzci$zzd$zza)object).zzb((zzcp)object3);
            }
        } else {
            object3 = zzcp.zzlh;
            ((zzci$zzd$zza)object).zzb((zzcp)object3);
        }
        int n13 = ((zzf)object2).zzcw;
        if (n13 != 0) {
            if (n13 == n10) {
                object2 = zzck.zzjm;
                ((zzci$zzd$zza)object).zzb((zzck)object2);
            }
        } else {
            object2 = zzck.zzjl;
            ((zzci$zzd$zza)object).zzb((zzck)object2);
        }
        this.zzdb = object = (zzci$zzd)((zzid)((zzid$zza)object).zzgw());
        context = context.getAssets();
        this.zzcz = l10 = faceDetectorV2Jni.zza((zzci$zzd)object, (AssetManager)context);
        this.zzda = dynamiteClearcutLogger;
        this.zzdc = faceDetectorV2Jni;
    }

    private static void zza(DynamiteClearcutLogger dynamiteClearcutLogger, zzu object, FaceParcel[] object2, String cloneable, long l10) {
        int n10 = ((zzu)object).id;
        int n11 = 2;
        if (n10 > n11 && (n10 = ((FaceParcel[])object2).length) == 0) {
            return;
        }
        cloneable = new ArrayList();
        n11 = ((FaceParcel[])object2).length;
        for (int i10 = 0; i10 < n11; ++i10) {
            Object object3 = object2[i10];
            zzjp zzjp2 = zzfl$zzm.zzdy();
            float f10 = ((FaceParcel)object3).centerX;
            float f11 = ((FaceParcel)object3).width;
            float f12 = 2.0f;
            int n12 = (int)(f10 - (f11 /= f12));
            zzjp2 = ((zzfl$zzm$zza)zzjp2).zzaf(n12);
            f10 = ((FaceParcel)object3).centerY;
            f11 = ((FaceParcel)object3).height / f12;
            n12 = (int)(f10 -= f11);
            zzjp2 = (zzfl$zzm)((zzid)((zzfl$zzm$zza)zzjp2).zzag(n12).zzgw());
            zzjp zzjp3 = zzfl$zzm.zzdy();
            f11 = ((FaceParcel)object3).centerX;
            float f13 = ((FaceParcel)object3).width / f12;
            int n13 = (int)(f11 + f13);
            zzjp3 = zzjp3.zzaf(n13);
            f11 = ((FaceParcel)object3).centerY;
            f13 = ((FaceParcel)object3).height / f12;
            n13 = (int)(f11 -= f13);
            zzjp3 = (zzfl$zzm)((zzid)zzjp3.zzag(n13).zzgw());
            zzjp zzjp4 = zzfl$zzm.zzdy();
            f13 = ((FaceParcel)object3).centerX;
            float f14 = ((FaceParcel)object3).width / f12;
            int n14 = (int)(f13 + f14);
            zzjp4 = zzjp4.zzaf(n14);
            f13 = ((FaceParcel)object3).centerY;
            f14 = ((FaceParcel)object3).height / f12;
            n14 = (int)(f13 += f14);
            zzjp4 = (zzfl$zzm)((zzid)zzjp4.zzag(n14).zzgw());
            zzjp zzjp5 = zzfl$zzm.zzdy();
            f14 = ((FaceParcel)object3).centerX;
            float f15 = ((FaceParcel)object3).width / f12;
            int n15 = (int)(f14 - f15);
            zzjp5 = zzjp5.zzaf(n15);
            f14 = ((FaceParcel)object3).centerY;
            f15 = ((FaceParcel)object3).height / f12;
            int n16 = (int)(f14 + f15);
            zzfl$zzm zzfl$zzm = (zzfl$zzm)((zzid)zzjp5.zzag(n16).zzgw());
            zzjp5 = zzfl$zzh.zzdo();
            f14 = ((FaceParcel)object3).zzdh;
            zzjp5 = ((zzfl$zzh$zza)zzjp5).zzj(f14);
            f14 = ((FaceParcel)object3).zzdi;
            zzjp5 = ((zzfl$zzh$zza)zzjp5).zzk(f14);
            f14 = ((FaceParcel)object3).zzdj;
            zzjp5 = ((zzfl$zzh$zza)zzjp5).zzl(f14);
            f14 = ((FaceParcel)object3).zzcm;
            zzjp5 = ((zzfl$zzh$zza)zzjp5).zzg(f14);
            f14 = ((FaceParcel)object3).zzcn;
            zzjp5 = ((zzfl$zzh$zza)zzjp5).zzh(f14);
            f14 = ((FaceParcel)object3).zzco;
            zzjp5 = (zzfl$zzh)((zzid)((zzfl$zzh$zza)zzjp5).zzi(f14).zzgw());
            zzfl$zzn$zza zzfl$zzn$zza = zzfl$zzn.zzea();
            zzfl$zzd$zza zzfl$zzd$zza = zzfl$zzd.zzdh();
            zzjp2 = zzfl$zzd$zza.zzb((zzfl$zzm)zzjp2).zzb((zzfl$zzm)zzjp3).zzb((zzfl$zzm)zzjp4).zzb(zzfl$zzm);
            zzjp2 = zzfl$zzn$zza.zza((zzfl$zzd$zza)zzjp2);
            int n17 = ((FaceParcel)object3).id;
            object3 = (zzfl$zzn)((zzid)((zzfl$zzn$zza)zzjp2).zzah(n17).zzb((zzfl$zzh)zzjp5).zzgw());
            cloneable.add(object3);
        }
        int n18 = ((FaceParcel[])object2).length;
        zzfl$zzi$zza zzfl$zzi$zza = zzfl$zzi.zzdr();
        zzfl$zzf$zza zzfl$zzf$zza = zzfl$zzf.zzdk().zzq("face").zzd(l10);
        long l11 = n18;
        object2 = zzfl$zzf$zza.zze(l11);
        ((zzfl$zzf$zza)object2).zzc((Iterable)((Object)cloneable));
        cloneable = new ArrayList();
        object2 = (zzfl$zzf)((zzid)((zzid$zza)object2).zzgw());
        cloneable.add(object2);
        object2 = zzfl$zzi$zza.zze((Iterable)((Object)cloneable));
        cloneable = zzfl$zzj.zzdt();
        l10 = ((zzu)object).height;
        cloneable = ((zzfl$zzj$zza)cloneable).zzi(l10);
        l10 = ((zzu)object).width;
        cloneable = ((zzfl$zzj$zza)cloneable).zzh(l10);
        l10 = ((zzu)object).id;
        cloneable = ((zzfl$zzj$zza)cloneable).zzj(l10);
        l10 = ((zzu)object).zzaz;
        object = (zzfl$zzj)((zzid)((zzfl$zzj$zza)cloneable).zzk(l10).zzgw());
        object = (zzfl$zzi)((zzid)((zzfl$zzi$zza)object2).zza((zzfl$zzj)object).zzgw());
        object = (zzfl$zzo)((zzid)zzfl$zzo.zzec().zzb((zzfl$zzi)object).zzgw());
        dynamiteClearcutLogger.zza(3, (zzfl$zzo)object);
    }

    private static FaceParcel[] zza(zzci$zzc zzci$zzc, zzck zzck2, zzcp zzcp2) {
        int n10;
        Object object = zzcp2;
        Object object2 = zzci$zzc.zzbp();
        int n11 = ((zzma)object2).zzkg();
        FaceParcel[] faceParcelArray = new FaceParcel[n11];
        for (int i10 = 0; i10 < (n10 = ((zzma)object2).zzkg()); ++i10) {
            zza[] zzaArray;
            float f10;
            int n12;
            int n13;
            Object object3;
            Object object4;
            Object object5;
            Object object6;
            ArrayList<Object> arrayList;
            float f11;
            float f12;
            float f13;
            float f14;
            int n14;
            boolean bl2;
            Object object7;
            Object object8;
            Object object9;
            int n15;
            float f15;
            int n16;
            int n17;
            zzls zzls2 = ((zzma)object2).zzcj(i10);
            Object object10 = zzls2.zzjm();
            float f16 = ((zzls$zzb)object10).zzjx();
            float f17 = ((zzls$zzb)object10).zzjz();
            float f18 = ((zzls$zzb)object10).zzjx();
            f17 -= f18;
            int n18 = 0x40000000;
            f18 = 2.0f;
            float f19 = f16 + (f17 /= f18);
            f16 = ((zzls$zzb)object10).zzjy();
            f17 = ((zzls$zzb)object10).zzka();
            float f20 = ((zzls$zzb)object10).zzjy();
            f17 = (f17 - f20) / f18;
            float f21 = f16 + f17;
            f16 = ((zzls$zzb)object10).zzjz();
            f17 = ((zzls$zzb)object10).zzjx();
            float f22 = f16 - f17;
            f16 = ((zzls$zzb)object10).zzka();
            float f23 = ((zzls$zzb)object10).zzjy();
            float f24 = f16 - f23;
            object10 = zzck.zzjm;
            Object object11 = zzck2;
            if (zzck2 == object10) {
                object10 = zzls2.zzjs().iterator();
                n18 = -1082130432;
                f18 = -1.0f;
                n17 = -1082130432;
                f20 = -1.0f;
                n16 = -1082130432;
                f15 = -1.0f;
                while ((n15 = object10.hasNext()) != 0) {
                    object9 = (zzls$zza)object10.next();
                    object8 = object9.getName();
                    bl2 = object8.equals(object7 = "joy");
                    if (bl2) {
                        f15 = object9.getConfidence();
                        continue;
                    }
                    object7 = object9.getName();
                    object8 = "left_eye_closed";
                    bl2 = ((String)object7).equals(object8);
                    n14 = 1065353216;
                    f16 = 1.0f;
                    if (bl2) {
                        f14 = object9.getConfidence();
                        f18 = f16 - f14;
                        continue;
                    }
                    object7 = object9.getName();
                    bl2 = ((String)object7).equals(object8 = "right_eye_closed");
                    if (!bl2) continue;
                    f14 = object9.getConfidence();
                    n14 = 1065353216;
                    f16 = 1.0f;
                    f20 = f16 - f14;
                }
                f13 = f18;
                f12 = f20;
                f11 = f15;
            } else {
                f13 = -1.0f;
                f12 = -1.0f;
                f11 = -1.0f;
            }
            bl2 = zzls2.zzjo();
            float f25 = bl2 ? (f14 = zzls2.getConfidence()) : -1.0f;
            object7 = zzcp.zzli;
            object10 = "NativeFaceDetectorV2Imp";
            int n19 = 11;
            float f26 = 1.5E-44f;
            int n20 = 5;
            int n21 = 6;
            float f27 = 8.4E-45f;
            int n22 = 10;
            int n23 = 4;
            int n24 = 1;
            if (object == object7) {
                object7 = zzls2.zzjn();
                arrayList = new ArrayList<Object>();
                f20 = 0.0f;
                object6 = null;
                for (n17 = 0; n17 < (n16 = object7.size()); ++n17) {
                    object5 = (zzls$zze)object7.get(n17);
                    object4 = ((zzls$zze)object5).zzke();
                    int[] nArray = NativeFaceDetectorV2Impl$1.zzdd;
                    int n25 = ((Enum)object4).ordinal();
                    int n26 = nArray[n25];
                    switch (n26) {
                        default: {
                            object9 = zzcy;
                            object8 = String.valueOf(object4);
                            int n27 = String.valueOf(object8).length();
                            object3 = object2;
                            n13 = n27 + 23;
                            object4 = object7;
                            object7 = new StringBuilder(n13);
                            ((StringBuilder)object7).append("Unknown landmark type: ");
                            ((StringBuilder)object7).append((String)object8);
                            object2 = ((StringBuilder)object7).toString();
                            object9.d((String)object10, (String)object2);
                            n15 = -1;
                            break;
                        }
                        case 12: {
                            object3 = object2;
                            object4 = object7;
                            n15 = 8;
                            break;
                        }
                        case 11: {
                            object3 = object2;
                            object4 = object7;
                            n15 = 2;
                            break;
                        }
                        case 10: {
                            object3 = object2;
                            object4 = object7;
                            n15 = 7;
                            break;
                        }
                        case 9: {
                            object3 = object2;
                            object4 = object7;
                            n15 = n24;
                            break;
                        }
                        case 8: {
                            object3 = object2;
                            object4 = object7;
                            n15 = 9;
                            break;
                        }
                        case 7: {
                            object3 = object2;
                            object4 = object7;
                            n15 = 3;
                            break;
                        }
                        case 6: {
                            object3 = object2;
                            object4 = object7;
                            n15 = n19;
                            break;
                        }
                        case 5: {
                            object3 = object2;
                            object4 = object7;
                            n15 = n20;
                            break;
                        }
                        case 4: {
                            object3 = object2;
                            object4 = object7;
                            n15 = 0;
                            object9 = null;
                            break;
                        }
                        case 3: {
                            object3 = object2;
                            object4 = object7;
                            n15 = n21;
                            break;
                        }
                        case 2: {
                            object3 = object2;
                            object4 = object7;
                            n15 = n22;
                            break;
                        }
                        case 1: {
                            object3 = object2;
                            object4 = object7;
                            n15 = n23;
                        }
                    }
                    if (n15 >= 0) {
                        f14 = ((zzls$zze)object5).getX();
                        f16 = ((zzls$zze)object5).getY();
                        n16 = -1;
                        f15 = 0.0f / 0.0f;
                        object2 = new LandmarkParcel(n16, f14, f16, n15);
                        arrayList.add(object2);
                    } else {
                        n16 = -1;
                        f15 = 0.0f / 0.0f;
                    }
                    object7 = object4;
                    object2 = object3;
                }
                object3 = object2;
                n13 = 0;
                object2 = null;
                n16 = -1;
                f15 = 0.0f / 0.0f;
                object7 = new LandmarkParcel[]{};
                object7 = (LandmarkParcel[])arrayList.toArray((T[])object7);
            } else {
                object3 = object2;
                n13 = 0;
                object2 = null;
                n16 = -1;
                f15 = 0.0f / 0.0f;
                object7 = new LandmarkParcel[]{};
            }
            object2 = zzcp.zzlj;
            if (object == object2) {
                object2 = zzci.zzjg;
                object2 = (List)zzls2.zzc((zzhp)object2);
                n14 = object2.size();
                object8 = new zza[n14];
                f18 = 0.0f;
                arrayList = null;
                for (n18 = 0; n18 < (n17 = object2.size()); ++n18) {
                    object6 = (zzci$zzb)object2.get(n18);
                    n15 = ((zzci$zzb)object6).zzbl();
                    object9 = new PointF[n15];
                    f15 = 0.0f;
                    object5 = null;
                    for (n16 = 0; n16 < (n12 = ((zzci$zzb)object6).zzbl()); ++n16) {
                        object = (zzci$zzb$zzb)((zzci$zzb)object6).zzbk().get(n16);
                        object4 = object2;
                        f17 = ((zzci$zzb$zzb)object).getX();
                        f10 = ((zzci$zzb$zzb)object).getY();
                        object2 = new PointF(f17, f10);
                        object9[n16] = object2;
                        object11 = zzck2;
                        object2 = object4;
                    }
                    object4 = object2;
                    object2 = ((zzci$zzb)object6).zzbj();
                    object11 = NativeFaceDetectorV2Impl$1.zzde;
                    n17 = ((Enum)object2).ordinal();
                    Object object12 = object11[n17];
                    switch (object12) {
                        default: {
                            object11 = zzcy;
                            n13 = ((zzci$zzb$zzc)object2).zzak();
                            n17 = 33;
                            f20 = 4.6E-44f;
                            object5 = new StringBuilder(n17);
                            object6 = "Unknown contour type: ";
                            ((StringBuilder)object5).append((String)object6);
                            ((StringBuilder)object5).append(n13);
                            object2 = ((StringBuilder)object5).toString();
                            ((GmsLogger)object11).e((String)object10, (String)object2);
                            n13 = -1;
                            break;
                        }
                        case 15: {
                            n13 = 15;
                            break;
                        }
                        case 14: {
                            n13 = 14;
                            break;
                        }
                        case 13: {
                            n13 = 13;
                            break;
                        }
                        case 12: {
                            n13 = 12;
                            break;
                        }
                        case 11: {
                            n13 = n19;
                            break;
                        }
                        case 10: {
                            n13 = n22;
                            break;
                        }
                        case 9: {
                            n13 = 9;
                            break;
                        }
                        case 8: {
                            n13 = 8;
                            break;
                        }
                        case 7: {
                            n13 = 7;
                            break;
                        }
                        case 6: {
                            n13 = n21;
                            break;
                        }
                        case 5: {
                            n13 = n20;
                            break;
                        }
                        case 4: {
                            n13 = n23;
                            break;
                        }
                        case 3: {
                            n13 = 3;
                            break;
                        }
                        case 2: {
                            n13 = 2;
                            break;
                        }
                        case 1: {
                            n13 = n24;
                        }
                    }
                    object8[n18] = object = new zza((PointF[])object9, n13);
                    object11 = zzck2;
                    object = zzcp2;
                    object2 = object4;
                    n16 = -1;
                    f15 = 0.0f / 0.0f;
                }
                zzaArray = object8;
                n12 = 0;
                f10 = 0.0f;
                object = null;
            } else {
                n12 = 0;
                f10 = 0.0f;
                object = null;
                object2 = new zza[]{};
                zzaArray = object2;
            }
            n16 = 3;
            f15 = 4.2E-45f;
            long l10 = zzls2.zzjt();
            n15 = (int)l10;
            f26 = zzls2.zzjq();
            f23 = -zzls2.zzjp();
            f27 = zzls2.zzjr();
            object6 = object2;
            faceParcelArray[i10] = object2 = new FaceParcel(n16, n15, f19, f21, f22, f24, f26, f23, f27, (LandmarkParcel[])object7, f13, f12, f11, zzaArray, f25);
            object = zzcp2;
            object2 = object3;
        }
        return faceParcelArray;
    }

    private static zzcc zze(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    n11 = 3;
                    if (n10 == n11) {
                        return zzcc.zzid;
                    }
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unsupported rotation degree.");
                    throw illegalArgumentException;
                }
                return zzcc.zzie;
            }
            return zzcc.zzif;
        }
        return zzcc.zzic;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final FaceParcel[] zza(IObjectWrapper object, IObjectWrapper object2, IObjectWrapper object3, int n10, int n11, int n12, int n13, int n14, int n15, zzu zzu2) {
        void var10_11;
        NativeFaceDetectorV2Impl nativeFaceDetectorV2Impl = this;
        void var12_13 = var10_11;
        long l10 = SystemClock.elapsedRealtime();
        try {
            void var9_10;
            void var8_9;
            void var7_8;
            void var6_7;
            void var5_6;
            boolean bl2;
            FaceParcel[] faceParcelArray = ObjectWrapper.unwrap((IObjectWrapper)object);
            Object object4 = faceParcelArray;
            object4 = (ByteBuffer)faceParcelArray;
            faceParcelArray = ObjectWrapper.unwrap((IObjectWrapper)object2);
            Object object5 = faceParcelArray;
            object5 = (ByteBuffer)faceParcelArray;
            faceParcelArray = ObjectWrapper.unwrap((IObjectWrapper)object3);
            Object object6 = faceParcelArray;
            object6 = (ByteBuffer)faceParcelArray;
            faceParcelArray = zzcb.zzam();
            int n16 = var10_11.width;
            faceParcelArray = faceParcelArray.zzj(n16);
            n16 = var10_11.height;
            faceParcelArray = faceParcelArray.zzk(n16);
            n16 = var10_11.rotation;
            Object object7 = NativeFaceDetectorV2Impl.zze(n16);
            faceParcelArray = faceParcelArray.zzb((zzcc)object7);
            long l11 = var10_11.zzaz;
            long l12 = 0L;
            long l13 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
            if (l13 > 0) {
                l12 = 1000L;
                faceParcelArray.zzc(l11 *= l12);
            }
            faceParcelArray = faceParcelArray.zzgw();
            faceParcelArray = (zzid)faceParcelArray;
            Object object8 = faceParcelArray;
            object8 = (zzcb)faceParcelArray;
            int n17 = ((ByteBuffer)object4).isDirect();
            if (n17 != 0) {
                object7 = nativeFaceDetectorV2Impl.zzdc;
                long l14 = nativeFaceDetectorV2Impl.zzcz;
                faceParcelArray = ((FaceDetectorV2Jni)object7).zza(l14, (ByteBuffer)object4, (ByteBuffer)object5, (ByteBuffer)object6, (int)(bl2 ? 1 : 0), (int)var5_6, (int)var6_7, (int)var7_8, (int)var8_9, (int)var9_10, (zzcb)object8);
            } else {
                n17 = ((ByteBuffer)object4).hasArray();
                if (n17 != 0 && (n17 = ((ByteBuffer)object4).arrayOffset()) == 0) {
                    n17 = 0;
                    faceParcelArray = null;
                    Object object9 = object5 != null && (n16 = (int)(((ByteBuffer)object5).hasArray() ? 1 : 0)) != 0 && (n16 = ((ByteBuffer)object5).arrayOffset()) == 0 ? (object7 = (Object)((ByteBuffer)object5).array()) : null;
                    if (object6 != null && (n16 = (int)(((ByteBuffer)object6).hasArray() ? 1 : 0)) != 0 && (n16 = ((ByteBuffer)object6).arrayOffset()) == 0) {
                        faceParcelArray = (FaceParcel[])((ByteBuffer)object6).array();
                    }
                    FaceDetectorV2Jni faceDetectorV2Jni = nativeFaceDetectorV2Impl.zzdc;
                    long l15 = nativeFaceDetectorV2Impl.zzcz;
                    byte[] byArray = ((ByteBuffer)object4).array();
                    faceParcelArray = faceDetectorV2Jni.zza(l15, byArray, (byte[])object9, (byte[])faceParcelArray, (int)(bl2 ? 1 : 0), (int)var5_6, (int)var6_7, (int)var7_8, (int)var8_9, (int)var9_10, (zzcb)object8);
                } else {
                    n17 = ((Buffer)object4).remaining();
                    byte[] byArray = new byte[n17];
                    ((ByteBuffer)object4).get(byArray);
                    n17 = ((Buffer)object5).remaining();
                    byte[] byArray2 = new byte[n17];
                    ((ByteBuffer)object4).get(byArray);
                    n17 = ((Buffer)object6).remaining();
                    faceParcelArray = (FaceParcel[])new byte[n17];
                    ((ByteBuffer)object4).get(byArray);
                    FaceDetectorV2Jni faceDetectorV2Jni = nativeFaceDetectorV2Impl.zzdc;
                    long l16 = nativeFaceDetectorV2Impl.zzcz;
                    faceParcelArray = faceDetectorV2Jni.zza(l16, byArray, byArray2, (byte[])faceParcelArray, (int)(bl2 ? 1 : 0), (int)var5_6, (int)var6_7, (int)var7_8, (int)var8_9, (int)var9_10, (zzcb)object8);
                }
            }
            object7 = nativeFaceDetectorV2Impl.zzdb;
            object7 = ((zzci$zzd)object7).zzbs();
            Object object10 = nativeFaceDetectorV2Impl.zzdb;
            object10 = ((zzci$zzd)object10).zzbr();
            faceParcelArray = NativeFaceDetectorV2Impl.zza((zzci$zzc)faceParcelArray, (zzck)object7, (zzcp)object10);
            object7 = nativeFaceDetectorV2Impl.zzda;
            object10 = null;
            long l17 = SystemClock.elapsedRealtime();
            l10 = l17 - l10;
            object = object7;
            object2 = var10_11;
            Object object11 = faceParcelArray;
            bl2 = false;
            NativeFaceDetectorV2Impl.zza((DynamiteClearcutLogger)object7, (zzu)var10_11, faceParcelArray, null, l10);
            return faceParcelArray;
        }
        catch (Exception exception) {
            zzcy.e("NativeFaceDetectorV2Imp", "Native face detection v2 failed", exception);
            return new FaceParcel[0];
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final FaceParcel[] zzc(IObjectWrapper faceParcelArray, zzu zzu2) {
        long l10 = SystemClock.elapsedRealtime();
        try {
            faceParcelArray = ObjectWrapper.unwrap((IObjectWrapper)faceParcelArray);
            faceParcelArray = (ByteBuffer)faceParcelArray;
            Object object = zzcb.zzam();
            int n10 = zzu2.width;
            object = ((zzcb$zza)object).zzj(n10);
            n10 = zzu2.height;
            object = ((zzcb$zza)object).zzk(n10);
            n10 = zzu2.rotation;
            Object object2 = NativeFaceDetectorV2Impl.zze(n10);
            object = ((zzcb$zza)object).zzb((zzcc)object2);
            object2 = zzbw.zzhk;
            object = ((zzcb$zza)object).zzb((zzbw)object2);
            long l11 = zzu2.zzaz;
            long l12 = 0L;
            long l13 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
            if (l13 > 0) {
                l12 = 1000L;
                ((zzcb$zza)object).zzc(l11 *= l12);
            }
            object = ((zzid$zza)object).zzgw();
            object = (zzid)object;
            object = (zzcb)object;
            n10 = (int)(faceParcelArray.isDirect() ? 1 : 0);
            if (n10 != 0) {
                object2 = this.zzdc;
                long l14 = this.zzcz;
                faceParcelArray = ((FaceDetectorV2Jni)object2).zza(l14, (ByteBuffer)faceParcelArray, (zzcb)object);
            } else {
                n10 = (int)(faceParcelArray.hasArray() ? 1 : 0);
                if (n10 != 0 && (n10 = faceParcelArray.arrayOffset()) == 0) {
                    object2 = this.zzdc;
                    long l15 = this.zzcz;
                    faceParcelArray = (FaceParcel[])faceParcelArray.array();
                    faceParcelArray = ((FaceDetectorV2Jni)object2).zza(l15, (byte[])faceParcelArray, (zzcb)object);
                } else {
                    n10 = faceParcelArray.remaining();
                    object2 = new byte[n10];
                    faceParcelArray.get((byte[])object2);
                    faceParcelArray = this.zzdc;
                    long l16 = this.zzcz;
                    faceParcelArray = faceParcelArray.zza(l16, (byte[])object2, (zzcb)object);
                }
            }
            object = this.zzdb;
            object = ((zzci$zzd)object).zzbs();
            object2 = this.zzdb;
            object2 = ((zzci$zzd)object2).zzbr();
            faceParcelArray = NativeFaceDetectorV2Impl.zza((zzci$zzc)faceParcelArray, (zzck)object, (zzcp)object2);
            DynamiteClearcutLogger dynamiteClearcutLogger = this.zzda;
            long l17 = SystemClock.elapsedRealtime();
            long l18 = l17 - l10;
            NativeFaceDetectorV2Impl.zza(dynamiteClearcutLogger, zzu2, faceParcelArray, null, l18);
            return faceParcelArray;
        }
        catch (Exception exception) {
            zzcy.e("NativeFaceDetectorV2Imp", "Native face detection v2 failed", exception);
            return new FaceParcel[0];
        }
    }

    public final boolean zzd(int n10) {
        return true;
    }

    public final void zzo() {
        FaceDetectorV2Jni faceDetectorV2Jni = this.zzdc;
        long l10 = this.zzcz;
        faceDetectorV2Jni.zza(l10);
    }
}

