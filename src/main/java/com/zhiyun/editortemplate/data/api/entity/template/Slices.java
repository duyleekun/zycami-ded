/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.api.entity.template;

import com.zhiyun.editortemplate.data.api.entity.template.Effect;
import com.zhiyun.editortemplate.data.api.entity.template.Filter;
import com.zhiyun.editortemplate.data.api.entity.template.Roi;
import com.zhiyun.editortemplate.data.api.entity.template.Rotate;
import com.zhiyun.editortemplate.data.api.entity.template.RotateFrame;
import com.zhiyun.editortemplate.data.api.entity.template.Slices$SliceRes;
import com.zhiyun.editortemplate.data.api.entity.template.Transition;

public class Slices {
    private String bezierRate;
    private long duration;
    private Effect effect;
    private long endTime;
    private Filter filter;
    private boolean mute;
    private float rate;
    private int rateType;
    private Roi roi;
    private Rotate rotate;
    private RotateFrame rotateFrame;
    private SliceRes sliceRes;
    private long startTime;
    private long timebase;
    private Transition transition;
    private float volume;

    public Slices(long l10, long l11, long l12, long l13, boolean bl2, float f10, float f11, int n10, String string2) {
        this.timebase = l10;
        this.startTime = l11;
        this.endTime = l12;
        this.duration = l13;
        this.mute = bl2;
        this.volume = f10;
        this.rate = f11;
        this.rateType = n10;
        this.bezierRate = string2;
    }

    public Slices(long l10, long l11, long l12, long l13, boolean bl2, float f10, float f11, int n10, String string2, Rotate rotate, Filter filter, Effect effect, Transition transition, RotateFrame rotateFrame, Roi roi, SliceRes sliceRes) {
        this(l10, l11, l12, l13, bl2, f10, f11, n10, string2);
        this.rotate = rotate;
        this.filter = filter;
        this.effect = effect;
        this.transition = transition;
        this.rotateFrame = rotateFrame;
        this.roi = roi;
        this.sliceRes = sliceRes;
    }

    public String getBezierRate() {
        return this.bezierRate;
    }

    public long getDuration() {
        return this.duration;
    }

    public Effect getEffect() {
        return this.effect;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public Filter getFilter() {
        return this.filter;
    }

    public float getRate() {
        return this.rate;
    }

    public int getRateType() {
        return this.rateType;
    }

    public Roi getRoi() {
        return this.roi;
    }

    public Rotate getRotate() {
        return this.rotate;
    }

    public RotateFrame getRotateFrame() {
        return this.rotateFrame;
    }

    public SliceRes getSliceRes() {
        return this.sliceRes;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public long getTimebase() {
        return this.timebase;
    }

    public Transition getTransition() {
        return this.transition;
    }

    public float getVolume() {
        return this.volume;
    }

    public boolean isMute() {
        return this.mute;
    }

    public void setBezierRate(String string2) {
        this.bezierRate = string2;
    }

    public void setDuration(long l10) {
        this.duration = l10;
    }

    public void setEffect(Effect effect) {
        this.effect = effect;
    }

    public void setEndTime(long l10) {
        this.endTime = l10;
    }

    public void setFilter(Filter filter) {
        this.filter = filter;
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

    public void setRoi(Roi roi) {
        this.roi = roi;
    }

    public void setRotate(Rotate rotate) {
        this.rotate = rotate;
    }

    public void setRotateFrame(RotateFrame rotateFrame) {
        this.rotateFrame = rotateFrame;
    }

    public void setSliceRes(SliceRes sliceRes) {
        this.sliceRes = sliceRes;
    }

    public void setStartTime(long l10) {
        this.startTime = l10;
    }

    public void setTimebase(long l10) {
        this.timebase = l10;
    }

    public void setTransition(Transition transition) {
        this.transition = transition;
    }

    public void setVolume(float f10) {
        this.volume = f10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Slices{timebase=");
        long l10 = this.timebase;
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
        boolean bl2 = this.mute;
        stringBuilder.append(bl2);
        stringBuilder.append(", volume=");
        float f10 = this.volume;
        stringBuilder.append(f10);
        stringBuilder.append(", rate=");
        f10 = this.rate;
        stringBuilder.append(f10);
        stringBuilder.append(", rotate=");
        Object object = this.rotate;
        stringBuilder.append(object);
        stringBuilder.append(", filter=");
        object = this.filter;
        stringBuilder.append(object);
        stringBuilder.append(", effect=");
        object = this.effect;
        stringBuilder.append(object);
        stringBuilder.append(", transition=");
        object = this.transition;
        stringBuilder.append(object);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

