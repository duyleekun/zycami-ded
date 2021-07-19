/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.ValueParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader$Token;
import com.airbnb.lottie.value.ScaleXY;

public class ScaleXYParser
implements ValueParser {
    public static final ScaleXYParser INSTANCE;

    static {
        ScaleXYParser scaleXYParser;
        INSTANCE = scaleXYParser = new ScaleXYParser();
    }

    private ScaleXYParser() {
    }

    public ScaleXY parse(JsonReader object, float f10) {
        boolean bl2;
        float f11;
        boolean bl3;
        JsonReader$Token jsonReader$Token;
        JsonReader$Token jsonReader$Token2 = ((JsonReader)object).peek();
        if (jsonReader$Token2 == (jsonReader$Token = JsonReader$Token.BEGIN_ARRAY)) {
            bl3 = true;
            f11 = Float.MIN_VALUE;
        } else {
            bl3 = false;
            f11 = 0.0f;
            jsonReader$Token2 = null;
        }
        if (bl3) {
            ((JsonReader)object).beginArray();
        }
        double d10 = ((JsonReader)object).nextDouble();
        float f12 = (float)d10;
        double d11 = ((JsonReader)object).nextDouble();
        float f13 = (float)d11;
        while (bl2 = ((JsonReader)object).hasNext()) {
            ((JsonReader)object).skipValue();
        }
        if (bl3) {
            ((JsonReader)object).endArray();
        }
        f11 = 100.0f;
        f12 = f12 / f11 * f10;
        f13 = f13 / f11 * f10;
        object = new ScaleXY(f12, f13);
        return object;
    }
}

