/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.DashPathEffect
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.Path
 *  android.graphics.PathEffect
 *  android.graphics.Rect
 *  android.view.View
 *  androidx.constraintlayout.motion.widget.MotionController
 */
package androidx.constraintlayout.motion.widget;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.Rect;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionController;
import androidx.constraintlayout.motion.widget.MotionLayout;
import java.util.HashMap;

public class MotionLayout$DevModeDraw {
    private static final int DEBUG_PATH_TICKS_PER_MS = 16;
    public final int DIAMOND_SIZE;
    public final int GRAPH_COLOR;
    public final int KEYFRAME_COLOR;
    public final int RED_COLOR;
    public final int SHADOW_COLOR;
    public Rect mBounds;
    public DashPathEffect mDashPathEffect;
    public Paint mFillPaint;
    public int mKeyFrameCount;
    public float[] mKeyFramePoints;
    public Paint mPaint;
    public Paint mPaintGraph;
    public Paint mPaintKeyframes;
    public Path mPath;
    public int[] mPathMode;
    public float[] mPoints;
    public boolean mPresentationMode;
    private float[] mRectangle;
    public int mShadowTranslate;
    public Paint mTextPaint;
    public final /* synthetic */ MotionLayout this$0;

    public MotionLayout$DevModeDraw(MotionLayout object) {
        Paint paint;
        Rect rect;
        int n10;
        int n11;
        int n12;
        this.this$0 = object;
        this.RED_COLOR = n12 = -21965;
        this.KEYFRAME_COLOR = n11 = -2067046;
        this.GRAPH_COLOR = n10 = -13391360;
        this.SHADOW_COLOR = 0x77000000;
        this.DIAMOND_SIZE = 10;
        this.mBounds = rect = new Rect();
        rect = null;
        this.mPresentationMode = false;
        boolean bl2 = true;
        this.mShadowTranslate = bl2;
        this.mPaint = paint = new Paint();
        paint.setAntiAlias(bl2);
        paint = this.mPaint;
        paint.setColor(n12);
        Object object2 = this.mPaint;
        float f10 = 2.0f;
        object2.setStrokeWidth(f10);
        object2 = this.mPaint;
        Paint.Style style2 = Paint.Style.STROKE;
        object2.setStyle(style2);
        this.mPaintKeyframes = object2 = new Paint();
        object2.setAntiAlias(bl2);
        this.mPaintKeyframes.setColor(n11);
        this.mPaintKeyframes.setStrokeWidth(f10);
        object2 = this.mPaintKeyframes;
        Paint.Style style3 = Paint.Style.STROKE;
        object2.setStyle(style3);
        this.mPaintGraph = object2 = new Paint();
        object2.setAntiAlias(bl2);
        this.mPaintGraph.setColor(n10);
        this.mPaintGraph.setStrokeWidth(f10);
        object2 = this.mPaintGraph;
        style3 = Paint.Style.STROKE;
        object2.setStyle(style3);
        this.mTextPaint = object2 = new Paint();
        object2.setAntiAlias(bl2);
        this.mTextPaint.setColor(n10);
        object2 = this.mTextPaint;
        float f11 = object.getContext().getResources().getDisplayMetrics().density * 12.0f;
        object2.setTextSize(f11);
        object = new float[8];
        this.mRectangle = (float[])object;
        object = new Paint();
        this.mFillPaint = object;
        object.setAntiAlias(bl2);
        n12 = 2;
        float f12 = 2.8E-45f;
        Object object3 = object2 = (Object)new float[n12];
        object3[0] = (Paint)4.0f;
        object3[1] = (Paint)8.0f;
        n11 = 0;
        style3 = null;
        object = new DashPathEffect((float[])object2, 0.0f);
        this.mDashPathEffect = object;
        object2 = this.mPaintGraph;
        object2.setPathEffect((PathEffect)object);
        object = new float[100];
        this.mKeyFramePoints = (float[])object;
        f11 = 7.0E-44f;
        object = new int[50];
        this.mPathMode = (int[])object;
        int n13 = this.mPresentationMode;
        if (n13 != 0) {
            object = this.mPaint;
            n12 = 0x41000000;
            f12 = 8.0f;
            object.setStrokeWidth(f12);
            this.mFillPaint.setStrokeWidth(f12);
            object = this.mPaintKeyframes;
            object.setStrokeWidth(f12);
            n13 = 4;
            f11 = 5.6E-45f;
            this.mShadowTranslate = n13;
        }
    }

