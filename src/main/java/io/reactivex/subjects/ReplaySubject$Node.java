/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.subjects;

import java.util.concurrent.atomic.AtomicReference;

public final class ReplaySubject$Node
extends AtomicReference {
    private static final long serialVersionUID = 6404226426336033100L;
    public final Object value;

    public ReplaySubject$Node(Object object) {
        this.value = object;
    }
}

