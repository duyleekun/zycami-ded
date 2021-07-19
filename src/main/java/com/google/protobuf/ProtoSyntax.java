/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

public final class ProtoSyntax
extends Enum {
    private static final /* synthetic */ ProtoSyntax[] $VALUES;
    public static final /* enum */ ProtoSyntax PROTO2;
    public static final /* enum */ ProtoSyntax PROTO3;

    static {
        ProtoSyntax protoSyntax;
        ProtoSyntax protoSyntax2;
        PROTO2 = protoSyntax2 = new ProtoSyntax("PROTO2", 0);
        int n10 = 1;
        PROTO3 = protoSyntax = new ProtoSyntax("PROTO3", n10);
        ProtoSyntax[] protoSyntaxArray = new ProtoSyntax[2];
        protoSyntaxArray[0] = protoSyntax2;
        protoSyntaxArray[n10] = protoSyntax;
        $VALUES = protoSyntaxArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ProtoSyntax() {
        void var2_-1;
        void var1_-1;
    }

    public static ProtoSyntax valueOf(String string2) {
        return Enum.valueOf(ProtoSyntax.class, string2);
    }

    public static ProtoSyntax[] values() {
        return (ProtoSyntax[])$VALUES.clone();
    }
}

