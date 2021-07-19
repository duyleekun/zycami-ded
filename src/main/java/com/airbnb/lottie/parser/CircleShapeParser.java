/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.content.CircleShape;
import com.airbnb.lottie.parser.AnimatablePathValueParser;
import com.airbnb.lottie.parser.AnimatableValueParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader$Options;

public class CircleShapeParser {
    private static JsonReader$Options NAMES = JsonReader$Options.of("nm", "p", "s", "hd", "d");

    private CircleShapeParser() {
    }

    public static CircleShape parse(JsonReader object, LottieComposition lottieComposition, int n10) {
        JsonReader$Options jsonReader$Options;
        int n11 = 1;
        float f10 = Float.MIN_VALUE;
        int n12 = 3;
        if (n10 == n12) {
            n10 = n11;
        } else {
            n10 = 0;
            jsonReader$Options = null;
        }
        int n13 = 0;
        int n14 = n10;
        boolean bl2 = false;
        String string2 = null;
        AnimatableValue animatableValue = null;
        AnimatablePointValue animatablePointValue = null;
        while ((n10 = (int)(((JsonReader)object).hasNext() ? 1 : 0)) != 0) {
            jsonReader$Options = NAMES;
            n10 = ((JsonReader)object).selectName(jsonReader$Options);
            if (n10 != 0) {
                if (n10 != n11) {
                    n13 = 2;
                    if (n10 != n13) {
                        if (n10 != n12) {
                            n13 = 4;
                            if (n10 != n13) {
                                ((JsonReader)object).skipName();
                                ((JsonReader)object).skipValue();
                                continue;
                            }
                            n10 = ((JsonReader)object).nextInt();
                            if (n10 == n12) {
                                n14 = n11;
                                continue;
                            }
                            n14 = 0;
                            continue;
                        }
                        bl2 = ((JsonReader)object).nextBoolean();
                        continue;
                    }
                    animatablePointValue = AnimatableValueParser.parsePoint((JsonReader)object, lottieComposition);
                    continue;
                }
                animatableValue = AnimatablePathValueParser.parseSplitPath((JsonReader)object, lottieComposition);
                continue;
            }
            string2 = ((JsonReader)object).nextString();
        }
        object = new CircleShape(string2, animatableValue, animatablePointValue, n14 != 0, bl2);
        return object;
    }
}

