/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.api.entity;

import com.zhiyun.net.BaseEntity;
import java.util.Objects;

public class LastTemplateId
extends BaseEntity {
    private int lastId;

    public LastTemplateId(int n10) {
        this.lastId = n10;
    }

    public boolean equals(Object object) {
        Class<?> clazz;
        Class<?> clazz2;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (clazz2 = this.getClass()) == (clazz = object.getClass())) {
            object = (LastTemplateId)object;
            int n10 = this.lastId;
            int n11 = ((LastTemplateId)object).lastId;
            if (n10 != n11) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int getLastId() {
        return this.lastId;
    }

    public int hashCode() {
        Object[] objectArray = new Object[1];
        Integer n10 = this.lastId;
        objectArray[0] = n10;
        return Objects.hash(objectArray);
    }

    public void setLastId(int n10) {
        this.lastId = n10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LastTemplateId{lastId=");
        int n10 = this.lastId;
        stringBuilder.append(n10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

