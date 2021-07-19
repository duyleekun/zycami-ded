/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package d.j.f.a.a.k;

import android.util.Log;

public class i {
    private static final String a = "i";
    private static final String b = "";

    public static String a(StringBuffer stringBuffer, int n10) {
        int n11;
        String string2 = b;
        if (stringBuffer != null && (n11 = stringBuffer.length()) >= n10 && n10 >= 0) {
            try {
                return stringBuffer.substring(n10);
            }
            catch (Exception exception) {
                String string3 = a;
                StringBuilder stringBuilder = new StringBuilder();
                String string4 = "substring exception: ";
                stringBuilder.append(string4);
                String string5 = exception.getMessage();
                stringBuilder.append(string5);
                string5 = stringBuilder.toString();
                Log.e((String)string3, (String)string5);
            }
        }
        return string2;
    }

    public static String b(StringBuffer stringBuffer, int n10, int n11) {
        int n12;
        String string2 = b;
        if (stringBuffer != null && n10 >= 0 && n11 <= (n12 = stringBuffer.length()) && n11 >= n10) {
            try {
                return stringBuffer.substring(n10, n11);
            }
            catch (Exception exception) {
                String string3 = a;
                StringBuilder stringBuilder = new StringBuilder();
                String string4 = "substring: ";
                stringBuilder.append(string4);
                String string5 = exception.getMessage();
                stringBuilder.append(string5);
                string5 = stringBuilder.toString();
                Log.e((String)string3, (String)string5);
            }
        }
        return string2;
    }
}

