/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.model.draft;

import java.lang.constant.Constable;
import java.util.Objects;

public class Withdraw {
    private long backId;
    public long createTime;
    private long id;

    public Withdraw() {
    }

    public Withdraw(long l10, long l11) {
        this.backId = l10;
        this.createTime = l11;
    }

    public Withdraw clone() {
        Withdraw withdraw = new Withdraw();
        long l10 = System.currentTimeMillis();
        withdraw.setCreateTime(l10);
        return withdraw;
    }

    public boolean equals(Object object) {
        Class<?> clazz;
        Constable constable;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (constable = this.getClass()) == (clazz = object.getClass())) {
            long l10;
            boolean bl3;
            long l11;
            object = (Withdraw)object;
            long l12 = this.id;
            long l13 = ((Withdraw)object).id;
            long l14 = l12 - l13;
            Object object2 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object2 != false || (object2 = (l11 = (l12 = this.backId) - (l13 = ((Withdraw)object).backId)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != false || !(bl3 = Objects.equals(constable = Long.valueOf(l12 = this.createTime), object = Long.valueOf(l10 = ((Withdraw)object).createTime)))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public long getBackId() {
        return this.backId;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public long getId() {
        return this.id;
    }

    public int hashCode() {
        Object[] objectArray = new Object[3];
        Long l10 = this.id;
        objectArray[0] = l10;
        l10 = this.backId;
        objectArray[1] = l10;
        l10 = this.createTime;
        objectArray[2] = l10;
        return Objects.hash(objectArray);
    }

    public void setBackId(long l10) {
        this.backId = l10;
    }

    public void setCreateTime(long l10) {
        this.createTime = l10;
    }

    public void setId(long l10) {
        this.id = l10;
    }
}

