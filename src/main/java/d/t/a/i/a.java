/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.BitmapFactory$Options
 *  android.graphics.Canvas
 *  android.graphics.Matrix
 *  android.graphics.Point
 *  android.net.Uri
 *  android.os.AsyncTask
 *  android.util.Log
 *  android.view.WindowManager
 */
package d.t.a.i;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.view.WindowManager;
import d.t.a.f.b;
import d.t.a.i.c;
import d.t.a.i.f;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;

public class a {
    private static final String a = "BitmapLoadUtils";

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int a(BitmapFactory.Options options, int n10, int n11) {
        int n12 = options.outHeight;
        int n13 = options.outWidth;
        int n14 = 1;
        if (n12 <= n11 && n13 <= n10) return n14;
        int n15;
        while ((n15 = n12 / n14) > n11 || (n15 = n13 / n14) > n10) {
            n14 *= 2;
        }
        return n14;
    }

    public static int b(Context context) {
        context = (WindowManager)context.getSystemService("window");
        Object object = new Point();
        if (context != null) {
            context = context.getDefaultDisplay();
            context.getSize((Point)object);
        }
        int n10 = ((Point)object).x;
        int n11 = ((Point)object).y;
        double d10 = n10;
        double d11 = 2.0;
        d10 = Math.pow(d10, d11);
        double d12 = n11;
        d11 = Math.pow(d12, d11);
        double d13 = Math.sqrt(d10 += d11);
        n10 = (int)d13;
        object = new Canvas();
        int n12 = object.getMaximumBitmapWidth();
        n11 = object.getMaximumBitmapHeight();
        if ((n11 = Math.min(n12, n11)) > 0) {
            n10 = Math.min(n10, n11);
        }
        if ((n11 = c.c()) > 0) {
            n10 = Math.min(n10, n11);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("maxBitmapSize: ");
        ((StringBuilder)object).append(n10);
        object = ((StringBuilder)object).toString();
        Log.d((String)a, (String)object);
        return n10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void c(Closeable closeable) {
        if (closeable == null) return;
        boolean bl2 = closeable instanceof Closeable;
        if (!bl2) return;
        try {
            closeable.close();
            return;
        }
        catch (IOException iOException) {
            return;
        }
    }

    public static void d(Context object, Uri objectArray, Uri uri, int n10, int n11, b b10) {
        d.t.a.h.b b11 = new d.t.a.h.b((Context)object, (Uri)objectArray, uri, n10, n11, b10);
        object = AsyncTask.THREAD_POOL_EXECUTOR;
        objectArray = new Void[]{};
        b11.executeOnExecutor((Executor)object, objectArray);
    }

    public static int e(int n10) {
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

    public static int f(int n10) {
        int n11 = 2;
        n10 = n10 != n11 && n10 != (n11 = 7) && n10 != (n11 = 4) && n10 != (n11 = 5) ? 1 : -1;
        return n10;
    }

    public static int g(Context object, Uri object2) {
        int n10;
        block6: {
            n10 = 0;
            object = object.getContentResolver();
            object = object.openInputStream(object2);
            if (object != null) break block6;
            return 0;
        }
        Object object3 = new f((InputStream)object);
        n10 = ((f)object3).c();
        try {
            d.t.a.i.a.c((Closeable)object);
        }
        catch (IOException iOException) {
            object3 = new StringBuilder();
            String string2 = "getExifOrientation: ";
            ((StringBuilder)object3).append(string2);
            object2 = object2.toString();
            ((StringBuilder)object3).append((String)object2);
            object2 = ((StringBuilder)object3).toString();
            object3 = a;
            Log.e((String)object3, (String)object2, (Throwable)iOException);
        }
        return n10;
    }

    public static Bitmap h(Bitmap bitmap, Matrix matrix) {
        String string2 = null;
        int n10 = bitmap.getWidth();
        int n11 = bitmap.getHeight();
        boolean bl2 = true;
        String string3 = bitmap;
        matrix = Bitmap.createBitmap((Bitmap)bitmap, (int)0, (int)0, (int)n10, (int)n11, (Matrix)matrix, (boolean)bl2);
        try {
            boolean bl3 = bitmap.sameAs((Bitmap)matrix);
            if (!bl3) {
                bitmap = matrix;
            }
        }
        catch (OutOfMemoryError outOfMemoryError) {
            string3 = a;
            string2 = "transformBitmap: ";
            Log.e((String)string3, (String)string2, (Throwable)outOfMemoryError);
        }
        return bitmap;
    }
}

