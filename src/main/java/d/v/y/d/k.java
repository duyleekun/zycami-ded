/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.d;

import java.nio.charset.Charset;
import java.util.Arrays;

public class k {
    public static final String a = "\u0000";
    private static final Charset b = Charset.forName("utf-8");
    private static final byte c;

    public static boolean a(String string2) {
        String string3;
        boolean bl2;
        if (string2 != null && !(bl2 = (string3 = "").equals(string2))) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }

    public static boolean b(String string2) {
        boolean bl2;
        if (string2 == null) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }

    public static String c(byte[] byArray) {
        return k.d(byArray, 0);
    }

    public static String d(byte[] byArray, int n10) {
        int n11 = byArray.length;
        return k.e(byArray, n10, n11);
    }

    public static String e(byte[] byArray, int n10, int n11) {
        Charset charset = b;
        String string2 = new String(byArray, n10, n11, charset);
        return string2.trim();
    }

    public static String[] f(String stringArray, int n10, char c10) {
        int n11;
        if (stringArray != null && (n11 = stringArray.isEmpty()) == 0) {
            if (n10 > 0) {
                n11 = (stringArray.length() + n10 + -1) / n10;
                int n12 = n11 * n10;
                char[] cArray = new char[n12];
                Arrays.fill(cArray, c10);
                stringArray = (String[])stringArray.toCharArray();
                c10 = (char)stringArray.length;
                int n13 = 0;
                System.arraycopy(stringArray, 0, cArray, 0, c10);
                stringArray = new String[n11];
                while (n13 < n11) {
                    String string2;
                    c10 = (char)(n13 * n10);
                    int n14 = n13 + 1;
                    int n15 = n14 * n10;
                    char[] cArray2 = Arrays.copyOfRange(cArray, (int)c10, n15);
                    stringArray[n13] = string2 = new String(cArray2);
                    n13 = n14;
                }
                return stringArray;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Illegal slice size ");
            stringBuilder.append(n10);
            String string3 = stringBuilder.toString();
            stringArray = new IllegalArgumentException(string3);
            throw stringArray;
        }
        stringArray = new NullPointerException("Need slice content is null");
        throw stringArray;
    }

    public static String[] g(String object, char c10) {
        char c11;
        boolean bl2 = ((String)object).isEmpty();
        if (bl2) {
            String[] stringArray = new String[]{object};
            return stringArray;
        }
        StringBuilder stringBuilder = new StringBuilder();
        object = ((String)object).toCharArray();
        for (int i10 = 0; i10 < (c11 = ((Object)object).length); ++i10) {
            c11 = (char)object[i10];
            if (c11 == c10) {
                c11 = '|';
                stringBuilder.append(c11);
                continue;
            }
            stringBuilder.append(c11);
        }
        object = stringBuilder.toString();
        System.out.println((String)object);
        return ((String)object).split("\\|");
    }

    public static byte[] h(String string2) {
        Charset charset = b;
        return string2.getBytes(charset);
    }

    public static int i(String object) {
        try {
            object = Integer.valueOf((String)object);
        }
        catch (NumberFormatException numberFormatException) {
            return 0;
        }
        return (Integer)object;
    }

    public static long j(String object) {
        try {
            object = Long.valueOf((String)object);
        }
        catch (NumberFormatException numberFormatException) {
            return 0L;
        }
        return (Long)object;
    }
}

