/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.api.entity.template;

import java.util.Objects;

public class Description {
    private String en;
    private String zh;
    private String zh_tw;

    public Description(String string2, String string3, String string4) {
        this.zh = string2;
        this.en = string3;
        this.zh_tw = string4;
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
            object = (Description)object;
            object3 = this.zh;
            object2 = ((Description)object).zh;
            boolean bl4 = Objects.equals(object3, object2);
            if (!(bl4 && (bl4 = Objects.equals(object3 = this.en, object2 = ((Description)object).en)) && (bl3 = Objects.equals(object3 = this.zh_tw, object = ((Description)object).zh_tw)))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public String getEn() {
        return this.en;
    }

    public String getZh() {
        return this.zh;
    }

    public String getZh_tw() {
        return this.zh_tw;
    }

    public int hashCode() {
        Object[] objectArray = new Object[3];
        String string2 = this.zh;
        objectArray[0] = string2;
        string2 = this.en;
        objectArray[1] = string2;
        string2 = this.zh_tw;
        objectArray[2] = string2;
        return Objects.hash(objectArray);
    }

    public void setEn(String string2) {
        this.en = string2;
    }

    public void setZh(String string2) {
        this.zh = string2;
    }

    public void setZh_tw(String string2) {
        this.zh_tw = string2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Description{zh='");
        String string2 = this.zh;
        stringBuilder.append(string2);
        char c10 = '\'';
        stringBuilder.append(c10);
        stringBuilder.append(", en='");
        String string3 = this.en;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        stringBuilder.append(", zh_tw='");
        string3 = this.zh_tw;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

