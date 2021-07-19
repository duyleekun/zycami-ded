/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;
import com.airbnb.lottie.model.content.ShapePath;
import com.airbnb.lottie.parser.AnimatableValueParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader$Options;

public class ShapePathParser {
    public static JsonReader$Options NAMES = JsonReader$Options.of("nm", "ind", "ks", "hd");

    private ShapePathParser() {
    }

    public static ShapePath parse(JsonReader object, LottieComposition lottieComposition) {
        int n10;
        int n11 = 0;
        String string2 = null;
        AnimatableShapeValue animatableShapeValue = null;
        boolean bl2 = false;
        while ((n10 = ((JsonReader)object).hasNext()) != 0) {
            JsonReader$Options jsonReader$Options = NAMES;
            n10 = ((JsonReader)object).selectName(jsonReader$Options);
            if (n10 != 0) {
                int n12 = 1;
                if (n10 != n12) {
                    n12 = 2;
                    if (n10 != n12) {
                        n12 = 3;
                        if (n10 != n12) {
                            ((JsonReader)object).skipValue();
                            continue;
                        }
                        bl2 = ((JsonReader)object).nextBoolean();
                        continue;
                    }
                    animatableShapeValue = AnimatableValueParser.parseShapeData((JsonReader)object, lottieComposition);
                    continue;
                }
                n11 = ((JsonReader)object).nextInt();
                continue;
            }
            string2 = ((JsonReader)object).nextString();
        }
        object = new ShapePath(string2, n11, animatableShapeValue, bl2);
        return object;
    }
}

