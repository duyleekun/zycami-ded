/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$FieldDescriptor$JavaType;
import com.google.protobuf.Descriptors$FieldDescriptor$Type;

public class Descriptors$1 {
    public static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType;
    public static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        Object object;
        int n10;
        Enum enum_;
        int n11;
        Object object2;
        int n12 = Descriptors$FieldDescriptor$JavaType.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType = nArray;
        int n13 = 1;
        try {
            object2 = Descriptors$FieldDescriptor$JavaType.ENUM;
            n11 = ((Enum)object2).ordinal();
            nArray[n11] = n13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n12 = 2;
        try {
            object2 = $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType;
            enum_ = Descriptors$FieldDescriptor$JavaType.MESSAGE;
            n10 = enum_.ordinal();
            object2[n10] = (Descriptors$FieldDescriptor$JavaType)n12;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n11 = Descriptors$FieldDescriptor$Type.values().length;
        object2 = new int[n11];
        $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type = (int[])object2;
        try {
            enum_ = Descriptors$FieldDescriptor$Type.INT32;
            n10 = enum_.ordinal();
            object2[n10] = (Descriptors$FieldDescriptor$JavaType)n13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object = $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type;
            object2 = Descriptors$FieldDescriptor$Type.SINT32;
            n11 = ((Enum)object2).ordinal();
            object[n11] = n12;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type;
            object = (Object)Descriptors$FieldDescriptor$Type.SFIXED32;
            n13 = ((Enum)object).ordinal();
            nArray[n13] = n11 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type;
            object = Descriptors$FieldDescriptor$Type.UINT32;
            n13 = ((Enum)object).ordinal();
            nArray[n13] = n11 = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type;
            object = Descriptors$FieldDescriptor$Type.FIXED32;
            n13 = ((Enum)object).ordinal();
            nArray[n13] = n11 = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type;
            object = Descriptors$FieldDescriptor$Type.INT64;
            n13 = ((Enum)object).ordinal();
            nArray[n13] = n11 = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type;
            object = Descriptors$FieldDescriptor$Type.SINT64;
            n13 = ((Enum)object).ordinal();
            nArray[n13] = n11 = 7;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type;
            object = Descriptors$FieldDescriptor$Type.SFIXED64;
            n13 = ((Enum)object).ordinal();
            nArray[n13] = n11 = 8;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type;
            object = Descriptors$FieldDescriptor$Type.UINT64;
            n13 = ((Enum)object).ordinal();
            nArray[n13] = n11 = 9;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type;
            object = Descriptors$FieldDescriptor$Type.FIXED64;
            n13 = ((Enum)object).ordinal();
            nArray[n13] = n11 = 10;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type;
            object = Descriptors$FieldDescriptor$Type.FLOAT;
            n13 = ((Enum)object).ordinal();
            nArray[n13] = n11 = 11;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type;
            object = Descriptors$FieldDescriptor$Type.DOUBLE;
            n13 = ((Enum)object).ordinal();
            nArray[n13] = n11 = 12;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type;
            object = Descriptors$FieldDescriptor$Type.BOOL;
            n13 = ((Enum)object).ordinal();
            nArray[n13] = n11 = 13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type;
            object = Descriptors$FieldDescriptor$Type.STRING;
            n13 = ((Enum)object).ordinal();
            nArray[n13] = n11 = 14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type;
            object = Descriptors$FieldDescriptor$Type.BYTES;
            n13 = ((Enum)object).ordinal();
            nArray[n13] = n11 = 15;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type;
            object = Descriptors$FieldDescriptor$Type.ENUM;
            n13 = ((Enum)object).ordinal();
            nArray[n13] = n11 = 16;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type;
            object = Descriptors$FieldDescriptor$Type.MESSAGE;
            n13 = ((Enum)object).ordinal();
            nArray[n13] = n11 = 17;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type;
            object = Descriptors$FieldDescriptor$Type.GROUP;
            n13 = ((Enum)object).ordinal();
            nArray[n13] = n11 = 18;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

