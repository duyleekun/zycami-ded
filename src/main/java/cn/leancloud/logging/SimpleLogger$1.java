/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.logging;

import cn.leancloud.AVLogger$Level;

public class SimpleLogger$1 {
    public static final /* synthetic */ int[] $SwitchMap$cn$leancloud$AVLogger$Level;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        AVLogger$Level aVLogger$Level;
        int n12 = AVLogger$Level.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$cn$leancloud$AVLogger$Level = nArray;
        try {
            aVLogger$Level = AVLogger$Level.OFF;
            n11 = aVLogger$Level.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$cn$leancloud$AVLogger$Level;
            aVLogger$Level = AVLogger$Level.ERROR;
            n11 = aVLogger$Level.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$cn$leancloud$AVLogger$Level;
            aVLogger$Level = AVLogger$Level.WARNING;
            n11 = aVLogger$Level.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$cn$leancloud$AVLogger$Level;
            aVLogger$Level = AVLogger$Level.INFO;
            n11 = aVLogger$Level.ordinal();
            nArray[n11] = n10 = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$cn$leancloud$AVLogger$Level;
            aVLogger$Level = AVLogger$Level.DEBUG;
            n11 = aVLogger$Level.ordinal();
            nArray[n11] = n10 = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$cn$leancloud$AVLogger$Level;
            aVLogger$Level = AVLogger$Level.VERBOSE;
            n11 = aVLogger$Level.ordinal();
            nArray[n11] = n10 = 6;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

