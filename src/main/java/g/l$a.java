/*
 * Decompiled with CFR 0.151.
 */
package g;

import f.h2.t.f0;
import f.q2.u;
import g.h0.a;
import g.l;
import java.util.Objects;
import kotlin.text.StringsKt__StringsKt;

public final class l$a {
    private String a;
    private String b;
    private long c = 253402300799999L;
    private String d;
    private String e = "/";
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;

    private final l$a c(String string2, boolean bl2) {
        CharSequence charSequence = g.h0.a.e(string2);
        if (charSequence != null) {
            this.d = charSequence;
            this.i = bl2;
            return this;
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("unexpected domain: ");
        ((StringBuilder)charSequence).append(string2);
        string2 = ((StringBuilder)charSequence).toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public final l a() {
        String string2 = this.a;
        Objects.requireNonNull(string2, "builder.name == null");
        String string3 = this.b;
        Objects.requireNonNull(string3, "builder.value == null");
        long l10 = this.c;
        String string4 = this.d;
        Objects.requireNonNull(string4, "builder.domain == null");
        String string5 = this.e;
        boolean bl2 = this.f;
        boolean bl3 = this.g;
        boolean bl4 = this.h;
        boolean bl5 = this.i;
        l l11 = new l(string2, string3, l10, string4, string5, bl2, bl3, bl4, bl5, null);
        return l11;
    }

    public final l$a b(String string2) {
        f0.p(string2, "domain");
        return this.c(string2, false);
    }

    public final l$a d(long l10) {
        long l11;
        long l12;
        long l13 = 0L;
        long l14 = l10 - l13;
        Object object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object <= 0) {
            l10 = Long.MIN_VALUE;
        }
        if ((l12 = (l11 = l10 - (l13 = 253402300799999L)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) > 0) {
            l10 = l13;
        }
        this.c = l10;
        this.h = true;
        return this;
    }

    public final l$a e(String string2) {
        f0.p(string2, "domain");
        return this.c(string2, true);
    }

    public final l$a f() {
        this.g = true;
        return this;
    }

    public final l$a g(String object) {
        f0.p(object, "name");
        String string2 = ((Object)StringsKt__StringsKt.p5((CharSequence)object)).toString();
        boolean bl2 = f0.g(string2, object);
        if (bl2) {
            this.a = object;
            return this;
        }
        string2 = "name is not trimmed".toString();
        object = new IllegalArgumentException(string2);
        throw object;
    }

    public final l$a h(String object) {
        f0.p(object, "path");
        String string2 = "/";
        int n10 = 2;
        boolean bl2 = u.q2((String)object, string2, false, n10, null);
        if (bl2) {
            this.e = object;
            return this;
        }
        string2 = "path must start with '/'".toString();
        object = new IllegalArgumentException(string2);
        throw object;
    }

    public final l$a i() {
        this.f = true;
        return this;
    }

    public final l$a j(String object) {
        f0.p(object, "value");
        String string2 = ((Object)StringsKt__StringsKt.p5((CharSequence)object)).toString();
        boolean bl2 = f0.g(string2, object);
        if (bl2) {
            this.b = object;
            return this;
        }
        string2 = "value is not trimmed".toString();
        object = new IllegalArgumentException(string2);
        throw object;
    }
}

