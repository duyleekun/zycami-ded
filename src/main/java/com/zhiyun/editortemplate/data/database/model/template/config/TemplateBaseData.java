/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.model.template.config;

import java.util.Objects;

public class TemplateBaseData {
    private String customerUUID;

    public boolean equals(Object object) {
        Class<?> clazz;
        Object object2;
        if (this == object) {
            return true;
        }
        if (object != null && (object2 = this.getClass()) == (clazz = object.getClass())) {
            object = (TemplateBaseData)object;
            object2 = this.customerUUID;
            object = ((TemplateBaseData)object).customerUUID;
            return Objects.equals(object2, object);
        }
        return false;
    }

    public String getCustomerUUID() {
        return this.customerUUID;
    }

    public int hashCode() {
        Object[] objectArray = new Object[1];
        String string2 = this.customerUUID;
        objectArray[0] = string2;
        return Objects.hash(objectArray);
    }

    public void setCustomerUUID(String string2) {
        this.customerUUID = string2;
    }
}

