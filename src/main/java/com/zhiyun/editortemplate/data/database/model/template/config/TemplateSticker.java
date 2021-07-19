/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.model.template.config;

import com.zhiyun.editortemplate.data.database.model.template.config.TemplateBaseData;
import java.util.Objects;

public class TemplateSticker
extends TemplateBaseData {
    private float angle;
    private String center;
    private long endTime;
    private String gifName;
    private long id;
    private String imageName;
    private boolean localSource;
    private float scale;
    private long startTime;
    private long stickerTypeId;
    private long tempId;
    public boolean textCaptionLocalSource;
    public String textCaptionName;
    private String textColor;
    private String textContent;
    private String textFontName;
    private float textFontSize;
    private String thumbUrl;
    private String type;

    public TemplateSticker() {
    }

    public TemplateSticker(long l10, long l11, float f10, String string2, String string3, long l12, float f11, float f12, String string4, String string5, String string6, String string7, boolean bl2, String string8, String string9, String string10, boolean bl3) {
        this.startTime = l10;
        this.endTime = l11;
        this.angle = f10;
        this.center = string2;
        this.type = string3;
        this.stickerTypeId = l12;
        this.scale = f11;
        this.textFontSize = f12;
        this.textFontName = string4;
        this.textColor = string5;
        this.textContent = string6;
        this.textCaptionName = string7;
        this.textCaptionLocalSource = bl2;
        this.imageName = string8;
        this.gifName = string9;
        this.thumbUrl = string10;
        this.localSource = bl3;
    }

    public TemplateSticker(long l10, long l11, long l12, long l13, float f10, String string2, String string3, int n10, float f11, float f12, String string4, String string5, String string6, String string7, boolean bl2, String string8, String string9, String string10, boolean bl3) {
        long l14 = n10;
        this(l12, l13, f10, string2, string3, l14, f11, f12, string4, string5, string6, string7, bl2, string8, string9, string10, bl3);
        this.id = l10;
        this.tempId = l11;
    }

    public TemplateSticker clone() {
        String string2;
        Object object = string2;
        long l10 = this.startTime;
        long l11 = this.endTime;
        float f10 = this.angle;
        String string3 = this.center;
        String string4 = this.type;
        long l12 = this.stickerTypeId;
        float f11 = this.scale;
        float f12 = this.textFontSize;
        String string5 = this.textFontName;
        String string6 = this.textColor;
        Object object2 = string2;
        string2 = this.textContent;
        TemplateSticker templateSticker = object;
        object2 = this.textCaptionName;
        boolean bl2 = this.textCaptionLocalSource;
        String string7 = this.imageName;
        String string8 = this.gifName;
        String string9 = this.thumbUrl;
        boolean bl3 = this.localSource;
        object = templateSticker;
        templateSticker(l10, l11, f10, string3, string4, l12, f11, f12, string5, string6, string2, (String)object2, bl2, string7, string8, string9, bl3);
        object = this.getCustomerUUID();
        templateSticker.setCustomerUUID((String)object);
        return templateSticker;
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
            int n10;
            long l10;
            float f10;
            float f11;
            long l11;
            long l12;
            long l13;
            Object object4 = super.equals(object);
            if (object4 == 0) {
                return false;
            }
            object = (TemplateSticker)object;
            long l14 = this.id;
            long l15 = ((TemplateSticker)object).id;
            long l16 = l14 - l15;
            object4 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
            if (object4 != 0 || (object4 = (l13 = (l14 = this.tempId) - (l15 = ((TemplateSticker)object).tempId)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) != 0 || (object4 = (l12 = (l14 = this.startTime) - (l15 = ((TemplateSticker)object).startTime)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != 0 || (object4 = (l11 = (l14 = this.endTime) - (l15 = ((TemplateSticker)object).endTime)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != 0 || (object4 = Float.compare(f11 = ((TemplateSticker)object).angle, f10 = this.angle)) != 0 || (object4 = (Object)((l10 = (l14 = this.stickerTypeId) - (l15 = ((TemplateSticker)object).stickerTypeId)) == 0L ? 0 : (l10 < 0L ? -1 : 1))) != 0 || (object4 = Float.compare(f11 = ((TemplateSticker)object).scale, f10 = this.scale)) != 0 || (object4 = Float.compare(f11 = ((TemplateSticker)object).textFontSize, f10 = this.textFontSize)) != 0 || (object4 = (Object)this.textCaptionLocalSource) != (n10 = ((TemplateSticker)object).textCaptionLocalSource) || (object4 = (Object)this.localSource) != (n10 = (int)(((TemplateSticker)object).localSource ? 1 : 0)) || (object4 = (Object)Objects.equals(object3 = this.center, object2 = ((TemplateSticker)object).center)) == 0 || (object4 = (Object)Objects.equals(object3 = this.type, object2 = ((TemplateSticker)object).type)) == 0 || (object4 = (Object)Objects.equals(object3 = this.textFontName, object2 = ((TemplateSticker)object).textFontName)) == 0 || (object4 = (Object)Objects.equals(object3 = this.textColor, object2 = ((TemplateSticker)object).textColor)) == 0 || (object4 = (Object)Objects.equals(object3 = this.textContent, object2 = ((TemplateSticker)object).textContent)) == 0 || (object4 = (Object)Objects.equals(object3 = this.textCaptionName, object2 = ((TemplateSticker)object).textCaptionName)) == 0 || (object4 = (Object)Objects.equals(object3 = this.imageName, object2 = ((TemplateSticker)object).imageName)) == 0 || (object4 = (Object)Objects.equals(object3 = this.gifName, object2 = ((TemplateSticker)object).gifName)) == 0 || !(bl3 = Objects.equals(object3 = this.thumbUrl, object = ((TemplateSticker)object).thumbUrl))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
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

    public String getGifName() {
        return this.gifName;
    }

    public long getId() {
        return this.id;
    }

    public String getImageName() {
        return this.imageName;
    }

    public String getName() {
        String string2 = this.getType();
        string2.hashCode();
        int n10 = string2.hashCode();
        int n11 = -1;
        switch (n10) {
            default: {
                break;
            }
            case 100313435: {
                String string3 = "image";
                boolean bl2 = string2.equals(string3);
                if (!bl2) break;
                n11 = 2;
                break;
            }
            case 3556653: {
                String string4 = "text";
                boolean bl3 = string2.equals(string4);
                if (!bl3) break;
                n11 = 1;
                break;
            }
            case 102340: {
                String string5 = "gif";
                boolean bl4 = string2.equals(string5);
                if (!bl4) break;
                n11 = 0;
            }
        }
        switch (n11) {
            default: {
                string2 = "";
                break;
            }
            case 2: {
                string2 = this.getImageName();
                break;
            }
            case 1: {
                string2 = this.getTextFontName();
                break;
            }
            case 0: {
                string2 = this.getGifName();
            }
        }
        return string2;
    }

    public float getScale() {
        return this.scale;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public long getStickerTypeId() {
        return this.stickerTypeId;
    }

    public long getTempId() {
        return this.tempId;
    }

    public String getTextCaptionName() {
        return this.textCaptionName;
    }

    public String getTextColor() {
        return this.textColor;
    }

    public String getTextContent() {
        return this.textContent;
    }

    public String getTextFontName() {
        return this.textFontName;
    }

    public float getTextFontSize() {
        return this.textFontSize;
    }

    public String getThumbUrl() {
        return this.thumbUrl;
    }

    public String getType() {
        return this.type;
    }

    public int hashCode() {
        Object object = super.hashCode();
        Object[] objectArray = new Object[]{object, object = Long.valueOf(this.id), object = Long.valueOf(this.tempId), object = Long.valueOf(this.startTime), object = Long.valueOf(this.endTime), object = Float.valueOf(this.angle), object = this.center, object = this.type, object = Long.valueOf(this.stickerTypeId), object = Float.valueOf(this.scale), object = Float.valueOf(this.textFontSize), object = this.textFontName, object = this.textColor, object = this.textContent, object = this.textCaptionName, object = Boolean.valueOf(this.textCaptionLocalSource), object = this.imageName, object = this.gifName, object = this.thumbUrl, object = Boolean.valueOf(this.localSource)};
        return Objects.hash(objectArray);
    }

    public boolean isLocalSource() {
        return this.localSource;
    }

    public boolean isTextCaptionLocalSource() {
        return this.textCaptionLocalSource;
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

    public void setGifName(String string2) {
        this.gifName = string2;
    }

    public void setId(long l10) {
        this.id = l10;
    }

    public void setImageName(String string2) {
        this.imageName = string2;
    }

    public void setLocalSource(boolean bl2) {
        this.localSource = bl2;
    }

    public void setScale(float f10) {
        this.scale = f10;
    }

    public void setStartTime(long l10) {
        this.startTime = l10;
    }

    public void setStickerTypeId(long l10) {
        this.stickerTypeId = l10;
    }

    public void setTempId(long l10) {
        this.tempId = l10;
    }

    public void setTextCaptionLocalSource(boolean bl2) {
        this.textCaptionLocalSource = bl2;
    }

    public void setTextCaptionName(String string2) {
        this.textCaptionName = string2;
    }

    public void setTextColor(String string2) {
        this.textColor = string2;
    }

    public void setTextContent(String string2) {
        this.textContent = string2;
    }

    public void setTextFontName(String string2) {
        this.textFontName = string2;
    }

    public void setTextFontSize(float f10) {
        this.textFontSize = f10;
    }

    public void setThumbUrl(String string2) {
        this.thumbUrl = string2;
    }

    public void setType(String string2) {
        this.type = string2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TemplateSticker{id=");
        long l10 = this.id;
        stringBuilder.append(l10);
        stringBuilder.append(", tempId=");
        l10 = this.tempId;
        stringBuilder.append(l10);
        stringBuilder.append(", startTime=");
        l10 = this.startTime;
        stringBuilder.append(l10);
        stringBuilder.append(", endTime=");
        l10 = this.endTime;
        stringBuilder.append(l10);
        stringBuilder.append(", angle=");
        float f10 = this.angle;
        stringBuilder.append(f10);
        stringBuilder.append(", center='");
        String string2 = this.center;
        stringBuilder.append(string2);
        char bl2 = '\'';
        stringBuilder.append(bl2);
        stringBuilder.append(", type='");
        String string3 = this.type;
        stringBuilder.append(string3);
        stringBuilder.append(bl2);
        stringBuilder.append(", stickerTypeId=");
        long l11 = this.stickerTypeId;
        stringBuilder.append(l11);
        stringBuilder.append(", scale=");
        float f11 = this.scale;
        stringBuilder.append(f11);
        stringBuilder.append(", text_font_size=");
        f11 = this.textFontSize;
        stringBuilder.append(f11);
        stringBuilder.append(", text_font_name='");
        string3 = this.textFontName;
        stringBuilder.append(string3);
        stringBuilder.append(bl2);
        stringBuilder.append(", text_text_color='");
        string3 = this.textColor;
        stringBuilder.append(string3);
        stringBuilder.append(bl2);
        stringBuilder.append(", text_text='");
        string3 = this.textContent;
        stringBuilder.append(string3);
        stringBuilder.append(bl2);
        stringBuilder.append(", text_caption_name='");
        string3 = this.textCaptionName;
        stringBuilder.append(string3);
        stringBuilder.append(bl2);
        stringBuilder.append(", isCaptionLocalSource=");
        boolean bl3 = this.textCaptionLocalSource;
        stringBuilder.append(bl3);
        stringBuilder.append(", image_name='");
        string3 = this.imageName;
        stringBuilder.append(string3);
        stringBuilder.append(bl2);
        stringBuilder.append(", gif_name='");
        string3 = this.gifName;
        stringBuilder.append(string3);
        stringBuilder.append(bl2);
        stringBuilder.append(", isLocalSource=");
        boolean bl4 = this.localSource;
        stringBuilder.append(bl4);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

