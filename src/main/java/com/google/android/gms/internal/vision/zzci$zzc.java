/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzci$zzc$zza;
import com.google.android.gms.internal.vision.zzcj;
import com.google.android.gms.internal.vision.zzho;
import com.google.android.gms.internal.vision.zzid;
import com.google.android.gms.internal.vision.zzid$zzc;
import com.google.android.gms.internal.vision.zzjn;
import com.google.android.gms.internal.vision.zzjp;
import com.google.android.gms.internal.vision.zzjw;
import com.google.android.gms.internal.vision.zzma;

public final class zzci$zzc
extends zzid
implements zzjp {
    private static volatile zzjw zzbk;
    private static final zzci$zzc zzko;
    private int zzbm;
    private zzma zzkm;
    private byte zzkn = (byte)2;

    static {
        zzci$zzc zzci$zzc;
        zzko = zzci$zzc = new zzci$zzc();
        zzid.zza(zzci$zzc.class, zzci$zzc);
    }

    private zzci$zzc() {
    }

    public static zzci$zzc zza(byte[] byArray, zzho zzho2) {
        return (zzci$zzc)zzid.zza(zzko, byArray, zzho2);
    }

    public static /* synthetic */ zzci$zzc zzbq() {
        return zzko;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        object2 = zzcj.zzbl;
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
                clazz = zzci$zzc.class;
                synchronized (clazz) {
                    object3 = zzbk;
                    if (object3 != null) return object3;
                    object2 = zzko;
                    zzbk = object3 = new zzid$zzc((zzid)object2);
                    return object3;
                }
            }
            case 4: {
                return zzko;
            }
            case 3: {
                Object[] objectArray = new Object[2];
                objectArray[0] = "zzbm";
                objectArray[n10] = "zzkm";
                return zzid.zza((zzjn)zzko, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0001\u1409\u0000", objectArray);
            }
            case 2: {
                return new zzci$zzc$zza(null);
            }
            case 1: 
        }
        return new zzci$zzc();
    }

    public final zzma zzbp() {
        zzma zzma2 = this.zzkm;
        if (zzma2 == null) {
            zzma2 = zzma.zzkh();
        }
        return zzma2;
    }
}

