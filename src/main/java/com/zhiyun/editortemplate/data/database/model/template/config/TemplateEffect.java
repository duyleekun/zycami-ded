/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.model.template.config;

import java.util.Objects;

public class TemplateEffect {
    private float contrast;
    private boolean enable;
    private float exposure;
    private float hue;
    private float saturation;
    private float sharpen;
    private float temperature;
    private float vignette;

    public TemplateEffect(boolean bl2, float f10, float f11, float f12, float f13, float f14, float f15, float f16) {
        this.enable = bl2;
        this.saturation = f10;
        this.contrast = f11;
        this.temperature = f12;
        this.hue = f13;
        this.exposure = f14;
        this.vignette = f15;
        this.sharpen = f16;
    }

    public TemplateEffect clone() {
        boolean bl2 = this.enable;
        float f10 = this.saturation;
        float f11 = this.contrast;
        float f12 = this.temperature;
        float f13 = this.hue;
        float f14 = this.exposure;
        float f15 = this.vignette;
        float f16 = this.sharpen;
        TemplateEffect templateEffect = new TemplateEffect(bl2, f10, f11, f12, f13, f14, f15, f16);
        return templateEffect;
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
            object = (TemplateEffect)object;
            int n11 = this.enable;
            int n12 = ((TemplateEffect)object).enable;
            if (n11 != n12 || (n11 = Float.compare(f12 = ((TemplateEffect)object).saturation, f11 = this.saturation)) != 0 || (n11 = Float.compare(f12 = ((TemplateEffect)object).contrast, f11 = this.contrast)) != 0 || (n11 = Float.compare(f12 = ((TemplateEffect)object).temperature, f11 = this.temperature)) != 0 || (n11 = Float.compare(f12 = ((TemplateEffect)object).hue, f11 = this.hue)) != 0 || (n11 = Float.compare(f12 = ((TemplateEffect)object).exposure, f11 = this.exposure)) != 0 || (n11 = Float.compare(f12 = ((TemplateEffect)object).vignette, f11 = this.vignette)) != 0 || (n10 = Float.compare(f10 = ((TemplateEffect)object).sharpen, f12 = this.sharpen)) != 0) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public float getContrast() {
        return this.contrast;
    }

    public float getExposure() {
        return this.exposure;
    }

    public float getHue() {
        return this.hue;
    }

    public float getSaturation() {
        return this.saturation;
    }

    public float getSharpen() {
        return this.sharpen;
    }

    public float getTemperature() {
        return this.temperature;
    }

    public float getVignette() {
        return this.vignette;
    }

    public int hashCode() {
        Object[] objectArray = new Object[8];
        Comparable<Boolean> comparable = this.enable;
        objectArray[0] = comparable;
        comparable = Float.valueOf(this.saturation);
        objectArray[1] = comparable;
        comparable = Float.valueOf(this.contrast);
        objectArray[2] = comparable;
        comparable = Float.valueOf(this.temperature);
        objectArray[3] = comparable;
        comparable = Float.valueOf(this.hue);
        objectArray[4] = comparable;
        comparable = Float.valueOf(this.exposure);
        objectArray[5] = comparable;
        comparable = Float.valueOf(this.vignette);
        objectArray[6] = comparable;
        comparable = Float.valueOf(this.sharpen);
        objectArray[7] = comparable;
        return Objects.hash(objectArray);
    }

    public boolean isEnable() {
        return this.enable;
    }

    public void setContrast(float f10) {
        this.contrast = f10;
    }

    public void setEnable(boolean bl2) {
        this.enable = bl2;
    }

    public void setExposure(float f10) {
        this.exposure = f10;
    }

    public void setHue(float f10) {
        this.hue = f10;
    }

    public void setSaturation(float f10) {
        this.saturation = f10;
    }

    public void setSharpen(float f10) {
        this.sharpen = f10;
    }

    public void setTemperature(float f10) {
        this.temperature = f10;
    }

    public void setVignette(float f10) {
        this.vignette = f10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TemplateEffect{enable=");
        boolean bl2 = this.enable;
        stringBuilder.append(bl2);
        stringBuilder.append(", saturation=");
        float f10 = this.saturation;
        stringBuilder.append(f10);
        stringBuilder.append(", contrast=");
        f10 = this.contrast;
        stringBuilder.append(f10);
        stringBuilder.append(", temperature=");
        f10 = this.temperature;
        stringBuilder.append(f10);
        stringBuilder.append(", hue=");
        f10 = this.hue;
        stringBuilder.append(f10);
        stringBuilder.append(", exposure=");
        f10 = this.exposure;
        stringBuilder.append(f10);
        stringBuilder.append(", vignette=");
        f10 = this.vignette;
        stringBuilder.append(f10);
        stringBuilder.append(", sharpen=");
        f10 = this.sharpen;
        stringBuilder.append(f10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

