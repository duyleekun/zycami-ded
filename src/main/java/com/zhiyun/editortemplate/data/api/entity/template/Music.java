/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.api.entity.template;

import com.zhiyun.editortemplate.data.api.entity.template.FileDataBaseBean;
import com.zhiyun.editortemplate.data.api.entity.template.Music$MusicTransition;

public class Music
extends FileDataBaseBean {
    private long attachTime;
    private long endTime;
    private Music$MusicTransition fadeIn;
    private Music$MusicTransition fadeOut;
    private boolean mute;
    private long startTime;
    private long timebase;
    private float volume;

    public long getAttachTime() {
        return this.attachTime;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public Music$MusicTransition getFadeIn() {
        return this.fadeIn;
    }

    public Music$MusicTransition getFadeOut() {
        return this.fadeOut;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public long getTimebase() {
        return this.timebase;
    }

    public float getVolume() {
        return this.volume;
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

    public void setFadeIn(Music$MusicTransition music$MusicTransition) {
        this.fadeIn = music$MusicTransition;
    }

    public void setFadeOut(Music$MusicTransition music$MusicTransition) {
        this.fadeOut = music$MusicTransition;
    }

    public void setMute(boolean bl2) {
        this.mute = bl2;
    }

    public void setStartTime(long l10) {
        this.startTime = l10;
    }

    public void setTimebase(long l10) {
        this.timebase = l10;
    }

    public void setVolume(float f10) {
        this.volume = f10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Music{startTime=");
        long l10 = this.startTime;
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
        stringBuilder.append(", attachTime=");
        l10 = this.attachTime;
        stringBuilder.append(l10);
        stringBuilder.append(", name='");
        Object object = this.name;
        stringBuilder.append((String)object);
        stringBuilder.append('\'');
        stringBuilder.append(", isLocalSource=");
        bl2 = this.isLocalSource;
        stringBuilder.append(bl2);
        stringBuilder.append(", file=");
        object = this.file;
        stringBuilder.append(object);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

