/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Value$KindCase;

public class Value$2 {
    public static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Value$KindCase;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        Value$KindCase value$KindCase;
        int n12 = Value$KindCase.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$com$google$protobuf$Value$KindCase = nArray;
        try {
            value$KindCase = Value$KindCase.NULL_VALUE;
            n11 = value$KindCase.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$protobuf$Value$KindCase;
            value$KindCase = Value$KindCase.NUMBER_VALUE;
            n11 = value$KindCase.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$protobuf$Value$KindCase;
            value$KindCase = Value$KindCase.STRING_VALUE;
            n11 = value$KindCase.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$protobuf$Value$KindCase;
            value$KindCase = Value$KindCase.BOOL_VALUE;
            n11 = value$KindCase.ordinal();
            nArray[n11] = n10 = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$protobuf$Value$KindCase;
            value$KindCase = Value$KindCase.STRUCT_VALUE;
            n11 = value$KindCase.ordinal();
            nArray[n11] = n10 = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$protobuf$Value$KindCase;
            value$KindCase = Value$KindCase.LIST_VALUE;
            n11 = value$KindCase.ordinal();
            nArray[n11] = n10 = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$protobuf$Value$KindCase;
            value$KindCase = Value$KindCase.KIND_NOT_SET;
            n11 = value$KindCase.ordinal();
            nArray[n11] = n10 = 7;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

