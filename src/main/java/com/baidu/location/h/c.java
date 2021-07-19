/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.location.h;

import java.io.Serializable;
import java.util.ArrayList;

public class c {
    public static int a(ArrayList arrayList) {
        int n10;
        int n11 = 0;
        for (int i10 = 0; i10 < (n10 = arrayList.size()); ++i10) {
            Float f10 = (Float)((ArrayList)arrayList.get(i10)).get(2);
            float f11 = f10.floatValue();
            float f12 = f11 - 0.0f;
            n10 = (int)(f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1));
            if (n10 <= 0) continue;
            ++n11;
        }
        return n11;
    }

    public static int b(ArrayList arrayList) {
        int n10;
        int n11 = 0;
        for (int i10 = 0; i10 < (n10 = arrayList.size()); ++i10) {
            float f10;
            Float f11 = (Float)((ArrayList)arrayList.get(i10)).get(2);
            float f12 = f11.floatValue();
            float f13 = f12 - (f10 = 15.0f);
            n10 = (int)(f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1));
            if (n10 < 0) continue;
            ++n11;
        }
        return n11;
    }

    public static int c(ArrayList arrayList) {
        int n10;
        int n11 = 0;
        for (int i10 = 0; i10 < (n10 = arrayList.size()); ++i10) {
            float f10;
            Float f11 = (Float)((ArrayList)arrayList.get(i10)).get(2);
            float f12 = f11.floatValue();
            float f13 = f12 - (f10 = 20.0f);
            n10 = (int)(f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1));
            if (n10 < 0) continue;
            ++n11;
        }
        return n11;
    }

    public static int d(ArrayList arrayList) {
        int n10;
        float f10 = 0.0f;
        for (int i10 = 0; i10 < (n10 = arrayList.size()); ++i10) {
            Serializable serializable = (ArrayList)arrayList.get(i10);
            int n11 = 2;
            float f11 = ((Float)(serializable = (Float)((ArrayList)serializable).get(n11))).floatValue();
            float f12 = f11 - 0.0f;
            n10 = (int)(f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1));
            if (n10 <= 0) continue;
            serializable = (Float)((ArrayList)arrayList.get(i10)).get(n11);
            f11 = ((Float)serializable).floatValue();
            f10 += f11;
        }
        return Math.round(f10);
    }

    public static int e(ArrayList arrayList) {
        float f10 = c.d(arrayList);
        float f11 = c.a(arrayList);
        return Math.round(f10 / f11);
    }

    public static int f(ArrayList arrayList) {
        int n10;
        float f10 = 0.0f;
        for (int i10 = 0; i10 < (n10 = arrayList.size()); ++i10) {
            Serializable serializable = (ArrayList)arrayList.get(i10);
            int n11 = 2;
            float f11 = 2.8E-45f;
            float f12 = ((Float)(serializable = (Float)((ArrayList)serializable).get(n11))).floatValue();
            float f13 = f12 - 0.0f;
            n10 = (int)(f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1));
            if (n10 <= 0) continue;
            serializable = (Float)((ArrayList)arrayList.get(i10)).get(n11);
            f12 = ((Float)serializable).floatValue();
            Serializable serializable2 = (ArrayList)arrayList.get(i10);
            int n12 = 1;
            serializable2 = (Float)((ArrayList)serializable2).get(n12);
            f11 = ((Float)serializable2).floatValue();
            f10 += (f12 *= f11);
        }
        return Math.round(f10);
    }

    public static int g(ArrayList arrayList) {
        int n10 = c.a(arrayList);
        float f10 = c.f(arrayList);
        float f11 = n10;
        return Math.round(f10 / f11);
    }

    public static int h(ArrayList arrayList) {
        int n10;
        int n11;
        int n12 = 37;
        int[] nArray = new int[n12];
        int n13 = 0;
        int n14 = 0;
        while (true) {
            int n15;
            int n16 = arrayList.size();
            if (n14 >= n16) break;
            Float f10 = (Float)((ArrayList)arrayList.get(n14)).get(0);
            float f11 = f10.floatValue();
            float f12 = 10.0f;
            double d10 = Math.ceil(f11 /= f12);
            n16 = (int)d10;
            nArray[n16] = n15 = nArray[n16] + n11;
            ++n14;
        }
        for (n11 = 1; n11 <= (n10 = 36); ++n11) {
            n10 = nArray[n11];
            if (n10 <= 0) continue;
            ++n13;
        }
        return Math.round((float)n13 / 36.0f * 1000.0f);
    }
}

