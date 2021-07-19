/*
 * Decompiled with CFR 0.151.
 */
package d.v.e.l;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class x1 {
    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String a(File var0) {
        block16: {
            block17: {
                if (var0 == null) return "";
                var1_7 = var0.isFile();
                if (var1_7 == 0) return "";
                var1_7 = var0.exists();
                if (var1_7 == 0) {
                    return "";
                }
                var1_7 = 0;
                var2_8 = null;
                var3_10 = new StringBuilder();
                var4_11 = 8192;
                var5_12 = new byte[var4_11];
                var6_13 = "MD5";
                var6_13 = MessageDigest.getInstance((String)var6_13);
                var7_14 = new FileInputStream((File)var0);
                while (true) {
                    var8_15 = var7_14.read((byte[])var5_12);
                    var1_7 = -1;
                    if (var8_15 == var1_7) break;
                    var6_13.update((byte[])var5_12, 0, var8_15);
                }
                var0 = var6_13.digest();
                var1_7 = ((Object)var0).length;
                for (var9_16 = 0; var9_16 < var1_7; ++var9_16) {
                    var4_11 = var0[var9_16] & 255;
                    var5_12 = Integer.toHexString(var4_11);
                    var10_17 = var5_12.length();
                    if (var10_17 == (var11_18 = 1)) {
                        var6_13 = new StringBuilder();
                        var12_19 = "0";
                        var6_13.append(var12_19);
                        var6_13.append((String)var5_12);
                        var5_12 = var6_13.toString();
                    }
                    var3_10.append((String)var5_12);
                }
                try {}
                catch (IOException var0_5) {
                    var0_5.printStackTrace();
                    return var3_10.toString().toUpperCase();
                }
                break block17;
                catch (Throwable var0_3) {
                    break block16;
                }
                catch (Exception var0_4) {
                    // empty catch block
                    ** GOTO lbl-1000
                }
                catch (Throwable var0_1) {
                    var2_8 = var7_14;
                    break block16;
                }
                catch (Exception var0_2) {
                    var2_8 = var7_14;
                    ** GOTO lbl-1000
                }
            }
            var7_14.close();
            return var3_10.toString().toUpperCase();
lbl-1000:
            // 2 sources

            {
                var0.printStackTrace();
                if (var2_8 == null) return var3_10.toString().toUpperCase();
            }
            {
                var2_8.close();
                return var3_10.toString().toUpperCase();
            }
        }
        if (var2_8 == null) throw var0_6;
        try {
            var2_8.close();
            throw var0_6;
        }
        catch (IOException var2_9) {
            var2_9.printStackTrace();
        }
        throw var0_6;
    }

    public static String b(String string2) {
        int n10 = 16;
        char[] cArray = new char[n10];
        int n11 = 48;
        cArray[0] = n11;
        n11 = 49;
        int n12 = 1;
        cArray[n12] = n11;
        n11 = 2;
        n12 = 50;
        cArray[n11] = n12;
        n11 = 3;
        n12 = 51;
        cArray[n11] = n12;
        n11 = 52;
        n12 = 4;
        cArray[n12] = n11;
        n11 = 5;
        n12 = 53;
        cArray[n11] = n12;
        n11 = 6;
        n12 = 54;
        cArray[n11] = n12;
        n11 = 7;
        n12 = 55;
        cArray[n11] = n12;
        n11 = 8;
        n12 = 56;
        cArray[n11] = n12;
        n11 = 9;
        n12 = 57;
        cArray[n11] = n12;
        n11 = 10;
        n12 = 97;
        cArray[n11] = n12;
        n11 = 11;
        n12 = 98;
        cArray[n11] = n12;
        n11 = 12;
        n12 = 99;
        cArray[n11] = n12;
        n11 = 13;
        n12 = 100;
        cArray[n11] = n12;
        n11 = 14;
        n12 = 101;
        cArray[n11] = n12;
        n11 = 102;
        n12 = 15;
        cArray[n12] = n11;
        Object object = "MD5";
        object = MessageDigest.getInstance((String)object);
        Object object2 = Charset.defaultCharset();
        object2 = string2.getBytes((Charset)object2);
        int n13 = ((Object)object2).length;
        ((MessageDigest)object).update((byte[])object2, 0, n13);
        object = ((MessageDigest)object).digest();
        n13 = 32;
        object2 = new StringBuilder(n13);
        n13 = ((Object)object).length;
        for (int i10 = 0; i10 < n13; ++i10) {
            Object object3 = object[i10];
            char c10 = object3 >> 4 & n12;
            c10 = cArray[c10];
            ((StringBuilder)object2).append(c10);
            object3 = object3 >> 0 & n12;
            object3 = cArray[object3];
            ((StringBuilder)object2).append((char)object3);
            continue;
        }
        try {
            string2 = ((StringBuilder)object2).toString();
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            noSuchAlgorithmException.printStackTrace();
        }
        return string2.toUpperCase();
    }
}

