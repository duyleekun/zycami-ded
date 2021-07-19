/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzfk;
import com.google.android.gms.internal.vision.zzfl$zzd$zza;
import com.google.android.gms.internal.vision.zzfl$zzm;
import com.google.android.gms.internal.vision.zzid;
import com.google.android.gms.internal.vision.zzid$zzc;
import com.google.android.gms.internal.vision.zzik;
import com.google.android.gms.internal.vision.zzjn;
import com.google.android.gms.internal.vision.zzjp;
import com.google.android.gms.internal.vision.zzjw;

public final class zzfl$zzd
extends zzid
implements zzjp {
    private static volatile zzjw zzbk;
    private static final zzfl$zzd zzoo;
    private zzik zzon;

    static {
        zzfl$zzd zzfl$zzd;
        zzoo = zzfl$zzd = new zzfl$zzd();
        zzid.zza(zzfl$zzd.class, zzfl$zzd);
    }

    private zzfl$zzd() {
        zzik zzik2;
        this.zzon = zzik2 = zzid.zzhb();
    }

    public static /* synthetic */ void zza(zzfl$zzd zzfl$zzd, zzfl$zzm zzfl$zzm) {
        zzfl$zzd.zza(zzfl$zzm);
    }

    private final void zza(zzfl$zzm zzfl$zzm) {
        zzfl$zzm.getClass();
        zzik zzik2 = this.zzon;
        boolean bl2 = zzik2.zzei();
        if (!bl2) {
            this.zzon = zzik2 = zzid.zza(zzik2);
        }
        this.zzon.add(zzfl$zzm);
    }

    public static zzfl$zzd$zza zzdh() {
        return (zzfl$zzd$zza)zzoo.zzgy();
    }

    public static /* synthetic */ zzfl$zzd zzdi() {
        return zzoo;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzfl$zzd>)zzfk.zzbl;
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
                clazz = zzfl$zzd.class;
                synchronized (clazz) {
                    object3 = zzbk;
                    if (object3 != null) return object3;
                    object2 = zzoo;
                    zzbk = object3 = new zzid$zzc((zzid)object2);
                    return object3;
                }
            }
            case 4: {
                return zzoo;
            }
            case 3: {
                Object[] objectArray = new Object[2];
                objectArray[0] = "zzon";
                objectArray[by2] = zzfl$zzm.class;
                return zzid.zza((zzjn)zzoo, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", objectArray);
            }
            case 2: {
                return new zzfl$zzd$zza(null);
            }
            case 1: 
        }
        return new zzfl$zzd();
    }
}

