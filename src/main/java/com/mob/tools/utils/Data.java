/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.util.Base64
 */
package com.mob.tools.utils;

import android.text.TextUtils;
import android.util.Base64;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.network.BufferedByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.security.Key;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.zip.CRC32;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.spec.SecretKeySpec;

public class Data {
    private static final String CHAT_SET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String AES128Decode(String object, byte[] object2) {
        if (object != null && object2 != null) {
            String string2 = "UTF-8";
            object = Data.AES128Decode(((String)object).getBytes(string2), object2);
            object2 = new String;
            object2((byte[])object, string2);
            return object2;
        }
        return null;
    }

    public static void AES128Decode(String string2, InputStream inputStream, OutputStream outputStream) {
        if (string2 == null) {
            return;
        }
        Data.AES128Decode(string2.getBytes("UTF-8"), inputStream, outputStream);
    }

    public static void AES128Decode(byte[] object, InputStream object2, OutputStream outputStream) {
        if (object != null && object2 != null && outputStream != null) {
            int n10 = 16;
            Object object3 = new byte[n10];
            n10 = Math.min(((byte[])object).length, n10);
            System.arraycopy(object, 0, object3, 0, n10);
            object = new SecretKeySpec;
            Object object4 = "AES";
            ((SecretKeySpec)object)((byte[])object3, (String)object4);
            object3 = new StringBuilder;
            ((StringBuilder)object3)();
            ((StringBuilder)object3).append((String)object4);
            ((StringBuilder)object3).append("/EC");
            ((StringBuilder)object3).append("B/PKCS7P");
            ((StringBuilder)object3).append("adding");
            object4 = ((StringBuilder)object3).toString();
            object3 = "BC";
            object4 = Data.getCipher((String)object4, (String)object3);
            int n11 = 2;
            ((Cipher)object4).init(n11, (Key)object);
            object = new CipherInputStream;
            ((CipherInputStream)object)((InputStream)object2, (Cipher)object4);
            int n12 = 1024;
            object2 = new byte[n12];
            n10 = ((CipherInputStream)object).read((byte[])object2);
            while (n10 != (n11 = -1)) {
                outputStream.write((byte[])object2, 0, n10);
                n10 = ((CipherInputStream)object).read((byte[])object2);
            }
            outputStream.flush();
        }
    }

    public static byte[] AES128Decode(byte[] object, byte[] byArray) {
        if (object != null && byArray != null) {
            int n10 = 16;
            Object object2 = new byte[n10];
            n10 = Math.min(((byte[])object).length, n10);
            System.arraycopy(object, 0, object2, 0, n10);
            object = new SecretKeySpec;
            Object object3 = "AES";
            object((byte[])object2, (String)object3);
            object2 = new StringBuilder;
            ((StringBuilder)object2)();
            ((StringBuilder)object2).append((String)object3);
            ((StringBuilder)object2).append("/EC");
            ((StringBuilder)object2).append("B/NoP");
            ((StringBuilder)object2).append("adding");
            object3 = Data.getCipher(((StringBuilder)object2).toString(), "BC");
            ((Cipher)object3).init(2, (Key)object);
            int n11 = byArray.length;
            object = new byte[((Cipher)object3).getOutputSize(n11)];
            int n12 = byArray.length;
            int n13 = ((Cipher)object3).update(byArray, 0, n12, (byte[])object, 0);
            ((Cipher)object3).doFinal((byte[])object, n13);
            return object;
        }
        return null;
    }

    public static byte[] AES128Encode(String object, String object2) {
        if (object != null && object2 != null) {
            CharSequence charSequence = "UTF-8";
            object = ((String)object).getBytes((String)charSequence);
            int n10 = 16;
            byte[] byArray = new byte[n10];
            n10 = Math.min(((Object)object).length, n10);
            System.arraycopy(object, 0, byArray, 0, n10);
            byte[] byArray2 = ((String)object2).getBytes((String)charSequence);
            object2 = "AES";
            object = new SecretKeySpec(byArray, (String)object2);
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append((String)object2);
            ((StringBuilder)charSequence).append("/EC");
            ((StringBuilder)charSequence).append("B/PKCS7P");
            ((StringBuilder)charSequence).append("adding");
            object2 = Data.getCipher(((StringBuilder)charSequence).toString(), "BC");
            ((Cipher)object2).init(1, (Key)object);
            int n11 = byArray2.length;
            object = new byte[((Cipher)object2).getOutputSize(n11)];
            int n12 = byArray2.length;
            int n13 = ((Cipher)object2).update(byArray2, 0, n12, (byte[])object, 0);
            ((Cipher)object2).doFinal((byte[])object, n13);
            return object;
        }
        return null;
    }

