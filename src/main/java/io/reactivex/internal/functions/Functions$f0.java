/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.functions;

import e.a.a1.a;
import e.a.v0.g;
import io.reactivex.exceptions.OnErrorNotImplementedException;

public final class Functions$f0
implements g {
    public void a(Throwable throwable) {
        OnErrorNotImplementedException onErrorNotImplementedException = new OnErrorNotImplementedException(throwable);
        a.Y(onErrorNotImplementedException);
    }
}

