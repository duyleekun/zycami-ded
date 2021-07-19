/*
 * Decompiled with CFR 0.151.
 */
package com.chad.library.adapter.base.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.chad.library.adapter.base.entity.SectionEntity$Companion;

public interface SectionEntity
extends MultiItemEntity {
    public static final SectionEntity$Companion Companion = SectionEntity$Companion.$$INSTANCE;
    public static final int HEADER_TYPE = 157;
    public static final int NORMAL_TYPE = 156;

    public int getItemType();

    public boolean isHeader();
}

