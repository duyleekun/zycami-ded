/*
 * Decompiled with CFR 0.151.
 */
package com.chad.library.adapter.base.entity.node;

import com.chad.library.adapter.base.entity.node.BaseNode;

public abstract class BaseExpandNode
extends BaseNode {
    private boolean isExpanded = true;

    public final boolean isExpanded() {
        return this.isExpanded;
    }

    public final void setExpanded(boolean bl2) {
        this.isExpanded = bl2;
    }
}

