/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.ExifInterface
 */
package l.a.o;

import android.media.ExifInterface;
import java.io.IOException;

public class a {
    public static int a(String string2) {
        int n10;
        ExifInterface exifInterface;
        try {
            exifInterface = new ExifInterface(string2);
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            n10 = 0;
            exifInterface = null;
        }
        int n11 = 0;
        string2 = null;
        if (exifInterface != null) {
            int n12;
            String string3 = "Orientation";
            n10 = exifInterface.getAttributeInt(string3, 0);
            if (n10 != (n12 = 3)) {
                n12 = 6;
                if (n10 != n12) {
                    n12 = 8;
                    if (n10 == n12) {
                        n11 = 270;
                    }
                } else {
                    n11 = 90;
                }
            } else {
                n11 = 180;
            }
        }
        return n11;
    }
}

