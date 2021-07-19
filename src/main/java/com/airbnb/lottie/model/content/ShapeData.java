/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 */
package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.MiscUtils;
import java.util.ArrayList;
import java.util.List;

public class ShapeData {
    private boolean closed;
    private final List curves;
    private PointF initialPoint;

    public ShapeData() {
        ArrayList arrayList;
        this.curves = arrayList = new ArrayList();
    }

    public ShapeData(PointF object, boolean bl2, List list) {
        this.initialPoint = object;
        this.closed = bl2;
        super(list);
        this.curves = object;
    }

    private void setInitialPoint(float f10, float f11) {
        PointF pointF = this.initialPoint;
        if (pointF == null) {
            this.initialPoint = pointF = new PointF();
        }
        this.initialPoint.set(f10, f11);
    }

    public List getCurves() {
        return this.curves;
    }

    public PointF getInitialPoint() {
        return this.initialPoint;
    }

    public void interpolateBetween(ShapeData shapeData, ShapeData shapeData2, float f10) {
        CubicCurveData cubicCurveData;
        Object object;
        float f11;
        Object object2 = this.initialPoint;
        if (object2 == null) {
            object2 = new PointF();
            this.initialPoint = object2;
        }
        int n10 = shapeData.isClosed();
        int n11 = 1;
        float f12 = Float.MIN_VALUE;
        if (n10 == 0 && (n10 = shapeData2.isClosed()) == 0) {
            n10 = 0;
            f11 = 0.0f;
            object2 = null;
        } else {
            n10 = n11;
            f11 = f12;
        }
        this.closed = n10;
        object2 = shapeData.getCurves();
        n10 = object2.size();
        Object object3 = shapeData2.getCurves();
        int n12 = object3.size();
        if (n10 != n12) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Curves must have the same number of control points. Shape 1: ");
            n12 = shapeData.getCurves().size();
            ((StringBuilder)object2).append(n12);
            ((StringBuilder)object2).append("\tShape 2: ");
            object3 = shapeData2.getCurves();
            n12 = object3.size();
            ((StringBuilder)object2).append(n12);
            object2 = ((StringBuilder)object2).toString();
            Logger.warning((String)object2);
        }
        object2 = shapeData.getCurves();
        n10 = object2.size();
        n12 = shapeData2.getCurves().size();
        n10 = Math.min(n10, n12);
        object3 = this.curves;
        n12 = object3.size();
        if (n12 < n10) {
            object3 = this.curves;
            for (n12 = object3.size(); n12 < n10; ++n12) {
                object = this.curves;
                cubicCurveData = new CubicCurveData();
                object.add(cubicCurveData);
            }
        } else {
            object3 = this.curves;
            n12 = object3.size();
            if (n12 > n10) {
                object3 = this.curves;
                for (n12 = object3.size() - n11; n12 >= n10; n12 += -1) {
                    object = this.curves;
                    int n13 = object.size() - n11;
                    object.remove(n13);
                }
            }
        }
        object2 = shapeData.getInitialPoint();
        object3 = shapeData2.getInitialPoint();
        float f13 = ((PointF)object2).x;
        float f14 = ((PointF)object3).x;
        f13 = MiscUtils.lerp(f13, f14, f10);
        f11 = ((PointF)object2).y;
        float f15 = ((PointF)object3).y;
        f11 = MiscUtils.lerp(f11, f15, f10);
        this.setInitialPoint(f13, f11);
        object2 = this.curves;
        for (n10 = object2.size() - n11; n10 >= 0; n10 += -1) {
            CubicCurveData cubicCurveData2 = (CubicCurveData)shapeData.getCurves().get(n10);
            object3 = (CubicCurveData)shapeData2.getCurves().get(n10);
            object = cubicCurveData2.getControlPoint1();
            cubicCurveData = cubicCurveData2.getControlPoint2();
            cubicCurveData2 = cubicCurveData2.getVertex();
            PointF pointF = ((CubicCurveData)object3).getControlPoint1();
            PointF pointF2 = ((CubicCurveData)object3).getControlPoint2();
            object3 = ((CubicCurveData)object3).getVertex();
            CubicCurveData cubicCurveData3 = (CubicCurveData)this.curves.get(n10);
            float f16 = ((PointF)object).x;
            float f17 = pointF.x;
            f16 = MiscUtils.lerp(f16, f17, f10);
            f13 = ((PointF)object).y;
            float f18 = pointF.y;
            f13 = MiscUtils.lerp(f13, f18, f10);
            cubicCurveData3.setControlPoint1(f16, f13);
            object = (CubicCurveData)this.curves.get(n10);
            f18 = ((PointF)cubicCurveData).x;
            float f19 = pointF2.x;
            f18 = MiscUtils.lerp(f18, f19, f10);
            f14 = ((PointF)cubicCurveData).y;
            float f20 = pointF2.y;
            f14 = MiscUtils.lerp(f14, f20, f10);
            ((CubicCurveData)object).setControlPoint2(f18, f14);
            object = (CubicCurveData)this.curves.get(n10);
            f14 = ((PointF)cubicCurveData2).x;
            f18 = ((PointF)object3).x;
            f14 = MiscUtils.lerp(f14, f18, f10);
            f12 = ((PointF)cubicCurveData2).y;
            f15 = ((PointF)object3).y;
            f12 = MiscUtils.lerp(f12, f15, f10);
            ((CubicCurveData)object).setVertex(f14, f12);
        }
    }

    public boolean isClosed() {
        return this.closed;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ShapeData{numCurves=");
        int bl2 = this.curves.size();
        stringBuilder.append(bl2);
        stringBuilder.append("closed=");
        boolean bl3 = this.closed;
        stringBuilder.append(bl3);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

