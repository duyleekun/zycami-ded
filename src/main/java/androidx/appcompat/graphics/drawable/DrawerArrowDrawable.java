/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.Paint
 *  android.graphics.Paint$Cap
 *  android.graphics.Paint$Join
 *  android.graphics.Paint$Style
 *  android.graphics.Path
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 */
package androidx.appcompat.graphics.drawable;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$style;
import androidx.appcompat.R$styleable;
import androidx.core.graphics.drawable.DrawableCompat;

public class DrawerArrowDrawable
extends Drawable {
    public static final int ARROW_DIRECTION_END = 3;
    public static final int ARROW_DIRECTION_LEFT = 0;
    public static final int ARROW_DIRECTION_RIGHT = 1;
    public static final int ARROW_DIRECTION_START = 2;
    private static final float ARROW_HEAD_ANGLE = (float)Math.toRadians(45.0);
    private float mArrowHeadLength;
    private float mArrowShaftLength;
    private float mBarGap;
    private float mBarLength;
    private int mDirection;
    private float mMaxCutForBarSize;
    private final Paint mPaint;
    private final Path mPath;
    private float mProgress;
    private final int mSize;
    private boolean mSpin;
    private boolean mVerticalMirror;

    public DrawerArrowDrawable(Context context) {
        Path path;
        Object object;
        this.mPaint = object = new Paint();
        this.mPath = path = new Path();
        this.mVerticalMirror = false;
        this.mDirection = 2;
        Paint.Style style2 = Paint.Style.STROKE;
        object.setStyle(style2);
        style2 = Paint.Join.MITER;
        object.setStrokeJoin((Paint.Join)style2);
        style2 = Paint.Cap.BUTT;
        object.setStrokeCap((Paint.Cap)style2);
        boolean bl2 = true;
        object.setAntiAlias(bl2);
        context = context.getTheme();
        object = R$styleable.DrawerArrowToggle;
        int n10 = R$attr.drawerArrowStyle;
        int n11 = R$style.Base_Widget_AppCompat_DrawerArrowToggle;
        context = context.obtainStyledAttributes(null, (int[])object, n10, n11);
        int n12 = R$styleable.DrawerArrowToggle_color;
        n12 = context.getColor(n12, 0);
        this.setColor(n12);
        n12 = R$styleable.DrawerArrowToggle_thickness;
        float f10 = context.getDimension(n12, 0.0f);
        this.setBarThickness(f10);
        n12 = R$styleable.DrawerArrowToggle_spinBars;
        n12 = context.getBoolean(n12, bl2) ? 1 : 0;
        this.setSpinEnabled(n12 != 0);
        n12 = R$styleable.DrawerArrowToggle_gapBetweenBars;
        f10 = Math.round(context.getDimension(n12, 0.0f));
        this.setGapSize(f10);
        n12 = R$styleable.DrawerArrowToggle_drawableSize;
        this.mSize = n12 = context.getDimensionPixelSize(n12, 0);
        n12 = R$styleable.DrawerArrowToggle_barLength;
        this.mBarLength = f10 = (float)Math.round(context.getDimension(n12, 0.0f));
        n12 = R$styleable.DrawerArrowToggle_arrowHeadLength;
        this.mArrowHeadLength = f10 = (float)Math.round(context.getDimension(n12, 0.0f));
        n12 = R$styleable.DrawerArrowToggle_arrowShaftLength;
        this.mArrowShaftLength = f10 = context.getDimension(n12, 0.0f);
        context.recycle();
    }

    private static float lerp(float f10, float f11, float f12) {
        f11 = (f11 - f10) * f12;
        return f10 + f11;
    }

    public void draw(Canvas canvas) {
        Path path;
        float f10;
        Paint paint;
        float f11;
        int n10;
        float f12;
        int n11;
        float f13;
        int n12;
        Rect rect;
        Canvas canvas2;
        DrawerArrowDrawable drawerArrowDrawable;
        block12: {
            block13: {
                drawerArrowDrawable = this;
                canvas2 = canvas;
                rect = this.getBounds();
                int n13 = this.mDirection;
                n12 = 0;
                f13 = 0.0f;
                n11 = 1;
                f12 = Float.MIN_VALUE;
                if (n13 == 0) break block12;
                if (n13 == n11) break block13;
                n10 = 3;
                f11 = 4.2E-45f;
                if (!(n13 != n10 ? (n13 = DrawableCompat.getLayoutDirection(this)) == n11 : (n13 = DrawableCompat.getLayoutDirection(this)) == 0)) break block12;
            }
            n12 = n11;
            f13 = f12;
        }
        float f14 = drawerArrowDrawable.mArrowHeadLength;
        f14 *= f14;
        n10 = 0x40000000;
        f11 = 2.0f;
        double d10 = Math.sqrt(f14 * f11);
        f14 = (float)d10;
        float f15 = drawerArrowDrawable.mBarLength;
        float f16 = drawerArrowDrawable.mProgress;
        f14 = DrawerArrowDrawable.lerp(f15, f14, f16);
        f15 = drawerArrowDrawable.mBarLength;
        f16 = drawerArrowDrawable.mArrowShaftLength;
        float f17 = drawerArrowDrawable.mProgress;
        f15 = DrawerArrowDrawable.lerp(f15, f16, f17);
        f16 = drawerArrowDrawable.mMaxCutForBarSize;
        f17 = drawerArrowDrawable.mProgress;
        float f18 = 0.0f;
        Path path2 = null;
        int n14 = Math.round(DrawerArrowDrawable.lerp(0.0f, f16, f17));
        f16 = n14;
        f17 = ARROW_HEAD_ANGLE;
        float f19 = drawerArrowDrawable.mProgress;
        f17 = DrawerArrowDrawable.lerp(0.0f, f17, f19);
        if (n12 != 0) {
            paint = null;
            f19 = 0.0f;
        } else {
            f19 = -180.0f;
        }
        float f20 = 180.0f;
        if (n12 != 0) {
            f10 = f20;
        } else {
            path = null;
            f10 = 0.0f;
        }
        float f21 = drawerArrowDrawable.mProgress;
        f19 = DrawerArrowDrawable.lerp(f19, f10, f21);
        double d11 = f14;
        float f22 = f19;
        double d12 = f17;
        double d13 = Math.cos(d12) * d11;
        int n15 = n12;
        f17 = f13;
        long l10 = Math.round(d13);
        f14 = l10;
        d12 = Math.sin(d12);
        long l11 = Math.round(d11 *= d12);
        f13 = l11;
        path2 = drawerArrowDrawable.mPath;
        path2.rewind();
        f18 = drawerArrowDrawable.mBarGap;
        paint = drawerArrowDrawable.mPaint;
        f19 = paint.getStrokeWidth();
        f18 += f19;
        f19 = -drawerArrowDrawable.mMaxCutForBarSize;
        f10 = drawerArrowDrawable.mProgress;
        f18 = DrawerArrowDrawable.lerp(f18, f19, f10);
        f19 = -f15 / f11;
        path = drawerArrowDrawable.mPath;
        f21 = f19 + f16;
        path.moveTo(f21, 0.0f);
        path = drawerArrowDrawable.mPath;
        path.rLineTo(f15 -= (f16 *= f11), 0.0f);
        drawerArrowDrawable.mPath.moveTo(f19, f18);
        drawerArrowDrawable.mPath.rLineTo(f14, f13);
        Path path3 = drawerArrowDrawable.mPath;
        f15 = -f18;
        path3.moveTo(f19, f15);
        path3 = drawerArrowDrawable.mPath;
        f13 = -f13;
        path3.rLineTo(f14, f13);
        drawerArrowDrawable.mPath.close();
        canvas.save();
        Paint paint2 = drawerArrowDrawable.mPaint;
        f14 = paint2.getStrokeWidth();
        f13 = rect.height();
        n11 = 0x40400000;
        f12 = 3.0f * f14;
        f13 -= f12;
        f12 = drawerArrowDrawable.mBarGap;
        n12 = (int)(f13 - (f11 *= f12)) / 4 * 2;
        f13 = n12;
        n10 = 1069547520;
        f11 = 1.5f;
        f14 = f14 * f11 + f12;
        float f23 = rect.centerX();
        canvas2.translate(f23, f13 += f14);
        int n16 = drawerArrowDrawable.mSpin;
        if (n16 != 0) {
            n16 = drawerArrowDrawable.mVerticalMirror ^ n15;
            if (n16 != 0) {
                n11 = -1;
                f12 = 0.0f / 0.0f;
            } else {
                n11 = 1;
                f12 = Float.MIN_VALUE;
            }
            f23 = n11;
            f19 = f22 * f23;
            canvas2.rotate(f19);
        } else if (n15 != 0) {
            canvas2.rotate(f20);
        }
        rect = drawerArrowDrawable.mPath;
        paint2 = drawerArrowDrawable.mPaint;
        canvas2.drawPath((Path)rect, paint2);
        canvas.restore();
    }

    public float getArrowHeadLength() {
        return this.mArrowHeadLength;
    }

    public float getArrowShaftLength() {
        return this.mArrowShaftLength;
    }

    public float getBarLength() {
        return this.mBarLength;
    }

    public float getBarThickness() {
        return this.mPaint.getStrokeWidth();
    }

    public int getColor() {
        return this.mPaint.getColor();
    }

    public int getDirection() {
        return this.mDirection;
    }

    public float getGapSize() {
        return this.mBarGap;
    }

    public int getIntrinsicHeight() {
        return this.mSize;
    }

    public int getIntrinsicWidth() {
        return this.mSize;
    }

    public int getOpacity() {
        return -3;
    }

    public final Paint getPaint() {
        return this.mPaint;
    }

    public float getProgress() {
        return this.mProgress;
    }

    public boolean isSpinEnabled() {
        return this.mSpin;
    }

    public void setAlpha(int n10) {
        Paint paint = this.mPaint;
        int n11 = paint.getAlpha();
        if (n10 != n11) {
            paint = this.mPaint;
            paint.setAlpha(n10);
            this.invalidateSelf();
        }
    }

    public void setArrowHeadLength(float f10) {
        float f11 = this.mArrowHeadLength;
        float f12 = f11 - f10;
        float f13 = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (f13 != false) {
            this.mArrowHeadLength = f10;
            this.invalidateSelf();
        }
    }

    public void setArrowShaftLength(float f10) {
        float f11 = this.mArrowShaftLength;
        float f12 = f11 - f10;
        float f13 = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (f13 != false) {
            this.mArrowShaftLength = f10;
            this.invalidateSelf();
        }
    }

    public void setBarLength(float f10) {
        float f11 = this.mBarLength;
        float f12 = f11 - f10;
        float f13 = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (f13 != false) {
            this.mBarLength = f10;
            this.invalidateSelf();
        }
    }

    public void setBarThickness(float f10) {
        Paint paint = this.mPaint;
        float f11 = paint.getStrokeWidth();
        float f12 = f11 - f10;
        float f13 = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (f13 != false) {
            paint = this.mPaint;
            paint.setStrokeWidth(f10);
            f13 = 0x40000000;
            f11 = 2.0f;
            double d10 = f10 / f11;
            double d11 = Math.cos(ARROW_HEAD_ANGLE);
            this.mMaxCutForBarSize = f10 = (float)(d10 *= d11);
            this.invalidateSelf();
        }
    }

    public void setColor(int n10) {
        Paint paint = this.mPaint;
        int n11 = paint.getColor();
        if (n10 != n11) {
            paint = this.mPaint;
            paint.setColor(n10);
            this.invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
        this.invalidateSelf();
    }

    public void setDirection(int n10) {
        int n11 = this.mDirection;
        if (n10 != n11) {
            this.mDirection = n10;
            this.invalidateSelf();
        }
    }

    public void setGapSize(float f10) {
        float f11 = this.mBarGap;
        float f12 = f10 - f11;
        float f13 = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (f13 != false) {
            this.mBarGap = f10;
            this.invalidateSelf();
        }
    }

    public void setProgress(float f10) {
        float f11 = this.mProgress;
        float f12 = f11 - f10;
        float f13 = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (f13 != false) {
            this.mProgress = f10;
            this.invalidateSelf();
        }
    }

    public void setSpinEnabled(boolean bl2) {
        boolean bl3 = this.mSpin;
        if (bl3 != bl2) {
            this.mSpin = bl2;
            this.invalidateSelf();
        }
    }

    public void setVerticalMirror(boolean bl2) {
        boolean bl3 = this.mVerticalMirror;
        if (bl3 != bl2) {
            this.mVerticalMirror = bl2;
            this.invalidateSelf();
        }
    }
}

