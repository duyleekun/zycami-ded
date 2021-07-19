/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.Paint
 *  android.graphics.Paint$Cap
 *  android.graphics.Paint$Style
 *  android.graphics.Path
 *  android.graphics.Path$FillType
 *  android.graphics.Rect
 *  android.graphics.RectF
 */
package androidx.swiperefreshlayout.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;

public class CircularProgressDrawable$Ring {
    public int mAlpha;
    public Path mArrow;
    public int mArrowHeight;
    public final Paint mArrowPaint;
    public float mArrowScale;
    public int mArrowWidth;
    public final Paint mCirclePaint;
    public int mColorIndex;
    public int[] mColors;
    public int mCurrentColor;
    public float mEndTrim;
    public final Paint mPaint;
    public float mRingCenterRadius;
    public float mRotation;
    public boolean mShowArrow;
    public float mStartTrim;
    public float mStartingEndTrim;
    public float mStartingRotation;
    public float mStartingStartTrim;
    public float mStrokeWidth;
    public final RectF mTempBounds;

    public CircularProgressDrawable$Ring() {
        Paint paint;
        Paint paint2;
        RectF rectF;
        this.mTempBounds = rectF = new RectF();
        this.mPaint = rectF;
        this.mArrowPaint = paint2 = new Paint();
        this.mCirclePaint = paint = new Paint();
        this.mStartTrim = 0.0f;
        this.mEndTrim = 0.0f;
        this.mRotation = 0.0f;
        this.mStrokeWidth = 5.0f;
        this.mArrowScale = 1.0f;
        this.mAlpha = 255;
        Paint.Cap cap = Paint.Cap.SQUARE;
        rectF.setStrokeCap(cap);
        boolean bl2 = true;
        rectF.setAntiAlias(bl2);
        Paint.Style style2 = Paint.Style.STROKE;
        rectF.setStyle(style2);
        rectF = Paint.Style.FILL;
        paint2.setStyle((Paint.Style)rectF);
        paint2.setAntiAlias(bl2);
        paint.setColor(0);
    }

    public void draw(Canvas canvas, Rect rect) {
        int n10;
        RectF rectF = this.mTempBounds;
        float f10 = this.mRingCenterRadius;
        float f11 = this.mStrokeWidth;
        float f12 = 2.0f;
        f11 = f11 / f12 + f10;
        float f13 = 0.0f;
        float f14 = f10 - 0.0f;
        Object object = f14 == 0.0f ? 0 : (f14 < 0.0f ? -1 : 1);
        if (object <= 0) {
            object = rect.width();
            n10 = rect.height();
            object = Math.min((int)object, n10);
            f10 = (float)object / f12;
            n10 = this.mArrowWidth;
            f11 = n10;
            f13 = this.mArrowScale;
            f11 = f11 * f13 / f12;
            f13 = this.mStrokeWidth / f12;
            f11 = Math.max(f11, f13);
            f11 = f10 - f11;
        }
        f10 = (float)rect.centerX() - f11;
        f13 = (float)rect.centerY() - f11;
        float f15 = (float)rect.centerX() + f11;
        float f16 = (float)rect.centerY() + f11;
        rectF.set(f10, f13, f15, f16);
        f16 = this.mStartTrim;
        f10 = this.mRotation;
        f16 += f10;
        f11 = 360.0f;
        float f17 = (this.mEndTrim + f10) * f11 - (f16 *= f11);
        Paint paint = this.mPaint;
        n10 = this.mCurrentColor;
        paint.setColor(n10);
        paint = this.mPaint;
        n10 = this.mAlpha;
        paint.setAlpha(n10);
        f10 = this.mStrokeWidth / f12;
        rectF.inset(f10, f10);
        f11 = rectF.centerX();
        f13 = rectF.centerY();
        f15 = rectF.width() / f12;
        Paint paint2 = this.mCirclePaint;
        canvas.drawCircle(f11, f13, f15, paint2);
        f10 = -f10;
        rectF.inset(f10, f10);
        Paint paint3 = this.mPaint;
        paint = canvas;
        f12 = f16;
        f13 = f17;
        canvas.drawArc(rectF, f16, f17, false, paint3);
        this.drawTriangle(canvas, f16, f17, rectF);
    }

