/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicReference;

public final class ObservableReplay$Node
extends AtomicReference {
    private static final long serialVersionUID = 245354315435971818L;
    public final Object value;

    public ObservableReplay$Node(Object object) {
        this.value = object;
    }
}

