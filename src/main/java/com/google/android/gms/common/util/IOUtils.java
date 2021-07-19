/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.ParcelFileDescriptor
 */
package com.google.android.gms.common.util;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.internal.Preconditions;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class IOUtils {
    private IOUtils() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void closeQuietly(ParcelFileDescriptor parcelFileDescriptor) {
        if (parcelFileDescriptor == null) return;
        try {
            parcelFileDescriptor.close();
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
    public static void closeQuietly(Closeable closeable) {
        if (closeable == null) return;
        try {
            closeable.close();
            return;
        }
        catch (IOException iOException) {
            return;
        }
    }

    public static long copyStream(InputStream inputStream, OutputStream outputStream) {
        return IOUtils.zza(inputStream, outputStream, false);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static long copyStream(InputStream inputStream, OutputStream outputStream, boolean bl2, int n10) {
        byte[] byArray = new byte[n10];
        long l10 = 0L;
        try {
            int n12;
            int n11;
            while ((n11 = inputStream.read(byArray, 0, n10)) != (n12 = -1)) {
                long l11 = n11;
                l10 += l11;
                outputStream.write(byArray, 0, n11);
            }
            return l10;
        }
        finally {
            if (bl2) {
                IOUtils.closeQuietly(inputStream);
                IOUtils.closeQuietly(outputStream);
            }
        }
    }

    public static boolean isGzipByteBuffer(byte[] byArray) {
        int n10 = byArray.length;
        int n11 = 1;
        if (n10 > n11) {
            n10 = byArray[0] & 0xFF;
            int n12 = (byArray[n11] & 0xFF) << 8 | n10;
            if (n12 == (n10 = 35615)) {
                return n11 != 0;
            }
        }
        return false;
    }

    public static byte[] readInputStreamFully(InputStream inputStream) {
        return IOUtils.readInputStreamFully(inputStream, true);
    }

    public static byte[] readInputStreamFully(InputStream inputStream, boolean bl2) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        IOUtils.zza(inputStream, byteArrayOutputStream, bl2);
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] toByteArray(InputStream inputStream) {
        int n10;
        int n11;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Preconditions.checkNotNull(inputStream);
        Preconditions.checkNotNull(byteArrayOutputStream);
        int n12 = 4096;
        byte[] byArray = new byte[n12];
        while ((n11 = inputStream.read(byArray)) != (n10 = -1)) {
            n10 = 0;
            ((OutputStream)byteArrayOutputStream).write(byArray, 0, n11);
        }
        return byteArrayOutputStream.toByteArray();
    }

    private static long zza(InputStream inputStream, OutputStream outputStream, boolean bl2) {
        return IOUtils.copyStream(inputStream, outputStream, bl2, 1024);
    }
}

