/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.graphics.BitmapFactory
 *  android.graphics.BitmapFactory$Options
 *  android.graphics.Matrix
 */
package d.o.a.a.a.a.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import com.quvideo.mobile.external.component.cloudcomposite.compressor.OooO00o;
import com.quvideo.mobile.external.component.cloudcomposite.compressor.OooOO0O;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class b {
    private OooOO0O a;
    private File b;
    private int c;
    private int d;
    private int e;
    private boolean f;
    private boolean g;

    public b(OooOO0O oooOO0O, File file, boolean bl2, int n10, boolean bl3) {
        int n11;
        this.b = file;
        this.a = oooOO0O;
        this.g = bl2;
        this.e = n10;
        this.f = bl3;
        ((BitmapFactory.Options)file).inJustDecodeBounds = bl2 = true;
        ((BitmapFactory.Options)file).inSampleSize = (int)(bl2 ? 1 : 0);
        BitmapFactory.decodeStream((InputStream)oooOO0O.OooO00o(), null, (BitmapFactory.Options)file);
        this.c = n11 = ((BitmapFactory.Options)file).outWidth;
        this.d = n11 = ((BitmapFactory.Options)file).outHeight;
    }

    private Bitmap a(Bitmap bitmap, int n10) {
        Matrix matrix = new Matrix();
        float f10 = n10;
        matrix.postRotate(f10);
        int n11 = bitmap.getWidth();
        int n12 = bitmap.getHeight();
        return Bitmap.createBitmap((Bitmap)bitmap, (int)0, (int)0, (int)n11, (int)n12, (Matrix)matrix, (boolean)true);
    }

    private int c() {
        double d10;
        double d11;
        double d12;
        double d13;
        int n10 = this.c;
        int n11 = n10 % 2;
        int n12 = 1;
        if (n11 == n12) {
            ++n10;
        }
        this.c = n10;
        n11 = this.d;
        int n13 = n11 % 2;
        if (n13 == n12) {
            ++n11;
        }
        this.d = n11;
        n10 = Math.max(n10, n11);
        n11 = this.c;
        n13 = this.d;
        n11 = Math.min(n11, n13);
        float f10 = n11;
        float f11 = n10;
        f10 /= f11;
        f11 = 1.0f;
        n13 = (int)(f10 == f11 ? 0 : (f10 < f11 ? -1 : 1));
        double d14 = 0.5625;
        if (n13 <= 0 && (n13 = (int)((d13 = (d12 = (double)f10) - d14) == 0.0 ? 0 : (d13 > 0.0 ? 1 : -1))) > 0) {
            n11 = 1664;
            f10 = 2.332E-42f;
            if (n10 < n11) {
                return n12;
            }
            n11 = 4990;
            f10 = 6.992E-42f;
            if (n10 < n11) {
                return 2;
            }
            if (n10 > n11) {
                n11 = 10240;
                f10 = 1.4349E-41f;
                if (n10 < n11) {
                    return 4;
                }
            }
            if ((n10 /= 1280) != 0) {
                n12 = n10;
            }
            return n12;
        }
        d12 = f10;
        double d15 = d12 - d14;
        n11 = (int)(d15 == 0.0 ? 0 : (d15 < 0.0 ? -1 : 1));
        if (n11 <= 0 && (n11 = (int)((d11 = d12 - (d10 = 0.5)) == 0.0 ? 0 : (d11 > 0.0 ? 1 : -1))) > 0) {
            if ((n10 /= 1280) != 0) {
                n12 = n10;
            }
            return n12;
        }
        double d16 = n10;
        double d17 = 1280.0 / d12;
        return (int)Math.ceil(d16 / d17);
    }

    public File b() {
        Object object = new BitmapFactory.Options();
        int n10 = this.f;
        n10 = n10 != 0 ? this.c() : 1;
        ((BitmapFactory.Options)object).inSampleSize = n10;
        Closeable closeable = this.a.OooO00o();
        int n11 = 0;
        object = BitmapFactory.decodeStream((InputStream)closeable, null, (BitmapFactory.Options)object);
        closeable = new ByteArrayOutputStream();
        Object object2 = OooO00o.SINGLE;
        InputStream inputStream = this.a.OooO00o();
        int n12 = object2.isJPG(inputStream);
        if (n12 != 0) {
            inputStream = this.a.OooO00o();
            n11 = object2.getOrientation(inputStream);
            object = this.a((Bitmap)object, n11);
        }
        object2 = (n11 = this.g) != 0 ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG;
        n12 = this.e;
        object.compress((Bitmap.CompressFormat)object2, n12, (OutputStream)closeable);
        object.recycle();
        object2 = this.b;
        object = new FileOutputStream((File)object2);
        object2 = ((ByteArrayOutputStream)closeable).toByteArray();
        ((FileOutputStream)object).write((byte[])object2);
        ((OutputStream)object).flush();
        ((FileOutputStream)object).close();
        ((ByteArrayOutputStream)closeable).close();
        return this.b;
    }
}

