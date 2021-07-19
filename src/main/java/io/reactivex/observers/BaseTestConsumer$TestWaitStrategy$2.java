/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.observers;

import io.reactivex.observers.BaseTestConsumer$TestWaitStrategy;

public final class BaseTestConsumer$TestWaitStrategy$2
extends BaseTestConsumer$TestWaitStrategy {
    public void run() {
        Thread.yield();
    }
}

