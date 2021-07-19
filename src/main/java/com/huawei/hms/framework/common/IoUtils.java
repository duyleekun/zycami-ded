/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 */
package com.huawei.hms.framework.common;

import android.database.Cursor;
import com.huawei.hms.framework.common.Logger;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class IoUtils {
    private static final int BUFF_SIZE = 4096;
    private static final int MAX_SIZE = 0x1000000;

    private IoUtils() {
    }

    public static void close(Cursor cursor) {
        if (cursor != null) {
            cursor.close();
        }
    }

    public static void closeSecure(Closeable object) {
        String string2 = "IOUtil";
        if (object != null) {
            try {
                object.close();
            }
            catch (IOException iOException) {
                String string3 = "closeSecure IOException";
                Logger.w(string2, string3, iOException);
            }
        } else {
            object = "closeable is null";
            Logger.w(string2, object);
        }
    }

    public static void closeSecure(InputStream inputStream) {
        IoUtils.closeSecure((Closeable)inputStream);
    }

    public static void closeSecure(OutputStream outputStream) {
        IoUtils.closeSecure((Closeable)outputStream);
    }

    public static void closeSecure(Reader reader) {
        IoUtils.closeSecure((Closeable)reader);
    }

    public static void closeSecure(Writer writer) {
        IoUtils.closeSecure((Closeable)writer);
    }

    public static long copy(InputStream object, OutputStream outputStream) {
        int n10;
        int n11;
        int n12 = 4096;
        byte[] byArray = new byte[n12];
        long l10 = 0L;
        while ((n11 = -1) != (n10 = ((InputStream)object).read(byArray))) {
            long l11 = 0x1000000L;
            long l12 = l10 - l11;
            n11 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
            if (n11 <= 0) {
                n11 = 0;
                outputStream.write(byArray, 0, n10);
                long l13 = n10;
                l10 += l13;
                continue;
            }
            object = new IOException("input data too large for byte.");
            throw object;
        }
        return l10;
    }

    public static byte[] toByteArray(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        IoUtils.copy(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}

