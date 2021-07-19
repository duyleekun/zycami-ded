/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.model.template.config;

import com.zhiyun.editortemplate.data.database.model.template.config.TemplateAudioTransition;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateBaseData;
import java.util.Objects;

public class TemplateAudioData
extends TemplateBaseData {
    private long attachTime;
    private long endTime;
    private TemplateAudioTransition fadeIn;
    private TemplateAudioTransition fadeout;
    private long id;
    private boolean localSource;
    private boolean mute;
    private String name;
    private long startTime;
    private long tempId;
    private long timebase;
    private String title;
    private float volume;

    public TemplateAudioData() {
    }

    public TemplateAudioData(long l10, long l11, String string2, String string3, long l12, long l13, long l14, long l15, float f10, boolean bl2, boolean bl3, TemplateAudioTransition templateAudioTransition, TemplateAudioTransition templateAudioTransition2) {
        this(string2, string3, l12, l13, l14, l15, f10, bl2, bl3, templateAudioTransition, templateAudioTransition2);
        this.id = l10;
        this.tempId = l11;
    }

    public TemplateAudioData(String string2, String string3, long l10, long l11, long l12, long l13, float f10, boolean bl2, boolean bl3, TemplateAudioTransition templateAudioTransition, TemplateAudioTransition templateAudioTransition2) {
        this.name = string2;
        this.title = string3;
        this.attachTime = l10;
        this.startTime = l11;
        this.endTime = l12;
        this.timebase = l13;
        this.volume = f10;
        this.mute = bl2;
        this.localSource = bl3;
        this.fadeIn = templateAudioTransition;
        this.fadeout = templateAudioTransition2;
    }

    public TemplateAudioData clone() {
        TemplateAudioTransition templateAudioTransition;
        TemplateAudioTransition templateAudioTransition2;
        TemplateAudioData templateAudioData = this;
        String string2 = this.name;
        String string3 = this.title;
        long l10 = this.attachTime;
        long l11 = this.startTime;
        long l12 = this.endTime;
        long l13 = this.timebase;
        float f10 = this.volume;
        boolean bl2 = this.mute;
        boolean bl3 = this.localSource;
        Object object = this.fadeIn;
        Object object2 = null;
        if (object == null) {
            templateAudioTransition2 = null;
        } else {
            object = ((TemplateAudioTransition)object).clone();
            templateAudioTransition2 = object;
        }
        object = templateAudioData.fadeout;
        if (object != null) {
            object2 = object = ((TemplateAudioTransition)object).clone();
        }
        object = templateAudioTransition;
        templateAudioData = templateAudioTransition;
        templateAudioTransition = templateAudioTransition2;
        ((TemplateAudioData)object)(string2, string3, l10, l11, l12, l13, f10, bl2, bl3, templateAudioTransition2, (TemplateAudioTransition)object2);
        object = this.getCustomerUUID();
        templateAudioData.setCustomerUUID((String)object);
        return templateAudioData;
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
            float f10;
            float f11;
            long l10;
            long l11;
            long l12;
            long l13;
            long l14;
            Object object4 = super.equals(object);
            if (object4 == 0) {
                return false;
            }
            object = (TemplateAudioData)object;
            long l15 = this.id;
            long l16 = ((TemplateAudioData)object).id;
            long l17 = l15 - l16;
            object4 = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
            if (object4 != 0 || (object4 = (l14 = (l15 = this.tempId) - (l16 = ((TemplateAudioData)object).tempId)) == 0L ? 0 : (l14 < 0L ? -1 : 1)) != 0 || (object4 = (l13 = (l15 = this.attachTime) - (l16 = ((TemplateAudioData)object).attachTime)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) != 0 || (object4 = (l12 = (l15 = this.startTime) - (l16 = ((TemplateAudioData)object).startTime)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != 0 || (object4 = (l11 = (l15 = this.endTime) - (l16 = ((TemplateAudioData)object).endTime)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != 0 || (object4 = (l10 = (l15 = this.timebase) - (l16 = ((TemplateAudioData)object).timebase)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != 0 || (object4 = Float.compare(f11 = ((TemplateAudioData)object).volume, f10 = this.volume)) != 0 || (object4 = (Object)this.mute) != (n10 = ((TemplateAudioData)object).mute) || (object4 = (Object)this.localSource) != (n10 = (int)(((TemplateAudioData)object).localSource ? 1 : 0)) || (object4 = (Object)Objects.equals(object3 = this.name, object2 = ((TemplateAudioData)object).name)) == 0 || (object4 = (Object)Objects.equals(object3 = this.title, object2 = ((TemplateAudioData)object).title)) == 0 || (object4 = (Object)Objects.equals(object3 = this.fadeIn, object2 = ((TemplateAudioData)object).fadeIn)) == 0 || !(bl3 = Objects.equals(object3 = this.fadeout, object = ((TemplateAudioData)object).fadeout))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public long getAttachTime() {
        return this.attachTime;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public TemplateAudioTransition getFadeIn() {
        return this.fadeIn;
    }

    public TemplateAudioTransition getFadeout() {
        return this.fadeout;
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public long getTempId() {
        return this.tempId;
    }

    public long getTimebase() {
        return this.timebase;
    }

    public String getTitle() {
        return this.title;
    }

    public float getVolume() {
        return this.volume;
    }

    public int hashCode() {
        Object object = super.hashCode();
        Object[] objectArray = new Object[]{object, object = Long.valueOf(this.id), object = Long.valueOf(this.tempId), object = this.name, object = this.title, object = Long.valueOf(this.attachTime), object = Long.valueOf(this.startTime), object = Long.valueOf(this.endTime), object = Long.valueOf(this.timebase), object = Float.valueOf(this.volume), object = Boolean.valueOf(this.mute), object = Boolean.valueOf(this.localSource), object = this.fadeIn, object = this.fadeout};
        return Objects.hash(objectArray);
    }

    public boolean isLocalSource() {
        return this.localSource;
    }

    public boolean isMute() {
        return this.mute;
    }

    public void setAttachTime(long l10) {
        this.attachTime = l10;
    }

    public void setEndTime(long l10) {
        this.endTime = l10;
    }

    public void setFadeIn(TemplateAudioTransition templateAudioTransition) {
        this.fadeIn = templateAudioTransition;
    }

    public void setFadeout(TemplateAudioTransition templateAudioTransition) {
        this.fadeout = templateAudioTransition;
    }

    public void setId(long l10) {
        this.id = l10;
    }

    public void setLocalSource(boolean bl2) {
        this.localSource = bl2;
    }

    public void setMute(boolean bl2) {
        this.mute = bl2;
    }

    public void setName(String string2) {
        this.name = string2;
    }

    public void setStartTime(long l10) {
        this.startTime = l10;
    }

    public void setTempId(long l10) {
        this.tempId = l10;
    }

    public void setTimebase(long l10) {
        this.timebase = l10;
    }

    public void setTitle(String string2) {
        this.title = string2;
    }

    public void setVolume(float f10) {
        this.volume = f10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TemplateAudioData{id=");
        long l10 = this.id;
        stringBuilder.append(l10);
        stringBuilder.append(", tempId=");
        l10 = this.tempId;
        stringBuilder.append(l10);
        stringBuilder.append(", name='");
        String string2 = this.name;
        stringBuilder.append(string2);
        stringBuilder.append('\'');
        stringBuilder.append(", title=");
        string2 = this.title;
        stringBuilder.append(string2);
        stringBuilder.append(", attachTime=");
        l10 = this.attachTime;
        stringBuilder.append(l10);
        stringBuilder.append(", startTime=");
        l10 = this.startTime;
        stringBuilder.append(l10);
        stringBuilder.append(", endTime=");
        l10 = this.endTime;
        stringBuilder.append(l10);
        stringBuilder.append(", timebase=");
        l10 = this.timebase;
        stringBuilder.append(l10);
        stringBuilder.append(", volume=");
        float f10 = this.volume;
        stringBuilder.append(f10);
        stringBuilder.append(", mute=");
        boolean bl2 = this.mute;
        stringBuilder.append(bl2);
        stringBuilder.append(", isLocalSource=");
        bl2 = this.localSource;
        stringBuilder.append(bl2);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

