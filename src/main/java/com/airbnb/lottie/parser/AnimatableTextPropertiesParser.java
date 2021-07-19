/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.parser.AnimatableValueParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader$Options;

public class AnimatableTextPropertiesParser {
    private static JsonReader$Options ANIMATABLE_PROPERTIES_NAMES;
    private static JsonReader$Options PROPERTIES_NAMES;

    static {
        PROPERTIES_NAMES = JsonReader$Options.of("a");
        ANIMATABLE_PROPERTIES_NAMES = JsonReader$Options.of("fc", "sc", "sw", "t");
    }

    private AnimatableTextPropertiesParser() {
    }

    public static AnimatableTextProperties parse(JsonReader object, LottieComposition lottieComposition) {
        int n10;
        ((JsonReader)object).beginObject();
        AnimatableTextProperties animatableTextProperties = null;
        while ((n10 = ((JsonReader)object).hasNext()) != 0) {
            JsonReader$Options jsonReader$Options = PROPERTIES_NAMES;
            n10 = ((JsonReader)object).selectName(jsonReader$Options);
            if (n10 != 0) {
                ((JsonReader)object).skipName();
                ((JsonReader)object).skipValue();
                continue;
            }
            animatableTextProperties = AnimatableTextPropertiesParser.parseAnimatableTextProperties((JsonReader)object, lottieComposition);
        }
        ((JsonReader)object).endObject();
        if (animatableTextProperties == null) {
            object = new AnimatableTextProperties(null, null, null, null);
            return object;
        }
        return animatableTextProperties;
    }

    private static AnimatableTextProperties parseAnimatableTextProperties(JsonReader object, LottieComposition lottieComposition) {
        int n10;
        ((JsonReader)object).beginObject();
        AnimatableColorValue animatableColorValue = null;
        AnimatableColorValue animatableColorValue2 = null;
        AnimatableFloatValue animatableFloatValue = null;
        AnimatableFloatValue animatableFloatValue2 = null;
        while ((n10 = ((JsonReader)object).hasNext()) != 0) {
            JsonReader$Options jsonReader$Options = ANIMATABLE_PROPERTIES_NAMES;
            n10 = ((JsonReader)object).selectName(jsonReader$Options);
            if (n10 != 0) {
                int n11 = 1;
                if (n10 != n11) {
                    n11 = 2;
                    if (n10 != n11) {
                        n11 = 3;
                        if (n10 != n11) {
                            ((JsonReader)object).skipName();
                            ((JsonReader)object).skipValue();
                            continue;
                        }
                        animatableFloatValue2 = AnimatableValueParser.parseFloat((JsonReader)object, lottieComposition);
                        continue;
                    }
                    animatableFloatValue = AnimatableValueParser.parseFloat((JsonReader)object, lottieComposition);
                    continue;
                }
                animatableColorValue2 = AnimatableValueParser.parseColor((JsonReader)object, lottieComposition);
                continue;
            }
            animatableColorValue = AnimatableValueParser.parseColor((JsonReader)object, lottieComposition);
        }
        ((JsonReader)object).endObject();
        object = new AnimatableTextProperties(animatableColorValue, animatableColorValue2, animatableFloatValue, animatableFloatValue2);
        return object;
    }
}

