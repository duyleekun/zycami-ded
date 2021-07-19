/*
 * Decompiled with CFR 0.151.
 */
package kotlin;

import f.h2.t.f0;
import f.h2.t.u;

public final class NotImplementedError
extends Error {
    public NotImplementedError() {
        this(null, 1, null);
    }

    public NotImplementedError(String string2) {
        f0.p(string2, "message");
        super(string2);
    }

    public /* synthetic */ NotImplementedError(String string2, int n10, u u10) {
        if ((n10 &= 1) != 0) {
            string2 = "An operation is not implemented.";
        }
        this(string2);
    }
}

