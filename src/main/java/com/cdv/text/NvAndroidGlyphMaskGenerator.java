/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.Color
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  android.graphics.Paint$Join
 *  android.graphics.Paint$Style
 *  android.graphics.Path
 *  android.graphics.PointF
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffXfermode
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.SurfaceTexture
 *  android.graphics.Typeface
 *  android.graphics.Xfermode
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.Looper
 *  android.text.TextPaint
 *  android.util.Log
 *  android.view.Surface
 */
package com.cdv.text;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.graphics.Typeface;
import android.graphics.Xfermode;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextPaint;
import android.util.Log;
import android.view.Surface;
import com.cdv.text.NvAndroidGlyphMaskGenerator$1;
import com.cdv.text.NvAndroidTextLayout;
import com.cdv.text.NvAndroidTextLayout$GlyphInfo;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class NvAndroidGlyphMaskGenerator {
    private static final String TAG = "NvAndroidGlyphMaskGenerator";
    private static final boolean m_verbose = false;
    private Handler m_hander;
    private HandlerThread m_handlerThread;
    private Semaphore m_hardwareRenderingSem;
    private Surface m_surface;
    private int m_surfaceHeight;
    private SurfaceTexture m_surfaceTexture;
    private int m_surfaceWidth;

    public NvAndroidGlyphMaskGenerator(int n10) {
        block13: {
            boolean bl2 = false;
            CharSequence charSequence = null;
            this.m_surfaceWidth = 0;
            this.m_surfaceHeight = 0;
            Object object = new Semaphore(0);
            this.m_hardwareRenderingSem = object;
            bl2 = this.canUseHardwareRenderer();
            if (!bl2) break block13;
            object = "Glyph Mask Generator Watcher";
            super((String)object);
            this.m_handlerThread = charSequence;
            charSequence.start();
            object = this.m_handlerThread;
            object = object.getLooper();
            super((Looper)object);
            this.m_hander = charSequence;
            super(n10);
            this.m_surfaceTexture = charSequence;
            NvAndroidGlyphMaskGenerator$1 nvAndroidGlyphMaskGenerator$1 = new NvAndroidGlyphMaskGenerator$1(this);
            object = this.m_hander;
            try {
                charSequence.setOnFrameAvailableListener(nvAndroidGlyphMaskGenerator$1, (Handler)object);
            }
            catch (Exception exception) {
                charSequence = new StringBuilder();
                charSequence.append("");
                object = exception.getMessage();
                charSequence.append((String)object);
                charSequence = charSequence.toString();
                object = TAG;
                Log.e((String)object, (String)charSequence);
                exception.printStackTrace();
            }
        }
    }

    public static /* synthetic */ Semaphore access$000(NvAndroidGlyphMaskGenerator nvAndroidGlyphMaskGenerator) {
        return nvAndroidGlyphMaskGenerator.m_hardwareRenderingSem;
    }

    private PointF calcGlyphSizeInCanvasPixel(NvAndroidTextLayout$GlyphInfo nvAndroidTextLayout$GlyphInfo, Canvas canvas) {
        if ((canvas = canvas.getMatrix()) == null) {
            float f10 = nvAndroidTextLayout$GlyphInfo.bounding.width();
            float f11 = nvAndroidTextLayout$GlyphInfo.bounding.height();
            canvas = new PointF(f10, f11);
            return canvas;
        }
        float[] fArray = new float[4];
        fArray[0] = 0.0f;
        int n10 = 1;
        fArray[n10] = 0.0f;
        float f12 = nvAndroidTextLayout$GlyphInfo.bounding.width();
        int n11 = 2;
        fArray[n11] = f12;
        float f13 = nvAndroidTextLayout$GlyphInfo.bounding.height();
        int n12 = 3;
        fArray[n12] = f13;
        canvas.mapPoints(fArray);
        float f14 = fArray[n11];
        float f15 = fArray[0];
        f14 = Math.abs(f14 - f15);
        f15 = fArray[n12];
        float f16 = fArray[n10];
        f16 = Math.abs(f15 - f16);
        nvAndroidTextLayout$GlyphInfo = new PointF(f14, f16);
        return nvAndroidTextLayout$GlyphInfo;
    }

    private Surface prepareSurface(int n10, int n11) {
        int n12;
        Object object = this.m_surface;
        SurfaceTexture surfaceTexture = null;
        int n13 = 1;
        n12 = object != null && n10 <= (n12 = this.m_surfaceWidth) && n11 <= (n12 = this.m_surfaceHeight) ? 0 : n13;
        if (n12 == 0) {
            return object;
        }
        n12 = 0;
        if (object != null) {
            object.release();
            this.m_surface = null;
            this.m_surfaceWidth = 0;
            this.m_surfaceHeight = 0;
        }
        n10 = n10 + 128 - n13;
        try {
            n10 = n10 / 128 * 128;
        }
        catch (Exception exception) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("");
            object = exception.getMessage();
            charSequence.append((String)object);
            charSequence = charSequence.toString();
            Log.e((String)TAG, (String)charSequence);
            exception.printStackTrace();
            return null;
        }
        int n14 = this.m_surfaceWidth;
        n10 = Math.max(n10, n14);
        n11 = n11 + 128 - n13;
        n11 = n11 / 128 * 128;
        n14 = this.m_surfaceHeight;
        n11 = Math.max(n11, n14);
        object = this.m_surfaceTexture;
        object.setDefaultBufferSize(n10, n11);
        surfaceTexture = this.m_surfaceTexture;
        object = new Surface(surfaceTexture);
        this.m_surface = object;
        this.m_surfaceWidth = n10;
        this.m_surfaceHeight = n11;
        return object;
    }

    private Paint selectPaint(NvAndroidTextLayout nvAndroidTextLayout, boolean bl2) {
        if ((nvAndroidTextLayout = nvAndroidTextLayout.getPaint()) == null) {
            return null;
        }
        if (!bl2) {
            return nvAndroidTextLayout;
        }
        Paint paint = new Paint();
        Typeface typeface = nvAndroidTextLayout.getTypeface();
        paint.setTypeface(typeface);
        float f10 = nvAndroidTextLayout.getTextSize();
        paint.setTextSize(f10);
        int n10 = nvAndroidTextLayout.isFakeBoldText();
        paint.setFakeBoldText(n10 != 0);
        f10 = nvAndroidTextLayout.getTextSkewX();
        paint.setTextSkewX(f10);
        n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            float f11 = nvAndroidTextLayout.getLetterSpacing();
            paint.setLetterSpacing(f11);
        }
        return paint;
    }

    private Path setupHardwareCanvasForGlyphPath(NvAndroidTextLayout object, int n10, int n11, Path path, Canvas canvas, float f10, float f11, float f12, float f13, int n12, int n13) {
        if ((object = ((NvAndroidTextLayout)object).getGlyphInfo(n10, n11)) == null) {
            return path;
        }
        Matrix matrix = new Matrix();
        float f14 = -f10;
        float f15 = -f12;
        matrix.postTranslate(f14, f15);
        f14 = n12;
        f14 /= (f11 -= f10);
        f10 = n13;
        matrix.postScale(f14, f10 /= (f13 -= f12));
        boolean bl2 = this.shouldDrawGlyphWithPath((NvAndroidTextLayout$GlyphInfo)object);
        n11 = Build.VERSION.SDK_INT;
        int n14 = 28;
        f10 = 3.9E-44f;
        if (n11 < n14 && bl2) {
            if (path == null) {
                return null;
            }
            object = new Path();
            path.transform(matrix, (Path)object);
            return object;
        }
        canvas.concat(matrix);
        return path;
    }

    private boolean shouldDrawGlyphWithPath(NvAndroidTextLayout$GlyphInfo nvAndroidTextLayout$GlyphInfo) {
        int n10;
        int n11 = nvAndroidTextLayout$GlyphInfo.mayHaveContextualForm;
        if (n11 != 0 && (n11 = Build.VERSION.SDK_INT) >= (n10 = 23)) {
            n11 = 0;
            nvAndroidTextLayout$GlyphInfo = null;
        } else {
            n11 = 1;
        }
        return n11 != 0;
    }

    private boolean waitHardwareRenderingFinished() {
        Object object;
        String string2;
        block7: {
            long l10;
            string2 = TAG;
            try {
                object = this.m_hardwareRenderingSem;
                l10 = 5000L;
            }
            catch (Exception exception) {
                CharSequence charSequence = new StringBuilder();
                charSequence.append("");
                String string3 = exception.getMessage();
                charSequence.append(string3);
                charSequence = charSequence.toString();
                Log.e((String)string2, (String)charSequence);
                exception.printStackTrace();
                return false;
            }
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            boolean bl2 = ((Semaphore)object).tryAcquire(l10, timeUnit);
            if (!bl2) break block7;
            object = this.m_surfaceTexture;
            object.updateTexImage();
            return true;
        }
        object = "Hardware rendering wait timed out!";
        Log.e((String)string2, (String)object);
        return false;
    }

    public boolean canUseHardwareRenderer() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        n10 = n10 >= n11 ? 1 : 0;
        return n10 != 0;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public boolean drawColorGlyph(NvAndroidTextLayout var1_1, int var2_2, int var3_3, Canvas var4_4, boolean var5_5) {
        var6_6 = var4_4;
        if (var4_4 == null) {
            return false;
        }
        try {
            var7_8 = var1_1.getGlyphInfo(var2_2, var3_3);
            if (var7_8 == null) {
                return false;
            }
            var8_9 = var1_1;
            var9_10 = var5_5;
        }
        catch (Exception var6_7) {
            var7_8 = new StringBuilder();
            var7_8.append("");
            var8_9 = var6_7.getMessage();
            var7_8.append((String)var8_9);
            var7_8 = var7_8.toString();
            Log.e((String)"NvAndroidGlyphMaskGenerator", (String)var7_8);
            var6_7.printStackTrace();
            return false;
        }
        var10_11 = this.selectPaint(var1_1, (boolean)var5_5);
        if (var10_11 == null) {
            return false;
        }
        var11_12 = 1;
        var12_13 = 1.4E-45f;
        var10_11.setAntiAlias((boolean)var11_12);
        var14_15 = PorterDuff.Mode.SRC;
        var13_14 = new PorterDuffXfermode(var14_15);
        var10_11.setXfermode((Xfermode)var13_14);
        var9_10 = Build.VERSION.SDK_INT;
        var15_16 = 30;
        var16_17 = 4.2E-44f;
        if (var9_10 >= var15_16) ** GOTO lbl-1000
        var13_14 = this.calcGlyphSizeInCanvasPixel((NvAndroidTextLayout$GlyphInfo)var7_8, var4_4);
        var16_17 = var13_14.x;
        var17_18 = 1132462080;
        var18_19 = 256.0f;
        var15_16 = (int)(var16_17 == var18_19 ? 0 : (var16_17 > var18_19 ? 1 : -1));
        if (var15_16 >= 0) ** GOTO lbl-1000
        var19_20 = var13_14.y;
        var9_10 = (int)(var19_20 == var18_19 ? 0 : (var19_20 > var18_19 ? 1 : -1));
        if (var9_10 >= 0) lbl-1000:
        // 2 sources

        {
            var9_10 = var11_12;
            var19_20 = var12_13;
        } else lbl-1000:
        // 2 sources

        {
            var9_10 = 0;
            var13_14 = null;
            var19_20 = 0.0f;
        }
        if (var9_10 == 0) {
            var13_14 = Paint.Style.FILL;
            var10_11.setStyle((Paint.Style)var13_14);
            var8_9 = var1_1.getText();
            var9_10 = var7_8.startCharIdx;
            var15_16 = var7_8.endCharIdx;
            var7_8 = var7_8.pos;
            var18_19 = var7_8.x;
            var20_21 = var7_8.y;
            var7_8 = var4_4;
            var4_4.drawText((String)var8_9, var9_10, var15_16, var18_19, var20_21, var10_11);
            var17_18 = var11_12;
            var18_19 = var12_13;
        } else {
            var13_14 = var7_8.bounding;
            var19_20 = var13_14.width();
            var14_15 = var7_8.bounding;
            var16_17 = var14_15.height();
            var19_20 /= var16_17;
            var16_17 = 1.0f;
            var15_16 = (int)(var19_20 == var16_17 ? 0 : (var19_20 > var16_17 ? 1 : -1));
            var17_18 = 256;
            var18_19 = 3.59E-43f;
            if (var15_16 >= 0) {
                var16_17 = (float)var17_18 / var19_20;
                var9_10 = (int)var16_17;
            } else {
                var16_17 = (float)var17_18 * var19_20;
                var9_10 = (int)var16_17;
                var21_22 = var17_18;
                var17_18 = var9_10;
                var9_10 = var21_22;
                var19_20 = var18_19;
            }
            var14_15 = Bitmap.Config.ARGB_8888;
            var14_15 = Bitmap.createBitmap((int)var17_18, (int)var9_10, (Bitmap.Config)var14_15);
            var14_15.eraseColor(0);
            var22_23 = new Canvas((Bitmap)var14_15);
            var23_24 = new Matrix();
            var24_25 /* !! */  = var7_8.bounding;
            var25_26 = -var24_25 /* !! */ .left;
            var26_27 = -var24_25 /* !! */ .top;
            var23_24.postTranslate(var25_26, var26_27);
            var18_19 = var17_18;
            var24_25 /* !! */  = var7_8.bounding;
            var26_27 = var24_25 /* !! */ .width();
            var18_19 /= var26_27;
            var19_20 = var9_10;
            var24_25 /* !! */  = var7_8.bounding;
            var26_27 = var24_25 /* !! */ .height();
            var19_20 /= var26_27;
            var23_24.postScale(var18_19, var19_20);
            var22_23.setMatrix(var23_24);
            var13_14 = var10_11.getXfermode();
            var23_24 = PorterDuff.Mode.SRC;
            var27_28 = new PorterDuffXfermode((PorterDuff.Mode)var23_24);
            var10_11.setXfermode((Xfermode)var27_28);
            var27_28 = Paint.Style.FILL;
            var10_11.setStyle((Paint.Style)var27_28);
            var24_25 /* !! */  = var1_1.getText();
            var28_29 = var7_8.startCharIdx;
            var29_30 = var7_8.endCharIdx;
            var8_9 = var7_8.pos;
            var30_31 = var8_9.x;
            var31_32 = var8_9.y;
            var17_18 = var11_12;
            var18_19 = var12_13;
            var12_13 = var31_32;
            var22_23.drawText((String)var24_25 /* !! */ , var28_29, var29_30, var30_31, var31_32, var10_11);
            var10_11.setXfermode((Xfermode)var13_14);
            var31_32 = 0.0f;
            var8_9 = null;
            var7_8 = var7_8.bounding;
            var6_6.drawBitmap((Bitmap)var14_15, null, (RectF)var7_8, var10_11);
        }
        return (boolean)var17_18;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean drawDoubleSidedGlyphOutline(NvAndroidTextLayout nvAndroidTextLayout, int n10, int n11, Path path, float f10, Canvas canvas, Paint paint, boolean n12, boolean n13) {
        Path path2 = path;
        Object object = canvas;
        if (canvas == null) return false;
        if (paint == null) {
            return false;
        }
        try {
            Paint paint2;
            int n14;
            Paint paint3;
            Object object2 = nvAndroidTextLayout.getGlyphInfo(n10, n11);
            if (object2 == null) {
                return false;
            }
            int n15 = this.shouldDrawGlyphWithPath((NvAndroidTextLayout$GlyphInfo)object2);
            if (n15 != 0) {
                paint3 = paint;
            } else {
                n14 = n12;
                paint3 = paint2 = this.selectPaint(nvAndroidTextLayout, n12 != 0);
            }
            if (paint3 == null) {
                return false;
            }
            n14 = n13;
            paint3.setAntiAlias(n13 != 0);
            PorterDuff.Mode mode = PorterDuff.Mode.SRC;
            paint2 = new PorterDuffXfermode(mode);
            paint3.setXfermode((Xfermode)paint2);
            paint2 = Paint.Style.STROKE;
            paint3.setStyle((Paint.Style)paint2);
            paint3.setStrokeWidth(f10);
            paint2 = Paint.Join.ROUND;
            paint3.setStrokeJoin((Paint.Join)paint2);
            n14 = 255;
            n14 = Color.argb((int)n14, (int)n14, (int)n14, (int)n14);
            paint3.setColor(n14);
            boolean bl2 = true;
            if (n15 == 0) {
                String string2 = nvAndroidTextLayout.getText();
                n15 = ((NvAndroidTextLayout$GlyphInfo)object2).startCharIdx;
                int n16 = ((NvAndroidTextLayout$GlyphInfo)object2).endCharIdx;
                n14 = ((NvAndroidTextLayout$GlyphInfo)object2).lineStart;
                int n17 = ((NvAndroidTextLayout$GlyphInfo)object2).lineEnd;
                PointF pointF = ((NvAndroidTextLayout$GlyphInfo)object2).pos;
                float f11 = pointF.x;
                float f12 = pointF.y;
                boolean bl3 = ((NvAndroidTextLayout$GlyphInfo)object2).isRtl;
                object = canvas;
                object2 = string2;
                float f13 = f11;
                f11 = f12;
                canvas.drawTextRun((CharSequence)string2, n15, n16, n14, n17, f13, f12, bl3, paint3);
                return bl2;
            }
            if (path2 == null) {
                return false;
            }
            boolean bl4 = path.isEmpty();
            if (bl4) {
                return bl2;
            }
            object.drawPath(path2, paint3);
            return bl2;
        }
        catch (Exception exception) {
            object = new StringBuilder();
            ((StringBuilder)object).append("");
            String string3 = exception.getMessage();
            ((StringBuilder)object).append(string3);
            object = ((StringBuilder)object).toString();
            string3 = TAG;
            Log.e((String)string3, (String)object);
            exception.printStackTrace();
        }
        return false;
    }

    public boolean drawDoubleSidedGlyphOutlineHardware(NvAndroidTextLayout nvAndroidTextLayout, int n10, int n11, Path path, float f10, boolean bl2, float f11, float f12, float f13, float f14, int n12, int n13) {
        Canvas canvas;
        float f15;
        Canvas canvas2;
        Object object;
        Surface surface;
        block15: {
            block14: {
                Object object2;
                Surface surface2;
                block13: {
                    boolean bl3 = this.canUseHardwareRenderer();
                    surface = null;
                    if (!bl3) {
                        return false;
                    }
                    try {
                        surface2 = this.prepareSurface(n12, n13);
                        if (surface2 != null) break block13;
                        return false;
                    }
                    catch (Exception exception) {
                        object2 = new StringBuilder();
                        ((StringBuilder)object2).append("");
                        object = exception.getMessage();
                        ((StringBuilder)object2).append((String)object);
                        object2 = ((StringBuilder)object2).toString();
                        Log.e((String)TAG, (String)object2);
                        exception.printStackTrace();
                        return false;
                    }
                }
                Canvas canvas3 = surface2.lockHardwareCanvas();
                object2 = new Rect(0, 0, n12, n13);
                canvas3.clipRect((Rect)object2);
                object2 = PorterDuff.Mode.SRC;
                canvas3.drawColor(0, (PorterDuff.Mode)object2);
                object2 = this;
                object = nvAndroidTextLayout;
                canvas2 = canvas3;
                f15 = f11;
                canvas = canvas3;
                surface = surface2;
                canvas2 = this.setupHardwareCanvasForGlyphPath(nvAndroidTextLayout, n10, n11, path, canvas3, f11, f12, f13, f14, n12, n13);
                object2 = path;
                if (canvas2 == path) break block14;
                float f16 = n12;
                float f17 = f12 - f11;
                f16 /= f17;
                f17 = n13;
                float f18 = f14 - f13;
                f17 /= f18;
                f15 = f16 = Math.max(f16, f17) * f10;
                break block15;
            }
            f15 = f10;
        }
        TextPaint textPaint = nvAndroidTextLayout.getPaint();
        object = this;
        this.drawDoubleSidedGlyphOutline(nvAndroidTextLayout, n10, n11, (Path)canvas2, f15, canvas, (Paint)textPaint, false, bl2);
        Canvas canvas4 = canvas;
        surface.unlockCanvasAndPost(canvas);
        return this.waitHardwareRenderingFinished();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean drawGlyphBody(NvAndroidTextLayout nvAndroidTextLayout, int n10, int n11, Path path, Canvas canvas, Paint paint, boolean n12, boolean n13) {
        Path path2 = path;
        Object object = canvas;
        if (canvas == null) return false;
        if (paint == null) {
            return false;
        }
        try {
            Paint paint2;
            int n14;
            Paint paint3;
            Object object2 = nvAndroidTextLayout.getGlyphInfo(n10, n11);
            if (object2 == null) {
                return false;
            }
            int n15 = this.shouldDrawGlyphWithPath((NvAndroidTextLayout$GlyphInfo)object2);
            if (n15 != 0) {
                paint3 = paint;
            } else {
                n14 = n12;
                paint3 = paint2 = this.selectPaint(nvAndroidTextLayout, n12 != 0);
            }
            if (paint3 == null) {
                return false;
            }
            n14 = n13;
            paint3.setAntiAlias(n13 != 0);
            PorterDuff.Mode mode = PorterDuff.Mode.SRC;
            paint2 = new PorterDuffXfermode(mode);
            paint3.setXfermode((Xfermode)paint2);
            paint2 = Paint.Style.FILL;
            paint3.setStyle((Paint.Style)paint2);
            n14 = 255;
            n14 = Color.argb((int)n14, (int)n14, (int)n14, (int)n14);
            paint3.setColor(n14);
            boolean bl2 = true;
            if (n15 == 0) {
                String string2 = nvAndroidTextLayout.getText();
                n15 = ((NvAndroidTextLayout$GlyphInfo)object2).startCharIdx;
                int n16 = ((NvAndroidTextLayout$GlyphInfo)object2).endCharIdx;
                n14 = ((NvAndroidTextLayout$GlyphInfo)object2).lineStart;
                int n17 = ((NvAndroidTextLayout$GlyphInfo)object2).lineEnd;
                PointF pointF = ((NvAndroidTextLayout$GlyphInfo)object2).pos;
                float f10 = pointF.x;
                float f11 = pointF.y;
                boolean bl3 = ((NvAndroidTextLayout$GlyphInfo)object2).isRtl;
                object = canvas;
                object2 = string2;
                float f12 = f10;
                f10 = f11;
                canvas.drawTextRun((CharSequence)string2, n15, n16, n14, n17, f12, f11, bl3, paint3);
                return bl2;
            }
            if (path2 == null) {
                return false;
            }
            boolean bl4 = path.isEmpty();
            if (bl4) {
                return bl2;
            }
            object.drawPath(path2, paint3);
            return bl2;
        }
        catch (Exception exception) {
            object = new StringBuilder();
            ((StringBuilder)object).append("");
            String string3 = exception.getMessage();
            ((StringBuilder)object).append(string3);
            object = ((StringBuilder)object).toString();
            string3 = TAG;
            Log.e((String)string3, (String)object);
            exception.printStackTrace();
        }
        return false;
    }

    public boolean drawGlyphBodyHardware(NvAndroidTextLayout nvAndroidTextLayout, int n10, int n11, Path path, boolean bl2, float f10, float f11, float f12, float f13, int n12, int n13) {
        Object object;
        Object object2;
        Surface surface;
        block12: {
            boolean bl3 = this.canUseHardwareRenderer();
            if (!bl3) {
                return false;
            }
            try {
                surface = this.prepareSurface(n12, n13);
                if (surface != null) break block12;
                return false;
            }
            catch (Exception exception) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("");
                object = exception.getMessage();
                ((StringBuilder)object2).append((String)object);
                object2 = ((StringBuilder)object2).toString();
                Log.e((String)TAG, (String)object2);
                exception.printStackTrace();
                return false;
            }
        }
        Canvas canvas = surface.lockHardwareCanvas();
        object2 = new Rect(0, 0, n12, n13);
        canvas.clipRect((Rect)object2);
        object2 = PorterDuff.Mode.SRC;
        canvas.drawColor(0, (PorterDuff.Mode)object2);
        object2 = this;
        object = nvAndroidTextLayout;
        Path path2 = path;
        Canvas canvas2 = canvas;
        path = canvas;
        canvas2 = this.setupHardwareCanvasForGlyphPath(nvAndroidTextLayout, n10, n11, path2, canvas, f10, f11, f12, f13, n12, n13);
        TextPaint textPaint = nvAndroidTextLayout.getPaint();
        object = this;
        this.drawGlyphBody(nvAndroidTextLayout, n10, n11, (Path)canvas2, canvas, (Paint)textPaint, false, bl2);
        Canvas canvas3 = canvas;
        surface.unlockCanvasAndPost(canvas);
        return this.waitHardwareRenderingFinished();
    }

    public int getSurfaceHeight() {
        return this.m_surfaceHeight;
    }

    public int getSurfaceWidth() {
        return this.m_surfaceWidth;
    }

    public void getTransformMatrixOfSurfaceTexture(float[] fArray) {
        SurfaceTexture surfaceTexture = this.m_surfaceTexture;
        if (surfaceTexture != null) {
            surfaceTexture.getTransformMatrix(fArray);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void release() {
        try {
            boolean bl2;
            HandlerThread handlerThread = this.m_handlerThread;
            Object var2_3 = null;
            if (handlerThread != null) {
                bl2 = handlerThread.isAlive();
                if (bl2) {
                    handlerThread = this.m_handlerThread;
                    handlerThread.quit();
                    handlerThread = this.m_handlerThread;
                    handlerThread.join();
                }
                this.m_handlerThread = null;
            }
            this.m_hander = null;
            handlerThread = this.m_surfaceTexture;
            if (handlerThread != null) {
                handlerThread.release();
                this.m_surfaceTexture = null;
            }
            if ((handlerThread = this.m_surface) == null) return;
            handlerThread.release();
            this.m_surface = null;
            bl2 = false;
            handlerThread = null;
            this.m_surfaceWidth = 0;
            this.m_surfaceHeight = 0;
            return;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("");
            String string2 = exception.getMessage();
            stringBuilder.append(string2);
            String string3 = stringBuilder.toString();
            string2 = TAG;
            Log.e((String)string2, (String)string3);
            exception.printStackTrace();
        }
    }
}

