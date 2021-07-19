/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 */
package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.parser.JsonUtils;
import com.airbnb.lottie.parser.ValueParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader$Options;
import com.airbnb.lottie.parser.moshi.JsonReader$Token;
import com.airbnb.lottie.utils.MiscUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShapeDataParser
implements ValueParser {
    public static final ShapeDataParser INSTANCE;
    private static final JsonReader$Options NAMES;

    static {
        ShapeDataParser shapeDataParser;
        INSTANCE = shapeDataParser = new ShapeDataParser();
        NAMES = JsonReader$Options.of("c", "v", "i", "o");
    }

    private ShapeDataParser() {
    }

    public ShapeData parse(JsonReader object, float f10) {
        Object object2;
        int n10;
        Object object3;
        Object object4 = ((JsonReader)object).peek();
        if (object4 == (object3 = JsonReader$Token.BEGIN_ARRAY)) {
            ((JsonReader)object).beginArray();
        }
        ((JsonReader)object).beginObject();
        object4 = null;
        object3 = null;
        List list = null;
        List list2 = null;
        boolean bl2 = false;
        while (true) {
            int n11 = ((JsonReader)object).hasNext();
            n10 = 1;
            if (n11 == 0) break;
            object2 = NAMES;
            n11 = ((JsonReader)object).selectName((JsonReader$Options)object2);
            if (n11 != 0) {
                if (n11 != n10) {
                    n10 = 2;
                    if (n11 != n10) {
                        n10 = 3;
                        if (n11 != n10) {
                            ((JsonReader)object).skipName();
                            ((JsonReader)object).skipValue();
                            continue;
                        }
                        list2 = JsonUtils.jsonToPoints((JsonReader)object, f10);
                        continue;
                    }
                    list = JsonUtils.jsonToPoints((JsonReader)object, f10);
                    continue;
                }
                object4 = JsonUtils.jsonToPoints((JsonReader)object, f10);
                continue;
            }
            bl2 = ((JsonReader)object).nextBoolean();
        }
        ((JsonReader)object).endObject();
        JsonReader$Token jsonReader$Token = ((JsonReader)object).peek();
        object2 = JsonReader$Token.END_ARRAY;
        if (jsonReader$Token == object2) {
            ((JsonReader)object).endArray();
        }
        if (object4 != null && list != null && list2 != null) {
            int n12 = object4.isEmpty();
            if (n12 != 0) {
                jsonReader$Token = new PointF();
                object4 = Collections.emptyList();
                object = new ShapeData((PointF)jsonReader$Token, false, (List)object4);
                return object;
            }
            n12 = object4.size();
            jsonReader$Token = (PointF)object4.get(0);
            object2 = new ArrayList(n12);
            for (int i10 = n10; i10 < n12; ++i10) {
                PointF pointF = (PointF)object4.get(i10);
                int n13 = i10 + -1;
                PointF pointF2 = (PointF)object4.get(n13);
                PointF pointF3 = (PointF)list2.get(n13);
                Object object5 = (PointF)list.get(i10);
                pointF3 = MiscUtils.addPoints(pointF2, pointF3);
                pointF2 = MiscUtils.addPoints(pointF, object5);
                object5 = new CubicCurveData(pointF3, pointF2, pointF);
                object2.add(object5);
            }
            if (bl2) {
                PointF pointF = (PointF)object4.get(0);
                object4 = (PointF)object4.get(n12 -= n10);
                object = (PointF)list2.get(n12);
                object3 = (PointF)list.get(0);
                object = MiscUtils.addPoints((PointF)object4, (PointF)object);
                object4 = MiscUtils.addPoints(pointF, (PointF)object3);
                object3 = new CubicCurveData((PointF)object, (PointF)object4, pointF);
                object2.add(object3);
            }
            object = new ShapeData((PointF)jsonReader$Token, bl2, (List)object2);
            return object;
        }
        object = new IllegalArgumentException("Shape data was missing information.");
        throw object;
    }
}

