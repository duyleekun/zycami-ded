/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.model.template.config;

import java.util.Objects;

public class TemplateRotateFrame {
    private String center;
    private int rotate;
    private String scale;

    public TemplateRotateFrame(String string2, String string3, int n10) {
        this.center = string2;
        this.scale = string3;
        this.rotate = n10;
    }

    public TemplateRotateFrame clone() {
        String string2 = this.center;
        String string3 = this.scale;
        int n10 = this.rotate;
        TemplateRotateFrame templateRotateFrame = new TemplateRotateFrame(string2, string3, n10);
        return templateRotateFrame;
    }

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object3 = this.getClass()) == (object2 = object.getClass())) {
            boolean bl3;
            object = (TemplateRotateFrame)object;
            int n10 = this.rotate;
            int n11 = ((TemplateRotateFrame)object).rotate;
            if (n10 != n11 || (n10 = (int)(Objects.equals(object3 = this.center, object2 = ((TemplateRotateFrame)object).center) ? 1 : 0)) == 0 || !(bl3 = Objects.equals(object3 = this.scale, object = ((TemplateRotateFrame)object).scale))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
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

    public int hashCode() {
        Object object = this.center;
        object = this.scale;
        object = this.rotate;
        Object[] objectArray = new Object[]{object, object, object};
        return Objects.hash(objectArray);
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

