/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.api.entity.template;

import com.zhiyun.editortemplate.data.api.entity.template.FileDataBaseBean;

public class Filter
extends FileDataBaseBean {
    private boolean enable;
    private float strength;

    public float getStrength() {
        return this.strength;
    }

    public boolean isEnable() {
        return this.enable;
    }

    public void setEnable(boolean bl2) {
        this.enable = bl2;
    }

    public void setStrength(float f10) {
        this.strength = f10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Filter{enable=");
        boolean bl2 = this.enable;
        stringBuilder.append(bl2);
        stringBuilder.append(", strength=");
        float f10 = this.strength;
        stringBuilder.append(f10);
        stringBuilder.append(", name='");
        Object object = this.name;
        stringBuilder.append((String)object);
        stringBuilder.append('\'');
        stringBuilder.append(", isLocalSource=");
        bl2 = this.isLocalSource;
        stringBuilder.append(bl2);
        stringBuilder.append(", file=");
        object = this.file;
        stringBuilder.append(object);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

