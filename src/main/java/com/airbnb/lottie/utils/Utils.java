/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  android.graphics.Path
 *  android.graphics.PathMeasure
 *  android.graphics.PointF
 *  android.graphics.RectF
 *  android.os.Build$VERSION
 *  android.provider.Settings$Global
 *  android.provider.Settings$System
 *  android.util.DisplayMetrics
 */
package com.airbnb.lottie.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build;
import android.provider.Settings;
import android.util.DisplayMetrics;
import com.airbnb.lottie.L;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.content.TrimPathContent;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.utils.Utils$1;
import com.airbnb.lottie.utils.Utils$2;
import com.airbnb.lottie.utils.Utils$3;
import com.airbnb.lottie.utils.Utils$4;
import java.io.Closeable;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import javax.net.ssl.SSLException;

public final class Utils {
    private static final float INV_SQRT_2 = 0.0f;
    public static final int SECOND_IN_NANOS = 1000000000;
    private static float dpScale;
    private static final ThreadLocal threadLocalPathMeasure;
    private static final ThreadLocal threadLocalPoints;
    private static final ThreadLocal threadLocalTempPath;
    private static final ThreadLocal threadLocalTempPath2;

    static {
        ThreadLocal threadLocal = new Utils$1();
        threadLocalPathMeasure = threadLocal;
        threadLocal = new Utils$2();
        threadLocalTempPath = threadLocal;
        threadLocal = new Utils$3();
        threadLocalTempPath2 = threadLocal;
        threadLocal = new Utils$4();
        threadLocalPoints = threadLocal;
        double d10 = 2.0;
        INV_SQRT_2 = (float)(Math.sqrt(d10) / d10);
        dpScale = -1.0f;
    }

    private Utils() {
    }

