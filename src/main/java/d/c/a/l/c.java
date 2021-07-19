/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.l;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.nio.charset.Charset;

public final class c {
    public static final Charset a = Charset.forName("US-ASCII");
    public static final Charset b = Charset.forName("UTF-8");

    private c() {
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            }
            catch (RuntimeException runtimeException) {
                throw runtimeException;
            }
            catch (Exception exception) {}
        }
    }

    public static void b(File object) {
        Object object2 = ((File)object).listFiles();
        if (object2 != null) {
            int n10 = ((File[])object2).length;
            Object var4_4 = null;
            for (int i10 = 0; i10 < n10; ++i10) {
                File file = object2[i10];
                boolean bl2 = file.isDirectory();
                if (bl2) {
                    c.b(file);
                }
                if (bl2 = file.delete()) {
                    continue;
                }
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("failed to delete file: ");
                ((StringBuilder)object2).append(file);
                object2 = ((StringBuilder)object2).toString();
                object = new IOException((String)object2);
                throw object;
            }
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("not a readable directory: ");
        stringBuilder.append(object);
        object = stringBuilder.toString();
        object2 = new IOException((String)object);
        throw object2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String c(Reader reader) {
        try {
            int n10;
            int n11;
            Object object = new StringWriter();
            int n12 = 1024;
            char[] cArray = new char[n12];
            while ((n11 = reader.read(cArray)) != (n10 = -1)) {
                n10 = 0;
                ((StringWriter)object).write(cArray, 0, n11);
            }
            object = ((StringWriter)object).toString();
            return object;
        }
        finally {
            reader.close();
        }
    }
}

