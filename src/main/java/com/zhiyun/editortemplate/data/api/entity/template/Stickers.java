/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.api.entity.template;

import com.zhiyun.editortemplate.data.api.entity.template.Gif;
import com.zhiyun.editortemplate.data.api.entity.template.Image;
import com.zhiyun.editortemplate.data.api.entity.template.Text;

public class Stickers {
    private float angle;
    private String center;
    private long endTime;
    private Gif gif;
    private Image image;
    private float scale;
    private long startTime;
    private Text text;
    private String type;

    public Stickers(long l10, long l11, float f10, String string2, String string3, float f11, Text text, Image image, Gif gif) {
        this.startTime = l10;
        this.endTime = l11;
        this.angle = f10;
        this.center = string2;
        this.type = string3;
        this.scale = f11;
        this.text = text;
        this.image = image;
        this.gif = gif;
    }

    public float getAngle() {
        return this.angle;
    }

    public String getCenter() {
        return this.center;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public Gif getGif() {
        return this.gif;
    }

    public Image getImage() {
        return this.image;
    }

    public float getScale() {
        return this.scale;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public Text getText() {
        return this.text;
    }

    public String getType() {
        return this.type;
    }

    public void setAngle(float f10) {
        this.angle = f10;
    }

    public void setCenter(String string2) {
        this.center = string2;
    }

    public void setEndTime(long l10) {
        this.endTime = l10;
    }

    public void setGif(Gif gif) {
        this.gif = gif;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setScale(float f10) {
        this.scale = f10;
    }

    public void setStartTime(long l10) {
        this.startTime = l10;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public void setType(String string2) {
        this.type = string2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Stickers{startTime=");
        long l10 = this.startTime;
        stringBuilder.append(l10);
        stringBuilder.append(", endTime=");
        l10 = this.endTime;
        stringBuilder.append(l10);
        stringBuilder.append(", angle=");
        float f10 = this.angle;
        stringBuilder.append(f10);
        stringBuilder.append(", center='");
        Object object = this.center;
        stringBuilder.append((String)object);
        char c10 = '\'';
        stringBuilder.append(c10);
        stringBuilder.append(", type='");
        String string2 = this.type;
        stringBuilder.append(string2);
        stringBuilder.append(c10);
        stringBuilder.append(", scale=");
        f10 = this.scale;
        stringBuilder.append(f10);
        stringBuilder.append(", text=");
        object = this.text;
        stringBuilder.append(object);
        stringBuilder.append(", image=");
        object = this.image;
        stringBuilder.append(object);
        stringBuilder.append(", gif=");
        object = this.gif;
        stringBuilder.append(object);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