    public static byte[] AES128Encode(byte[] byArray, String object) {
        if (byArray != null && object != null) {
            object = ((String)object).getBytes("UTF-8");
            return Data.AES128Encode(byArray, (byte[])object);
        }
        return null;
    }

    public static byte[] AES128Encode(byte[] object, byte[] byArray) {
        String string2 = "AES";
        Object object2 = new SecretKeySpec((byte[])object, string2);
        object = new StringBuilder;
        ((StringBuilder)object)();
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append("/EC");
        ((StringBuilder)object).append("B/PKCS7P");
        ((StringBuilder)object).append("adding");
        object = Data.getCipher(((StringBuilder)object).toString(), "BC");
        ((Cipher)object).init(1, (Key)object2);
        int n10 = byArray.length;
        object2 = new byte[((Cipher)object).getOutputSize(n10)];
        int n11 = byArray.length;
        int n12 = ((Cipher)object).update(byArray, 0, n11, (byte[])object2, 0);
        ((Cipher)object).doFinal((byte[])object2, n12);
        return object2;
    }

    public static String Base64AES(String object, String object2) {
        String string2;
        block8: {
            String string3 = "\n";
            string2 = null;
            if (object != null && object2 != null) {
                boolean bl2;
                block7: {
                    object = Data.AES128Encode((String)object2, (String)object);
                    object2 = null;
                    string2 = Base64.encodeToString((byte[])object, (int)0);
                    bl2 = TextUtils.isEmpty((CharSequence)string2);
                    if (!bl2) break block7;
                    return string2;
                }
                bl2 = string2.contains(string3);
                if (!bl2) break block8;
                object = "";
                try {
                    string2 = string2.replace(string3, (CharSequence)object);
                }
                catch (Throwable throwable) {
                    object2 = MobLog.getInstance();
                    ((NLog)object2).w(throwable);
                }
            }
        }
        return string2;
    }

    public static String CRC32(byte[] object) {
        Object object2;
        Object object3;
        Object object4 = new CRC32();
        object4.update((byte[])object);
        long l10 = ((CRC32)object4).getValue();
        object = new StringBuilder;
        ((StringBuilder)object)();
        long l11 = l10 >>> 56;
        int n10 = (int)l11;
        int n11 = 1;
        Object object5 = new Object[n11];
        object5[0] = object3 = Integer.valueOf(n10 &= 0xFF);
        object3 = "%02x";
        object5 = String.format((String)object3, object5);
        ((StringBuilder)object).append((String)object5);
        int n12 = 48;
        int n13 = (int)(l10 >>> n12);
        Object[] objectArray = new Object[n11];
        objectArray[0] = object2 = Integer.valueOf(n13 & 0xFF);
        object2 = String.format((String)object3, objectArray);
        ((StringBuilder)object).append((String)object2);
        n13 = (byte)(l10 >>> 40);
        objectArray = new Object[n11];
        objectArray[0] = object2 = Integer.valueOf(n13 & 0xFF);
        object2 = String.format((String)object3, objectArray);
        ((StringBuilder)object).append((String)object2);
        n13 = (byte)(l10 >>> 32);
        objectArray = new Object[n11];
        objectArray[0] = object2 = Integer.valueOf(n13 & 0xFF);
        object2 = String.format((String)object3, objectArray);
        ((StringBuilder)object).append((String)object2);
        n13 = (byte)(l10 >>> 24);
        objectArray = new Object[n11];
        objectArray[0] = object2 = Integer.valueOf(n13 & 0xFF);
        object2 = String.format((String)object3, objectArray);
        ((StringBuilder)object).append((String)object2);
        n13 = (byte)(l10 >>> 16);
        objectArray = new Object[n11];
        objectArray[0] = object2 = Integer.valueOf(n13 & 0xFF);
        object2 = String.format((String)object3, objectArray);
        ((StringBuilder)object).append((String)object2);
        long l12 = l10 >>> 8;
        n13 = (byte)l12;
        objectArray = new Object[n11];
        objectArray[0] = object2 = Integer.valueOf(n13 &= 0xFF);
        object2 = String.format((String)object3, objectArray);
        ((StringBuilder)object).append((String)object2);
        int n14 = (int)l10;
        Object[] objectArray2 = new Object[n11];
        objectArray2[0] = object4 = Integer.valueOf(n14 &= 0xFF);
        object4 = String.format((String)object3, objectArray2);
        ((StringBuilder)object).append((String)object4);
        while ((n14 = (int)((StringBuilder)object).charAt(0)) == n12) {
            object = ((StringBuilder)object).deleteCharAt(0);
        }
        return ((StringBuilder)object).toString().toLowerCase();
    }

