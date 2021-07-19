/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzci$zzg$zza;
import com.google.android.gms.internal.vision.zzcj;
import com.google.android.gms.internal.vision.zzgs;
import com.google.android.gms.internal.vision.zzid;
import com.google.android.gms.internal.vision.zzid$zzc;
import com.google.android.gms.internal.vision.zzjn;
import com.google.android.gms.internal.vision.zzjp;
import com.google.android.gms.internal.vision.zzjw;

public final class zzci$zzg
extends zzid
implements zzjp {
    private static volatile zzjw zzbk;
    private static final zzci$zzg zzlx;
    private int zzbm;
    private zzgs zzlv;
    private String zzlw;

    static {
        zzci$zzg zzci$zzg;
        zzlx = zzci$zzg = new zzci$zzg();
        zzid.zza(zzci$zzg.class, zzci$zzg);
    }

    private zzci$zzg() {
        zzgs zzgs2;
        this.zzlv = zzgs2 = zzgs.zztt;
        this.zzlw = "";
    }

    public static /* synthetic */ void zza(zzci$zzg zzci$zzg, String string2) {
        zzci$zzg.zzj(string2);
    }

    public static zzci$zzg$zza zzbz() {
        return (zzci$zzg$zza)zzlx.zzgy();
    }

    public static /* synthetic */ zzci$zzg zzca() {
        return zzlx;
    }

    private final void zzj(String string2) {
        int n10;
        string2.getClass();
        this.zzbm = n10 = this.zzbm | 2;
        this.zzlw = string2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzci$zzg>)zzcj.zzbl;
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
                clazz = zzci$zzg.class;
                synchronized (clazz) {
                    object3 = zzbk;
                    if (object3 != null) return object3;
                    object2 = zzlx;
                    zzbk = object3 = new zzid$zzc((zzid)object2);
                    return object3;
                }
            }
            case 4: {
                return zzlx;
            }
            case 3: {
                Object[] objectArray = new Object[3];
                objectArray[0] = "zzbm";
                objectArray[by2] = "zzlv";
                objectArray[2] = "zzlw";
                return zzid.zza((zzjn)zzlx, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u100a\u0000\u0002\u1008\u0001", objectArray);
            }
            case 2: {
                return new zzci$zzg$zza(null);
            }
            case 1: 
        }
        return new zzci$zzg();
    }
}

