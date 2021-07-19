/*
 * Decompiled with CFR 0.151.
 */
package androidx.annotation;

public final class RequiresOptIn$Level
extends Enum {
    private static final /* synthetic */ RequiresOptIn$Level[] $VALUES;
    public static final /* enum */ RequiresOptIn$Level ERROR;
    public static final /* enum */ RequiresOptIn$Level WARNING;

    static {
        RequiresOptIn$Level requiresOptIn$Level;
        RequiresOptIn$Level[] requiresOptIn$LevelArray = new RequiresOptIn$Level[2];
        WARNING = requiresOptIn$Level = new RequiresOptIn$Level("WARNING", 0);
        requiresOptIn$LevelArray[0] = requiresOptIn$Level;
        int n10 = 1;
        ERROR = requiresOptIn$Level = new RequiresOptIn$Level("ERROR", n10);
        requiresOptIn$LevelArray[n10] = requiresOptIn$Level;
        $VALUES = requiresOptIn$LevelArray;
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
        return (RequiresOptIn$Level[])$VALUES.clone();
    }
}

