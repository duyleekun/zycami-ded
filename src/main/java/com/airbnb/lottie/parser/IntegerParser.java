/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.JsonUtils;
import com.airbnb.lottie.parser.ValueParser;
import com.airbnb.lottie.parser.moshi.JsonReader;

public class IntegerParser
implements ValueParser {
    public static final IntegerParser INSTANCE;

    static {
        IntegerParser integerParser;
        INSTANCE = integerParser = new IntegerParser();
    }

    private IntegerParser() {
    }

    public Integer parse(JsonReader jsonReader, float f10) {
        return Math.round(JsonUtils.valueFromObject(jsonReader) * f10);
    }
}

