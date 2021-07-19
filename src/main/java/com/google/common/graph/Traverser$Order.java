/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

public final class Traverser$Order
extends Enum {
    private static final /* synthetic */ Traverser$Order[] $VALUES;
    public static final /* enum */ Traverser$Order POSTORDER;
    public static final /* enum */ Traverser$Order PREORDER;

    static {
        Traverser$Order traverser$Order;
        Traverser$Order traverser$Order2;
        PREORDER = traverser$Order2 = new Traverser$Order("PREORDER", 0);
        int n10 = 1;
        POSTORDER = traverser$Order = new Traverser$Order("POSTORDER", n10);
        Traverser$Order[] traverser$OrderArray = new Traverser$Order[2];
        traverser$OrderArray[0] = traverser$Order2;
        traverser$OrderArray[n10] = traverser$Order;
        $VALUES = traverser$OrderArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private Traverser$Order() {
        void var2_-1;
        void var1_-1;
    }

    public static Traverser$Order valueOf(String string2) {
        return Enum.valueOf(Traverser$Order.class, string2);
    }

    public static Traverser$Order[] values() {
        return (Traverser$Order[])$VALUES.clone();
    }
}

