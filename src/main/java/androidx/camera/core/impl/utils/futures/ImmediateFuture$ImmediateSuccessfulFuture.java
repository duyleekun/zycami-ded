/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl.utils.futures;

import androidx.camera.core.impl.utils.futures.ImmediateFuture;

public final class ImmediateFuture$ImmediateSuccessfulFuture
extends ImmediateFuture {
    public static final ImmediateFuture NULL_FUTURE;
    private final Object mValue;

    static {
        ImmediateFuture$ImmediateSuccessfulFuture immediateFuture$ImmediateSuccessfulFuture = new ImmediateFuture$ImmediateSuccessfulFuture(null);
        NULL_FUTURE = immediateFuture$ImmediateSuccessfulFuture;
    }

    public ImmediateFuture$ImmediateSuccessfulFuture(Object object) {
        this.mValue = object;
    }

    public Object get() {
        return this.mValue;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Object object = super.toString();
        stringBuilder.append((String)object);
        stringBuilder.append("[status=SUCCESS, result=[");
        object = this.mValue;
        stringBuilder.append(object);
        stringBuilder.append("]]");
        return stringBuilder.toString();
    }
}

