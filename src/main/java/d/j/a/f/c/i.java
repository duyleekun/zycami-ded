/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package d.j.a.f.c;

import android.util.Log;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

public final class i {
    public static String a(InputStream inputStream, String string2) {
        StringWriter stringWriter = new StringWriter();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, string2);
        i.c(inputStreamReader, stringWriter);
        return stringWriter.toString();
    }

    public static void b(Closeable object) {
        if (object != null) {
            try {
                object.close();
            }
            catch (IOException iOException) {
                object = "Utils";
                String string2 = "Exception when closing the 'Closeable'.";
                Log.e((String)object, (String)string2);
            }
        }
    }

    public static void c(Reader reader, Writer writer) {
        char[] cArray = new char[4096];
        i.d(reader, writer, cArray);
    }

    public static void d(Reader reader, Writer writer, char[] cArray) {
        int n10;
        int n11;
        while ((n11 = -1) != (n10 = reader.read(cArray))) {
            n11 = 0;
            writer.write(cArray, 0, n10);
        }
    }
}

