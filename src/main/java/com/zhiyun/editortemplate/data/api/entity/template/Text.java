/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.api.entity.template;

import com.zhiyun.editortemplate.data.api.entity.template.Caption;
import com.zhiyun.editortemplate.data.api.entity.template.FileDataBaseBean;

public class Text
extends FileDataBaseBean {
    private Caption caption;
    private float fontSize;
    public String name;
    private String text;
    private String textColor;

    public Caption getCaption() {
        return this.caption;
    }

    public float getFontSize() {
        return this.fontSize;
    }

    public String getName() {
        return this.name;
    }

    public String getText() {
        return this.text;
    }

    public String getTextColor() {
        return this.textColor;
    }

    public void setCaption(Caption caption) {
        this.caption = caption;
    }

    public void setFontSize(float f10) {
        this.fontSize = f10;
    }

    public void setName(String string2) {
        this.name = string2;
    }

    public void setText(String string2) {
        this.text = string2;
    }

    public void setTextColor(String string2) {
        this.textColor = string2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Text{fontSize=");
        float f10 = this.fontSize;
        stringBuilder.append(f10);
        stringBuilder.append(", name='");
        Object object = this.name;
        stringBuilder.append((String)object);
        char bl2 = '\'';
        stringBuilder.append(bl2);
        stringBuilder.append(", textColor='");
        String string2 = this.textColor;
        stringBuilder.append(string2);
        stringBuilder.append(bl2);
        stringBuilder.append(", text='");
        string2 = this.text;
        stringBuilder.append(string2);
        stringBuilder.append(bl2);
        stringBuilder.append(", caption=");
        object = this.caption;
        stringBuilder.append(object);
        stringBuilder.append(", isLocalSource=");
        boolean bl3 = this.isLocalSource;
        stringBuilder.append(bl3);
        stringBuilder.append(", file=");
        object = this.file;
        stringBuilder.append(object);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

