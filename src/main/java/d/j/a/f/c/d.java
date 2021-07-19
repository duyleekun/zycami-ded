/*
 * Decompiled with CFR 0.151.
 */
package d.j.a.f.c;

public class d {
    private static final char[] a = "0123456789ABCDEF".toCharArray();

    public static String a(byte[] byArray) {
        int n10 = byArray.length * 2;
        StringBuilder stringBuilder = new StringBuilder(n10);
        for (char c10 : byArray) {
            char[] cArray = a;
            char c11 = c10 >> 4 & 0xF;
            c11 = cArray[c11];
            stringBuilder.append(c11);
            c10 &= 0xF;
            c10 = cArray[c10];
            stringBuilder.append(c10);
        }
        return stringBuilder.toString();
    }

    public static byte[] b(String string2) {
        return d.c(string2.toCharArray());
    }

    private static byte[] c(char[] object) {
        int n10 = ((char[])object).length & 1;
        if (n10 == 0) {
            int n11;
            n10 = ((char[])object).length >> 1;
            Object object2 = new byte[n10];
            int n12 = 0;
            int n13 = 0;
            while (n12 < (n11 = ((char[])object).length)) {
                n11 = object[n12];
                int n14 = 16;
                n11 = Character.digit((char)n11, n14);
                String string2 = "Illegal hexadecimal character at index ";
                int n15 = -1;
                if (n11 != n15) {
                    char c10;
                    if ((n14 = Character.digit(c10 = object[++n12], n14)) != n15) {
                        ++n12;
                        n11 = (byte)((n11 << 4 | n14) & 0xFF);
                        object2[n13] = n11;
                        ++n13;
                        continue;
                    }
                    object = new IllegalArgumentException;
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append(string2);
                    ((StringBuilder)object2).append(n12);
                    object2 = ((StringBuilder)object2).toString();
                    object((String)object2);
                    throw object;
                }
                object = new IllegalArgumentException;
                object2 = new StringBuilder;
                object2 = new StringBuilder();
                ((StringBuilder)object2).append(string2);
                ((StringBuilder)object2).append(n12);
                object2 = ((StringBuilder)object2).toString();
                object((String)object2);
                throw object;
            }
            return object2;
        }
        object = new IllegalArgumentException;
        object("Odd number of characters.");
        throw object;
    }
}

