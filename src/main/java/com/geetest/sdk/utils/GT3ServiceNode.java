/*
 * Decompiled with CFR 0.151.
 */
package com.geetest.sdk.utils;

public final class GT3ServiceNode
extends Enum {
    private static final /* synthetic */ GT3ServiceNode[] $VALUES;
    public static final /* enum */ GT3ServiceNode NODE_CHINA;
    public static final /* enum */ GT3ServiceNode NODE_IPV6;
    public static final /* enum */ GT3ServiceNode NODE_NORTH_AMERICA;
    public static final /* enum */ GT3ServiceNode NODE_NORTH_GOOGLE;

    static {
        GT3ServiceNode gT3ServiceNode;
        GT3ServiceNode gT3ServiceNode2;
        GT3ServiceNode gT3ServiceNode3;
        GT3ServiceNode gT3ServiceNode4;
        NODE_CHINA = gT3ServiceNode4 = new GT3ServiceNode("NODE_CHINA", 0);
        int n10 = 1;
        NODE_NORTH_AMERICA = gT3ServiceNode3 = new GT3ServiceNode("NODE_NORTH_AMERICA", n10);
        int n11 = 2;
        NODE_NORTH_GOOGLE = gT3ServiceNode2 = new GT3ServiceNode("NODE_NORTH_GOOGLE", n11);
        int n12 = 3;
        NODE_IPV6 = gT3ServiceNode = new GT3ServiceNode("NODE_IPV6", n12);
        GT3ServiceNode[] gT3ServiceNodeArray = new GT3ServiceNode[4];
        gT3ServiceNodeArray[0] = gT3ServiceNode4;
        gT3ServiceNodeArray[n10] = gT3ServiceNode3;
        gT3ServiceNodeArray[n11] = gT3ServiceNode2;
        gT3ServiceNodeArray[n12] = gT3ServiceNode;
        $VALUES = gT3ServiceNodeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private GT3ServiceNode() {
        void var2_-1;
        void var1_-1;
    }

    public static GT3ServiceNode valueOf(String string2) {
        return Enum.valueOf(GT3ServiceNode.class, string2);
    }

    public static GT3ServiceNode[] values() {
        return (GT3ServiceNode[])$VALUES.clone();
    }
}

