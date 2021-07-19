/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package d.c.a.n.a.d;

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class h {
    private static final String a = "Utils";

    public static int a(int n10, int n11, int n12, int n13) {
        int n14 = n11 / n13;
        int n15 = n10 / n12;
        n14 = (n14 = Math.min(n14, n15)) == 0 ? 0 : Integer.highestOneBit(n14);
        n15 = 1;
        n14 = Math.max(n15, n14);
        String string2 = a;
        boolean bl2 = Log.isLoggable((String)string2, (int)2);
        if (bl2 && n14 > n15) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Downsampling WEBP, sampleSize: ");
            stringBuilder.append(n14);
            String string3 = ", target dimens: [";
            stringBuilder.append(string3);
            stringBuilder.append(n12);
            String string4 = "x";
            stringBuilder.append(string4);
            stringBuilder.append(n13);
            String string5 = "], actual dimens: [";
            stringBuilder.append(string5);
            stringBuilder.append(n10);
            stringBuilder.append(string4);
            stringBuilder.append(n11);
            stringBuilder.append("]");
            String string6 = stringBuilder.toString();
            Log.v((String)string2, (String)string6);
        }
        return n14;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static byte[] b(InputStream inputStream) {
        int n10 = 16384;
        Object object = new ByteArrayOutputStream(n10);
        try {
            byte[] byArray = new byte[n10];
            while (true) {
                int n11;
                int n12;
                if ((n12 = inputStream.read(byArray)) == (n11 = -1)) {
                    ((OutputStream)object).flush();
                    return ((ByteArrayOutputStream)object).toByteArray();
                }
                n11 = 0;
                ((ByteArrayOutputStream)object).write(byArray, 0, n12);
            }
        }
        catch (IOException iOException) {
            String string2 = a;
            boolean bl2 = Log.isLoggable((String)string2, (int)5);
            if (bl2) {
                object = "Error reading data from stream";
                Log.w((String)string2, (String)object, (Throwable)iOException);
            }
            return null;
        }
    }
}

