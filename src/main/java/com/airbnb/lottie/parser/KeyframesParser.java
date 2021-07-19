/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.animation.keyframe.PathKeyframe;
import com.airbnb.lottie.parser.KeyframeParser;
import com.airbnb.lottie.parser.ValueParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader$Options;
import com.airbnb.lottie.parser.moshi.JsonReader$Token;
import com.airbnb.lottie.value.Keyframe;
import java.util.ArrayList;
import java.util.List;

public class KeyframesParser {
    public static JsonReader$Options NAMES = JsonReader$Options.of("k");

    private KeyframesParser() {
    }

    public static List parse(JsonReader jsonReader, LottieComposition lottieComposition, float f10, ValueParser valueParser) {
        int n10;
        JsonReader$Token jsonReader$Token;
        ArrayList<JsonReader$Token> arrayList = new ArrayList<JsonReader$Token>();
        Object object = jsonReader.peek();
        if (object == (jsonReader$Token = JsonReader$Token.STRING)) {
            lottieComposition.addWarning("Lottie doesn't support expressions.");
            return arrayList;
        }
        jsonReader.beginObject();
        while (n10 = jsonReader.hasNext()) {
            object = NAMES;
            n10 = jsonReader.selectName((JsonReader$Options)object);
            if (n10) {
                jsonReader.skipValue();
                continue;
            }
            object = jsonReader.peek();
            if (object == (jsonReader$Token = JsonReader$Token.BEGIN_ARRAY)) {
                jsonReader.beginArray();
                object = jsonReader.peek();
                jsonReader$Token = JsonReader$Token.NUMBER;
                if (object == jsonReader$Token) {
                    object = KeyframeParser.parse(jsonReader, lottieComposition, f10, valueParser, false);
                    arrayList.add((JsonReader$Token)((Object)object));
                } else {
                    while (n10 = (int)(jsonReader.hasNext() ? 1 : 0)) {
                        n10 = 1;
                        object = KeyframeParser.parse(jsonReader, lottieComposition, f10, valueParser, n10 != 0);
                        arrayList.add((JsonReader$Token)((Object)object));
                    }
                }
                jsonReader.endArray();
                continue;
            }
            object = KeyframeParser.parse(jsonReader, lottieComposition, f10, valueParser, false);
            arrayList.add((JsonReader$Token)((Object)object));
        }
        jsonReader.endObject();
        KeyframesParser.setEndFrames(arrayList);
        return arrayList;
    }

    public static void setEndFrames(List list) {
        int n10;
        int n11;
        int n12 = list.size();
        int n13 = 0;
        Object object = null;
        while (true) {
            n11 = 1;
            n10 = n12 + -1;
            if (n13 >= n10) break;
            Keyframe keyframe = (Keyframe)list.get(n13);
            Object object2 = (Keyframe)list.get(++n13);
            float f10 = ((Keyframe)object2).startFrame;
            Object object3 = Float.valueOf(f10);
            keyframe.endFrame = object3;
            object3 = keyframe.endValue;
            if (object3 != null || (object2 = ((Keyframe)object2).startValue) == null) continue;
            keyframe.endValue = object2;
            n10 = keyframe instanceof PathKeyframe;
            if (n10 == 0) continue;
            keyframe = (PathKeyframe)keyframe;
            ((PathKeyframe)keyframe).createPath();
        }
        Keyframe keyframe = (Keyframe)list.get(n10);
        object = keyframe.startValue;
        if ((object == null || (object = keyframe.endValue) == null) && (n13 = list.size()) > n11) {
            list.remove(keyframe);
        }
    }
}

