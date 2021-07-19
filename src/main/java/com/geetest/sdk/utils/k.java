/*
 * Decompiled with CFR 0.151.
 */
package com.geetest.sdk.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

public class k {
    public static void a(InputStream inputStream, OutputStream outputStream) {
        int n10;
        int n11;
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
        int n12 = 1024;
        byte[] byArray = new byte[n12];
        while ((n11 = inputStream.read(byArray, 0, n12)) != (n10 = -1)) {
            gZIPOutputStream.write(byArray, 0, n11);
        }
        gZIPOutputStream.finish();
        gZIPOutputStream.close();
    }

    public static byte[] a(byte[] object) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream((byte[])object);
        object = new ByteArrayOutputStream;
        ((ByteArrayOutputStream)object)();
        k.a(byteArrayInputStream, (OutputStream)object);
        byte[] byArray = ((ByteArrayOutputStream)object).toByteArray();
        ((OutputStream)object).flush();
        ((ByteArrayOutputStream)object).close();
        byteArrayInputStream.close();
        return byArray;
    }
}

