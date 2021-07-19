/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$EnumDescriptor;
import com.google.protobuf.Descriptors$EnumValueDescriptor;
import com.google.protobuf.Internal$EnumLiteMap;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.Syntax$1;
import com.google.protobuf.TypeProto;
import java.util.List;

public final class Syntax
extends Enum
implements ProtocolMessageEnum {
    private static final /* synthetic */ Syntax[] $VALUES;
    public static final /* enum */ Syntax SYNTAX_PROTO2;
    public static final int SYNTAX_PROTO2_VALUE = 0;
    public static final /* enum */ Syntax SYNTAX_PROTO3;
    public static final int SYNTAX_PROTO3_VALUE = 1;
    public static final /* enum */ Syntax UNRECOGNIZED;
    private static final Syntax[] VALUES;
    private static final Internal$EnumLiteMap internalValueMap;
    private final int value;

    static {
        Syntax syntax;
        Syntax syntax2;
        Object object = new Syntax("SYNTAX_PROTO2", 0, 0);
        SYNTAX_PROTO2 = object;
        int n10 = 1;
        SYNTAX_PROTO3 = syntax2 = new Syntax("SYNTAX_PROTO3", n10, n10);
        int n11 = 2;
        UNRECOGNIZED = syntax = new Syntax("UNRECOGNIZED", n11, -1);
        Syntax[] syntaxArray = new Syntax[3];
        syntaxArray[0] = object;
        syntaxArray[n10] = syntax2;
        syntaxArray[n11] = syntax;
        $VALUES = syntaxArray;
        internalValueMap = object = new Syntax$1();
        VALUES = Syntax.values();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private Syntax() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
    }

    public static Syntax forNumber(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                return null;
            }
            return SYNTAX_PROTO3;
        }
        return SYNTAX_PROTO2;
    }

    public static final Descriptors$EnumDescriptor getDescriptor() {
        return (Descriptors$EnumDescriptor)TypeProto.getDescriptor().getEnumTypes().get(0);
    }

    public static Internal$EnumLiteMap internalGetValueMap() {
        return internalValueMap;
    }

    public static Syntax valueOf(int n10) {
        return Syntax.forNumber(n10);
    }

    public static Syntax valueOf(Descriptors$EnumValueDescriptor object) {
        Descriptors$EnumDescriptor descriptors$EnumDescriptor;
        Syntax[] syntaxArray = ((Descriptors$EnumValueDescriptor)object).getType();
        if (syntaxArray == (descriptors$EnumDescriptor = Syntax.getDescriptor())) {
            int n10;
            int n11 = ((Descriptors$EnumValueDescriptor)object).getIndex();
            if (n11 == (n10 = -1)) {
                return UNRECOGNIZED;
            }
            syntaxArray = VALUES;
            int n12 = ((Descriptors$EnumValueDescriptor)object).getIndex();
            return syntaxArray[n12];
        }
        object = new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        throw object;
    }

    public static Syntax valueOf(String string2) {
        return Enum.valueOf(Syntax.class, string2);
    }

    public static Syntax[] values() {
        return (Syntax[])$VALUES.clone();
    }

    public final Descriptors$EnumDescriptor getDescriptorForType() {
        return Syntax.getDescriptor();
    }

    public final int getNumber() {
        Object object = UNRECOGNIZED;
        if (this != object) {
            return this.value;
        }
        object = new IllegalArgumentException("Can't get the number of an unknown enum value.");
        throw object;
    }

    public final Descriptors$EnumValueDescriptor getValueDescriptor() {
        List list = Syntax.getDescriptor().getValues();
        int n10 = this.ordinal();
        return (Descriptors$EnumValueDescriptor)list.get(n10);
    }
}

