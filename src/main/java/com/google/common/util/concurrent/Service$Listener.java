/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.Service$State;

public abstract class Service$Listener {
    public void failed(Service$State service$State, Throwable throwable) {
    }

    public void running() {
    }

    public void starting() {
    }

    public void stopping(Service$State service$State) {
    }

    public void terminated(Service$State service$State) {
    }
}

