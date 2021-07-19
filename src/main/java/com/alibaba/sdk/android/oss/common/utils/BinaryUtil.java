/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Base64
 */
package com.alibaba.sdk.android.oss.common.utils;

import android.util.Base64;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class BinaryUtil {
    public static String calculateBase64Md5(String string2) {
        return BinaryUtil.toBase64String(BinaryUtil.calculateMd5(string2));
    }

    public static String calculateBase64Md5(byte[] byArray) {
        return BinaryUtil.toBase64String(BinaryUtil.calculateMd5(byArray));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static byte[] calculateMd5(String object) {
        Object object2 = "MD5";
        try {
            object2 = MessageDigest.getInstance((String)object2);
            int n10 = 10240;
            byte[] byArray = new byte[n10];
            File file = new File((String)object);
            FileInputStream fileInputStream = new FileInputStream(file);
            while (true) {
                int n11;
                int n12;
                if ((n12 = fileInputStream.read(byArray)) == (n11 = -1)) {
                    fileInputStream.close();
                    return ((MessageDigest)object2).digest();
                }
                n11 = 0;
                file = null;
                ((MessageDigest)object2).update(byArray, 0, n12);
            }
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            object = new RuntimeException("MD5 algorithm not found.");
            throw object;
        }
    }

    public static byte[] calculateMd5(byte[] object) {
        Object object2 = "MD5";
        try {
            object2 = MessageDigest.getInstance((String)object2);
            ((MessageDigest)object2).update((byte[])object);
            return ((MessageDigest)object2).digest();
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            object = new RuntimeException;
            object("MD5 algorithm not found.");
            throw object;
        }
    }

    public static String calculateMd5Str(String string2) {
        return BinaryUtil.getMd5StrFromBytes(BinaryUtil.calculateMd5(string2));
    }

    public static String calculateMd5Str(byte[] byArray) {
        return BinaryUtil.getMd5StrFromBytes(BinaryUtil.calculateMd5(byArray));
    }

    private static String convertHashToString(byte[] byArray) {
        int n10;
        String string2 = "";
        for (int i10 = 0; i10 < (n10 = byArray.length); ++i10) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            int n11 = (byArray[i10] & 0xFF) + 256;
            string2 = Integer.toString(n11, 16);
            int n12 = 1;
            string2 = string2.substring(n12);
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
        }
        return string2.toLowerCase();
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String fileToSHA1(String object) {
        void var0_3;
        FileInputStream fileInputStream;
        InputStream inputStream;
        block13: {
            int n10;
            inputStream = null;
            fileInputStream = new FileInputStream((String)object);
            int n11 = 1024;
            object = new byte[n11];
            Object object2 = "SHA-1";
            object2 = MessageDigest.getInstance((String)object2);
            int n12 = 0;
            while (n12 != (n10 = -1)) {
                n12 = ((InputStream)fileInputStream).read((byte[])object);
                if (n12 <= 0) continue;
                ((MessageDigest)object2).update((byte[])object, 0, n12);
            }
            object = ((MessageDigest)object2).digest();
            object = BinaryUtil.convertHashToString((byte[])object);
            ((InputStream)fileInputStream).close();
            return object;
            {
                catch (Exception exception) {
                    return object;
                }
            }
            catch (Throwable throwable) {
                inputStream = fileInputStream;
                break block13;
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        if (inputStream == null) throw var0_3;
        inputStream.close();
        {
            catch (Exception exception) {
                throw var0_3;
            }
        }
        throw var0_3;
        catch (Exception exception) {
            block14: {
                fileInputStream = null;
                break block14;
                catch (Exception exception2) {}
            }
            if (fileInputStream == null) return null;
            try {
                ((InputStream)fileInputStream).close();
                return null;
            }
            catch (Exception exception3) {
                return null;
            }
        }
    }

    public static byte[] fromBase64String(String string2) {
        return Base64.decode((String)string2, (int)0);
    }

    public static String getMd5StrFromBytes(byte[] byArray) {
        int n10;
        if (byArray == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i10 = 0; i10 < (n10 = byArray.length); ++i10) {
            Object object;
            n10 = 1;
            Object object2 = new Object[n10];
            byte by2 = byArray[i10];
            object2[0] = object = Byte.valueOf(by2);
            object = "%02x";
            object2 = String.format((String)object, object2);
            stringBuilder.append((String)object2);
        }
        return stringBuilder.toString();
    }

    public static String toBase64String(byte[] byArray) {
        byArray = Base64.encode((byte[])byArray, (int)0);
        String string2 = new String(byArray);
        return string2.trim();
    }
}

