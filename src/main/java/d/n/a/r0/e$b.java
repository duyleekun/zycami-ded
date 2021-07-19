/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.r0;

import d.n.a.q0.v.f$a;
import d.n.a.r0.e;

public final class e$b
implements f$a {
    private int a = 0;
    private int b;
    private long c;
    private int d;
    private int e;
    private boolean f;

    public e$b() {
        int n10;
        this.b = n10 = 1;
        this.c = 0L;
        this.d = n10;
        this.e = 3;
        this.f = n10;
    }

    private static boolean c(int n10) {
        int n11;
        int n12 = 1;
        if (n10 != n12 && n10 != (n11 = 2) && n10 != (n11 = 4) && n10 != (n11 = 6)) {
            n12 = 0;
        }
        return n12 != 0;
    }

    public e b() {
        int n10 = this.a;
        int n11 = this.b;
        long l10 = this.c;
        int n12 = this.d;
        int n13 = this.e;
        boolean bl2 = this.f;
        e e10 = new e(n10, n11, l10, n12, n13, bl2);
        return e10;
    }

    public e$b d(int n10) {
        boolean bl2 = e$b.c(n10);
        if (bl2) {
            this.b = n10;
            return this;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("invalid callback type - ");
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public e$b e(int n10) {
        int n11 = -1;
        if (n10 >= n11 && n10 <= (n11 = 2)) {
            this.a = n10;
            return this;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("invalid scan mode ");
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public e$b f(boolean bl2) {
        this.f = bl2;
        return this;
    }
}

