/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.api.entity.template;

public class Effect {
    private float contrast;
    private boolean enable;
    private float exposure;
    private float hue;
    private float saturation;
    private float sharpen;
    private float temperature;
    private float vignette;

    public Effect() {
    }

    public Effect(boolean bl2, float f10, float f11, float f12, float f13, float f14, float f15, float f16) {
        this.enable = bl2;
        this.saturation = f10;
        this.contrast = f11;
        this.temperature = f12;
        this.hue = f13;
        this.exposure = f14;
        this.vignette = f15;
        this.sharpen = f16;
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
        stringBuilder.append("Effect{enable=");
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

