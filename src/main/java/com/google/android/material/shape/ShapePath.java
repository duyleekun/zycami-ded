/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 *  android.graphics.Path
 */
package com.google.android.material.shape;

import android.graphics.Matrix;
import android.graphics.Path;
import com.google.android.material.shape.ShapePath$PathArcOperation;
import com.google.android.material.shape.ShapePath$PathLineOperation;
import com.google.android.material.shape.ShapePath$PathOperation;
import com.google.android.material.shape.ShapePath$PathQuadOperation;
import java.util.ArrayList;
import java.util.List;

public class ShapePath {
    public float endX;
    public float endY;
    private final List operations;
    public float startX;
    public float startY;

    public ShapePath() {
        ArrayList arrayList;
        this.operations = arrayList = new ArrayList();
        this.reset(0.0f, 0.0f);
    }

    public ShapePath(float f10, float f11) {
        ArrayList arrayList;
        this.operations = arrayList = new ArrayList();
        this.reset(f10, f11);
    }

    public void addArc(float f10, float f11, float f12, float f13, float f14, float f15) {
        ShapePath$PathArcOperation shapePath$PathArcOperation = new ShapePath$PathArcOperation(f10, f11, f12, f13);
        shapePath$PathArcOperation.startAngle = f14;
        shapePath$PathArcOperation.sweepAngle = f15;
        this.operations.add(shapePath$PathArcOperation);
        float f16 = f10 + f12;
        float f17 = 0.5f;
        f16 *= f17;
        f12 -= f10;
        f10 = 2.0f;
        f12 /= f10;
        double d10 = f14 + f15;
        float f18 = (float)Math.cos(Math.toRadians(d10));
        this.endX = f16 += (f12 *= f18);
        f12 = (f11 + f13) * f17;
        f13 = (f13 - f11) / f10;
        f10 = (float)Math.sin(Math.toRadians(d10));
        this.endY = f12 += (f13 *= f10);
    }

    public void applyToPath(Matrix matrix, Path path) {
        List list = this.operations;
        int n10 = list.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            ShapePath$PathOperation shapePath$PathOperation = (ShapePath$PathOperation)this.operations.get(i10);
            shapePath$PathOperation.applyToPath(matrix, path);
        }
    }

    public void lineTo(float f10, float f11) {
        ShapePath$PathLineOperation shapePath$PathLineOperation = new ShapePath$PathLineOperation();
        ShapePath$PathLineOperation.access$002(shapePath$PathLineOperation, f10);
        ShapePath$PathLineOperation.access$102(shapePath$PathLineOperation, f11);
        this.operations.add(shapePath$PathLineOperation);
        this.endX = f10;
        this.endY = f11;
    }

    public void quadToPoint(float f10, float f11, float f12, float f13) {
        ShapePath$PathQuadOperation shapePath$PathQuadOperation = new ShapePath$PathQuadOperation();
        shapePath$PathQuadOperation.controlX = f10;
        shapePath$PathQuadOperation.controlY = f11;
        shapePath$PathQuadOperation.endX = f12;
        shapePath$PathQuadOperation.endY = f13;
        this.operations.add(shapePath$PathQuadOperation);
        this.endX = f12;
        this.endY = f13;
    }

    public void reset(float f10, float f11) {
        this.startX = f10;
        this.startY = f11;
        this.endX = f10;
        this.endY = f11;
        this.operations.clear();
    }
}

