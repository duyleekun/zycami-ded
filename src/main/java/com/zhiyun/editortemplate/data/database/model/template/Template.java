/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.model.template;

import java.util.Objects;

public class Template {
    private long id;
    private boolean isEmpty = false;
    private long referenceId;
    private long tempId;
    private long typeId;

    public Template clone() {
        Template template = new Template();
        return template;
    }

    public boolean equals(Object object) {
        Class<?> clazz;
        Class<?> clazz2;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (clazz2 = this.getClass()) == (clazz = object.getClass())) {
            long l10;
            long l11;
            object = (Template)object;
            long l12 = this.id;
            long l13 = ((Template)object).id;
            long l14 = l12 - l13;
            Object object2 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object2 != false || (l11 = (l10 = (l12 = this.tempId) - (l13 = ((Template)object).tempId)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public long getId() {
        return this.id;
    }

    public long getReferenceId() {
        return this.referenceId;
    }

    public long getTempId() {
        return this.tempId;
    }

    public long getTypeId() {
        return this.typeId;
    }

    public int hashCode() {
        Object[] objectArray = new Object[2];
        Long l10 = this.id;
        objectArray[0] = l10;
        l10 = this.tempId;
        objectArray[1] = l10;
        return Objects.hash(objectArray);
    }

    public boolean isEmpty() {
        return this.isEmpty;
    }

    public void setEmpty(boolean bl2) {
        this.isEmpty = bl2;
    }

    public void setId(long l10) {
        this.id = l10;
    }

    public void setReferenceId(long l10) {
        this.referenceId = l10;
    }

    public void setTempId(long l10) {
        this.tempId = l10;
    }

    public void setTypeId(long l10) {
        this.typeId = l10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Template{id=");
        long l10 = this.id;
        stringBuilder.append(l10);
        stringBuilder.append(", tempId=");
        l10 = this.tempId;
        stringBuilder.append(l10);
        stringBuilder.append(", typeId=");
        l10 = this.typeId;
        stringBuilder.append(l10);
        stringBuilder.append(", referenceId=");
        l10 = this.referenceId;
        stringBuilder.append(l10);
        stringBuilder.append(", isEmpty=");
        boolean bl2 = this.isEmpty;
        stringBuilder.append(bl2);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

