/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.graphics.Matrix
 */
package d.m.a.f;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

public class c {
    public static String a = "UTF-8";

    public static int a(int n10, int n11) {
        n10 = n10 + n11 + -1;
        n11 = ~(n11 + -1);
        return n10 & n11;
    }

    public static long b(long l10, long l11, long l12) {
        long l13;
        long l14;
        long l15 = l10;
        long l16 = 0L;
        long l17 = l10 - l16;
        Object object = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
        if (object < 0 && (object = (l14 = l10 - (l13 = Long.MIN_VALUE)) == 0L ? 0 : (l14 < 0L ? -1 : 1)) != false) {
            l15 = -l10;
            l16 = l11;
            l13 = l12;
            return -c.b(l15, l11, l12);
        }
        l13 = l12 / (long)2;
        long l18 = Long.MAX_VALUE;
        long l19 = l11 - l18;
        Object object2 = l19 == 0L ? 0 : (l19 < 0L ? -1 : 1);
        if (object2 <= 0 && (object2 = l12 == l18 ? 0 : (l12 < l18 ? -1 : 1)) <= 0) {
            Object object3 = l15 == l18 ? 0 : (l15 < l18 ? -1 : 1);
            if (object3 <= 0) {
                return (l15 * l11 + l13) / l12;
            }
            l16 = l15 / l12 * l11;
            l15 = (l15 % l12 * l11 + l13) / l12;
            return l16 + l15;
        }
        l18 = -1;
        long l20 = l15 & l18;
        int n10 = 32;
        l18 = l11 & l18;
        long l21 = l11 >> n10;
        long l22 = l20 * l21;
        long l23 = (l15 >>= n10) * l18;
        l22 += l23;
        l23 = l22 << n10;
        l20 = l20 * l18 + l23;
        long l24 = l20 == l23 ? 0 : (l20 < l23 ? -1 : 1);
        l23 = 1L;
        double d10 = Double.MIN_VALUE;
        l18 = l24 < 0 ? l23 : l16;
        l15 *= l21;
        long l25 = l22 >> n10;
        l15 = l15 + l25 + l18;
        long l26 = (l20 += l13) - l13;
        object = l26 == 0L ? 0 : (l26 < 0L ? -1 : 1);
        if (object < 0) {
            l16 = l23;
        }
        l15 += l16;
        for (int i10 = 63; i10 >= 0; i10 += -1) {
            long l27 = (l20 >> i10 & l23) + l15;
            l22 += l22;
            long l28 = l12 - (l15 += l27);
            Object object4 = l28 == 0L ? 0 : (l28 < 0L ? -1 : 1);
            if (object4 > 0) continue;
            l15 -= l12;
            l22 += l23;
        }
        return l22;
    }

    public static char c(byte[] byArray) {
        int n10 = (byArray[0] & 0xFF) << 8;
        return (char)(byArray[1] & 0xFF | n10);
    }

    public static byte[] d(char c10) {
        byte by2 = (byte)((0xFF00 & c10) >> 8);
        byte[] byArray = new byte[]{by2, c10 = (char)(c10 & 0xFF)};
        return byArray;
    }

    public static byte[] e(char[] cArray) {
        Charset charset = Charset.forName("UTF-8");
        CharBuffer charBuffer = CharBuffer.allocate(cArray.length);
        charBuffer.put(cArray);
        charBuffer.flip();
        return charset.encode(charBuffer).array();
    }

    public static int f(int n10) {
        int n11 = (n10 & 0xFF) >> 0;
        int n12 = (0xFF00 & n10) >> 8;
        int n13 = (0xFF0000 & n10) >> 16;
        n10 = (n10 & 0xFF000000) >> 24;
        n11 <<= 24;
        n11 |= (n12 <<= 16);
        n12 = n13 << 8;
        return n10 << 0 | (n11 |= n12);
    }

    public static boolean g(Bitmap bitmap, String object) {
        boolean bl2;
        if (bitmap != null && object != null && !(bl2 = ((String)object).isEmpty())) {
            File file = new File((String)object);
            object = new FileOutputStream(file);
            file = Bitmap.CompressFormat.JPEG;
            int n10 = 100;
            try {
                bitmap.compress((Bitmap.CompressFormat)file, n10, (OutputStream)object);
                ((OutputStream)object).flush();
                ((FileOutputStream)object).close();
                return true;
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
            catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        }
        return false;
    }

    public static Bitmap h(Bitmap bitmap, int n10, int n11) {
        if (bitmap == null) {
            return null;
        }
        int n12 = bitmap.getHeight();
        int n13 = bitmap.getWidth();
        float f10 = n10;
        float f11 = n13;
        f10 /= f11;
        float f12 = n11;
        f11 = n12;
        Matrix matrix = new Matrix();
        matrix.postScale(f10, f12 /= f11);
        return Bitmap.createBitmap((Bitmap)bitmap, (int)0, (int)0, (int)n13, (int)n12, (Matrix)matrix, (boolean)false);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static int i(Object var0) {
        block22: {
            block21: {
                block20: {
                    block19: {
                        var1_6 = new ByteArrayOutputStream();
                        var2_7 = null;
                        var3_8 = new ObjectOutputStream(var1_6);
                        var3_8.writeObject(var0);
                        var0 = var1_6.toByteArray();
                        var4_9 = ((Object)var0).length;
                        try {
                            var3_8.close();
                            break block19;
                        }
                        catch (IOException v0) {}
                        catch (Throwable var0_1) {
                            var2_7 = var3_8;
                            break block20;
                        }
                        catch (IOException var0_2) {
                            var2_7 = var3_8;
                            ** GOTO lbl-1000
                        }
                    }
                    try {
                        var1_6.close();
                        return var4_9;
                    }
                    catch (IOException v1) {
                        return var4_9;
                    }
                    catch (Throwable var0_3) {
                        break block20;
                    }
                    catch (IOException var0_4) {
                        // empty catch block
                    }
lbl-1000:
                    // 2 sources

                    {
                        var0.printStackTrace();
                        if (var2_7 == null) break block21;
                    }
                    try {
                        var2_7.close();
                        break block21;
                    }
                    catch (IOException v2) {}
                }
                if (var2_7 == null) break block22;
                try {
                    var2_7.close();
                    break block22;
                }
                catch (IOException v3) {}
            }
            try {
                var1_6.close();
                return 0;
            }
            catch (IOException v4) {
                return 0;
            }
        }
        try {
            var1_6.close();
        }
        catch (IOException v5) {
            throw var0_5;
        }
        throw var0_5;
    }
}

