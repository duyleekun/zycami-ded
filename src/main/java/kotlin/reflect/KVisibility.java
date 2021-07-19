/*
 * Decompiled with CFR 0.151.
 */
package kotlin.reflect;

public final class KVisibility
extends Enum {
    public static final /* enum */ KVisibility INTERNAL;
    public static final /* enum */ KVisibility PRIVATE;
    public static final /* enum */ KVisibility PROTECTED;
    public static final /* enum */ KVisibility PUBLIC;
    private static final /* synthetic */ KVisibility[] a;

    static {
        KVisibility kVisibility;
        KVisibility[] kVisibilityArray = new KVisibility[4];
        PUBLIC = kVisibility = new KVisibility("PUBLIC", 0);
        kVisibilityArray[0] = kVisibility;
        int n10 = 1;
        PROTECTED = kVisibility = new KVisibility("PROTECTED", n10);
        kVisibilityArray[n10] = kVisibility;
        n10 = 2;
        INTERNAL = kVisibility = new KVisibility("INTERNAL", n10);
        kVisibilityArray[n10] = kVisibility;
        n10 = 3;
        PRIVATE = kVisibility = new KVisibility("PRIVATE", n10);
        kVisibilityArray[n10] = kVisibility;
        a = kVisibilityArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private KVisibility() {
        void var2_-1;
        void var1_-1;
    }

    public static KVisibility valueOf(String string2) {
        return Enum.valueOf(KVisibility.class, string2);
    }

    public static KVisibility[] values() {
        return (KVisibility[])a.clone();
    }
}

