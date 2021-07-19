/*
 * Decompiled with CFR 0.151.
 */
package kotlin.contracts;

public final class InvocationKind
extends Enum {
    public static final /* enum */ InvocationKind AT_LEAST_ONCE;
    public static final /* enum */ InvocationKind AT_MOST_ONCE;
    public static final /* enum */ InvocationKind EXACTLY_ONCE;
    public static final /* enum */ InvocationKind UNKNOWN;
    private static final /* synthetic */ InvocationKind[] a;

    static {
        InvocationKind invocationKind;
        InvocationKind[] invocationKindArray = new InvocationKind[4];
        AT_MOST_ONCE = invocationKind = new InvocationKind("AT_MOST_ONCE", 0);
        invocationKindArray[0] = invocationKind;
        int n10 = 1;
        AT_LEAST_ONCE = invocationKind = new InvocationKind("AT_LEAST_ONCE", n10);
        invocationKindArray[n10] = invocationKind;
        n10 = 2;
        EXACTLY_ONCE = invocationKind = new InvocationKind("EXACTLY_ONCE", n10);
        invocationKindArray[n10] = invocationKind;
        n10 = 3;
        UNKNOWN = invocationKind = new InvocationKind("UNKNOWN", n10);
        invocationKindArray[n10] = invocationKind;
        a = invocationKindArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private InvocationKind() {
        void var2_-1;
        void var1_-1;
    }

    public static InvocationKind valueOf(String string2) {
        return Enum.valueOf(InvocationKind.class, string2);
    }

    public static InvocationKind[] values() {
        return (InvocationKind[])a.clone();
    }
}

