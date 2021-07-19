/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.JsonUtils;
import com.airbnb.lottie.parser.ValueParser;
import com.airbnb.lottie.parser.moshi.JsonReader;

public class FloatParser
implements ValueParser {
    public static final FloatParser INSTANCE;

    static {
        FloatParser floatParser;
        INSTANCE = floatParser = new FloatParser();
    }

    private FloatParser() {
    }

    public Float parse(JsonReader jsonReader, float f10) {
        return Float.valueOf(JsonUtils.valueFromObject(jsonReader) * f10);
    }
}