    private void drawBasicPath(Canvas canvas) {
        float[] fArray = this.mPoints;
        Paint paint = this.mPaint;
        canvas.drawLines(fArray, paint);
    }

    private void drawPathAsConfigured(Canvas canvas) {
        int n10;
        int n11 = 0;
        int n12 = 0;
        for (int i10 = 0; i10 < (n10 = this.mKeyFrameCount); ++i10) {
            int[] nArray = this.mPathMode;
            int n13 = nArray[i10];
            int n14 = 1;
            if (n13 == n14) {
                n11 = n14;
            }
            if ((n10 = nArray[i10]) != (n13 = 2)) continue;
            n12 = n14;
        }
        if (n11 != 0) {
            this.drawPathRelative(canvas);
        }
        if (n12 != 0) {
            this.drawPathCartesian(canvas);
        }
    }

    private void drawPathCartesian(Canvas canvas) {
        Object object = this.mPoints;
        float f10 = object[0];
        int n10 = 1;
        float f11 = object[n10];
        int n11 = ((float[])object).length + -2;
        float f12 = object[n11];
        int n12 = ((float[])object).length - n10;
        float f13 = object[n12];
        float f14 = Math.min(f10, f12);
        float f15 = Math.max(f11, f13);
        float f16 = Math.max(f10, f12);
        float f17 = Math.max(f11, f13);
        Paint paint = this.mPaintGraph;
        canvas.drawLine(f14, f15, f16, f17, paint);
        float f18 = Math.min(f10, f12);
        float f19 = Math.min(f11, f13);
        float f20 = Math.min(f10, f12);
        float f21 = Math.max(f11, f13);
        object = this.mPaintGraph;
        canvas.drawLine(f18, f19, f20, f21, (Paint)object);
    }

    private void drawPathCartesianTicks(Canvas canvas, float f10, float f11) {
        Object object = this.mPoints;
        float f12 = object[0];
        int n10 = 1;
        float f13 = object[n10];
        int n11 = ((float[])object).length + -2;
        float f14 = object[n11];
        int n12 = ((float[])object).length - n10;
        float f15 = object[n12];
        float f16 = Math.min(f12, f14);
        float f17 = Math.max(f13, f15);
        float f18 = Math.min(f12, f14);
        f18 = f10 - f18;
        float f19 = Math.max(f13, f15) - f11;
        CharSequence charSequence = new StringBuilder();
        String string2 = "";
        charSequence.append(string2);
        float f20 = 100.0f;
        float f21 = f18 * f20;
        float f22 = Math.abs(f14 - f12);
        double d10 = f21 / f22;
        double d11 = 0.5;
        f21 = (float)((int)(d10 + d11)) / f20;
        charSequence.append(f21);
        charSequence = charSequence.toString();
        Paint paint = this.mTextPaint;
        this.getTextBounds((String)charSequence, paint);
        f22 = 2.0f;
        f18 /= f22;
        f21 = this.mBounds.width() / 2;
        f18 = f18 - f21 + f16;
        f16 = f11 - 20.0f;
        paint = this.mTextPaint;
        canvas.drawText((String)charSequence, f18, f16, paint);
        f14 = Math.min(f12, f14);
        paint = this.mPaintGraph;
        object = canvas;
        f12 = f10;
        f18 = f11;
        float f23 = f11;
        canvas.drawLine(f10, f11, f14, f11, paint);
        object = new StringBuilder;
        ((StringBuilder)object)();
        ((StringBuilder)object).append(string2);
        f12 = f19 * f20;
        f18 = Math.abs(f15 - f13);
        f12 = (float)((int)((double)(f12 / f18) + d11)) / f20;
        ((StringBuilder)object).append(f12);
        object = ((StringBuilder)object).toString();
        Paint paint2 = this.mTextPaint;
        this.getTextBounds((String)object, paint2);
        f19 /= f22;
        f12 = this.mBounds.height() / 2;
        f19 -= f12;
        f12 = f10 + 5.0f;
        Paint paint3 = this.mTextPaint;
        canvas.drawText((String)object, f12, f17 -= f19, paint3);
        f23 = Math.max(f13, f15);
        paint = this.mPaintGraph;
        object = canvas;
        f12 = f10;
        f18 = f11;
        f14 = f10;
        canvas.drawLine(f10, f11, f10, f23, paint);
    }

