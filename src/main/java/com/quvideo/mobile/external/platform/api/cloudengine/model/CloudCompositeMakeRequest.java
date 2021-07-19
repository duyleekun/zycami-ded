/*
 * Decompiled with CFR 0.151.
 */
package com.quvideo.mobile.external.platform.api.cloudengine.model;

import java.util.List;

public class CloudCompositeMakeRequest {
    private String country;
    private List dataList;
    private long fileType;
    private boolean forceMake;
    private String lang;
    private int resolution;
    private long templateId;

    public void setCountry(String string2) {
        this.country = string2;
    }

    public void setDataList(List list) {
        this.dataList = list;
    }

    public void setFileType(long l10) {
        this.fileType = l10;
    }

    public void setForceMake(boolean bl2) {
        this.forceMake = bl2;
    }

    public void setLang(String string2) {
        this.lang = string2;
    }

    public void setResolution(int n10) {
        this.resolution = n10;
    }

    public void setTemplateId(long l10) {
        this.templateId = l10;
    }
}

