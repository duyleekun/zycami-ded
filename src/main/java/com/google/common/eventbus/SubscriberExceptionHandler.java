/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.eventbus;

import com.google.common.eventbus.SubscriberExceptionContext;

public interface SubscriberExceptionHandler {
    public void handleException(Throwable var1, SubscriberExceptionContext var2);
}

