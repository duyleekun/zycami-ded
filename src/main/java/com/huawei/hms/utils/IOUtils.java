/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.utils;

import com.huawei.hms.support.log.HMSLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public final class IOUtils {
    public static void closeQuietly(Closeable object) {
        if (object != null) {
            try {
                object.close();
            }
            catch (IOException iOException) {
                object = "IOUtils";
                String string2 = "An exception occurred while closing the 'Closeable' object.";
                HMSLog.e((String)object, string2);
            }
        }
    }

    public static void closeQuietly(InputStream inputStream) {
        IOUtils.closeQuietly((Closeable)inputStream);
    }

    public static void closeQuietly(OutputStream outputStream) {
        IOUtils.closeQuietly((Closeable)outputStream);
    }

    public static void closeQuietly(Reader reader) {
        IOUtils.closeQuietly((Closeable)reader);
    }

    public static void closeQuietly(Writer writer) {
        IOUtils.closeQuietly((Closeable)writer);
    }

    public static long copy(InputStream inputStream, OutputStream outputStream) {
        byte[] byArray = new byte[4096];
        return IOUtils.copy(inputStream, outputStream, byArray);
    }

    public static long copy(InputStream inputStream, OutputStream outputStream, byte[] byArray) {
        int n10;
        int n11;
        long l10 = 0L;
        while ((n11 = -1) != (n10 = inputStream.read(byArray))) {
            n11 = 0;
            outputStream.write(byArray, 0, n10);
            long l11 = n10;
            l10 += l11;
        }
        return l10;
    }

    public static byte[] toByteArray(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        IOUtils.copy(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static InputStream toInputStream(byte[] byArray) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray);
        return byteArrayInputStream;
    }
}

