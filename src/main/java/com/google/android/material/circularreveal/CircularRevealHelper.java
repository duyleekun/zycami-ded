/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.BitmapShader
 *  android.graphics.Canvas
 *  android.graphics.Color
 *  android.graphics.Paint
 *  android.graphics.Path
 *  android.graphics.Path$Direction
 *  android.graphics.Rect
 *  android.graphics.Shader
 *  android.graphics.Shader$TileMode
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.view.View
 */
package com.google.android.material.circularreveal;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import com.google.android.material.circularreveal.CircularRevealHelper$Delegate;
import com.google.android.material.circularreveal.CircularRevealWidget$RevealInfo;
import com.google.android.material.math.MathUtils;

public class CircularRevealHelper {
    public static final int BITMAP_SHADER = 0;
    public static final int CLIP_PATH = 1;
    private static final boolean DEBUG = false;
    public static final int REVEAL_ANIMATOR = 2;
    public static final int STRATEGY;
    private boolean buildingCircularRevealCache;
    private Paint debugPaint;
    private final CircularRevealHelper$Delegate delegate;
    private boolean hasCircularRevealCache;
    private Drawable overlayDrawable;
    private CircularRevealWidget$RevealInfo revealInfo;
    private final Paint revealPaint;
    private final Path revealPath;
    private final Paint scrimPaint;
    private final View view;

