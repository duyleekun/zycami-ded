/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  android.graphics.Paint$Cap
 *  android.graphics.Paint$Join
 *  android.graphics.Paint$Style
 *  android.graphics.Path
 *  android.graphics.Path$FillType
 *  android.graphics.PathMeasure
 *  android.graphics.Shader
 */
package androidx.vectordrawable.graphics.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Shader;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import androidx.core.content.res.ComplexColorCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VFullPath;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VGroup;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VObject;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VPath;
import java.util.ArrayList;

public class VectorDrawableCompat$VPathRenderer {
    private static final Matrix IDENTITY_MATRIX;
    public float mBaseHeight;
    public float mBaseWidth;
    private int mChangingConfigurations;
    public Paint mFillPaint;
    private final Matrix mFinalPathMatrix;
    public Boolean mIsStateful;
    private final Path mPath;
    private PathMeasure mPathMeasure;
    private final Path mRenderPath;
    public int mRootAlpha;
    public final VectorDrawableCompat$VGroup mRootGroup;
    public String mRootName;
    public Paint mStrokePaint;
    public final ArrayMap mVGTargetsMap;
    public float mViewportHeight;
    public float mViewportWidth;

    static {
        Matrix matrix;
        IDENTITY_MATRIX = matrix = new Matrix();
    }

    public VectorDrawableCompat$VPathRenderer() {
        Object object;
        this.mFinalPathMatrix = object = new Matrix();
        this.mBaseWidth = 0.0f;
        this.mBaseHeight = 0.0f;
        this.mViewportWidth = 0.0f;
        this.mViewportHeight = 0.0f;
        this.mRootAlpha = 255;
        this.mRootName = null;
        this.mIsStateful = null;
        this.mVGTargetsMap = object;
        super();
        this.mRootGroup = object;
        super();
        this.mPath = object;
        super();
        this.mRenderPath = object;
    }

    public VectorDrawableCompat$VPathRenderer(VectorDrawableCompat$VPathRenderer object) {
        int n10;
        float f10;
        Object object2 = new Matrix();
        this.mFinalPathMatrix = object2;
        this.mBaseWidth = 0.0f;
        this.mBaseHeight = 0.0f;
        this.mViewportWidth = 0.0f;
        this.mViewportHeight = 0.0f;
        this.mRootAlpha = 255;
        this.mRootName = null;
        this.mIsStateful = null;
        this.mVGTargetsMap = object2;
        VectorDrawableCompat$VGroup vectorDrawableCompat$VGroup = ((VectorDrawableCompat$VPathRenderer)object).mRootGroup;
        Object object3 = new VectorDrawableCompat$VGroup(vectorDrawableCompat$VGroup, (ArrayMap)object2);
        this.mRootGroup = object3;
        vectorDrawableCompat$VGroup = ((VectorDrawableCompat$VPathRenderer)object).mPath;
        super((Path)vectorDrawableCompat$VGroup);
        this.mPath = object3;
        vectorDrawableCompat$VGroup = ((VectorDrawableCompat$VPathRenderer)object).mRenderPath;
        super((Path)vectorDrawableCompat$VGroup);
        this.mRenderPath = object3;
        this.mBaseWidth = f10 = ((VectorDrawableCompat$VPathRenderer)object).mBaseWidth;
        this.mBaseHeight = f10 = ((VectorDrawableCompat$VPathRenderer)object).mBaseHeight;
        this.mViewportWidth = f10 = ((VectorDrawableCompat$VPathRenderer)object).mViewportWidth;
        this.mViewportHeight = f10 = ((VectorDrawableCompat$VPathRenderer)object).mViewportHeight;
        this.mChangingConfigurations = n10 = ((VectorDrawableCompat$VPathRenderer)object).mChangingConfigurations;
        this.mRootAlpha = n10 = ((VectorDrawableCompat$VPathRenderer)object).mRootAlpha;
        this.mRootName = object3 = ((VectorDrawableCompat$VPathRenderer)object).mRootName;
        object3 = ((VectorDrawableCompat$VPathRenderer)object).mRootName;
        if (object3 != null) {
            ((SimpleArrayMap)object2).put(object3, this);
        }
        this.mIsStateful = object = ((VectorDrawableCompat$VPathRenderer)object).mIsStateful;
    }

    private static float cross(float f10, float f11, float f12, float f13) {
        return (f10 *= f13) - (f11 *= f12);
    }

