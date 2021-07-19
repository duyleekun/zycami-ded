/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.api.entity.template;

public class RotateFrame {
    private String center;
    private int rotate;
    private String scale;

    public RotateFrame(String string2, String string3, int n10) {
        this.center = string2;
        this.scale = string3;
        this.rotate = n10;
    }

    public String getCenter() {
        return this.center;
    }

    public int getRotate() {
        return this.rotate;
    }

    public String getScale() {
        return this.scale;
    }

    public void setCenter(String string2) {
        this.center = string2;
    }

    public void setRotate(int n10) {
        this.rotate = n10;
    }

    public void setScale(String string2) {
        this.scale = string2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RotateFrame{center='");
        String string2 = this.center;
        stringBuilder.append(string2);
        int n10 = 39;
        stringBuilder.append((char)n10);
        stringBuilder.append(", scale='");
        String string3 = this.scale;
        stringBuilder.append(string3);
        stringBuilder.append((char)n10);
        stringBuilder.append(", rotate=");
        n10 = this.rotate;
        stringBuilder.append(n10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

