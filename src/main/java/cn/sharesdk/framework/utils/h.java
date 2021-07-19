/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.framework.utils;

import cn.sharesdk.framework.utils.Escaper;
import cn.sharesdk.framework.utils.d;
import cn.sharesdk.framework.utils.h$1;
import cn.sharesdk.framework.utils.h$a;

public abstract class h
implements Escaper {
    private static final char[] a(char[] cArray, int n10, int n11) {
        char[] cArray2 = new char[n11];
        if (n10 > 0) {
            System.arraycopy(cArray, 0, cArray2, 0, n10);
        }
        return cArray2;
    }

    public static final int b(CharSequence object, int n10, int n11) {
        if (n10 < n11) {
            char c10 = object.charAt(n10);
            ++n10;
            char c11 = '\ud800';
            if (c10 >= c11 && c10 <= (c11 = '\udfff')) {
                c11 = '\udbff';
                String string2 = " at index ";
                String string3 = "' with value ";
                if (c10 <= c11) {
                    if (n10 == n11) {
                        return -c10;
                    }
                    char c12 = object.charAt(n10);
                    n11 = (int)(Character.isLowSurrogate(c12) ? 1 : 0);
                    if (n11 != 0) {
                        return Character.toCodePoint(c10, c12);
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Expected low surrogate but got char '");
                    stringBuilder.append(c12);
                    stringBuilder.append(string3);
                    stringBuilder.append((int)c12);
                    stringBuilder.append(string2);
                    stringBuilder.append(n10);
                    object = stringBuilder.toString();
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
                    throw illegalArgumentException;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unexpected low surrogate character '");
                stringBuilder.append(c10);
                stringBuilder.append(string3);
                stringBuilder.append((int)c10);
                stringBuilder.append(string2);
                stringBuilder.append(n10 += -1);
                String string4 = stringBuilder.toString();
                object = new IllegalArgumentException(string4);
                throw object;
            }
            return c10;
        }
        object = new IndexOutOfBoundsException("Index exceeds specified range");
        throw object;
    }

    public int a(CharSequence charSequence, int n10, int n11) {
        char[] cArray;
        int n12;
        while (n10 < n11 && (n12 = h.b(charSequence, n10, n11)) >= 0 && (cArray = this.a(n12)) == null) {
            n12 = (n12 = (int)(Character.isSupplementaryCodePoint(n12) ? 1 : 0)) != 0 ? 2 : 1;
            n10 += n12;
        }
        return n10;
    }

    public final String a(String object, int n10) {
        int n11;
        int n12 = ((String)object).length();
        Object object2 = new h$a(null);
        object2 = (char[])((ThreadLocal)object2).get();
        int n13 = 0;
        int n14 = 0;
        while (n10 < n12) {
            n11 = h.b((CharSequence)object, n10, n12);
            if (n11 >= 0) {
                char[] cArray = this.a(n11);
                if (cArray != null) {
                    int n15 = ((Object)object2).length;
                    int n16 = n10 - n13;
                    int n17 = n14 + n16;
                    int n18 = cArray.length + n17;
                    if (n15 < n18) {
                        n15 = n12 - n10;
                        n18 = n18 + n15 + 32;
                        object2 = h.a((char[])object2, n14, n18);
                    }
                    if (n16 > 0) {
                        ((String)object).getChars(n13, n10, (char[])object2, n14);
                        n14 = n17;
                    }
                    if ((n13 = cArray.length) > 0) {
                        n13 = cArray.length;
                        System.arraycopy(cArray, 0, object2, n14, n13);
                        n13 = cArray.length;
                        n14 += n13;
                    }
                }
                n13 = (n13 = (int)(Character.isSupplementaryCodePoint(n11) ? 1 : 0)) != 0 ? 2 : 1;
                n10 = this.a((CharSequence)object, n13 += n10, n12);
                continue;
            }
            object = new IllegalArgumentException("Trailing high surrogate at end of input");
            throw object;
        }
        n10 = n12 - n13;
        if (n10 > 0) {
            n11 = ((Object)object2).length;
            if (n11 < (n10 += n14)) {
                object2 = h.a((char[])object2, n14, n10);
            }
            ((String)object).getChars(n13, n12, (char[])object2, n14);
            n14 = n10;
        }
        object = new String((char[])object2, 0, n14);
        return object;
    }

    public abstract char[] a(int var1);

    public Appendable escape(Appendable appendable) {
        d.a(appendable);
        h$1 h$1 = new h$1(this, appendable);
        return h$1;
    }

    public String escape(String string2) {
        int n10 = string2.length();
        int n11 = this.a(string2, 0, n10);
        if (n11 != n10) {
            string2 = this.a(string2, n11);
        }
        return string2;
    }
}

