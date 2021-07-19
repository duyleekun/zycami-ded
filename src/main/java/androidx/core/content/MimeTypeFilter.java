/*
 * Decompiled with CFR 0.151.
 */
package androidx.core.content;

import java.util.ArrayList;

public final class MimeTypeFilter {
    private MimeTypeFilter() {
    }

    public static String matches(String stringArray, String[] stringArray2) {
        if (stringArray == null) {
            return null;
        }
        String string2 = "/";
        stringArray = stringArray.split(string2);
        for (String string3 : stringArray2) {
            String[] stringArray3 = string3.split(string2);
            boolean bl2 = MimeTypeFilter.mimeTypeAgainstFilter(stringArray, stringArray3);
            if (!bl2) continue;
            return string3;
        }
        return null;
    }

    public static String matches(String[] stringArray, String stringArray2) {
        if (stringArray == null) {
            return null;
        }
        String string2 = "/";
        stringArray2 = stringArray2.split(string2);
        for (String string3 : stringArray) {
            String[] stringArray3 = string3.split(string2);
            boolean bl2 = MimeTypeFilter.mimeTypeAgainstFilter(stringArray3, stringArray2);
            if (!bl2) continue;
            return string3;
        }
        return null;
    }

    public static boolean matches(String stringArray, String stringArray2) {
        if (stringArray == null) {
            return false;
        }
        String string2 = "/";
        stringArray = stringArray.split(string2);
        stringArray2 = stringArray2.split(string2);
        return MimeTypeFilter.mimeTypeAgainstFilter(stringArray, stringArray2);
    }

    public static String[] matchesMany(String[] stringArray, String stringArray2) {
        if (stringArray == null) {
            return new String[0];
        }
        ArrayList<String> arrayList = new ArrayList<String>();
        String string2 = "/";
        stringArray2 = stringArray2.split(string2);
        for (String string3 : stringArray) {
            String[] stringArray3 = string3.split(string2);
            boolean bl2 = MimeTypeFilter.mimeTypeAgainstFilter(stringArray3, stringArray2);
            if (!bl2) continue;
            arrayList.add(string3);
        }
        stringArray = new String[arrayList.size()];
        return arrayList.toArray(stringArray);
    }

    private static boolean mimeTypeAgainstFilter(String[] object, String[] object2) {
        int n10 = ((String[])object2).length;
        int n11 = 2;
        if (n10 == n11) {
            String string2;
            int n12;
            n10 = 0;
            String string3 = object2[0];
            int n13 = (int)(string3.isEmpty() ? 1 : 0);
            if (n13 == 0 && (n12 = (string2 = object2[n13 = 1]).isEmpty()) == 0) {
                boolean bl2;
                String string4;
                n12 = ((String[])object).length;
                if (n12 != n11) {
                    return false;
                }
                string2 = "*";
                String string5 = object2[0];
                n11 = (int)(string2.equals(string5) ? 1 : 0);
                if (n11 == 0 && (n11 = (int)((string5 = object2[0]).equals(string4 = object[0]) ? 1 : 0)) == 0) {
                    return false;
                }
                string5 = object2[n13];
                n11 = (int)(string2.equals(string5) ? 1 : 0);
                if (n11 == 0 && !(bl2 = ((String)(object2 = object2[n13])).equals(object = object[n13]))) {
                    return false;
                }
                return n13 != 0;
            }
            object = new IllegalArgumentException("Ill-formatted MIME type filter. Type or subtype empty.");
            throw object;
        }
        object = new IllegalArgumentException("Ill-formatted MIME type filter. Must be type/subtype.");
        throw object;
    }
}

