/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.model.template.config;

import com.zhiyun.editortemplate.data.database.model.template.config.TemplateEffect;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateFilter;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateRoi;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateRotate;
import java.util.Objects;

public class TemplateGlobal {
    private int displayType;
    private long duration;
    private TemplateEffect effect;
    private TemplateFilter filter;
    private long id;
    private boolean mute;
    private String render;
    private TemplateRoi roi;
    private TemplateRotate rotate;
    private long tempId;
    private long timebase;
    private boolean voiceEnable;
    private float volume;

    public TemplateGlobal() {
    }

    public TemplateGlobal(long l10, long l11, String string2, int n10, float f10, boolean bl2, boolean bl3, TemplateFilter templateFilter, TemplateEffect templateEffect, TemplateRotate templateRotate, TemplateRoi templateRoi) {
        this.duration = l10;
        this.timebase = l11;
        this.render = string2;
        this.displayType = n10;
        this.volume = f10;
        this.mute = bl2;
        this.voiceEnable = bl3;
        this.filter = templateFilter;
        this.effect = templateEffect;
        this.rotate = templateRotate;
        this.roi = templateRoi;
    }

    public TemplateGlobal clone() {
        TemplateGlobal templateGlobal;
        TemplateGlobal templateGlobal2 = this;
        long l10 = this.duration;
        long l11 = this.timebase;
        String string2 = this.render;
        int n10 = this.displayType;
        float f10 = this.volume;
        boolean bl2 = this.mute;
        boolean bl3 = this.voiceEnable;
        Object object = this.filter;
        TemplateFilter templateFilter = null;
        Object object2 = object == null ? null : (object = ((TemplateFilter)object).clone());
        object = templateGlobal2.effect;
        Object object3 = object == null ? null : (object = ((TemplateEffect)object).clone());
        object = templateGlobal2.rotate;
        Object object4 = object == null ? null : (object = ((TemplateRotate)object).clone());
        object = templateGlobal2.roi;
        Object object5 = object == null ? null : (object = ((TemplateRoi)object).clone());
        object = templateGlobal;
        templateFilter = object2;
        object2 = object3;
        object3 = object4;
        object4 = object5;
        templateGlobal = new TemplateGlobal(l10, l11, string2, n10, f10, bl2, bl3, templateFilter, (TemplateEffect)object2, (TemplateRotate)object3, (TemplateRoi)object5);
        return templateGlobal;
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
            float f10;
            float f11;
            int n10;
            long l10;
            long l11;
            long l12;
            object = (TemplateGlobal)object;
            long l13 = this.id;
            long l14 = ((TemplateGlobal)object).id;
            long l15 = l13 - l14;
            Object object4 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
            if (object4 != false || (object4 = (l12 = (l13 = this.tempId) - (l14 = ((TemplateGlobal)object).tempId)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != false || (object4 = (l11 = (l13 = this.duration) - (l14 = ((TemplateGlobal)object).duration)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != false || (object4 = (l10 = (l13 = this.timebase) - (l14 = ((TemplateGlobal)object).timebase)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false || (object4 = (Object)this.displayType) != (n10 = ((TemplateGlobal)object).displayType) || (object4 = (Object)Float.compare(f11 = ((TemplateGlobal)object).volume, f10 = this.volume)) != false || (object4 = (Object)this.mute) != (n10 = (int)(((TemplateGlobal)object).mute ? 1 : 0)) || (object4 = (Object)this.voiceEnable) != (n10 = (int)(((TemplateGlobal)object).voiceEnable ? 1 : 0)) || (object4 = (Object)Objects.equals(object3 = this.render, object2 = ((TemplateGlobal)object).render)) == false || (object4 = (Object)Objects.equals(object3 = this.filter, object2 = ((TemplateGlobal)object).filter)) == false || (object4 = (Object)Objects.equals(object3 = this.effect, object2 = ((TemplateGlobal)object).effect)) == false || (object4 = (Object)Objects.equals(object3 = this.rotate, object2 = ((TemplateGlobal)object).rotate)) == false || !(bl3 = Objects.equals(object3 = this.roi, object = ((TemplateGlobal)object).roi))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int getDisplayType() {
        return this.displayType;
    }

    public long getDuration() {
        return this.duration;
    }

    public TemplateEffect getEffect() {
        return this.effect;
    }

    public TemplateFilter getFilter() {
        return this.filter;
    }

    public long getId() {
        return this.id;
    }

    public String getRender() {
        return this.render;
    }

    public TemplateRoi getRoi() {
        return this.roi;
    }

    public TemplateRotate getRotate() {
        return this.rotate;
    }

    public long getTempId() {
        return this.tempId;
    }

    public long getTimebase() {
        return this.timebase;
    }

    public float getVolume() {
        return this.volume;
    }

    public int hashCode() {
        Object object = this.id;
        Object[] objectArray = new Object[]{object, object = Long.valueOf(this.tempId), object = Long.valueOf(this.duration), object = Long.valueOf(this.timebase), object = this.render, object = Integer.valueOf(this.displayType), object = Float.valueOf(this.volume), object = Boolean.valueOf(this.mute), object = Boolean.valueOf(this.voiceEnable), object = this.filter, object = this.effect, object = this.rotate, object = this.roi};
        return Objects.hash(objectArray);
    }

    public boolean isMute() {
        return this.mute;
    }

    public boolean isVoiceEnable() {
        return this.voiceEnable;
    }

    public void setDisplayType(int n10) {
        this.displayType = n10;
    }

    public void setDuration(long l10) {
        this.duration = l10;
    }

    public void setEffect(TemplateEffect templateEffect) {
        this.effect = templateEffect;
    }

    public void setFilter(TemplateFilter templateFilter) {
        this.filter = templateFilter;
    }

    public void setId(long l10) {
        this.id = l10;
    }

    public void setMute(boolean bl2) {
        this.mute = bl2;
    }

    public void setRender(String string2) {
        this.render = string2;
    }

    public void setRoi(TemplateRoi templateRoi) {
        this.roi = templateRoi;
    }

    public void setRotate(TemplateRotate templateRotate) {
        this.rotate = templateRotate;
    }

    public void setTempId(long l10) {
        this.tempId = l10;
    }

    public void setTimebase(long l10) {
        this.timebase = l10;
    }

    public void setVoiceEnable(boolean bl2) {
        this.voiceEnable = bl2;
    }

    public void setVolume(float f10) {
        this.volume = f10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TemplateGlobal{id=");
        long l10 = this.id;
        stringBuilder.append(l10);
        stringBuilder.append(", tempId=");
        l10 = this.tempId;
        stringBuilder.append(l10);
        stringBuilder.append(", duration=");
        l10 = this.duration;
        stringBuilder.append(l10);
        stringBuilder.append(", timebase=");
        l10 = this.timebase;
        stringBuilder.append(l10);
        stringBuilder.append(", render='");
        Object object = this.render;
        stringBuilder.append((String)object);
        stringBuilder.append('\'');
        stringBuilder.append(", displayType=");
        int bl2 = this.displayType;
        stringBuilder.append(bl2);
        stringBuilder.append(", volume=");
        float f10 = this.volume;
        stringBuilder.append(f10);
        stringBuilder.append(", mute=");
        boolean bl3 = this.mute;
        stringBuilder.append(bl3);
        stringBuilder.append(", voiceEnable=");
        boolean bl4 = this.voiceEnable;
        stringBuilder.append(bl4);
        stringBuilder.append(", filter=");
        object = this.filter;
        stringBuilder.append(object);
        stringBuilder.append(", effect=");
        object = this.effect;
        stringBuilder.append(object);
        stringBuilder.append(", rotate=");
        object = this.rotate;
        stringBuilder.append(object);
        stringBuilder.append(", roi=");
        object = this.roi;
        stringBuilder.append(object);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

