/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.model.template.config;

import java.util.Objects;

public class TemplateRotate {
    private boolean enable;
    private int rotate;

    public TemplateRotate(boolean bl2, int n10) {
        this.enable = bl2;
        this.rotate = n10;
    }

    public TemplateRotate clone() {
        boolean bl2 = this.enable;
        int n10 = this.rotate;
        TemplateRotate templateRotate = new TemplateRotate(bl2, n10);
        return templateRotate;
    }

    public boolean equals(Object object) {
        Class<?> clazz;
        Class<?> clazz2;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (clazz2 = this.getClass()) == (clazz = object.getClass())) {
            int n10;
            object = (TemplateRotate)object;
            int n11 = this.enable;
            int n12 = ((TemplateRotate)object).enable;
            if (n11 != n12 || (n11 = this.rotate) != (n10 = ((TemplateRotate)object).rotate)) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int getRotate() {
        return this.rotate;
    }

    public int hashCode() {
        Object[] objectArray = new Object[2];
        Comparable<Boolean> comparable = this.enable;
        objectArray[0] = comparable;
        comparable = this.rotate;
        objectArray[1] = comparable;
        return Objects.hash(objectArray);
    }

    public boolean isEnable() {
        return this.enable;
    }

    public void setEnable(boolean bl2) {
        this.enable = bl2;
    }

    public void setRotate(int n10) {
        this.rotate = n10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TemplateRotate{enable=");
        int n10 = this.enable;
        stringBuilder.append(n10 != 0);
        stringBuilder.append(", rotate=");
        n10 = this.rotate;
        stringBuilder.append(n10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