    static {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            STRATEGY = n10 = 2;
        } else {
            n11 = 18;
            if (n10 >= n11) {
                STRATEGY = n10 = 1;
            } else {
                n10 = 0;
                STRATEGY = 0;
            }
        }
    }

    public CircularRevealHelper(CircularRevealHelper$Delegate circularRevealHelper$Delegate) {
        this.delegate = circularRevealHelper$Delegate;
        circularRevealHelper$Delegate = (View)circularRevealHelper$Delegate;
        this.view = circularRevealHelper$Delegate;
        circularRevealHelper$Delegate.setWillNotDraw(false);
        this.revealPath = circularRevealHelper$Delegate;
        super(7);
        this.revealPaint = circularRevealHelper$Delegate;
        super(1);
        this.scrimPaint = circularRevealHelper$Delegate;
        circularRevealHelper$Delegate.setColor(0);
    }

    private void drawDebugCircle(Canvas canvas, int n10, float f10) {
        this.debugPaint.setColor(n10);
        this.debugPaint.setStrokeWidth(f10);
        CircularRevealWidget$RevealInfo circularRevealWidget$RevealInfo = this.revealInfo;
        float f11 = circularRevealWidget$RevealInfo.centerX;
        float f12 = circularRevealWidget$RevealInfo.centerY;
        float f13 = circularRevealWidget$RevealInfo.radius;
        Paint paint = this.debugPaint;
        canvas.drawCircle(f11, f12, f13 -= (f10 /= 2.0f), paint);
    }

    private void drawDebugMode(Canvas canvas) {
        float f10;
        float f11;
        Object object = this.delegate;
        object.actualDraw(canvas);
        int n10 = this.shouldDrawScrim();
        if (n10 != 0) {
            object = this.revealInfo;
            f11 = ((CircularRevealWidget$RevealInfo)object).centerX;
            float f12 = ((CircularRevealWidget$RevealInfo)object).centerY;
            f10 = ((CircularRevealWidget$RevealInfo)object).radius;
            Paint paint = this.scrimPaint;
            canvas.drawCircle(f11, f12, f10, paint);
        }
        if ((n10 = this.shouldDrawCircularReveal()) != 0) {
            this.drawDebugCircle(canvas, -16777216, 10.0f);
            n10 = -65536;
            f10 = 0.0f / 0.0f;
            f11 = 5.0f;
            this.drawDebugCircle(canvas, n10, f11);
        }
        this.drawOverlayDrawable(canvas);
    }

    private void drawOverlayDrawable(Canvas canvas) {
        int n10 = this.shouldDrawOverlayDrawable();
        if (n10 != 0) {
            Rect rect = this.overlayDrawable.getBounds();
            CircularRevealWidget$RevealInfo circularRevealWidget$RevealInfo = this.revealInfo;
            float f10 = circularRevealWidget$RevealInfo.centerX;
            int n11 = rect.width();
            float f11 = n11;
            float f12 = 2.0f;
            CircularRevealWidget$RevealInfo circularRevealWidget$RevealInfo2 = this.revealInfo;
            f11 = circularRevealWidget$RevealInfo2.centerY;
            n10 = rect.height();
            float f13 = (float)n10 / f12;
            canvas.translate(f10 -= (f11 /= f12), f11 -= f13);
            rect = this.overlayDrawable;
            rect.draw(canvas);
            f13 = -f10;
            f10 = -f11;
            canvas.translate(f13, f10);
        }
    }

    private float getDistanceToFurthestCorner(CircularRevealWidget$RevealInfo circularRevealWidget$RevealInfo) {
        float f10 = circularRevealWidget$RevealInfo.centerX;
        float f11 = circularRevealWidget$RevealInfo.centerY;
        float f12 = this.view.getWidth();
        float f13 = this.view.getHeight();
        return MathUtils.distanceToFurthestCorner(f10, f11, 0.0f, 0.0f, f12, f13);
    }

    private void invalidateRevealInfo() {
        int n10 = STRATEGY;
        int n11 = 1;
        if (n10 == n11) {
            this.revealPath.rewind();
            CircularRevealWidget$RevealInfo circularRevealWidget$RevealInfo = this.revealInfo;
            if (circularRevealWidget$RevealInfo != null) {
                Path path = this.revealPath;
                float f10 = circularRevealWidget$RevealInfo.centerX;
                float f11 = circularRevealWidget$RevealInfo.centerY;
                float f12 = circularRevealWidget$RevealInfo.radius;
                Path.Direction direction = Path.Direction.CW;
                path.addCircle(f10, f11, f12, direction);
            }
        }
        this.view.invalidate();
    }

    private boolean shouldDrawCircularReveal() {
        boolean bl2;
        CircularRevealWidget$RevealInfo circularRevealWidget$RevealInfo = this.revealInfo;
        boolean bl3 = false;
        boolean bl4 = true;
        if (circularRevealWidget$RevealInfo != null && !(bl2 = circularRevealWidget$RevealInfo.isInvalid())) {
            bl2 = false;
            circularRevealWidget$RevealInfo = null;
        } else {
            bl2 = bl4;
        }
        int n10 = STRATEGY;
        if (n10 == 0) {
            if (!bl2 && (bl2 = this.hasCircularRevealCache)) {
                bl3 = bl4;
            }
            return bl3;
        }
        return bl2 ^ bl4;
    }

    private boolean shouldDrawOverlayDrawable() {
        Object object;
        boolean bl2 = this.buildingCircularRevealCache;
        if (!bl2 && (object = this.overlayDrawable) != null && (object = this.revealInfo) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    private boolean shouldDrawScrim() {
        Paint paint;
        int n10 = this.buildingCircularRevealCache;
        if (n10 == 0 && (n10 = Color.alpha((int)(paint = this.scrimPaint).getColor())) != 0) {
            n10 = 1;
        } else {
            n10 = 0;
            paint = null;
        }
        return n10 != 0;
    }

    public void buildCircularRevealCache() {
        int n10 = STRATEGY;
        if (n10 == 0) {
            BitmapShader bitmapShader;
            View view;
            int n11;
            n10 = 1;
            this.buildingCircularRevealCache = n10;
            this.hasCircularRevealCache = false;
            this.view.buildDrawingCache();
            Bitmap bitmap = this.view.getDrawingCache();
            if (bitmap == null && (n11 = (view = this.view).getWidth()) != 0 && (n11 = (view = this.view).getHeight()) != 0) {
                int n12 = this.view.getWidth();
                n11 = this.view.getHeight();
                bitmapShader = Bitmap.Config.ARGB_8888;
                bitmap = Bitmap.createBitmap((int)n12, (int)n11, (Bitmap.Config)bitmapShader);
                view = new Canvas(bitmap);
                bitmapShader = this.view;
                bitmapShader.draw((Canvas)view);
            }
            if (bitmap != null) {
                view = this.revealPaint;
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
                view.setShader((Shader)bitmapShader);
            }
            this.buildingCircularRevealCache = false;
            this.hasCircularRevealCache = n10;
        }
    }

    public void destroyCircularRevealCache() {
        int n10 = STRATEGY;
        if (n10 == 0) {
            n10 = 0;
            this.hasCircularRevealCache = false;
            this.view.destroyDrawingCache();
            this.revealPaint.setShader(null);
            View view = this.view;
            view.invalidate();
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public void draw(Canvas object) {
        block9: {
            int n10;
            block7: {
                block8: {
                    n10 = this.shouldDrawCircularReveal();
                    if (n10 == 0) break block7;
                    n10 = STRATEGY;
                    if (n10 == 0) break block8;
                    int n11 = 1;
                    float f10 = Float.MIN_VALUE;
                    if (n10 != n11) {
                        n11 = 2;
                        f10 = 2.8E-45f;
                        if (n10 != n11) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Unsupported strategy ");
                            stringBuilder.append(n10);
                            String string2 = stringBuilder.toString();
                            IllegalStateException illegalStateException = new IllegalStateException(string2);
                            throw illegalStateException;
                        }
                        CircularRevealHelper$Delegate circularRevealHelper$Delegate = this.delegate;
                        circularRevealHelper$Delegate.actualDraw((Canvas)object);
                        n10 = (int)(this.shouldDrawScrim() ? 1 : 0);
                        if (n10 != 0) {
                            float f11 = 0.0f;
                            Object var7_14 = null;
                            float f12 = this.view.getWidth();
                            circularRevealHelper$Delegate = this.view;
                            n10 = circularRevealHelper$Delegate.getHeight();
                            float f13 = n10;
                            Paint paint = this.scrimPaint;
                            Object object2 = object;
                            object.drawRect(0.0f, 0.0f, f12, f13, paint);
                        }
                        break block9;
                    } else {
                        n10 = object.save();
                        Path path = this.revealPath;
                        object.clipPath(path);
                        CircularRevealHelper$Delegate circularRevealHelper$Delegate = this.delegate;
                        circularRevealHelper$Delegate.actualDraw((Canvas)object);
                        n11 = (int)(this.shouldDrawScrim() ? 1 : 0);
                        if (n11 != 0) {
                            Object var7_15 = null;
                            float f14 = 0.0f;
                            float f15 = this.view.getWidth();
                            View view = this.view;
                            n11 = view.getHeight();
                            float f16 = n11;
                            Paint paint = this.scrimPaint;
                            object.drawRect(0.0f, 0.0f, f15, f16, paint);
                        }
                        object.restoreToCount(n10);
                    }
                    break block9;
                }
                CircularRevealWidget$RevealInfo circularRevealWidget$RevealInfo = this.revealInfo;
                float f17 = circularRevealWidget$RevealInfo.centerX;
                float f18 = circularRevealWidget$RevealInfo.centerY;
                float f19 = circularRevealWidget$RevealInfo.radius;
                Paint paint = this.revealPaint;
                object.drawCircle(f17, f18, f19, paint);
                n10 = (int)(this.shouldDrawScrim() ? 1 : 0);
                if (n10 != 0) {
                    circularRevealWidget$RevealInfo = this.revealInfo;
                    f17 = circularRevealWidget$RevealInfo.centerX;
                    f18 = circularRevealWidget$RevealInfo.centerY;
                    f19 = circularRevealWidget$RevealInfo.radius;
                    paint = this.scrimPaint;
                    object.drawCircle(f17, f18, f19, paint);
                }
                break block9;
            }
            CircularRevealHelper$Delegate circularRevealHelper$Delegate = this.delegate;
            circularRevealHelper$Delegate.actualDraw((Canvas)object);
            n10 = (int)(this.shouldDrawScrim() ? 1 : 0);
            if (n10 != 0) {
                float f20 = 0.0f;
                Object var7_17 = null;
                float f21 = this.view.getWidth();
                circularRevealHelper$Delegate = this.view;
                n10 = circularRevealHelper$Delegate.getHeight();
                float f22 = n10;
                Paint paint = this.scrimPaint;
                Object object3 = object;
                object.drawRect(0.0f, 0.0f, f21, f22, paint);
            }
        }
        this.drawOverlayDrawable((Canvas)object);
    }

    public Drawable getCircularRevealOverlayDrawable() {
        return this.overlayDrawable;
    }

    public int getCircularRevealScrimColor() {
        return this.scrimPaint.getColor();
    }

    public CircularRevealWidget$RevealInfo getRevealInfo() {
        CircularRevealWidget$RevealInfo circularRevealWidget$RevealInfo = this.revealInfo;
        if (circularRevealWidget$RevealInfo == null) {
            return null;
        }
        CircularRevealWidget$RevealInfo circularRevealWidget$RevealInfo2 = new CircularRevealWidget$RevealInfo(circularRevealWidget$RevealInfo);
        boolean bl2 = circularRevealWidget$RevealInfo2.isInvalid();
        if (bl2) {
            float f10;
            circularRevealWidget$RevealInfo2.radius = f10 = this.getDistanceToFurthestCorner(circularRevealWidget$RevealInfo2);
        }
        return circularRevealWidget$RevealInfo2;
    }

    public boolean isOpaque() {
        CircularRevealHelper$Delegate circularRevealHelper$Delegate = this.delegate;
        boolean bl2 = circularRevealHelper$Delegate.actualIsOpaque();
        if (bl2 && !(bl2 = this.shouldDrawCircularReveal())) {
            bl2 = true;
        } else {
            bl2 = false;
            circularRevealHelper$Delegate = null;
        }
        return bl2;
    }

    public void setCircularRevealOverlayDrawable(Drawable drawable2) {
        this.overlayDrawable = drawable2;
        this.view.invalidate();
    }

    public void setCircularRevealScrimColor(int n10) {
        this.scrimPaint.setColor(n10);
        this.view.invalidate();
    }

    public void setRevealInfo(CircularRevealWidget$RevealInfo circularRevealWidget$RevealInfo) {
        if (circularRevealWidget$RevealInfo == null) {
            boolean bl2 = false;
            float f10 = 0.0f;
            circularRevealWidget$RevealInfo = null;
            this.revealInfo = null;
        } else {
            CircularRevealWidget$RevealInfo circularRevealWidget$RevealInfo2 = this.revealInfo;
            if (circularRevealWidget$RevealInfo2 == null) {
                this.revealInfo = circularRevealWidget$RevealInfo2 = new CircularRevealWidget$RevealInfo(circularRevealWidget$RevealInfo);
            } else {
                circularRevealWidget$RevealInfo2.set(circularRevealWidget$RevealInfo);
            }
            float f11 = circularRevealWidget$RevealInfo.radius;
            float f12 = this.getDistanceToFurthestCorner(circularRevealWidget$RevealInfo);
            float f13 = 1.0E-4f;
            boolean bl3 = MathUtils.geq(f11, f12, f13);
            if (bl3) {
                circularRevealWidget$RevealInfo = this.revealInfo;
                circularRevealWidget$RevealInfo.radius = f11 = Float.MAX_VALUE;
            }
        }
        this.invalidateRevealInfo();
    }
}

