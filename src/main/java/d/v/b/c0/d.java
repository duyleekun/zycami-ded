/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.graphics.Bitmap$Config
 *  android.graphics.Matrix
 */
package d.v.b.c0;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import d.v.d.h.f;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.Objects;

public class d {
    public static byte[] a(ByteBuffer object, int n10, int n11, int n12) {
        block4: {
            Bitmap.Config config = Bitmap.Config.ARGB_8888;
            Bitmap bitmap = Bitmap.createBitmap((int)n10, (int)n11, (Bitmap.Config)config);
            bitmap.copyPixelsFromBuffer((Buffer)object);
            Matrix matrix = new Matrix();
            float f10 = n12;
            matrix.postRotate(f10);
            int n13 = bitmap.getWidth();
            int n14 = bitmap.getHeight();
            boolean bl2 = true;
            object = Bitmap.createBitmap((Bitmap)bitmap, (int)0, (int)0, (int)n13, (int)n14, (Matrix)matrix, (boolean)bl2);
            if (object == null) {
                return null;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
            int n15 = 90;
            object.compress(compressFormat, n15, (OutputStream)byteArrayOutputStream);
            object = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            n11 = (int)(bitmap.isRecycled() ? 1 : 0);
            if (n11 != 0) break block4;
            try {
                bitmap.recycle();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
        return object;
    }

    /*
     * Loose catch block
     */
    public static void b(Bitmap bitmap, String object) {
        block26: {
            int n10;
            BufferedOutputStream bufferedOutputStream;
            block25: {
                block23: {
                    boolean bl2;
                    block24: {
                        File file = new File((String)object);
                        bl2 = file.exists();
                        if (bl2) {
                            file.delete();
                        }
                        try {
                            file.createNewFile();
                        }
                        catch (IOException iOException) {
                            iOException.printStackTrace();
                        }
                        bl2 = false;
                        object = null;
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                        object = Bitmap.CompressFormat.PNG;
                        n10 = 90;
                        bitmap.compress((Bitmap.CompressFormat)object, n10, (OutputStream)bufferedOutputStream);
                        bitmap.recycle();
                        bufferedOutputStream.close();
                        bl2 = bitmap.isRecycled();
                        if (bl2) break block23;
                        bitmap.recycle();
                        catch (Exception exception) {
                            break block24;
                        }
                        catch (Throwable throwable) {
                            bufferedOutputStream = null;
                            object = throwable;
                            break block25;
                        }
                        catch (Exception exception) {
                            bufferedOutputStream = null;
                            object = exception;
                        }
                    }
                    ((Throwable)object).printStackTrace();
                    if (bufferedOutputStream == null) break block23;
                    bufferedOutputStream.close();
                    bl2 = bitmap.isRecycled();
                    if (bl2) break block23;
                    try {
                        bitmap.recycle();
                    }
                    catch (IOException iOException) {
                        iOException.printStackTrace();
                    }
                }
                return;
                catch (Throwable throwable) {
                    // empty catch block
                }
            }
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
                n10 = bitmap.isRecycled();
                if (n10 != 0) break block26;
                try {
                    bitmap.recycle();
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                }
            }
        }
        throw object;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void c(String var0, byte[] var1_7) {
        block12: {
            Objects.requireNonNull(var1_7);
            Objects.requireNonNull(var0);
            var2_9 = new StringBuilder();
            var3_10 = "save file path=";
            var2_9.append((String)var3_10);
            var2_9.append(var0);
            f.a(var2_9.toString());
            var2_9 = null;
            try {
                var4_11 = new FileOutputStream(var0);
                var3_10 = new BufferedOutputStream(var4_11);
            }
            catch (Throwable var0_4) {
                break block12;
            }
            catch (IOException var0_5) {
                // empty catch block
                ** GOTO lbl-1000
            }
            try {
                var3_10.write((byte[])var1_7);
                var3_10.flush();
                var3_10.close();
            }
            catch (Throwable var0_2) {
                var2_9 = var3_10;
                break block12;
            }
            catch (IOException var0_3) {
                var2_9 = var3_10;
                ** GOTO lbl-1000
            }
            {
                var3_10.close();
                return;
            }
lbl-1000:
            // 2 sources

            {
                var0.printStackTrace();
                var1_7 = new StringBuilder;
                var1_7();
                var3_10 = "save file failed=";
                var1_7.append((String)var3_10);
                var0 = var0.toString();
                var1_7.append(var0);
                var0 = var1_7.toString();
                f.a(var0);
                if (var2_9 == null) return;
            }
            {
                var2_9.close();
                return;
            }
        }
        if (var2_9 == null) throw var0_6;
        try {
            var2_9.close();
            throw var0_6;
        }
        catch (IOException var1_8) {
            var1_8.printStackTrace();
        }
        throw var0_6;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void d(ByteBuffer var0, int var1_3, int var2_4, int var3_5, String var4_6) {
        block16: {
            block17: {
                var5_7 = Bitmap.Config.ARGB_8888;
                var6_8 = Bitmap.createBitmap((int)var1_3, (int)var2_4, (Bitmap.Config)var5_7);
                var6_8.copyPixelsFromBuffer((Buffer)var0);
                var7_14 = new Matrix();
                var8_15 = var3_5;
                var7_14.postRotate(var8_15);
                var9_16 = var6_8.getWidth();
                var10_17 = var6_8.getHeight();
                var11_18 = true;
                var0 = Bitmap.createBitmap((Bitmap)var6_8, (int)0, (int)0, (int)var9_16, (int)var10_17, (Matrix)var7_14, (boolean)var11_18);
                if (var6_8 != null && (var2_4 = (int)var6_8.isRecycled()) == 0) {
                    var6_8.recycle();
                }
                if ((var2_4 = (int)(var6_8 = new File((String)var4_6)).exists()) != 0) {
                    var6_8.delete();
                }
                try {
                    var6_8.createNewFile();
                }
                catch (IOException var12_19) {
                    var12_19.printStackTrace();
                }
                var2_4 = 0;
                var12_20 = null;
                var4_6 = new FileOutputStream((File)var6_8);
                var13_21 = new BufferedOutputStream((OutputStream)var4_6);
                var6_8 = Bitmap.CompressFormat.PNG;
                var2_4 = 90;
                var0.compress((Bitmap.CompressFormat)var6_8, var2_4, var13_21);
                var0.recycle();
                try {}
                catch (IOException var0_1) {
                    var0_1.printStackTrace();
                    return;
                }
                break block17;
                catch (Throwable var6_11) {
                    break block16;
                }
                catch (Exception var6_12) {
                    // empty catch block
                    ** GOTO lbl-1000
                }
                catch (Throwable var6_9) {
                    var12_20 = var13_21;
                    break block16;
                }
                catch (Exception var6_10) {
                    var12_20 = var13_21;
                    ** GOTO lbl-1000
                }
            }
            var13_21.close();
            var1_3 = (int)var0.isRecycled();
            if (var1_3 != 0) return;
            var0.recycle();
            return;
lbl-1000:
            // 2 sources

            {
                var6_8.printStackTrace();
                if (var12_20 == null) return;
            }
            {
                var12_20.close();
                var1_3 = (int)var0.isRecycled();
                if (var1_3 != 0) return;
                var0.recycle();
                return;
            }
        }
        if (var12_20 == null) throw var6_13;
        try {
            var12_20.close();
            var2_4 = (int)var0.isRecycled();
            if (var2_4 != 0) throw var6_13;
            var0.recycle();
            throw var6_13;
        }
        catch (IOException var0_2) {
            var0_2.printStackTrace();
        }
        throw var6_13;
    }
}

