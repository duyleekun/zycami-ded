/*
 * Decompiled with CFR 0.151.
 */
package com.uber.autodispose;

import d.q.a.n;

public class OutsideScopeException
extends RuntimeException {
    public OutsideScopeException(String string2) {
        super(string2);
    }

    public final Throwable fillInStackTrace() {
        synchronized (this) {
            block5: {
                boolean bl2 = n.b;
                if (!bl2) break block5;
                Throwable throwable = super.fillInStackTrace();
                return throwable;
            }
            return this;
            finally {
            }
        }
    }
}

