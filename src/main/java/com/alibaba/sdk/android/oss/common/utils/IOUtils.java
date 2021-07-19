/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.common.utils;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

public class IOUtils {
    private static final int BUFFER_SIZE = 4096;

    public static byte[] readStreamAsBytesArray(InputStream inputStream) {
        int n10;
        int n11;
        if (inputStream == null) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int n12 = 4096;
        byte[] byArray = new byte[n12];
        while ((n11 = inputStream.read(byArray)) > (n10 = -1)) {
            byteArrayOutputStream.write(byArray, 0, n11);
        }
        byteArrayOutputStream.flush();
        IOUtils.safeClose(byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] readStreamAsBytesArray(InputStream inputStream, int n10) {
        long l10;
        long l11;
        long l12;
        if (inputStream == null) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int n11 = 4096;
        byte[] byArray = new byte[n11];
        long l13 = 0L;
        while ((l12 = (l11 = l13 - (l10 = (long)n10)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) < 0) {
            int n12;
            l12 = 2048;
            int n13 = (int)(l10 -= l13);
            n13 = Math.min((int)l12, n13);
            if ((n13 = inputStream.read(byArray, 0, n13)) <= (n12 = -1)) break;
            byteArrayOutputStream.write(byArray, 0, n13);
            l10 = n13;
            l13 += l10;
        }
        byteArrayOutputStream.flush();
        IOUtils.safeClose(byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String readStreamAsString(InputStream inputStream, String string2) {
        void var1_4;
        StringWriter stringWriter;
        Reader reader;
        block7: {
            BufferedReader bufferedReader;
            if (inputStream == null) {
                return "";
            }
            reader = null;
            stringWriter = new StringWriter();
            int n10 = 4096;
            char[] cArray = new char[n10];
            try {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, string2);
                bufferedReader = new BufferedReader(inputStreamReader);
            }
            catch (Throwable throwable) {
                // empty catch block
                break block7;
            }
            try {
                int n11;
                while ((n11 = bufferedReader.read(cArray)) > 0) {
                    reader = null;
                    ((Writer)stringWriter).write(cArray, 0, n11);
                }
                string2 = ((Object)stringWriter).toString();
            }
            catch (Throwable throwable) {
                reader = bufferedReader;
            }
            IOUtils.safeClose(inputStream);
            ((Reader)bufferedReader).close();
            ((Writer)stringWriter).close();
            return string2;
        }
        IOUtils.safeClose(inputStream);
        if (reader != null) {
            reader.close();
        }
        ((Writer)stringWriter).close();
        throw var1_4;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void safeClose(InputStream inputStream) {
        if (inputStream == null) return;
        try {
            inputStream.close();
            return;
        }
        catch (IOException iOException) {
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void safeClose(OutputStream outputStream) {
        if (outputStream == null) return;
        try {
            outputStream.close();
            return;
        }
        catch (IOException iOException) {
            return;
        }
    }
}

