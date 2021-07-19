/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzia;
import com.google.android.gms.internal.vision.zzip;

public final class zzhx {
    public static final /* synthetic */ int[] zzve;
    public static final /* synthetic */ int[] zzvf;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        Object object;
        int n10;
        Enum enum_;
        int n11;
        Object object2;
        int n12;
        Object object3;
        int n13 = zzip.values().length;
        int[] nArray = new int[n13];
        zzvf = nArray;
        int n14 = 1;
        try {
            object3 = zzip.zzzf;
            n12 = object3.ordinal();
            nArray[n12] = n14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n13 = 2;
        try {
            object3 = zzvf;
            object2 = zzip.zzzh;
            n11 = ((Enum)object2).ordinal();
            object3[n11] = (zzip)n13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n12 = 3;
        try {
            object2 = zzvf;
            enum_ = zzip.zzze;
            n10 = enum_.ordinal();
            object2[n10] = (zzip)n12;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n11 = zzia.values().length;
        object2 = new int[n11];
        zzve = (int[])object2;
        try {
            enum_ = zzia.zzxr;
            n10 = enum_.ordinal();
            object2[n10] = (zzip)n14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object = zzve;
            object2 = zzia.zzxp;
            n11 = ((Enum)object2).ordinal();
            object[n11] = n13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = zzve;
            object = (Object)zzia.zzxo;
            n14 = ((Enum)object).ordinal();
            nArray[n14] = n12;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

