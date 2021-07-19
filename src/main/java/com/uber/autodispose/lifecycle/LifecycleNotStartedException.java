/*
 * Decompiled with CFR 0.151.
 */
package com.uber.autodispose.lifecycle;

import com.uber.autodispose.OutsideScopeException;

public class LifecycleNotStartedException
extends OutsideScopeException {
    public LifecycleNotStartedException() {
        this("Lifecycle hasn't started!");
    }

    public LifecycleNotStartedException(String string2) {
        super(string2);
    }
}

