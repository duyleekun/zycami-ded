/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzae$zza;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzae$zzb;
import com.google.android.gms.internal.mlkit_vision_face.zzbo;
import com.google.android.gms.internal.mlkit_vision_face.zzgd;
import com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc;
import com.google.android.gms.internal.mlkit_vision_face.zzhn;
import com.google.android.gms.internal.mlkit_vision_face.zzhv;

public final class zzbm$zzae
extends zzgd
implements zzhn {
    private static final zzbm$zzae zzg;
    private static volatile zzhv zzh;
    private int zzc;
    private int zzd;
    private int zze;
    private int zzf;

    static {
        zzbm$zzae zzbm$zzae;
        zzg = zzbm$zzae = new zzbm$zzae();
        zzgd.zza(zzbm$zzae.class, zzbm$zzae);
    }

    private zzbm$zzae() {
    }

    public static zzbm$zzae$zzb zza() {
        return (zzbm$zzae$zzb)zzg.zzh();
    }

    private final void zza(zzbm$zzae$zza zzbm$zzae$zza) {
        int n10;
        this.zzd = n10 = zzbm$zzae$zza.zza();
        this.zzc = n10 = this.zzc | 1;
    }

    public static /* synthetic */ void zza(zzbm$zzae zzbm$zzae, int n10) {
        zzbm$zzae.zzb(n10);
    }

    public static /* synthetic */ void zza(zzbm$zzae zzbm$zzae, zzbm$zzae$zza zzbm$zzae$zza) {
        zzbm$zzae.zza(zzbm$zzae$zza);
    }

    public static /* synthetic */ zzbm$zzae zzb() {
        return zzg;
    }

    private final void zzb(int n10) {
        int n11;
        this.zzc = n11 = this.zzc | 2;
        this.zze = n10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzbm$zzae>)zzbo.zza;
        byte by2 = 1;
        object -= by2;
        object = clazz[object];
        clazz = null;
        switch (object) {
            default: {
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
                throw unsupportedOperationException;
            }
            case 7: {
                return null;
            }
            case 6: {
                return by2;
            }
            case 5: {
                Object object3 = zzh;
                if (object3 != null) return object3;
                clazz = zzbm$zzae.class;
                synchronized (clazz) {
                    object3 = zzh;
                    if (object3 != null) return object3;
                    object2 = zzg;
                    zzh = object3 = new zzgd$zzc((zzgd)object2);
                    return object3;
                }
            }
            case 4: {
                return zzg;
            }
            case 3: {
                Object[] objectArray = new Object[5];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = object2 = zzbm$zzae$zza.zzb();
                objectArray[3] = "zze";
                objectArray[4] = "zzf";
                return zzgd.zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u100c\u0000\u0002\u100b\u0001\u0003\u100b\u0002", objectArray);
            }
            case 2: {
                return new zzbm$zzae$zzb(null);
            }
            case 1: 
        }
        return new zzbm$zzae();
    }
}

