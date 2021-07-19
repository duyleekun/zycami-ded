/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Color
 *  android.graphics.Rect
 */
package com.airbnb.lottie.parser;

import android.graphics.Color;
import android.graphics.Rect;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTextFrame;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.model.layer.Layer$LayerType;
import com.airbnb.lottie.model.layer.Layer$MatteType;
import com.airbnb.lottie.parser.AnimatableTextPropertiesParser;
import com.airbnb.lottie.parser.AnimatableTransformParser;
import com.airbnb.lottie.parser.AnimatableValueParser;
import com.airbnb.lottie.parser.ContentModelParser;
import com.airbnb.lottie.parser.LayerParser$1;
import com.airbnb.lottie.parser.MaskParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader$Options;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LayerParser {
    private static final JsonReader$Options EFFECTS_NAMES;
    private static final JsonReader$Options NAMES;
    private static final JsonReader$Options TEXT_NAMES;

    static {
        NAMES = JsonReader$Options.of("nm", "ind", "refId", "ty", "parent", "sw", "sh", "sc", "ks", "tt", "masksProperties", "shapes", "t", "ef", "sr", "st", "w", "h", "ip", "op", "tm", "cl", "hd");
        TEXT_NAMES = JsonReader$Options.of("d", "a");
        EFFECTS_NAMES = JsonReader$Options.of("nm");
    }

    private LayerParser() {
    }

    public static Layer parse(LottieComposition lottieComposition) {
        Rect rect = lottieComposition.getBounds();
        List list = Collections.emptyList();
        Layer$LayerType layer$LayerType = Layer$LayerType.PRE_COMP;
        List list2 = Collections.emptyList();
        AnimatableTransform animatableTransform = new AnimatableTransform();
        int n10 = rect.width();
        int n11 = rect.height();
        List list3 = Collections.emptyList();
        Layer$MatteType layer$MatteType = Layer$MatteType.NONE;
        Layer layer = new Layer(list, lottieComposition, "__container", -1, layer$LayerType, -1, null, list2, animatableTransform, 0, 0, 0, 0.0f, 0.0f, n10, n11, null, null, list3, layer$MatteType, null, false);
        return layer;
    }

    public static Layer parse(JsonReader object, LottieComposition lottieComposition) {
        Layer layer;
        float f10;
        float f11;
        Layer$MatteType[] layer$MatteTypeArray;
        long l10;
        int n10;
        Object object2;
        float f12;
        int n11;
        Object object3 = object;
        LottieComposition lottieComposition2 = lottieComposition;
        Object object4 = Layer$MatteType.NONE;
        Layer$MatteType[] layer$MatteTypeArray2 = new ArrayList();
        ArrayList<Object> arrayList = new ArrayList<Object>();
        ((JsonReader)object).beginObject();
        float f13 = 1.0f;
        Object object5 = Float.valueOf(f13);
        Object object6 = 0;
        float f14 = 0.0f;
        Object object7 = null;
        Object object8 = null;
        Float f15 = Float.valueOf(0.0f);
        Object object9 = "UNSET";
        long l11 = 0L;
        Layer$MatteType layer$MatteType = object4;
        float f16 = f13;
        int n112 = 0;
        int n12 = 0;
        boolean bl2 = false;
        int n13 = 0;
        int n14 = 0;
        boolean bl3 = false;
        Layer$LayerType layer$LayerType = null;
        Object object10 = null;
        Layer$MatteType[] layer$MatteTypeArray3 = null;
        AnimatableTextFrame animatableTextFrame = null;
        Object object11 = null;
        AnimatableFloatValue animatableFloatValue = null;
        object4 = null;
        float f17 = 0.0f;
        f13 = 0.0f;
        float f18 = 0.0f;
        long l12 = -1;
        long l13 = l11;
        int n15 = 0;
        String string2 = null;
        String string3 = object9;
        block25: while ((object6 = ((JsonReader)object).hasNext()) != 0) {
            object7 = NAMES;
            object6 = ((JsonReader)object3).selectName((JsonReader$Options)object7);
            n11 = 1;
            f12 = Float.MIN_VALUE;
            switch (object6) {
                default: {
                    ((JsonReader)object).skipName();
                    ((JsonReader)object).skipValue();
                    continue block25;
                }
                case 22: {
                    bl3 = ((JsonReader)object).nextBoolean();
                    continue block25;
                }
                case 21: {
                    string2 = ((JsonReader)object).nextString();
                    continue block25;
                }
                case 20: {
                    animatableFloatValue = AnimatableValueParser.parseFloat((JsonReader)object3, lottieComposition2, false);
                    continue block25;
                }
                case 19: {
                    double d10 = ((JsonReader)object).nextDouble();
                    f13 = (float)d10;
                    continue block25;
                }
                case 18: {
                    double d10 = ((JsonReader)object).nextDouble();
                    f17 = (float)d10;
                    continue block25;
                }
                case 17: {
                    f14 = ((JsonReader)object).nextInt();
                    f12 = Utils.dpScale();
                    n14 = object6 = (int)(f14 *= f12);
                    continue block25;
                }
                case 16: {
                    f14 = ((JsonReader)object).nextInt();
                    f12 = Utils.dpScale();
                    n13 = object6 = (int)(f14 *= f12);
                    continue block25;
                }
                case 15: {
                    double d10 = ((JsonReader)object).nextDouble();
                    f18 = f14 = (float)d10;
                    continue block25;
                }
                case 14: {
                    double d10 = ((JsonReader)object).nextDouble();
                    f16 = f14 = (float)d10;
                    continue block25;
                }
                case 13: {
                    ((JsonReader)object).beginArray();
                    object7 = new ArrayList();
                    while ((n11 = (int)(((JsonReader)object).hasNext() ? 1 : 0)) != 0) {
                        ((JsonReader)object).beginObject();
                        while ((n11 = (int)(((JsonReader)object).hasNext() ? 1 : 0)) != 0) {
                            object9 = EFFECTS_NAMES;
                            n11 = ((JsonReader)object3).selectName((JsonReader$Options)object9);
                            if (n11 != 0) {
                                ((JsonReader)object).skipName();
                                ((JsonReader)object).skipValue();
                                continue;
                            }
                            object9 = ((JsonReader)object).nextString();
                            object7.add(object9);
                        }
                        ((JsonReader)object).endObject();
                    }
                    ((JsonReader)object).endArray();
                    object9 = new StringBuilder();
                    object2 = "Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: ";
                    ((StringBuilder)object9).append((String)object2);
                    ((StringBuilder)object9).append(object7);
                    object7 = ((StringBuilder)object9).toString();
                    lottieComposition2.addWarning((String)object7);
                    continue block25;
                }
                case 12: {
                    ((JsonReader)object).beginObject();
                    while ((object6 = (Object)((JsonReader)object).hasNext()) != 0) {
                        object7 = TEXT_NAMES;
                        object6 = ((JsonReader)object3).selectName((JsonReader$Options)object7);
                        if (object6 != 0) {
                            if (object6 != n11) {
                                ((JsonReader)object).skipName();
                                ((JsonReader)object).skipValue();
                                continue;
                            }
                            ((JsonReader)object).beginArray();
                            object6 = ((JsonReader)object).hasNext();
                            if (object6 != 0) {
                                object11 = object7 = AnimatableTextPropertiesParser.parse((JsonReader)object, lottieComposition);
                            }
                            while ((object6 = (Object)((JsonReader)object).hasNext()) != 0) {
                                ((JsonReader)object).skipValue();
                            }
                            ((JsonReader)object).endArray();
                            continue;
                        }
                        animatableTextFrame = AnimatableValueParser.parseDocumentData((JsonReader)object, lottieComposition);
                    }
                    ((JsonReader)object).endObject();
                    continue block25;
                }
                case 11: {
                    ((JsonReader)object).beginArray();
                    while ((object6 = (Object)((JsonReader)object).hasNext()) != 0) {
                        object7 = ContentModelParser.parse((JsonReader)object, lottieComposition);
                        if (object7 == null) continue;
                        arrayList.add(object7);
                    }
                    ((JsonReader)object).endArray();
                    continue block25;
                }
                case 10: {
                    ((JsonReader)object).beginArray();
                    while ((object6 = (Object)((JsonReader)object).hasNext()) != 0) {
                        object7 = MaskParser.parse((JsonReader)object, lottieComposition);
                        layer$MatteTypeArray2.add(object7);
                    }
                    object6 = layer$MatteTypeArray2.size();
                    lottieComposition2.incrementMatteOrMaskCount((int)object6);
                    ((JsonReader)object).endArray();
                    continue block25;
                }
                case 9: {
                    object6 = ((JsonReader)object).nextInt();
                    object2 = Layer$MatteType.values();
                    int n16 = ((Layer$MatteType[])object2).length;
                    if (object6 >= n16) {
                        object9 = new StringBuilder();
                        object2 = "Unsupported matte type: ";
                        ((StringBuilder)object9).append((String)object2);
                        ((StringBuilder)object9).append((int)object6);
                        object7 = ((StringBuilder)object9).toString();
                        lottieComposition2.addWarning((String)object7);
                        continue block25;
                    }
                    object7 = LayerParser$1.$SwitchMap$com$airbnb$lottie$model$layer$Layer$MatteType;
                    object2 = Layer$MatteType.values();
                    layer$MatteType = object2[object6];
                    n16 = layer$MatteType.ordinal();
                    object6 = object7[n16];
                    if (object6 != n11) {
                        n16 = 2;
                        if (object6 == n16) {
                            object7 = "Unsupported matte type: Luma Inverted";
                            lottieComposition2.addWarning((String)object7);
                        }
                    } else {
                        object7 = "Unsupported matte type: Luma";
                        lottieComposition2.addWarning((String)object7);
                    }
                    lottieComposition2.incrementMatteOrMaskCount(n11);
                    continue block25;
                }
                case 8: {
                    layer$MatteTypeArray3 = AnimatableTransformParser.parse((JsonReader)object, lottieComposition);
                    continue block25;
                }
                case 7: {
                    object7 = ((JsonReader)object).nextString();
                    n10 = Color.parseColor((String)object7);
                    continue block25;
                }
                case 6: {
                    f14 = ((JsonReader)object).nextInt();
                    f12 = Utils.dpScale();
                    n12 = object6 = (int)(f14 *= f12);
                    continue block25;
                }
                case 5: {
                    f14 = ((JsonReader)object).nextInt();
                    f12 = Utils.dpScale();
                    n112 = object6 = (int)(f14 *= f12);
                    continue block25;
                }
                case 4: {
                    object6 = ((JsonReader)object).nextInt();
                    l12 = l10 = (long)object6;
                    continue block25;
                }
                case 3: {
                    object6 = ((JsonReader)object).nextInt();
                    if (object6 >= (n11 = (layer$LayerType = Layer$LayerType.UNKNOWN).ordinal())) continue block25;
                    object9 = Layer$LayerType.values();
                    layer$LayerType = object9[object6];
                    continue block25;
                }
                case 2: {
                    object10 = ((JsonReader)object).nextString();
                    continue block25;
                }
                case 1: {
                    object6 = ((JsonReader)object).nextInt();
                    l13 = l10 = (long)object6;
                    continue block25;
                }
                case 0: 
            }
            string3 = ((JsonReader)object).nextString();
        }
        ((JsonReader)object).endObject();
        float f19 = f17 / f16;
        float f20 = f13 / f16;
        object2 = new ArrayList();
        float f21 = f19 - 0.0f;
        float f22 = f21 == 0.0f ? 0 : (f21 > 0.0f ? 1 : -1);
        if (f22 > 0) {
            object6 = 0;
            f14 = 0.0f;
            object7 = null;
            Float f23 = Float.valueOf(f19);
            object3 = object9;
            object4 = lottieComposition;
            object8 = object9;
            n11 = 0;
            object9 = null;
            f12 = 0.0f;
            layer$MatteTypeArray = layer$MatteTypeArray2;
            layer$MatteTypeArray2 = object2;
            object2 = f23;
            ((Keyframe)object3)(lottieComposition, f15, f15, null, 0.0f, f23);
            layer$MatteTypeArray2.add(object3);
            f22 = 0.0f;
            f11 = 0.0f;
            object3 = null;
        } else {
            layer$MatteTypeArray = layer$MatteTypeArray2;
            layer$MatteTypeArray2 = object2;
            f22 = 0.0f;
            object3 = null;
            f11 = 0.0f;
        }
        f22 = (f10 = f20 - 0.0f) == 0.0f ? 0 : (f10 > 0.0f ? 1 : -1);
        if (f22 <= 0) {
            f20 = f11 = lottieComposition.getEndFrame();
        }
        object6 = 0;
        f14 = 0.0f;
        object7 = null;
        object2 = Float.valueOf(f20);
        object3 = object8;
        object4 = lottieComposition;
        f12 = f19;
        object8 = new Keyframe(lottieComposition, object5, object5, null, f19, (Float)object2);
        layer$MatteTypeArray2.add(object8);
        f11 = Float.MAX_VALUE;
        object2 = Float.valueOf(f11);
        object3 = object5;
        f12 = f20;
        object5 = new Keyframe(lottieComposition, f15, f15, null, f20, (Float)object2);
        layer$MatteTypeArray2.add(object5);
        object3 = ".ai";
        f22 = (float)string3.endsWith((String)object3);
        if (f22 != false || (f22 = (float)((String)(object3 = "ai")).equals(string2)) != false) {
            object3 = "Convert your Illustrator layers to shape layers.";
            lottieComposition2.addWarning((String)object3);
        }
        object3 = layer;
        object4 = arrayList;
        l10 = l13;
        object2 = layer$LayerType;
        object5 = object10;
        Layer$MatteType[] layer$MatteTypeArray4 = layer$MatteTypeArray2;
        layer$MatteTypeArray2 = layer$MatteTypeArray;
        object8 = layer$MatteTypeArray3;
        n15 = n10;
        object10 = object11;
        layer$MatteTypeArray3 = layer$MatteTypeArray4;
        boolean bl4 = bl3;
        layer = new Layer(arrayList, lottieComposition, string3, l13, layer$LayerType, l12, (String)object5, (List)layer$MatteTypeArray, (AnimatableTransform)object8, n112, n12, n15, f16, f18, n13, n14, animatableTextFrame, (AnimatableTextProperties)object11, (List)layer$MatteTypeArray4, layer$MatteType, animatableFloatValue, bl3);
        return layer;
    }
}

