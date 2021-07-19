/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal.bind;

import com.google.gson.stream.JsonToken;

public class TypeAdapters$36 {
    public static final /* synthetic */ int[] $SwitchMap$com$google$gson$stream$JsonToken;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        JsonToken jsonToken;
        int n12 = JsonToken.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$com$google$gson$stream$JsonToken = nArray;
        try {
            jsonToken = JsonToken.NUMBER;
            n11 = jsonToken.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$gson$stream$JsonToken;
            jsonToken = JsonToken.BOOLEAN;
            n11 = jsonToken.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$gson$stream$JsonToken;
            jsonToken = JsonToken.STRING;
            n11 = jsonToken.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$gson$stream$JsonToken;
            jsonToken = JsonToken.NULL;
            n11 = jsonToken.ordinal();
            nArray[n11] = n10 = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$gson$stream$JsonToken;
            jsonToken = JsonToken.BEGIN_ARRAY;
            n11 = jsonToken.ordinal();
            nArray[n11] = n10 = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$gson$stream$JsonToken;
            jsonToken = JsonToken.BEGIN_OBJECT;
            n11 = jsonToken.ordinal();
            nArray[n11] = n10 = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$gson$stream$JsonToken;
            jsonToken = JsonToken.END_DOCUMENT;
            n11 = jsonToken.ordinal();
            nArray[n11] = n10 = 7;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$gson$stream$JsonToken;
            jsonToken = JsonToken.NAME;
            n11 = jsonToken.ordinal();
            nArray[n11] = n10 = 8;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$gson$stream$JsonToken;
            jsonToken = JsonToken.END_OBJECT;
            n11 = jsonToken.ordinal();
            nArray[n11] = n10 = 9;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$gson$stream$JsonToken;
            jsonToken = JsonToken.END_ARRAY;
            n11 = jsonToken.ordinal();
            nArray[n11] = n10 = 10;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

