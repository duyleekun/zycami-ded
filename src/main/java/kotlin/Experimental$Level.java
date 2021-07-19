/*
 * Decompiled with CFR 0.151.
 */
package kotlin;

public final class Experimental$Level
extends Enum {
    public static final /* enum */ Experimental$Level ERROR;
    public static final /* enum */ Experimental$Level WARNING;
    private static final /* synthetic */ Experimental$Level[] a;

    static {
        Experimental$Level experimental$Level;
        Experimental$Level[] experimental$LevelArray = new Experimental$Level[2];
        WARNING = experimental$Level = new Experimental$Level("WARNING", 0);
        experimental$LevelArray[0] = experimental$Level;
        int n10 = 1;
        ERROR = experimental$Level = new Experimental$Level("ERROR", n10);
        experimental$LevelArray[n10] = experimental$Level;
        a = experimental$LevelArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private Experimental$Level() {
        void var2_-1;
        void var1_-1;
    }

    public static Experimental$Level valueOf(String string2) {
        return Enum.valueOf(Experimental$Level.class, string2);
    }

    public static Experimental$Level[] values() {
        return (Experimental$Level[])a.clone();
    }
}

