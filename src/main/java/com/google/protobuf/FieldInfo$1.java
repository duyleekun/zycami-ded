/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.FieldType;

public class FieldInfo$1 {
    public static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$FieldType;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        FieldType fieldType;
        int n12 = FieldType.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$com$google$protobuf$FieldType = nArray;
        try {
            fieldType = FieldType.MESSAGE;
            n11 = fieldType.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$protobuf$FieldType;
            fieldType = FieldType.GROUP;
            n11 = fieldType.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$protobuf$FieldType;
            fieldType = FieldType.MESSAGE_LIST;
            n11 = fieldType.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$protobuf$FieldType;
            fieldType = FieldType.GROUP_LIST;
            n11 = fieldType.ordinal();
            nArray[n11] = n10 = 4;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

