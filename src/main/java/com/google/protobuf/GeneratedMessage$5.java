/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$FieldDescriptor$JavaType;

public class GeneratedMessage$5 {
    public static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        Descriptors$FieldDescriptor$JavaType descriptors$FieldDescriptor$JavaType;
        int n12 = Descriptors$FieldDescriptor$JavaType.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType = nArray;
        try {
            descriptors$FieldDescriptor$JavaType = Descriptors$FieldDescriptor$JavaType.MESSAGE;
            n11 = descriptors$FieldDescriptor$JavaType.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType;
            descriptors$FieldDescriptor$JavaType = Descriptors$FieldDescriptor$JavaType.ENUM;
            n11 = descriptors$FieldDescriptor$JavaType.ordinal();
            nArray[n11] = n10 = 2;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

