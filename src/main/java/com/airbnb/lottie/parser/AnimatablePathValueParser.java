/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatablePathValue;
import com.airbnb.lottie.model.animatable.AnimatableSplitDimensionPathValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.parser.AnimatableValueParser;
import com.airbnb.lottie.parser.JsonUtils;
import com.airbnb.lottie.parser.KeyframesParser;
import com.airbnb.lottie.parser.PathKeyframeParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader$Options;
import com.airbnb.lottie.parser.moshi.JsonReader$Token;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;
import java.util.ArrayList;

public class AnimatablePathValueParser {
    private static JsonReader$Options NAMES = JsonReader$Options.of("k", "x", "y");

    private AnimatablePathValueParser() {
    }

    public static AnimatablePathValue parse(JsonReader object, LottieComposition object2) {
        JsonReader$Token jsonReader$Token;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        Object object3 = ((JsonReader)object).peek();
        if (object3 == (jsonReader$Token = JsonReader$Token.BEGIN_ARRAY)) {
            boolean bl2;
            ((JsonReader)object).beginArray();
            while (bl2 = ((JsonReader)object).hasNext()) {
                object3 = PathKeyframeParser.parse((JsonReader)object, (LottieComposition)object2);
                arrayList.add(object3);
            }
            ((JsonReader)object).endArray();
            KeyframesParser.setEndFrames(arrayList);
        } else {
            float f10 = Utils.dpScale();
            object = JsonUtils.jsonToPoint((JsonReader)object, f10);
            object2 = new Keyframe(object);
            arrayList.add(object2);
        }
        object = new AnimatablePathValue(arrayList);
        return object;
    }

    public static AnimatableValue parseSplitPath(JsonReader object, LottieComposition lottieComposition) {
        JsonReader$Token jsonReader$Token;
        Object object2;
        ((JsonReader)object).beginObject();
        int n10 = 1;
        AnimatablePathValue animatablePathValue = null;
        AnimatableFloatValue animatableFloatValue = null;
        int n11 = 0;
        AnimatableFloatValue animatableFloatValue2 = null;
        while ((object2 = ((JsonReader)object).peek()) != (jsonReader$Token = JsonReader$Token.END_OBJECT)) {
            block7: {
                block11: {
                    block10: {
                        block8: {
                            block9: {
                                object2 = NAMES;
                                int n12 = ((JsonReader)object).selectName((JsonReader$Options)object2);
                                if (n12 == 0) break block7;
                                if (n12 == n10) break block8;
                                int n13 = 2;
                                if (n12 != n13) {
                                    ((JsonReader)object).skipName();
                                    ((JsonReader)object).skipValue();
                                    continue;
                                }
                                object2 = ((JsonReader)object).peek();
                                if (object2 != (jsonReader$Token = JsonReader$Token.STRING)) break block9;
                                ((JsonReader)object).skipValue();
                                break block10;
                            }
                            animatableFloatValue = AnimatableValueParser.parseFloat((JsonReader)object, lottieComposition);
                            continue;
                        }
                        object2 = ((JsonReader)object).peek();
                        if (object2 != (jsonReader$Token = JsonReader$Token.STRING)) break block11;
                        ((JsonReader)object).skipValue();
                    }
                    n11 = n10;
                    continue;
                }
                animatableFloatValue2 = AnimatableValueParser.parseFloat((JsonReader)object, lottieComposition);
                continue;
            }
            animatablePathValue = AnimatablePathValueParser.parse((JsonReader)object, lottieComposition);
        }
        ((JsonReader)object).endObject();
        if (n11 != 0) {
            object = "Lottie doesn't support expressions.";
            lottieComposition.addWarning((String)object);
        }
        if (animatablePathValue != null) {
            return animatablePathValue;
        }
        object = new AnimatableSplitDimensionPathValue(animatableFloatValue2, animatableFloatValue);
        return object;
    }
}

