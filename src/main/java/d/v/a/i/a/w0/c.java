/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.util.Patterns
 */
package d.v.a.i.a.w0;

import android.text.TextUtils;
import android.util.Patterns;
import java.util.regex.Pattern;

public class c {
    public static boolean a(String string2) {
        return TextUtils.isEmpty((CharSequence)string2) ^ true;
    }

    public static boolean b(String string2) {
        return Patterns.EMAIL_ADDRESS.matcher(string2).matches();
    }

    public static boolean c(String string2) {
        return Pattern.compile("^[0-9]{1,20}$").matcher(string2).matches();
    }

    public static boolean d(String string2) {
        boolean bl2;
        boolean bl3 = c.c(string2);
        if (!bl3 && !(bl2 = c.b(string2))) {
            bl2 = false;
            string2 = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public static boolean e(String string2) {
        return Pattern.compile("^[0-9a-zA-Z]{8,32}$").matcher(string2).matches();
    }

    public static String f(String string2, String string3) {
        boolean bl2 = c.c(string3 = string3.trim());
        if (bl2) {
            StringBuilder stringBuilder = new StringBuilder();
            String string4 = "+";
            stringBuilder.append(string4);
            stringBuilder.append(string2);
            stringBuilder.append(string3);
            string3 = stringBuilder.toString();
        }
        return string3;
    }
}

