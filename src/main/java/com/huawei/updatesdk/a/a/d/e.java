/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.updatesdk.a.a.d;

import java.util.List;

public class e {
    private static String a(String string2) {
        if (string2 == null) {
            string2 = "";
        }
        return string2;
    }

    public static String a(List list, String string2) {
        return e.a(list, string2, null, null);
    }

    public static String a(List object, String string2, String string3, String string4) {
        boolean bl2;
        if (object != null && !(bl2 = object.isEmpty())) {
            bl2 = false;
            String[] stringArray = new String[]{};
            object = e.a(object.toArray(stringArray), string2, string3, string4);
        } else {
            object = "";
        }
        return object;
    }

    public static String a(String[] stringArray, String string2) {
        return e.a(stringArray, string2, null, null);
    }

    public static String a(String[] stringArray, String string2, String string3, String string4) {
        int n10;
        if (stringArray != null && (n10 = stringArray.length) != 0) {
            int n11;
            string2 = e.a(string2);
            string3 = e.a(string3);
            string4 = e.a(string4);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string3);
            String string5 = stringArray[0];
            stringBuilder.append(string5);
            stringBuilder.append(string4);
            for (int i10 = 1; i10 < (n11 = stringArray.length); ++i10) {
                stringBuilder.append(string2);
                stringBuilder.append(string3);
                String string6 = stringArray[i10];
                stringBuilder.append(string6);
                stringBuilder.append(string4);
            }
            return stringBuilder.toString();
        }
        return "";
    }
}

