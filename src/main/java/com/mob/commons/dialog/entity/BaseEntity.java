/*
 * Decompiled with CFR 0.151.
 */
package com.mob.commons.dialog.entity;

import com.mob.tools.proguard.EverythingKeeper;
import com.mob.tools.utils.Hashon;
import java.io.Serializable;

public class BaseEntity
implements EverythingKeeper,
Serializable {
    public String toJSONString() {
        Hashon hashon = new Hashon();
        return hashon.fromObject(this);
    }
}