    public void drawTriangle(Canvas canvas, float f10, float f11, RectF rectF) {
        boolean bl2 = this.mShowArrow;
        if (bl2) {
            Path path = this.mArrow;
            if (path == null) {
                this.mArrow = path = new Path();
                Path.FillType fillType = Path.FillType.EVEN_ODD;
                path.setFillType(fillType);
            } else {
                path.reset();
            }
            float f12 = rectF.width();
            float f13 = rectF.height();
            f12 = Math.min(f12, f13);
            f13 = 2.0f;
            f12 /= f13;
            int n10 = this.mArrowWidth;
            float f14 = n10;
            float f15 = this.mArrowScale;
            f14 = f14 * f15 / f13;
            this.mArrow.moveTo(0.0f, 0.0f);
            Path path2 = this.mArrow;
            int n11 = this.mArrowWidth;
            float f16 = n11;
            float f17 = this.mArrowScale;
            path2.lineTo(f16 *= f17, 0.0f);
            path2 = this.mArrow;
            int n12 = this.mArrowWidth;
            float f18 = n12;
            f16 = this.mArrowScale;
            f18 = f18 * f16 / f13;
            int n13 = this.mArrowHeight;
            f17 = (float)n13 * f16;
            path2.lineTo(f18, f17);
            path2 = this.mArrow;
            f18 = rectF.centerX();
            f12 = f12 + f18 - f14;
            f14 = rectF.centerY();
            f18 = this.mStrokeWidth / f13;
            path2.offset(f12, f14 += f18);
            this.mArrow.close();
            path = this.mArrowPaint;
            int n14 = this.mCurrentColor;
            path.setColor(n14);
            path = this.mArrowPaint;
            n14 = this.mAlpha;
            path.setAlpha(n14);
            canvas.save();
            f10 += f11;
            f11 = rectF.centerX();
            float f19 = rectF.centerY();
            canvas.rotate(f10, f11, f19);
            Path path3 = this.mArrow;
            Paint paint = this.mArrowPaint;
            canvas.drawPath(path3, paint);
            canvas.restore();
        }
    }

    public int getAlpha() {
        return this.mAlpha;
    }

    public float getArrowHeight() {
        return this.mArrowHeight;
    }

    public float getArrowScale() {
        return this.mArrowScale;
    }

    public float getArrowWidth() {
        return this.mArrowWidth;
    }

    public int getBackgroundColor() {
        return this.mCirclePaint.getColor();
    }

    public float getCenterRadius() {
        return this.mRingCenterRadius;
    }

    public int[] getColors() {
        return this.mColors;
    }

    public float getEndTrim() {
        return this.mEndTrim;
    }

    public int getNextColor() {
        int[] nArray = this.mColors;
        int n10 = this.getNextColorIndex();
        return nArray[n10];
    }

    public int getNextColorIndex() {
        int n10 = this.mColorIndex + 1;
        int n11 = this.mColors.length;
        return n10 % n11;
    }

    public float getRotation() {
        return this.mRotation;
    }

    public boolean getShowArrow() {
        return this.mShowArrow;
    }

    public float getStartTrim() {
        return this.mStartTrim;
    }

    public int getStartingColor() {
        int[] nArray = this.mColors;
        int n10 = this.mColorIndex;
        return nArray[n10];
    }

    public float getStartingEndTrim() {
        return this.mStartingEndTrim;
    }

    public float getStartingRotation() {
        return this.mStartingRotation;
    }

    public float getStartingStartTrim() {
        return this.mStartingStartTrim;
    }

    public Paint.Cap getStrokeCap() {
        return this.mPaint.getStrokeCap();
    }

    public float getStrokeWidth() {
        return this.mStrokeWidth;
    }

    public void goToNextColor() {
        int n10 = this.getNextColorIndex();
        this.setColorIndex(n10);
    }

    public void resetOriginals() {
        this.mStartingStartTrim = 0.0f;
        this.mStartingEndTrim = 0.0f;
        this.mStartingRotation = 0.0f;
        this.setStartTrim(0.0f);
        this.setEndTrim(0.0f);
        this.setRotation(0.0f);
    }

    public void setAlpha(int n10) {
        this.mAlpha = n10;
    }

    public void setArrowDimensions(float f10, float f11) {
        int n10;
        this.mArrowWidth = n10 = (int)f10;
        this.mArrowHeight = n10 = (int)f11;
    }

    public void setArrowScale(float f10) {
        float f11 = this.mArrowScale;
        float f12 = f10 - f11;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object != false) {
            this.mArrowScale = f10;
        }
    }

    public void setBackgroundColor(int n10) {
        this.mCirclePaint.setColor(n10);
    }

    public void setCenterRadius(float f10) {
        this.mRingCenterRadius = f10;
    }

    public void setColor(int n10) {
        this.mCurrentColor = n10;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    public void setColorIndex(int n10) {
        this.mColorIndex = n10;
        this.mCurrentColor = n10 = this.mColors[n10];
    }

    public void setColors(int[] nArray) {
        this.mColors = nArray;
        this.setColorIndex(0);
    }

    public void setEndTrim(float f10) {
        this.mEndTrim = f10;
    }

    public void setRotation(float f10) {
        this.mRotation = f10;
    }

    public void setShowArrow(boolean bl2) {
        boolean bl3 = this.mShowArrow;
        if (bl3 != bl2) {
            this.mShowArrow = bl2;
        }
    }

    public void setStartTrim(float f10) {
        this.mStartTrim = f10;
    }

    public void setStrokeCap(Paint.Cap cap) {
        this.mPaint.setStrokeCap(cap);
    }

    public void setStrokeWidth(float f10) {
        this.mStrokeWidth = f10;
        this.mPaint.setStrokeWidth(f10);
    }

    public void storeOriginals() {
        float f10;
        this.mStartingStartTrim = f10 = this.mStartTrim;
        this.mStartingEndTrim = f10 = this.mEndTrim;
        this.mStartingRotation = f10 = this.mRotation;
    }
}