    public static String MD5(File object) {
        boolean bl2;
        if (object != null && (bl2 = ((File)object).exists())) {
            block5: {
                Object object2 = new FileInputStream((File)object);
                object = Data.rawMD5((InputStream)object2);
                try {
                    ((FileInputStream)object2).close();
                    if (object != null) break block5;
                    return null;
                }
                catch (Throwable throwable) {
                    object2 = MobLog.getInstance();
                    ((NLog)object2).w(throwable);
                }
            }
            return Data.toHex((byte[])object);
        }
        return null;
    }

    public static String MD5(String object) {
        if (object == null) {
            return null;
        }
        if ((object = (Object)Data.rawMD5((String)object)) == null) {
            return null;
        }
        return Data.toHex((byte[])object);
    }

    public static String MD5(byte[] byArray) {
        if (byArray == null) {
            return null;
        }
        int n10 = byArray.length;
        return Data.MD5(byArray, 0, n10);
    }

    public static String MD5(byte[] byArray, int n10, int n11) {
        if (byArray == null) {
            return null;
        }
        if ((byArray = Data.rawMD5(byArray, n10, n11)) == null) {
            return null;
        }
        return Data.toHex(byArray);
    }

    public static byte[] SHA1(File file) {
        boolean bl2;
        byte[] byArray = null;
        if (file != null && (bl2 = file.exists())) {
            Object object = new FileInputStream(file);
            byArray = Data.SHA1((InputStream)object);
            try {
                ((FileInputStream)object).close();
            }
            catch (Throwable throwable) {
                object = MobLog.getInstance();
                ((NLog)object).w(throwable);
            }
        }
        return byArray;
    }

    public static byte[] SHA1(InputStream inputStream) {
        int n10;
        byte[] byArray = null;
        if (inputStream == null) {
            return null;
        }
        int n11 = 1024;
        Object object = new byte[n11];
        Object object2 = "SHA-1";
        object2 = MessageDigest.getInstance((String)object2);
        int n12 = inputStream.read((byte[])object);
        while (n12 != (n10 = -1)) {
            n10 = 0;
            ((MessageDigest)object2).update((byte[])object, 0, n12);
            n12 = inputStream.read((byte[])object);
        }
        try {
            byArray = ((MessageDigest)object2).digest();
        }
        catch (Throwable throwable) {
            object = MobLog.getInstance();
            ((NLog)object).w(throwable);
        }
        return byArray;
    }

