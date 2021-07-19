/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Color
 */
package com.airbnb.lottie.parser;

import android.graphics.Color;
import com.airbnb.lottie.parser.ValueParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader$Token;

public class ColorParser
implements ValueParser {
    public static final ColorParser INSTANCE;

    static {
        ColorParser colorParser;
        INSTANCE = colorParser = new ColorParser();
    }

    private ColorParser() {
    }

    public Integer parse(JsonReader jsonReader, float f10) {
        double d10;
        int n10;
        JsonReader$Token jsonReader$Token;
        JsonReader$Token jsonReader$Token2 = jsonReader.peek();
        if (jsonReader$Token2 == (jsonReader$Token = JsonReader$Token.BEGIN_ARRAY)) {
            n10 = 1;
        } else {
            n10 = 0;
            jsonReader$Token2 = null;
        }
        if (n10 != 0) {
            jsonReader.beginArray();
        }
        double d11 = jsonReader.nextDouble();
        double d12 = jsonReader.nextDouble();
        double d13 = jsonReader.nextDouble();
        JsonReader$Token jsonReader$Token3 = jsonReader.peek();
        JsonReader$Token jsonReader$Token4 = JsonReader$Token.NUMBER;
        double d14 = 1.0;
        double d15 = jsonReader$Token3 == jsonReader$Token4 ? jsonReader.nextDouble() : d14;
        if (n10 != 0) {
            jsonReader.endArray();
        }
        if ((d10 = d11 == d14 ? 0 : (d11 < d14 ? -1 : 1)) <= 0 && (d10 = d12 == d14 ? 0 : (d12 < d14 ? -1 : 1)) <= 0 && (d10 = d13 == d14 ? 0 : (d13 < d14 ? -1 : 1)) <= 0) {
            double d16 = 255.0;
            d11 *= d16;
            d12 *= d16;
            d13 *= d16;
            Object object = d15 == d14 ? 0 : (d15 < d14 ? -1 : 1);
            if (object <= 0) {
                d15 *= d16;
            }
        }
        d10 = (int)d15;
        n10 = (int)d11;
        int n11 = (int)d12;
        int n12 = (int)d13;
        return Color.argb((int)d10, (int)n10, (int)n11, (int)n12);
    }
}

