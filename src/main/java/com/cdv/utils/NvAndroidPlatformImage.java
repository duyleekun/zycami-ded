/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Canvas
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffXfermode
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.Xfermode
 *  android.os.Build$VERSION
 *  android.renderscript.Allocation
 *  android.renderscript.Allocation$MipmapControl
 *  android.renderscript.Element
 *  android.renderscript.RenderScript
 *  android.renderscript.ScriptIntrinsicBlur
 *  android.util.Log
 */
package com.cdv.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.util.Log;
import java.util.concurrent.atomic.AtomicReference;

public class NvAndroidPlatformImage {
    private static final String TAG = "NvAndroidPlatformImage";
    private static AtomicReference m_renderScript;
    private static final boolean m_verbose = false;

    static {
        AtomicReference atomicReference;
        m_renderScript = atomicReference = new AtomicReference();
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void blurTo(Context context, Canvas object, Paint object2, Bitmap bitmap, Bitmap bitmap2, float f10) {
        Allocation.MipmapControl mipmapControl;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 17;
        if (n10 < n11) {
            NvAndroidPlatformImage.copyTo((Canvas)object, object2, (Bitmap)mipmapControl);
            return;
        }
        try {
            float f11;
            void var3_8;
            context = NvAndroidPlatformImage.getRednerScriptContext(context);
            if (context == null) {
                NvAndroidPlatformImage.copyTo((Canvas)object, object2, (Bitmap)mipmapControl);
                return;
            }
            object = Element.U8_4((RenderScript)context);
            object = ScriptIntrinsicBlur.create((RenderScript)context, (Element)object);
            Allocation.MipmapControl mipmapControl2 = Allocation.MipmapControl.MIPMAP_NONE;
            n10 = 129;
            Allocation allocation = Allocation.createFromBitmap((RenderScript)context, (Bitmap)mipmapControl, (Allocation.MipmapControl)mipmapControl2, (int)n10);
            mipmapControl = Allocation.MipmapControl.MIPMAP_NONE;
            context = Allocation.createFromBitmap((RenderScript)context, (Bitmap)var3_8, (Allocation.MipmapControl)mipmapControl, (int)n10);
            float f12 = 25.0f;
            f12 = Math.min(f11, f12);
            f11 = 0.0f;
            f12 = Math.max(f12, 0.0f);
            object.setRadius(f12);
            object.setInput(allocation);
            object.forEach((Allocation)context);
            context.copyTo((Bitmap)var3_8);
            return;
        }
        catch (Exception exception) {
            object = new StringBuilder();
            ((StringBuilder)object).append("");
            String string2 = exception.getMessage();
            ((StringBuilder)object).append(string2);
            object = ((StringBuilder)object).toString();
            String string3 = TAG;
            Log.e((String)string3, (String)object);
            exception.printStackTrace();
        }
    }

    public static void copyTo(Canvas canvas, Paint object, Bitmap object2) {
        PorterDuff.Mode mode = PorterDuff.Mode.SRC;
        PorterDuffXfermode porterDuffXfermode = new PorterDuffXfermode(mode);
        object.setXfermode((Xfermode)porterDuffXfermode);
        canvas.save();
        porterDuffXfermode = null;
        canvas.setMatrix(null);
        porterDuffXfermode = null;
        try {
            canvas.drawBitmap(object2, 0.0f, 0.0f, (Paint)object);
            canvas.restore();
        }
        catch (Exception exception) {
            object = new StringBuilder();
            ((StringBuilder)object).append("");
            object2 = exception.getMessage();
            ((StringBuilder)object).append((String)object2);
            object = ((StringBuilder)object).toString();
            object2 = TAG;
            Log.e((String)object2, (String)object);
            exception.printStackTrace();
        }
    }

    public static void drawBitmap(Canvas canvas, Paint object, int n10, Bitmap bitmap, int n11, int n12, int n13, int n14, float f10, float f11, float f12, float f13) {
        Object object2 = NvAndroidPlatformImage.getXferMode(n10);
        object.setXfermode(object2);
        n10 = 0;
        object2 = null;
        object.setAntiAlias(false);
        n13 += n11;
        n14 += n12;
        object2 = new Rect(n11, n12, n13, n14);
        f12 += f10;
        f13 += f11;
        RectF rectF = new RectF(f10, f11, f12, f13);
        try {
            canvas.drawBitmap(bitmap, (Rect)object2, rectF, (Paint)object);
        }
        catch (Exception exception) {
            object = new StringBuilder();
            ((StringBuilder)object).append("");
            object2 = exception.getMessage();
            ((StringBuilder)object).append((String)object2);
            object = ((StringBuilder)object).toString();
            object2 = TAG;
            Log.e((String)object2, (String)object);
            exception.printStackTrace();
        }
    }

    private static RenderScript getRednerScriptContext(Context object) {
        Object object2;
        block9: {
            try {
                object2 = m_renderScript;
            }
            catch (Exception exception) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("");
                String string2 = exception.getMessage();
                ((StringBuilder)object2).append(string2);
                object2 = ((StringBuilder)object2).toString();
                Log.e((String)TAG, (String)object2);
                exception.printStackTrace();
                return null;
            }
            object2 = ((AtomicReference)object2).get();
            object2 = (RenderScript)object2;
            if (object2 == null) break block9;
            return object2;
        }
        object = RenderScript.create((Context)object);
        object2 = m_renderScript;
        ((AtomicReference)object2).compareAndSet(null, object);
        object = m_renderScript;
        object = object.get();
        return (RenderScript)object;
    }

    public static Xfermode getXferMode(int n10) {
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_OVER;
        switch (n10) {
            default: {
                break;
            }
            case 10: {
                mode = PorterDuff.Mode.XOR;
                break;
            }
            case 9: {
                mode = PorterDuff.Mode.DST_ATOP;
                break;
            }
            case 8: {
                mode = PorterDuff.Mode.SRC_ATOP;
                break;
            }
            case 7: {
                mode = PorterDuff.Mode.DST_OUT;
                break;
            }
            case 6: {
                mode = PorterDuff.Mode.SRC_OUT;
                break;
            }
            case 5: {
                mode = PorterDuff.Mode.DST_IN;
                break;
            }
            case 4: {
                mode = PorterDuff.Mode.SRC_IN;
                break;
            }
            case 3: {
                mode = PorterDuff.Mode.SRC;
                break;
            }
            case 2: {
                mode = PorterDuff.Mode.CLEAR;
                break;
            }
            case 1: {
                mode = PorterDuff.Mode.DST_OVER;
            }
        }
        PorterDuffXfermode porterDuffXfermode = new PorterDuffXfermode(mode);
        return porterDuffXfermode;
    }

    public static void setupProjection(Canvas canvas, Bitmap object, float f10, float f11, float f12, float f13) {
        int n10 = object.getWidth();
        int n11 = object.getHeight();
        Matrix matrix = new Matrix();
        f10 = -f10;
        f11 = -f11;
        matrix.postTranslate(f10, f11);
        f10 = (float)n10 / f12;
        float f14 = (float)n11 / f13;
        matrix.postScale(f10, f14);
        try {
            canvas.setMatrix(matrix);
        }
        catch (Exception exception) {
            object = new StringBuilder();
            ((StringBuilder)object).append("");
            String string2 = exception.getMessage();
            ((StringBuilder)object).append(string2);
            object = ((StringBuilder)object).toString();
            string2 = TAG;
            Log.e((String)string2, (String)object);
            exception.printStackTrace();
        }
    }
}

