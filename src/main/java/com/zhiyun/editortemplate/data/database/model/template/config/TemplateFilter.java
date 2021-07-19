/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.model.template.config;

import java.util.Objects;

public class TemplateFilter {
    private boolean enable;
    private boolean localSource;
    private String name;
    private float strength;

    public TemplateFilter(boolean bl2, String string2, boolean bl3, float f10) {
        this.enable = bl2;
        this.name = string2;
        this.localSource = bl3;
        this.strength = f10;
    }

    public TemplateFilter clone() {
        boolean bl2 = this.enable;
        String string2 = this.name;
        boolean bl3 = this.localSource;
        float f10 = this.strength;
        TemplateFilter templateFilter = new TemplateFilter(bl2, string2, bl3, f10);
        return templateFilter;
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
            float f10;
            float f11;
            object = (TemplateFilter)object;
            int n10 = this.enable;
            int n11 = ((TemplateFilter)object).enable;
            if (n10 != n11 || (n10 = this.localSource) != (n11 = ((TemplateFilter)object).localSource) || (n10 = Float.compare(f11 = ((TemplateFilter)object).strength, f10 = this.strength)) != 0 || !(bl3 = Objects.equals(object2 = this.name, object = ((TemplateFilter)object).name))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public String getName() {
        return this.name;
    }

    public float getStrength() {
        return this.strength;
    }

    public int hashCode() {
        Object object = this.enable;
        Object[] objectArray = new Object[]{object, object = this.name, object = Boolean.valueOf(this.localSource), object = Float.valueOf(this.strength)};
        return Objects.hash(objectArray);
    }

    public boolean isEnable() {
        return this.enable;
    }

    public boolean isLocalSource() {
        return this.localSource;
    }

    public void setEnable(boolean bl2) {
        this.enable = bl2;
    }

    public void setLocalSource(boolean bl2) {
        this.localSource = bl2;
    }

    public void setName(String string2) {
        this.name = string2;
    }

    public void setStrength(float f10) {
        this.strength = f10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TemplateFilter{enable=");
        boolean bl2 = this.enable;
        stringBuilder.append(bl2);
        stringBuilder.append(", name='");
        String string2 = this.name;
        stringBuilder.append(string2);
        stringBuilder.append('\'');
        stringBuilder.append(", localSource=");
        bl2 = this.localSource;
        stringBuilder.append(bl2);
        stringBuilder.append(", strength=");
        float f10 = this.strength;
        stringBuilder.append(f10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

