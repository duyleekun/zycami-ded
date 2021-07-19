/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Color
 */
package com.airbnb.lottie.parser;

import android.graphics.Color;
import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.parser.ValueParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader$Token;
import com.airbnb.lottie.utils.MiscUtils;
import java.util.ArrayList;
import java.util.List;

public class GradientColorParser
implements ValueParser {
    private int colorPoints;

    public GradientColorParser(int n10) {
        this.colorPoints = n10;
    }

    private void addOpacityStopsToGradientIfNeeded(GradientColor gradientColor, List object) {
        Object object2;
        int n10;
        int n11;
        int n12 = object.size();
        if (n12 <= n11) {
            return;
        }
        n12 = (object.size() - n11) / 2;
        double[] dArray = new double[n12];
        double[] dArray2 = new double[n12];
        int n13 = 0;
        int n14 = 0;
        for (n11 = this.colorPoints * 4; n11 < (n10 = object.size()); ++n11) {
            double d10;
            float f10;
            Float f11;
            n10 = n11 % 2;
            if (n10 == 0) {
                f11 = (Float)object.get(n11);
                f10 = f11.floatValue();
                dArray[n14] = d10 = (double)f10;
                continue;
            }
            f11 = (Float)object.get(n11);
            f10 = f11.floatValue();
            dArray2[n14] = d10 = (double)f10;
            ++n14;
        }
        while (n13 < (object2 = gradientColor.getSize())) {
            object = gradientColor.getColors();
            object2 = object[n13];
            float f12 = gradientColor.getPositions()[n13];
            double d11 = f12;
            n11 = this.getOpacityAtPosition(d11, dArray, dArray2);
            n14 = Color.red((int)object2);
            n10 = Color.green((int)object2);
            object2 = Color.blue((int)object2);
            object2 = Color.argb((int)n11, (int)n14, (int)n10, (int)object2);
            int[] nArray = gradientColor.getColors();
            nArray[n13] = object2;
            ++n13;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private int getOpacityAtPosition(double d10, double[] dArray, double[] dArray2) {
        double d11;
        double d12;
        int n10;
        double[] dArray3 = dArray;
        double[] dArray4 = dArray2;
        int n11 = n10 = 1;
        while (true) {
            int n12 = dArray3.length;
            d12 = 255.0;
            if (n11 >= n12) break;
            n12 = n11 + -1;
            double d13 = dArray3[n12];
            double d14 = dArray3[n11];
            double d15 = dArray3[n11];
            double d16 = d15 - d10;
            Object object = d16 == 0.0 ? 0 : (d16 > 0.0 ? 1 : -1);
            if (object >= 0) {
                d15 = d10 - d13;
                double d17 = d15 / (d14 -= d13);
                double d18 = 0.0;
                double d19 = 1.0;
                d15 = MiscUtils.clamp(d17, d18, d19);
                d13 = dArray4[n12];
                d14 = dArray4[n11];
                d11 = MiscUtils.lerp(d13, d14, d15);
                return (int)(d11 * d12);
            }
            ++n11;
        }
        int n13 = dArray4.length - n10;
        d11 = dArray4[n13];
        return (int)(d11 * d12);
    }

    public GradientColor parse(JsonReader object, float f10) {
        int n10;
        int n11;
        float f11;
        int n12;
        int n13;
        ArrayList<JsonReader$Token> arrayList = new ArrayList<JsonReader$Token>();
        Object object2 = ((JsonReader)object).peek();
        Object object3 = JsonReader$Token.BEGIN_ARRAY;
        int n14 = 1;
        int n15 = 0;
        if (object2 == object3) {
            n13 = n14;
        } else {
            n13 = 0;
            object2 = null;
        }
        if (n13 != 0) {
            ((JsonReader)object).beginArray();
        }
        while ((n12 = ((JsonReader)object).hasNext()) != 0) {
            double d10 = ((JsonReader)object).nextDouble();
            f11 = (float)d10;
            object3 = Float.valueOf(f11);
            arrayList.add((JsonReader$Token)((Object)object3));
        }
        if (n13 != 0) {
            ((JsonReader)object).endArray();
        }
        if ((n11 = this.colorPoints) == (n13 = -1)) {
            this.colorPoints = n11 = arrayList.size() / 4;
        }
        n11 = this.colorPoints;
        object2 = new float[n11];
        object = new int[n11];
        n12 = 0;
        object3 = null;
        f11 = 0.0f;
        int n16 = 0;
        while (n15 < (n10 = this.colorPoints * 4)) {
            n10 = n15 / 4;
            Float f12 = (Float)arrayList.get(n15);
            float f13 = f12.floatValue();
            double d11 = f13;
            int n17 = n15 % 4;
            if (n17 != 0) {
                double d12 = 255.0;
                if (n17 != n14) {
                    int n18 = 2;
                    if (n17 != n18) {
                        n18 = 3;
                        if (n17 == n18) {
                            int n19 = (int)(d11 *= d12);
                            int n20 = 255;
                            n19 = Color.argb((int)n20, (int)n12, (int)n16, (int)n19);
                            object[n10] = n19;
                        }
                    } else {
                        n16 = (int)(d11 *= d12);
                    }
                } else {
                    n12 = (int)(d11 *= d12);
                }
            } else {
                f13 = (float)d11;
                object2[n10] = (JsonReader$Token)f13;
            }
            ++n15;
        }
        object3 = new GradientColor((float[])object2, (int[])object);
        this.addOpacityStopsToGradientIfNeeded((GradientColor)object3, arrayList);
        return object3;
    }
}

