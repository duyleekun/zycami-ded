/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.BitmapShader
 *  android.graphics.Canvas
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffXfermode
 *  android.graphics.RectF
 *  android.graphics.Shader
 *  android.graphics.Shader$TileMode
 *  android.graphics.Xfermode
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.Log
 */
package d.c.a.o.m.d;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Xfermode;
import android.os.Build;
import android.util.Log;
import d.c.a.o.k.x.e;
import d.c.a.o.m.d.d0$a;
import d.c.a.o.m.d.d0$b;
import d.c.a.o.m.d.d0$c;
import d.c.a.o.m.d.d0$d;
import d.c.a.u.k;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class d0 {
    private static final String a = "TransformationUtils";
    public static final int b = 6;
    private static final Paint c;
    private static final int d = 7;
    private static final Paint e;
    private static final Paint f;
    private static final Set g;
    private static final Lock h;

    static {
        Object object = new Paint(6);
        c = object;
        int n10 = 7;
        object = new Paint(n10);
        e = object;
        String string2 = "XT1092";
        String string3 = "XT1093";
        String string4 = "XT1094";
        String string5 = "XT1095";
        String string6 = "XT1096";
        String string7 = "XT1097";
        String string8 = "XT1098";
        String string9 = "XT1031";
        String string10 = "XT1028";
        String string11 = "XT937C";
        String string12 = "XT1032";
        String string13 = "XT1008";
        String string14 = "XT1033";
        String string15 = "XT1035";
        String string16 = "XT1034";
        String string17 = "XT939G";
        String string18 = "XT1039";
        String string19 = "XT1040";
        String string20 = "XT1042";
        String string21 = "XT1045";
        String string22 = "XT1063";
        String string23 = "XT1064";
        String string24 = "XT1068";
        String string25 = "XT1069";
        String string26 = "XT1072";
        String string27 = "XT1077";
        String string28 = "XT1078";
        String string29 = "XT1079";
        Object object2 = Arrays.asList("XT1085", string2, string3, string4, string5, string6, string7, string8, string9, string10, string11, string12, string13, string14, string15, string16, string17, string18, string19, string20, string21, string22, string23, string24, string25, string26, string27, string28, string29);
        object = new HashSet(object2);
        g = object;
        object2 = Build.MODEL;
        boolean bl2 = object.contains(object2);
        object = bl2 ? new ReentrantLock() : new d0$d();
        h = object;
        object = new Paint(n10);
        f = object;
        object2 = PorterDuff.Mode.SRC_IN;
        PorterDuffXfermode porterDuffXfermode = new PorterDuffXfermode((PorterDuff.Mode)object2);
        object.setXfermode((Xfermode)porterDuffXfermode);
    }

    private d0() {
    }

    private static void a(Bitmap bitmap, Bitmap bitmap2, Matrix matrix) {
        Canvas canvas;
        Lock lock = h;
        lock.lock();
        try {
            canvas = new Canvas(bitmap2);
            bitmap2 = c;
        }
        catch (Throwable throwable) {
            h.unlock();
            throw throwable;
        }
        canvas.drawBitmap(bitmap, matrix, (Paint)bitmap2);
        d0.e(canvas);
        lock.unlock();
    }

    public static Bitmap b(e e10, Bitmap bitmap, int n10, int n11) {
        float f10;
        float f11;
        int n12 = bitmap.getWidth();
        if (n12 == n10 && (n12 = bitmap.getHeight()) == n11) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        int n13 = bitmap.getWidth() * n11;
        int n14 = bitmap.getHeight() * n10;
        float f12 = 0.0f;
        float f13 = 0.5f;
        if (n13 > n14) {
            f11 = n11;
            f10 = bitmap.getHeight();
            f11 /= f10;
            f10 = n10;
            int n15 = bitmap.getWidth();
            float f14 = (float)n15 * f11;
            f12 = (f10 - f14) * f13;
            n14 = 0;
            f10 = 0.0f;
        } else {
            f11 = n10;
            n14 = bitmap.getWidth();
            f10 = n14;
            f11 /= f10;
            f10 = n11;
            int n16 = bitmap.getHeight();
            float f15 = (float)n16 * f11;
            f10 = (f10 - f15) * f13;
        }
        matrix.setScale(f11, f11);
        f11 = (int)(f12 + f13);
        f10 = (int)(f10 + f13);
        matrix.postTranslate(f11, f10);
        Bitmap.Config config = d0.k(bitmap);
        e10 = e10.f(n10, n11, config);
        d0.t(bitmap, (Bitmap)e10);
        d0.a(bitmap, (Bitmap)e10, matrix);
        return e10;
    }

    public static Bitmap c(e object, Bitmap bitmap, int n10, int n11) {
        int n12 = bitmap.getWidth();
        int n13 = 2;
        String string2 = a;
        if (n12 <= n10 && (n12 = bitmap.getHeight()) <= n11) {
            boolean bl2 = Log.isLoggable((String)string2, (int)n13);
            if (bl2) {
                object = "requested target size larger or equal to input, returning input";
                Log.v((String)string2, (String)object);
            }
            return bitmap;
        }
        n12 = (int)(Log.isLoggable((String)string2, (int)n13) ? 1 : 0);
        if (n12 != 0) {
            String string3 = "requested target size too big for input, fit centering instead";
            Log.v((String)string2, (String)string3);
        }
        return d0.f((e)object, bitmap, n10, n11);
    }

    public static Bitmap d(e e10, Bitmap bitmap, int n10, int n11) {
        Paint paint;
        Canvas canvas;
        n10 = Math.min(n10, n11);
        float f10 = n10;
        float f11 = 2.0f;
        float f12 = f10 / f11;
        int bl2 = bitmap.getWidth();
        int n12 = bitmap.getHeight();
        float f13 = bl2;
        float f14 = f10 / f13;
        float f15 = n12;
        float f16 = f10 / f15;
        f14 = Math.max(f14, f16);
        f13 *= f14;
        f14 *= f15;
        f15 = (f10 - f13) / f11;
        f10 = (f10 - f14) / f11;
        RectF rectF = new RectF(f15, f10, f13 += f15, f14 += f10);
        Bitmap bitmap2 = d0.g(e10, bitmap);
        Object object = d0.h(bitmap);
        Bitmap bitmap3 = e10.f(n10, n10, (Bitmap.Config)object);
        boolean bl3 = true;
        f13 = Float.MIN_VALUE;
        bitmap3.setHasAlpha(bl3);
        object = h;
        object.lock();
        try {
            canvas = new Canvas(bitmap3);
            paint = e;
        }
        catch (Throwable throwable) {
            h.unlock();
            throw throwable;
        }
        canvas.drawCircle(f12, f12, f12, paint);
        f12 = 0.0f;
        paint = f;
        canvas.drawBitmap(bitmap2, null, rectF, paint);
        d0.e(canvas);
        object.unlock();
        boolean bl4 = bitmap2.equals(bitmap);
        if (!bl4) {
            e10.d(bitmap2);
        }
        return bitmap3;
    }

    private static void e(Canvas canvas) {
        canvas.setBitmap(null);
    }

    public static Bitmap f(e object, Bitmap bitmap, int n10, int n11) {
        Object object2;
        int n12 = bitmap.getWidth();
        int n13 = 2;
        String string2 = a;
        if (n12 == n10 && (n12 = bitmap.getHeight()) == n11) {
            boolean bl2 = Log.isLoggable((String)string2, (int)n13);
            if (bl2) {
                object = "requested target size matches input, returning input";
                Log.v((String)string2, (String)object);
            }
            return bitmap;
        }
        float f10 = n10;
        float f11 = bitmap.getWidth();
        f10 /= f11;
        f11 = n11;
        float f12 = bitmap.getHeight();
        f10 = Math.min(f10, f11 /= f12);
        f11 = (float)bitmap.getWidth() * f10;
        int n14 = Math.round(f11);
        f12 = (float)bitmap.getHeight() * f10;
        int n15 = Math.round(f12);
        int n16 = bitmap.getWidth();
        if (n16 == n14 && (n14 = bitmap.getHeight()) == n15) {
            boolean bl3 = Log.isLoggable((String)string2, (int)n13);
            if (bl3) {
                object = "adjusted target size matches input, returning input";
                Log.v((String)string2, (String)object);
            }
            return bitmap;
        }
        f11 = (float)bitmap.getWidth() * f10;
        n14 = (int)f11;
        f12 = (float)bitmap.getHeight() * f10;
        n15 = (int)f12;
        Bitmap.Config config = d0.k(bitmap);
        object = object.f(n14, n15, config);
        d0.t(bitmap, (Bitmap)object);
        n13 = (int)(Log.isLoggable((String)string2, (int)n13) ? 1 : 0);
        if (n13 != 0) {
            CharSequence charSequence = new StringBuilder();
            String string3 = "request: ";
            charSequence.append(string3);
            charSequence.append(n10);
            object2 = "x";
            charSequence.append((String)object2);
            charSequence.append(n11);
            CharSequence charSequence2 = charSequence.toString();
            Log.v((String)string2, (String)charSequence2);
            charSequence2 = new StringBuilder();
            ((StringBuilder)charSequence2).append("toFit:   ");
            n13 = bitmap.getWidth();
            ((StringBuilder)charSequence2).append(n13);
            ((StringBuilder)charSequence2).append((String)object2);
            n13 = bitmap.getHeight();
            ((StringBuilder)charSequence2).append(n13);
            charSequence2 = ((StringBuilder)charSequence2).toString();
            Log.v((String)string2, (String)charSequence2);
            charSequence2 = new StringBuilder();
            charSequence = "toReuse: ";
            ((StringBuilder)charSequence2).append((String)charSequence);
            n13 = object.getWidth();
            ((StringBuilder)charSequence2).append(n13);
            ((StringBuilder)charSequence2).append((String)object2);
            n10 = object.getHeight();
            ((StringBuilder)charSequence2).append(n10);
            object2 = ((StringBuilder)charSequence2).toString();
            Log.v((String)string2, (String)object2);
            object2 = new StringBuilder();
            charSequence2 = "minPct:   ";
            ((StringBuilder)object2).append((String)charSequence2);
            ((StringBuilder)object2).append(f10);
            object2 = ((StringBuilder)object2).toString();
            Log.v((String)string2, (String)object2);
        }
        object2 = new Matrix();
        object2.setScale(f10, f10);
        d0.a(bitmap, (Bitmap)object, (Matrix)object2);
        return object;
    }

    private static Bitmap g(e e10, Bitmap bitmap) {
        Bitmap.Config config;
        Bitmap.Config config2 = d0.h(bitmap);
        int n10 = config2.equals((Object)(config = bitmap.getConfig()));
        if (n10 != 0) {
            return bitmap;
        }
        n10 = bitmap.getWidth();
        int n11 = bitmap.getHeight();
        e10 = e10.f(n10, n11, config2);
        config2 = new Canvas((Bitmap)e10);
        config2.drawBitmap(bitmap, 0.0f, 0.0f, null);
        return e10;
    }

    private static Bitmap.Config h(Bitmap bitmap) {
        Bitmap.Config config;
        boolean bl2;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 >= n11 && (bl2 = (config = Bitmap.Config.RGBA_F16).equals((Object)(bitmap = bitmap.getConfig())))) {
            return Bitmap.Config.RGBA_F16;
        }
        return Bitmap.Config.ARGB_8888;
    }

    public static Lock i() {
        return h;
    }

    public static int j(int n10) {
        switch (n10) {
            default: {
                n10 = 0;
                break;
            }
            case 7: 
            case 8: {
                n10 = 270;
                break;
            }
            case 5: 
            case 6: {
                n10 = 90;
                break;
            }
            case 3: 
            case 4: {
                n10 = 180;
            }
        }
        return n10;
    }

    private static Bitmap.Config k(Bitmap bitmap) {
        Bitmap.Config config = bitmap.getConfig();
        bitmap = config != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888;
        return bitmap;
    }

    public static void l(int n10, Matrix matrix) {
        float f10 = -90.0f;
        float f11 = 90.0f;
        float f12 = 180.0f;
        float f13 = 1.0f;
        float f14 = -1.0f;
        switch (n10) {
            default: {
                break;
            }
            case 8: {
                matrix.setRotate(f10);
                break;
            }
            case 7: {
                matrix.setRotate(f10);
                matrix.postScale(f14, f13);
                break;
            }
            case 6: {
                matrix.setRotate(f11);
                break;
            }
            case 5: {
                matrix.setRotate(f11);
                matrix.postScale(f14, f13);
                break;
            }
            case 4: {
                matrix.setRotate(f12);
                matrix.postScale(f14, f13);
                break;
            }
            case 3: {
                matrix.setRotate(f12);
                break;
            }
            case 2: {
                matrix.setScale(f14, f13);
            }
        }
    }

    public static boolean m(int n10) {
        switch (n10) {
            default: {
                return false;
            }
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
        }
        return true;
    }

    public static Bitmap n(Bitmap bitmap, int n10) {
        block8: {
            if (n10 != 0) {
                Matrix matrix = new Matrix();
                float f10 = n10;
                matrix.setRotate(f10);
                String string2 = null;
                int n11 = bitmap.getWidth();
                int n12 = bitmap.getHeight();
                boolean bl2 = true;
                String string3 = bitmap;
                try {
                    bitmap = Bitmap.createBitmap((Bitmap)bitmap, (int)0, (int)0, (int)n11, (int)n12, (Matrix)matrix, (boolean)bl2);
                }
                catch (Exception exception) {
                    string2 = a;
                    boolean bl3 = Log.isLoggable((String)string2, (int)6);
                    if (!bl3) break block8;
                    string3 = "Exception when trying to orient image";
                    Log.e((String)string2, (String)string3, (Throwable)exception);
                }
            }
        }
        return bitmap;
    }

    public static Bitmap o(e e10, Bitmap bitmap, int n10) {
        boolean bl2 = d0.m(n10);
        if (!bl2) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        d0.l(n10, matrix);
        float f10 = bitmap.getWidth();
        float f11 = bitmap.getHeight();
        RectF rectF = new RectF(0.0f, 0.0f, f10, f11);
        matrix.mapRect(rectF);
        int n11 = Math.round(rectF.width());
        int n12 = Math.round(rectF.height());
        Bitmap.Config config = d0.k(bitmap);
        e10 = e10.f(n11, n12, config);
        f10 = -rectF.left;
        float f12 = -rectF.top;
        matrix.postTranslate(f10, f12);
        n10 = (int)(bitmap.hasAlpha() ? 1 : 0);
        e10.setHasAlpha(n10 != 0);
        d0.a(bitmap, (Bitmap)e10, matrix);
        return e10;
    }

    public static Bitmap p(e e10, Bitmap bitmap, float f10, float f11, float f12, float f13) {
        d0$b d0$b = new d0$b(f10, f11, f12, f13);
        return d0.s(e10, bitmap, d0$b);
    }

    public static Bitmap q(e e10, Bitmap bitmap, int n10) {
        d0$a d0$a;
        boolean bl2;
        if (n10 > 0) {
            bl2 = true;
        } else {
            bl2 = false;
            d0$a = null;
        }
        k.a(bl2, "roundingRadius must be greater than 0.");
        d0$a = new d0$a(n10);
        return d0.s(e10, bitmap, d0$a);
    }

    public static Bitmap r(e e10, Bitmap bitmap, int n10, int n11, int n12) {
        return d0.q(e10, bitmap, n12);
    }

    private static Bitmap s(e e10, Bitmap bitmap, d0$c d0$c) {
        PorterDuff.Mode mode;
        Canvas canvas;
        Bitmap.Config config = d0.h(bitmap);
        Bitmap bitmap2 = d0.g(e10, bitmap);
        int bl2 = bitmap2.getWidth();
        int n10 = bitmap2.getHeight();
        config = e10.f(bl2, n10, config);
        boolean bl3 = true;
        config.setHasAlpha(bl3);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        Object object = new BitmapShader(bitmap2, tileMode, tileMode);
        tileMode = new Paint();
        tileMode.setAntiAlias(bl3);
        tileMode.setShader((Shader)object);
        n10 = config.getWidth();
        float f10 = n10;
        int n11 = config.getHeight();
        float f11 = n11;
        RectF rectF = new RectF(0.0f, 0.0f, f10, f11);
        object = h;
        object.lock();
        try {
            canvas = new Canvas((Bitmap)config);
            mode = PorterDuff.Mode.CLEAR;
        }
        catch (Throwable throwable) {
            h.unlock();
            throw throwable;
        }
        canvas.drawColor(0, mode);
        d0$c.a(canvas, (Paint)tileMode, rectF);
        d0.e(canvas);
        object.unlock();
        boolean bl4 = bitmap2.equals(bitmap);
        if (!bl4) {
            e10.d(bitmap2);
        }
        return config;
    }

    public static void t(Bitmap bitmap, Bitmap bitmap2) {
        boolean bl2 = bitmap.hasAlpha();
        bitmap2.setHasAlpha(bl2);
    }
}

