/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.livequery;

import cn.leancloud.livequery.AVLiveQuery$EventType;

public class AVLiveQueryEventHandler$7 {
    public static final /* synthetic */ int[] $SwitchMap$cn$leancloud$livequery$AVLiveQuery$EventType;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        AVLiveQuery$EventType aVLiveQuery$EventType;
        int n12 = AVLiveQuery$EventType.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$cn$leancloud$livequery$AVLiveQuery$EventType = nArray;
        try {
            aVLiveQuery$EventType = AVLiveQuery$EventType.ENTER;
            n11 = aVLiveQuery$EventType.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$cn$leancloud$livequery$AVLiveQuery$EventType;
            aVLiveQuery$EventType = AVLiveQuery$EventType.UPDATE;
            n11 = aVLiveQuery$EventType.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$cn$leancloud$livequery$AVLiveQuery$EventType;
            aVLiveQuery$EventType = AVLiveQuery$EventType.DELETE;
            n11 = aVLiveQuery$EventType.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$cn$leancloud$livequery$AVLiveQuery$EventType;
            aVLiveQuery$EventType = AVLiveQuery$EventType.LEAVE;
            n11 = aVLiveQuery$EventType.ordinal();
            nArray[n11] = n10 = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$cn$leancloud$livequery$AVLiveQuery$EventType;
            aVLiveQuery$EventType = AVLiveQuery$EventType.LOGIN;
            n11 = aVLiveQuery$EventType.ordinal();
            nArray[n11] = n10 = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$cn$leancloud$livequery$AVLiveQuery$EventType;
            aVLiveQuery$EventType = AVLiveQuery$EventType.CREATE;
            n11 = aVLiveQuery$EventType.ordinal();
            nArray[n11] = n10 = 6;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

