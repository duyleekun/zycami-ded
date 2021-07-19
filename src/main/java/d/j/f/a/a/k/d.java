/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 *  android.text.TextUtils
 *  android.util.Log
 */
package d.j.f.a.a.k;

import android.database.Cursor;
import android.text.TextUtils;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class d {
    private static final String a = "IOUtil";
    private static final int b = 4096;

    public static void a(Cursor cursor) {
        if (cursor != null) {
            cursor.close();
        }
    }

    public static void b(Closeable object) {
        if (object != null) {
            try {
                object.close();
            }
            catch (IOException iOException) {
                object = a;
                String string2 = "closeSecure IOException";
                Log.e((String)object, (String)string2);
            }
        }
    }

    public static void c(InputStream inputStream) {
        d.b(inputStream);
    }

    public static void d(OutputStream outputStream) {
        d.b(outputStream);
    }

    public static void e(Reader reader) {
        d.b(reader);
    }

    public static void f(Writer writer) {
        d.b(writer);
    }

    public static long g(InputStream inputStream, OutputStream outputStream) {
        byte[] byArray = new byte[4096];
        return d.h(inputStream, outputStream, byArray);
    }

    public static long h(InputStream inputStream, OutputStream outputStream, byte[] byArray) {
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

    public static void i(File object) {
        boolean bl2;
        boolean bl3;
        if (object != null && (bl3 = ((File)object).exists()) && !(bl2 = ((File)object).delete())) {
            object = a;
            String string2 = "deleteSecure exception";
            Log.e((String)object, (String)string2);
        }
    }

    public static void j(String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2) {
            File file = new File(string2);
            d.i(file);
        }
    }

    public static byte[] k(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        d.g(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static InputStream l(byte[] byArray) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray);
        return byteArrayInputStream;
    }
}

