/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.moshi.JsonReader$Token;

public class JsonUtils$1 {
    public static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$parser$moshi$JsonReader$Token;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        JsonReader$Token jsonReader$Token;
        int n12 = JsonReader$Token.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$com$airbnb$lottie$parser$moshi$JsonReader$Token = nArray;
        try {
            jsonReader$Token = JsonReader$Token.NUMBER;
            n11 = jsonReader$Token.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$airbnb$lottie$parser$moshi$JsonReader$Token;
            jsonReader$Token = JsonReader$Token.BEGIN_ARRAY;
            n11 = jsonReader$Token.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$airbnb$lottie$parser$moshi$JsonReader$Token;
            jsonReader$Token = JsonReader$Token.BEGIN_OBJECT;
            n11 = jsonReader$Token.ordinal();
            nArray[n11] = n10 = 3;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

