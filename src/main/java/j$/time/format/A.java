/*
 * Decompiled with CFR 0.151.
 */
package j$.time.format;

public final class A
extends Enum {
    public static final /* enum */ A a;
    public static final /* enum */ A b;
    private static final /* synthetic */ A[] c;

    static {
        A a10;
        A a11;
        a = a11 = new A("STRICT", 0);
        int n10 = 1;
        b = a10 = new A("SMART", n10);
        int n11 = 2;
        A a12 = new A("LENIENT", n11);
        A[] aArray = new A[3];
        aArray[0] = a11;
        aArray[n10] = a10;
        aArray[n11] = a12;
        c = aArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private A() {
        void var2_-1;
        void var1_-1;
    }

    public static A valueOf(String string2) {
        return Enum.valueOf(A.class, string2);
    }

    public static A[] values() {
        return (A[])c.clone();
    }
}

