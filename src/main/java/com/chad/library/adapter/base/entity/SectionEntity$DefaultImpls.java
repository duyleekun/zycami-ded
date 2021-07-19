/*
 * Decompiled with CFR 0.151.
 */
package com.chad.library.adapter.base.entity;

import com.chad.library.adapter.base.entity.SectionEntity;

public final class SectionEntity$DefaultImpls {
    public static int getItemType(SectionEntity sectionEntity) {
        int n10 = sectionEntity.isHeader();
        n10 = n10 != 0 ? -99 : -100;
        return n10;
    }
}

