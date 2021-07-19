/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.codec;

import cn.leancloud.cache.PersistenceUtil;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MDFive {
    private static final int MAX_FILE_BUF_SIZE = 0x200000;
    private MessageDigest mdInstance = null;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private MDFive() {
        Object object = "MD5";
        try {
            object = MessageDigest.getInstance((String)object);
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            return;
        }
        this.mdInstance = object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String computeFileMD5(File object) {
        Object object2 = null;
        if (object == null) return object2;
        boolean bl2 = ((File)object).exists();
        if (!bl2) return object2;
        bl2 = ((File)object).isFile();
        if (!bl2) {
            return object2;
        }
        Object object3 = "MD5";
        try {
            int n10;
            int n11;
            object3 = MessageDigest.getInstance((String)object3);
            object = PersistenceUtil.getInputStreamFromFile((File)object);
            if (object == null) return object2;
            int n12 = 0x200000;
            byte[] byArray = new byte[n12];
            while ((n11 = ((InputStream)object).read(byArray)) != (n10 = -1)) {
                n10 = 0;
                ((MessageDigest)object3).update(byArray, 0, n11);
            }
            object3 = ((MessageDigest)object3).digest();
            object3 = MDFive.hexEncodeBytes((byte[])object3);
            ((InputStream)object).close();
            return object3;
        }
        catch (IOException | NoSuchAlgorithmException exception) {
            return object2;
        }
    }

    public static String computeMD5(String string2) {
        if (string2 == null) {
            return null;
        }
        return MDFive.computeMD5(string2.getBytes());
    }

    public static String computeMD5(byte[] byArray) {
        if (byArray == null) {
            return null;
        }
        Object object = "MD5";
        try {
            object = MessageDigest.getInstance((String)object);
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            object = new RuntimeException(noSuchAlgorithmException);
            throw object;
        }
        int n10 = byArray.length;
        ((MessageDigest)object).update(byArray, 0, n10);
        byArray = ((MessageDigest)object).digest();
        return MDFive.hexEncodeBytes(byArray);
    }

    public static MDFive getInstance() {
        MDFive mDFive = new MDFive();
        return mDFive;
    }

    public static String hexEncodeBytes(byte[] byArray) {
        int n10;
        if (byArray == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i10 = 0; i10 < (n10 = byArray.length); ++i10) {
            int n11;
            n10 = byArray[i10] & 0xFF;
            String string2 = Integer.toHexString(n10);
            int n12 = string2.length();
            if (n12 == (n11 = 1)) {
                n12 = 48;
                stringBuffer.append((char)n12);
            }
            stringBuffer.append(string2);
        }
        return stringBuffer.toString();
    }

    public byte[] digest() {
        MessageDigest messageDigest = this.mdInstance;
        if (messageDigest != null) {
            return messageDigest.digest();
        }
        return null;
    }

    public boolean prepare() {
        MessageDigest messageDigest = this.mdInstance;
        if (messageDigest != null) {
            messageDigest.reset();
            return true;
        }
        return false;
    }

    public void update(byte[] byArray, int n10, int n11) {
        MessageDigest messageDigest = this.mdInstance;
        if (messageDigest != null) {
            messageDigest.update(byArray, n10, n11);
        }
    }
}

