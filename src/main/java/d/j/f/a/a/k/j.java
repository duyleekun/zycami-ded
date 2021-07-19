/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.util.Log
 */
package d.j.f.a.a.k;

import android.text.TextUtils;
import android.util.Log;

public class j {
    private static final String a = "j";
    private static final String b = "";

    public static String a(StringBuilder stringBuilder, int n10) {
        int n11 = TextUtils.isEmpty((CharSequence)stringBuilder);
        String string2 = b;
        if (n11 == 0 && (n11 = stringBuilder.length()) >= n10 && n10 >= 0) {
            try {
                return stringBuilder.substring(n10);
            }
            catch (Exception exception) {
                String string3 = a;
                StringBuilder stringBuilder2 = new StringBuilder();
                String string4 = "substring exception: ";
                stringBuilder2.append(string4);
                String string5 = exception.getMessage();
                stringBuilder2.append(string5);
                string5 = stringBuilder2.toString();
                Log.e((String)string3, (String)string5);
            }
        }
        return string2;
    }

    public static String b(StringBuilder stringBuilder, int n10, int n11) {
        int n12 = TextUtils.isEmpty((CharSequence)stringBuilder);
        String string2 = b;
        if (n12 == 0 && n10 >= 0 && n11 <= (n12 = stringBuilder.length()) && n11 >= n10) {
            try {
                return stringBuilder.substring(n10, n11);
            }
            catch (Exception exception) {
                String string3 = a;
                StringBuilder stringBuilder2 = new StringBuilder();
                String string4 = "substring: ";
                stringBuilder2.append(string4);
                String string5 = exception.getMessage();
                stringBuilder2.append(string5);
                string5 = stringBuilder2.toString();
                Log.e((String)string3, (String)string5);
            }
        }
        return string2;
    }
}

