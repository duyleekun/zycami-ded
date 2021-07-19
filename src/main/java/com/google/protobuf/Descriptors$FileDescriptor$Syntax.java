/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

public final class Descriptors$FileDescriptor$Syntax
extends Enum {
    private static final /* synthetic */ Descriptors$FileDescriptor$Syntax[] $VALUES;
    public static final /* enum */ Descriptors$FileDescriptor$Syntax PROTO2;
    public static final /* enum */ Descriptors$FileDescriptor$Syntax PROTO3;
    public static final /* enum */ Descriptors$FileDescriptor$Syntax UNKNOWN;
    private final String name;

    static {
        Descriptors$FileDescriptor$Syntax descriptors$FileDescriptor$Syntax;
        Descriptors$FileDescriptor$Syntax descriptors$FileDescriptor$Syntax2;
        Descriptors$FileDescriptor$Syntax descriptors$FileDescriptor$Syntax3;
        UNKNOWN = descriptors$FileDescriptor$Syntax3 = new Descriptors$FileDescriptor$Syntax("UNKNOWN", 0, "unknown");
        int n10 = 1;
        PROTO2 = descriptors$FileDescriptor$Syntax2 = new Descriptors$FileDescriptor$Syntax("PROTO2", n10, "proto2");
        int n11 = 2;
        PROTO3 = descriptors$FileDescriptor$Syntax = new Descriptors$FileDescriptor$Syntax("PROTO3", n11, "proto3");
        Descriptors$FileDescriptor$Syntax[] descriptors$FileDescriptor$SyntaxArray = new Descriptors$FileDescriptor$Syntax[3];
        descriptors$FileDescriptor$SyntaxArray[0] = descriptors$FileDescriptor$Syntax3;
        descriptors$FileDescriptor$SyntaxArray[n10] = descriptors$FileDescriptor$Syntax2;
        descriptors$FileDescriptor$SyntaxArray[n11] = descriptors$FileDescriptor$Syntax;
        $VALUES = descriptors$FileDescriptor$SyntaxArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private Descriptors$FileDescriptor$Syntax() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.name = var3_1;
    }

    public static /* synthetic */ String access$000(Descriptors$FileDescriptor$Syntax descriptors$FileDescriptor$Syntax) {
        return descriptors$FileDescriptor$Syntax.name;
    }

    public static Descriptors$FileDescriptor$Syntax valueOf(String string2) {
        return Enum.valueOf(Descriptors$FileDescriptor$Syntax.class, string2);
    }

    public static Descriptors$FileDescriptor$Syntax[] values() {
        return (Descriptors$FileDescriptor$Syntax[])$VALUES.clone();
    }
}

