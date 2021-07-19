/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzid;
import com.google.android.gms.internal.vision.zzid$zzc;
import com.google.android.gms.internal.vision.zzik;
import com.google.android.gms.internal.vision.zzjn;
import com.google.android.gms.internal.vision.zzjp;
import com.google.android.gms.internal.vision.zzjw;
import com.google.android.gms.internal.vision.zzls;
import com.google.android.gms.internal.vision.zzma$zza;
import com.google.android.gms.internal.vision.zzmc;

public final class zzma
extends zzid
implements zzjp {
    private static final zzma zzaih;
    private static volatile zzjw zzbk;
    private zzik zzaig;
    private byte zzkn = (byte)2;

    static {
        zzma zzma2;
        zzaih = zzma2 = new zzma();
        zzid.zza(zzma.class, zzma2);
    }

    private zzma() {
        zzik zzik2;
        this.zzaig = zzik2 = zzid.zzhb();
    }

    public static zzma zzkh() {
        return zzaih;
    }

    public static /* synthetic */ zzma zzki() {
        return zzaih;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        object2 = zzmc.zzbl;
        int n10 = 1;
        object -= n10;
        object = object2[object];
        object2 = null;
        switch (object) {
            default: {
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
                throw unsupportedOperationException;
            }
            case 7: {
                if (clazz == null) {
                    n10 = 0;
                }
                object = (byte)n10;
                this.zzkn = (byte)object;
                return null;
            }
            case 6: {
                return this.zzkn;
            }
            case 5: {
                Object object3 = zzbk;
                if (object3 != null) return object3;
                clazz = zzma.class;
                synchronized (clazz) {
                    object3 = zzbk;
                    if (object3 != null) return object3;
                    object2 = zzaih;
                    zzbk = object3 = new zzid$zzc((zzid)object2);
                    return object3;
                }
            }
            case 4: {
                return zzaih;
            }
            case 3: {
                Object[] objectArray = new Object[2];
                objectArray[0] = "zzaig";
                objectArray[n10] = zzls.class;
                return zzid.zza((zzjn)zzaih, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u041b", objectArray);
            }
            case 2: {
                return new zzma$zza(null);
            }
            case 1: 
        }
        return new zzma();
    }

    public final zzls zzcj(int n10) {
        return (zzls)this.zzaig.get(n10);
    }

    public final int zzkg() {
        return this.zzaig.size();
    }
}

