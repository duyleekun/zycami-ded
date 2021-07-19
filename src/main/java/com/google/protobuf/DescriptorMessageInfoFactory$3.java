/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$FieldDescriptor$Type;
import com.google.protobuf.Descriptors$FileDescriptor$Syntax;
import com.google.protobuf.JavaType;

public class DescriptorMessageInfoFactory$3 {
    public static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type;
    public static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Descriptors$FileDescriptor$Syntax;
    public static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$JavaType;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        Enum enum_;
        int n12;
        Object object;
        int n13;
        Object object2;
        int n14;
        Object object3;
        int n15;
        Object object4;
        int n16;
        Object object5;
        int n17;
        Object object6;
        int n18;
        Object object7;
        int n19;
        Object object8;
        int n20 = Descriptors$FieldDescriptor$Type.values().length;
        int[] nArray = new int[n20];
        $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type = nArray;
        int n21 = 1;
        try {
            object8 = Descriptors$FieldDescriptor$Type.BOOL;
            n19 = ((Enum)object8).ordinal();
            nArray[n19] = n21;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n20 = 2;
        try {
            object8 = $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type;
            object7 = Descriptors$FieldDescriptor$Type.BYTES;
            n18 = ((Enum)object7).ordinal();
            object8[n18] = (Descriptors$FieldDescriptor$Type)n20;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n19 = 3;
        try {
            object7 = $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type;
            object6 = Descriptors$FieldDescriptor$Type.DOUBLE;
            n17 = object6.ordinal();
            object7[n17] = (Descriptors$FieldDescriptor$Type)n19;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n18 = 4;
        try {
            object6 = $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type;
            object5 = Descriptors$FieldDescriptor$Type.ENUM;
            n16 = object5.ordinal();
            object6[n16] = (Descriptors$FieldDescriptor$Type)n18;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n17 = 5;
        try {
            object5 = $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type;
            object4 = Descriptors$FieldDescriptor$Type.FIXED32;
            n15 = object4.ordinal();
            object5[n15] = (Descriptors$FieldDescriptor$Type)n17;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n16 = 6;
        try {
            object4 = $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type;
            object3 = Descriptors$FieldDescriptor$Type.FIXED64;
            n14 = object3.ordinal();
            object4[n14] = (Descriptors$FieldDescriptor$Type)n16;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n15 = 7;
        try {
            object3 = $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type;
            object2 = Descriptors$FieldDescriptor$Type.FLOAT;
            n13 = object2.ordinal();
            object3[n13] = (Descriptors$FieldDescriptor$Type)n15;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n14 = 8;
        try {
            object2 = $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type;
            object = Descriptors$FieldDescriptor$Type.GROUP;
            n12 = ((Enum)object).ordinal();
            object2[n12] = (Descriptors$FieldDescriptor$Type)n14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n13 = 9;
        try {
            object = $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type;
            enum_ = Descriptors$FieldDescriptor$Type.INT32;
            n11 = enum_.ordinal();
            object[n11] = (Descriptors$FieldDescriptor$Type)n13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object = $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type;
            enum_ = Descriptors$FieldDescriptor$Type.INT64;
            n11 = enum_.ordinal();
            n10 = 10;
            object[n11] = (Descriptors$FieldDescriptor$Type)n10;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object = $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type;
            enum_ = Descriptors$FieldDescriptor$Type.MESSAGE;
            n11 = enum_.ordinal();
            n10 = 11;
            object[n11] = (Descriptors$FieldDescriptor$Type)n10;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object = $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type;
            enum_ = Descriptors$FieldDescriptor$Type.SFIXED32;
            n11 = enum_.ordinal();
            n10 = 12;
            object[n11] = (Descriptors$FieldDescriptor$Type)n10;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object = $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type;
            enum_ = Descriptors$FieldDescriptor$Type.SFIXED64;
            n11 = enum_.ordinal();
            n10 = 13;
            object[n11] = (Descriptors$FieldDescriptor$Type)n10;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object = $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type;
            enum_ = Descriptors$FieldDescriptor$Type.SINT32;
            n11 = enum_.ordinal();
            n10 = 14;
            object[n11] = (Descriptors$FieldDescriptor$Type)n10;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object = $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type;
            enum_ = Descriptors$FieldDescriptor$Type.SINT64;
            n11 = enum_.ordinal();
            n10 = 15;
            object[n11] = (Descriptors$FieldDescriptor$Type)n10;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object = $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type;
            enum_ = Descriptors$FieldDescriptor$Type.STRING;
            n11 = enum_.ordinal();
            n10 = 16;
            object[n11] = (Descriptors$FieldDescriptor$Type)n10;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object = $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type;
            enum_ = Descriptors$FieldDescriptor$Type.UINT32;
            n11 = enum_.ordinal();
            n10 = 17;
            object[n11] = (Descriptors$FieldDescriptor$Type)n10;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object = $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type;
            enum_ = Descriptors$FieldDescriptor$Type.UINT64;
            n11 = enum_.ordinal();
            n10 = 18;
            object[n11] = (Descriptors$FieldDescriptor$Type)n10;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n12 = JavaType.values().length;
        object = new int[n12];
        $SwitchMap$com$google$protobuf$JavaType = (int[])object;
        try {
            enum_ = JavaType.BOOLEAN;
            n11 = enum_.ordinal();
            object[n11] = (Descriptors$FieldDescriptor$Type)n21;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object = $SwitchMap$com$google$protobuf$JavaType;
            enum_ = JavaType.BYTE_STRING;
            n11 = enum_.ordinal();
            object[n11] = (Descriptors$FieldDescriptor$Type)n20;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object = $SwitchMap$com$google$protobuf$JavaType;
            enum_ = JavaType.DOUBLE;
            n11 = enum_.ordinal();
            object[n11] = (Descriptors$FieldDescriptor$Type)n19;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object8 = $SwitchMap$com$google$protobuf$JavaType;
            object = JavaType.FLOAT;
            n12 = ((Enum)object).ordinal();
            object8[n12] = (Descriptors$FieldDescriptor$Type)n18;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object8 = $SwitchMap$com$google$protobuf$JavaType;
            object7 = JavaType.ENUM;
            n18 = ((Enum)object7).ordinal();
            object8[n18] = (Descriptors$FieldDescriptor$Type)n17;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object8 = $SwitchMap$com$google$protobuf$JavaType;
            object7 = JavaType.INT;
            n18 = ((Enum)object7).ordinal();
            object8[n18] = (Descriptors$FieldDescriptor$Type)n16;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object8 = $SwitchMap$com$google$protobuf$JavaType;
            object7 = JavaType.LONG;
            n18 = ((Enum)object7).ordinal();
            object8[n18] = (Descriptors$FieldDescriptor$Type)n15;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object8 = $SwitchMap$com$google$protobuf$JavaType;
            object7 = JavaType.STRING;
            n18 = ((Enum)object7).ordinal();
            object8[n18] = (Descriptors$FieldDescriptor$Type)n14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object8 = $SwitchMap$com$google$protobuf$JavaType;
            object7 = JavaType.MESSAGE;
            n18 = ((Enum)object7).ordinal();
            object8[n18] = (Descriptors$FieldDescriptor$Type)n13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n19 = Descriptors$FileDescriptor$Syntax.values().length;
        object8 = new int[n19];
        $SwitchMap$com$google$protobuf$Descriptors$FileDescriptor$Syntax = (int[])object8;
        try {
            object7 = Descriptors$FileDescriptor$Syntax.PROTO2;
            n18 = ((Enum)object7).ordinal();
            object8[n18] = (Descriptors$FieldDescriptor$Type)n21;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            int[] nArray2 = $SwitchMap$com$google$protobuf$Descriptors$FileDescriptor$Syntax;
            object8 = Descriptors$FileDescriptor$Syntax.PROTO3;
            n19 = ((Enum)object8).ordinal();
            nArray2[n19] = n20;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

