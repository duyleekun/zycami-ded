/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Path
 *  android.graphics.PointF
 */
package com.airbnb.lottie.utils;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.animation.content.KeyPathElementContent;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.ShapeData;
import java.util.List;

public class MiscUtils {
    private static PointF pathFromDataCurrentPoint;

    static {
        PointF pointF;
        pathFromDataCurrentPoint = pointF = new PointF();
    }

    public static PointF addPoints(PointF pointF, PointF pointF2) {
        float f10 = pointF.x;
        float f11 = pointF2.x;
        float f12 = pointF.y;
        float f13 = pointF2.y;
        PointF pointF3 = new PointF(f10 += f11, f12 += f13);
        return pointF3;
    }

    public static double clamp(double d10, double d11, double d12) {
        d10 = Math.min(d12, d10);
        return Math.max(d11, d10);
    }

    public static float clamp(float f10, float f11, float f12) {
        f10 = Math.min(f12, f10);
        return Math.max(f11, f10);
    }

    public static int clamp(int n10, int n11, int n12) {
        n10 = Math.min(n12, n10);
        return Math.max(n11, n10);
    }

    public static boolean contains(float f10, float f11, float f12) {
        boolean bl2;
        Object object = f10 == f11 ? 0 : (f10 > f11 ? 1 : -1);
        if (object >= 0 && (bl2 = f10 == f12 ? 0 : (f10 < f12 ? -1 : 1)) <= false) {
            bl2 = true;
            f10 = Float.MIN_VALUE;
        } else {
            bl2 = false;
            f10 = 0.0f;
        }
        return bl2;
    }

    private static int floorDiv(int n10, int n11) {
        int n12 = n10 / n11;
        int n13 = n10 ^ n11;
        n13 = n13 >= 0 ? 1 : 0;
        if (n13 == 0 && (n10 %= n11) != 0) {
            n12 += -1;
        }
        return n12;
    }

    public static int floorMod(float f10, float f11) {
        int n10 = (int)f10;
        int n11 = (int)f11;
        return MiscUtils.floorMod(n10, n11);
    }

    private static int floorMod(int n10, int n11) {
        int n12 = MiscUtils.floorDiv(n10, n11);
        return n10 - (n11 *= n12);
    }

    public static void getPathFromData(ShapeData shapeData, Path path) {
        int n10;
        path.reset();
        PointF pointF = shapeData.getInitialPoint();
        float f10 = pointF.x;
        float f11 = pointF.y;
        path.moveTo(f10, f11);
        Object object = pathFromDataCurrentPoint;
        f11 = pointF.x;
        float f12 = pointF.y;
        object.set(f11, f12);
        f12 = 0.0f;
        pointF = null;
        for (int i10 = 0; i10 < (n10 = (object = shapeData.getCurves()).size()); ++i10) {
            float f13;
            object = (CubicCurveData)shapeData.getCurves().get(i10);
            PointF pointF2 = ((CubicCurveData)object).getControlPoint1();
            PointF pointF3 = ((CubicCurveData)object).getControlPoint2();
            object = ((CubicCurveData)object).getVertex();
            PointF pointF4 = pathFromDataCurrentPoint;
            boolean bl2 = pointF2.equals((Object)pointF4);
            if (bl2 && (bl2 = pointF3.equals(object))) {
                f11 = ((PointF)object).x;
                f13 = ((PointF)object).y;
                path.lineTo(f11, f13);
            } else {
                float f14 = pointF2.x;
                float f15 = pointF2.y;
                float f16 = pointF3.x;
                float f17 = pointF3.y;
                float f18 = ((PointF)object).x;
                float f19 = ((PointF)object).y;
                pointF4 = path;
                path.cubicTo(f14, f15, f16, f17, f18, f19);
            }
            pointF2 = pathFromDataCurrentPoint;
            f13 = ((PointF)object).x;
            f10 = ((PointF)object).y;
            pointF2.set(f13, f10);
        }
        boolean bl3 = shapeData.isClosed();
        if (bl3) {
            path.close();
        }
    }

    public static double lerp(double d10, double d11, double d12) {
        return d10 + (d12 *= (d11 -= d10));
    }

    public static float lerp(float f10, float f11, float f12) {
        return f10 + (f12 *= (f11 -= f10));
    }

    public static int lerp(int n10, int n11, float f10) {
        float f11 = n10;
        float f12 = n11 - n10;
        return (int)(f11 + (f10 *= f12));
    }

    public static void resolveKeyPath(KeyPath object, int n10, List list, KeyPath keyPath, KeyPathElementContent keyPathElementContent) {
        String string2 = keyPathElementContent.getName();
        boolean bl2 = ((KeyPath)object).fullyResolvesTo(string2, n10);
        if (bl2) {
            object = keyPathElementContent.getName();
            object = keyPath.addKey((String)object).resolve(keyPathElementContent);
            list.add(object);
        }
    }
}

