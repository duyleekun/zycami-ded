/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgr;
import com.google.android.gms.internal.vision.zzgs;
import com.google.android.gms.internal.vision.zzho;
import com.google.android.gms.internal.vision.zzhq;
import com.google.android.gms.internal.vision.zzhr;
import com.google.android.gms.internal.vision.zzht;
import com.google.android.gms.internal.vision.zzhv;
import com.google.android.gms.internal.vision.zzid$zzd;
import com.google.android.gms.internal.vision.zzid$zze;
import com.google.android.gms.internal.vision.zzid$zzg;
import com.google.android.gms.internal.vision.zzie;
import com.google.android.gms.internal.vision.zzig;
import com.google.android.gms.internal.vision.zzin;
import com.google.android.gms.internal.vision.zzjn;
import com.google.android.gms.internal.vision.zzkb;
import com.google.android.gms.internal.vision.zzkc;
import com.google.android.gms.internal.vision.zzkf;
import com.google.android.gms.internal.vision.zzkh;
import com.google.android.gms.internal.vision.zzkx;
import com.google.android.gms.internal.vision.zzlk;
import com.google.android.gms.internal.vision.zzlq;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

public final class zzhs
extends zzhq {
    public final int zza(Map.Entry entry) {
        return ((zzid$zzd)entry.getKey()).number;
    }

    public final Object zza(zzho zzho2, zzjn zzjn2, int n10) {
        return zzho2.zza(zzjn2, n10);
    }

    public final Object zza(zzkc object, Object object2, zzho object3, zzht zzht2, Object object4, zzkx clazz) {
        Object object5;
        object2 = (zzid$zzg)object2;
        Object object6 = ((zzid$zzg)object2).zzyr;
        int n10 = ((zzid$zzd)object6).number;
        object6 = ((zzid$zzd)object6).zzyd;
        zzlk zzlk2 = zzlk.zzads;
        Object object7 = null;
        if (object6 == zzlk2) {
            object5 = object.zzes();
            object3 = ((zzig)null).zzh((int)object5);
            if (object3 == null) {
                return zzkh.zza(n10, object5, object4, (zzkx)((Object)clazz));
            }
            object7 = object5;
        } else {
            clazz = (Class<?>)zzhr.zztn;
            int n11 = ((Enum)object6).ordinal();
            Object object8 = clazz[n11];
            switch (object8) {
                default: {
                    break;
                }
                case 18: {
                    clazz = ((zzid$zzg)object2).zzyq.getClass();
                    object7 = object.zza(clazz, (zzho)object3);
                    break;
                }
                case 17: {
                    clazz = ((zzid$zzg)object2).zzyq.getClass();
                    object7 = object.zzb(clazz, (zzho)object3);
                    break;
                }
                case 16: {
                    object7 = object.readString();
                    break;
                }
                case 15: {
                    object7 = object.zzex();
                    break;
                }
                case 14: {
                    object = new IllegalStateException("Shouldn't reach here.");
                    throw object;
                }
                case 13: {
                    long l10 = object.zzfd();
                    object7 = l10;
                    break;
                }
                case 12: {
                    object5 = object.zzfc();
                    object7 = object5;
                    break;
                }
                case 11: {
                    long l11 = object.zzfb();
                    object7 = l11;
                    break;
                }
                case 10: {
                    object5 = object.zzfa();
                    object7 = object5;
                    break;
                }
                case 9: {
                    object5 = object.zzey();
                    object7 = object5;
                    break;
                }
                case 8: {
                    object5 = object.zzev();
                    object7 = (boolean)object5;
                    break;
                }
                case 7: {
                    object5 = object.zzeu();
                    object7 = object5;
                    break;
                }
                case 6: {
                    long l12 = object.zzet();
                    object7 = l12;
                    break;
                }
                case 5: {
                    object5 = object.zzes();
                    object7 = object5;
                    break;
                }
                case 4: {
                    long l13 = object.zzeq();
                    object7 = l13;
                    break;
                }
                case 3: {
                    long l14 = object.zzer();
                    object7 = l14;
                    break;
                }
                case 2: {
                    float f10 = object.readFloat();
                    object7 = Float.valueOf(f10);
                    break;
                }
                case 1: {
                    double d10 = object.readDouble();
                    object7 = d10;
                }
            }
        }
        object = ((zzid$zzg)object2).zzyr;
        Object object9 = ((zzid$zzd)object).zzye;
        if (object9 != 0) {
            zzht2.zzb((zzhv)object, object7);
        } else {
            object3 = zzhr.zztn;
            object = ((zzid$zzd)object).zzyd;
            object5 = ((Enum)object).ordinal();
            object9 = 17;
            if ((object5 = (Object)object3[object5]) == object9 || object5 == (object9 = 18)) {
                object = ((zzid$zzg)object2).zzyr;
                if ((object = zzht2.zza((zzhv)object)) != null) {
                    object7 = zzie.zzb(object, object7);
                }
            }
            object = ((zzid$zzg)object2).zzyr;
            zzht2.zza((zzhv)object, object7);
        }
        return object4;
    }

    public final void zza(zzgs object, Object object2, zzho zzho2, zzht zzht2) {
        object2 = (zzid$zzg)object2;
        zzjn zzjn2 = ((zzid$zzg)object2).zzyq.zzhd().zzgv();
        int n10 = ((zzgs)object).size();
        if (n10 == 0) {
            object = zzie.zzys;
        } else {
            byte[] byArray = new byte[n10];
            ((zzgs)object).zza(byArray, 0, 0, n10);
            object = byArray;
        }
        object = ByteBuffer.wrap((byte[])object);
        n10 = (int)(((ByteBuffer)object).hasArray() ? 1 : 0);
        if (n10 != 0) {
            boolean bl2 = true;
            zzgr zzgr2 = new zzgr((ByteBuffer)object, bl2);
            zzkb.zzik().zzx(zzjn2).zza(zzjn2, zzgr2, zzho2);
            object = ((zzid$zzg)object2).zzyr;
            zzht2.zza((zzhv)object, zzjn2);
            int n11 = zzgr2.zzeo();
            int n12 = -1 >>> 1;
            if (n11 == n12) {
                return;
            }
            throw zzin.zzhl();
        }
        object = new IllegalArgumentException("Direct buffers not yet supported");
        throw object;
    }

    public final void zza(zzkc object, Object object2, zzho zzho2, zzht zzht2) {
        object2 = (zzid$zzg)object2;
        Class<?> clazz = ((zzid$zzg)object2).zzyq.getClass();
        object = object.zza(clazz, zzho2);
        object2 = ((zzid$zzg)object2).zzyr;
        zzht2.zza((zzhv)object2, object);
    }

    public final void zza(zzlq zzlq2, Map.Entry object) {
        zzid$zzd zzid$zzd = (zzid$zzd)object.getKey();
        int n10 = zzid$zzd.zzye;
        if (n10 != 0) {
            Object object2 = zzhr.zztn;
            int n11 = zzid$zzd.zzyd.ordinal();
            n10 = object2[n11];
            n11 = 0;
            Object var7_9 = null;
            switch (n10) {
                default: {
                    break;
                }
                case 18: {
                    boolean bl2;
                    object2 = (List)object.getValue();
                    if (object2 == null || (bl2 = object2.isEmpty())) break;
                    int n12 = zzid$zzd.number;
                    object = (List)object.getValue();
                    zzkb zzkb2 = zzkb.zzik();
                    object2 = object2.get(0).getClass();
                    object2 = zzkb2.zzf((Class)object2);
                    zzkh.zza(n12, (List)object, zzlq2, (zzkf)object2);
                    break;
                }
                case 17: {
                    boolean bl3;
                    object2 = (List)object.getValue();
                    if (object2 != null && !(bl3 = object2.isEmpty())) {
                        int n13 = zzid$zzd.number;
                        object = (List)object.getValue();
                        zzkb zzkb3 = zzkb.zzik();
                        object2 = object2.get(0).getClass();
                        object2 = zzkb3.zzf((Class)object2);
                        zzkh.zzb(n13, (List)object, zzlq2, (zzkf)object2);
                    }
                    return;
                }
                case 16: {
                    int n14 = zzid$zzd.number;
                    object = (List)object.getValue();
                    zzkh.zza(n14, object, zzlq2);
                    return;
                }
                case 15: {
                    int n15 = zzid$zzd.number;
                    object = (List)object.getValue();
                    zzkh.zzb(n15, object, zzlq2);
                    return;
                }
                case 14: {
                    int n16 = zzid$zzd.number;
                    object = (List)object.getValue();
                    zzkh.zzh(n16, object, zzlq2, false);
                    return;
                }
                case 13: {
                    int n17 = zzid$zzd.number;
                    object = (List)object.getValue();
                    zzkh.zze(n17, object, zzlq2, false);
                    return;
                }
                case 12: {
                    int n18 = zzid$zzd.number;
                    object = (List)object.getValue();
                    zzkh.zzj(n18, object, zzlq2, false);
                    return;
                }
                case 11: {
                    int n19 = zzid$zzd.number;
                    object = (List)object.getValue();
                    zzkh.zzg(n19, object, zzlq2, false);
                    return;
                }
                case 10: {
                    int n20 = zzid$zzd.number;
                    object = (List)object.getValue();
                    zzkh.zzl(n20, object, zzlq2, false);
                    return;
                }
                case 9: {
                    int n21 = zzid$zzd.number;
                    object = (List)object.getValue();
                    zzkh.zzi(n21, object, zzlq2, false);
                    return;
                }
                case 8: {
                    int n22 = zzid$zzd.number;
                    object = (List)object.getValue();
                    zzkh.zzn(n22, object, zzlq2, false);
                    return;
                }
                case 7: {
                    int n23 = zzid$zzd.number;
                    object = (List)object.getValue();
                    zzkh.zzk(n23, object, zzlq2, false);
                    return;
                }
                case 6: {
                    int n24 = zzid$zzd.number;
                    object = (List)object.getValue();
                    zzkh.zzf(n24, object, zzlq2, false);
                    return;
                }
                case 5: {
                    int n25 = zzid$zzd.number;
                    object = (List)object.getValue();
                    zzkh.zzh(n25, object, zzlq2, false);
                    return;
                }
                case 4: {
                    int n26 = zzid$zzd.number;
                    object = (List)object.getValue();
                    zzkh.zzd(n26, object, zzlq2, false);
                    return;
                }
                case 3: {
                    int n27 = zzid$zzd.number;
                    object = (List)object.getValue();
                    zzkh.zzc(n27, object, zzlq2, false);
                    return;
                }
                case 2: {
                    int n28 = zzid$zzd.number;
                    object = (List)object.getValue();
                    zzkh.zzb(n28, object, zzlq2, false);
                    return;
                }
                case 1: {
                    int n29 = zzid$zzd.number;
                    object = (List)object.getValue();
                    zzkh.zza(n29, object, zzlq2, false);
                }
            }
            return;
        }
        Object object3 = zzhr.zztn;
        Object object4 = zzid$zzd.zzyd;
        int n30 = ((Enum)object4).ordinal();
        n10 = object3[n30];
        switch (n10) {
            default: {
                break;
            }
            case 18: {
                int n31 = zzid$zzd.number;
                object3 = object.getValue();
                object4 = zzkb.zzik();
                object = object.getValue().getClass();
                object = ((zzkb)object4).zzf((Class)object);
                zzlq2.zza(n31, object3, (zzkf)object);
                break;
            }
            case 17: {
                int n32 = zzid$zzd.number;
                object3 = object.getValue();
                object4 = zzkb.zzik();
                object = object.getValue().getClass();
                object = ((zzkb)object4).zzf((Class)object);
                zzlq2.zzb(n32, object3, (zzkf)object);
                return;
            }
            case 16: {
                int n33 = zzid$zzd.number;
                object = (String)object.getValue();
                zzlq2.zza(n33, (String)object);
                return;
            }
            case 15: {
                int n34 = zzid$zzd.number;
                object = (zzgs)object.getValue();
                zzlq2.zza(n34, (zzgs)object);
                return;
            }
            case 14: {
                int n35 = zzid$zzd.number;
                int n36 = (Integer)object.getValue();
                zzlq2.zzj(n35, n36);
                return;
            }
            case 13: {
                int n37 = zzid$zzd.number;
                long l10 = (Long)object.getValue();
                zzlq2.zzb(n37, l10);
                return;
            }
            case 12: {
                int n38 = zzid$zzd.number;
                int n39 = (Integer)object.getValue();
                zzlq2.zzl(n38, n39);
                return;
            }
            case 11: {
                int n40 = zzid$zzd.number;
                long l11 = (Long)object.getValue();
                zzlq2.zzj(n40, l11);
                return;
            }
            case 10: {
                int n41 = zzid$zzd.number;
                int n42 = (Integer)object.getValue();
                zzlq2.zzt(n41, n42);
                return;
            }
            case 9: {
                int n43 = zzid$zzd.number;
                int n44 = (Integer)object.getValue();
                zzlq2.zzk(n43, n44);
                return;
            }
            case 8: {
                int n45 = zzid$zzd.number;
                boolean bl4 = (Boolean)object.getValue();
                zzlq2.zza(n45, bl4);
                return;
            }
            case 7: {
                int n46 = zzid$zzd.number;
                int n47 = (Integer)object.getValue();
                zzlq2.zzm(n46, n47);
                return;
            }
            case 6: {
                int n48 = zzid$zzd.number;
                long l12 = (Long)object.getValue();
                zzlq2.zzc(n48, l12);
                return;
            }
            case 5: {
                int n49 = zzid$zzd.number;
                int n50 = (Integer)object.getValue();
                zzlq2.zzj(n49, n50);
                return;
            }
            case 4: {
                int n51 = zzid$zzd.number;
                long l13 = (Long)object.getValue();
                zzlq2.zza(n51, l13);
                return;
            }
            case 3: {
                int n52 = zzid$zzd.number;
                long l14 = (Long)object.getValue();
                zzlq2.zzi(n52, l14);
                return;
            }
            case 2: {
                int n53 = zzid$zzd.number;
                float f10 = ((Float)object.getValue()).floatValue();
                zzlq2.zza(n53, f10);
                return;
            }
            case 1: {
                int n54 = zzid$zzd.number;
                object = (Double)object.getValue();
                double d10 = (Double)object;
                zzlq2.zza(n54, d10);
            }
        }
    }

    public final boolean zze(zzjn zzjn2) {
        return zzjn2 instanceof zzid$zze;
    }

    public final zzht zzh(Object object) {
        return ((zzid$zze)object).zzyg;
    }

    public final zzht zzi(Object object) {
        return ((zzid$zze)object).zzhe();
    }

    public final void zzj(Object object) {
        ((zzhq)this).zzh(object).zzej();
    }
}

