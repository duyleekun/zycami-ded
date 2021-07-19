/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.graphics.Matrix
 *  android.graphics.Path
 *  android.graphics.PathMeasure
 *  android.util.AttributeSet
 *  org.xmlpull.v1.XmlPullParser
 */
package androidx.transition;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import androidx.transition.PathMotion;
import androidx.transition.Styleable;
import org.xmlpull.v1.XmlPullParser;

public class PatternPathMotion
extends PathMotion {
    private Path mOriginalPatternPath;
    private final Path mPatternPath;
    private final Matrix mTempMatrix;

    public PatternPathMotion() {
        Matrix matrix;
        Path path;
        this.mPatternPath = path = new Path();
        this.mTempMatrix = matrix = new Matrix();
        path.lineTo(1.0f, 0.0f);
        this.mOriginalPatternPath = path;
    }

    public PatternPathMotion(Context context, AttributeSet object) {
        Object object2;
        block8: {
            this.mPatternPath = object2 = new Path();
            this.mTempMatrix = object2;
            object2 = Styleable.PATTERN_PATH_MOTION;
            context = context.obtainStyledAttributes(object, (int[])object2);
            object = (XmlPullParser)object;
            object2 = "patternPathData";
            object = TypedArrayUtils.getNamedString((TypedArray)context, (XmlPullParser)object, (String)object2, 0);
            if (object == null) break block8;
            object = PathParser.createPathFromPathData((String)object);
            this.setPatternPath((Path)object);
            return;
        }
        object2 = "pathData must be supplied for patternPathMotion";
        try {
            super((String)object2);
            throw object;
        }
        finally {
            context.recycle();
        }
    }

    public PatternPathMotion(Path path) {
        Path path2;
        this.mPatternPath = path2 = new Path();
        this.mTempMatrix = path2;
        this.setPatternPath(path);
    }

    private static float distance(float f10, float f11) {
        f10 *= f10;
        f11 *= f11;
        return (float)Math.sqrt(f10 + f11);
    }

    public Path getPath(float f10, float f11, float f12, float f13) {
        float f14 = PatternPathMotion.distance(f12 -= f10, f13 -= f11);
        double d10 = f13;
        double d11 = f12;
        d11 = Math.atan2(d10, d11);
        this.mTempMatrix.setScale(f14, f14);
        Matrix matrix = this.mTempMatrix;
        f12 = (float)Math.toDegrees(d11);
        matrix.postRotate(f12);
        this.mTempMatrix.postTranslate(f10, f11);
        Path path = new Path();
        Path path2 = this.mPatternPath;
        Matrix matrix2 = this.mTempMatrix;
        path2.transform(matrix2, path);
        return path;
    }

    public Path getPatternPath() {
        return this.mOriginalPatternPath;
    }

    public void setPatternPath(Path object) {
        Path path = null;
        PathMeasure pathMeasure = new PathMeasure(object, false);
        float f10 = pathMeasure.getLength();
        Object object2 = new float[2];
        float f11 = 0.0f;
        pathMeasure.getPosTan(f10, object2, null);
        f10 = object2[0];
        int n10 = 1;
        float f12 = Float.MIN_VALUE;
        float f13 = object2[n10];
        pathMeasure.getPosTan(0.0f, object2, null);
        float f14 = object2[0];
        float f15 = object2[n10];
        float f16 = f14 == f10 ? 0 : (f14 > f10 ? 1 : -1);
        if (f16 == false && (f16 = f15 == f13 ? 0 : (f15 > f13 ? 1 : -1)) == false) {
            object = new IllegalArgumentException("pattern must not end at the starting point");
            throw object;
        }
        object2 = this.mTempMatrix;
        f11 = -f14;
        f12 = -f15;
        object2.setTranslate(f11, f12);
        f10 -= f14;
        f14 = PatternPathMotion.distance(f10, f13 -= f15);
        f15 = 1.0f / f14;
        this.mTempMatrix.postScale(f15, f15);
        double d10 = f13;
        double d11 = f10;
        d10 = Math.atan2(d10, d11);
        Matrix matrix = this.mTempMatrix;
        f14 = (float)Math.toDegrees(-d10);
        matrix.postRotate(f14);
        pathMeasure = this.mTempMatrix;
        path = this.mPatternPath;
        object.transform((Matrix)pathMeasure, path);
        this.mOriginalPatternPath = object;
    }
}

