/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.framework.utils;

import cn.sharesdk.framework.utils.h;

public class h$1
implements Appendable {
    public int a = -1;
    public char[] b;
    public final /* synthetic */ Appendable c;
    public final /* synthetic */ h d;

    public h$1(h object, Appendable appendable) {
        this.d = object;
        this.c = appendable;
        object = new char[2];
        this.b = (char[])object;
    }

    private void a(char[] cArray, int n10) {
        for (int i10 = 0; i10 < n10; ++i10) {
            Appendable appendable = this.c;
            char c10 = cArray[i10];
            appendable.append(c10);
        }
    }

    public Appendable append(char c10) {
        String string2;
        block11: {
            block9: {
                int n10;
                block10: {
                    block7: {
                        block8: {
                            n10 = this.a;
                            string2 = "' with value ";
                            int n11 = -1;
                            if (n10 == n11) break block7;
                            n10 = (int)(Character.isLowSurrogate(c10) ? 1 : 0);
                            if (n10 == 0) break block8;
                            Object object = this.d;
                            int n12 = Character.toCodePoint((char)this.a, c10);
                            if ((object = (Object)((h)object).a(n12)) != null) {
                                c10 = (char)((Object)object).length;
                                this.a((char[])object, c10);
                            } else {
                                object = this.c;
                                n12 = (char)this.a;
                                object.append((char)n12);
                                object = this.c;
                                object.append(c10);
                            }
                            this.a = n11;
                            break block9;
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Expected low surrogate character but got '");
                        stringBuilder.append(c10);
                        stringBuilder.append(string2);
                        stringBuilder.append((int)c10);
                        String string3 = stringBuilder.toString();
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string3);
                        throw illegalArgumentException;
                    }
                    n10 = (int)(Character.isHighSurrogate(c10) ? 1 : 0);
                    if (n10 == 0) break block10;
                    this.a = c10;
                    break block9;
                }
                n10 = (int)(Character.isLowSurrogate(c10) ? 1 : 0);
                if (n10 != 0) break block11;
                Object object = this.d.a(c10);
                if (object != null) {
                    c10 = (char)((char[])object).length;
                    this.a((char[])object, c10);
                } else {
                    object = this.c;
                    object.append(c10);
                }
            }
            return this;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unexpected low surrogate character '");
        stringBuilder.append(c10);
        stringBuilder.append(string2);
        stringBuilder.append((int)c10);
        String string4 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string4);
        throw illegalArgumentException;
    }

    public Appendable append(CharSequence charSequence) {
        int n10 = charSequence.length();
        return this.append(charSequence, 0, n10);
    }

    /*
     * Enabled aggressive block sorting
     */
    public Appendable append(CharSequence object, int n10, int n11) {
        int n12;
        if (n10 >= n11) return this;
        int n13 = this.a;
        int n14 = -1;
        if (n13 != n14) {
            n13 = object.charAt(n10);
            n12 = n10 + 1;
            char c10 = Character.isLowSurrogate((char)n13);
            if (c10 == '\u0000') {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Expected low surrogate character but got ");
                stringBuilder.append((char)n13);
                String string2 = stringBuilder.toString();
                object = new IllegalArgumentException(string2);
                throw object;
            }
            h h10 = this.d;
            char c11 = (char)this.a;
            char[] cArray = h10.a(n13 = Character.toCodePoint(c11, (char)n13));
            if (cArray != null) {
                n10 = cArray.length;
                this.a(cArray, n10);
                n10 = n12;
            } else {
                Appendable appendable = this.c;
                c10 = (char)this.a;
                appendable.append(c10);
            }
            this.a = n14;
            n13 = n10;
            n10 = n12;
        } else {
            n13 = n10;
        }
        while (true) {
            Object object2;
            if ((n10 = (int)((h)(object2 = this.d)).a((CharSequence)object, n10, n11)) > n13) {
                object2 = this.c;
                object2.append((CharSequence)object, n13, n10);
            }
            if (n10 == n11) {
                return this;
            }
            n13 = h.b((CharSequence)object, n10, n11);
            if (n13 < 0) {
                int n15;
                this.a = n15 = -n13;
                return this;
            }
            object2 = this.d.a(n13);
            if (object2 != null) {
                n12 = ((Object)object2).length;
                this.a((char[])object2, n12);
            } else {
                object2 = this.b;
                n12 = 0;
                n14 = Character.toChars(n13, (char[])object2, 0);
                char[] cArray = this.b;
                this.a(cArray, n14);
            }
            n13 = (int)(Character.isSupplementaryCodePoint(n13) ? 1 : 0);
            n13 = n13 != 0 ? 2 : 1;
            n13 += n10;
            n10 = n13;
        }
    }
}

