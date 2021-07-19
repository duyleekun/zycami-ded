/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.util.Log
 */
package d.c.a.o.m.d;

import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.load.EncodeStrategy;
import d.c.a.o.f;
import d.c.a.o.h;
import d.c.a.o.j.c;
import d.c.a.o.k.s;
import d.c.a.o.k.x.b;
import d.c.a.u.g;
import d.c.a.u.m;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class e
implements h {
    public static final d.c.a.o.e b;
    public static final d.c.a.o.e c;
    private static final String d = "BitmapEncoder";
    private final b a;

    static {
        Integer n10 = 90;
        b = d.c.a.o.e.g("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", n10);
        c = d.c.a.o.e.f("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");
    }

    public e() {
        this.a = null;
    }

    public e(b b10) {
        this.a = b10;
    }

    private Bitmap.CompressFormat d(Bitmap bitmap, f f10) {
        d.c.a.o.e e10 = c;
        if ((f10 = (Bitmap.CompressFormat)f10.c(e10)) != null) {
            return f10;
        }
        boolean bl2 = bitmap.hasAlpha();
        if (bl2) {
            return Bitmap.CompressFormat.PNG;
        }
        return Bitmap.CompressFormat.JPEG;
    }

    public EncodeStrategy b(f f10) {
        return EncodeStrategy.TRANSFORMED;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean c(s var1_1, File var2_5, f var3_8) {
        block23: {
            block22: {
                block21: {
                    var4_9 = "BitmapEncoder";
                    var1_1 = (Bitmap)var1_1.get();
                    var5_10 /* !! */  = this.d((Bitmap)var1_1, (f)var3_8);
                    var6_11 = var1_1.getWidth();
                    var7_12 = var6_11;
                    var8_13 = var1_1.getHeight();
                    var9_14 = var8_13;
                    var10_15 = "encode: [%dx%d] %s";
                    d.c.a.u.o.b.d((String)var10_15, var7_12, var9_14, var5_10 /* !! */ );
                    var11_16 = g.b();
                    var10_15 = e.b;
                    var10_15 = var3_8.c((d.c.a.o.e)var10_15);
                    var10_15 = (Integer)var10_15;
                    var13_17 = var10_15.intValue();
                    var14_18 = false;
                    var15_19 = null;
                    var16_20 = new FileOutputStream((File)var2_5);
                    var2_5 = this.a;
                    if (var2_5 != null) {
                        var15_19 = this.a;
                        var15_19 = var2_5 = new c(var16_20, (b)var15_19);
                        break block21;
                    }
                    var15_19 = var16_20;
                }
                try {
                    var1_1.compress(var5_10 /* !! */ , var13_17, (OutputStream)var15_19);
                    var15_19.close();
                    var14_18 = true;
                }
                catch (Throwable var1_3) {
                    break block23;
                }
                catch (IOException var2_7) {
                    // empty catch block
                }
lbl33:
                // 2 sources

                while (true) {
                    var15_19.close();
                    break block22;
                    break;
                }
                catch (Throwable var1_2) {
                    var15_19 = var16_20;
                    break block23;
                }
                catch (IOException var2_6) {
                    var15_19 = var16_20;
                }
                var13_17 = 3;
                {
                    var13_17 = (int)Log.isLoggable((String)var4_9, (int)var13_17);
                    if (var13_17 != 0) {
                        var10_15 = "Failed to encode Bitmap";
                        Log.d((String)var4_9, (String)var10_15, (Throwable)var2_5);
                    }
                    if (var15_19 != null) {
                        ** continue;
                    }
                    break block22;
                }
                catch (IOException v0) {}
            }
            var17_21 = 2;
            var17_21 = (int)Log.isLoggable((String)var4_9, (int)var17_21);
            if (var17_21 == 0) return var14_18;
            var2_5 = new StringBuilder();
            var10_15 = "Compressed with type: ";
            var2_5.append((String)var10_15);
            var2_5.append(var5_10 /* !! */ );
            var5_10 /* !! */  = " of size ";
            var2_5.append((String)var5_10 /* !! */ );
            var18_22 = m.h((Bitmap)var1_1);
            var2_5.append(var18_22);
            var5_10 /* !! */  = " in ";
            var2_5.append((String)var5_10 /* !! */ );
            var19_23 = g.a(var11_16);
            var2_5.append(var19_23);
            var5_10 /* !! */  = ", options format: ";
            var2_5.append((String)var5_10 /* !! */ );
            var5_10 /* !! */  = e.c;
            var3_8 = var3_8.c((d.c.a.o.e)var5_10 /* !! */ );
            var2_5.append(var3_8);
            var3_8 = ", hasAlpha: ";
            var2_5.append((String)var3_8);
            var21_24 = var1_1.hasAlpha();
            var2_5.append(var21_24);
            var1_1 = var2_5.toString();
            Log.v((String)var4_9, (String)var1_1);
            return var14_18;
        }
        if (var15_19 == null) throw var1_1;
        try {}
        catch (IOException v1) {
            throw var1_1;
        }
        var15_19.close();
        throw var1_1;
        finally {
            d.c.a.u.o.b.e();
        }
    }
}

