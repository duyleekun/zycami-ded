/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcd;
import com.google.android.gms.internal.clearcut.zzcq;

public final class zzcc {
    public static final /* synthetic */ int[] zzje;
    public static final /* synthetic */ int[] zzjf;

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
        int n13 = zzcq.values().length;
        int[] nArray = new int[n13];
        zzjf = nArray;
        int n14 = 1;
        try {
            object3 = zzcq.zzle;
            n12 = object3.ordinal();
            nArray[n12] = n14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n13 = 2;
        try {
            object3 = zzjf;
            object2 = zzcq.zzlg;
            n11 = ((Enum)object2).ordinal();
            object3[n11] = (zzcq)n13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n12 = 3;
        try {
            object2 = zzjf;
            enum_ = zzcq.zzld;
            n10 = enum_.ordinal();
            object2[n10] = (zzcq)n12;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n11 = zzcd.values().length;
        object2 = new int[n11];
        zzje = (int[])object2;
        try {
            enum_ = zzcd.zzjj;
            n10 = enum_.ordinal();
            object2[n10] = (zzcq)n14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object = zzje;
            object2 = zzcd.zzjh;
            n11 = ((Enum)object2).ordinal();
            object[n11] = n13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = zzje;
            object = (Object)zzcd.zzjg;
            n14 = ((Enum)object).ordinal();
            nArray[n14] = n12;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

