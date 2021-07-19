/*
 * Decompiled with CFR 0.151.
 */
package org.java_websocket.enums;

public final class Opcode
extends Enum {
    public static final /* enum */ Opcode BINARY;
    public static final /* enum */ Opcode CLOSING;
    public static final /* enum */ Opcode CONTINUOUS;
    public static final /* enum */ Opcode PING;
    public static final /* enum */ Opcode PONG;
    public static final /* enum */ Opcode TEXT;
    private static final /* synthetic */ Opcode[] a;

    static {
        Opcode opcode;
        Opcode opcode2;
        Opcode opcode3;
        Opcode opcode4;
        Opcode opcode5;
        Opcode opcode6;
        CONTINUOUS = opcode6 = new Opcode("CONTINUOUS", 0);
        int n10 = 1;
        TEXT = opcode5 = new Opcode("TEXT", n10);
        int n11 = 2;
        BINARY = opcode4 = new Opcode("BINARY", n11);
        int n12 = 3;
        PING = opcode3 = new Opcode("PING", n12);
        int n13 = 4;
        PONG = opcode2 = new Opcode("PONG", n13);
        int n14 = 5;
        CLOSING = opcode = new Opcode("CLOSING", n14);
        Opcode[] opcodeArray = new Opcode[6];
        opcodeArray[0] = opcode6;
        opcodeArray[n10] = opcode5;
        opcodeArray[n11] = opcode4;
        opcodeArray[n12] = opcode3;
        opcodeArray[n13] = opcode2;
        opcodeArray[n14] = opcode;
        a = opcodeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private Opcode() {
        void var2_-1;
        void var1_-1;
    }

    public static Opcode valueOf(String string2) {
        return Enum.valueOf(Opcode.class, string2);
    }

    public static Opcode[] values() {
        return (Opcode[])a.clone();
    }
}

