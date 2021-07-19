/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.Path
 *  android.graphics.PointF
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffColorFilter
 *  android.graphics.Rect
 *  android.graphics.Region
 *  android.graphics.Region$Op
 *  android.graphics.drawable.Drawable
 */
package com.google.android.material.shape;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.TintAwareDrawable;
import com.google.android.material.shape.CornerTreatment;
import com.google.android.material.shape.EdgeTreatment;
import com.google.android.material.shape.ShapePath;
import com.google.android.material.shape.ShapePathModel;

public class MaterialShapeDrawable
extends Drawable
implements TintAwareDrawable {
    private int alpha;
    private final ShapePath[] cornerPaths;
    private final Matrix[] cornerTransforms;
    private final Matrix[] edgeTransforms;
    private float interpolation;
    private final Matrix matrix;
    private final Paint paint;
    private Paint.Style paintStyle;
    private final Path path;
    private final PointF pointF;
    private float scale;
    private final float[] scratch;
    private final float[] scratch2;
    private final Region scratchRegion;
    private int shadowColor;
    private int shadowElevation;
    private boolean shadowEnabled;
    private int shadowRadius;
    private final ShapePath shapePath;
    private ShapePathModel shapedViewModel;
    private float strokeWidth;
    private PorterDuffColorFilter tintFilter;
    private ColorStateList tintList;
    private PorterDuff.Mode tintMode;
    private final Region transparentRegion;
    private boolean useTintColorForShadow;

    public MaterialShapeDrawable() {
        this(null);
    }

    public MaterialShapeDrawable(ShapePathModel objectArray) {
        Paint.Style style2;
        int n10;
        float f10;
        Paint paint;
        this.paint = paint = new Paint();
        int n11 = 4;
        Object object = new Matrix[n11];
        this.cornerTransforms = object;
        object = new Matrix[n11];
        this.edgeTransforms = object;
        object = new ShapePath[n11];
        this.cornerPaths = object;
        this.matrix = object = new Matrix();
        this.path = object;
        super();
        this.pointF = object;
        super();
        this.shapePath = object;
        super();
        this.transparentRegion = object;
        super();
        this.scratchRegion = object;
        int n12 = 2;
        float[] fArray = new float[n12];
        this.scratch = fArray;
        object = new float[n12];
        this.scratch2 = (float[])object;
        n12 = 0;
        object = null;
        this.shapedViewModel = null;
        fArray = null;
        this.shadowEnabled = false;
        this.useTintColorForShadow = false;
        this.interpolation = f10 = 1.0f;
        this.shadowColor = -16777216;
        this.shadowElevation = 5;
        this.shadowRadius = 10;
        this.alpha = n10 = 255;
        this.scale = f10;
        f10 = 0.0f;
        this.strokeWidth = 0.0f;
        this.paintStyle = style2 = Paint.Style.FILL_AND_STROKE;
        style2 = PorterDuff.Mode.SRC_IN;
        this.tintMode = style2;
        this.tintList = null;
        this.shapedViewModel = objectArray;
        for (int i10 = 0; i10 < n11; ++i10) {
            objectArray = this.cornerTransforms;
            objectArray[i10] = object = new Matrix();
            objectArray = this.edgeTransforms;
            objectArray[i10] = object = new Matrix();
            objectArray = this.cornerPaths;
            super();
            objectArray[i10] = object;
        }
    }

    private float angleOfCorner(int n10, int n11, int n12) {
        int n13 = (n10 + -1 + 4) % 4;
        PointF pointF = this.pointF;
        this.getCoordinatesOfCorner(n13, n11, n12, pointF);
        PointF pointF2 = this.pointF;
        float f10 = pointF2.x;
        float f11 = pointF2.y;
        int n14 = (n10 + 1) % 4;
        this.getCoordinatesOfCorner(n14, n11, n12, pointF2);
        pointF2 = this.pointF;
        float f12 = pointF2.x;
        float f13 = pointF2.y;
        this.getCoordinatesOfCorner(n10, n11, n12, pointF2);
        PointF pointF3 = this.pointF;
        float f14 = pointF3.x;
        float f15 = pointF3.y;
        f13 -= f15;
        double d10 = f11 -= f15;
        double d11 = f10 -= f14;
        d10 = Math.atan2(d10, d11);
        f15 = (float)d10;
        double d12 = f13;
        d11 = f12 -= f14;
        d12 = Math.atan2(d12, d11);
        f14 = (float)d12;
        f15 -= f14;
        f14 = 0.0f;
        float f16 = f15 - 0.0f;
        n11 = (int)(f16 == 0.0f ? 0 : (f16 < 0.0f ? -1 : 1));
        if (n11 < 0) {
            d10 = f15;
            d11 = Math.PI * 2;
            f15 = (float)(d10 += d11);
        }
        return f15;
    }

    private float angleOfEdge(int n10, int n11, int n12) {
        int n13 = (n10 + 1) % 4;
        PointF pointF = this.pointF;
        this.getCoordinatesOfCorner(n10, n11, n12, pointF);
        PointF pointF2 = this.pointF;
        float f10 = pointF2.x;
        float f11 = pointF2.y;
        this.getCoordinatesOfCorner(n13, n11, n12, pointF2);
        pointF2 = this.pointF;
        float f12 = pointF2.x;
        float f13 = pointF2.y;
        double d10 = f13 - f11;
        double d11 = f12 -= f10;
        return (float)Math.atan2(d10, d11);
    }

    private void appendCornerPath(int n10, Path path) {
        float f10;
        Object object = this.scratch;
        Matrix matrix = this.cornerPaths;
        ShapePath shapePath = matrix[n10];
        object[0] = f10 = shapePath.startX;
        float f11 = matrix[n10].startY;
        int n11 = 1;
        f10 = Float.MIN_VALUE;
        object[n11] = f11;
        matrix = this.cornerTransforms[n10];
        matrix.mapPoints((float[])object);
        if (n10 == 0) {
            object = this.scratch;
            f11 = object[0];
            float f12 = object[n11];
            path.moveTo(f11, f12);
        } else {
            object = this.scratch;
            f11 = object[0];
            float f13 = object[n11];
            path.lineTo(f11, f13);
        }
        object = this.cornerPaths[n10];
        Matrix matrix2 = this.cornerTransforms[n10];
        ((ShapePath)object).applyToPath(matrix2, path);
    }

    private void appendEdgePath(int n10, Path path) {
        float f10;
        float f11;
        int n11 = (n10 + 1) % 4;
        Object object = this.scratch;
        Object[] objectArray = this.cornerPaths;
        object[0] = f11 = objectArray[n10].endX;
        float f12 = objectArray[n10].endY;
        int n12 = 1;
        object[n12] = f12;
        this.cornerTransforms[n10].mapPoints((float[])object);
        object = this.scratch2;
        objectArray = this.cornerPaths;
        object[0] = f10 = objectArray[n11].startX;
        object[n12] = f12 = objectArray[n11].startY;
        this.cornerTransforms[n11].mapPoints((float[])object);
        Object object2 = this.scratch;
        Object object3 = object2[0];
        objectArray = this.scratch2;
        ShapePath shapePath = objectArray[0];
        double d10 = object3 - shapePath;
        float f13 = object2[n12];
        object3 = objectArray[n12];
        double d11 = f13 - object3;
        f13 = (float)Math.hypot(d10, d11);
        this.shapePath.reset(0.0f, 0.0f);
        object = this.getEdgeTreatmentForIndex(n10);
        f12 = this.interpolation;
        ShapePath shapePath2 = this.shapePath;
        ((EdgeTreatment)object).getEdgePath(f13, f12, shapePath2);
        object2 = this.shapePath;
        Matrix matrix = this.edgeTransforms[n10];
        ((ShapePath)object2).applyToPath(matrix, path);
    }

    private void getCoordinatesOfCorner(int n10, int n11, int n12, PointF pointF) {
        int n13 = 1;
        if (n10 != n13) {
            n13 = 2;
            if (n10 != n13) {
                n11 = 3;
                float f10 = 4.2E-45f;
                if (n10 != n11) {
                    pointF.set(0.0f, 0.0f);
                } else {
                    float f11 = n12;
                    pointF.set(0.0f, f11);
                }
            } else {
                float f12 = n11;
                float f13 = n12;
                pointF.set(f12, f13);
            }
        } else {
            float f14 = n11;
            pointF.set(f14, 0.0f);
        }
    }

    private CornerTreatment getCornerTreatmentForIndex(int n10) {
        int n11 = 1;
        if (n10 != n11) {
            n11 = 2;
            if (n10 != n11) {
                n11 = 3;
                if (n10 != n11) {
                    return this.shapedViewModel.getTopLeftCorner();
                }
                return this.shapedViewModel.getBottomLeftCorner();
            }
            return this.shapedViewModel.getBottomRightCorner();
        }
        return this.shapedViewModel.getTopRightCorner();
    }

    private EdgeTreatment getEdgeTreatmentForIndex(int n10) {
        int n11 = 1;
        if (n10 != n11) {
            n11 = 2;
            if (n10 != n11) {
                n11 = 3;
                if (n10 != n11) {
                    return this.shapedViewModel.getTopEdge();
                }
                return this.shapedViewModel.getLeftEdge();
            }
            return this.shapedViewModel.getBottomEdge();
        }
        return this.shapedViewModel.getRightEdge();
    }

    private void getPath(int n10, int n11, Path path) {
        this.getPathForSize(n10, n11, path);
        float f10 = this.scale;
        float f11 = 1.0f;
        float f12 = f10 == f11 ? 0 : (f10 > f11 ? 1 : -1);
        if (f12 == false) {
            return;
        }
        this.matrix.reset();
        Matrix matrix = this.matrix;
        f11 = this.scale;
        float f13 = n10 / 2;
        float f14 = n11 / 2;
        matrix.setScale(f11, f11, f13, f14);
        Matrix matrix2 = this.matrix;
        path.transform(matrix2);
    }

    private static int modulateAlpha(int n10, int n11) {
        int n12 = n11 >>> 7;
        return n10 * (n11 += n12) >>> 8;
    }

    private void setCornerPathAndTransform(int n10, int n11, int n12) {
        PointF pointF = this.pointF;
        this.getCoordinatesOfCorner(n10, n11, n12, pointF);
        float f10 = this.angleOfCorner(n10, n11, n12);
        CornerTreatment cornerTreatment = this.getCornerTreatmentForIndex(n10);
        float f11 = this.interpolation;
        ShapePath shapePath = this.cornerPaths[n10];
        cornerTreatment.getCornerPath(f10, f11, shapePath);
        int n13 = (n10 + -1 + 4) % 4;
        float f12 = this.angleOfEdge(n13, n11, n12) + 1.5707964f;
        this.cornerTransforms[n10].reset();
        Matrix matrix = this.cornerTransforms[n10];
        pointF = this.pointF;
        float f13 = pointF.x;
        f10 = pointF.y;
        matrix.setTranslate(f13, f10);
        Matrix matrix2 = this.cornerTransforms[n10];
        f12 = (float)Math.toDegrees(f12);
        matrix2.preRotate(f12);
    }

    private void setEdgeTransform(int n10, int n11, int n12) {
        float f10;
        float[] fArray = this.scratch;
        ShapePath[] shapePathArray = this.cornerPaths;
        fArray[0] = f10 = shapePathArray[n10].endX;
        float f11 = shapePathArray[n10].endY;
        int n13 = 1;
        fArray[n13] = f11;
        this.cornerTransforms[n10].mapPoints(fArray);
        float f12 = this.angleOfEdge(n10, n11, n12);
        this.edgeTransforms[n10].reset();
        Matrix matrix = this.edgeTransforms[n10];
        fArray = this.scratch;
        f11 = fArray[0];
        float f13 = fArray[n13];
        matrix.setTranslate(f11, f13);
        Matrix matrix2 = this.edgeTransforms[n10];
        f12 = (float)Math.toDegrees(f12);
        matrix2.preRotate(f12);
    }

    private void updateTintFilter() {
        Object object;
        ColorStateList colorStateList = this.tintList;
        if (colorStateList != null && (object = this.tintMode) != null) {
            object = this.getState();
            int n10 = colorStateList.getColorForState((int[])object, 0);
            PorterDuff.Mode mode = this.tintMode;
            object = new PorterDuffColorFilter(n10, mode);
            this.tintFilter = object;
            boolean bl2 = this.useTintColorForShadow;
            if (bl2) {
                this.shadowColor = n10;
            }
            return;
        }
        this.tintFilter = null;
    }

    public void draw(Canvas canvas) {
        int n10;
        Paint paint = this.paint;
        Object object = this.tintFilter;
        paint.setColorFilter((ColorFilter)object);
        paint = this.paint;
        int n11 = paint.getAlpha();
        object = this.paint;
        int n12 = this.alpha;
        n12 = MaterialShapeDrawable.modulateAlpha(n11, n12);
        object.setAlpha(n12);
        object = this.paint;
        float f10 = this.strokeWidth;
        object.setStrokeWidth(f10);
        object = this.paint;
        Paint.Style style2 = this.paintStyle;
        object.setStyle(style2);
        int n13 = this.shadowElevation;
        if (n13 > 0 && (n12 = (int)(this.shadowEnabled ? 1 : 0)) != 0) {
            style2 = this.paint;
            int n14 = this.shadowRadius;
            float f11 = n14;
            float f12 = n13;
            n10 = this.shadowColor;
            style2.setShadowLayer(f11, 0.0f, f12, n10);
        }
        if ((object = this.shapedViewModel) != null) {
            n13 = canvas.getWidth();
            n12 = canvas.getHeight();
            Path path = this.path;
            this.getPath(n13, n12, path);
            object = this.path;
            style2 = this.paint;
            canvas.drawPath((Path)object, (Paint)style2);
        } else {
            n10 = 0;
            float f13 = canvas.getWidth();
            n13 = canvas.getHeight();
            float f14 = n13;
            Paint paint2 = this.paint;
            Canvas canvas2 = canvas;
            canvas.drawRect(0.0f, 0.0f, f13, f14, paint2);
        }
        this.paint.setAlpha(n11);
    }

    public float getInterpolation() {
        return this.interpolation;
    }

    public int getOpacity() {
        return -3;
    }

    public Paint.Style getPaintStyle() {
        return this.paintStyle;
    }

    public void getPathForSize(int n10, int n11, Path path) {
        int n12;
        path.rewind();
        ShapePathModel shapePathModel = this.shapedViewModel;
        if (shapePathModel == null) {
            return;
        }
        int n13 = 0;
        shapePathModel = null;
        for (int i10 = 0; i10 < (n12 = 4); ++i10) {
            this.setCornerPathAndTransform(i10, n10, n11);
            this.setEdgeTransform(i10, n10, n11);
        }
        while (n13 < n12) {
            this.appendCornerPath(n13, path);
            this.appendEdgePath(n13, path);
            ++n13;
        }
        path.close();
    }

    public float getScale() {
        return this.scale;
    }

    public int getShadowElevation() {
        return this.shadowElevation;
    }

    public int getShadowRadius() {
        return this.shadowRadius;
    }

    public ShapePathModel getShapedViewModel() {
        return this.shapedViewModel;
    }

    public float getStrokeWidth() {
        return this.strokeWidth;
    }

    public ColorStateList getTintList() {
        return this.tintList;
    }

    public Region getTransparentRegion() {
        Rect rect = this.getBounds();
        this.transparentRegion.set(rect);
        int n10 = rect.width();
        int n11 = rect.height();
        Path path = this.path;
        this.getPath(n10, n11, path);
        rect = this.scratchRegion;
        Path path2 = this.path;
        path = this.transparentRegion;
        rect.setPath(path2, (Region)path);
        rect = this.transparentRegion;
        path2 = this.scratchRegion;
        path = Region.Op.DIFFERENCE;
        rect.op((Region)path2, (Region.Op)path);
        return this.transparentRegion;
    }

    public boolean isPointInTransparentRegion(int n10, int n11) {
        return this.getTransparentRegion().contains(n10, n11);
    }

    public boolean isShadowEnabled() {
        return this.shadowEnabled;
    }

    public void setAlpha(int n10) {
        this.alpha = n10;
        this.invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
        this.invalidateSelf();
    }

    public void setInterpolation(float f10) {
        this.interpolation = f10;
        this.invalidateSelf();
    }

    public void setPaintStyle(Paint.Style style2) {
        this.paintStyle = style2;
        this.invalidateSelf();
    }

    public void setScale(float f10) {
        this.scale = f10;
        this.invalidateSelf();
    }

    public void setShadowColor(int n10) {
        this.shadowColor = n10;
        this.useTintColorForShadow = false;
        this.invalidateSelf();
    }

    public void setShadowElevation(int n10) {
        this.shadowElevation = n10;
        this.invalidateSelf();
    }

    public void setShadowEnabled(boolean bl2) {
        this.shadowEnabled = bl2;
        this.invalidateSelf();
    }

    public void setShadowRadius(int n10) {
        this.shadowRadius = n10;
        this.invalidateSelf();
    }

    public void setShapedViewModel(ShapePathModel shapePathModel) {
        this.shapedViewModel = shapePathModel;
        this.invalidateSelf();
    }

    public void setStrokeWidth(float f10) {
        this.strokeWidth = f10;
        this.invalidateSelf();
    }

    public void setTint(int n10) {
        ColorStateList colorStateList = ColorStateList.valueOf((int)n10);
        this.setTintList(colorStateList);
    }

    public void setTintList(ColorStateList colorStateList) {
        this.tintList = colorStateList;
        this.updateTintFilter();
        this.invalidateSelf();
    }

    public void setTintMode(PorterDuff.Mode mode) {
        this.tintMode = mode;
        this.updateTintFilter();
        this.invalidateSelf();
    }

    public void setUseTintColorForShadow(boolean bl2) {
        this.useTintColorForShadow = bl2;
        this.invalidateSelf();
    }
}