    private void drawPathRelative(Canvas canvas) {
        float[] fArray = this.mPoints;
        float f10 = fArray[0];
        int n10 = 1;
        float f11 = fArray[n10];
        int n11 = fArray.length + -2;
        float f12 = fArray[n11];
        n11 = fArray.length - n10;
        float f13 = fArray[n11];
        Paint paint = this.mPaintGraph;
        canvas.drawLine(f10, f11, f12, f13, paint);
    }

    private void drawPathRelativeTicks(Canvas canvas, float f10, float f11) {
        float[] fArray = this.mPoints;
        float f12 = fArray[0];
        int n10 = 1;
        float f13 = fArray[n10];
        int n11 = fArray.length + -2;
        float f14 = fArray[n11];
        int n12 = fArray.length - n10;
        float f15 = fArray[n12];
        double d10 = f12 - f14;
        double d11 = f13 - f15;
        float f16 = (float)Math.hypot(d10, d11);
        float f17 = f10 - f12;
        f17 *= (f14 -= f12);
        float f18 = f11 - f13;
        f17 += (f18 *= (f15 -= f13));
        f18 = f16 * f16;
        float f19 = f12 + (f14 *= (f17 /= f18));
        float f20 = f13 + (f17 *= f15);
        Path path = new Path();
        path.moveTo(f10, f11);
        path.lineTo(f19, f20);
        double d12 = f19 - f10;
        double d13 = f20 - f11;
        f15 = (float)Math.hypot(d12, d13);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        f13 = 100.0f;
        f16 = (float)((int)(f15 * f13 / f16)) / f13;
        stringBuilder.append(f16);
        String string2 = stringBuilder.toString();
        stringBuilder = this.mTextPaint;
        this.getTextBounds(string2, (Paint)stringBuilder);
        f12 = this.mBounds.width() / 2;
        f18 = (f15 /= 2.0f) - f12;
        Paint paint = this.mTextPaint;
        canvas.drawTextOnPath(string2, path, f18, -20.0f, paint);
        Paint paint2 = this.mPaintGraph;
        canvas.drawLine(f10, f11, f19, f20, paint2);
    }

