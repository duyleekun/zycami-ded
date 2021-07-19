/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 *  android.text.TextUtils
 */
package d.j.f.a.a.h.f;

import android.database.Cursor;
import android.text.TextUtils;
import d.j.f.a.a.h.f.g;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class f {
    private static final String a = "IOUtil";
    private static final int b = 4096;

    public static long a(InputStream inputStream, OutputStream outputStream, byte[] byArray) {
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

    public static void b(Cursor cursor) {
        if (cursor != null) {
            cursor.close();
        }
    }

    public static void c(Closeable object) {
        if (object != null) {
            try {
                object.close();
            }
            catch (IOException iOException) {
                object = a;
                String string2 = "closeSecure IOException";
                g.f((String)object, string2);
            }
        }
    }

    public static void d(InputStream inputStream) {
        f.c(inputStream);
    }

    public static void e(OutputStream outputStream) {
        f.c(outputStream);
    }

    public static void f(Reader reader) {
        f.c(reader);
    }

    public static void g(Writer writer) {
        f.c(writer);
    }

    public static void h(File object) {
        boolean bl2;
        boolean bl3;
        if (object != null && (bl3 = ((File)object).exists()) && !(bl2 = ((File)object).delete())) {
            object = a;
            String string2 = "deleteSecure exception";
            g.f((String)object, string2);
        }
    }

    public static byte[] i(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        f.j(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static long j(InputStream inputStream, OutputStream outputStream) {
        byte[] byArray = new byte[4096];
        return f.a(inputStream, outputStream, byArray);
    }

    public static InputStream k(byte[] byArray) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray);
        return byteArrayInputStream;
    }

    public static void l(String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2) {
            File file = new File(string2);
            f.h(file);
        }
    }
}

