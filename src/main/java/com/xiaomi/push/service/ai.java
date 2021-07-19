/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.BitmapFactory
 *  android.graphics.BitmapFactory$Options
 *  android.net.Uri
 */
package com.xiaomi.push.service;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.bf;
import com.xiaomi.push.service.ai$a;
import com.xiaomi.push.service.ai$b;
import com.xiaomi.push.x;
import com.xiaomi.push.y;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;

public class ai {
    private static long a;

    private static int a(Context context, InputStream inputStream) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        int n10 = 1;
        options.inJustDecodeBounds = n10;
        BitmapFactory.decodeStream((InputStream)inputStream, null, (BitmapFactory.Options)options);
        int n11 = options.outWidth;
        int n12 = -1;
        if (n11 != n12 && (n11 = options.outHeight) != n12) {
            int n13;
            context = context.getResources().getDisplayMetrics();
            float f10 = (float)context.densityDpi / 160.0f;
            n11 = options.outWidth;
            float f11 = 48.0f;
            int n14 = Math.round(f10 *= f11);
            if (n11 > n14 && (n13 = options.outHeight) > n14) {
                return Math.min(n11 /= n14, n13 /= n14);
            }
            return n10;
        }
        b.a("decode dimension failed for bitmap.");
        return n10;
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     */
    public static Bitmap a(Context object, String string2) {
        void var1_8;
        Object object2;
        Context context;
        block17: {
            block16: {
                string2 = Uri.parse((String)string2);
                context = null;
                object2 = object.getContentResolver();
                object2 = object2.openInputStream((Uri)string2);
                int n10 = ai.a(object, (InputStream)object2);
                object = object.getContentResolver();
                object = object.openInputStream((Uri)string2);
                string2 = new BitmapFactory.Options();
                ((BitmapFactory.Options)string2).inSampleSize = n10;
                try {
                    string2 = BitmapFactory.decodeStream((InputStream)object, null, (BitmapFactory.Options)string2);
                }
                catch (IOException iOException) {
                    break block16;
                }
                y.a((Closeable)object);
                y.a((Closeable)object2);
                return string2;
                catch (Throwable throwable) {
                    break block17;
                }
                catch (IOException iOException) {
                    object = null;
                    break block16;
                }
                catch (Throwable throwable) {
                    object2 = null;
                    break block17;
                }
                catch (IOException iOException) {
                    object = null;
                    object2 = null;
                }
            }
            try {
                b.a((Throwable)((Object)string2));
            }
            catch (Throwable throwable) {
                context = object;
            }
            y.a((Closeable)object);
            y.a((Closeable)object2);
            return null;
        }
        y.a(context);
        y.a((Closeable)object2);
        throw var1_8;
    }

