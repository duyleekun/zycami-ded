/*
 * Decompiled with CFR 0.151.
 */
package com.geetest.sdk;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.Charset;

public class o {
    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    static {
        StringWriter stringWriter;
        int n10 = 4;
        try {
            stringWriter = new StringWriter(n10);
        }
        catch (Exception exception) {
            return;
        }
        PrintWriter printWriter = new PrintWriter(stringWriter);
        printWriter.println();
        stringWriter.toString();
    }

    public static int a(Reader reader, Writer writer) {
        long l10;
        long l11 = o.b(reader, writer);
        long l12 = l11 - (l10 = Integer.MAX_VALUE);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object > 0) {
            return -1;
        }
        return (int)l11;
    }

    public static long a(Reader reader, Writer writer, char[] cArray) {
        int n10;
        int n11;
        long l10 = 0L;
        while ((n11 = -1) != (n10 = reader.read(cArray))) {
            n11 = 0;
            writer.write(cArray, 0, n10);
            long l11 = n10;
            l10 += l11;
        }
        return l10;
    }

    public static String a(InputStream inputStream, String object) {
        object = Charset.forName((String)object);
        return o.a(inputStream, (Charset)object);
    }

    public static String a(InputStream inputStream, Charset charset) {
        StringWriter stringWriter;
        try {
            stringWriter = new StringWriter();
        }
        catch (Exception exception) {
            return null;
        }
        o.a(inputStream, (Writer)stringWriter, charset);
        return stringWriter.toString();
    }

    public static String a(Reader reader) {
        StringWriter stringWriter;
        try {
            stringWriter = new StringWriter();
        }
        catch (Exception exception) {
            return null;
        }
        o.a(reader, (Writer)stringWriter);
        return stringWriter.toString();
    }

    public static String a(byte[] byArray, String object) {
        object = Charset.forName((String)object);
        String string2 = new String(byArray, (Charset)object);
        return string2;
    }

    public static void a(InputStream inputStream, Writer writer, Charset charset) {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charset);
        o.a(inputStreamReader, writer);
    }

    public static void a(String string2, Writer writer) {
        if (string2 != null) {
            writer.write(string2);
        }
    }

    public static long b(Reader reader, Writer writer) {
        char[] cArray = new char[4096];
        return o.a(reader, writer, cArray);
    }
}

