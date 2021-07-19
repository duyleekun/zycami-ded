/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.BitmapFactory
 *  android.graphics.BitmapFactory$Options
 *  android.graphics.Matrix
 *  android.net.Uri
 *  android.os.AsyncTask
 *  android.util.Log
 */
package d.t.a.h;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import d.t.a.g.c;
import d.t.a.h.b$a;
import d.t.a.i.a;
import g.a0;
import g.a0$a;
import g.c0;
import g.d0;
import g.e;
import h.k0;
import h.z;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;

public class b
extends AsyncTask {
    private static final String g = "BitmapWorkerTask";
    private static final int h = 0x6400000;
    private final Context a;
    private Uri b;
    private Uri c;
    private final int d;
    private final int e;
    private final d.t.a.f.b f;

    public b(Context context, Uri uri, Uri uri2, int n10, int n11, d.t.a.f.b b10) {
        this.a = context;
        this.b = uri;
        this.c = uri2;
        this.d = n10;
        this.e = n11;
        this.f = b10;
    }

    private boolean a(Bitmap bitmap, BitmapFactory.Options options) {
        int n10;
        if (bitmap != null) {
            n10 = bitmap.getByteCount();
        } else {
            n10 = 0;
            bitmap = null;
        }
        int n11 = 0x6400000;
        if (n10 > n11) {
            options.inSampleSize = n10 = options.inSampleSize * 2;
            return true;
        }
        return false;
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void b(Uri object, Uri object2) {
        void var2_6;
        Object object3;
        block9: {
            Object object4;
            block8: {
                object4 = "copyFile";
                Log.d((String)g, (String)object4);
                Objects.requireNonNull(object2, "Output Uri is null - cannot copy image");
                int n10 = 0;
                object3 = null;
                object4 = this.a;
                object4 = object4.getContentResolver();
                object = object4.openInputStream((Uri)object);
                object2 = object2.getPath();
                File file = new File((String)object2);
                object4 = new FileOutputStream(file);
                if (object == null) break block8;
                int n11 = 1024;
                object2 = new byte[n11];
                while ((n10 = ((InputStream)object).read((byte[])object2)) > 0) {
                    file = null;
                    ((OutputStream)object4).write((byte[])object2, 0, n10);
                }
                d.t.a.i.a.c((Closeable)object4);
                d.t.a.i.a.c((Closeable)object);
                object = this.c;
                this.b = object;
                return;
            }
            try {
                object3 = "InputStream for given input Uri is null";
                object2 = new NullPointerException((String)object3);
                throw object2;
            }
            catch (Throwable throwable) {
                object3 = object4;
            }
            break block9;
            catch (Throwable throwable) {}
            break block9;
            catch (Throwable throwable) {
                object = null;
            }
        }
        d.t.a.i.a.c(object3);
        d.t.a.i.a.c((Closeable)object);
        object = this.c;
        this.b = object;
        throw var2_6;
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     */
    private void d(Uri object, Uri object2) {
        void var2_6;
        Object object3;
        Object object4;
        g.z z10;
        block21: {
            Object object5;
            block20: {
                Log.d((String)g, (String)"downloadFile");
                Objects.requireNonNull(object2, "Output Uri is null - cannot download image");
                z10 = new g.z();
                object4 = null;
                object3 = new a0$a();
                object = object.toString();
                object = ((a0$a)object3).B((String)object);
                object = ((a0$a)object).b();
                object = z10.a((a0)object);
                object = FirebasePerfOkHttpClient.execute((e)object);
                try {
                    object3 = ((c0)object).r0();
                }
                catch (Throwable throwable) {
                    object3 = object;
                    object = null;
                    break block21;
                }
                object3 = ((d0)object3).source();
                object5 = this.a;
                object5 = object5.getContentResolver();
                object2 = object5.openOutputStream(object2);
                if (object2 == null) break block20;
                object4 = z.h((OutputStream)object2);
                object3.i0((k0)object4);
                d.t.a.i.a.c((Closeable)object3);
                d.t.a.i.a.c((Closeable)object4);
                if (object != null) {
                    object = ((c0)object).r0();
                    d.t.a.i.a.c((Closeable)object);
                }
                z10.R().b();
                object = this.c;
                this.b = object;
                return;
            }
            object5 = "OutputStream for given output Uri is null";
            try {
                object2 = new NullPointerException((String)object5);
                throw object2;
            }
            catch (Throwable throwable) {
                Object object6 = object3;
                object3 = object;
                object = object4;
                object4 = object6;
            }
            break block21;
            catch (Throwable throwable) {
                object = null;
                object3 = null;
            }
        }
        d.t.a.i.a.c(object4);
        d.t.a.i.a.c((Closeable)object);
        if (object3 != null) {
            object = ((c0)object3).r0();
            d.t.a.i.a.c((Closeable)object);
        }
        z10.R().b();
        object = this.c;
        this.b = object;
        throw var2_6;
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void f() {
        void var1_7;
        String string2 = this.b.getScheme();
        Object object = new StringBuilder();
        ((StringBuilder)object).append("Uri scheme: ");
        ((StringBuilder)object).append(string2);
        object = ((StringBuilder)object).toString();
        CharSequence charSequence = g;
        Log.d((String)charSequence, (String)object);
        object = "http";
        boolean bl2 = ((String)object).equals(string2);
        if (!bl2 && !(bl2 = ((String)(object = "https")).equals(string2))) {
            object = "content";
            bl2 = ((String)object).equals(string2);
            if (bl2) {
                void var1_4;
                string2 = this.b;
                object = this.c;
                try {
                    this.b((Uri)string2, (Uri)object);
                    return;
                }
                catch (IOException iOException) {
                }
                catch (NullPointerException nullPointerException) {
                    // empty catch block
                }
                Log.e((String)charSequence, (String)"Copying failed", (Throwable)var1_4);
                throw var1_4;
            }
            object = "file";
            bl2 = ((String)object).equals(string2);
            if (bl2) return;
            object = new StringBuilder();
            ((StringBuilder)object).append("Invalid Uri scheme ");
            ((StringBuilder)object).append(string2);
            object = ((StringBuilder)object).toString();
            Log.e((String)charSequence, (String)object);
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("Invalid Uri scheme");
            ((StringBuilder)charSequence).append(string2);
            string2 = ((StringBuilder)charSequence).toString();
            object = new IllegalArgumentException(string2);
            throw object;
        }
        string2 = this.b;
        object = this.c;
        try {
            this.d((Uri)string2, (Uri)object);
            return;
        }
        catch (IOException iOException) {
        }
        catch (NullPointerException nullPointerException) {
            // empty catch block
        }
        Log.e((String)charSequence, (String)"Downloading failed", (Throwable)var1_7);
        throw var1_7;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public b$a c(Void ... var1_1) {
        var1_1 /* !! */  = "BitmapWorkerTask";
        var2_5 /* !! */  = this.b;
        if (var2_5 /* !! */  == null) {
            var2_5 /* !! */  = new NullPointerException("Input Uri cannot be null");
            var1_1 /* !! */  = new b$a((Exception)var2_5 /* !! */ );
            return var1_1 /* !! */ ;
        }
        try {
            this.f();
        }
        catch (IOException var1_2) {
        }
        catch (NullPointerException var1_3) {
            // empty catch block
        }
        var2_5 /* !! */  = new BitmapFactory.Options();
        var3_7 = 1;
        var4_8 = 1.4E-45f;
        var2_5 /* !! */ .inJustDecodeBounds = var3_7;
        var5_9 = this.d;
        var6_10 = this.e;
        var2_5 /* !! */ .inSampleSize = var5_9 = d.t.a.i.a.a((BitmapFactory.Options)var2_5 /* !! */ , var5_9, var6_10);
        var5_9 = 0;
        var7_11 /* !! */  = null;
        var2_5 /* !! */ .inJustDecodeBounds = false;
        var6_10 = 0;
        var8_12 = null;
        var9_13 = null;
        while (true) lbl-1000:
        // 4 sources

        {
            block32: {
                var10_14 = "Bitmap could not be decoded from the Uri: [";
                var11_16 = "]";
                if (var5_9 != 0) ** break;
                var12_17 /* !! */  = this.a;
                var12_17 /* !! */  = var12_17 /* !! */ .getContentResolver();
                var13_18 /* !! */  = this.b;
                var12_17 /* !! */  = var12_17 /* !! */ .openInputStream(var13_18 /* !! */ );
                var9_13 = BitmapFactory.decodeStream((InputStream)var12_17 /* !! */ , null, (BitmapFactory.Options)var2_5 /* !! */ );
                var14_20 = var2_5 /* !! */ .outWidth;
                var15_21 = -1;
                if (var14_20 == var15_21) break block32;
                var14_20 = var2_5 /* !! */ .outHeight;
                if (var14_20 == var15_21) break block32;
                d.t.a.i.a.c((Closeable)var12_17 /* !! */ );
                var16_22 = (int)this.a(var9_13, (BitmapFactory.Options)var2_5 /* !! */ );
                if (var16_22 != 0) ** GOTO lbl-1000
                var5_9 = var3_7;
            }
            var18_24 /* !! */  = new StringBuilder();
            var19_25 = "Bounds for bitmap could not be retrieved from the Uri: [";
            var18_24 /* !! */ .append(var19_25);
            var19_25 = this.b;
            var18_24 /* !! */ .append((Object)var19_25);
            var18_24 /* !! */ .append(var11_16);
            var18_24 /* !! */  = var18_24 /* !! */ .toString();
            var17_23 = new IllegalArgumentException((String)var18_24 /* !! */ );
            var13_18 /* !! */  = new b$a(var17_23);
            d.t.a.i.a.c((Closeable)var12_17 /* !! */ );
            return var13_18 /* !! */ ;
            catch (Throwable var13_19) {
                try {
                    d.t.a.i.a.c((Closeable)var12_17 /* !! */ );
                    throw var13_19;
                }
                catch (IOException var2_6) {
                    Log.e((String)var1_1 /* !! */ , (String)"doInBackground: ImageDecoder.createSource: ", (Throwable)var2_6);
                    var7_11 /* !! */  = new StringBuilder();
                    var7_11 /* !! */ .append(var10_14);
                    var8_12 = this.b;
                    var7_11 /* !! */ .append(var8_12);
                    var7_11 /* !! */ .append(var11_16);
                    var7_11 /* !! */  = var7_11 /* !! */ .toString();
                    var20_26 = new IllegalArgumentException((String)var7_11 /* !! */ , var2_6);
                    var1_1 /* !! */  = new b$a(var20_26);
                    return var1_1 /* !! */ ;
                }
                catch (OutOfMemoryError var10_15) {
                    var11_16 = "doInBackground: BitmapFactory.decodeFileDescriptor: ";
                    Log.e((String)var1_1 /* !! */ , (String)var11_16, (Throwable)var10_15);
                    var2_5 /* !! */ .inSampleSize = var16_22 = var2_5 /* !! */ .inSampleSize * 2;
                    continue;
                }
            }
            break;
        }
        ** GOTO lbl-1000
        if (var9_13 == null) {
            var20_27 /* !! */  = new StringBuilder();
            var20_27 /* !! */ .append(var10_14);
            var7_11 /* !! */  = this.b;
            var20_27 /* !! */ .append((Object)var7_11 /* !! */ );
            var20_27 /* !! */ .append(var11_16);
            var20_27 /* !! */  = var20_27 /* !! */ .toString();
            var2_5 /* !! */  = new IllegalArgumentException((String)var20_27 /* !! */ );
            var1_1 /* !! */  = new b$a((Exception)var2_5 /* !! */ );
            return var1_1 /* !! */ ;
        }
        var1_1 /* !! */  = this.a;
        var2_5 /* !! */  = this.b;
        var21_28 = d.t.a.i.a.g(var1_1 /* !! */ , var2_5 /* !! */ );
        var22_29 = d.t.a.i.a.e(var21_28);
        var5_9 = d.t.a.i.a.f(var21_28);
        var8_12 = new c(var21_28, var22_29, var5_9);
        var1_1 /* !! */  = new Matrix();
        if (var22_29 != 0) {
            var23_30 = var22_29;
            var1_1 /* !! */ .preRotate(var23_30);
        }
        if (var5_9 != var3_7) {
            var23_30 = var5_9;
            var3_7 = 1065353216;
            var4_8 = 1.0f;
            var1_1 /* !! */ .postScale(var23_30, var4_8);
        }
        if ((var22_29 = (int)var1_1 /* !! */ .isIdentity()) == 0) {
            var1_1 /* !! */  = d.t.a.i.a.h(var9_13, (Matrix)var1_1 /* !! */ );
            var2_5 /* !! */  = new b$a((Bitmap)var1_1 /* !! */ , var8_12);
            return var2_5 /* !! */ ;
        }
        var1_1 /* !! */  = new b$a(var9_13, var8_12);
        return var1_1 /* !! */ ;
        var2_5 /* !! */  = new b$a((Exception)var1_4);
        return var2_5 /* !! */ ;
    }

    public void e(b$a object) {
        Object object2 = ((b$a)object).c;
        if (object2 == null) {
            object2 = this.f;
            Bitmap bitmap = ((b$a)object).a;
            object = ((b$a)object).b;
            String string2 = this.b.getPath();
            Object object3 = this.c;
            object3 = object3 == null ? null : object3.getPath();
            object2.a(bitmap, (c)object, string2, (String)object3);
        } else {
            object = this.f;
            object.onFailure((Exception)object2);
        }
    }
}

