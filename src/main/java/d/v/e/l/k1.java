/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package d.v.e.l;

import android.text.TextUtils;
import d.v.e.l.l1;

public class k1 {
    public static int a(String object) {
        int n10;
        if (object == null) {
            return 0;
        }
        object = ((String)object).toCharArray();
        int n11 = 0;
        int n12 = 0;
        for (int i10 = 0; i10 < (n10 = ((Object)object).length); ++i10) {
            n10 = (char)((byte)object[i10]);
            Object object2 = object[i10];
            if (n10 != object2) {
                ++n12;
                continue;
            }
            ++n11;
        }
        int n13 = n11 % 2;
        n12 = n13 == 0 ? (n12 += (n11 /= 2)) : n12 + (n11 /= 2) + 1;
        return n12;
    }

    public static int b(String string2) {
        if (string2 == null) {
            return 0;
        }
        int n10 = string2.length();
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            char c10;
            char c11 = string2.charAt(i10);
            if (c11 != (c10 = '\n')) continue;
            ++n11;
        }
        return n11 + 1;
    }

    public static String c(String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        String string3 = "#unknow";
        if (bl2) {
            return string3;
        }
        l1 l12 = l1.c();
        string2 = l12.e(string2);
        bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return string3;
        }
        return string2.toUpperCase().substring(0, 1);
    }

    public static boolean d(char n10) {
        int n11 = 97;
        return n10 >= n11 && n10 <= (n11 = 122) || n10 >= (n11 = 65) && n10 <= (n11 = 90);
    }

    public static Object[] e(int[] nArray) {
        int n10;
        int n11 = nArray.length;
        Object[] objectArray = new Object[n11];
        for (int i10 = 0; i10 < (n10 = nArray.length); ++i10) {
            n10 = nArray[i10];
            Integer n12 = n10;
            objectArray[i10] = n12;
        }
        return objectArray;
    }
}