    public static void applyTrimPathIfNeeded(Path path, float f10, float f11, float f12) {
        double d10;
        float f13;
        double d11;
        double d12;
        float f14;
        String string2 = "applyTrimPathIfNeeded";
        L.beginSection(string2);
        PathMeasure pathMeasure = (PathMeasure)threadLocalPathMeasure.get();
        Path path2 = (Path)threadLocalTempPath.get();
        Path path3 = (Path)threadLocalTempPath2.get();
        pathMeasure.setPath(path, false);
        float f15 = pathMeasure.getLength();
        int n10 = 1065353216;
        float f16 = 1.0f;
        Object object = f10 == f16 ? 0 : (f10 > f16 ? 1 : -1);
        if (object == false && (object = (f14 = f11 - 0.0f) == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1)) == false) {
            L.endSection(string2);
            return;
        }
        object = f15 == f16 ? 0 : (f15 < f16 ? -1 : 1);
        if (object >= 0 && (n10 = (int)((d12 = (d11 = (double)(f16 = Math.abs(f13 = f11 - f10 - f16))) - (d10 = 0.01)) == 0.0 ? 0 : (d12 < 0.0 ? -1 : 1))) >= 0) {
            float f17;
            float f18;
            int n11;
            float f19;
            f16 = Math.min(f10 *= f15, f11 *= f15);
            f10 = Math.max(f10, f11);
            float f20 = (f16 += (f12 *= f15)) - f15;
            Object object2 = f20 == 0.0f ? 0 : (f20 > 0.0f ? 1 : -1);
            if (object2 >= 0 && (object2 = (f19 = (f10 += f12) - f15) == 0.0f ? 0 : (f19 > 0.0f ? 1 : -1)) >= 0) {
                object2 = MiscUtils.floorMod(f16, f15);
                f16 = object2;
                n11 = MiscUtils.floorMod(f10, f15);
                f10 = n11;
            }
            if ((object2 = (f18 = f16 - 0.0f) == 0.0f ? 0 : (f18 < 0.0f ? -1 : 1)) < 0) {
                object2 = MiscUtils.floorMod(f16, f15);
                f16 = object2;
            }
            if ((object2 = (f17 = f10 - 0.0f) == 0.0f ? 0 : (f17 < 0.0f ? -1 : 1)) < 0) {
                n11 = MiscUtils.floorMod(f10, f15);
                f10 = n11;
            }
            if ((object2 = f16 == f10 ? 0 : (f16 > f10 ? 1 : -1)) == false) {
                path.reset();
                L.endSection(string2);
                return;
            }
            if (object2 >= 0) {
                f16 -= f15;
            }
            path2.reset();
            object2 = true;
            f11 = Float.MIN_VALUE;
            pathMeasure.getSegment(f16, f10, path2, (boolean)object2);
            float f21 = f10 == f15 ? 0 : (f10 > f15 ? 1 : -1);
            if (f21 > 0) {
                path3.reset();
                pathMeasure.getSegment(0.0f, f10 %= f15, path3, (boolean)object2);
                path2.addPath(path3);
            } else {
                float f22 = f16 - 0.0f;
                n11 = (int)(f22 == 0.0f ? 0 : (f22 < 0.0f ? -1 : 1));
                if (n11 < 0) {
                    path3.reset();
                    pathMeasure.getSegment(f16 += f15, f15, path3, (boolean)object2);
                    path2.addPath(path3);
                }
            }
            path.set(path2);
            L.endSection(string2);
            return;
        }
        L.endSection(string2);
    }

    public static void applyTrimPathIfNeeded(Path path, TrimPathContent object) {
        boolean bl2;
        if (object != null && !(bl2 = ((TrimPathContent)object).isHidden())) {
            FloatKeyframeAnimation floatKeyframeAnimation = (FloatKeyframeAnimation)((TrimPathContent)object).getStart();
            float f10 = floatKeyframeAnimation.getFloatValue();
            FloatKeyframeAnimation floatKeyframeAnimation2 = (FloatKeyframeAnimation)((TrimPathContent)object).getEnd();
            float f11 = floatKeyframeAnimation2.getFloatValue();
            object = (FloatKeyframeAnimation)((TrimPathContent)object).getOffset();
            float f12 = ((FloatKeyframeAnimation)object).getFloatValue();
            float f13 = 100.0f;
            f10 /= f13;
            f11 /= f13;
            f13 = 360.0f;
            Utils.applyTrimPathIfNeeded(path, f10, f11, f12 /= f13);
        }
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            }
            catch (RuntimeException runtimeException) {
                throw runtimeException;
            }
            catch (Exception exception) {}
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static Path createPath(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        Path path = new Path();
        float f10 = pointF.x;
        float f11 = pointF.y;
        path.moveTo(f10, f11);
        if (pointF3 != null && pointF4 != null) {
            float f12;
            float f13;
            f10 = pointF3.length();
            f11 = 0.0f;
            float f14 = f10 - 0.0f;
            Object object = f14 == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1);
            if (object != false || (f13 = (f12 = (f10 = pointF4.length()) - 0.0f) == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1)) != false) {
                f10 = pointF.x;
                f11 = pointF3.x + f10;
                float f15 = pointF.y;
                float f16 = pointF3.y;
                float f17 = f15 + f16;
                float f18 = pointF2.x;
                f15 = pointF4.x;
                float f19 = f18 + f15;
                float f20 = pointF2.y;
                f15 = pointF4.y;
                float f21 = f20 + f15;
                path.cubicTo(f11, f17, f19, f21, f18, f20);
                return path;
            }
        }
        float f22 = pointF2.x;
        float f23 = pointF2.y;
        path.lineTo(f22, f23);
        return path;
    }

    public static float dpScale() {
        float f10 = dpScale;
        float f11 = -1.0f;
        float f12 = f10 - f11;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object == false) {
            DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
            dpScale = f10 = displayMetrics.density;
        }
        return dpScale;
    }

    public static float getAnimationScale(Context context) {
        int n10 = Build.VERSION.SDK_INT;
        float f10 = 1.0f;
        String string2 = "animator_duration_scale";
        int n11 = 17;
        if (n10 >= n11) {
            return Settings.Global.getFloat((ContentResolver)context.getContentResolver(), (String)string2, (float)f10);
        }
        return Settings.System.getFloat((ContentResolver)context.getContentResolver(), (String)string2, (float)f10);
    }

    public static float getScale(Matrix matrix) {
        float[] fArray = (float[])threadLocalPoints.get();
        fArray[0] = 0.0f;
        int n10 = 1;
        fArray[n10] = 0.0f;
        float f10 = INV_SQRT_2;
        int n11 = 2;
        fArray[n11] = f10;
        int n12 = 3;
        fArray[n12] = f10;
        matrix.mapPoints(fArray);
        float f11 = fArray[n11];
        float f12 = fArray[0];
        f11 -= f12;
        f12 = fArray[n12];
        float f13 = fArray[n10];
        double d10 = f11;
        double d11 = f12 -= f13;
        return (float)Math.hypot(d10, d11);
    }

    public static boolean hasZeroScaleAxis(Matrix matrix) {
        float f10;
        float f11;
        float[] fArray = (float[])threadLocalPoints.get();
        fArray[0] = 0.0f;
        int n10 = 1;
        fArray[n10] = 0.0f;
        int n11 = 2;
        fArray[n11] = 37394.73f;
        int n12 = 3;
        fArray[n12] = 39575.234f;
        matrix.mapPoints(fArray);
        float f12 = fArray[0];
        float f13 = fArray[n11];
        float f14 = f12 == f13 ? 0 : (f12 > f13 ? 1 : -1);
        if (f14 != false && (f14 = (f11 = (f12 = fArray[n10]) - (f10 = fArray[n12])) == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1)) != false) {
            return false;
        }
        return n10 != 0;
    }

    public static int hashFor(float f10, float f11, float f12, float f13) {
        float f14;
        float f15;
        float f16;
        float f17;
        int n10;
        float f18 = f10 - 0.0f;
        Object object = f18 == 0.0f ? 0 : (f18 > 0.0f ? 1 : -1);
        if (object != false) {
            object = 527;
            float f19 = (float)object * f10;
            n10 = (int)f19;
        } else {
            n10 = 17;
            f10 = 2.4E-44f;
        }
        object = (f17 = f11 - 0.0f) == 0.0f ? 0 : (f17 > 0.0f ? 1 : -1);
        if (object != false) {
            f10 = (float)(n10 * 31) * f11;
            n10 = (int)f10;
        }
        if ((f16 = (f15 = f12 - 0.0f) == 0.0f ? 0 : (f15 > 0.0f ? 1 : -1)) != false) {
            f10 = (float)(n10 * 31) * f12;
            n10 = (int)f10;
        }
        if ((f16 = (f14 = f13 - 0.0f) == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1)) != false) {
            f10 = (float)(n10 * 31) * f13;
            n10 = (int)f10;
        }
        return n10;
    }

    public static boolean isAtLeastVersion(int n10, int n11, int n12, int n13, int n14, int n15) {
        boolean bl2 = false;
        if (n10 < n13) {
            return false;
        }
        boolean bl3 = true;
        if (n10 > n13) {
            return bl3;
        }
        if (n11 < n14) {
            return false;
        }
        if (n11 > n14) {
            return bl3;
        }
        if (n12 >= n15) {
            bl2 = bl3;
        }
        return bl2;
    }

    public static boolean isNetworkException(Throwable throwable) {
        boolean bl2;
        boolean bl3 = throwable instanceof SocketException;
        if (!(bl3 || (bl3 = throwable instanceof ClosedChannelException) || (bl3 = throwable instanceof InterruptedIOException) || (bl3 = throwable instanceof ProtocolException) || (bl3 = throwable instanceof SSLException) || (bl3 = throwable instanceof UnknownHostException) || (bl2 = throwable instanceof UnknownServiceException))) {
            bl2 = false;
            throwable = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public static Bitmap renderPath(Path path) {
        RectF rectF = new RectF();
        path.computeBounds(rectF, false);
        int n10 = (int)rectF.right;
        int n11 = (int)rectF.bottom;
        Object object = Bitmap.Config.ARGB_8888;
        rectF = Bitmap.createBitmap((int)n10, (int)n11, (Bitmap.Config)object);
        Canvas canvas = new Canvas((Bitmap)rectF);
        object = new LPaint();
        object.setAntiAlias(true);
        object.setColor(-16776961);
        canvas.drawPath(path, (Paint)object);
        return rectF;
    }

    public static Bitmap resizeBitmapIfNeeded(Bitmap bitmap, int n10, int n11) {
        int n12 = bitmap.getWidth();
        if (n12 == n10 && (n12 = bitmap.getHeight()) == n11) {
            return bitmap;
        }
        Bitmap bitmap2 = Bitmap.createScaledBitmap((Bitmap)bitmap, (int)n10, (int)n11, (boolean)true);
        bitmap.recycle();
        return bitmap2;
    }

    public static void saveLayerCompat(Canvas canvas, RectF rectF, Paint paint) {
        Utils.saveLayerCompat(canvas, rectF, paint, 31);
    }

    public static void saveLayerCompat(Canvas canvas, RectF rectF, Paint paint, int n10) {
        String string2 = "Utils#saveLayer";
        L.beginSection(string2);
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 23;
        if (n11 < n12) {
            canvas.saveLayer(rectF, paint, n10);
        } else {
            canvas.saveLayer(rectF, paint);
        }
        L.endSection(string2);
    }
}

