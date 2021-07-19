/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 *  android.view.animation.Interpolator
 *  android.view.animation.LinearInterpolator
 */
package com.airbnb.lottie.parser;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.parser.JsonUtils;
import com.airbnb.lottie.parser.ValueParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader$Options;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;
import java.lang.ref.WeakReference;

public class KeyframeParser {
    private static final Interpolator LINEAR_INTERPOLATOR;
    private static final float MAX_CP_VALUE = 100.0f;
    public static JsonReader$Options NAMES;
    private static SparseArrayCompat pathInterpolatorCache;

    static {
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        LINEAR_INTERPOLATOR = linearInterpolator;
        NAMES = JsonReader$Options.of("t", "s", "e", "o", "i", "h", "to", "ti");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static WeakReference getInterpolator(int n10) {
        Class<KeyframeParser> clazz = KeyframeParser.class;
        synchronized (clazz) {
            SparseArrayCompat sparseArrayCompat = KeyframeParser.pathInterpolatorCache();
            Object object = sparseArrayCompat.get(n10);
            return (WeakReference)object;
        }
    }

    public static Keyframe parse(JsonReader jsonReader, LottieComposition lottieComposition, float f10, ValueParser valueParser, boolean bl2) {
        if (bl2) {
            return KeyframeParser.parseKeyframe(lottieComposition, jsonReader, f10, valueParser);
        }
        return KeyframeParser.parseStaticValue(jsonReader, f10, valueParser);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static Keyframe parseKeyframe(LottieComposition lottieComposition, JsonReader jsonReader, float f10, ValueParser valueParser) {
        Keyframe keyframe;
        Interpolator interpolator2;
        JsonReader$Options jsonReader$Options;
        PointF pointF;
        PointF pointF2;
        Object object;
        Object object2;
        float f11;
        block20: {
            block22: {
                void var11_29;
                block18: {
                    Interpolator interpolator3;
                    block21: {
                        void var4_11;
                        void var11_27;
                        void var16_36;
                        PointF pointF3;
                        float f12;
                        int n10;
                        float f13;
                        float f14;
                        Object var8_21;
                        float f15;
                        float f16;
                        block19: {
                            Interpolator interpolator4;
                            int n11;
                            JsonReader jsonReader2 = jsonReader;
                            f16 = f10;
                            ValueParser valueParser2 = valueParser;
                            jsonReader.beginObject();
                            f15 = 0.0f;
                            var8_21 = null;
                            f14 = 0.0f;
                            f13 = 0.0f;
                            Object var11_24 = null;
                            n10 = 0;
                            f12 = 0.0f;
                            f11 = 0.0f;
                            pointF3 = null;
                            Object var16_35 = null;
                            object2 = null;
                            object = null;
                            pointF2 = null;
                            pointF = null;
                            block14: while ((n11 = jsonReader.hasNext()) != 0) {
                                jsonReader$Options = NAMES;
                                n11 = jsonReader2.selectName(jsonReader$Options);
                                switch (n11) {
                                    default: {
                                        jsonReader.skipValue();
                                        continue block14;
                                    }
                                    case 7: {
                                        pointF2 = JsonUtils.jsonToPoint(jsonReader, f10);
                                        continue block14;
                                    }
                                    case 6: {
                                        pointF = JsonUtils.jsonToPoint(jsonReader, f10);
                                        continue block14;
                                    }
                                    case 5: {
                                        n10 = jsonReader.nextInt();
                                        n11 = 1;
                                        float f17 = Float.MIN_VALUE;
                                        if (n10 == n11) {
                                            n10 = n11;
                                            f12 = f17;
                                            continue block14;
                                        }
                                        n10 = 0;
                                        f12 = 0.0f;
                                        continue block14;
                                    }
                                    case 4: {
                                        PointF pointF4 = JsonUtils.jsonToPoint(jsonReader, f10);
                                        continue block14;
                                    }
                                    case 3: {
                                        pointF3 = JsonUtils.jsonToPoint(jsonReader, f10);
                                        continue block14;
                                    }
                                    case 2: {
                                        object2 = valueParser2.parse(jsonReader2, f16);
                                        continue block14;
                                    }
                                    case 1: {
                                        object = valueParser2.parse(jsonReader2, f16);
                                        continue block14;
                                    }
                                    case 0: 
                                }
                                double d10 = jsonReader.nextDouble();
                                f11 = (float)d10;
                            }
                            jsonReader.endObject();
                            if (n10 == 0) break block19;
                            interpolator2 = interpolator4 = LINEAR_INTERPOLATOR;
                            jsonReader$Options = object;
                            break block20;
                        }
                        if (pointF3 == null || var16_36 == null) break block21;
                        float f18 = pointF3.x;
                        float f19 = -f16;
                        pointF3.x = f18 = MiscUtils.clamp(f18, f19, f16);
                        f18 = pointF3.y;
                        f15 = -100.0f;
                        n10 = 1120403456;
                        f12 = 100.0f;
                        pointF3.y = f18 = MiscUtils.clamp(f18, f15, f12);
                        var16_36.x = f18 = MiscUtils.clamp(var16_36.x, f19, f16);
                        var16_36.y = f18 = MiscUtils.clamp(var16_36.y, f15, f12);
                        f19 = pointF3.x;
                        f15 = pointF3.y;
                        f12 = var16_36.x;
                        int n12 = Utils.hashFor(f19, f15, f12, f18);
                        WeakReference weakReference = KeyframeParser.getInterpolator(n12);
                        if (weakReference != null) {
                            Object var11_25 = var8_21 = weakReference.get();
                            Interpolator interpolator5 = var8_21;
                        }
                        if (weakReference != null && var11_27 != null) break block18;
                        pointF3.x = f18 = pointF3.x / f16;
                        pointF3.y = f18 = pointF3.y / f16;
                        var16_36.x = f18 = var16_36.x / f16;
                        var16_36.y = f15 = var16_36.y / f16;
                        try {
                            f16 = pointF3.x;
                            f13 = pointF3.y;
                            Interpolator interpolator6 = PathInterpolatorCompat.create(f16, f13, f18, f15);
                        }
                        catch (IllegalArgumentException illegalArgumentException) {
                            String string2 = illegalArgumentException.getMessage();
                            String string3 = "The Path cannot loop back on itself.";
                            boolean bl2 = string2.equals(string3);
                            if (bl2) {
                                f18 = Math.min(pointF3.x, 1.0f);
                                f16 = pointF3.y;
                                f15 = Math.max(var16_36.x, 0.0f);
                                f14 = var16_36.y;
                                Interpolator interpolator7 = PathInterpolatorCompat.create(f18, f16, f15, f14);
                            }
                            LinearInterpolator linearInterpolator = new LinearInterpolator();
                        }
                        void var11_28 = var4_11;
                        try {
                            WeakReference<void> weakReference2 = new WeakReference<void>(var11_28);
                            KeyframeParser.putInterpolator(n12, weakReference2);
                            break block18;
                        }
                        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {}
                    }
                    interpolator2 = interpolator3 = LINEAR_INTERPOLATOR;
                    break block22;
                }
                interpolator2 = var11_29;
            }
            jsonReader$Options = object2;
        }
        Keyframe keyframe2 = keyframe;
        object2 = lottieComposition;
        PointF pointF5 = pointF2;
        keyframe = new Keyframe(lottieComposition, object, jsonReader$Options, interpolator2, f11, null);
        keyframe.pathCp1 = pointF;
        keyframe.pathCp2 = pointF2;
        return keyframe;
    }

    private static Keyframe parseStaticValue(JsonReader object, float f10, ValueParser valueParser) {
        object = valueParser.parse((JsonReader)object, f10);
        Keyframe keyframe = new Keyframe(object);
        return keyframe;
    }

    private static SparseArrayCompat pathInterpolatorCache() {
        SparseArrayCompat sparseArrayCompat = pathInterpolatorCache;
        if (sparseArrayCompat == null) {
            pathInterpolatorCache = sparseArrayCompat = new SparseArrayCompat();
        }
        return pathInterpolatorCache;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void putInterpolator(int n10, WeakReference weakReference) {
        Class<KeyframeParser> clazz = KeyframeParser.class;
        synchronized (clazz) {
            SparseArrayCompat sparseArrayCompat = pathInterpolatorCache;
            sparseArrayCompat.put(n10, weakReference);
            return;
        }
    }
}

