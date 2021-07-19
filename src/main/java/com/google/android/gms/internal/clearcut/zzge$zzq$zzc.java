/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcj;
import com.google.android.gms.internal.clearcut.zzck;
import com.google.android.gms.internal.clearcut.zzgn;

public final class zzge$zzq$zzc
extends Enum
implements zzcj {
    private static final /* enum */ zzge$zzq$zzc zzbes;
    private static final /* enum */ zzge$zzq$zzc zzbet;
    private static final /* enum */ zzge$zzq$zzc zzbeu;
    private static final /* enum */ zzge$zzq$zzc zzbev;
    private static final /* enum */ zzge$zzq$zzc zzbew;
    private static final /* enum */ zzge$zzq$zzc zzbex;
    private static final /* synthetic */ zzge$zzq$zzc[] zzbey;
    private static final zzck zzbq;
    private final int value;

    static {
        zzge$zzq$zzc zzge$zzq$zzc;
        zzge$zzq$zzc zzge$zzq$zzc2;
        zzge$zzq$zzc zzge$zzq$zzc3;
        zzge$zzq$zzc zzge$zzq$zzc4;
        zzge$zzq$zzc zzge$zzq$zzc5;
        Object object = new zzge$zzq$zzc("UNKNOWN_SCHEDULER", 0, 0);
        zzbes = object;
        int n10 = 1;
        zzbet = zzge$zzq$zzc5 = new zzge$zzq$zzc("ASAP", n10, n10);
        int n11 = 2;
        zzbeu = zzge$zzq$zzc4 = new zzge$zzq$zzc("DEFAULT_PERIODIC", n11, n11);
        int n12 = 3;
        zzbev = zzge$zzq$zzc3 = new zzge$zzq$zzc("QOS_FAST_ONEOFF", n12, n12);
        int n13 = 4;
        zzbew = zzge$zzq$zzc2 = new zzge$zzq$zzc("QOS_DEFAULT_PERIODIC", n13, n13);
        int n14 = 5;
        zzbex = zzge$zzq$zzc = new zzge$zzq$zzc("QOS_UNMETERED_PERIODIC", n14, n14);
        zzge$zzq$zzc[] zzge$zzq$zzcArray = new zzge$zzq$zzc[6];
        zzge$zzq$zzcArray[0] = object;
        zzge$zzq$zzcArray[n10] = zzge$zzq$zzc5;
        zzge$zzq$zzcArray[n11] = zzge$zzq$zzc4;
        zzge$zzq$zzcArray[n12] = zzge$zzq$zzc3;
        zzge$zzq$zzcArray[n13] = zzge$zzq$zzc2;
        zzge$zzq$zzcArray[n14] = zzge$zzq$zzc;
        zzbey = zzge$zzq$zzcArray;
        zzbq = object = new zzgn();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzge$zzq$zzc() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
    }

    public static zzge$zzq$zzc[] values() {
        return (zzge$zzq$zzc[])zzbey.clone();
    }

    public static zzge$zzq$zzc zzay(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    n11 = 3;
                    if (n10 != n11) {
                        n11 = 4;
                        if (n10 != n11) {
                            n11 = 5;
                            if (n10 != n11) {
                                return null;
                            }
                            return zzbex;
                        }
                        return zzbew;
                    }
                    return zzbev;
                }
                return zzbeu;
            }
            return zzbet;
        }
        return zzbes;
    }

    public static zzck zzd() {
        return zzbq;
    }

    public final int zzc() {
        return this.value;
    }
}

