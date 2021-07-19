/*
 * Decompiled with CFR 0.151.
 */
package org.java_websocket.enums;

public final class CloseHandshakeType
extends Enum {
    public static final /* enum */ CloseHandshakeType NONE;
    public static final /* enum */ CloseHandshakeType ONEWAY;
    public static final /* enum */ CloseHandshakeType TWOWAY;
    private static final /* synthetic */ CloseHandshakeType[] a;

    static {
        CloseHandshakeType closeHandshakeType;
        CloseHandshakeType closeHandshakeType2;
        CloseHandshakeType closeHandshakeType3;
        NONE = closeHandshakeType3 = new CloseHandshakeType("NONE", 0);
        int n10 = 1;
        ONEWAY = closeHandshakeType2 = new CloseHandshakeType("ONEWAY", n10);
        int n11 = 2;
        TWOWAY = closeHandshakeType = new CloseHandshakeType("TWOWAY", n11);
        CloseHandshakeType[] closeHandshakeTypeArray = new CloseHandshakeType[3];
        closeHandshakeTypeArray[0] = closeHandshakeType3;
        closeHandshakeTypeArray[n10] = closeHandshakeType2;
        closeHandshakeTypeArray[n11] = closeHandshakeType;
        a = closeHandshakeTypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private CloseHandshakeType() {
        void var2_-1;
        void var1_-1;
    }

    public static CloseHandshakeType valueOf(String string2) {
        return Enum.valueOf(CloseHandshakeType.class, string2);
    }

    public static CloseHandshakeType[] values() {
        return (CloseHandshakeType[])a.clone();
    }
}

