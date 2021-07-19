/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Matrix
 *  android.graphics.Rect
 *  android.util.AttributeSet
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnTouchListener
 *  android.view.ViewConfiguration
 *  android.widget.ImageView
 *  com.mob.tools.utils.BitmapHelper
 */
package com.mob.tools.gui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ImageView;
import com.mob.tools.MobLog;
import com.mob.tools.gui.ScaledImageView$OnMatrixChangedListener;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.BitmapHelper;

public class ScaledImageView
extends ImageView
implements View.OnTouchListener {
    private static final int DRAG_1 = 1;
    private static final int DRAG_2 = 2;
    private static final int NONE = 0;
    private static final int ZOOM = 3;
    private Bitmap bitmap;
    private float distSquare;
    private float[] downPoint;
    private int dragScrollMinDistSquare;
    private ScaledImageView$OnMatrixChangedListener listener;
    private Matrix matrix;
    private int mode;
    private Matrix savedMatrix;

    public ScaledImageView(Context context) {
        super(context);
        this.init(context);
    }

    public ScaledImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.init(context);
    }

    public ScaledImageView(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        this.init(context);
    }

    private void init(Context context) {
        int n10;
        this.dragScrollMinDistSquare = n10 = ViewConfiguration.get((Context)context).getScaledTouchSlop();
        n10 *= n10;
        this.dragScrollMinDistSquare = n10;
        this.setOnTouchListener(this);
    }

    public Bitmap getCropedBitmap(Rect object) {
        Object object2;
        int n10;
        block12: {
            int n11;
            try {
                n11 = this.getWidth();
            }
            catch (Throwable throwable) {
                MobLog.getInstance().w(throwable);
                return null;
            }
            n10 = this.getHeight();
            object2 = BitmapHelper.captureView((View)this, (int)n11, (int)n10);
            if (object2 != null) break block12;
            object = MobLog.getInstance();
            object2 = "ivPhoto.getDrawingCache() returns null";
            ((NLog)object).w((String)object2);
            return null;
        }
        n10 = ((Rect)object).left;
        int n12 = ((Rect)object).top;
        int n13 = object.width();
        int n14 = object.height();
        object = Bitmap.createBitmap((Bitmap)object2, (int)n10, (int)n12, (int)n13, (int)n14);
        object2.recycle();
        return object;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public boolean onTouch(View var1_1, MotionEvent var2_2) {
        block125: {
            block129: {
                block128: {
                    block130: {
                        block127: {
                            block126: {
                                var3_4 = 1;
                                var4_5 = var2_2.getAction();
                                var5_6 = 2;
                                var6_7 = 2.8E-45f;
                                var7_8 = 0.0f;
                                if (var4_5 == 0) break block125;
                                if (var4_5 == var3_4) ** GOTO lbl277
                                var8_9 = 3;
                                var9_10 = 4.2E-45f;
                                if (var4_5 == var5_6) ** GOTO lbl137
                                var10_11 = 5;
                                var11_12 = 7.0E-45f;
                                if (var4_5 == var10_11) ** GOTO lbl101
                                var10_11 = 6;
                                var11_12 = 8.4E-45f;
                                if (var4_5 == var10_11) ** GOTO lbl82
                                var10_11 = 261;
                                var11_12 = 3.66E-43f;
                                if (var4_5 == var10_11) ** GOTO lbl46
                                var8_9 = 262;
                                var9_10 = 3.67E-43f;
                                if (var4_5 == var8_9) break block126;
                                return false;
                            }
                            var12_14 = new float[var5_6];
                            var6_7 = var2_2.getX(0);
                            var12_14[0] = var6_7;
                            var13_15 = var2_2.getY(0);
                            var12_14[var3_4] = var13_15;
                            this.downPoint = (float[])var12_14;
                            var2_2 = this.savedMatrix;
                            var12_14 = this.matrix;
                            var2_2.set((Matrix)var12_14);
                            this.mode = var3_4;
                            ** GOTO lbl343
lbl46:
                            // 1 sources

                            var12_14 = new float[var5_6];
                            var11_12 = var2_2.getX(0);
                            var12_14[0] = var11_12;
                            var11_12 = var2_2.getY(0);
                            var12_14[var3_4] = var11_12;
                            var14_24 = new float[var5_6];
                            var11_12 = var2_2.getX(var3_4);
                            var14_24[0] = var11_12;
                            var13_16 = var2_2.getY(var3_4);
                            var14_24[var3_4] = var13_16;
                            var13_16 = (float)var12_14[0];
                            var7_8 = var14_24[0];
                            var13_16 -= var7_8;
                            var15_30 = var12_14[var3_4];
                            var6_7 = var14_24[var3_4];
                            var15_30 -= var6_7;
                            var13_16 *= var13_16;
                            var15_30 *= var15_30;
                            var13_16 += var15_30;
                            this.distSquare = var13_16;
                            this.mode = var8_9;
                            ** GOTO lbl343
lbl82:
                            // 1 sources

                            var12_14 = new float[var5_6];
                            var9_10 = var2_2.getX(var3_4);
                            var12_14[0] = var9_10;
                            var13_17 = var2_2.getY(var3_4);
                            var12_14[var3_4] = var13_17;
                            this.downPoint = (float[])var12_14;
                            var2_2 = this.savedMatrix;
                            var12_14 = this.matrix;
                            var2_2.set((Matrix)var12_14);
                            this.mode = var5_6;
                            ** GOTO lbl343
lbl101:
                            // 1 sources

                            var12_14 = new float[var5_6];
                            var11_12 = var2_2.getX(0);
                            var12_14[0] = var11_12;
                            var11_12 = var2_2.getY(0);
                            var12_14[var3_4] = var11_12;
                            var14_25 = new float[var5_6];
                            var11_12 = var2_2.getX(var3_4);
                            var14_25[0] = var11_12;
                            var13_18 = var2_2.getY(var3_4);
                            var14_25[var3_4] = var13_18;
                            var13_18 = (float)var12_14[0];
                            var7_8 = var14_25[0];
                            var13_18 -= var7_8;
                            var15_31 = var12_14[var3_4];
                            var6_7 = var14_25[var3_4];
                            var15_31 -= var6_7;
                            var13_18 *= var13_18;
                            var15_31 *= var15_31;
                            var13_18 += var15_31;
                            this.distSquare = var13_18;
                            this.mode = var8_9;
                            ** GOTO lbl343
lbl137:
                            // 1 sources

                            var4_5 = this.mode;
                            if (var4_5 != var3_4) break block127;
                            var12_14 = new float[var5_6];
                            var6_7 = var2_2.getX(0);
                            var12_14[0] = var6_7;
                            var13_19 = var2_2.getY(0);
                            var12_14[var3_4] = var13_19;
                            var2_2 = this.matrix;
                            var14_26 = this.savedMatrix;
                            var2_2.set(var14_26);
                            var2_2 = this.matrix;
                            var6_7 = (float)var12_14[0];
                            var16_36 = this.downPoint;
                            var7_8 = var16_36[0];
                            var6_7 -= var7_8;
                            var15_32 = var12_14[var3_4];
                            var7_8 = var16_36[var3_4];
                            var15_32 -= var7_8;
                            var2_2.postTranslate(var6_7, (float)var15_32);
                            ** GOTO lbl343
                        }
                        if (var4_5 != var5_6) break block130;
                        var12_14 = new float[var5_6];
                        var6_7 = var2_2.getX(var3_4);
                        var12_14[0] = var6_7;
                        var13_20 = var2_2.getY(var3_4);
                        var12_14[var3_4] = var13_20;
                        var2_2 = this.matrix;
                        var14_27 = this.savedMatrix;
                        var2_2.set(var14_27);
                        var2_2 = this.matrix;
                        var6_7 = (float)var12_14[0];
                        var16_37 = this.downPoint;
                        var7_8 = var16_37[0];
                        var6_7 -= var7_8;
                        var15_33 = var12_14[var3_4];
                        var7_8 = var16_37[var3_4];
                        var15_33 -= var7_8;
                        var2_2.postTranslate(var6_7, (float)var15_33);
                        ** GOTO lbl343
                    }
                    if (var4_5 != var8_9) ** GOTO lbl343
                    var12_14 = new float[var5_6];
                    var9_10 = var2_2.getX(0);
                    var12_14[0] = var9_10;
                    var9_10 = var2_2.getY(0);
                    var12_14[var3_4] = var9_10;
                    var16_38 = new float[var5_6];
                    var11_13 = var2_2.getX(var3_4);
                    var16_38[0] = var11_13;
                    var13_21 = var2_2.getY(var3_4);
                    var16_38[var3_4] = var13_21;
                    var13_21 = (float)var12_14[0];
                    var11_13 = var16_38[0];
                    var13_21 -= var11_13;
                    var11_13 = (float)var12_14[var3_4];
                    var17_40 = var16_38[var3_4];
                    var11_13 -= var17_40;
                    var13_21 *= var13_21;
                    var11_13 *= var11_13;
                    var13_21 += var11_13;
                    var18_41 = this.matrix;
                    var19_42 = this.savedMatrix;
                    var18_41.set(var19_42);
                    var11_13 = this.distSquare;
                    var20_43 = var13_21 /= var11_13;
                    var20_43 = Math.sqrt(var20_43);
                    var13_21 = (float)var20_43;
                    var14_28 = new float[var5_6];
                    var11_13 = (float)var12_14[0];
                    var17_40 = var16_38[0];
                    var11_13 += var17_40;
                    var17_40 = 2.0f;
                    var11_13 /= var17_40;
                    var14_28[0] = var11_13;
                    var15_34 = var12_14[var3_4];
                    var9_10 = var16_38[var3_4];
                    var15_34 = (var15_34 + var9_10) / var17_40;
                    var14_28[var3_4] = (float)var15_34;
                    var12_14 = this.matrix;
                    var7_8 = var14_28[0];
                    var6_7 = var14_28[var3_4];
                    var12_14.postScale(var13_21, var13_21, var7_8, var6_7);
                    ** GOTO lbl343
lbl277:
                    // 1 sources

                    var12_14 = this.listener;
                    if (var12_14 == null) break block128;
                    var14_29 /* !! */  = this.matrix;
                    var12_14.onMactrixChage(var14_29 /* !! */ );
                }
                var15_35 = var2_2.getX(0);
                var14_29 /* !! */  = (Matrix)this.downPoint;
                var6_7 = (float)var14_29 /* !! */ [0];
                var15_35 -= var6_7;
                var13_22 = var2_2.getY(0);
                var14_29 /* !! */  = (Matrix)this.downPoint;
                var6_7 = (float)var14_29 /* !! */ [var3_4];
                var13_22 -= var6_7;
                var5_6 = this.mode;
                if (var5_6 != var3_4) break block129;
                var15_35 *= var15_35;
                var13_22 *= var13_22;
                var15_35 += var13_22;
                var13_22 = this.dragScrollMinDistSquare;
                var22_44 = var15_35 == var13_22 ? 0 : (var15_35 < var13_22 ? -1 : 1);
                if (var22_44 > 0) break block129;
                this.performClick();
            }
            this.mode = 0;
            ** GOTO lbl343
        }
        var12_14 = new Matrix();
        this.matrix = var12_14;
        var16_39 = this.getImageMatrix();
        var12_14.set(var16_39);
        var12_14 = new Matrix();
        this.savedMatrix = var12_14;
        var16_39 = this.matrix;
        var12_14.set(var16_39);
        var12_14 = new float[var5_6];
        var6_7 = var2_2.getX(0);
        var12_14[0] = var6_7;
        var13_23 = var2_2.getY(0);
        var12_14[var3_4] = var13_23;
        this.downPoint = (float[])var12_14;
        this.mode = var3_4;
lbl343:
        // 10 sources

        var2_2 = this.matrix;
        try {
            this.setImageMatrix((Matrix)var2_2);
        }
        catch (Throwable var2_3) {
            var12_14 = MobLog.getInstance();
            var12_14.w(var2_3);
        }
        return (boolean)var3_4;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void rotateLeft() {
        Matrix matrix;
        Matrix matrix2;
        float[] fArray;
        int n10;
        float[] fArray2;
        float f10;
        int n11;
        int n12;
        float f11;
        int n13;
        int n14;
        float f12;
        float f13;
        Object object;
        Object object2;
        ScaledImageView scaledImageView = this;
        try {
            object2 = new Matrix();
            this.matrix = object2;
            int n15 = 9;
            object = new float[n15];
            int n16 = 0;
            f13 = 0.0f;
            Object var7_8 = null;
            object[0] = 0.0f;
            f12 = 1.0f;
            n14 = 1;
            object[n14] = f12;
            n13 = 2;
            object[n13] = 0.0f;
            int n17 = 3;
            f11 = 4.2E-45f;
            int n18 = -1082130432;
            float f14 = -1.0f;
            object[n17] = f14;
            n12 = 4;
            f11 = 5.6E-45f;
            object[n12] = 0.0f;
            n18 = 5;
            f14 = 7.0E-45f;
            object[n18] = 0.0f;
            n11 = 6;
            f10 = 8.4E-45f;
            object[n11] = 0.0f;
            n11 = 7;
            f10 = 9.8E-45f;
            object[n11] = 0.0f;
            n16 = 8;
            f13 = 1.1E-44f;
            object[n16] = f12;
            object2.setValues((float[])object);
            Bitmap bitmap = this.bitmap;
            int n19 = bitmap.getWidth();
            object2 = this.bitmap;
            int n20 = object2.getHeight();
            Matrix matrix3 = this.matrix;
            boolean bl2 = true;
            object2 = Bitmap.createBitmap((Bitmap)bitmap, (int)0, (int)0, (int)n19, (int)n20, (Matrix)matrix3, (boolean)bl2);
            if (object2 != null && (n16 = (int)(object2.isRecycled() ? 1 : 0)) == 0) {
                Bitmap bitmap2 = this.bitmap;
                bitmap2.recycle();
                this.bitmap = object2;
            }
            object2 = scaledImageView.bitmap;
            scaledImageView.setImageBitmap((Bitmap)object2);
            object2 = new Matrix();
            scaledImageView.matrix = object2;
            Matrix matrix4 = this.getImageMatrix();
            object2.set(matrix4);
            object2 = scaledImageView.matrix;
            object2.getValues((float[])object);
            object2 = new int[n13];
            n16 = this.getWidth();
            object2[0] = (Matrix)n16;
            n16 = this.getHeight();
            object2[n14] = (Matrix)n16;
            fArray2 = new float[n13];
            f12 = (float)object[0];
            bitmap = scaledImageView.bitmap;
            n11 = bitmap.getWidth();
        }
        catch (Throwable throwable) {
            object = MobLog.getInstance();
            ((NLog)object).w(throwable);
            return;
        }
        f10 = n11;
        {
            fArray2[0] = f12 *= f10;
            f12 = (float)object[n12];
            Bitmap bitmap = scaledImageView.bitmap;
            n10 = bitmap.getHeight();
        }
        f11 = n10;
        {
            fArray2[n14] = f12 *= f11;
            fArray = new float[n13];
            matrix2 = object2[0];
        }
        f11 = (float)matrix2;
        {
            f10 = fArray2[0];
            f11 -= f10;
            n11 = 0x40000000;
            f10 = 2.0f;
        }
        {
            fArray[0] = f11 /= f10;
            matrix = object2[n14];
        }
        float f15 = (float)matrix;
        {
            f13 = fArray2[n14];
        }
        f15 = (f15 - f13) / f10;
        {
            fArray[n14] = f15;
            f15 = fArray[0];
            object[n13] = f15;
            f15 = fArray[n14];
            object[n18] = f15;
            object2 = scaledImageView.matrix;
            object2.setValues((float[])object);
            object2 = scaledImageView.listener;
            if (object2 != null) {
                object = scaledImageView.matrix;
                object2.onMactrixChage((Matrix)object);
            }
            object2 = scaledImageView.matrix;
            scaledImageView.setImageMatrix((Matrix)object2);
            return;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void rotateRight() {
        Matrix matrix;
        Matrix matrix2;
        float[] fArray;
        int n10;
        float[] fArray2;
        float f10;
        int n11;
        float f11;
        float f12;
        int n12;
        int n13;
        int n14;
        float f13;
        Object object;
        Object object2;
        ScaledImageView scaledImageView = this;
        try {
            object2 = new Matrix();
            this.matrix = object2;
            int n15 = 9;
            object = new float[n15];
            int n16 = 0;
            f13 = 0.0f;
            Object var7_8 = null;
            object[0] = 0.0f;
            n14 = -1082130432;
            float f14 = -1.0f;
            n13 = 1;
            object[n13] = f14;
            n14 = 2;
            f14 = 2.8E-45f;
            object[n14] = 0.0f;
            n12 = 3;
            f12 = 4.2E-45f;
            int n17 = 1065353216;
            f11 = 1.0f;
            object[n12] = f11;
            n12 = 4;
            f12 = 5.6E-45f;
            object[n12] = 0.0f;
            int n18 = 5;
            object[n18] = 0.0f;
            n11 = 6;
            f10 = 8.4E-45f;
            object[n11] = 0.0f;
            n11 = 7;
            f10 = 9.8E-45f;
            object[n11] = 0.0f;
            n16 = 8;
            f13 = 1.1E-44f;
            object[n16] = f11;
            object2.setValues((float[])object);
            Bitmap bitmap = this.bitmap;
            int n19 = bitmap.getWidth();
            object2 = this.bitmap;
            int n20 = object2.getHeight();
            Matrix matrix3 = this.matrix;
            boolean bl2 = true;
            object2 = Bitmap.createBitmap((Bitmap)bitmap, (int)0, (int)0, (int)n19, (int)n20, (Matrix)matrix3, (boolean)bl2);
            if (object2 != null && (n16 = (int)(object2.isRecycled() ? 1 : 0)) == 0) {
                Bitmap bitmap2 = this.bitmap;
                bitmap2.recycle();
                this.bitmap = object2;
            }
            object2 = scaledImageView.bitmap;
            scaledImageView.setImageBitmap((Bitmap)object2);
            object2 = new Matrix();
            scaledImageView.matrix = object2;
            Matrix matrix4 = this.getImageMatrix();
            object2.set(matrix4);
            object2 = scaledImageView.matrix;
            object2.getValues((float[])object);
            object2 = new int[n14];
            n16 = this.getWidth();
            object2[0] = (Matrix)n16;
            n16 = this.getHeight();
            object2[n13] = (Matrix)n16;
            fArray2 = new float[n14];
            f11 = (float)object[0];
            bitmap = scaledImageView.bitmap;
            n11 = bitmap.getWidth();
        }
        catch (Throwable throwable) {
            object = MobLog.getInstance();
            ((NLog)object).w(throwable);
            return;
        }
        f10 = n11;
        {
            fArray2[0] = f11 *= f10;
            f12 = (float)object[n12];
            Bitmap bitmap = scaledImageView.bitmap;
            n10 = bitmap.getHeight();
        }
        f11 = n10;
        {
            fArray2[n13] = f12 *= f11;
            fArray = new float[n14];
            matrix2 = object2[0];
        }
        f11 = (float)matrix2;
        {
            f10 = fArray2[0];
            f11 -= f10;
            n11 = 0x40000000;
            f10 = 2.0f;
        }
        {
            fArray[0] = f11 /= f10;
            matrix = object2[n13];
        }
        float f15 = (float)matrix;
        {
            f13 = fArray2[n13];
        }
        f15 = (f15 - f13) / f10;
        {
            fArray[n13] = f15;
            f15 = fArray[0];
            object[n14] = f15;
            f15 = fArray[n13];
            object[n18] = f15;
            object2 = scaledImageView.matrix;
            object2.setValues((float[])object);
            object2 = scaledImageView.listener;
            if (object2 != null) {
                object = scaledImageView.matrix;
                object2.onMactrixChage((Matrix)object);
            }
            object2 = scaledImageView.matrix;
            scaledImageView.setImageMatrix((Matrix)object2);
            return;
        }
    }

    public void setBitmap(Bitmap object) {
        int n10;
        int n11;
        this.bitmap = object;
        this.setImageBitmap((Bitmap)object);
        int n12 = 2;
        Object object2 = new int[n12];
        object2[0] = n11 = this.getWidth();
        n11 = this.getHeight();
        int n13 = 1;
        object2[n13] = n11;
        Object object3 = new int[n12];
        object3[0] = n10 = this.bitmap.getWidth();
        object3[n13] = n10 = this.bitmap.getHeight();
        int[] nArray = BitmapHelper.fixRect((int[])object3, (int[])object2);
        int[] nArray2 = new int[n12];
        int n14 = object2[0];
        int n15 = nArray[0];
        nArray2[0] = n14 = (n14 - n15) / n12;
        int n16 = object2[n13];
        n14 = nArray[n13];
        nArray2[n13] = n16 = (n16 - n14) / n12;
        object = new float[n12];
        float f10 = nArray[0];
        n14 = object3[0];
        float f11 = n14;
        object[0] = (Bitmap)(f10 /= f11);
        f10 = nArray[n13];
        float f12 = object3[n13];
        object[n13] = (Bitmap)(f10 /= f12);
        object2 = new Matrix;
        object2();
        this.matrix = (Matrix)object2;
        object3 = this.getImageMatrix();
        object2.set((Matrix)object3);
        object2 = this.matrix;
        f12 = (float)object[0];
        Bitmap bitmap = object[n13];
        object2.postScale(f12, (float)bitmap);
        object = this.matrix;
        n16 = nArray2[0];
        f10 = n16;
        n11 = nArray2[n13];
        f12 = n11;
        object.postTranslate(f10, f12);
        object = this.listener;
        if (object != null) {
            object2 = this.matrix;
            object.onMactrixChage((Matrix)object2);
        }
        object = this.matrix;
        this.setImageMatrix((Matrix)object);
    }

    public void setOnMatrixChangedListener(ScaledImageView$OnMatrixChangedListener scaledImageView$OnMatrixChangedListener) {
        this.listener = scaledImageView$OnMatrixChangedListener;
        Matrix matrix = this.matrix;
        if (matrix != null) {
            if (scaledImageView$OnMatrixChangedListener != null) {
                scaledImageView$OnMatrixChangedListener.onMactrixChage(matrix);
            }
            scaledImageView$OnMatrixChangedListener = this.matrix;
            this.setImageMatrix((Matrix)scaledImageView$OnMatrixChangedListener);
        }
    }

    public void zoomIn() {
        Object object = new Matrix();
        this.matrix = object;
        Matrix matrix = this.getImageMatrix();
        object.set(matrix);
        object = this.matrix;
        float f10 = 1.072f;
        object.postScale(f10, f10);
        object = this.listener;
        if (object != null) {
            matrix = this.matrix;
            object.onMactrixChage(matrix);
        }
        object = this.matrix;
        this.setImageMatrix((Matrix)object);
    }

    public void zoomOut() {
        Object object = new Matrix();
        this.matrix = object;
        Matrix matrix = this.getImageMatrix();
        object.set(matrix);
        object = this.matrix;
        float f10 = 0.933f;
        object.postScale(f10, f10);
        object = this.listener;
        if (object != null) {
            matrix = this.matrix;
            object.onMactrixChage(matrix);
        }
        object = this.matrix;
        this.setImageMatrix((Matrix)object);
    }
}

