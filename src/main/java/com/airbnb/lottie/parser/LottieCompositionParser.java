/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 */
package com.airbnb.lottie.parser;

import android.graphics.Rect;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.model.layer.Layer$LayerType;
import com.airbnb.lottie.parser.LayerParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader$Options;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LottieCompositionParser {
    public static JsonReader$Options NAMES = JsonReader$Options.of("w", "h", "ip", "op", "fr", "v", "layers", "assets", "fonts", "chars", "markers");

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public static LottieComposition parse(JsonReader jsonReader) {
        JsonReader jsonReader2 = jsonReader;
        float f10 = Utils.dpScale();
        LongSparseArray longSparseArray = new LongSparseArray();
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        Object object = new ArrayList();
        SparseArrayCompat sparseArrayCompat = new SparseArrayCompat();
        LottieComposition lottieComposition = new LottieComposition();
        jsonReader.beginObject();
        float f11 = 0.0f;
        float f12 = 0.0f;
        float f13 = 0.0f;
        int n10 = 0;
        int n11 = 0;
        while (true) {
            block13: {
                void var1_14;
                Object object2;
                block12: {
                    void var1_2;
                    Object object3;
                    boolean bl2;
                    if (!(bl2 = jsonReader.hasNext())) {
                        HashMap hashMap4 = hashMap3;
                        object2 = object;
                        n10 = (int)((float)n10 * f10);
                        int n12 = (int)((float)n11 * f10);
                        object3 = new Rect(0, 0, n10, n12);
                        lottieComposition.init((Rect)object3, f11, f12, f13, arrayList, longSparseArray, hashMap, hashMap2, sparseArrayCompat, hashMap3, (List)object);
                        return lottieComposition;
                    }
                    object3 = NAMES;
                    int n13 = var1_2.selectName((JsonReader$Options)object3);
                    switch (n13) {
                        case 6: {
                            LottieCompositionParser.parseLayers((JsonReader)var1_2, lottieComposition, arrayList, longSparseArray);
                        }
                        default: {
                            HashMap hashMap5 = hashMap3;
                            object2 = object;
                            break;
                        }
                        case 5: {
                            String[] stringArray = jsonReader.nextString().split("\\.");
                            object2 = stringArray[0];
                            int n14 = Integer.parseInt((String)object2);
                            object3 = stringArray[1];
                            int n15 = Integer.parseInt((String)object3);
                            n13 = 2;
                            float f14 = 2.8E-45f;
                            String string2 = stringArray[n13];
                            int n16 = Integer.parseInt(string2);
                            int n17 = 4;
                            int n18 = 4;
                            boolean bl3 = Utils.isAtLeastVersion(n14, n15, n16, n17, n18, 0);
                            if (!bl3) {
                                String string3 = "Lottie only supports bodymovin >= 4.4.0";
                                lottieComposition.addWarning(string3);
                            }
                            HashMap hashMap6 = hashMap3;
                            object2 = object;
                            break block12;
                        }
                        case 4: {
                            HashMap hashMap7 = hashMap3;
                            object2 = object;
                            double d10 = jsonReader.nextDouble();
                            f13 = (float)d10;
                            break block12;
                        }
                        case 3: {
                            HashMap hashMap8 = hashMap3;
                            object2 = object;
                            double d10 = jsonReader.nextDouble();
                            float f14 = (float)d10;
                            f12 = f14 - 0.01f;
                            break block12;
                        }
                        case 2: {
                            HashMap hashMap9 = hashMap3;
                            object2 = object;
                            double d11 = jsonReader.nextDouble();
                            f11 = (float)d11;
                            break block13;
                        }
                        case 1: {
                            HashMap hashMap10 = hashMap3;
                            object2 = object;
                            n11 = jsonReader.nextInt();
                            break block13;
                        }
                        case 0: {
                            HashMap hashMap11 = hashMap3;
                            object2 = object;
                            n10 = jsonReader.nextInt();
                            break block13;
                        }
                    }
                    jsonReader.skipValue();
                }
                hashMap3 = var1_14;
                object = object2;
            }
            JsonReader jsonReader3 = jsonReader;
        }
    }

    private static void parseLayers(JsonReader jsonReader, LottieComposition lottieComposition, List list, LongSparseArray longSparseArray) {
        int n10;
        jsonReader.beginArray();
        int n11 = 0;
        while ((n10 = jsonReader.hasNext()) != 0) {
            Layer$LayerType layer$LayerType;
            Object object = LayerParser.parse(jsonReader, lottieComposition);
            Object object2 = ((Layer)object).getLayerType();
            if (object2 == (layer$LayerType = Layer$LayerType.IMAGE)) {
                ++n11;
            }
            list.add(object);
            long l10 = ((Layer)object).getId();
            longSparseArray.put(l10, object);
            n10 = 4;
            if (n11 <= n10) continue;
            object = new StringBuilder();
            ((StringBuilder)object).append("You have ");
            ((StringBuilder)object).append(n11);
            object2 = " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.";
            ((StringBuilder)object).append((String)object2);
            object = ((StringBuilder)object).toString();
            Logger.warning((String)object);
        }
        jsonReader.endArray();
    }
}

