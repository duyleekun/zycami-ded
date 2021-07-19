/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.d;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;

public class j {
    private static ClassLoader a() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        if (classLoader != null) {
            return classLoader;
        }
        return j.class.getClassLoader();
    }

    public static URL b(String string2) {
        return j.a().getResource(string2);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static byte[] c(String object) {
        Throwable throwable222222;
        int n10;
        int n11;
        object = j.b((String)object);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (object == null) return byteArrayOutputStream.toByteArray();
        int n12 = 8192;
        byte[] byArray = new byte[n12];
        InputStream inputStream = null;
        inputStream = FirebasePerfUrlConnection.openStream((URL)object);
        while ((n11 = inputStream.read(byArray)) != (n10 = -1)) {
            n10 = 0;
            byteArrayOutputStream.write(byArray, 0, n11);
        }
        if (inputStream == null) return byteArrayOutputStream.toByteArray();
        inputStream.close();
        return byteArrayOutputStream.toByteArray();
        {
            catch (IOException iOException) {
                iOException.printStackTrace();
                return byteArrayOutputStream.toByteArray();
            }
            catch (Throwable throwable222222) {
            }
            catch (IOException iOException) {}
            {
                iOException.printStackTrace();
                if (inputStream == null) return byteArrayOutputStream.toByteArray();
            }
            inputStream.close();
            return byteArrayOutputStream.toByteArray();
        }
        if (inputStream == null) throw throwable222222;
        try {
            inputStream.close();
            throw throwable222222;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        throw throwable222222;
    }

    public static String d(String object) {
        object = j.c((String)object);
        String string2 = "utf-8";
        try {
            String string3 = new String((byte[])object, string2);
            return string3;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            unsupportedEncodingException.printStackTrace();
            return "";
        }
    }
}

