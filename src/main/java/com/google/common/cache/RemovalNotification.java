/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.base.Preconditions;
import com.google.common.cache.RemovalCause;
import java.util.AbstractMap;

public final class RemovalNotification
extends AbstractMap.SimpleImmutableEntry {
    private static final long serialVersionUID;
    private final RemovalCause cause;

    private RemovalNotification(Object object, Object object2, RemovalCause removalCause) {
        super(object, object2);
        object = (RemovalCause)((Object)Preconditions.checkNotNull((Object)removalCause));
        this.cause = object;
    }

    public static RemovalNotification create(Object object, Object object2, RemovalCause removalCause) {
        RemovalNotification removalNotification = new RemovalNotification(object, object2, removalCause);
        return removalNotification;
    }

    public RemovalCause getCause() {
        return this.cause;
    }

    public boolean wasEvicted() {
        return this.cause.wasEvicted();
    }
}

