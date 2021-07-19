/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.api.entity.template;

public class Render {
    private int displayType;
    private String renderSize;

    public Render(String string2) {
        this.renderSize = string2;
    }

    public int getDisplayType() {
        return this.displayType;
    }

    public String getRenderSize() {
        return this.renderSize;
    }

    public void setDisplayType(int n10) {
        this.displayType = n10;
    }

    public void setRenderSize(String string2) {
        this.renderSize = string2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Render{renderSize='");
        String string2 = this.renderSize;
        stringBuilder.append(string2);
        stringBuilder.append('\'');
        stringBuilder.append(", displayType=");
        int n10 = this.displayType;
        stringBuilder.append(n10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

