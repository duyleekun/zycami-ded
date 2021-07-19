/*
 * Decompiled with CFR 0.151.
 */
package com.jakewharton.rxrelay2;

import java.util.concurrent.atomic.AtomicReference;

public final class ReplayRelay$TimedNode
extends AtomicReference {
    private static final long serialVersionUID = 6404226426336033100L;
    public final long time;
    public final Object value;

    public ReplayRelay$TimedNode(Object object, long l10) {
        this.value = object;
        this.time = l10;
    }
}

