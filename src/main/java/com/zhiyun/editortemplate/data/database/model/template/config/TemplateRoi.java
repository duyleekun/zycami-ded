/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.model.template.config;

import java.util.Objects;

public class TemplateRoi {
    private long duration;
    private boolean enable;
    private String endCenter;
    private float endHeight;
    private float endWidth;
    private String startCenter;
    private float startHeight;
    private float startWidth;

    public TemplateRoi(boolean bl2, String string2, float f10, float f11, String string3, float f12, float f13, long l10) {
        this.enable = bl2;
        this.startCenter = string2;
        this.startWidth = f10;
        this.startHeight = f11;
        this.endCenter = string3;
        this.endWidth = f12;
        this.endHeight = f13;
        this.duration = l10;
    }

    public TemplateRoi clone() {
        boolean bl2 = this.enable;
        String string2 = this.startCenter;
        float f10 = this.startWidth;
        float f11 = this.startHeight;
        String string3 = this.endCenter;
        float f12 = this.endWidth;
        float f13 = this.endHeight;
        long l10 = this.duration;
        TemplateRoi templateRoi = new TemplateRoi(bl2, string2, f10, f11, string3, f12, f13, l10);
        return templateRoi;
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
            long l10;
            long l11;
            long l12;
            float f10;
            float f11;
            object = (TemplateRoi)object;
            int n10 = this.enable;
            int n11 = ((TemplateRoi)object).enable;
            if (n10 != n11 || (n10 = Float.compare(f11 = ((TemplateRoi)object).startWidth, f10 = this.startWidth)) != 0 || (n10 = Float.compare(f11 = ((TemplateRoi)object).startHeight, f10 = this.startHeight)) != 0 || (n10 = Float.compare(f11 = ((TemplateRoi)object).endWidth, f10 = this.endWidth)) != 0 || (n10 = Float.compare(f11 = ((TemplateRoi)object).endHeight, f10 = this.endHeight)) != 0 || (n10 = (int)((l12 = (l11 = this.duration) - (l10 = ((TemplateRoi)object).duration)) == 0L ? 0 : (l12 < 0L ? -1 : 1))) != 0 || (n10 = (int)(Objects.equals(object3 = this.startCenter, object2 = ((TemplateRoi)object).startCenter) ? 1 : 0)) == 0 || !(bl3 = Objects.equals(object3 = this.endCenter, object = ((TemplateRoi)object).endCenter))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public long getDuration() {
        return this.duration;
    }

    public String getEndCenter() {
        return this.endCenter;
    }

    public float getEndHeight() {
        return this.endHeight;
    }

    public float getEndWidth() {
        return this.endWidth;
    }

    public String getStartCenter() {
        return this.startCenter;
    }

    public float getStartHeight() {
        return this.startHeight;
    }

    public float getStartWidth() {
        return this.startWidth;
    }

    public int hashCode() {
        Object object = this.enable;
        Object[] objectArray = new Object[]{object, object = this.startCenter, object = Float.valueOf(this.startWidth), object = Float.valueOf(this.startHeight), object = this.endCenter, object = Float.valueOf(this.endWidth), object = Float.valueOf(this.endHeight), object = Long.valueOf(this.duration)};
        return Objects.hash(objectArray);
    }

    public boolean isEnable() {
        return this.enable;
    }

    public void setDuration(long l10) {
        this.duration = l10;
    }

    public void setEnable(boolean bl2) {
        this.enable = bl2;
    }

    public void setEndCenter(String string2) {
        this.endCenter = string2;
    }

    public void setEndHeight(float f10) {
        this.endHeight = f10;
    }

    public void setEndWidth(float f10) {
        this.endWidth = f10;
    }

    public void setStartCenter(String string2) {
        this.startCenter = string2;
    }

    public void setStartHeight(float f10) {
        this.startHeight = f10;
    }

    public void setStartWidth(float f10) {
        this.startWidth = f10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TemplateRoi{enable=");
        char c10 = this.enable;
        stringBuilder.append(c10 != 0);
        stringBuilder.append(", startCenter='");
        String string2 = this.startCenter;
        stringBuilder.append(string2);
        c10 = '\'';
        stringBuilder.append(c10);
        stringBuilder.append(", startWidth=");
        float f10 = this.startWidth;
        stringBuilder.append(f10);
        stringBuilder.append(", startHeight=");
        f10 = this.startHeight;
        stringBuilder.append(f10);
        stringBuilder.append(", endCenter='");
        String string3 = this.endCenter;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        stringBuilder.append(", endWidth=");
        float f11 = this.endWidth;
        stringBuilder.append(f11);
        stringBuilder.append(", endHeight=");
        f11 = this.endHeight;
        stringBuilder.append(f11);
        stringBuilder.append(", duration=");
        long l10 = this.duration;
        stringBuilder.append(l10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

