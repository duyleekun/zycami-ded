/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.animation.keyframe.PathKeyframe;
import com.airbnb.lottie.parser.KeyframeParser;
import com.airbnb.lottie.parser.PathParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader$Token;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;

public class PathKeyframeParser {
    private PathKeyframeParser() {
    }

    public static PathKeyframe parse(JsonReader object, LottieComposition lottieComposition) {
        boolean bl2;
        JsonReader$Token jsonReader$Token;
        Object object2 = ((JsonReader)object).peek();
        if (object2 == (jsonReader$Token = JsonReader$Token.BEGIN_OBJECT)) {
            bl2 = true;
        } else {
            bl2 = false;
            object2 = null;
        }
        float f10 = Utils.dpScale();
        PathParser pathParser = PathParser.INSTANCE;
        object = KeyframeParser.parse((JsonReader)object, lottieComposition, f10, pathParser, bl2);
        object2 = new PathKeyframe(lottieComposition, (Keyframe)object);
        return object2;
    }
}

