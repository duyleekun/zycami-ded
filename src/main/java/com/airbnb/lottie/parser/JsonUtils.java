/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Color
 *  android.graphics.PointF
 */
package com.airbnb.lottie.parser;

import android.graphics.Color;
import android.graphics.PointF;
import com.airbnb.lottie.parser.JsonUtils$1;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader$Options;
import com.airbnb.lottie.parser.moshi.JsonReader$Token;
import java.util.ArrayList;
import java.util.List;

public class JsonUtils {
    private static final JsonReader$Options POINT_NAMES = JsonReader$Options.of("x", "y");

    private JsonUtils() {
    }

    private static PointF jsonArrayToPoint(JsonReader jsonReader, float f10) {
        JsonReader$Token jsonReader$Token;
        JsonReader$Token jsonReader$Token2;
        jsonReader.beginArray();
        double d10 = jsonReader.nextDouble();
        float f11 = (float)d10;
        double d11 = jsonReader.nextDouble();
        float f12 = (float)d11;
        while ((jsonReader$Token2 = jsonReader.peek()) != (jsonReader$Token = JsonReader$Token.END_ARRAY)) {
            jsonReader.skipValue();
        }
        jsonReader.endArray();
        jsonReader = new PointF(f11 *= f10, f12 *= f10);
        return jsonReader;
    }

    private static PointF jsonNumbersToPoint(JsonReader jsonReader, float f10) {
        boolean bl2;
        double d10 = jsonReader.nextDouble();
        float f11 = (float)d10;
        double d11 = jsonReader.nextDouble();
        float f12 = (float)d11;
        while (bl2 = jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        jsonReader = new PointF(f11 *= f10, f12 *= f10);
        return jsonReader;
    }

    private static PointF jsonObjectToPoint(JsonReader jsonReader, float f10) {
        int n10;
        jsonReader.beginObject();
        float f11 = 0.0f;
        float f12 = 0.0f;
        while ((n10 = jsonReader.hasNext()) != 0) {
            JsonReader$Options jsonReader$Options = POINT_NAMES;
            n10 = jsonReader.selectName(jsonReader$Options);
            if (n10 != 0) {
                int n11 = 1;
                if (n10 != n11) {
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    continue;
                }
                f12 = JsonUtils.valueFromObject(jsonReader);
                continue;
            }
            f11 = JsonUtils.valueFromObject(jsonReader);
        }
        jsonReader.endObject();
        jsonReader = new PointF(f11 *= f10, f12 *= f10);
        return jsonReader;
    }

    public static int jsonToColor(JsonReader jsonReader) {
        boolean bl2;
        jsonReader.beginArray();
        double d10 = jsonReader.nextDouble();
        double d11 = 255.0;
        int n10 = (int)(d10 *= d11);
        int n11 = (int)(jsonReader.nextDouble() * d11);
        double d12 = jsonReader.nextDouble() * d11;
        int n12 = (int)d12;
        while (bl2 = jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        jsonReader.endArray();
        return Color.argb((int)255, (int)n10, (int)n11, (int)n12);
    }

    public static PointF jsonToPoint(JsonReader object, float f10) {
        Object object2 = JsonUtils$1.$SwitchMap$com$airbnb$lottie$parser$moshi$JsonReader$Token;
        JsonReader$Token jsonReader$Token = object.peek();
        int n10 = jsonReader$Token.ordinal();
        int n11 = object2[n10];
        if (n11 != (n10 = 1)) {
            n10 = 2;
            if (n11 != n10) {
                n10 = 3;
                if (n11 == n10) {
                    return JsonUtils.jsonObjectToPoint(object, f10);
                }
                object2 = new StringBuilder;
                ((StringBuilder)object2)();
                ((StringBuilder)object2).append("Unknown point starts with ");
                object = object.peek();
                ((StringBuilder)object2).append(object);
                object = ((StringBuilder)object2).toString();
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
                throw illegalArgumentException;
            }
            return JsonUtils.jsonArrayToPoint(object, f10);
        }
        return JsonUtils.jsonNumbersToPoint(object, f10);
    }

    public static List jsonToPoints(JsonReader jsonReader, float f10) {
        JsonReader$Token jsonReader$Token;
        JsonReader$Token jsonReader$Token2;
        ArrayList<JsonReader$Token> arrayList = new ArrayList<JsonReader$Token>();
        jsonReader.beginArray();
        while ((jsonReader$Token2 = jsonReader.peek()) == (jsonReader$Token = JsonReader$Token.BEGIN_ARRAY)) {
            jsonReader.beginArray();
            jsonReader$Token2 = JsonUtils.jsonToPoint(jsonReader, f10);
            arrayList.add(jsonReader$Token2);
            jsonReader.endArray();
        }
        jsonReader.endArray();
        return arrayList;
    }

    public static float valueFromObject(JsonReader object) {
        Object object2 = ((JsonReader)object).peek();
        Object object3 = JsonUtils$1.$SwitchMap$com$airbnb$lottie$parser$moshi$JsonReader$Token;
        int n10 = object2.ordinal();
        int n11 = object3[n10];
        if (n11 != (n10 = 1)) {
            n10 = 2;
            if (n11 == n10) {
                ((JsonReader)object).beginArray();
                double d10 = ((JsonReader)object).nextDouble();
                float f10 = (float)d10;
                while ((n11 = (int)(((JsonReader)object).hasNext() ? 1 : 0)) != 0) {
                    ((JsonReader)object).skipValue();
                }
                ((JsonReader)object).endArray();
                return f10;
            }
            object3 = new StringBuilder;
            ((StringBuilder)object3)();
            ((StringBuilder)object3).append("Unknown value for token of type ");
            ((StringBuilder)object3).append(object2);
            object2 = ((StringBuilder)object3).toString();
            object = new IllegalArgumentException((String)object2);
            throw object;
        }
        return (float)((JsonReader)object).nextDouble();
    }
}

