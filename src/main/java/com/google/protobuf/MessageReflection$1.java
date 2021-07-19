/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$FieldDescriptor$Type;

public class MessageReflection$1 {
    public static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        Descriptors$FieldDescriptor$Type descriptors$FieldDescriptor$Type;
        int n12 = Descriptors$FieldDescriptor$Type.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type = nArray;
        try {
            descriptors$FieldDescriptor$Type = Descriptors$FieldDescriptor$Type.GROUP;
            n11 = descriptors$FieldDescriptor$Type.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type;
            descriptors$FieldDescriptor$Type = Descriptors$FieldDescriptor$Type.MESSAGE;
            n11 = descriptors$FieldDescriptor$Type.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type;
            descriptors$FieldDescriptor$Type = Descriptors$FieldDescriptor$Type.ENUM;
            n11 = descriptors$FieldDescriptor$Type.ordinal();
            nArray[n11] = n10 = 3;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

