/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.api.entity.sticker;

public class AssetsStickerListBean$AssetsStickerBean {
    private int id;
    private String littleThumb;
    private String name;
    private float scale;
    private int sort;
    private String thumb;
    private long typeId;
    private String url;

    public int getId() {
        return this.id;
    }

    public String getLittleThumb() {
        return this.littleThumb;
    }

    public String getName() {
        return this.name;
    }

    public float getScale() {
        return this.scale;
    }

    public int getSort() {
        return this.sort;
    }

    public String getThumb() {
        return this.thumb;
    }

    public long getTypeId() {
        return this.typeId;
    }

    public String getUrl() {
        return this.url;
    }

    public AssetsStickerListBean$AssetsStickerBean setId(int n10) {
        this.id = n10;
        return this;
    }

    public AssetsStickerListBean$AssetsStickerBean setLittleThumb(String string2) {
        this.littleThumb = string2;
        return this;
    }

    public void setName(String string2) {
        this.name = string2;
    }

    public void setScale(float f10) {
        this.scale = f10;
    }

    public AssetsStickerListBean$AssetsStickerBean setSort(int n10) {
        this.sort = n10;
        return this;
    }

    public void setThumb(String string2) {
        this.thumb = string2;
    }

    public void setTypeId(long l10) {
        this.typeId = l10;
    }

    public void setUrl(String string2) {
        this.url = string2;
    }
}

