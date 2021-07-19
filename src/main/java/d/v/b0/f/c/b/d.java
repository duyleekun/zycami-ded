/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.AssetManager
 */
package d.v.b0.f.c.b;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.IOException;
import java.io.InputStream;

public abstract class d {
    public static byte[] a(AssetManager object, String string2) {
        try {
            object = object.open(string2);
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            return new byte[0];
        }
        return d.b((InputStream)object);
    }

    public static byte[] b(InputStream inputStream) {
        int n10;
        try {
            n10 = inputStream.available();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            return new byte[0];
        }
        byte[] byArray = new byte[n10];
        inputStream.read(byArray);
        inputStream.close();
        return byArray;
    }

    public static String c(Context object, int n10) {
        object = d.b(object.getResources().openRawResource(n10));
        String string2 = new String((byte[])object);
        return string2;
    }
}