    private void drawPathScreenTicks(Canvas canvas, float f10, float f11, int n10, int n11) {
        CharSequence charSequence = new StringBuilder();
        String string2 = "";
        ((StringBuilder)charSequence).append(string2);
        float f12 = n10 / 2;
        f12 = f10 - f12;
        float f13 = 100.0f;
        float f14 = this.this$0.getWidth() - n10;
        double d10 = (f12 *= f13) / f14;
        double d11 = 0.5;
        f12 = (float)((int)(d10 + d11)) / f13;
        ((StringBuilder)charSequence).append(f12);
        charSequence = ((StringBuilder)charSequence).toString();
        Paint paint = this.mTextPaint;
        this.getTextBounds((String)charSequence, paint);
        float f15 = 2.0f;
        f12 = f10 / f15;
        f14 = this.mBounds.width() / 2;
        f12 = f12 - f14 + 0.0f;
        f14 = f11 - 20.0f;
        Paint paint2 = this.mTextPaint;
        canvas.drawText((String)charSequence, f12, f14, paint2);
        float f16 = 1.0f;
        float f17 = Math.min(0.0f, f16);
        Paint paint3 = this.mPaintGraph;
        charSequence = canvas;
        f12 = f10;
        f14 = f11;
        float f18 = f11;
        canvas.drawLine(f10, f11, f17, f11, paint3);
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append(string2);
        f12 = n11 / 2;
        f12 = (f11 - f12) * f13;
        f14 = this.this$0.getHeight() - n11;
        f12 = (float)((int)((double)(f12 / f14) + d11)) / f13;
        ((StringBuilder)charSequence).append(f12);
        charSequence = ((StringBuilder)charSequence).toString();
        paint = this.mTextPaint;
        this.getTextBounds((String)charSequence, paint);
        f12 = f11 / f15;
        f14 = this.mBounds.height() / 2;
        f12 -= f14;
        f14 = f10 + 5.0f;
        f12 = 0.0f - f12;
        paint2 = this.mTextPaint;
        canvas.drawText((String)charSequence, f14, f12, paint2);
        f18 = Math.max(0.0f, f16);
        paint3 = this.mPaintGraph;
        charSequence = canvas;
        f12 = f10;
        f14 = f11;
        f17 = f10;
        canvas.drawLine(f10, f11, f10, f18, paint3);
    }

