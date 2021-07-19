/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.base.Preconditions;

public abstract class DirectedGraphConnections$NodeConnection {
    public final Object node;

    public DirectedGraphConnections$NodeConnection(Object object) {
        this.node = object = Preconditions.checkNotNull(object);
    }
}

