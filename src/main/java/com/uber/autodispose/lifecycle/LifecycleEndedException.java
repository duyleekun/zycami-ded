/*
 * Decompiled with CFR 0.151.
 */
package com.uber.autodispose.lifecycle;

import com.uber.autodispose.OutsideScopeException;

public class LifecycleEndedException
extends OutsideScopeException {
    public LifecycleEndedException() {
        this("Lifecycle has ended!");
    }

    public LifecycleEndedException(String string2) {
        super(string2);
    }
}

