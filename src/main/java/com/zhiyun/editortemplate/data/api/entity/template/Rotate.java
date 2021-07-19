/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.api.entity.template;

public class Rotate {
    private boolean enable;
    private int rotate;

    public Rotate(boolean bl2, int n10) {
        this.enable = bl2;
        this.rotate = n10;
    }

    public int getRotate() {
        return this.rotate;
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
        stringBuilder.append("Rotate{enable=");
        int n10 = this.enable;
        stringBuilder.append(n10 != 0);
        stringBuilder.append(", rotate=");
        n10 = this.rotate;
        stringBuilder.append(n10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

