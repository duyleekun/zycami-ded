/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.model.template.config;

import com.zhiyun.editortemplate.data.database.model.template.config.TemplateBaseData;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateEffect;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateFilter;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateRoi;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateRotate;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateRotateFrame;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateTransition;
import java.io.Serializable;
import java.util.Objects;

public class TemplateVideo
extends TemplateBaseData
implements Serializable {
    private String bezierRate;
    private long duration;
    private TemplateEffect effect;
    private long endTime;
    private TemplateFilter filter;
    private long id;
    private boolean isLocalSource;
    private boolean isReverse;
    private boolean mute;
    private float rate;
    private int rateType;
    private String reversePath;
    private TemplateRoi roi;
    private TemplateRotate rotate;
    private TemplateRotateFrame rotateFrame;
    private long startTime;
    private long tempId;
    private long timebase;
    private TemplateTransition transition;
    private String videoPath;
    private boolean voiceEnable;
    private float volume;

    public TemplateVideo() {
    }

    public TemplateVideo(long l10, long l11, long l12, long l13, boolean bl2, float f10, boolean bl3, float f11, int n10, String string2, TemplateFilter templateFilter, TemplateEffect templateEffect, TemplateRotate templateRotate, TemplateTransition templateTransition, TemplateRoi templateRoi, TemplateRotateFrame templateRotateFrame, String string3, boolean bl4, boolean bl5, String string4) {
        this.timebase = l10;
        this.startTime = l11;
        this.endTime = l12;
        this.duration = l13;
        this.mute = bl2;
        this.volume = f10;
        this.voiceEnable = bl3;
        this.rate = f11;
        this.rateType = n10;
        this.bezierRate = string2;
        this.filter = templateFilter;
        this.effect = templateEffect;
        this.rotate = templateRotate;
        this.transition = templateTransition;
        this.videoPath = string3;
        this.roi = templateRoi;
        this.rotateFrame = templateRotateFrame;
        this.isLocalSource = bl4;
        this.isReverse = bl5;
        this.reversePath = string4;
    }

    public TemplateVideo clone() {
        Object object;
        TemplateVideo templateVideo = this;
        long l10 = this.timebase;
        long l11 = this.startTime;
        long l12 = this.endTime;
        long l13 = this.duration;
        boolean bl2 = this.mute;
        float f10 = this.volume;
        boolean bl3 = this.voiceEnable;
        float f11 = this.rate;
        int n10 = this.rateType;
        Object object2 = this.bezierRate;
        Object object3 = this.filter;
        Object object4 = null;
        Object object5 = object3 == null ? null : (object3 = ((TemplateFilter)object3).clone());
        object3 = templateVideo.effect;
        Object object6 = object3 == null ? null : (object3 = ((TemplateEffect)object3).clone());
        object3 = templateVideo.rotate;
        Object object7 = object3 == null ? null : (object3 = ((TemplateRotate)object3).clone());
        object3 = templateVideo.transition;
        Object object8 = object3 == null ? null : (object3 = ((TemplateTransition)object3).clone());
        object3 = templateVideo.roi;
        Object object9 = object3 == null ? null : (object3 = ((TemplateRoi)object3).clone());
        object3 = templateVideo.rotateFrame;
        Object object10 = object3 == null ? null : (object3 = ((TemplateRotateFrame)object3).clone());
        String string2 = templateVideo.videoPath;
        boolean bl4 = templateVideo.isLocalSource;
        boolean bl5 = templateVideo.isReverse;
        String string3 = templateVideo.reversePath;
        object3 = object;
        templateVideo = object;
        object = object2;
        object2 = object5;
        object4 = object6;
        object5 = object7;
        object6 = object8;
        object7 = object9;
        object8 = object10;
        ((TemplateVideo)object3)(l10, l11, l12, l13, bl2, f10, bl3, f11, n10, (String)object, (TemplateFilter)object2, (TemplateEffect)object4, (TemplateRotate)object5, (TemplateTransition)object6, (TemplateRoi)object9, (TemplateRotateFrame)object10, string2, bl4, bl5, string3);
        object3 = this.getCustomerUUID();
        templateVideo.setCustomerUUID((String)object3);
        return templateVideo;
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
            long l13;
            long l14;
            Object object4 = super.equals(object);
            if (object4 == 0) {
                return false;
            }
            object = (TemplateVideo)object;
            long l15 = this.id;
            long l16 = ((TemplateVideo)object).id;
            long l17 = l15 - l16;
            object4 = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
            if (object4 != 0 || (object4 = (l14 = (l15 = this.tempId) - (l16 = ((TemplateVideo)object).tempId)) == 0L ? 0 : (l14 < 0L ? -1 : 1)) != 0 || (object4 = (l13 = (l15 = this.timebase) - (l16 = ((TemplateVideo)object).timebase)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) != 0 || (object4 = (l12 = (l15 = this.startTime) - (l16 = ((TemplateVideo)object).startTime)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != 0 || (object4 = (l11 = (l15 = this.endTime) - (l16 = ((TemplateVideo)object).endTime)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != 0 || (object4 = (l10 = (l15 = this.duration) - (l16 = ((TemplateVideo)object).duration)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != 0 || (object4 = this.mute) != (n10 = ((TemplateVideo)object).mute) || (object4 = Float.compare(f11 = ((TemplateVideo)object).volume, f10 = this.volume)) != 0 || (object4 = (Object)this.voiceEnable) != (n10 = ((TemplateVideo)object).voiceEnable) || (object4 = Float.compare(f11 = ((TemplateVideo)object).rate, f10 = this.rate)) != 0 || (object4 = this.rateType) != (n10 = ((TemplateVideo)object).rateType) || (object4 = (Object)this.isLocalSource) != (n10 = (int)(((TemplateVideo)object).isLocalSource ? 1 : 0)) || (object4 = (Object)this.isReverse) != (n10 = (int)(((TemplateVideo)object).isReverse ? 1 : 0)) || (object4 = (Object)Objects.equals(object3 = this.bezierRate, object2 = ((TemplateVideo)object).bezierRate)) == 0 || (object4 = (Object)Objects.equals(object3 = this.filter, object2 = ((TemplateVideo)object).filter)) == 0 || (object4 = (Object)Objects.equals(object3 = this.effect, object2 = ((TemplateVideo)object).effect)) == 0 || (object4 = (Object)Objects.equals(object3 = this.rotate, object2 = ((TemplateVideo)object).rotate)) == 0 || (object4 = (Object)Objects.equals(object3 = this.transition, object2 = ((TemplateVideo)object).transition)) == 0 || (object4 = (Object)Objects.equals(object3 = this.roi, object2 = ((TemplateVideo)object).roi)) == 0 || (object4 = (Object)Objects.equals(object3 = this.rotateFrame, object2 = ((TemplateVideo)object).rotateFrame)) == 0 || (object4 = (Object)Objects.equals(object3 = this.videoPath, object2 = ((TemplateVideo)object).videoPath)) == 0 || !(bl3 = Objects.equals(object3 = this.reversePath, object = ((TemplateVideo)object).reversePath))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public String getBezierRate() {
        String string2 = this.bezierRate;
        if (string2 == null) {
            string2 = "";
        }
        return string2;
    }

    public long getDuration() {
        return this.duration;
    }

    public TemplateEffect getEffect() {
        return this.effect;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public TemplateFilter getFilter() {
        return this.filter;
    }

    public long getId() {
        return this.id;
    }

    public float getRate() {
        return this.rate;
    }

    public int getRateType() {
        return this.rateType;
    }

    public String getReversePath() {
        return this.reversePath;
    }

    public TemplateRoi getRoi() {
        return this.roi;
    }

    public TemplateRotate getRotate() {
        return this.rotate;
    }

    public TemplateRotateFrame getRotateFrame() {
        return this.rotateFrame;
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

    public TemplateTransition getTransition() {
        return this.transition;
    }

    public String getVideoPath() {
        return this.videoPath;
    }

    public float getVolume() {
        return this.volume;
    }

    public int hashCode() {
        Object object = super.hashCode();
        Object[] objectArray = new Object[]{object, object = Long.valueOf(this.id), object = Long.valueOf(this.tempId), object = Long.valueOf(this.timebase), object = Long.valueOf(this.startTime), object = Long.valueOf(this.endTime), object = Long.valueOf(this.duration), object = Boolean.valueOf(this.mute), object = Float.valueOf(this.volume), object = Boolean.valueOf(this.voiceEnable), object = Float.valueOf(this.rate), object = Integer.valueOf(this.rateType), object = this.bezierRate, object = this.filter, object = this.effect, object = this.rotate, object = this.transition, object = this.roi, object = this.rotateFrame, object = this.videoPath, object = Boolean.valueOf(this.isLocalSource), object = Boolean.valueOf(this.isReverse), object = this.reversePath};
        return Objects.hash(objectArray);
    }

    public boolean isLocalSource() {
        return this.isLocalSource;
    }

    public boolean isMute() {
        return this.mute;
    }

    public boolean isReverse() {
        return this.isReverse;
    }

    public boolean isVoiceEnable() {
        return this.voiceEnable;
    }

    public void setBezierRate(String string2) {
        this.bezierRate = string2;
    }

    public void setDuration(long l10) {
        this.duration = l10;
    }

    public void setEffect(TemplateEffect templateEffect) {
        this.effect = templateEffect;
    }

    public void setEndTime(long l10) {
        this.endTime = l10;
    }

    public void setFilter(TemplateFilter templateFilter) {
        this.filter = templateFilter;
    }

    public void setId(long l10) {
        this.id = l10;
    }

    public void setLocalSource(boolean bl2) {
        this.isLocalSource = bl2;
    }

    public void setMute(boolean bl2) {
        this.mute = bl2;
    }

    public void setRate(float f10) {
        this.rate = f10;
    }

    public void setRateType(int n10) {
        this.rateType = n10;
    }

    public void setReverse(boolean bl2) {
        this.isReverse = bl2;
    }

    public void setReversePath(String string2) {
        this.reversePath = string2;
    }

    public void setRoi(TemplateRoi templateRoi) {
        this.roi = templateRoi;
    }

    public void setRotate(TemplateRotate templateRotate) {
        this.rotate = templateRotate;
    }

    public void setRotateFrame(TemplateRotateFrame templateRotateFrame) {
        this.rotateFrame = templateRotateFrame;
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

    public void setTransition(TemplateTransition templateTransition) {
        this.transition = templateTransition;
    }

    public void setVideoPath(String string2) {
        this.videoPath = string2;
    }

    public void setVoiceEnable(boolean bl2) {
        this.voiceEnable = bl2;
    }

    public void setVolume(float f10) {
        this.volume = f10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TemplateVideo{id=");
        long l10 = this.id;
        stringBuilder.append(l10);
        stringBuilder.append(", tempId=");
        l10 = this.tempId;
        stringBuilder.append(l10);
        stringBuilder.append(", timebase=");
        l10 = this.timebase;
        stringBuilder.append(l10);
        stringBuilder.append(", startTime=");
        l10 = this.startTime;
        stringBuilder.append(l10);
        stringBuilder.append(", endTime=");
        l10 = this.endTime;
        stringBuilder.append(l10);
        stringBuilder.append(", duration=");
        l10 = this.duration;
        stringBuilder.append(l10);
        stringBuilder.append(", mute=");
        boolean c10 = this.mute;
        stringBuilder.append(c10);
        stringBuilder.append(", volume=");
        float f10 = this.volume;
        stringBuilder.append(f10);
        stringBuilder.append(", voiceEnable=");
        boolean bl2 = this.voiceEnable;
        stringBuilder.append(bl2);
        stringBuilder.append(", rate=");
        f10 = this.rate;
        stringBuilder.append(f10);
        stringBuilder.append(", rateType=");
        int n10 = this.rateType;
        stringBuilder.append(n10);
        stringBuilder.append(", bezierRate='");
        String string2 = this.bezierRate;
        stringBuilder.append(string2);
        char c11 = '\'';
        stringBuilder.append(c11);
        stringBuilder.append(", filter=");
        Object object = this.filter;
        stringBuilder.append(object);
        stringBuilder.append(", effect=");
        object = this.effect;
        stringBuilder.append(object);
        stringBuilder.append(", rotate=");
        object = this.rotate;
        stringBuilder.append(object);
        stringBuilder.append(", transition=");
        object = this.transition;
        stringBuilder.append(object);
        stringBuilder.append(", roi=");
        object = this.roi;
        stringBuilder.append(object);
        stringBuilder.append(", rotateFrame=");
        object = this.rotateFrame;
        stringBuilder.append(object);
        stringBuilder.append(", videoPath='");
        object = this.videoPath;
        stringBuilder.append((String)object);
        stringBuilder.append(c11);
        stringBuilder.append(", isLocalSource=");
        boolean bl3 = this.isLocalSource;
        stringBuilder.append(bl3);
        stringBuilder.append(", isReverse=");
        bl3 = this.isReverse;
        stringBuilder.append(bl3);
        stringBuilder.append(", reversePath='");
        object = this.reversePath;
        stringBuilder.append((String)object);
        stringBuilder.append(c11);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

