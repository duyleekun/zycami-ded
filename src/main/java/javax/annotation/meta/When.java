/*
 * Decompiled with CFR 0.151.
 */
package javax.annotation.meta;

public final class When
extends Enum {
    public static final /* enum */ When ALWAYS;
    public static final /* enum */ When MAYBE;
    public static final /* enum */ When NEVER;
    public static final /* enum */ When UNKNOWN;
    private static final /* synthetic */ When[] a;

    static {
        When when;
        When when2;
        When when3;
        When when4;
        ALWAYS = when4 = new When("ALWAYS", 0);
        int n10 = 1;
        UNKNOWN = when3 = new When("UNKNOWN", n10);
        int n11 = 2;
        MAYBE = when2 = new When("MAYBE", n11);
        int n12 = 3;
        NEVER = when = new When("NEVER", n12);
        When[] whenArray = new When[4];
        whenArray[0] = when4;
        whenArray[n10] = when3;
        whenArray[n11] = when2;
        whenArray[n12] = when;
        a = whenArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private When() {
        void var2_-1;
        void var1_-1;
    }

    public static When valueOf(String string2) {
        return Enum.valueOf(When.class, string2);
    }

    public static When[] values() {
        return (When[])a.clone();
    }
}

