/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

public final class ElementOrder$Type
extends Enum {
    private static final /* synthetic */ ElementOrder$Type[] $VALUES;
    public static final /* enum */ ElementOrder$Type INSERTION;
    public static final /* enum */ ElementOrder$Type SORTED;
    public static final /* enum */ ElementOrder$Type STABLE;
    public static final /* enum */ ElementOrder$Type UNORDERED;

    static {
        ElementOrder$Type elementOrder$Type;
        ElementOrder$Type elementOrder$Type2;
        ElementOrder$Type elementOrder$Type3;
        ElementOrder$Type elementOrder$Type4;
        UNORDERED = elementOrder$Type4 = new ElementOrder$Type("UNORDERED", 0);
        int n10 = 1;
        STABLE = elementOrder$Type3 = new ElementOrder$Type("STABLE", n10);
        int n11 = 2;
        INSERTION = elementOrder$Type2 = new ElementOrder$Type("INSERTION", n11);
        int n12 = 3;
        SORTED = elementOrder$Type = new ElementOrder$Type("SORTED", n12);
        ElementOrder$Type[] elementOrder$TypeArray = new ElementOrder$Type[4];
        elementOrder$TypeArray[0] = elementOrder$Type4;
        elementOrder$TypeArray[n10] = elementOrder$Type3;
        elementOrder$TypeArray[n11] = elementOrder$Type2;
        elementOrder$TypeArray[n12] = elementOrder$Type;
        $VALUES = elementOrder$TypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ElementOrder$Type() {
        void var2_-1;
        void var1_-1;
    }

    public static ElementOrder$Type valueOf(String string2) {
        return Enum.valueOf(ElementOrder$Type.class, string2);
    }

    public static ElementOrder$Type[] values() {
        return (ElementOrder$Type[])$VALUES.clone();
    }
}

