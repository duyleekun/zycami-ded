/*
 * Decompiled with CFR 0.151.
 */
package d.j.f.a.a.f;

public class b {
    public static int a(String string2, char c10, int n10) {
        char c11;
        int n11;
        for (n11 = string2.length() + -1; n11 >= 0 && ((c11 = string2.charAt(n11)) != c10 || (n10 += -1) > 0); n11 += -1) {
        }
        return n11;
    }

    public static String b(String object, String string2, String string3) {
        int n10;
        if (object != null && (n10 = ((String)object).length()) > 0 && (n10 = string2.length()) > 0 && (n10 = string3.length()) > 0) {
            int n11;
            char[] cArray = ((String)object).toCharArray();
            int n12 = ((String)object).length();
            object = new char[n12];
            int n13 = string3.length() + -1;
            n13 = string3.charAt(n13);
            for (int i10 = 0; i10 < (n11 = cArray.length); ++i10) {
                n11 = cArray[i10];
                int n14 = string2.lastIndexOf(n11);
                if (n14 < 0) {
                    object[i10] = n11;
                    continue;
                }
                n11 = string3.length();
                n11 = n14 >= n11 ? n13 : (int)string3.charAt(n14);
                object[i10] = n11;
            }
            string2 = new String((char[])object);
            return string2;
        }
        return object;
    }

    public static String c(String[] stringArray, int n10) {
        int n11;
        String string2 = "";
        if (stringArray != null && (n11 = stringArray.length) > 0 && n10 >= 0 && n10 < (n11 = stringArray.length)) {
            return stringArray[n10];
        }
        return string2;
    }

    public static String[] d(String string2, char c10) {
        int n10;
        int n11;
        if (string2 == null) {
            return new String[0];
        }
        int n12 = string2.length();
        int n13 = 1;
        if (n12 <= 0) {
            String[] stringArray = new String[n13];
            stringArray[0] = string2;
            return stringArray;
        }
        String[] stringArray = null;
        int n14 = n13;
        for (n12 = 0; n12 < (n11 = string2.length()); ++n12) {
            n11 = string2.charAt(n12);
            if (n11 != c10) continue;
            ++n14;
        }
        if (n14 <= n13) {
            String[] stringArray2 = new String[n13];
            stringArray2[0] = string2;
            return stringArray2;
        }
        stringArray = new String[n14];
        n11 = string2.length();
        StringBuilder stringBuilder = new StringBuilder(n11);
        int n15 = 0;
        for (n11 = 0; n11 < (n10 = string2.length()) && n15 < n14; ++n11) {
            n10 = string2.charAt(n11);
            if (n10 == c10) {
                String string3;
                n10 = n15 + 1;
                stringArray[n15] = string3 = stringBuilder.toString();
                stringBuilder.setLength(0);
                n15 = n10;
                continue;
            }
            stringBuilder.append((char)n10);
        }
        stringArray[n15] = string2 = stringBuilder.toString();
        return stringArray;
    }

    public static String[] e(String stringArray, int n10, int n11) {
        stringArray = b.m((String)stringArray, n10);
        String string2 = b.c(stringArray, 0);
        stringArray = b.c(stringArray, 1);
        stringArray = b.m((String)stringArray, n11 -= n10);
        return b.h(string2, stringArray);
    }

    public static String[] f(String stringArray, int n10, int n11, int n12) {
        stringArray = b.m((String)stringArray, n10);
        String string2 = b.c(stringArray, 0);
        stringArray = b.c(stringArray, 1);
        stringArray = b.e((String)stringArray, n11 -= n10, n12 -= n10);
        return b.h(string2, stringArray);
    }

    public static String[] g(String stringArray, int ... object) {
        int n10;
        if (stringArray == null) {
            return new String[]{""};
        }
        int n11 = stringArray.length();
        if (n11 > (n10 = 1) && (n11 = ((int[])object).length) > 0) {
            n11 = ((int[])object).length;
            if (n11 <= n10) {
                int n12 = object[0];
                return b.m((String)stringArray, n12);
            }
            n11 = object[0];
            int n13 = ((int[])object).length - n10;
            int[] nArray = new int[n13];
            int n14 = 0;
            while (n14 < n13) {
                int n15;
                int n16 = n14 + 1;
                nArray[n14] = n15 = object[n16] - n11;
                n14 = n16;
            }
            stringArray = b.m((String)stringArray, n11);
            object = b.c(stringArray, 0);
            stringArray = b.g(b.c(stringArray, n10), nArray);
            return b.h((String)object, stringArray);
        }
        object = new String[n10];
        object[0] = (int)stringArray;
        return object;
    }

    public static String[] h(String string2, String[] stringArray) {
        String[] stringArray2 = new String[]{string2};
        return b.j(stringArray2, stringArray);
    }

    public static String[] i(String[] stringArray, String string2) {
        String[] stringArray2 = new String[]{string2};
        return b.j(stringArray, stringArray2);
    }

    public static String[] j(String[] stringArray, String[] stringArray2) {
        int n10 = stringArray.length;
        if (n10 <= 0) {
            int n11 = stringArray2.length;
            if (n11 <= 0) {
                return new String[0];
            }
            return stringArray2;
        }
        n10 = stringArray2.length;
        if (n10 <= 0) {
            return stringArray;
        }
        n10 = stringArray.length;
        int n12 = stringArray2.length;
        String[] stringArray3 = new String[n10 + n12];
        n12 = stringArray.length;
        System.arraycopy(stringArray, 0, stringArray3, 0, n12);
        int n13 = stringArray.length;
        n12 = stringArray2.length;
        System.arraycopy(stringArray2, 0, stringArray3, n13, n12);
        return stringArray3;
    }

    public static String k(String string2, char c10) {
        int n10;
        if (string2 != null && (n10 = string2.length()) > 0) {
            int n11 = string2.length();
            char[] cArray = new char[n11];
            for (int i10 = 0; i10 < n11; ++i10) {
                cArray[i10] = c10;
            }
            string2 = new String(cArray);
            return string2;
        }
        return "";
    }

    public static String l(String string2, String ... stringArray) {
        int n10;
        if (stringArray != null && (n10 = stringArray.length) > 0) {
            int n11;
            String string3 = stringArray[0];
            StringBuilder stringBuilder = new StringBuilder(string3);
            for (int i10 = 1; i10 < (n11 = stringArray.length); ++i10) {
                String string4 = stringArray[i10];
                if (string4 == null) continue;
                stringBuilder.append(string2);
                string4 = stringArray[i10];
                stringBuilder.append(string4);
            }
            return stringBuilder.toString();
        }
        return "";
    }

    public static String[] m(String string2, int n10) {
        int n11;
        String[] stringArray = "";
        if (string2 == null) {
            return new String[]{stringArray, stringArray};
        }
        int n12 = 1;
        int n13 = 2;
        if (n10 >= 0 && n10 <= (n11 = string2.length())) {
            String string3;
            stringArray = new String[n13];
            stringArray[0] = string3 = string2.substring(0, n10);
            stringArray[n12] = string2 = string2.substring(n10);
            return stringArray;
        }
        String[] stringArray2 = new String[n13];
        stringArray2[0] = string2;
        stringArray2[n12] = stringArray;
        return stringArray2;
    }
}