    private void drawRectangle(Canvas canvas, MotionController motionController) {
        this.mPath.reset();
        Paint paint = null;
        int n10 = 0;
        while (true) {
            int n11 = 50;
            float f10 = 7.0E-44f;
            if (n10 > n11) break;
            float f11 = n10;
            f10 = n11;
            Object object = this.mRectangle;
            motionController.buildRect(f11 /= f10, object, 0);
            object = this.mPath;
            float[] fArray = this.mRectangle;
            float f12 = fArray[0];
            f11 = fArray[1];
            object.moveTo(f12, f11);
            object = this.mPath;
            fArray = this.mRectangle;
            f12 = fArray[2];
            f11 = fArray[3];
            object.lineTo(f12, f11);
            object = this.mPath;
            fArray = this.mRectangle;
            f12 = fArray[4];
            f11 = fArray[5];
            object.lineTo(f12, f11);
            object = this.mPath;
            fArray = this.mRectangle;
            int n12 = 6;
            f12 = fArray[n12];
            int n13 = 7;
            f11 = fArray[n13];
            object.lineTo(f12, f11);
            object = this.mPath;
            object.close();
            ++n10;
        }
        this.mPaint.setColor(0x44000000);
        float f13 = 2.0f;
        canvas.translate(f13, f13);
        motionController = this.mPath;
        paint = this.mPaint;
        canvas.drawPath((Path)motionController, paint);
        f13 = -2.0f;
        canvas.translate(f13, f13);
        this.mPaint.setColor(-65536);
        motionController = this.mPath;
        paint = this.mPaint;
        canvas.drawPath((Path)motionController, paint);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void drawTicks(Canvas var1_1, int var2_2, int var3_3, MotionController var4_4) {
        var5_5 = this;
        var6_6 = var1_1;
        var7_7 = var2_2;
        var8_8 = var4_4;
        var9_9 /* !! */  = var4_4.mView;
        if (var9_9 /* !! */  != null) {
            var10_10 /* !! */  = var9_9 /* !! */ .getWidth();
            var11_11 /* !! */  = var4_4.mView;
            var12_12 /* !! */  = var11_11 /* !! */ .getHeight();
            var13_13 = var10_10 /* !! */ ;
            var14_14 = var12_12 /* !! */ ;
        } else {
            var13_13 = 0;
            var14_14 = 0;
        }
        var16_16 = var15_15 = 1;
        while (true) {
            block10: {
                block13: {
                    block11: {
                        block9: {
                            block12: {
                                var10_10 /* !! */  = var3_3 + -1;
                                var17_17 = 2;
                                if (var16_16 >= var10_10 /* !! */ ) break;
                                var10_10 /* !! */  = 4;
                                var18_18 /* !! */  = 5.6E-45f;
                                if (var7_7 == var10_10 /* !! */  && (var12_12 /* !! */  = (int)(var11_11 /* !! */  = (View)var5_5.mPathMode)[var19_19 /* !! */  = var16_16 + -1]) == 0) break block10;
                                var11_11 /* !! */  = (View)var5_5.mKeyFramePoints;
                                var19_19 /* !! */  = var16_16 * 2;
                                var20_20 = var11_11 /* !! */ [var19_19 /* !! */ ];
                                var21_21 = var11_11 /* !! */ [var19_19 /* !! */  += var15_15];
                                var5_5.mPath.reset();
                                var11_11 /* !! */  = var5_5.mPath;
                                var19_19 /* !! */  = 1092616192;
                                var22_22 /* !! */  = 10.0f;
                                var23_23 /* !! */  = (float)(var21_21 + var22_22 /* !! */ );
                                var11_11 /* !! */ .moveTo((float)var20_20, var23_23 /* !! */ );
                                var11_11 /* !! */  = var5_5.mPath;
                                var23_23 /* !! */  = (float)(var20_20 + var22_22 /* !! */ );
                                var11_11 /* !! */ .lineTo(var23_23 /* !! */ , (float)var21_21);
                                var11_11 /* !! */  = var5_5.mPath;
                                var23_23 /* !! */  = (float)(var21_21 - var22_22 /* !! */ );
                                var11_11 /* !! */ .lineTo((float)var20_20, var23_23 /* !! */ );
                                var11_11 /* !! */  = var5_5.mPath;
                                var22_22 /* !! */  = (float)(var20_20 - var22_22 /* !! */ );
                                var11_11 /* !! */ .lineTo(var22_22 /* !! */ , (float)var21_21);
                                var11_11 /* !! */  = var5_5.mPath;
                                var11_11 /* !! */ .close();
                                var12_12 /* !! */  = var16_16 + -1;
                                var8_8.getKeyFrame(var12_12 /* !! */ );
                                var24_24 = 3;
                                var23_23 /* !! */  = 4.2E-45f;
                                if (var7_7 != var10_10 /* !! */ ) break block11;
                                var9_9 /* !! */  = (View)var5_5.mPathMode;
                                var19_19 /* !! */  = (int)var9_9 /* !! */ [var12_12 /* !! */ ];
                                if (var19_19 /* !! */  == var15_15) {
                                    var18_18 /* !! */  = (float)(var20_20 - 0.0f);
                                    var25_25 = var21_21 - 0.0f;
                                    var5_5.drawPathRelativeTicks(var6_6, var18_18 /* !! */ , (float)var25_25);
lbl56:
                                    // 3 sources

                                    while (true) {
                                        var26_26 = var24_24;
                                        var27_27 = var21_21;
                                        var28_28 = var20_20;
                                        break block9;
                                        break;
                                    }
                                }
                                var19_19 /* !! */  = (int)var9_9 /* !! */ [var12_12 /* !! */ ];
                                if (var19_19 /* !! */  != var17_17) break block12;
                                var18_18 /* !! */  = (float)(var20_20 - 0.0f);
                                var25_25 = var21_21 - 0.0f;
                                var5_5.drawPathCartesianTicks(var6_6, var18_18 /* !! */ , (float)var25_25);
                                ** GOTO lbl56
                            }
                            var10_10 /* !! */  = (int)var9_9 /* !! */ [var12_12 /* !! */ ];
                            if (var10_10 /* !! */  == var24_24) ** break;
                            ** continue;
                            var22_22 /* !! */  = (float)(var20_20 - 0.0f);
                            var27_27 = var21_21 - 0.0f;
                            var9_9 /* !! */  = this;
                            var11_11 /* !! */  = var1_1;
                            var26_26 = var24_24;
                            var23_23 /* !! */  = (float)var27_27;
                            var27_27 = var21_21;
                            var28_28 = var20_20;
                            this.drawPathScreenTicks(var1_1, var22_22 /* !! */ , var23_23 /* !! */ , var13_13, var14_14);
                        }
                        var9_9 /* !! */  = var5_5.mPath;
                        var11_11 /* !! */  = var5_5.mFillPaint;
                        var6_6.drawPath((Path)var9_9 /* !! */ , (Paint)var11_11 /* !! */ );
                        break block13;
                    }
                    var26_26 = var24_24;
                    var27_27 = var21_21;
                    var28_28 = var20_20;
                }
                if (var7_7 == var17_17) {
                    var20_20 = var28_28 - 0.0f;
                    var21_21 = var27_27 - 0.0f;
                    var5_5.drawPathRelativeTicks(var6_6, (float)var20_20, (float)var21_21);
                }
                if (var7_7 == var26_26) {
                    var20_20 = var28_28 - 0.0f;
                    var21_21 = var27_27 - 0.0f;
                    var5_5.drawPathCartesianTicks(var6_6, (float)var20_20, (float)var21_21);
                }
                var10_10 /* !! */  = 6;
                var18_18 /* !! */  = 8.4E-45f;
                if (var7_7 == var10_10 /* !! */ ) {
                    var22_22 /* !! */  = (float)(var28_28 - 0.0f);
                    var23_23 /* !! */  = (float)(var27_27 - 0.0f);
                    var9_9 /* !! */  = this;
                    var11_11 /* !! */  = var1_1;
                    this.drawPathScreenTicks(var1_1, var22_22 /* !! */ , var23_23 /* !! */ , var13_13, var14_14);
                }
                var9_9 /* !! */  = var5_5.mPath;
                var11_11 /* !! */  = var5_5.mFillPaint;
                var6_6.drawPath((Path)var9_9 /* !! */ , (Paint)var11_11 /* !! */ );
            }
            ++var16_16;
        }
        var9_9 /* !! */  = (View)var5_5.mPoints;
        var12_12 /* !! */  = ((View)var9_9 /* !! */ ).length;
        if (var12_12 /* !! */  > var15_15) {
            var11_11 /* !! */  = null;
            var25_25 = var9_9 /* !! */ [0];
            var18_18 /* !! */  = (float)var9_9 /* !! */ [var15_15];
            var29_29 = var5_5.mPaintKeyframes;
            var24_24 = 0x41000000;
            var23_23 /* !! */  = 8.0f;
            var6_6.drawCircle((float)var25_25, var18_18 /* !! */ , var23_23 /* !! */ , var29_29);
            var9_9 /* !! */  = (View)var5_5.mPoints;
            var12_12 /* !! */  = ((View)var9_9 /* !! */ ).length - var17_17;
            var25_25 = var9_9 /* !! */ [var12_12 /* !! */ ];
            var19_19 /* !! */  = ((View)var9_9 /* !! */ ).length - var15_15;
            var18_18 /* !! */  = (float)var9_9 /* !! */ [var19_19 /* !! */ ];
            var29_29 = var5_5.mPaintKeyframes;
            var6_6.drawCircle((float)var25_25, var18_18 /* !! */ , var23_23 /* !! */ , var29_29);
        }
    }

    private void drawTranslation(Canvas canvas, float f10, float f11, float f12, float f13) {
        Paint paint = this.mPaintGraph;
        canvas.drawRect(f10, f11, f12, f13, paint);
        Paint paint2 = this.mPaintGraph;
        canvas.drawLine(f10, f11, f12, f13, paint2);
    }

    public void draw(Canvas canvas, HashMap object, int n10, int n11) {
        int n12;
        if (object != null && (n12 = ((HashMap)object).size()) != 0) {
            MotionLayout motionLayout;
            Object object2;
            float f10;
            int n13;
            float f11;
            int n14;
            canvas.save();
            Object object3 = this.this$0;
            n12 = object3.isInEditMode() ? 1 : 0;
            if (n12 == 0) {
                n12 = n11 & 1;
                n14 = 2;
                f11 = 2.8E-45f;
                if (n12 == n14) {
                    object3 = new StringBuilder();
                    Object object4 = this.this$0.getContext().getResources();
                    n13 = MotionLayout.access$000(this.this$0);
                    object4 = object4.getResourceName(n13);
                    ((StringBuilder)object3).append((String)object4);
                    ((StringBuilder)object3).append(":");
                    object4 = this.this$0;
                    f11 = ((MotionLayout)object4).getProgress();
                    ((StringBuilder)object3).append(f11);
                    object3 = ((StringBuilder)object3).toString();
                    f10 = this.this$0.getHeight() + -30;
                    object2 = this.mTextPaint;
                    canvas.drawText((String)object3, 10.0f, f10, (Paint)object2);
                    n14 = 1093664768;
                    f11 = 11.0f;
                    motionLayout = this.this$0;
                    n13 = motionLayout.getHeight() + -29;
                    f10 = n13;
                    object2 = this.mPaint;
                    canvas.drawText((String)object3, f11, f10, (Paint)object2);
                }
            }
            object = ((HashMap)object).values().iterator();
            while ((n12 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                int n15;
                int n16;
                object3 = (MotionController)object.next();
                n14 = object3.getDrawPath();
                n13 = 1;
                f10 = Float.MIN_VALUE;
                if (n11 > 0 && n14 == 0) {
                    n14 = n13;
                    f11 = f10;
                }
                if (n14 == 0) continue;
                object2 = this.mKeyFramePoints;
                int[] nArray = this.mPathMode;
                this.mKeyFrameCount = n16 = object3.buildKeyFrames(object2, nArray);
                if (n14 < n13) continue;
                n13 = n10 / 16;
                object2 = this.mPoints;
                if (object2 == null || (n16 = ((float[])object2).length) != (n15 = n13 * 2)) {
                    n16 = n13 * 2;
                    object2 = new float[n16];
                    this.mPoints = object2;
                    object2 = new Path;
                    object2();
                    this.mPath = (Path)object2;
                }
                n16 = this.mShadowTranslate;
                float f12 = n16;
                float f13 = n16;
                canvas.translate(f12, f13);
                object2 = this.mPaint;
                n15 = 0x77000000;
                f12 = 2.5961484E33f;
                object2.setColor(n15);
                this.mFillPaint.setColor(n15);
                this.mPaintKeyframes.setColor(n15);
                this.mPaintGraph.setColor(n15);
                object2 = this.mPoints;
                object3.buildPath(object2, n13);
                n13 = this.mKeyFrameCount;
                this.drawAll(canvas, n14, n13, (MotionController)object3);
                this.mPaint.setColor(-21965);
                motionLayout = this.mPaintKeyframes;
                n16 = -2067046;
                motionLayout.setColor(n16);
                this.mFillPaint.setColor(n16);
                motionLayout = this.mPaintGraph;
                motionLayout.setColor(-13391360);
                n13 = this.mShadowTranslate;
                n16 = -n13;
                f13 = n16;
                f10 = -n13;
                canvas.translate(f13, f10);
                n13 = this.mKeyFrameCount;
                this.drawAll(canvas, n14, n13, (MotionController)object3);
                n13 = 5;
                f10 = 7.0E-45f;
                if (n14 != n13) continue;
                this.drawRectangle(canvas, (MotionController)object3);
            }
            canvas.restore();
        }
    }

    public void drawAll(Canvas canvas, int n10, int n11, MotionController motionController) {
        int n12 = 4;
        if (n10 == n12) {
            this.drawPathAsConfigured(canvas);
        }
        if (n10 == (n12 = 2)) {
            this.drawPathRelative(canvas);
        }
        if (n10 == (n12 = 3)) {
            this.drawPathCartesian(canvas);
        }
        this.drawBasicPath(canvas);
        this.drawTicks(canvas, n10, n11, motionController);
    }

    public void getTextBounds(String string2, Paint paint) {
        int n10 = string2.length();
        Rect rect = this.mBounds;
        paint.getTextBounds(string2, 0, n10, rect);
    }
}

