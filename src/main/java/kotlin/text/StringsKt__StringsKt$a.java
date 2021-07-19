/*
 * Decompiled with CFR 0.151.
 */
package kotlin.text;

import f.x1.r;

public final class StringsKt__StringsKt$a
extends r {
    private int a;
    public final /* synthetic */ CharSequence b;

    public StringsKt__StringsKt$a(CharSequence charSequence) {
        this.b = charSequence;
    }

    public char c() {
        int n10;
        CharSequence charSequence = this.b;
        int n11 = this.a;
        this.a = n10 = n11 + 1;
        return charSequence.charAt(n11);
    }

    public boolean hasNext() {
        int n10 = this.a;
        CharSequence charSequence = this.b;
        int n11 = charSequence.length();
        n10 = n10 < n11 ? 1 : 0;
        return n10 != 0;
    }
}

