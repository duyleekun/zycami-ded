/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package d.v.c.v0.u;

import android.text.TextUtils;
import d.v.e.l.m1;

public class w {
    public static String a(String string2) {
        int n10;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2 && (n10 = Integer.parseInt(string2)) > 0) {
            return m1.b0(n10);
        }
        return "";
    }

    public static String b(String stringArray) {
        int n10;
        String string2;
        int n11 = TextUtils.isEmpty((CharSequence)stringArray);
        if (n11 == 0 && (n11 = (stringArray = TextUtils.split((String)stringArray, (String)(string2 = ","))).length) == (n10 = 2)) {
            return stringArray[0];
        }
        return "";
    }

    public static String c(String stringArray) {
        int n10;
        String string2;
        int n11 = TextUtils.isEmpty((CharSequence)stringArray);
        if (n11 == 0 && (n11 = (stringArray = TextUtils.split((String)stringArray, (String)(string2 = ","))).length) == (n10 = 2)) {
            return stringArray[1];
        }
        return "";
    }
}

