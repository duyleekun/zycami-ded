/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzfr;
import com.google.android.gms.internal.vision.zzfs;
import com.google.android.gms.internal.vision.zzig;
import com.google.android.gms.internal.vision.zzih;
import com.google.android.gms.internal.vision.zzij;

public final class zzfl$zzg$zza
extends Enum
implements zzih {
    private static final zzig zzhq;
    private static final /* enum */ zzfl$zzg$zza zzpw;
    public static final /* enum */ zzfl$zzg$zza zzpx;
    public static final /* enum */ zzfl$zzg$zza zzpy;
    private static final /* synthetic */ zzfl$zzg$zza[] zzpz;
    private final int value;

    static {
        zzfl$zzg$zza zzfl$zzg$zza;
        zzfl$zzg$zza zzfl$zzg$zza2;
        Object object = new zzfl$zzg$zza("CLASSIFICATION_UNKNOWN", 0, 0);
        zzpw = object;
        int n10 = 1;
        zzpx = zzfl$zzg$zza2 = new zzfl$zzg$zza("CLASSIFICATION_NONE", n10, n10);
        int n11 = 2;
        zzpy = zzfl$zzg$zza = new zzfl$zzg$zza("CLASSIFICATION_ALL", n11, n11);
        zzfl$zzg$zza[] zzfl$zzg$zzaArray = new zzfl$zzg$zza[3];
        zzfl$zzg$zzaArray[0] = object;
        zzfl$zzg$zzaArray[n10] = zzfl$zzg$zza2;
        zzfl$zzg$zzaArray[n11] = zzfl$zzg$zza;
        zzpz = zzfl$zzg$zzaArray;
        zzhq = object = new zzfs();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzfl$zzg$zza() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
    }

    public static zzfl$zzg$zza[] values() {
        return (zzfl$zzg$zza[])zzpz.clone();
    }

    public static zzfl$zzg$zza zzab(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    return null;
                }
                return zzpy;
            }
            return zzpx;
        }
        return zzpw;
    }

    public static zzij zzal() {
        return zzfr.zzht;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzfl$zzg$zza.class.getName();
        stringBuilder.append(string2);
        stringBuilder.append('@');
        string2 = Integer.toHexString(System.identityHashCode(this));
        stringBuilder.append(string2);
        stringBuilder.append(" number=");
        int n10 = this.value;
        stringBuilder.append(n10);
        stringBuilder.append(" name=");
        string2 = this.name();
        stringBuilder.append(string2);
        stringBuilder.append('>');
        return stringBuilder.toString();
    }

    public final int zzak() {
        return this.value;
    }
}

