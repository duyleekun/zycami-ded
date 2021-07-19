/*
 * Decompiled with CFR 0.151.
 */
package k.x.a;

import java.util.Objects;
import k.r;

public final class d {
    private final r a;
    private final Throwable b;

    private d(r r10, Throwable throwable) {
        this.a = r10;
        this.b = throwable;
    }

    public static d b(Throwable throwable) {
        Objects.requireNonNull(throwable, "error == null");
        d d10 = new d(null, throwable);
        return d10;
    }

    public static d e(r r10) {
        Objects.requireNonNull(r10, "response == null");
        d d10 = new d(r10, null);
        return d10;
    }

    public Throwable a() {
        return this.b;
    }

    public boolean c() {
        boolean bl2;
        Throwable throwable = this.b;
        if (throwable != null) {
            bl2 = true;
        } else {
            bl2 = false;
            throwable = null;
        }
        return bl2;
    }

    public r d() {
        return this.a;
    }
}

