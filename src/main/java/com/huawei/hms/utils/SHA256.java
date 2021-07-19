/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.utils;

import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.IOUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class SHA256 {
    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static byte[] digest(File object) {
        void var0_3;
        BufferedInputStream bufferedInputStream;
        block8: {
            int n10 = 0;
            bufferedInputStream = null;
            Object object2 = "SHA-256";
            object2 = MessageDigest.getInstance((String)object2);
            FileInputStream fileInputStream = new FileInputStream((File)object);
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(fileInputStream);
            int n11 = 4096;
            {
                block9: {
                    block10: {
                        catch (Throwable throwable) {
                            // empty catch block
                            break block8;
                        }
                        catch (IOException | NoSuchAlgorithmException exception) {
                            break block9;
                        }
                        try {
                            int n12;
                            int n13;
                            object = new byte[n11];
                            n10 = 0;
                            bufferedInputStream = null;
                            while ((n13 = ((InputStream)bufferedInputStream2).read((byte[])object)) != (n12 = -1)) {
                                n10 += n13;
                                ((MessageDigest)object2).update((byte[])object, 0, n13);
                            }
                            if (n10 <= 0) break block10;
                            object = ((MessageDigest)object2).digest();
                        }
                        catch (Throwable throwable) {
                            bufferedInputStream = bufferedInputStream2;
                            break block8;
                        }
                        catch (IOException | NoSuchAlgorithmException exception) {}
                        IOUtils.closeQuietly(bufferedInputStream2);
                        return object;
                    }
                    IOUtils.closeQuietly(bufferedInputStream2);
                    return new byte[0];
                    bufferedInputStream = bufferedInputStream2;
                }
                object = "SHA256";
                object2 = "An exception occurred while computing file 'SHA-256'.";
                {
                    HMSLog.e((String)object, (String)object2);
                }
                IOUtils.closeQuietly(bufferedInputStream);
            }
            return new byte[0];
        }
        IOUtils.closeQuietly(bufferedInputStream);
        throw var0_3;
    }

    public static byte[] digest(byte[] byArray) {
        Object object = "SHA-256";
        try {
            object = MessageDigest.getInstance((String)object);
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            object = new StringBuilder();
            ((StringBuilder)object).append("NoSuchAlgorithmException");
            String string2 = noSuchAlgorithmException.getMessage();
            ((StringBuilder)object).append(string2);
            string2 = ((StringBuilder)object).toString();
            HMSLog.e("SHA256", string2);
            return new byte[0];
        }
        return ((MessageDigest)object).digest(byArray);
    }
}

