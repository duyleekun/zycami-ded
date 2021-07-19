/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.model.template.templatelist;

import java.util.Objects;

public class TemplateFileRelation {
    private String fileHash;
    private long tempId;

    public TemplateFileRelation(long l10, String string2) {
        this.tempId = l10;
        this.fileHash = string2;
    }

    public boolean equals(Object object) {
        Class<?> clazz;
        Object object2;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object2 = this.getClass()) == (clazz = object.getClass())) {
            boolean bl3;
            object = (TemplateFileRelation)object;
            long l10 = this.tempId;
            long l11 = ((TemplateFileRelation)object).tempId;
            long l12 = l10 - l11;
            Object object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object3 != false || !(bl3 = Objects.equals(object2 = this.fileHash, object = ((TemplateFileRelation)object).fileHash))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public String getFileHash() {
        return this.fileHash;
    }

    public long getTempId() {
        return this.tempId;
    }

    public int hashCode() {
        Object object = this.tempId;
        Object[] objectArray = new Object[]{object, object = this.fileHash};
        return Objects.hash(objectArray);
    }

    public void setFileHash(String string2) {
        this.fileHash = string2;
    }

    public void setTempId(long l10) {
        this.tempId = l10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TemplateFileRelation{tempId=");
        long l10 = this.tempId;
        stringBuilder.append(l10);
        stringBuilder.append(", fileHash='");
        String string2 = this.fileHash;
        stringBuilder.append(string2);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

