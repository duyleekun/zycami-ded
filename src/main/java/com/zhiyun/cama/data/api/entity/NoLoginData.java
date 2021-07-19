/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.api.entity;

import com.zhiyun.net.BaseEntity;

public class NoLoginData
extends BaseEntity {
    private int activeVisitor;

    public int getActiveVisitor() {
        return this.activeVisitor;
    }

    public void setActiveVisitor(int n10) {
        this.activeVisitor = n10;
    }
}

