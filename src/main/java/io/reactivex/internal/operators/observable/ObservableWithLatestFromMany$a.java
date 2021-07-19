/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.v0.o;
import e.a.w0.b.a;
import io.reactivex.internal.operators.observable.ObservableWithLatestFromMany;

public final class ObservableWithLatestFromMany$a
implements o {
    public final /* synthetic */ ObservableWithLatestFromMany a;

    public ObservableWithLatestFromMany$a(ObservableWithLatestFromMany observableWithLatestFromMany) {
        this.a = observableWithLatestFromMany;
    }

    public Object apply(Object object) {
        o o10 = this.a.d;
        Object[] objectArray = new Object[]{object};
        return e.a.w0.b.a.g(o10.apply(objectArray), "The combiner returned a null value");
    }
}

