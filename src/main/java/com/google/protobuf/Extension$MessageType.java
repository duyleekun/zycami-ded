/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

public final class Extension$MessageType
extends Enum {
    private static final /* synthetic */ Extension$MessageType[] $VALUES;
    public static final /* enum */ Extension$MessageType PROTO1;
    public static final /* enum */ Extension$MessageType PROTO2;

    static {
        Extension$MessageType extension$MessageType;
        Extension$MessageType extension$MessageType2;
        PROTO1 = extension$MessageType2 = new Extension$MessageType("PROTO1", 0);
        int n10 = 1;
        PROTO2 = extension$MessageType = new Extension$MessageType("PROTO2", n10);
        Extension$MessageType[] extension$MessageTypeArray = new Extension$MessageType[2];
        extension$MessageTypeArray[0] = extension$MessageType2;
        extension$MessageTypeArray[n10] = extension$MessageType;
        $VALUES = extension$MessageTypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private Extension$MessageType() {
        void var2_-1;
        void var1_-1;
    }

    public static Extension$MessageType valueOf(String string2) {
        return Enum.valueOf(Extension$MessageType.class, string2);
    }

    public static Extension$MessageType[] values() {
        return (Extension$MessageType[])$VALUES.clone();
    }
}

