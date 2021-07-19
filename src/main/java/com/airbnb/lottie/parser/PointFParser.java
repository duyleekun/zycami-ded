/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 */
package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.parser.JsonUtils;
import com.airbnb.lottie.parser.ValueParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader$Token;

public class PointFParser
implements ValueParser {
    public static final PointFParser INSTANCE;

    static {
        PointFParser pointFParser;
        INSTANCE = pointFParser = new PointFParser();
    }

    private PointFParser() {
    }

    public PointF parse(JsonReader object, float f10) {
        JsonReader$Token jsonReader$Token;
        JsonReader$Token jsonReader$Token2 = ((JsonReader)object).peek();
        if (jsonReader$Token2 == (jsonReader$Token = JsonReader$Token.BEGIN_ARRAY)) {
            return JsonUtils.jsonToPoint((JsonReader)object, f10);
        }
        jsonReader$Token = JsonReader$Token.BEGIN_OBJECT;
        if (jsonReader$Token2 == jsonReader$Token) {
            return JsonUtils.jsonToPoint((JsonReader)object, f10);
        }
        jsonReader$Token = JsonReader$Token.NUMBER;
        if (jsonReader$Token2 == jsonReader$Token) {
            boolean bl2;
            double d10 = ((JsonReader)object).nextDouble();
            float f11 = (float)d10 * f10;
            double d11 = ((JsonReader)object).nextDouble();
            float f12 = (float)d11 * f10;
            jsonReader$Token2 = new PointF(f11, f12);
            while (bl2 = ((JsonReader)object).hasNext()) {
                ((JsonReader)object).skipValue();
            }
            return jsonReader$Token2;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Cannot convert json to point. Next token is ");
        charSequence.append((Object)jsonReader$Token2);
        charSequence = charSequence.toString();
        object = new IllegalArgumentException((String)charSequence);
        throw object;
    }
}