    private void drawGroupTree(VectorDrawableCompat$VGroup vectorDrawableCompat$VGroup, Matrix matrix, Canvas canvas, int n10, int n11, ColorFilter colorFilter) {
        int n12;
        vectorDrawableCompat$VGroup.mStackedMatrix.set(matrix);
        matrix = vectorDrawableCompat$VGroup.mStackedMatrix;
        Object object = vectorDrawableCompat$VGroup.mLocalMatrix;
        matrix.preConcat((Matrix)object);
        canvas.save();
        matrix = null;
        for (int i10 = 0; i10 < (n12 = ((ArrayList)(object = vectorDrawableCompat$VGroup.mChildren)).size()); ++i10) {
            Object object2;
            Object object3;
            object = (VectorDrawableCompat$VObject)vectorDrawableCompat$VGroup.mChildren.get(i10);
            boolean bl2 = object instanceof VectorDrawableCompat$VGroup;
            if (bl2) {
                object3 = object;
                object3 = (VectorDrawableCompat$VGroup)object;
                object2 = vectorDrawableCompat$VGroup.mStackedMatrix;
                this.drawGroupTree((VectorDrawableCompat$VGroup)object3, (Matrix)object2, canvas, n10, n11, colorFilter);
                continue;
            }
            bl2 = object instanceof VectorDrawableCompat$VPath;
            if (!bl2) continue;
            object2 = object;
            object2 = (VectorDrawableCompat$VPath)object;
            object3 = vectorDrawableCompat$VGroup;
            this.drawPath(vectorDrawableCompat$VGroup, (VectorDrawableCompat$VPath)object2, canvas, n10, n11, colorFilter);
        }
        canvas.restore();
    }

