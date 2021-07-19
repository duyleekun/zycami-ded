/*
 * Decompiled with CFR 0.151.
 */
package kotlin.internal;

public final class RequireKotlinVersionKind
extends Enum {
    public static final /* enum */ RequireKotlinVersionKind API_VERSION;
    public static final /* enum */ RequireKotlinVersionKind COMPILER_VERSION;
    public static final /* enum */ RequireKotlinVersionKind LANGUAGE_VERSION;
    private static final /* synthetic */ RequireKotlinVersionKind[] a;

    static {
        RequireKotlinVersionKind requireKotlinVersionKind;
        RequireKotlinVersionKind[] requireKotlinVersionKindArray = new RequireKotlinVersionKind[3];
        LANGUAGE_VERSION = requireKotlinVersionKind = new RequireKotlinVersionKind("LANGUAGE_VERSION", 0);
        requireKotlinVersionKindArray[0] = requireKotlinVersionKind;
        int n10 = 1;
        COMPILER_VERSION = requireKotlinVersionKind = new RequireKotlinVersionKind("COMPILER_VERSION", n10);
        requireKotlinVersionKindArray[n10] = requireKotlinVersionKind;
        n10 = 2;
        API_VERSION = requireKotlinVersionKind = new RequireKotlinVersionKind("API_VERSION", n10);
        requireKotlinVersionKindArray[n10] = requireKotlinVersionKind;
        a = requireKotlinVersionKindArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private RequireKotlinVersionKind() {
        void var2_-1;
        void var1_-1;
    }

    public static RequireKotlinVersionKind valueOf(String string2) {
        return Enum.valueOf(RequireKotlinVersionKind.class, string2);
    }

    public static RequireKotlinVersionKind[] values() {
        return (RequireKotlinVersionKind[])a.clone();
    }
}