    /*
     * Unable to fully structure code
     */
    private static ai$a a(String var0, boolean var1_8) {
        block62: {
            block61: {
                block60: {
                    block59: {
                        var2_9 = null;
                        var3_10 = new URL(var0);
                        var3_10 = var3_10.openConnection();
                        var3_10 = FirebasePerfUrlConnection.instrument(var3_10);
                        var3_10 = (URLConnection)var3_10;
                        var3_10 = (HttpURLConnection)var3_10;
                        var4_11 = 8000;
                        var3_10.setConnectTimeout(var4_11);
                        var4_11 = 20000;
                        var3_10.setReadTimeout(var4_11);
                        var5_14 = "User-agent";
                        var6_15 = "Mozilla/5.0 (Linux; U;) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/71.0.3578.141 Mobile Safari/537.36 XiaoMi/MiuiBrowser";
                        var3_10.setRequestProperty((String)var5_14, (String)var6_15);
                        var3_10.connect();
                        var4_11 = var3_10.getContentLength();
                        var7_16 = 102400;
                        if (var1_8 == 0 || var4_11 <= var7_16) break block59;
                        var8_17 = new StringBuilder();
                        var6_15 = "Bitmap size is too big, max size is 102400  contentLen size is ";
                        var8_17.append((String)var6_15);
                        var8_17.append(var4_11);
                        var5_14 = " from url ";
                        var8_17.append((String)var5_14);
                        var8_17.append(var0);
                        var8_17 = var8_17.toString();
                        b.a((String)var8_17);
                        y.a(null);
                        if (var3_10 != null) {
                            var3_10.disconnect();
                        }
                        return null;
                    }
                    var4_11 = var3_10.getResponseCode();
                    var9_18 = 200;
                    if (var4_11 == var9_18) break block60;
                    var8_17 = new StringBuilder();
                    var6_15 = "Invalid Http Response Code ";
                    var8_17.append((String)var6_15);
                    var8_17.append(var4_11);
                    var5_14 = " received";
                    var8_17.append((String)var5_14);
                    var8_17 = var8_17.toString();
                    b.a((String)var8_17);
                    y.a(null);
                    if (var3_10 != null) {
                        var3_10.disconnect();
                    }
                    return null;
                }
                var5_14 = var3_10.getInputStream();
                var10_19 = new ByteArrayOutputStream();
                var11_20 = 1024;
                var12_21 = new byte[var11_20];
                for (var1_8 = var1_8 != 0 ? var7_16 : 2048000; var1_8 > 0; var1_8 -= var13_22) {
                    var13_22 = var5_14.read(var12_21, 0, var11_20);
                    var14_23 = -1;
                    if (var13_22 == var14_23) break;
                    var10_19.write(var12_21, 0, var13_22);
                    continue;
                }
                if (var1_8 <= 0) {
                    var8_17 = "length 102400 exhausted.";
                    b.a((String)var8_17);
                    var8_17 = new ai$a(null, var7_16);
                    y.a((Closeable)var5_14);
                    if (var3_10 != null) {
                        var3_10.disconnect();
                    }
                    return var8_17;
                }
                var8_17 = var10_19.toByteArray();
                var9_18 = ((Object)var8_17).length;
                try {
                    var6_15 = new ai$a((byte[])var8_17, var9_18);
                }
                catch (IOException var0_1) {
                    break block61;
                }
                y.a((Closeable)var5_14);
                if (var3_10 != null) {
                    var3_10.disconnect();
                }
                return var6_15;
                catch (Throwable var0_2) {
                    ** GOTO lbl160
                }
                catch (IOException var0_3) {
                    var4_11 = 0;
                    var5_14 = null;
                    break block61;
                }
                catch (SocketTimeoutException v0) {
                    var4_11 = 0;
                    var5_14 = null;
                    break block62;
                }
                catch (Throwable var0_4) {
                    var3_10 = null;
                    ** GOTO lbl160
                }
                catch (IOException var0_5) {
                    var3_10 = null;
                    var4_12 = false;
                    var5_14 = null;
                }
            }
            b.a((Throwable)var0);
            y.a(var5_14);
            if (var3_10 != null) {
                while (true) {
                    var3_10.disconnect();
                    ** GOTO lbl157
                    break;
                }
            }
            ** GOTO lbl157
            catch (SocketTimeoutException v1) {
                var3_10 = null;
                var4_13 = false;
                var5_14 = null;
            }
        }
lbl142:
        // 2 sources

        while (true) {
            var8_17 = new StringBuilder();
            var6_15 = "Connect timeout to ";
            var8_17.append((String)var6_15);
            var8_17.append(var0);
            var0 = var8_17.toString();
            try {
                b.d(var0);
            }
            catch (Throwable var0_6) {
                var2_9 = var5_14;
            }
            y.a(var5_14);
            if (var3_10 != null) ** continue;
lbl157:
            // 3 sources

            return null;
lbl160:
            // 3 sources

            y.a(var2_9);
            if (var3_10 != null) {
                var3_10.disconnect();
            }
            throw var0_7;
        }
        catch (SocketTimeoutException v2) {
            ** continue;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static ai$b a(Context var0, String var1_7, boolean var2_8) {
        block14: {
            block13: {
                block12: {
                    block11: {
                        var4_10 = 0;
                        var5_11 /* !! */  = null;
                        var6_12 = 0L;
                        var3_9 = new ai$b(null, var6_12);
                        var8_13 /* !! */  = ai.b(var0, var1_7);
                        if (var8_13 /* !! */  != null) {
                            var3_9.a = var8_13 /* !! */ ;
                            return var3_9;
                        }
                        try {
                            var8_13 /* !! */  = ai.a(var1_7, var2_8);
                            if (var8_13 /* !! */  != null) break block11;
                        }
                        catch (Exception var0_4) {
                            // empty catch block
                            break block12;
                        }
                        y.a(null);
                        return var3_9;
                    }
                    try {
                        var9_14 = var8_13 /* !! */ .a;
                        var3_9.a = var10_15 = (long)var9_14;
                        var12_16 = var8_13 /* !! */ .a;
                        if (var12_16 == null) ** GOTO lbl43
                        if (!var2_8) ** GOTO lbl-1000
                        var13_17 /* !! */  = (byte[])new ByteArrayInputStream;
                        var13_17 /* !! */ (var12_16);
                    }
                    catch (Throwable var0_3) {}
                    try {
                        var4_10 = ai.a(var0, (InputStream)var13_17 /* !! */ );
                        var14_18 = new BitmapFactory.Options();
                        var14_18.inSampleSize = var4_10;
                        var4_10 = var12_16.length;
                        var5_11 /* !! */  = (byte[])BitmapFactory.decodeByteArray((byte[])var12_16, (int)0, (int)var4_10, (BitmapFactory.Options)var14_18);
                        var3_9.a = (Bitmap)var5_11 /* !! */ ;
                        return var3_9.a;
                    }
                    catch (Exception var0_2) {}
                    finally {
                        var5_11 /* !! */  = var13_17 /* !! */ ;
                        ** GOTO lbl43
                    }
lbl-1000:
                    // 1 sources

                    {
                        var2_8 = var12_16.length;
                        var13_17 /* !! */  = (byte[])BitmapFactory.decodeByteArray((byte[])var12_16, (int)0, (int)var2_8);
                        var3_9.a = (Bitmap)var13_17 /* !! */ ;
lbl43:
                        // 3 sources

                        var13_17 /* !! */  = var8_13 /* !! */ .a;
                        ai.a(var0, var13_17 /* !! */ , var1_7);
                        break block13;
                    }
                    break block14;
                }
                b.a((Throwable)var0_5);
            }
            y.a(var5_11 /* !! */ );
            return var3_9;
        }
        y.a(var5_11 /* !! */ );
        throw var0_6;
    }

    private static void a(Context fileArray) {
        long l10;
        long l11;
        Comparable<StringBuilder> comparable = new Comparable<StringBuilder>();
        fileArray = fileArray.getCacheDir().getPath();
        ((StringBuilder)comparable).append((String)fileArray);
        fileArray = File.separator;
        ((StringBuilder)comparable).append((String)fileArray);
        ((StringBuilder)comparable).append("mipush_icon");
        fileArray = ((StringBuilder)comparable).toString();
        File file = new File((String)fileArray);
        Object object = file.exists();
        if (object == 0) {
            return;
        }
        long l12 = a;
        long l13 = 0L;
        long l14 = l12 - l13;
        object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object == 0) {
            a = l12 = x.a(file);
        }
        if ((object = (l11 = (l12 = a) - (l10 = 0xF00000L)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) > 0) {
            block16: {
                int n10;
                try {
                    fileArray = file.listFiles();
                    n10 = 0;
                    file = null;
                }
                catch (Exception exception) {
                    b.a(exception);
                }
                while (true) {
                    block17: {
                        int n11 = fileArray.length;
                        if (n10 >= n11) break block16;
                        comparable = fileArray[n10];
                        n11 = (int)(((File)comparable).isDirectory() ? 1 : 0);
                        if (n11 != 0) break block17;
                        l12 = System.currentTimeMillis();
                        File file2 = fileArray[n10];
                        l10 = file2.lastModified();
                        l12 -= l10;
                        l12 = Math.abs(l12);
                        l10 = 1209600L;
                        n11 = (int)(l12 == l10 ? 0 : (l12 < l10 ? -1 : 1));
                        if (n11 > 0) {
                            comparable = fileArray[n10];
                            ((File)comparable).delete();
                        }
                    }
                    ++n10;
                }
            }
            a = l13;
        }
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     */
    private static void a(Context object, byte[] object2, String object3) {
        void var0_4;
        Object object4;
        block17: {
            String string2;
            Object object5;
            block19: {
                block18: {
                    boolean bl2;
                    block16: {
                        if (object2 == null) {
                            b.a("cannot save small icon cause bitmap is null");
                            return;
                        }
                        ai.a(object);
                        object5 = new StringBuilder();
                        string2 = object.getCacheDir().getPath();
                        ((StringBuilder)object5).append(string2);
                        string2 = File.separator;
                        ((StringBuilder)object5).append(string2);
                        string2 = "mipush_icon";
                        ((StringBuilder)object5).append(string2);
                        object5 = ((StringBuilder)object5).toString();
                        object4 = new File((String)object5);
                        boolean bl3 = ((File)object4).exists();
                        if (!bl3) {
                            ((File)object4).mkdirs();
                        }
                        object3 = bf.a((String)object3);
                        object5 = new File((File)object4, (String)object3);
                        object3 = null;
                        bl2 = ((File)object5).exists();
                        if (bl2) break block16;
                        ((File)object5).createNewFile();
                    }
                    object4 = new FileOutputStream((File)object5);
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream((OutputStream)object4);
                    try {
                        bufferedOutputStream.write((byte[])object2);
                        bufferedOutputStream.flush();
                    }
                    catch (Throwable throwable) {
                        object3 = bufferedOutputStream;
                        break block17;
                    }
                    catch (Exception exception) {
                        object3 = bufferedOutputStream;
                        break block18;
                    }
                    y.a(bufferedOutputStream);
                    break block19;
                    catch (Exception exception) {
                        break block18;
                    }
                    catch (Throwable throwable) {
                        bl2 = false;
                        object4 = null;
                        break block17;
                    }
                    catch (Exception exception) {
                        bl2 = false;
                        object4 = null;
                    }
                }
                try {
                    b.a((Throwable)object2);
                }
                catch (Throwable throwable) {
                    // empty catch block
                }
                y.a((Closeable)object3);
            }
            y.a((Closeable)object4);
            long l10 = a;
            long l11 = 0L;
            long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            if (l12 == false) {
                object2 = new File;
                object3 = new StringBuilder();
                object = object.getCacheDir().getPath();
                ((StringBuilder)object3).append((String)object);
                object = File.separator;
                ((StringBuilder)object3).append((String)object);
                ((StringBuilder)object3).append(string2);
                object = ((StringBuilder)object3).toString();
                object2((String)object);
                long l13 = x.a((File)object2);
                long l14 = ((File)object5).length();
                a = l13 += l14;
            }
            return;
        }
        y.a((Closeable)object3);
        y.a((Closeable)object4);
        throw var0_4;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static Bitmap b(Context var0, String var1_2) {
        block8: {
            var3_8 = new StringBuilder();
            var0 /* !! */  = var0 /* !! */ .getCacheDir().getPath();
            var3_8.append((String)var0 /* !! */ );
            var0 /* !! */  = File.separator;
            var3_8.append((String)var0 /* !! */ );
            var3_8.append("mipush_icon");
            var0 /* !! */  = var3_8.toString();
            var1_2 = bf.a((String)var1_2);
            var2_4 = new File((String)var0 /* !! */ , (String)var1_2);
            var4_9 = var2_4.exists();
            var1_2 = null;
            if (!var4_9) {
                return null;
            }
            try {
                var0 /* !! */  = new FileInputStream(var2_4);
            }
            catch (Throwable var0_1) {
                var7_11 = var1_2;
                var1_2 = var0_1;
                var0 /* !! */  = var7_11;
                break block8;
            }
            catch (Exception var2_6) {
                var4_9 = false;
                var0 /* !! */  = null;
                ** GOTO lbl-1000
            }
            try {
                var1_2 = BitmapFactory.decodeStream((InputStream)var0 /* !! */ );
                var5_10 = System.currentTimeMillis();
                var2_4.setLastModified(var5_10);
            }
            catch (Throwable var1_3) {
                break block8;
            }
            catch (Exception var2_5) {
                var7_11 = var1_2;
                var1_2 = var0 /* !! */ ;
                var0 /* !! */  = var7_11;
                ** GOTO lbl-1000
            }
            y.a((Closeable)var0 /* !! */ );
            return var1_2;
lbl-1000:
            // 2 sources

            {
                b.a((Throwable)var2_7);
            }
            y.a((Closeable)var1_2);
            return var0 /* !! */ ;
        }
        y.a((Closeable)var0 /* !! */ );
        throw var1_2;
    }
}

