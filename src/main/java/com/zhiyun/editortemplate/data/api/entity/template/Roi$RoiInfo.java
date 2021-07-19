/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.api.entity.template;

public class Roi$RoiInfo {
    private String center;
    private float height;
    private float width;

    public Roi$RoiInfo(String string2, float f10, float f11) {
        this.center = string2;
        this.width = f10;
        this.height = f11;
    }

    public String getCenter() {
        return this.center;
    }

    public float getHeight() {
        return this.height;
    }

    public float getWidth() {
        return this.width;
    }

    public void setCenter(String string2) {
        this.center = string2;
    }

    public void setHeight(float f10) {
        this.height = f10;
    }

    public void setWidth(float f10) {
        this.width = f10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RoiInfo{center='");
        String string2 = this.center;
        stringBuilder.append(string2);
        stringBuilder.append('\'');
        stringBuilder.append(", width=");
        float f10 = this.width;
        stringBuilder.append(f10);
        stringBuilder.append(", height=");
        f10 = this.height;
        stringBuilder.append(f10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

