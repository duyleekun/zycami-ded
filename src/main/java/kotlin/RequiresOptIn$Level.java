/*
 * Decompiled with CFR 0.151.
 */
package kotlin;

public final class RequiresOptIn$Level
extends Enum {
    public static final /* enum */ RequiresOptIn$Level ERROR;
    public static final /* enum */ RequiresOptIn$Level WARNING;
    private static final /* synthetic */ RequiresOptIn$Level[] a;

    static {
        RequiresOptIn$Level requiresOptIn$Level;
        RequiresOptIn$Level[] requiresOptIn$LevelArray = new RequiresOptIn$Level[2];
        WARNING = requiresOptIn$Level = new RequiresOptIn$Level("WARNING", 0);
        requiresOptIn$LevelArray[0] = requiresOptIn$Level;
        int n10 = 1;
        ERROR = requiresOptIn$Level = new RequiresOptIn$Level("ERROR", n10);
        requiresOptIn$LevelArray[n10] = requiresOptIn$Level;
        a = requiresOptIn$LevelArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private RequiresOptIn$Level() {
        void var2_-1;
        void var1_-1;
    }

    public static RequiresOptIn$Level valueOf(String string2) {
        return Enum.valueOf(RequiresOptIn$Level.class, string2);
    }

    public static RequiresOptIn$Level[] values() {
        return (RequiresOptIn$Level[])a.clone();
    }
}

