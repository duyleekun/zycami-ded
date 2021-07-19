/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.service;

import cn.leancloud.core.AVOSService;

public class AppAccessEndpoint$1 {
    public static final /* synthetic */ int[] $SwitchMap$cn$leancloud$core$AVOSService;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        AVOSService aVOSService;
        int n12 = AVOSService.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$cn$leancloud$core$AVOSService = nArray;
        try {
            aVOSService = AVOSService.API;
            n11 = aVOSService.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$cn$leancloud$core$AVOSService;
            aVOSService = AVOSService.ENGINE;
            n11 = aVOSService.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$cn$leancloud$core$AVOSService;
            aVOSService = AVOSService.PUSH;
            n11 = aVOSService.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$cn$leancloud$core$AVOSService;
            aVOSService = AVOSService.RTM;
            n11 = aVOSService.ordinal();
            nArray[n11] = n10 = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$cn$leancloud$core$AVOSService;
            aVOSService = AVOSService.STATS;
            n11 = aVOSService.ordinal();
            nArray[n11] = n10 = 5;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

