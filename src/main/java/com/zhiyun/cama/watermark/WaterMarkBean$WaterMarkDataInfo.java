/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.watermark;

public class WaterMarkBean$WaterMarkDataInfo {
    private long id;
    private boolean isDefault;
    private String path;
    private String thumbnail;

    public WaterMarkBean$WaterMarkDataInfo(long l10, String string2) {
        this.id = l10;
        this.path = string2;
    }

    public long getId() {
        return this.id;
    }

    public String getPath() {
        return this.path;
    }

    public String getThumbnail() {
        return this.thumbnail;
    }

    public boolean isDefault() {
        return this.isDefault;
    }

    public void setDefault(boolean bl2) {
        this.isDefault = bl2;
    }

    public void setId(long l10) {
        this.id = l10;
    }

    public void setPath(String string2) {
        this.path = string2;
    }

    public void setThumbnail(String string2) {
        this.thumbnail = string2;
    }
}

