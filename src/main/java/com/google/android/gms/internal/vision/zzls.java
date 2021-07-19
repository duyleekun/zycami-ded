/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzid;
import com.google.android.gms.internal.vision.zzid$zzc;
import com.google.android.gms.internal.vision.zzid$zze;
import com.google.android.gms.internal.vision.zzik;
import com.google.android.gms.internal.vision.zzjn;
import com.google.android.gms.internal.vision.zzjp;
import com.google.android.gms.internal.vision.zzjw;
import com.google.android.gms.internal.vision.zzls$zza;
import com.google.android.gms.internal.vision.zzls$zzb;
import com.google.android.gms.internal.vision.zzls$zzc;
import com.google.android.gms.internal.vision.zzls$zzd;
import com.google.android.gms.internal.vision.zzls$zze;
import com.google.android.gms.internal.vision.zzlu;
import java.util.List;

public final class zzls
extends zzid$zze
implements zzjp {
    private static final zzls zzaew;
    private static volatile zzjw zzbk;
    private zzls$zzb zzaek;
    private zzik zzael;
    private float zzaem;
    private float zzaen;
    private float zzaeo;
    private float zzaep;
    private zzik zzaeq;
    private zzik zzaer;
    private long zzaes;
    private long zzaet;
    private long zzaeu;
    private float zzaev;
    private int zzbm;
    private byte zzkn = (byte)2;

    static {
        zzls zzls2;
        zzaew = zzls2 = new zzls();
        zzid.zza(zzls.class, zzls2);
    }

    private zzls() {
        zzik zzik2;
        this.zzael = zzik2 = zzid.zzhb();
        this.zzaeq = zzik2 = zzid.zzhb();
        this.zzaer = zzik2 = zzid.zzhb();
    }

    public static zzls zzju() {
        return zzaew;
    }

    public static /* synthetic */ zzls zzjv() {
        return zzaew;
    }

    public final float getConfidence() {
        return this.zzaem;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        object2 = zzlu.zzbl;
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
                clazz = zzls.class;
                synchronized (clazz) {
                    object3 = zzbk;
                    if (object3 != null) return object3;
                    object2 = zzaew;
                    zzbk = object3 = new zzid$zzc((zzid)object2);
                    return object3;
                }
            }
            case 4: {
                return zzaew;
            }
            case 3: {
                Object[] objectArray = new Object[16];
                objectArray[0] = "zzbm";
                objectArray[n10] = "zzaek";
                objectArray[2] = "zzael";
                objectArray[3] = zzls$zze.class;
                objectArray[4] = "zzaem";
                objectArray[5] = "zzaen";
                objectArray[6] = "zzaeo";
                objectArray[7] = "zzaep";
                objectArray[8] = "zzaeq";
                objectArray[9] = zzls$zzc.class;
                objectArray[10] = "zzaer";
                objectArray[11] = zzls$zza.class;
                objectArray[12] = "zzaet";
                objectArray[13] = "zzaev";
                objectArray[14] = "zzaeu";
                objectArray[15] = "zzaes";
                return zzid.zza((zzjn)zzaew, "\u0001\f\u0000\u0001\u0001\f\f\u0000\u0003\u0000\u0001\u1009\u0000\u0002\u001b\u0003\u1001\u0001\u0004\u1001\u0002\u0005\u1001\u0003\u0006\u1001\u0004\u0007\u001b\b\u001b\t\u1003\u0006\n\u1001\b\u000b\u1003\u0007\f\u1003\u0005", objectArray);
            }
            case 2: {
                return new zzls$zzd(null);
            }
            case 1: 
        }
        return new zzls();
    }

    public final zzls$zzb zzjm() {
        zzls$zzb zzls$zzb = this.zzaek;
        if (zzls$zzb == null) {
            zzls$zzb = zzls$zzb.zzkb();
        }
        return zzls$zzb;
    }

    public final List zzjn() {
        return this.zzael;
    }

    public final boolean zzjo() {
        int n10 = this.zzbm & 2;
        return n10 != 0;
    }

    public final float zzjp() {
        return this.zzaen;
    }

    public final float zzjq() {
        return this.zzaeo;
    }

    public final float zzjr() {
        return this.zzaep;
    }

    public final List zzjs() {
        return this.zzaer;
    }

    public final long zzjt() {
        return this.zzaet;
    }
}

