/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.RectF
 *  android.graphics.drawable.ShapeDrawable
 *  android.graphics.drawable.shapes.RoundRectShape
 *  android.graphics.drawable.shapes.Shape
 */
package cn.sharesdk.framework.utils;

import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;

public class j {
    public static ShapeDrawable a(float f10, int n10) {
        int n11 = 8;
        float[] fArray = new float[n11];
        float[] fArray2 = new float[n11];
        int n12 = 0;
        RectF rectF = null;
        while (true) {
            float f11 = 0.0f;
            if (n12 >= n11) break;
            fArray[n12] = f11 = 0.0f + f10;
            fArray2[n12] = f10;
            ++n12;
        }
        rectF = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        RoundRectShape roundRectShape = new RoundRectShape(fArray, rectF, fArray2);
        ShapeDrawable shapeDrawable = new ShapeDrawable((Shape)roundRectShape);
        shapeDrawable.getPaint().setColor(n10);
        return shapeDrawable;
    }
}

