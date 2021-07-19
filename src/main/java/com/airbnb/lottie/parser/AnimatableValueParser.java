/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableGradientColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableScaleValue;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;
import com.airbnb.lottie.model.animatable.AnimatableTextFrame;
import com.airbnb.lottie.parser.ColorParser;
import com.airbnb.lottie.parser.DocumentDataParser;
import com.airbnb.lottie.parser.FloatParser;
import com.airbnb.lottie.parser.GradientColorParser;
import com.airbnb.lottie.parser.IntegerParser;
import com.airbnb.lottie.parser.KeyframesParser;
import com.airbnb.lottie.parser.PointFParser;
import com.airbnb.lottie.parser.ScaleXYParser;
import com.airbnb.lottie.parser.ShapeDataParser;
import com.airbnb.lottie.parser.ValueParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Utils;
import java.util.List;

public class AnimatableValueParser {
    private AnimatableValueParser() {
    }

    private static List parse(JsonReader jsonReader, float f10, LottieComposition lottieComposition, ValueParser valueParser) {
        return KeyframesParser.parse(jsonReader, lottieComposition, f10, valueParser);
    }

    private static List parse(JsonReader jsonReader, LottieComposition lottieComposition, ValueParser valueParser) {
        return KeyframesParser.parse(jsonReader, lottieComposition, 1.0f, valueParser);
    }

    public static AnimatableColorValue parseColor(JsonReader object, LottieComposition lottieComposition) {
        ColorParser colorParser = ColorParser.INSTANCE;
        object = AnimatableValueParser.parse((JsonReader)object, lottieComposition, colorParser);
        AnimatableColorValue animatableColorValue = new AnimatableColorValue((List)object);
        return animatableColorValue;
    }

    public static AnimatableTextFrame parseDocumentData(JsonReader object, LottieComposition lottieComposition) {
        DocumentDataParser documentDataParser = DocumentDataParser.INSTANCE;
        object = AnimatableValueParser.parse((JsonReader)object, lottieComposition, documentDataParser);
        AnimatableTextFrame animatableTextFrame = new AnimatableTextFrame((List)object);
        return animatableTextFrame;
    }

    public static AnimatableFloatValue parseFloat(JsonReader jsonReader, LottieComposition lottieComposition) {
        return AnimatableValueParser.parseFloat(jsonReader, lottieComposition, true);
    }

    public static AnimatableFloatValue parseFloat(JsonReader object, LottieComposition lottieComposition, boolean bl2) {
        float f10;
        if (bl2) {
            f10 = Utils.dpScale();
        } else {
            int n10 = 1065353216;
            f10 = 1.0f;
        }
        FloatParser floatParser = FloatParser.INSTANCE;
        object = AnimatableValueParser.parse((JsonReader)object, f10, lottieComposition, floatParser);
        AnimatableFloatValue animatableFloatValue = new AnimatableFloatValue((List)object);
        return animatableFloatValue;
    }

    public static AnimatableGradientColorValue parseGradientColor(JsonReader object, LottieComposition lottieComposition, int n10) {
        GradientColorParser gradientColorParser = new GradientColorParser(n10);
        object = AnimatableValueParser.parse((JsonReader)object, lottieComposition, gradientColorParser);
        AnimatableGradientColorValue animatableGradientColorValue = new AnimatableGradientColorValue((List)object);
        return animatableGradientColorValue;
    }

    public static AnimatableIntegerValue parseInteger(JsonReader object, LottieComposition lottieComposition) {
        IntegerParser integerParser = IntegerParser.INSTANCE;
        object = AnimatableValueParser.parse((JsonReader)object, lottieComposition, integerParser);
        AnimatableIntegerValue animatableIntegerValue = new AnimatableIntegerValue((List)object);
        return animatableIntegerValue;
    }

    public static AnimatablePointValue parsePoint(JsonReader object, LottieComposition lottieComposition) {
        float f10 = Utils.dpScale();
        PointFParser pointFParser = PointFParser.INSTANCE;
        object = AnimatableValueParser.parse((JsonReader)object, f10, lottieComposition, pointFParser);
        AnimatablePointValue animatablePointValue = new AnimatablePointValue((List)object);
        return animatablePointValue;
    }

    public static AnimatableScaleValue parseScale(JsonReader object, LottieComposition lottieComposition) {
        ScaleXYParser scaleXYParser = ScaleXYParser.INSTANCE;
        object = AnimatableValueParser.parse((JsonReader)object, lottieComposition, scaleXYParser);
        AnimatableScaleValue animatableScaleValue = new AnimatableScaleValue((List)object);
        return animatableScaleValue;
    }

    public static AnimatableShapeValue parseShapeData(JsonReader object, LottieComposition lottieComposition) {
        float f10 = Utils.dpScale();
        ShapeDataParser shapeDataParser = ShapeDataParser.INSTANCE;
        object = AnimatableValueParser.parse((JsonReader)object, f10, lottieComposition, shapeDataParser);
        AnimatableShapeValue animatableShapeValue = new AnimatableShapeValue((List)object);
        return animatableShapeValue;
    }
}

