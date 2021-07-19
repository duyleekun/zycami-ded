/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 *  android.text.TextUtils
 */
package d.j.f.a.a.j.o;

import android.database.Cursor;
import android.text.TextUtils;
import d.j.f.a.a.j.o.i;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public abstract class h {
    private static final String a = "IOUtil";
    private static final int b = 4096;

    public static long a(InputStream inputStream, OutputStream outputStream) {
        byte[] byArray = new byte[4096];
        return h.b(inputStream, outputStream, byArray);
    }

    public static long b(InputStream inputStream, OutputStream outputStream, byte[] byArray) {
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

    public static InputStream c(byte[] byArray) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray);
        return byteArrayInputStream;
    }

    public static void d(Cursor cursor) {
        if (cursor != null) {
            cursor.close();
        }
    }

    public static void e(Closeable object) {
        if (object != null) {
            try {
                object.close();
            }
            catch (IOException iOException) {
                object = a;
                String string2 = "closeSecure IOException";
                i.d((String)object, string2);
            }
        }
    }

    public static void f(File object) {
        boolean bl2;
        boolean bl3;
        if (object != null && (bl3 = ((File)object).exists()) && !(bl2 = ((File)object).delete())) {
            object = a;
            String string2 = "deleteSecure exception";
            i.d((String)object, string2);
        }
    }

    public static void g(InputStream inputStream) {
        h.e(inputStream);
    }

    public static void h(OutputStream outputStream) {
        h.e(outputStream);
    }

    public static void i(Reader reader) {
        h.e(reader);
    }

    public static void j(Writer writer) {
        h.e(writer);
    }

    public static void k(String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2) {
            File file = new File(string2);
            h.f(file);
        }
    }

    public static byte[] l(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        h.a(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}

