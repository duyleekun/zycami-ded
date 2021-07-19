/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import com.xiaomi.push.bc;
import java.util.Random;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class gu {
    private static Random a;
    private static final char[] a;
    private static final char[] b;
    private static final char[] c;
    private static final char[] d;
    private static final char[] e;
    private static char[] f;

    static {
        Random random;
        a = "&quot;".toCharArray();
        b = "&apos;".toCharArray();
        c = "&amp;".toCharArray();
        d = "&lt;".toCharArray();
        e = "&gt;".toCharArray();
        a = random = new Random();
        f = "0123456789abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    }

    public static String a(int n10) {
        int n11 = 1;
        if (n10 < n11) {
            return null;
        }
        char[] cArray = new char[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            char c10;
            char[] cArray2 = f;
            Random random = a;
            int n12 = 71;
            int n13 = random.nextInt(n12);
            cArray[i10] = c10 = cArray2[n13];
        }
        String string2 = new String(cArray);
        return string2;
    }

    public static String a(String string2) {
        if (string2 == null) {
            return null;
        }
        char[] cArray = string2.toCharArray();
        int n10 = cArray.length;
        double d10 = n10;
        double d11 = 1.3;
        int n11 = (int)(d10 *= d11);
        StringBuilder stringBuilder = new StringBuilder(n11);
        int n12 = 0;
        for (n11 = 0; n11 < n10; ++n11) {
            char[] cArray2;
            int n13 = cArray[n11];
            int n14 = 62;
            if (n13 > n14) continue;
            int n15 = 60;
            if (n13 == n15) {
                if (n11 > n12) {
                    n13 = n11 - n12;
                    stringBuilder.append(cArray, n12, n13);
                }
                n12 = n11 + 1;
                cArray2 = d;
                stringBuilder.append(cArray2);
                continue;
            }
            if (n13 == n14) {
                if (n11 > n12) {
                    n13 = n11 - n12;
                    stringBuilder.append(cArray, n12, n13);
                }
                n12 = n11 + 1;
                cArray2 = e;
                stringBuilder.append(cArray2);
                continue;
            }
            n14 = 38;
            if (n13 == n14) {
                if (n11 > n12) {
                    n13 = n11 - n12;
                    stringBuilder.append(cArray, n12, n13);
                }
                if (n10 > (n13 = n11 + 5)) {
                    n14 = n11 + 1;
                    n15 = 35;
                    if ((n14 = cArray[n14]) == n15) {
                        n14 = n11 + 2;
                        if ((n14 = (int)(Character.isDigit(cArray[n14]) ? 1 : 0)) != 0) {
                            n14 = n11 + 3;
                            if ((n14 = (int)(Character.isDigit(cArray[n14]) ? 1 : 0)) != 0) {
                                n14 = n11 + 4;
                                if ((n14 = (int)(Character.isDigit(cArray[n14]) ? 1 : 0)) != 0 && (n13 = cArray[n13]) == (n14 = 59)) continue;
                            }
                        }
                    }
                }
                n12 = n11 + 1;
                cArray2 = c;
                stringBuilder.append(cArray2);
                continue;
            }
            n14 = 34;
            if (n13 == n14) {
                if (n11 > n12) {
                    n13 = n11 - n12;
                    stringBuilder.append(cArray, n12, n13);
                }
                n12 = n11 + 1;
                cArray2 = a;
                stringBuilder.append(cArray2);
                continue;
            }
            n14 = 39;
            if (n13 != n14) continue;
            if (n11 > n12) {
                n13 = n11 - n12;
                stringBuilder.append(cArray, n12, n13);
            }
            n12 = n11 + 1;
            cArray2 = b;
            stringBuilder.append(cArray2);
        }
        if (n12 == 0) {
            return string2;
        }
        if (n11 > n12) {
            stringBuilder.append(cArray, n12, n11 -= n12);
        }
        return stringBuilder.toString();
    }

    public static final String a(String string2, String string3, String object) {
        if (string2 == null) {
            return null;
        }
        int n10 = 0;
        int n11 = string2.indexOf(string3, 0);
        if (n11 >= 0) {
            char[] cArray = string2.toCharArray();
            object = ((String)object).toCharArray();
            int n12 = string3.length();
            int n13 = cArray.length;
            StringBuilder stringBuilder = new StringBuilder(n13);
            stringBuilder.append(cArray, 0, n11);
            stringBuilder.append((char[])object);
            n11 += n12;
            while ((n10 = string2.indexOf(string3, n11)) > 0) {
                n13 = n10 - n11;
                stringBuilder.append(cArray, n11, n13);
                stringBuilder.append((char[])object);
                n11 = n10 + n12;
            }
            int n14 = cArray.length - n11;
            stringBuilder.append(cArray, n11, n14);
            string2 = stringBuilder.toString();
        }
        return string2;
    }

    public static String a(byte[] byArray) {
        return String.valueOf(bc.a(byArray));
    }

    public static final String b(String string2) {
        return gu.a(gu.a(gu.a(gu.a(gu.a(string2, "&lt;", "<"), "&gt;", ">"), "&quot;", "\""), "&apos;", "'"), "&amp;", "&");
    }
}

