/*
 * Decompiled with CFR 0.151.
 */
package com.bumptech.glide.load.engine;

public final class GlideException$a
implements Appendable {
    private static final String c = "";
    private static final String d = "  ";
    private final Appendable a;
    private boolean b = true;

    public GlideException$a(Appendable appendable) {
        this.a = appendable;
    }

    private CharSequence a(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = c;
        }
        return charSequence;
    }

    public Appendable append(char c10) {
        char c11 = this.b;
        boolean bl2 = false;
        if (c11 != '\u0000') {
            this.b = false;
            Appendable appendable = this.a;
            String string2 = d;
            appendable.append(string2);
        }
        if (c10 == (c11 = '\n')) {
            bl2 = true;
        }
        this.b = bl2;
        this.a.append(c10);
        return this;
    }

    public Appendable append(CharSequence charSequence) {
        charSequence = this.a(charSequence);
        int n10 = charSequence.length();
        return this.append(charSequence, 0, n10);
    }

    public Appendable append(CharSequence charSequence, int n10, int n11) {
        charSequence = this.a(charSequence);
        int n12 = this.b;
        boolean bl2 = false;
        if (n12 != 0) {
            this.b = false;
            Appendable appendable = this.a;
            String string2 = d;
            appendable.append(string2);
        }
        if ((n12 = charSequence.length()) > 0) {
            int n13;
            n12 = n11 + -1;
            if ((n12 = (int)charSequence.charAt(n12)) == (n13 = 10)) {
                bl2 = true;
            }
        }
        this.b = bl2;
        this.a.append(charSequence, n10, n11);
        return this;
    }
}

