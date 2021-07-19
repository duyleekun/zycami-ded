/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzfk;
import com.google.android.gms.internal.vision.zzfl$zza$zza;
import com.google.android.gms.internal.vision.zzid;
import com.google.android.gms.internal.vision.zzid$zzc;
import com.google.android.gms.internal.vision.zzjn;
import com.google.android.gms.internal.vision.zzjp;
import com.google.android.gms.internal.vision.zzjw;

public final class zzfl$zza
extends zzid
implements zzjp {
    private static volatile zzjw zzbk;
    private static final zzfl$zza zzof;
    private int zzbm;
    private String zzod;
    private String zzoe;

    static {
        zzfl$zza zzfl$zza;
        zzof = zzfl$zza = new zzfl$zza();
        zzid.zza(zzfl$zza.class, zzfl$zza);
    }

    private zzfl$zza() {
        String string2;
        this.zzod = string2 = "";
        this.zzoe = string2;
    }

    public static /* synthetic */ void zza(zzfl$zza zzfl$zza, String string2) {
        zzfl$zza.zzo(string2);
    }

    public static /* synthetic */ void zzb(zzfl$zza zzfl$zza, String string2) {
        zzfl$zza.zzp(string2);
    }

    public static zzfl$zza$zza zzdd() {
        return (zzfl$zza$zza)zzof.zzgy();
    }

    public static /* synthetic */ zzfl$zza zzde() {
        return zzof;
    }

    private final void zzo(String string2) {
        int n10;
        string2.getClass();
        this.zzbm = n10 = this.zzbm | 1;
        this.zzod = string2;
    }

    private final void zzp(String string2) {
        int n10;
        string2.getClass();
        this.zzbm = n10 = this.zzbm | 2;
        this.zzoe = string2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzfl$zza>)zzfk.zzbl;
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
                Object object3 = zzbk;
                if (object3 != null) return object3;
                clazz = zzfl$zza.class;
                synchronized (clazz) {
                    object3 = zzbk;
                    if (object3 != null) return object3;
                    object2 = zzof;
                    zzbk = object3 = new zzid$zzc((zzid)object2);
                    return object3;
                }
            }
            case 4: {
                return zzof;
            }
            case 3: {
                Object[] objectArray = new Object[3];
                objectArray[0] = "zzbm";
                objectArray[by2] = "zzod";
                objectArray[2] = "zzoe";
                return zzid.zza((zzjn)zzof, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u1008\u0000\u0002\u1008\u0001", objectArray);
            }
            case 2: {
                return new zzfl$zza$zza(null);
            }
            case 1: 
        }
        return new zzfl$zza();
    }
}

