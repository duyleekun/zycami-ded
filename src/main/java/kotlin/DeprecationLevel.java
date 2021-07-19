/*
 * Decompiled with CFR 0.151.
 */
package kotlin;

public final class DeprecationLevel
extends Enum {
    public static final /* enum */ DeprecationLevel ERROR;
    public static final /* enum */ DeprecationLevel HIDDEN;
    public static final /* enum */ DeprecationLevel WARNING;
    private static final /* synthetic */ DeprecationLevel[] a;

    static {
        DeprecationLevel deprecationLevel;
        DeprecationLevel[] deprecationLevelArray = new DeprecationLevel[3];
        WARNING = deprecationLevel = new DeprecationLevel("WARNING", 0);
        deprecationLevelArray[0] = deprecationLevel;
        int n10 = 1;
        ERROR = deprecationLevel = new DeprecationLevel("ERROR", n10);
        deprecationLevelArray[n10] = deprecationLevel;
        n10 = 2;
        HIDDEN = deprecationLevel = new DeprecationLevel("HIDDEN", n10);
        deprecationLevelArray[n10] = deprecationLevel;
        a = deprecationLevelArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private DeprecationLevel() {
        void var2_-1;
        void var1_-1;
    }

    public static DeprecationLevel valueOf(String string2) {
        return Enum.valueOf(DeprecationLevel.class, string2);
    }

    public static DeprecationLevel[] values() {
        return (DeprecationLevel[])a.clone();
    }
}

