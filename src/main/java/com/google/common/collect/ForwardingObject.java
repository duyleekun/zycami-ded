/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

public abstract class ForwardingObject {
    public abstract Object delegate();

    public String toString() {
        return this.delegate().toString();
    }
}

