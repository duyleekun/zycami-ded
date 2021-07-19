/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentUris
 *  android.content.Context
 *  android.content.Intent
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.net.Uri
 *  android.os.Environment
 *  android.provider.MediaStore$Files
 */
package d.v.c.s0;

import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import androidx.core.util.Pair;
import com.zhiyun.android.CameraView;
import d.v.b.f0.l.f;
import d.v.c.o0.s0;
import d.v.c.s0.a6;
import d.v.c.s0.b6;
import d.v.c.s0.y5;
import d.v.c.s0.z5;
import d.v.d.h.a;
import d.v.e.l.k2;
import d.v.e.l.s1;
import e.a.c1.b;
import e.a.h0;
import e.a.j;
import e.a.q;
import e.a.s;
import e.a.u;
import e.a.v0.o;
import e.a.v0.r;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class t6 {
    public static void a(Context context, Uri uri) {
        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        intent.setData(uri);
        context.sendBroadcast(intent);
    }

    public static void b(Context context, String string2) {
        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        File file = new File(string2);
        string2 = Uri.fromFile((File)file);
        intent.setData((Uri)string2);
        context.sendBroadcast(intent);
    }

    public static String c() {
        String string2 = "VID";
        String string3 = "mp4";
        Object object = k2.A(t6.d(string2, string3));
        if (object != null) {
            return s1.G((Uri)object);
        }
        object = new StringBuilder();
        Object object2 = k2.k();
        ((StringBuilder)object).append(object2);
        object2 = File.separator;
        ((StringBuilder)object).append((String)object2);
        ((StringBuilder)object).append("ZYCami");
        string2 = t6.d(string2, string3);
        ((StringBuilder)object).append(string2);
        return ((StringBuilder)object).toString();
    }

    private static String d(String string2, String string3) {
        StringBuilder stringBuilder = new StringBuilder();
        string2 = t6.e(string2);
        stringBuilder.append(string2);
        stringBuilder.append(".");
        stringBuilder.append(string3);
        return stringBuilder.toString();
    }

    public static String e(String string2) {
        Serializable serializable = Locale.US;
        Object object = new SimpleDateFormat("yyyyMMdd_HHmmss", (Locale)serializable);
        serializable = new Date();
        object = ((DateFormat)object).format((Date)serializable);
        serializable = new StringBuilder();
        ((StringBuilder)serializable).append(string2);
        ((StringBuilder)serializable).append("_");
        ((StringBuilder)serializable).append((String)object);
        return ((StringBuilder)serializable).toString();
    }

    public static String f() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ZYCami");
        Cloneable cloneable = Locale.US;
        Object object = new SimpleDateFormat("yyyyMMddHHmmss", (Locale)cloneable);
        cloneable = new Date();
        object = ((DateFormat)object).format((Date)cloneable);
        stringBuilder.append((String)object);
        stringBuilder.append(".mp4");
        return stringBuilder.toString();
    }

    public static String g() {
        return s1.G(k2.z(t6.e("PIC")));
    }

    public static Uri h() {
        return k2.z(t6.d("PIC", "jpg"));
    }

    public static String i() {
        StringBuilder stringBuilder = new StringBuilder();
        Object object = k2.k();
        stringBuilder.append(object);
        object = File.separator;
        stringBuilder.append((String)object);
        stringBuilder.append("ZYCami");
        Cloneable cloneable = Locale.US;
        object = new SimpleDateFormat("yyyyMMddHHmmss", (Locale)cloneable);
        cloneable = new Date();
        object = ((DateFormat)object).format((Date)cloneable);
        stringBuilder.append((String)object);
        stringBuilder.append(".mp4");
        return stringBuilder.toString();
    }

    public static Bitmap j(CameraView cameraView) {
        return t6.k(cameraView, 1.0f);
    }

    public static Bitmap k(CameraView cameraView, float f10) {
        return t6.l(cameraView, f10, 3, false);
    }

    public static Bitmap l(CameraView cameraView, float f10, int n10, boolean bl2) {
        block10: {
            int n11;
            int n12;
            int n13;
            block9: {
                f f11;
                n10 = 720;
                n13 = 1280;
                try {
                    f11 = cameraView.getTextureSize();
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                    cameraView = Bitmap.Config.RGB_565;
                    return Bitmap.createBitmap((int)n13, (int)n10, (Bitmap.Config)cameraView);
                }
                n12 = f11.p();
                f f12 = cameraView.getTextureSize();
                n11 = f12.o();
                if (!bl2) break block9;
                int n14 = n11 * 4;
                n12 = n14 / 3;
            }
            float f13 = (float)n12 * f10;
            int n15 = (int)f13;
            float f14 = (float)n11 * f10;
            int n16 = (int)f14;
            cameraView = cameraView.e(n15, n16);
            if (cameraView != null) break block10;
            cameraView = Bitmap.Config.RGB_565;
            cameraView = Bitmap.createBitmap((int)n13, (int)n10, (Bitmap.Config)cameraView);
        }
        return cameraView;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void m(Context var0, s var1_6) {
        block13: {
            block14: {
                block12: {
                    var2_7 = var0 /* !! */ .getContentResolver();
                    var0 /* !! */  = MediaStore.Files.getContentUri((String)"external");
                    var3_8 = "_id";
                    var4_9 = "_size";
                    var5_10 = new String[]{var3_8, var4_9};
                    var6_11 = 2;
                    var7_12 /* !! */  = new String[var6_11];
                    var8_13 = k2.k().getPath();
                    var7_12 /* !! */ [0] = var8_13;
                    var8_13 = new StringBuilder();
                    var9_14 = Environment.getExternalStorageDirectory();
                    var8_13.append(var9_14);
                    var9_14 = File.separator;
                    var8_13.append((String)var9_14);
                    var8_13.append("DCIM");
                    var8_13.append((String)var9_14);
                    var8_13.append("ZY_Cami");
                    var8_13.append((String)var9_14);
                    var8_13.append("Camera");
                    var8_13 = var8_13.toString();
                    var10_15 = 1;
                    var7_12 /* !! */ [var10_15] = var8_13;
                    var8_13 = new s0();
                    var8_13 = var8_13.a(0, (String[])var7_12 /* !! */ );
                    var11_16 = null;
                    var9_14 = "date_added DESC";
                    var7_12 /* !! */  = var0 /* !! */ ;
                    try {
                        var2_7 = var2_7.query((Uri)var0 /* !! */ , var5_10, (String)var8_13, null, (String)var9_14);
                        if (var2_7 == null) break block12;
                    }
                    catch (Throwable var0_3) {
                        break block13;
                    }
                    catch (Exception var0_4) {
                        // empty catch block
                        ** GOTO lbl-1000
                    }
                    try {
                        while ((var6_11 = (int)var2_7.moveToNext()) != 0) {
                            var6_11 = var2_7.getColumnIndex(var4_9);
                            if (var6_11 != (var12_17 = -1) && (var6_11 = (int)((cfr_temp_0 = (var13_18 = var2_7.getLong(var6_11)) - (var15_19 = 0L)) == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1))) == 0) continue;
                            var6_11 = var2_7.getColumnIndex(var3_8);
                            var6_11 = var2_7.getInt(var6_11);
                            var13_18 = var6_11;
                            var11_16 = ContentUris.withAppendedId((Uri)var0 /* !! */ , (long)var13_18);
                            break;
                        }
                    }
                    catch (Throwable var0_1) {
                        var11_16 = var2_7;
                        break block13;
                    }
                    catch (Exception var0_2) {
                        var11_16 = var2_7;
                        ** GOTO lbl-1000
                    }
                }
                if (var11_16 == null) {
                    var7_12 /* !! */  = "No file";
                    var0 /* !! */  = new FileNotFoundException((String)var7_12 /* !! */ );
                    var1_6.onError((Throwable)var0 /* !! */ );
                } else {
                    var0 /* !! */  = var11_16.toString();
                    var1_6.onSuccess(var0 /* !! */ );
                }
                if (var2_7 != null) {
                    var2_7.close();
                }
                break block14;
lbl-1000:
                // 2 sources

                {
                    var1_6.onError((Throwable)var0 /* !! */ );
                    if (var11_16 == null) break block14;
                }
                var11_16.close();
            }
            var1_6.onComplete();
            return;
        }
        if (var11_16 != null) {
            var11_16.close();
        }
        var1_6.onComplete();
        throw var0_5;
    }

    public static /* synthetic */ Pair n(Uri uri, byte[] byArray) {
        Object object = d.v.e.f.a().c();
        boolean bl2 = s1.k0((Context)object, byArray, uri);
        if (bl2) {
            object = a.b();
            Context context = d.v.e.f.a().c();
            ((a)object).f(context, uri);
        }
        return Pair.create(bl2, uri);
    }

    public static /* synthetic */ boolean o(Pair pair) {
        return (Boolean)pair.first;
    }

    public static /* synthetic */ Uri p(Pair pair) {
        return (Uri)pair.second;
    }

    public static q q(Context object) {
        Object object2 = new z5((Context)object);
        object = q.K((u)object2);
        object2 = b.d();
        return ((q)object).u1((h0)object2);
    }

    public static Uri r(Bitmap bitmap) {
        Uri uri = k2.z(t6.d("PIC_Panorama", "jpg"));
        Context context = d.v.e.f.a().c();
        boolean bl2 = s1.j0(context, bitmap, uri);
        if (!bl2) {
            uri = null;
        }
        return uri;
    }

    public static j s(byte[] object) {
        Object object2 = k2.z(t6.d("PIC", "jpg"));
        object = j.C3(object);
        Object object3 = b.d();
        object = ((j)object).n6((h0)object3);
        object3 = new a6((Uri)object2);
        object = ((j)object).R3((o)object3);
        object2 = y5.a;
        object = ((j)object).u2((r)object2);
        object2 = b6.a;
        return ((j)object).R3((o)object2);
    }
}