    private void drawPath(VectorDrawableCompat$VGroup vectorDrawableCompat$VGroup, VectorDrawableCompat$VPath vectorDrawableCompat$VPath, Canvas canvas, int n10, int n11, ColorFilter colorFilter) {
        float f10 = n10;
        float f11 = this.mViewportWidth;
        f10 /= f11;
        float f12 = n11;
        f11 = this.mViewportHeight;
        f12 /= f11;
        f11 = Math.min(f10, f12);
        vectorDrawableCompat$VGroup = vectorDrawableCompat$VGroup.mStackedMatrix;
        this.mFinalPathMatrix.set((Matrix)vectorDrawableCompat$VGroup);
        Matrix matrix = this.mFinalPathMatrix;
        matrix.postScale(f10, f12);
        float f13 = this.getMatrixScale((Matrix)vectorDrawableCompat$VGroup);
        n10 = 0;
        f10 = 0.0f;
        Object object = null;
        float f14 = f13 - 0.0f;
        n11 = (int)(f14 == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1));
        if (n11 == 0) {
            return;
        }
        Path path = this.mPath;
        vectorDrawableCompat$VPath.toPath(path);
        path = this.mPath;
        matrix = this.mRenderPath;
        matrix.reset();
        int n12 = vectorDrawableCompat$VPath.isClipPath();
        if (n12 != 0) {
            vectorDrawableCompat$VGroup = this.mRenderPath;
            int n13 = vectorDrawableCompat$VPath.mFillRule;
            vectorDrawableCompat$VPath = n13 == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
            vectorDrawableCompat$VGroup.setFillType((Path.FillType)vectorDrawableCompat$VPath);
            vectorDrawableCompat$VGroup = this.mRenderPath;
            vectorDrawableCompat$VPath = this.mFinalPathMatrix;
            vectorDrawableCompat$VGroup.addPath(path, (Matrix)vectorDrawableCompat$VPath);
            vectorDrawableCompat$VGroup = this.mRenderPath;
            canvas.clipPath((Path)vectorDrawableCompat$VGroup);
        } else {
            Path path2;
            PathMeasure pathMeasure;
            float f15;
            float f16;
            float f17;
            vectorDrawableCompat$VPath = (VectorDrawableCompat$VFullPath)vectorDrawableCompat$VPath;
            float f18 = ((VectorDrawableCompat$VFullPath)vectorDrawableCompat$VPath).mTrimPathStart;
            float f19 = f18 - 0.0f;
            float f20 = f19 == 0.0f ? 0 : (f19 > 0.0f ? 1 : -1);
            int n14 = 1065353216;
            float f21 = 1.0f;
            boolean bl2 = true;
            float f22 = Float.MIN_VALUE;
            if (f20 != false || (f20 = (f17 = (f16 = ((VectorDrawableCompat$VFullPath)vectorDrawableCompat$VPath).mTrimPathEnd) - f21) == 0.0f ? 0 : (f17 > 0.0f ? 1 : -1)) != false) {
                f16 = ((VectorDrawableCompat$VFullPath)vectorDrawableCompat$VPath).mTrimPathOffset;
                f18 = (f18 + f16) % f21;
                f15 = (((VectorDrawableCompat$VFullPath)vectorDrawableCompat$VPath).mTrimPathEnd + f16) % f21;
                pathMeasure = this.mPathMeasure;
                if (pathMeasure == null) {
                    this.mPathMeasure = pathMeasure = new PathMeasure();
                }
                pathMeasure = this.mPathMeasure;
                path2 = this.mPath;
                pathMeasure.setPath(path2, false);
                pathMeasure = this.mPathMeasure;
                f16 = pathMeasure.getLength();
                path.reset();
                float f23 = (f18 *= f16) - (f15 *= f16);
                n14 = (int)(f23 == 0.0f ? 0 : (f23 > 0.0f ? 1 : -1));
                if (n14 > 0) {
                    path2 = this.mPathMeasure;
                    path2.getSegment(f18, f16, path, bl2);
                    matrix = this.mPathMeasure;
                    matrix.getSegment(0.0f, f15, path, bl2);
                } else {
                    pathMeasure = this.mPathMeasure;
                    pathMeasure.getSegment(f18, f15, path, bl2);
                }
                path.rLineTo(0.0f, 0.0f);
            }
            object = this.mRenderPath;
            matrix = this.mFinalPathMatrix;
            object.addPath(path, matrix);
            object = ((VectorDrawableCompat$VFullPath)vectorDrawableCompat$VPath).mFillColor;
            n10 = (int)(((ComplexColorCompat)object).willDraw() ? 1 : 0);
            n11 = 1132396544;
            f12 = 255.0f;
            n12 = 255;
            f18 = 3.57E-43f;
            f20 = 0.0f;
            f16 = 0.0f;
            pathMeasure = null;
            if (n10 != 0) {
                Paint.Style style2;
                object = ((VectorDrawableCompat$VFullPath)vectorDrawableCompat$VPath).mFillColor;
                path2 = this.mFillPaint;
                if (path2 == null) {
                    path2 = new Paint((int)(bl2 ? 1 : 0));
                    this.mFillPaint = path2;
                    style2 = Paint.Style.FILL;
                    path2.setStyle(style2);
                }
                path2 = this.mFillPaint;
                boolean n15 = ((ComplexColorCompat)object).isGradient();
                if (n15) {
                    object = ((ComplexColorCompat)object).getShader();
                    style2 = this.mFinalPathMatrix;
                    object.setLocalMatrix((Matrix)style2);
                    path2.setShader((Shader)object);
                    f10 = ((VectorDrawableCompat$VFullPath)vectorDrawableCompat$VPath).mFillAlpha * f12;
                    n10 = Math.round(f10);
                    path2.setAlpha(n10);
                } else {
                    path2.setShader(null);
                    path2.setAlpha(n12);
                    n10 = ((ComplexColorCompat)object).getColor();
                    f15 = ((VectorDrawableCompat$VFullPath)vectorDrawableCompat$VPath).mFillAlpha;
                    n10 = VectorDrawableCompat.applyAlpha(n10, f15);
                    path2.setColor(n10);
                }
                path2.setColorFilter(colorFilter);
                object = this.mRenderPath;
                int n13 = vectorDrawableCompat$VPath.mFillRule;
                style2 = n13 == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
                object.setFillType((Path.FillType)style2);
                object = this.mRenderPath;
                canvas.drawPath((Path)object, (Paint)path2);
            }
            if ((n10 = (int)(((ComplexColorCompat)(object = ((VectorDrawableCompat$VFullPath)vectorDrawableCompat$VPath).mStrokeColor)).willDraw() ? 1 : 0)) != 0) {
                Paint.Join join;
                object = ((VectorDrawableCompat$VFullPath)vectorDrawableCompat$VPath).mStrokeColor;
                path2 = this.mStrokePaint;
                if (path2 == null) {
                    path2 = new Paint((int)(bl2 ? 1 : 0));
                    this.mStrokePaint = path2;
                    join = Paint.Style.STROKE;
                    path2.setStyle((Paint.Style)join);
                }
                path2 = this.mStrokePaint;
                join = ((VectorDrawableCompat$VFullPath)vectorDrawableCompat$VPath).mStrokeLineJoin;
                if (join != null) {
                    path2.setStrokeJoin(join);
                }
                if ((join = ((VectorDrawableCompat$VFullPath)vectorDrawableCompat$VPath).mStrokeLineCap) != null) {
                    path2.setStrokeCap((Paint.Cap)join);
                }
                f22 = ((VectorDrawableCompat$VFullPath)vectorDrawableCompat$VPath).mStrokeMiterlimit;
                path2.setStrokeMiter(f22);
                bl2 = ((ComplexColorCompat)object).isGradient();
                if (bl2) {
                    object = ((ComplexColorCompat)object).getShader();
                    matrix = this.mFinalPathMatrix;
                    object.setLocalMatrix(matrix);
                    path2.setShader((Shader)object);
                    f10 = ((VectorDrawableCompat$VFullPath)vectorDrawableCompat$VPath).mStrokeAlpha * f12;
                    n10 = Math.round(f10);
                    path2.setAlpha(n10);
                } else {
                    path2.setShader(null);
                    path2.setAlpha(n12);
                    n10 = ((ComplexColorCompat)object).getColor();
                    f12 = ((VectorDrawableCompat$VFullPath)vectorDrawableCompat$VPath).mStrokeAlpha;
                    n10 = VectorDrawableCompat.applyAlpha(n10, f12);
                    path2.setColor(n10);
                }
                path2.setColorFilter(colorFilter);
                f11 *= f13;
                f13 = ((VectorDrawableCompat$VFullPath)vectorDrawableCompat$VPath).mStrokeWidth * f11;
                path2.setStrokeWidth(f13);
                vectorDrawableCompat$VGroup = this.mRenderPath;
                canvas.drawPath((Path)vectorDrawableCompat$VGroup, (Paint)path2);
            }
        }
    }

    private float getMatrixScale(Matrix matrix) {
        float[] fArray;
        int n10 = 4;
        float[] fArray2 = fArray = new float[n10];
        float[] fArray3 = fArray;
        fArray2[0] = 0.0f;
        fArray3[1] = 1.0f;
        fArray2[2] = 1.0f;
        fArray3[3] = 0.0f;
        matrix.mapVectors(fArray);
        matrix = null;
        double d10 = fArray[0];
        int n11 = 1;
        double d11 = fArray[n11];
        d10 = Math.hypot(d10, d11);
        float f10 = (float)d10;
        int n12 = 2;
        d11 = fArray[n12];
        int n13 = 3;
        float f11 = fArray[n13];
        double d12 = f11;
        d11 = Math.hypot(d11, d12);
        float f12 = (float)d11;
        float f13 = fArray[0];
        float f14 = fArray[n11];
        float f15 = fArray[n12];
        float f16 = fArray[n13];
        f13 = VectorDrawableCompat$VPathRenderer.cross(f13, f14, f15, f16);
        f16 = Math.max(f10, f12);
        f10 = 0.0f;
        float f17 = f16 - 0.0f;
        n12 = (int)(f17 == 0.0f ? 0 : (f17 > 0.0f ? 1 : -1));
        if (n12 > 0) {
            f13 = Math.abs(f13);
            f10 = f13 / f16;
        }
        return f10;
    }

    public void draw(Canvas canvas, int n10, int n11, ColorFilter colorFilter) {
        VectorDrawableCompat$VGroup vectorDrawableCompat$VGroup = this.mRootGroup;
        Matrix matrix = IDENTITY_MATRIX;
        this.drawGroupTree(vectorDrawableCompat$VGroup, matrix, canvas, n10, n11, colorFilter);
    }

    public float getAlpha() {
        return (float)this.getRootAlpha() / 255.0f;
    }

    public int getRootAlpha() {
        return this.mRootAlpha;
    }

    public boolean isStateful() {
        Boolean bl2 = this.mIsStateful;
        if (bl2 == null) {
            boolean bl3 = this.mRootGroup.isStateful();
            this.mIsStateful = bl2 = Boolean.valueOf(bl3);
        }
        return this.mIsStateful;
    }

    public boolean onStateChanged(int[] nArray) {
        return this.mRootGroup.onStateChanged(nArray);
    }

    public void setAlpha(float f10) {
        int n10 = (int)(f10 * 255.0f);
        this.setRootAlpha(n10);
    }

    public void setRootAlpha(int n10) {
        this.mRootAlpha = n10;
    }
}

