/*
 * Decompiled with CFR 0.151.
 */
package com.chad.library.adapter.base.entity;

import com.chad.library.adapter.base.entity.SectionEntity;

public abstract class JSectionEntity
implements SectionEntity {
    public int getItemType() {
        boolean bl2 = this.isHeader();
        if (bl2) {
            return -99;
        }
        return -100;
    }
}

