/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.graphics.Matrix
 *  android.graphics.RectF
 *  android.net.Uri
 *  android.os.AsyncTask
 *  android.util.Log
 */
package d.t.a.h;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import d.t.a.g.b;
import d.t.a.g.c;
import d.t.a.g.d;
import d.t.a.i.e;
import d.t.a.i.f;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.ref.WeakReference;

public class a
extends AsyncTask {
    private static final String s = "BitmapCropTask";
    private final WeakReference a;
    private Bitmap b;
    private final RectF c;
    private final RectF d;
    private float e;
    private float f;
    private final int g;
    private final int h;
    private final Bitmap.CompressFormat i;
    private final int j;
    private final String k;
    private final String l;
    private final c m;
    private final d.t.a.f.a n;
    private int o;
    private int p;
    private int q;
    private int r;

    public a(Context object, Bitmap bitmap, d d10, b b10, d.t.a.f.a a10) {
        int n10;
        float f10;
        WeakReference<Context> weakReference;
        this.a = weakReference = new WeakReference<Context>((Context)object);
        this.b = bitmap;
        object = d10.a();
        this.c = object;
        object = d10.c();
        this.d = object;
        this.e = f10 = d10.d();
        this.f = f10 = d10.b();
        this.g = n10 = b10.f();
        this.h = n10 = b10.g();
        object = b10.a();
        this.i = object;
        this.j = n10 = b10.b();
        object = b10.d();
        this.k = object;
        object = b10.e();
        this.l = object;
        object = b10.c();
        this.m = object;
        this.n = a10;
    }

    private boolean a() {
        int n10;
        int n11;
        int n12;
        int n13;
        int n14;
        Bitmap bitmap;
        Object object;
        Object object2;
        float f10;
        int n15;
        float f11;
        Object object3;
        float f12;
        float f13;
        Object object4;
        int n16;
        int bl2 = this.g;
        int n17 = 0;
        String string2 = null;
        if (bl2 > 0 && (n16 = this.h) > 0) {
            float f14;
            object4 = this.c;
            f13 = object4.width();
            f12 = this.e;
            f13 /= f12;
            object3 = this.c;
            f12 = object3.height();
            f11 = this.e;
            n15 = this.g;
            f10 = n15;
            float f15 = f13 - f10;
            object2 = f15 == 0.0f ? 0 : (f15 > 0.0f ? 1 : -1);
            if (object2 > 0 || (object2 = (f14 = (f12 /= f11) - (f10 = (float)this.h)) == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1)) > 0) {
                f11 = (float)n15 / f13;
                int n18 = this.h;
                f13 = (float)n18 / f12;
                f13 = Math.min(f11, f13);
                object3 = this.b;
                object = this.b;
                f11 = (float)object3.getWidth() * f13;
                n15 = Math.round(f11);
                if (object != (object3 = Bitmap.createScaledBitmap((Bitmap)object3, (int)n15, (int)(object2 = (Object)Math.round(f10 = (float)(bitmap = this.b).getHeight() * f13)), (boolean)false))) {
                    object.recycle();
                }
                this.b = object3;
                this.e = f12 = this.e / f13;
            }
        }
        f13 = this.f;
        int n19 = 0;
        f12 = 0.0f;
        object3 = null;
        float f16 = f13 - 0.0f;
        Object object5 = f16 == 0.0f ? 0 : (f16 > 0.0f ? 1 : -1);
        if (object5 != false) {
            Matrix matrix = new Matrix();
            f13 = this.f;
            n19 = this.b.getWidth() / 2;
            f12 = n19;
            f11 = this.b.getHeight() / 2;
            matrix.setRotate(f13, f12, f11);
            object3 = this.b;
            n15 = 0;
            f11 = 0.0f;
            object = null;
            object2 = false;
            f10 = 0.0f;
            bitmap = null;
            n14 = object3.getWidth();
            int n20 = this.b.getHeight();
            boolean bl3 = true;
            object4 = Bitmap.createBitmap((Bitmap)object3, (int)0, (int)0, (int)n14, (int)n20, (Matrix)matrix, (boolean)bl3);
            object3 = this.b;
            if (object3 != object4) {
                object3.recycle();
            }
            this.b = object4;
        }
        f13 = this.c.left;
        f12 = this.d.left;
        f13 -= f12;
        f12 = this.e;
        this.q = n13 = Math.round(f13 / f12);
        f13 = this.c.top;
        f12 = this.d.top;
        f13 -= f12;
        f12 = this.e;
        this.r = n12 = Math.round(f13 / f12);
        f13 = this.c.width();
        f12 = this.e;
        this.o = n11 = Math.round(f13 / f12);
        object4 = this.c;
        f13 = object4.height();
        f12 = this.e;
        this.p = n10 = Math.round(f13 /= f12);
        n19 = this.o;
        boolean bl4 = this.e(n19, n10);
        object3 = new StringBuilder();
        ((StringBuilder)object3).append("Should crop: ");
        ((StringBuilder)object3).append(bl4);
        object3 = ((StringBuilder)object3).toString();
        object = s;
        Log.i((String)object, (String)object3);
        if (bl4) {
            string2 = this.k;
            object4 = new ExifInterface(string2);
            string2 = this.b;
            n19 = this.q;
            n15 = this.r;
            object2 = this.o;
            n14 = this.p;
            string2 = Bitmap.createBitmap((Bitmap)string2, (int)n19, (int)n15, (int)object2, (int)n14);
            this.d((Bitmap)string2);
            string2 = this.i;
            object3 = Bitmap.CompressFormat.JPEG;
            n17 = string2.equals(object3);
            if (n17 != 0) {
                n17 = this.o;
                n19 = this.p;
                object = this.l;
                d.t.a.i.f.b((ExifInterface)object4, n17, n19, (String)object);
            }
            return true;
        }
        object4 = this.k;
        object3 = this.l;
        d.t.a.i.e.a((String)object4, (String)object3);
        return false;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void d(Bitmap bitmap) {
        void var1_5;
        Object object;
        Object object2;
        block12: {
            block16: {
                Object object3;
                block13: {
                    block15: {
                        block14: {
                            int n10;
                            object2 = (Context)this.a.get();
                            if (object2 == null) {
                                return;
                            }
                            object2 = null;
                            try {
                                String string3 = this.l;
                                object = new File(string3);
                                n10 = 0;
                                string3 = null;
                                object3 = new FileOutputStream((File)object, false);
                            }
                            catch (Throwable throwable) {
                                object = null;
                                break block12;
                            }
                            catch (IOException iOException) {
                                object = null;
                                break block13;
                            }
                            try {
                                object = new ByteArrayOutputStream();
                            }
                            catch (Throwable throwable) {
                                object = null;
                                break block14;
                            }
                            catch (IOException iOException) {
                                object = null;
                                break block15;
                            }
                            try {
                                object2 = this.i;
                                n10 = this.j;
                                bitmap.compress((Bitmap.CompressFormat)object2, n10, (OutputStream)object);
                                object2 = ((ByteArrayOutputStream)object).toByteArray();
                                ((OutputStream)object3).write((byte[])object2);
                                bitmap.recycle();
                            }
                            catch (Throwable throwable) {
                                break block14;
                            }
                            catch (IOException iOException) {
                                break block15;
                            }
                            d.t.a.i.a.c((Closeable)object3);
                            break block16;
                        }
                        object2 = object3;
                        break block12;
                    }
                    object2 = object3;
                }
                object3 = s;
                try {
                    String string2;
                    string2 = ((Throwable)((Object)string2)).getLocalizedMessage();
                    Log.e((String)object3, (String)string2);
                }
                catch (Throwable throwable) {
                    // empty catch block
                    break block12;
                }
                d.t.a.i.a.c((Closeable)object2);
            }
            d.t.a.i.a.c((Closeable)object);
            return;
        }
        d.t.a.i.a.c((Closeable)object2);
        d.t.a.i.a.c((Closeable)object);
        throw var1_5;
    }

    private boolean e(int n10, int n11) {
        float f10 = (float)Math.max(n10, n11) / 1000.0f;
        n10 = Math.round(f10);
        n11 = 1;
        n10 += n11;
        int n12 = this.g;
        if (n12 <= 0 || (n12 = this.h) <= 0) {
            RectF rectF = this.c;
            float f11 = rectF.left;
            RectF rectF2 = this.d;
            float f12 = rectF2.left;
            float f13 = (f11 = Math.abs(f11 - f12)) - (f10 = (float)n10);
            n12 = (int)(f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1));
            if (n12 <= 0) {
                rectF = this.c;
                f11 = rectF.top;
                rectF2 = this.d;
                f12 = rectF2.top;
                float f14 = (f11 = Math.abs(f11 - f12)) - f10;
                n12 = (int)(f14 == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1));
                if (n12 <= 0) {
                    rectF = this.c;
                    f11 = rectF.bottom;
                    rectF2 = this.d;
                    f12 = rectF2.bottom;
                    float f15 = (f11 = Math.abs(f11 - f12)) - f10;
                    n12 = (int)(f15 == 0.0f ? 0 : (f15 > 0.0f ? 1 : -1));
                    if (n12 <= 0) {
                        rectF = this.c;
                        f11 = rectF.right;
                        rectF2 = this.d;
                        f12 = rectF2.right;
                        float f16 = (f11 = Math.abs(f11 - f12)) - f10;
                        n10 = (int)(f16 == 0.0f ? 0 : (f16 > 0.0f ? 1 : -1));
                        if (n10 <= 0) {
                            f10 = this.f;
                            n12 = 0;
                            f11 = 0.0f;
                            rectF = null;
                            float f17 = f10 - 0.0f;
                            n10 = (int)(f17 == 0.0f ? 0 : (f17 > 0.0f ? 1 : -1));
                            if (n10 == 0) {
                                n11 = 0;
                            }
                        }
                    }
                }
            }
        }
        return n11 != 0;
    }

    public Throwable b(Void ... object) {
        object = this.b;
        if (object == null) {
            object = new NullPointerException("ViewBitmap is null");
            return object;
        }
        boolean bl2 = object.isRecycled();
        if (bl2) {
            object = new NullPointerException("ViewBitmap is recycled");
            return object;
        }
        object = this.d;
        bl2 = object.isEmpty();
        if (bl2) {
            object = new NullPointerException("CurrentImageRect is empty");
            return object;
        }
        try {
            this.a();
            bl2 = false;
            object = null;
        }
        catch (Throwable throwable) {
            return throwable;
        }
        this.b = null;
        return null;
    }

    public void c(Throwable serializable) {
        Object object = this.n;
        if (object != null) {
            if (serializable == null) {
                object = this.l;
                serializable = new File((String)object);
                Uri uri = Uri.fromFile((File)serializable);
                d.t.a.f.a a10 = this.n;
                int n10 = this.q;
                int n11 = this.r;
                int n12 = this.o;
                int n13 = this.p;
                a10.a(uri, n10, n11, n12, n13);
            } else {
                object.b((Throwable)serializable);
            }
        }
    }
}

