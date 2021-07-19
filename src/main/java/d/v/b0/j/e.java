/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.text.TextUtils
 */
package d.v.b0.j;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import d.v.b0.j.b;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class e {
    private static void a(byte[] byArray, int[] nArray, int n10, int n11) {
        int n12 = n10;
        int n13 = n11;
        int n14 = n10 * n11;
        int n15 = 0;
        int n16 = 0;
        for (int i10 = 0; i10 < n13; ++i10) {
            for (int i11 = 0; i11 < n12; ++i11) {
                int n17 = nArray[n16];
                n17 = (nArray[n16] & 0xFF0000) >> 16;
                int n18 = (nArray[n16] & 0xFF00) >> 8;
                int n19 = nArray[n16];
                int n20 = 255;
                n19 = (n19 & n20) >> 0;
                int n21 = n17 * 66;
                int n22 = n18 * 129;
                n21 += n22;
                n22 = n19 * 25;
                n21 = (n21 + n22 + 128 >> 8) + 16;
                n22 = n17 * -38;
                int n23 = n18 * 74;
                n22 -= n23;
                n23 = n19 * 112;
                n22 = (n22 + n23 + 128 >> 8) + 128;
                n17 *= 112;
                n17 -= (n18 *= 94);
                n17 = (n17 - (n19 *= 18) + 128 >> 8) + 128;
                n18 = n15 + 1;
                if (n21 < 0) {
                    n21 = 0;
                } else if (n21 > n20) {
                    n21 = n20;
                }
                byArray[n15] = n19 = (int)((byte)n21);
                n15 = i10 % 2;
                if (n15 == 0 && (n15 = n16 % 2) == 0) {
                    n15 = n14 + 1;
                    if (n17 < 0) {
                        n17 = 0;
                    } else if (n17 > n20) {
                        n17 = n20;
                    }
                    byArray[n14] = n17 = (int)((byte)n17);
                    n14 = n15 + 1;
                    if (n22 < 0) {
                        n20 = 0;
                    } else if (n22 <= n20) {
                        n20 = n22;
                    }
                    byArray[n15] = n17 = (int)((byte)n20);
                }
                ++n16;
                n15 = n18;
            }
        }
    }

    public static byte[] b(int n10, int n11, Bitmap bitmap) {
        int n12 = n10 * n11;
        int[] nArray = new int[n12];
        bitmap.getPixels(nArray, 0, n10, 0, 0, n10, n11);
        byte[] byArray = new byte[n12 * 3 / 2];
        e.a(byArray, nArray, n10, n11);
        bitmap.recycle();
        return byArray;
    }

    public static byte[] c(Context object, String string2) {
        block7: {
            Object object2;
            int n10 = TextUtils.isEmpty((CharSequence)string2);
            if (n10 != 0) {
                return null;
            }
            try {
                object = object.getAssets();
            }
            catch (Exception exception) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("Utils , readAssetFile");
                ((StringBuilder)object2).append("(");
                ((StringBuilder)object2).append(string2);
                ((StringBuilder)object2).append(")");
                ((StringBuilder)object2).append(" exception: ");
                String string3 = exception.toString();
                ((StringBuilder)object2).append(string3);
                b.b(((StringBuilder)object2).toString());
                return null;
            }
            object = object.open(string2);
            if (object == null) break block7;
            n10 = ((InputStream)object).available();
            object2 = new byte[n10];
            ((InputStream)object).read((byte[])object2);
            ((InputStream)object).close();
            return object2;
        }
        return null;
    }

    public static byte[] d(Context object, String string2) {
        Object object2;
        int n10;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return null;
        }
        try {
            object = new FileInputStream(string2);
            n10 = ((InputStream)object).available();
        }
        catch (Exception exception) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Utils , readFileFromPath");
            ((StringBuilder)object2).append("(");
            ((StringBuilder)object2).append(string2);
            ((StringBuilder)object2).append(")");
            ((StringBuilder)object2).append(" exception: ");
            String string3 = exception.toString();
            ((StringBuilder)object2).append(string3);
            b.b(((StringBuilder)object2).toString());
            return null;
        }
        object2 = new byte[n10];
        ((InputStream)object).read((byte[])object2);
        ((InputStream)object).close();
        return object2;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void e(byte[] var0, String var1_7) {
        block13: {
            block14: {
                var2_9 = null;
                var3_10 = new File((String)var1_7);
                var4_11 = var3_10.exists();
                if (var4_11) {
                    var3_10.delete();
                }
                var3_10.createNewFile();
                var1_7 = new FileOutputStream(var3_10);
                var1_7.write(var0);
                var1_7.flush();
                try {}
                catch (IOException var0_5) {
                    var0_5.printStackTrace();
                    return;
                }
                break block14;
                catch (Throwable var0_3) {
                    break block13;
                }
                catch (Exception var0_4) {
                    // empty catch block
                    ** GOTO lbl-1000
                }
                catch (Throwable var0_1) {
                    var2_9 = var1_7;
                    break block13;
                }
                catch (Exception var0_2) {
                    var2_9 = var1_7;
                    ** GOTO lbl-1000
                }
            }
            var1_7.close();
            return;
lbl-1000:
            // 2 sources

            {
                var0.printStackTrace();
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
}

