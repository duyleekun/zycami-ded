/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.model.template.config;

import java.util.Objects;

public class TemplateAudioTransition {
    private long endTime;
    private float endVolume;
    private long startTime;
    private float startVolume;

    public TemplateAudioTransition(long l10, long l11, float f10, float f11) {
        this.startTime = l10;
        this.endTime = l11;
        this.startVolume = f10;
        this.endVolume = f11;
    }

    public TemplateAudioTransition clone() {
        long l10 = this.startTime;
        long l11 = this.endTime;
        float f10 = this.startVolume;
        float f11 = this.endVolume;
        TemplateAudioTransition templateAudioTransition = new TemplateAudioTransition(l10, l11, f10, f11);
        return templateAudioTransition;
    }

    public boolean equals(Object object) {
        Class<?> clazz;
        Class<?> clazz2;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (clazz2 = this.getClass()) == (clazz = object.getClass())) {
            float f10;
            int n10;
            float f11;
            float f12;
            long l10;
            object = (TemplateAudioTransition)object;
            long l11 = this.startTime;
            long l12 = ((TemplateAudioTransition)object).startTime;
            long l13 = l11 - l12;
            Object object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object2 != false || (object2 = (l10 = (l11 = this.endTime) - (l12 = ((TemplateAudioTransition)object).endTime)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false || (object2 = (Object)Float.compare(f12 = ((TemplateAudioTransition)object).startVolume, f11 = this.startVolume)) != false || (n10 = Float.compare(f10 = ((TemplateAudioTransition)object).endVolume, f12 = this.endVolume)) != 0) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public float getEndVolume() {
        return this.endVolume;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public float getStartVolume() {
        return this.startVolume;
    }

    public int hashCode() {
        Object[] objectArray = new Object[4];
        Number number = this.startTime;
        objectArray[0] = number;
        number = this.endTime;
        objectArray[1] = number;
        number = Float.valueOf(this.startVolume);
        objectArray[2] = number;
        number = Float.valueOf(this.endVolume);
        objectArray[3] = number;
        return Objects.hash(objectArray);
    }

    public void setEndTime(long l10) {
        this.endTime = l10;
    }

    public void setEndVolume(float f10) {
        this.endVolume = f10;
    }

    public void setStartTime(long l10) {
        this.startTime = l10;
    }

    public void setStartVolume(float f10) {
        this.startVolume = f10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TemplateAudioTransition{startTime=");
        long l10 = this.startTime;
        stringBuilder.append(l10);
        stringBuilder.append(", endTime=");
        l10 = this.endTime;
        stringBuilder.append(l10);
        stringBuilder.append(", startVolume=");
        float f10 = this.startVolume;
        stringBuilder.append(f10);
        stringBuilder.append(", endVolume=");
        f10 = this.endVolume;
        stringBuilder.append(f10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