    public static byte[] SHA1(String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return null;
        }
        return Data.SHA1(string2.getBytes("utf-8"));
    }

    public static byte[] SHA1(byte[] byArray) {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
        messageDigest.update(byArray);
        return messageDigest.digest();
    }

    public static String base62(long l10) {
        long l11;
        long l12 = 0L;
        long l13 = l10 - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        String string2 = object == false ? "0" : "";
        while ((l11 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1)) > 0) {
            long l14 = 62;
            long l15 = l10 % l14;
            int n10 = (int)l15;
            l10 /= l14;
            StringBuilder stringBuilder = new StringBuilder();
            String string3 = CHAT_SET;
            char c10 = string3.charAt(n10);
            stringBuilder.append(c10);
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
        }
        return string2;
    }

    public static String byteToHex(byte[] byArray) {
        int n10 = byArray.length;
        return Data.byteToHex(byArray, 0, n10);
    }

    public static String byteToHex(byte[] byArray, int n10, int n11) {
        StringBuffer stringBuffer = new StringBuffer();
        if (byArray == null) {
            return stringBuffer.toString();
        }
        while (n10 < n11) {
            int n12 = 1;
            Object object = new Object[n12];
            byte by2 = byArray[n10];
            Byte by3 = by2;
            object[0] = by3;
            String string2 = "%02x";
            object = String.format(string2, object);
            stringBuffer.append((String)object);
            ++n10;
        }
        return stringBuffer.toString();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static Cipher getCipher(String string2, String string3) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string3);
        Object object = null;
        if (!bl2) {
            try {
                Object object2 = Security.getProvider(string3);
                if (object2 != null) {
                    object = object2 = Cipher.getInstance(string2, (Provider)object2);
                }
            }
            catch (Throwable throwable) {}
        }
        if (object != null) return object;
        return Cipher.getInstance(string2, string3);
    }

    private static byte[] hexToBytes(String string2) {
        int n10 = string2.length() / 2;
        byte[] byArray = new byte[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11 = i10 * 2;
            int n12 = n11 + 2;
            String string3 = string2.substring(n11, n12);
            n12 = 16;
            byArray[i10] = n11 = (int)((byte)Integer.parseInt(string3, n12));
        }
        return byArray;
    }

    public static byte[] rawMD5(InputStream inputStream) {
        int n10;
        byte[] byArray = null;
        if (inputStream == null) {
            return null;
        }
        int n11 = 1024;
        Object object = new byte[n11];
        Object object2 = "MD5";
        object2 = MessageDigest.getInstance((String)object2);
        int n12 = inputStream.read((byte[])object);
        while (n12 != (n10 = -1)) {
            n10 = 0;
            ((MessageDigest)object2).update((byte[])object, 0, n12);
            n12 = inputStream.read((byte[])object);
        }
        try {
            byArray = ((MessageDigest)object2).digest();
        }
        catch (Throwable throwable) {
            object = MobLog.getInstance();
            ((NLog)object).w(throwable);
        }
        return byArray;
    }

    public static byte[] rawMD5(String object) {
        byte[] byArray = null;
        if (object == null) {
            return null;
        }
        Object object2 = "utf-8";
        object = ((String)object).getBytes((String)object2);
        try {
            byArray = Data.rawMD5((byte[])object);
        }
        catch (Throwable throwable) {
            object2 = MobLog.getInstance();
            ((NLog)object2).w(throwable);
        }
        return byArray;
    }

    public static byte[] rawMD5(byte[] byArray) {
        if (byArray == null) {
            return null;
        }
        int n10 = byArray.length;
        return Data.rawMD5(byArray, 0, n10);
    }

    public static byte[] rawMD5(byte[] byArray, int n10, int n11) {
        byte[] byArray2 = null;
        if (byArray == null) {
            return null;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray, n10, n11);
        byArray = Data.rawMD5(byteArrayInputStream);
        try {
            byteArrayInputStream.close();
            byArray2 = byArray;
        }
        catch (Throwable throwable) {
            NLog nLog = MobLog.getInstance();
            nLog.w(throwable);
        }
        return byArray2;
    }

    public static byte[] rawRSADecode(byte[] byArray, byte[] object, int n10) {
        int n11;
        Object object2 = KeyFactory.getInstance("RSA");
        PKCS8EncodedKeySpec pKCS8EncodedKeySpec = new PKCS8EncodedKeySpec((byte[])object);
        object = (RSAPrivateKey)((KeyFactory)object2).generatePrivate(pKCS8EncodedKeySpec);
        object2 = Cipher.getInstance("RSA/None/PKCS1Padding");
        ((Cipher)object2).init(2, (Key)object);
        n10 /= 8;
        object = new BufferedByteArrayOutputStream;
        ((BufferedByteArrayOutputStream)object)();
        pKCS8EncodedKeySpec = null;
        int n12 = 0;
        while ((n11 = byArray.length - n12) > 0) {
            n11 = Math.min(byArray.length - n12, n10);
            byte[] byArray2 = ((Cipher)object2).doFinal(byArray, n12, n11);
            int n13 = byArray2.length;
            ((ByteArrayOutputStream)object).write(byArray2, 0, n13);
            n12 += n10;
        }
        ((ByteArrayOutputStream)object).close();
        return ((ByteArrayOutputStream)object).toByteArray();
    }

    public static byte[] rawRSAEncode(byte[] byArray, byte[] object, int n10) {
        int n11;
        n10 = n10 / 8 + -11;
        Object object2 = new X509EncodedKeySpec((byte[])object);
        object = (RSAPublicKey)KeyFactory.getInstance("RSA").generatePublic((KeySpec)object2);
        object2 = Cipher.getInstance("RSA/None/PKCS1Padding");
        ((Cipher)object2).init(1, (Key)object);
        object = new ByteArrayOutputStream;
        ((ByteArrayOutputStream)object)();
        int n12 = 0;
        while ((n11 = byArray.length - n12) > 0) {
            n11 = Math.min(byArray.length - n12, n10);
            byte[] byArray2 = ((Cipher)object2).doFinal(byArray, n12, n11);
            int n13 = byArray2.length;
            ((ByteArrayOutputStream)object).write(byArray2, 0, n13);
            n12 += n10;
        }
        ((ByteArrayOutputStream)object).close();
        return ((ByteArrayOutputStream)object).toByteArray();
    }

    private static String toHex(byte[] byArray) {
        int n10;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i10 = 0; i10 < (n10 = byArray.length); ++i10) {
            Object object;
            n10 = 1;
            Object object2 = new Object[n10];
            byte by2 = byArray[i10];
            object2[0] = object = Byte.valueOf(by2);
            object = "%02x";
            object2 = String.format((String)object, object2);
            stringBuffer.append((String)object2);
        }
        return stringBuffer.toString();
    }

    public static String urlEncode(String string2) {
        String string3 = "utf-8";
        try {
            return Data.urlEncode(string2, string3);
        }
        catch (Throwable throwable) {
            MobLog.getInstance().w(throwable);
            return null;
        }
    }

    public static String urlEncode(String string2, String string3) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)(string2 = URLEncoder.encode(string2, string3)));
        if (bl2) {
            return string2;
        }
        return string2.replace("+", "%20");
    }
}

