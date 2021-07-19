/*
 * Decompiled with CFR 0.151.
 */
package f.q2;

import f.h2.s.p;
import f.h2.t.f0;
import f.n2.m;
import f.q2.f$a;
import java.util.Iterator;

public final class f
implements m {
    private final CharSequence a;
    private final int b;
    private final int c;
    private final p d;

    public f(CharSequence charSequence, int n10, int n11, p p10) {
        f0.p(charSequence, "input");
        f0.p(p10, "getNextMatch");
        this.a = charSequence;
        this.b = n10;
        this.c = n11;
        this.d = p10;
    }

    public static final /* synthetic */ p c(f f10) {
        return f10.d;
    }

    public static final /* synthetic */ CharSequence d(f f10) {
        return f10.a;
    }

    public static final /* synthetic */ int e(f f10) {
        return f10.c;
    }

    public static final /* synthetic */ int f(f f10) {
        return f10.b;
    }

    public Iterator iterator() {
        f$a f$a = new f$a(this);
        return f$a;
    }
}

