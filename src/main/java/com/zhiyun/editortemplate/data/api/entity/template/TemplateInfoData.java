/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.api.entity.template;

import com.zhiyun.editortemplate.data.api.entity.template.Description;
import d.v.j.e.e.a;

public class TemplateInfoData
implements a {
    private String coverUrl;
    private Description description;
    private int download;
    private String editorName;
    private String editorNameJson;
    private long id;
    private int isPkg;
    private Long localId;
    private String name;
    private String name_en;
    private String name_zh_tw;
    private int requiredPrime;
    private int resSize;
    private String trackChainName;
    private String trackChainNameJson;
    private long typeId;
    private int videoCount;
    private String videoRatio;
    private double videoTime;
    private String videoUrl;

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public Description getDescription() {
        return this.description;
    }

    public int getDownload() {
        return this.download;
    }

    public String getEditorName() {
        return this.editorName;
    }

    public String getEditorNameJson() {
        return this.editorNameJson;
    }

    public long getId() {
        return this.id;
    }

    public int getIsPkg() {
        return this.isPkg;
    }

    public Long getLocalId() {
        return this.localId;
    }

    public String getName() {
        return this.name;
    }

    public String getName_en() {
        return this.name_en;
    }

    public String getName_zh_tw() {
        return this.name_zh_tw;
    }

    public long getRealTypeId() {
        long l10;
        Long l11 = this.getLocalId();
        if (l11 != null) {
            l11 = this.getLocalId();
            l10 = l11;
        } else {
            l10 = this.typeId;
        }
        return l10;
    }

    public int getRequiredPrime() {
        return this.requiredPrime;
    }

    public int getResSize() {
        return this.resSize;
    }

    public String getTrackChainName() {
        return this.trackChainName;
    }

    public String getTrackChainNameJson() {
        return this.trackChainNameJson;
    }

    public long getTypeId() {
        return this.typeId;
    }

    public int getVideoCount() {
        return this.videoCount;
    }

    public String getVideoRatio() {
        return this.videoRatio;
    }

    public double getVideoTime() {
        return this.videoTime;
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public void setCoverUrl(String string2) {
        this.coverUrl = string2;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public void setDownload(int n10) {
        this.download = n10;
    }

    public void setEditorName(String string2) {
        this.editorName = string2;
    }

    public void setEditorNameJson(String string2) {
        this.editorNameJson = string2;
    }

    public void setId(long l10) {
        this.id = l10;
    }

    public void setIsPkg(int n10) {
        this.isPkg = n10;
    }

    public void setLocalId(Long l10) {
        this.localId = l10;
    }

    public void setName(String string2) {
        this.name = string2;
    }

    public void setName_en(String string2) {
        this.name_en = string2;
    }

    public void setName_zh_tw(String string2) {
        this.name_zh_tw = string2;
    }

    public void setRequiredPrime(int n10) {
        this.requiredPrime = n10;
    }

    public void setResSize(int n10) {
        this.resSize = n10;
    }

    public void setTrackChainName(String string2) {
        this.trackChainName = string2;
    }

    public void setTrackChainNameJson(String string2) {
        this.trackChainNameJson = string2;
    }

    public void setTypeId(long l10) {
        this.typeId = l10;
    }

    public void setVideoCount(int n10) {
        this.videoCount = n10;
    }

    public void setVideoRatio(String string2) {
        this.videoRatio = string2;
    }

    public void setVideoTime(double d10) {
        this.videoTime = d10;
    }

    public void setVideoUrl(String string2) {
        this.videoUrl = string2;
    }
}

