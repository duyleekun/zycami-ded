/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package d.j.f.a.a.k;

import android.util.Log;

public class h {
    private static final String a = "h";
    private static final String b = "";

    public static String a(String string2, CharSequence charSequence, CharSequence charSequence2) {
        if (string2 != null && charSequence != null && charSequence2 != null) {
            try {
                return string2.replace(charSequence, charSequence2);
            }
            catch (Exception exception) {
                charSequence2 = a;
                StringBuilder stringBuilder = new StringBuilder();
                String string3 = "replace: ";
                stringBuilder.append(string3);
                String string4 = exception.getMessage();
                stringBuilder.append(string4);
                string4 = stringBuilder.toString();
                Log.e((String)charSequence2, (String)string4);
            }
        }
        return string2;
    }

    public static String b(String string2, int n10) {
        int n11;
        String string3 = b;
        if (string2 != null && (n11 = string2.length()) >= n10 && n10 >= 0) {
            try {
                return string2.substring(n10);
            }
            catch (Exception exception) {
                String string4 = a;
                StringBuilder stringBuilder = new StringBuilder();
                String string5 = "substring exception: ";
                stringBuilder.append(string5);
                String string6 = exception.getMessage();
                stringBuilder.append(string6);
                string6 = stringBuilder.toString();
                Log.e((String)string4, (String)string6);
            }
        }
        return string3;
    }

    public static String c(String string2, int n10, int n11) {
        int n12;
        String string3 = b;
        if (string2 != null && n10 >= 0 && n11 <= (n12 = string2.length()) && n11 >= n10) {
            try {
                return string2.substring(n10, n11);
            }
            catch (Exception exception) {
                String string4 = a;
                StringBuilder stringBuilder = new StringBuilder();
                String string5 = "substring: ";
                stringBuilder.append(string5);
                String string6 = exception.getMessage();
                stringBuilder.append(string6);
                string6 = stringBuilder.toString();
                Log.e((String)string4, (String)string6);
            }
        }
        return string3;
    }
}

