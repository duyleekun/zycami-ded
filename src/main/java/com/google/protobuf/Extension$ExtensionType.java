/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

public final class Extension$ExtensionType
extends Enum {
    private static final /* synthetic */ Extension$ExtensionType[] $VALUES;
    public static final /* enum */ Extension$ExtensionType IMMUTABLE;
    public static final /* enum */ Extension$ExtensionType MUTABLE;
    public static final /* enum */ Extension$ExtensionType PROTO1;

    static {
        Extension$ExtensionType extension$ExtensionType;
        Extension$ExtensionType extension$ExtensionType2;
        Extension$ExtensionType extension$ExtensionType3;
        IMMUTABLE = extension$ExtensionType3 = new Extension$ExtensionType("IMMUTABLE", 0);
        int n10 = 1;
        MUTABLE = extension$ExtensionType2 = new Extension$ExtensionType("MUTABLE", n10);
        int n11 = 2;
        PROTO1 = extension$ExtensionType = new Extension$ExtensionType("PROTO1", n11);
        Extension$ExtensionType[] extension$ExtensionTypeArray = new Extension$ExtensionType[3];
        extension$ExtensionTypeArray[0] = extension$ExtensionType3;
        extension$ExtensionTypeArray[n10] = extension$ExtensionType2;
        extension$ExtensionTypeArray[n11] = extension$ExtensionType;
        $VALUES = extension$ExtensionTypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private Extension$ExtensionType() {
        void var2_-1;
        void var1_-1;
    }

    public static Extension$ExtensionType valueOf(String string2) {
        return Enum.valueOf(Extension$ExtensionType.class, string2);
    }

    public static Extension$ExtensionType[] values() {
        return (Extension$ExtensionType[])$VALUES.clone();
    }
}

