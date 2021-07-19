/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

public final class AVLogger$Level
extends Enum {
    private static final /* synthetic */ AVLogger$Level[] $VALUES;
    public static final /* enum */ AVLogger$Level ALL;
    public static final /* enum */ AVLogger$Level DEBUG;
    public static final /* enum */ AVLogger$Level ERROR;
    public static final /* enum */ AVLogger$Level INFO;
    public static final /* enum */ AVLogger$Level OFF;
    public static final /* enum */ AVLogger$Level VERBOSE;
    public static final /* enum */ AVLogger$Level WARNING;
    private int intLevel;

    static {
        AVLogger$Level aVLogger$Level;
        AVLogger$Level aVLogger$Level2;
        AVLogger$Level aVLogger$Level3;
        AVLogger$Level aVLogger$Level4;
        AVLogger$Level aVLogger$Level5;
        AVLogger$Level aVLogger$Level6;
        AVLogger$Level aVLogger$Level7;
        OFF = aVLogger$Level7 = new AVLogger$Level("OFF", 0, 0);
        int n10 = 1;
        ERROR = aVLogger$Level6 = new AVLogger$Level("ERROR", n10, n10);
        int n11 = 2;
        WARNING = aVLogger$Level5 = new AVLogger$Level("WARNING", n11, n11);
        int n12 = 3;
        INFO = aVLogger$Level4 = new AVLogger$Level("INFO", n12, n12);
        int n13 = 4;
        DEBUG = aVLogger$Level3 = new AVLogger$Level("DEBUG", n13, n13);
        int n14 = 5;
        VERBOSE = aVLogger$Level2 = new AVLogger$Level("VERBOSE", n14, n14);
        int n15 = 6;
        ALL = aVLogger$Level = new AVLogger$Level("ALL", n15, n15);
        AVLogger$Level[] aVLogger$LevelArray = new AVLogger$Level[7];
        aVLogger$LevelArray[0] = aVLogger$Level7;
        aVLogger$LevelArray[n10] = aVLogger$Level6;
        aVLogger$LevelArray[n11] = aVLogger$Level5;
        aVLogger$LevelArray[n12] = aVLogger$Level4;
        aVLogger$LevelArray[n13] = aVLogger$Level3;
        aVLogger$LevelArray[n14] = aVLogger$Level2;
        aVLogger$LevelArray[n15] = aVLogger$Level;
        $VALUES = aVLogger$LevelArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private AVLogger$Level() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.intLevel = var3_1;
    }

    public static AVLogger$Level valueOf(String string2) {
        return Enum.valueOf(AVLogger$Level.class, string2);
    }

    public static AVLogger$Level[] values() {
        return (AVLogger$Level[])$VALUES.clone();
    }

    public int intLevel() {
        return this.intLevel;
    }
}

