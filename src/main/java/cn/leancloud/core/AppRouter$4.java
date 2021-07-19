/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.core;

import cn.leancloud.core.AVOSCloud$REGION;
import cn.leancloud.core.AVOSService;

public class AppRouter$4 {
    public static final /* synthetic */ int[] $SwitchMap$cn$leancloud$core$AVOSCloud$REGION;
    public static final /* synthetic */ int[] $SwitchMap$cn$leancloud$core$AVOSService;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        Object object;
        int n10;
        int n11;
        Enum enum_;
        int n12;
        Object object2;
        int n13;
        Object object3;
        int n14 = AVOSService.values().length;
        int[] nArray = new int[n14];
        $SwitchMap$cn$leancloud$core$AVOSService = nArray;
        int n15 = 1;
        try {
            object3 = AVOSService.API;
            n13 = object3.ordinal();
            nArray[n13] = n15;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n14 = 2;
        try {
            object3 = $SwitchMap$cn$leancloud$core$AVOSService;
            object2 = AVOSService.ENGINE;
            n12 = ((Enum)object2).ordinal();
            object3[n12] = (AVOSService)n14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n13 = 3;
        try {
            object2 = $SwitchMap$cn$leancloud$core$AVOSService;
            enum_ = AVOSService.PUSH;
            n11 = enum_.ordinal();
            object2[n11] = (AVOSService)n13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object2 = $SwitchMap$cn$leancloud$core$AVOSService;
            enum_ = AVOSService.RTM;
            n11 = enum_.ordinal();
            n10 = 4;
            object2[n11] = (AVOSService)n10;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object2 = $SwitchMap$cn$leancloud$core$AVOSService;
            enum_ = AVOSService.STATS;
            n11 = enum_.ordinal();
            n10 = 5;
            object2[n11] = (AVOSService)n10;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n12 = AVOSCloud$REGION.values().length;
        object2 = new int[n12];
        $SwitchMap$cn$leancloud$core$AVOSCloud$REGION = (int[])object2;
        try {
            enum_ = AVOSCloud$REGION.NorthChina;
            n11 = enum_.ordinal();
            object2[n11] = (AVOSService)n15;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object = $SwitchMap$cn$leancloud$core$AVOSCloud$REGION;
            object2 = AVOSCloud$REGION.EastChina;
            n12 = ((Enum)object2).ordinal();
            object[n12] = n14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$cn$leancloud$core$AVOSCloud$REGION;
            object = (Object)AVOSCloud$REGION.NorthAmerica;
            n15 = ((Enum)object).ordinal();
            nArray[n15] = n13;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

