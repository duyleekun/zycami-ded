/*
 * Decompiled with CFR 0.151.
 */
package androidx.annotation;

public final class RestrictTo$Scope
extends Enum {
    private static final /* synthetic */ RestrictTo$Scope[] $VALUES;
    public static final /* enum */ RestrictTo$Scope GROUP_ID;
    public static final /* enum */ RestrictTo$Scope LIBRARY;
    public static final /* enum */ RestrictTo$Scope LIBRARY_GROUP;
    public static final /* enum */ RestrictTo$Scope LIBRARY_GROUP_PREFIX;
    public static final /* enum */ RestrictTo$Scope SUBCLASSES;
    public static final /* enum */ RestrictTo$Scope TESTS;

    static {
        RestrictTo$Scope restrictTo$Scope;
        RestrictTo$Scope restrictTo$Scope2;
        RestrictTo$Scope restrictTo$Scope3;
        RestrictTo$Scope restrictTo$Scope4;
        RestrictTo$Scope restrictTo$Scope5;
        RestrictTo$Scope restrictTo$Scope6;
        LIBRARY = restrictTo$Scope6 = new RestrictTo$Scope("LIBRARY", 0);
        int n10 = 1;
        LIBRARY_GROUP = restrictTo$Scope5 = new RestrictTo$Scope("LIBRARY_GROUP", n10);
        int n11 = 2;
        LIBRARY_GROUP_PREFIX = restrictTo$Scope4 = new RestrictTo$Scope("LIBRARY_GROUP_PREFIX", n11);
        int n12 = 3;
        GROUP_ID = restrictTo$Scope3 = new RestrictTo$Scope("GROUP_ID", n12);
        int n13 = 4;
        TESTS = restrictTo$Scope2 = new RestrictTo$Scope("TESTS", n13);
        int n14 = 5;
        SUBCLASSES = restrictTo$Scope = new RestrictTo$Scope("SUBCLASSES", n14);
        RestrictTo$Scope[] restrictTo$ScopeArray = new RestrictTo$Scope[6];
        restrictTo$ScopeArray[0] = restrictTo$Scope6;
        restrictTo$ScopeArray[n10] = restrictTo$Scope5;
        restrictTo$ScopeArray[n11] = restrictTo$Scope4;
        restrictTo$ScopeArray[n12] = restrictTo$Scope3;
        restrictTo$ScopeArray[n13] = restrictTo$Scope2;
        restrictTo$ScopeArray[n14] = restrictTo$Scope;
        $VALUES = restrictTo$ScopeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private RestrictTo$Scope() {
        void var2_-1;
        void var1_-1;
    }

    public static RestrictTo$Scope valueOf(String string2) {
        return Enum.valueOf(RestrictTo$Scope.class, string2);
    }

    public static RestrictTo$Scope[] values() {
        return (RestrictTo$Scope[])$VALUES.clone();
    }
}

