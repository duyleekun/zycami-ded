/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzq;

public final class zze {
    public static final /* synthetic */ int[] zza;

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        int[] nArray;
        block10: {
            int n12;
            block9: {
                int n13 = zzq.zza().length;
                nArray = new int[n13];
                zza = nArray;
                n11 = 1;
                try {
                    n10 = zzq.zza - n11;
                }
                catch (NoSuchFieldError noSuchFieldError) {
                    break block9;
                }
                {
                    nArray[n10] = n11;
                }
            }
            try {
                nArray = zza;
                n10 = zzq.zzb - n11;
                n12 = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                break block10;
            }
            {
                nArray[n10] = n12;
            }
        }
        try {
            nArray = zza;
            n10 = zzq.zzc - n11;
            n11 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
        {
            nArray[n10] = n11;
            return;
        }
    }
}

