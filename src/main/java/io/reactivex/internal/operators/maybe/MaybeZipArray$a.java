/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.v0.o;
import e.a.w0.b.a;
import io.reactivex.internal.operators.maybe.MaybeZipArray;

public final class MaybeZipArray$a
implements o {
    public final /* synthetic */ MaybeZipArray a;

    public MaybeZipArray$a(MaybeZipArray maybeZipArray) {
        this.a = maybeZipArray;
    }

    public Object apply(Object object) {
        o o10 = this.a.b;
        Object[] objectArray = new Object[]{object};
        return e.a.w0.b.a.g(o10.apply(objectArray), "The zipper returned a null value");
    }
}

