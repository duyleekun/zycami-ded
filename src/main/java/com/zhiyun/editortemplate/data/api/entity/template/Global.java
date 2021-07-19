/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.api.entity.template;

import com.zhiyun.editortemplate.data.api.entity.template.Effect;
import com.zhiyun.editortemplate.data.api.entity.template.Filter;
import com.zhiyun.editortemplate.data.api.entity.template.Music;
import com.zhiyun.editortemplate.data.api.entity.template.Render;
import com.zhiyun.editortemplate.data.api.entity.template.Roi;
import com.zhiyun.editortemplate.data.api.entity.template.Rotate;
import java.util.List;

public class Global {
    private long duration;
    private Effect effect;
    private Filter filter;
    private Music music;
    private List musics;
    private boolean mute;
    private Render render;
    private Roi roi;
    private Rotate rotate;
    private List stickers;
    private long timebase;
    private float volume;

    public long getDuration() {
        return this.duration;
    }

    public Effect getEffect() {
        return this.effect;
    }

    public Filter getFilter() {
        return this.filter;
    }

    public Music getMusic() {
        return this.music;
    }

    public List getMusics() {
        return this.musics;
    }

    public Render getRender() {
        return this.render;
    }

    public Roi getRoi() {
        return this.roi;
    }

    public Rotate getRotate() {
        return this.rotate;
    }

    public List getStickers() {
        return this.stickers;
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

    public void setDuration(long l10) {
        this.duration = l10;
    }

    public void setEffect(Effect effect) {
        this.effect = effect;
    }

    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    public void setMusic(Music music) {
        this.music = music;
    }

    public void setMusics(List list) {
        this.musics = list;
    }

    public void setMute(boolean bl2) {
        this.mute = bl2;
    }

    public void setRender(Render render) {
        this.render = render;
    }

    public void setRoi(Roi roi) {
        this.roi = roi;
    }

    public void setRotate(Rotate rotate) {
        this.rotate = rotate;
    }

    public void setStickers(List list) {
        this.stickers = list;
    }

    public void setTimebase(long l10) {
        this.timebase = l10;
    }

    public void setVolume(float f10) {
        this.volume = f10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Global{duration=");
        long l10 = this.duration;
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
        stringBuilder.append(", filter=");
        Object object = this.filter;
        stringBuilder.append(object);
        stringBuilder.append(", rotate=");
        object = this.rotate;
        stringBuilder.append(object);
        stringBuilder.append(", render=");
        object = this.render;
        stringBuilder.append(object);
        stringBuilder.append(", effect=");
        object = this.effect;
        stringBuilder.append(object);
        stringBuilder.append(", music=");
        object = this.music;
        stringBuilder.append(object);
        stringBuilder.append(", musics=");
        object = this.musics;
        stringBuilder.append(object);
        stringBuilder.append(", stickers=");
        object = this.stickers;
        stringBuilder.append(object);
        stringBuilder.append(", roi=");
        object = this.roi;
        stringBuilder.append(object);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

